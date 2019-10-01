import socket
import os
import subprocess
import threading
import sys
import time
from os import system, name


ADDRESS = '0.0.0.0'
PORT = 5050


def clear():
    if name == 'nt': 
        _ = system('cls') 
    else: 
        _ = system('clear')


def create_file(s):
    print("Welcome to the file creation tool!")
    print('When you are done, simply type "===end==="')
    while True:
        user_input = input()
        if "===end===" in user_input.lower():
            s.send(b"===end===")
            break
        if len(user_input):
            s.send(bytes(user_input,"utf-8"))


def file_creator(s,path,fileName):
    try:
        f = open(path + fileName,"w+")
        while True:
            received_data = s.recv(4096)
            received_message = received_data.decode()
            if "===end===" in received_message:
                f.close()
                break
            f.write(received_message +"\n")
    except:
        print("Exception! Terminating!")


def send_commands(s):
    print("\nYou can now send commands!")
    print('To exit, simple type "exit"')
    while True:
        user_input = input("#>")
        if "exit" in user_input.lower():
            s.send(b"ended")
            break
        elif len(user_input):
            s.send(bytes(user_input,"utf-8"))


def receive_commands(s,receiveCommands):
    while receiveCommands:
        received_data = s.recv(4096)
        received_message = received_data.decode()
        if "ended" in received_message:
            receive(s)
            break
        elif receiveCommands:
            try:
                if "cd" in received_message.lower():
                    os.chdir(received_message[3:])
                else:
                    p = subprocess.check_output(received_message,stderr = subprocess.STDOUT,shell=True)
                    if len(p):
                        s.send(p)
                    else:
                        s.send(b"#>")
            except Exception as e:
                print(e)
                try:
                    p = subprocess.run(received_message,shell=True,capture_output=True)
                    answer = p.stdout + p.stderr
                    s.send(answer)
                except Exception as g:
                    print(g)
                    s.send(b"Must've been an incorrect command!")
        else:
            break


def send(s):
    while True:
        try:
            user_input = input()
            if "cls" in user_input.lower() or "clear" in user_input.lower():
                clear()
            if "shell:" in user_input.lower():
                s.send(b"shell:")
                send_commands(s)
            if "createfile:" in user_input.lower():
                print("Please enter Path to create file at!")
                path = input()
                print("Please enter file name!")
                name = input()
                s.send(bytes("===createFile===," + path +',' + name,"utf-8"))
                create_file(s)
            if len(user_input):
                s.send(bytes(user_input,"utf-8"))
        except Exception as e:
            print(e)
            break
    sys.exit(-1)


def receive(s):
    while True:
        try:
            received_data = s.recv(4096)
            received_message = received_data.decode()
            if "===createFile===," in received_message:
                command, path, name = received_message.split(',');
                file_creator(s,path,name)
            elif "shell:" in received_message:
                receive_commands(s,True)
            elif len(received_message):
                print(received_message)
        except Exception as e:
            print(e)
            break
    sys.exit(-1)
    

def client(s):
    try:
        a = threading.Thread(target = send, args = (s,))
        b = threading.Thread(target = receive,args = (s,))
        a.start()
        b.start()
    except Exception as e:
        print(e)
        time.sleep(3)
        sys.exit(0)


def client_handler(s,addr):
    try:
        a=threading.Thread(target = send, args = (s,))
        b=threading.Thread(target = receive,args = (s,))
        a.start()
        b.start()
    except Exception as e:
        print(e)
        time.sleep(3)
        s.close()
        print("Client " + str(addr[0])+":"+str(addr[1])+" disconnected!")
        sys.exit(0)


def netcat():
    clear()
    global ADDRESS,PORT
    AMOUNT = 1
    print("Welcome to the NetCat tool!")
    print("Please choose mode Host/Client!")
    while True:
        type = input("#>")
        if "host" in type.lower():
            print("Please select address to listen on!")
            address = input("#>")
            if len(address):
                ADDRESS = address
            print("Please select port to listen on!")
            port = input("#>")
            if len(port):
                PORT = int(port)
            print("Please specify maximum connections amount!")
            amount = input("#>")
            if len(amount):
                AMOUNT = int(amount)
            try:
                s = socket.socket()
                s.bind((ADDRESS,PORT))
                s.listen(AMOUNT)
                print("Listening on "+ADDRESS+":"+str(PORT)+"...")
                while True:
                    client_socket,client_address=s.accept()
                    print("Client "+str(client_address[0])+":"+str(client_address[1])+" connected!")
                    p = threading.Thread(target = client_handler, args = (client_socket,client_address))
                    p.start()
            except Exception as e:
                print(e)
                time.sleep(3)
                break
        elif "client" in type.lower():
            print("Please select address to connect to!")
            address = input("#>")
            if len(address):
                ADDRESS = address
            print("Please specify port to connect to!")
            port = input("#>")
            if len(port):
                PORT = int(port)
            print("Attempting to connect to " + ADDRESS + ":"+str(PORT))
            try:    
                s = socket.socket()
                s.connect((ADDRESS,PORT))
                print("Connected!")
                client(s)
                break
            except Exception as e:
                print(e)
                time.sleep(3)
                break
        elif "exit" in type.lower():
            break
        else:
            continue


def help():
    print("Usage:")
    print('netcat or nc                          - start netcat')
    print('exit                                  - exit')
    print('help                                  - display this screen')
    start()


def start():
    print("Welcome to the Networking Tool!")
    print('To see all functions, type "help" or "?"')
    while True:
        user_input = input("#>")
        if "?" in user_input or "help" in user_input.lower():
            help()
            break
        elif "netcat" in user_input.lower() or "nc" in user_input.lower():
            netcat()
            break
        elif "exit" in user_input.lower():
            break
        elif "cls" in user_input.lower() or "clear" in user_input.lower():
            clear()
        else:   
            continue
    sys.exit(0)


start()