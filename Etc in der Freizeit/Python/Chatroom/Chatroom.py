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
client_addresses = []


def client_handler(s,client_name,client_address):
    global clients,client_names,client_addresses
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
                            a.send(bytes(message,"UTF-8"))
    except:
        client_names.remove(client_name)
        clients.remove(s)
        for a in clients:
            a.send(bytes("#>SYSTEM: "+client_name + " has left the chatroom!","UTF-8"))
        print("#>SYSTEM: "+client_name + " has left the chatroom!")
        client_addresses.remove(client_address)
        s.close()


def view_users():
    global client_addresses
    while True:
        server_input = input()
        if len(server_input):
            if "/users" in server_input:
                print("\n=====Currently Connected=====")
                for a in client_addresses:
                    print(str(a[0])+":"+str(a[1]))
                print("=============================")
            elif server_input.lower() == 'cls' or server_input.lower() == 'clear':
                os.system('cls' if os.name == 'nt' else 'clear')


def start_chatroom():
    global ADDRESS,PORT,clients,client_names,client_addresses
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
        print('To view all connected users, type "/users"')
        p = threading.Thread(target = view_users)
        p.start()
        while True:
            client_socket, client_address = s.accept()
            client_name = client_socket.recv(1024).decode()
            client_names.append(client_name)
            t = threading.Thread(target = client_handler, args = (client_socket,client_name,client_address))
            t.setDaemon(True)
            t.start()
            for a in clients:
                a.send(bytes("#>SYSTEM: "+client_name + " has joined the chatroom!","UTF-8"))
            clients.append(client_socket)
            print("#>SYSTEM: "+client_name + " has joined the chatroom!")
            client_addresses.append(client_address)
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