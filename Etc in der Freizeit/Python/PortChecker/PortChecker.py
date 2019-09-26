import socket
import sys
import time


def portchecker(address):
    print("Enter address to check port on!")
    addr = input("#>")
    if len(addr):
        address = addr
    print("Enter port to check!")
    port = input("#>")
    s = socket.socket()
    try:
        s.connect((address,int(port)))
        print("Port is open!\n")
        s.close()
    except:
        print("Port is closed!\n")
    print("Would you like to check another port?")
    choice = input("#Yes/No#>")
    if "y" in choice:
        portchecker(address)


if __name__ == "__main__":
    portchecker("0.0.0.0")