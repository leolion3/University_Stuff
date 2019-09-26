import socket
import threading
import sys
import time
import os


ADDRESS = '127.0.0.1'
PORT = 5050
clients = []
client_names = []
username = ''


def client_handler(s,client_name):
    global clients,client_names
    try:
        while True:
            data = s.recv(4096)
            message = data.decode()
            if len(message):
                if "/users" in message:
                    message = '\n==========Users Online==========\n'
                    for name in client_names:
                        message = message + "\n" + name
                    message += "\n\n================================\n\n"
                    s.send(bytes(message,"UTF-8"))
                else:
                    print(message)
                    for a in clients:
                        if a!=s:
                            a.send(bytes("\n"+message,"UTF-8"))
    except:
        client_names.remove(client_name)
        clients.remove(s)
        for a in clients:
            a.send(bytes("\n#>SYSTEM: "+client_name + " has left the chatroom!\n","UTF-8"))
        s.close()


def start_chatroom():
    global ADDRESS,PORT,clients,client_names
    print("Please select address to host on!")
    address = input("#>")
    if len(address):
        ADDRESS = address
    print("Please select port to host on!")
    port = input("#>")
    if len(port):
        PORT = int(port)
    s = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    try:
        s.bind((ADDRESS,PORT))
        s.listen(True)
        os.system('cls' if os.name == 'nt' else 'clear')
        print("Listening on " + ADDRESS +":"+ str(PORT))
        while True:
            client_socket, client_address = s.accept()
            print("Client " + str(client_address[0])+":"+str(client_address[1]) + " connected!")
            client_name = client_socket.recv(1024).decode()
            client_names.append(client_name)
            t = threading.Thread(target = client_handler, args = (client_socket,client_name))
            t.setDaemon(True)
            t.start()
            for a in clients:
                a.send(bytes("\n#>SYSTEM: "+client_name + " has joined the chatroom!\n","UTF-8"))
            clients.append(client_socket)
    except:
        print("Error occurred! Terminating...")
        time.sleep(3)
        sys.exit(0)


def receive_messages(s):
    while True:
        data = s.recv(4096)
        message = data.decode()
        if len(message):
            print(message)
        continue


def send_messages(s):
    while True:
            message = input()
            if message.lower() == 'cls' or message.lower() == 'clear':
                os.system('cls' if os.name == 'nt' else 'clear')
            elif len(message):
                sendme = "<"+username +">: " + message
                s.send(bytes(sendme,"UTF-8"))
            continue
            
def join():
    global ADDRESS,PORT,username
    print("Please select a username!")
    username = input("#>")
    if not len(username):
        print("Please try again!")
        join()
    print("Please select the Chatrooms address!")
    address = input("#>")
    if len(address):
        ADDRESS = address
    print("Please enter the Chatrooms port!")
    port = input("#>")
    if len(port):
        PORT = int(port)
    s = socket.socket()
    try:
        s.connect((ADDRESS,PORT))
        print("Connected!")
        time.sleep(1)
        os.system('cls' if os.name == 'nt' else 'clear')
        s.send(bytes(username,"UTF-8"))
        t = threading.Thread(target = receive_messages, args = (s,))
        t.start()
        a = threading.Thread(target = send_messages, args = (s,))
        a.start()
        print('#>To see who is online, simply enter "/users"\n')
    except:
        print("Error occurred! Exiting...")
        time.sleep(3)
        sys.exit(0)



def select_type():
    print("Do you want to Host or Join a Chatroom? Select host/join")
    type = input("#>")
    if "host" in type.lower():
        start_chatroom()
    elif "join" in type.lower():
        join()
    else:
        print("Please try again!")
        select_type()
    
    
if __name__ == "__main__":
    select_type()