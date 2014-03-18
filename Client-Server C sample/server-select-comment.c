#include <sys/types.h>
#include <sys/socket.h>
#include <netdb.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>

#define MAXHOSTNAMELEN 128

/* Same function as we've seen earlier */
int open_listen(int port)
{
    int fd;
    struct sockaddr_in serverAddr;
    int optVal;

    fd = socket(AF_INET, SOCK_STREAM, 0);
    if(fd < 0) {
        perror("Error creating socket");
        exit(1);
    }

    optVal = 1;
    if(setsockopt(fd, SOL_SOCKET, SO_REUSEADDR, &optVal, sizeof(int)) < 0) {
        perror("Error setting socket option");
        exit(1);
    }
    
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_port = htons(port);
    serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);

    if(bind(fd, (struct sockaddr*)&serverAddr, sizeof(struct sockaddr_in)) < 0){
        perror("Error binding socket to port");
        exit(1);
    }
    if(listen(fd, SOMAXCONN) < 0) {
        perror("Error listening");
        exit(1);
    }

    return fd;
}

/* Same function as we've seen earlier */
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
    int maxFD;
    int newFD;
    int error;
    struct sockaddr_in fromAddr;
    socklen_t fromAddrSize;
    char buffer[1024];
    ssize_t numBytesRead;
    char hostname[MAXHOSTNAMELEN];

    /* Declare two sets of fds - one is the master copy, one we
     * pass to select(). baseSet is our master copy.
     */
    fd_set baseSet, readSet;

    /* Initialise our master fd set - we're interested in events
     * on our listening file descriptor.
     */
    maxFD = fdServer;
    FD_ZERO(&baseSet);
    FD_SET(fdServer, &baseSet);
    FD_SET(STDIN_FILENO, &baseSet);

    while(1) {
	/* Copy our set of fds */
        readSet = baseSet;

	/* Block until until "read" activity happens on one
	 * of our file descriptors
	 */
        if(select(maxFD + 1, &readSet, NULL, NULL, NULL) < 0) {
            perror("Select failed");
            exit(1);
        }
	/* If we get here - event happened on at least one of 
	 * the fds of interest. Iterate over all of them and
	 * check which bits are one in our set of fds.
	 */
        for(fd = maxFD; fd >= 0; fd--) {
	    /* For each fd - check whether it is set */
            if(FD_ISSET(fd, &readSet)) {
                if(fd == fdServer) {
		    /* New connection request has arrived - deal with it as before */
                    fromAddrSize = sizeof(struct sockaddr_in);
                    newFD = accept(fdServer, (struct sockaddr*)&fromAddr,  
                              &fromAddrSize);
                    if(newFD < 0) {
                        perror("Error accepting connection");
                        exit(1);
                    }
		    /* Add new connected file descriptor to our master set
		     * of interesting fds
		     */
                    FD_SET(newFD, &baseSet);
		    /* Update max if necessary */
                    if(newFD > maxFD) {
                        maxFD = newFD;
                    }
                    error = getnameinfo((struct sockaddr*)&fromAddr, 
                            fromAddrSize, hostname,
                            MAXHOSTNAMELEN, NULL, 0, 0);
                    if(error) {
                        fprintf(stderr, "Error getting hostname: %s\n",
                                gai_strerror(error));
                    } else {
                        printf("Accepted connection from %s (%s), port %d\n",
                                inet_ntoa(fromAddr.sin_addr),
                                hostname, ntohs(fromAddr.sin_port));
                    }
                } else {
		    /* Read event on connected fd - data arrived from
		     * client (or EOF on client). Read data, capitalise,
		     * send it back.
		     */
                    numBytesRead = read(fd, buffer, 1024);
                    if(numBytesRead > 0) {
                        fflush(stdout);
                        capitalise(buffer, numBytesRead);
                        write(fd, buffer, numBytesRead);
                    } else if(numBytesRead < 0) {
                        perror("Error reading from socket");
                        exit(1);
                    } else {                          
			/* EOF - client has disconnected. We need to
			 * remove the fd from our master set and update
			 * the max if necessary.
			 */
                        FD_CLR(fd, &baseSet);
                        if(fd == maxFD) {
                            do {
                               maxFD--;
                            } while ( maxFD > 0 && !FD_ISSET(maxFD, &baseSet));
                        }
                        close(fd);
                    }
                }
            }
        }
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

    portnum = atoi(argv[1]);
    if(portnum < 1024 || portnum > 65535) {
        fprintf(stderr,  "Invalid port number: %s\n", argv[1]);
        exit(1);
    }

    fdServer = open_listen(portnum);

    process_connections(fdServer);

    return 0;
}
 

