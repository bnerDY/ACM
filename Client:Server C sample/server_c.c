/* 
** CSSE2310/CSSE7231 - Sample Server - to be commented in class 
** Accept connections on a given port number and turn text received into
** upper case.
*/
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
#include <netdb.h>

#define MAXHOSTNAMELEN 128

int open_listen(int port)
{
    int fd;
    struct sockaddr_in serverAddr;
    int optVal;

    /*  Create TCP socket */
    fd = socket(AF_INET, SOCK_STREAM, 0);
    if(fd < 0) {
        perror("Error creating socket");
        exit(1);
    }

    /* Set the option to reuse the socket address immediately */
    optVal = 1;
    if(setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &optVal, sizeof(int)) < 0) {
        perror("Error setting socket option");
        exit(1);
    }

    /* Set up the address structure for the server side of the connection
     * - any local IP address is OK (INADDR_ANY) 
     * - given port number - convert to network byte order
     */
    serverAddr.sin_family = AF_INET;    
    serverAddr.sin_port = htons(port);
    serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);

    /* Bind our socket to the given address (IP address and port number) */
    if(bind(fd, (struct sockaddr*)&serverAddr, sizeof(struct sockaddr_in)) < 0) {
        perror("Error binding socket to port");
        exit(1);
    }

    /* Start listening for incoming connection requests - queue up to SOMAXCONN
     * of them
     */
    if(listen(fd, SOMAXCONN) < 0) {
        perror("Error listening");
        exit(1);
    }

    return fd;
}

char* capitalise(char* buffer, int len)
{
    int i;

    for(i=0; i<len; i++) {
        buffer[i] = (char)toupper((int)buffer[i]);
    }
    return buffer;
}

void process_connections(int fdServer)
{
    int fd;
    struct sockaddr_in fromAddr;
    socklen_t fromAddrSize;
    int error;
    char hostname[MAXHOSTNAMELEN];
    char buffer[1024];
    ssize_t numBytesRead;

    while(1) {
        fromAddrSize = sizeof(struct sockaddr_in);
	/* Block, waiting for a connection request to come in and accept it.
	 * fromAddr structure will get populated with the address of the client
	 */
        fd = accept(fdServer, (struct sockaddr*)&fromAddr,  &fromAddrSize);
        if(fd < 0) {
            perror("Error accepting connection");
            exit(1);
        }
     
	/* Lookup hostname of client and print it out (along with port num) */
        error = getnameinfo((struct sockaddr*)&fromAddr, fromAddrSize, hostname,
                MAXHOSTNAMELEN, NULL, 0, 0);
        if(error) {
            fprintf(stderr, "Error getting hostname: %s\n", 
                    gai_strerror(error));
        } else {
            printf("Accepted connection from %s (%s), port %d\n", 
                    inet_ntoa(fromAddr.sin_addr), hostname,
                    ntohs(fromAddr.sin_port));
        }

	/* Repeatedly read bytes from connected fd until EOF or error.
	 * Convert those characters to upper case and return them over
	 * the connection.
	 */
        while((numBytesRead = read(fd, buffer, 1024)) > 0) {
            capitalise(buffer, numBytesRead);
            write(fd, buffer, numBytesRead);
        }

	/* EOF or error on our connection */
        if(numBytesRead < 0) {
            perror("Error reading from socket");
            exit(1);
        }
	/* Print message to server's stdout */
        printf("Done\n");
        fflush(stdout);
        close(fd);
    }
}

int main(int argc, char* argv[])
{
    int portnum;
    int fdServer;

    if(argc != 2) {
        fprintf(stderr, "Usage: %s port-num\n", argv[0]);
        exit(1);
    }

    /* Get the port number from the arguments and check range */
    portnum = atoi(argv[1]);
    if(portnum < 1024 || portnum > 65535) {
        fprintf(stderr,  "Invalid port number: %s\n", argv[1]);
        exit(1);
    }

    /* Start listening on the given port */
    fdServer = open_listen(portnum);

    process_connections(fdServer);
    return 0;
}
