#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <netdb.h>

#define MAXHOSTNAMELEN 128


int create_and_bind_socket(port)
{
    int fd;
    struct sockaddr_in myAddress;

    /* Create UDP socket - SOCK_DGRAM for UDP */
    if((fd = socket(AF_INET, SOCK_DGRAM, 0)) < 0) {
        perror("Error creating socket");
        exit(1);
    }

    /* Populate an internet socket address structure with
     * the port we're "listening" on - any IP address on
     * this host is fine
     */
    myAddress.sin_family = AF_INET;
    myAddress.sin_port = htons(port);
    myAddress.sin_addr.s_addr = htonl(INADDR_ANY);
    
    /* Bind our socket to this address */
    if(bind(fd, (struct sockaddr *)&myAddress, 
            sizeof(struct sockaddr_in)) < 0) {
        perror("Error binding socket to port");
        exit(1);
    }
    return fd;
}


void communicate(fd, destPort)
{
    fd_set readSet;
    int numBytes;
    char buffer[1024];
    struct sockaddr_in theirAddress, destAddress;
    socklen_t theirAddrSize;
    char hostname[MAXHOSTNAMELEN];

    /* Destination address */
    destAddress.sin_family = AF_INET;
    destAddress.sin_port = htons(destPort);
    destAddress.sin_addr.s_addr = inet_addr("127.0.0.1");

    FD_ZERO(&readSet);

    while(1) {
	/* Only interested in two fds - stdin and the socket fd
	 * we're "listening" on - add those two fds to our set.
	 */
        FD_SET(fd, &readSet);
        FD_SET(STDIN_FILENO, &readSet);

	/* Wait for a read event on one of those two fds */
        if(select(fd + 1, &readSet, NULL, NULL, NULL) < 0) {
            perror("Select failed");
            exit(1);
        }

	/* Check the source of the event and handle */
        if(FD_ISSET(STDIN_FILENO, &readSet)) {
	    /* Stdin is readable */
            numBytes = read(STDIN_FILENO, buffer, 1024);
            if(numBytes > 0) {
		/* Got data from stdin - send it to our destination */
                if(sendto(fd, buffer, numBytes, 0, 
                        (struct sockaddr *)&destAddress, 
                        sizeof(struct sockaddr_in)) < 0) {
                    perror("sendto failed");
                    exit(1);
                }
            } else if(numBytes == 0) {
		/* EOF of stdin */
                close(fd);
                exit(1);
            } else {
                perror("Error reading from standard input");
                exit(1);
            }
        }
        if(FD_ISSET(fd, &readSet)) {
	    /* socket fd is readable */
            theirAddrSize = sizeof(struct sockaddr_in);
	    /* Get data from socket - along with the source address */
            numBytes = recvfrom(fd, buffer, 1024, 0, 
                    (struct sockaddr*)&theirAddress, 
                    &theirAddrSize);
            if(numBytes > 0) {
		/* Got data - print it out - with the source address */
                getnameinfo((struct sockaddr*)&theirAddress, theirAddrSize, 
                        hostname, MAXHOSTNAMELEN, NULL, 0, 0);
                printf("From %s:%d: ", hostname,
                          ntohs(theirAddress.sin_port));
                fflush(stdout);
		/* print the message */
                write(STDOUT_FILENO, buffer, numBytes);
            } else if(numBytes == 0) {
                close(fd);
                exit(1);
            } else {
                perror("Error in recvfrom");
                exit(1);
            }
        }
    }
}

int main(int argc, char* argv[])
{
    int myPort, destPort, fd;

    if(argc != 3) {
        printf("Usage: %s my-port dest-port\n", argv[0]);
        exit(1);
    }
    myPort = atoi(argv[1]);
    destPort = atoi(argv[2]);
    fd = create_and_bind_socket(myPort);
    communicate(fd, destPort);
    return 0;
}

