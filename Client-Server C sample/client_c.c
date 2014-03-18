/* 
** CSSE2310/7231 - sample client - code to be commented in class
** Send a request for the top level page at some webserver and 
** print it out (including HTTP headers).
*/
#include <sys/types.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <stdlib.h>
#include <stdio.h> 
#include <unistd.h>
#include <netdb.h>
#include <string.h>

struct in_addr* name_to_IP_addr(char* hostname)
{
    int error;
    struct addrinfo* addressInfo;

    /* Convert hostname to an address */
    error = getaddrinfo(hostname, NULL, NULL, &addressInfo);
    if(error) {
	return NULL;
    }
    /* Extract the IP address from the address structure and return it */
    return &(((struct sockaddr_in*)(addressInfo->ai_addr))->sin_addr);
}

int connect_to(struct in_addr* ipAddress, int port)
{
    struct sockaddr_in socketAddr;
    int fd;
    
    /* Create TCP socket */
    fd = socket(AF_INET, SOCK_STREAM, 0);
    if(fd < 0) {
	perror("Error creating socket");
	exit(1);
    }

    /* Create structure that represents the address (IP address and port
     * number) to connect to
     */
    socketAddr.sin_family = AF_INET;	/* Address family - IPv4 */
    socketAddr.sin_port = htons(port);	/* Port number - network byte order */
    socketAddr.sin_addr.s_addr = ipAddress->s_addr;	/* IP address - already in network byte order */

    /* Attempt to connect to that remote address */
    if(connect(fd, (struct sockaddr*)&socketAddr, sizeof(socketAddr)) < 0) {
	perror("Error connecting");
	exit(1);
    }

    return fd;
}

void send_HTTP_request(int fd, char* file, char* host)
{
    char* requestString;

    /* Allocate space for our HTTP request */
    requestString = (char*)malloc(strlen(file) + strlen(host) + 26);

    /* Construct HTTP request
     * GET <file> HTTP/1.0
     * Host: <host>
     * <blank line>
     */
    sprintf(requestString, "GET %s HTTP/1.0\r\nHost: %s\r\n\r\n", file, host);

    /* Send request to server. write () returns the number of bytes sent - 
     * should really check that all were sent (but don't)
     */
    if(write(fd, requestString, strlen(requestString)) < 1) {
	perror("Write error");
	exit(1);
    }
}

void get_and_output_HTTP_response(int fd)
{
    char buffer[1024];
    int numBytesRead;
    int eof = 0;

    /* Read all data from file descriptor until end of file
     * and print to standard output 
     */
    while(!eof) {
	numBytesRead = read(fd, buffer, 1024);
	if(numBytesRead < 0) {
	    perror("Read error\n");
	    exit(1);
	} else if(numBytesRead == 0) {
	    eof = 1;
	} else {
	    /* Write characters received to standard output */
	    fwrite(buffer, sizeof(char), numBytesRead, stdout);
	}
    }
}

int main(int argc, char* argv[]) {
    int fd;
    struct in_addr* ipAddress;
    char* hostname;

    if(argc != 2) {
	fprintf(stderr, "Usage: %s hostname\n", argv[0]);
	exit(1);
    }
    hostname = argv[1];

    /* Convert our hostname to an IP address */
    ipAddress = name_to_IP_addr(hostname);
    if(!ipAddress) {
	fprintf(stderr, "%s is not a valid hostname\n", hostname);
	exit(1);
    }

    fd = connect_to(ipAddress, 80);
    send_HTTP_request(fd, "/", hostname);
    get_and_output_HTTP_response(fd);
    close(fd);
    return 0;
}
