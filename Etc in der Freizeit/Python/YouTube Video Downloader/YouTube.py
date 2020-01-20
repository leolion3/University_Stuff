# To use this, you must first download the youtube-dl library
# using pip: pip install --upgrade youtube-dl
# additionally you need to have either ffprobe or avprobe installed
# you can install one using pip install ffprobe/avprobe
# you also need to install ffmpeg or avconv
# you can install ffmpeg using pip install ffmpeg
# if that doesnt work, copy the exe's to the install location of youtube-dl.exe
import subprocess
import threading
import pyperclip
import time
import sys
import os
sys.path.append(os.path.abspath("SO_site-packages"))


def download(command):
    subprocess.run(command, shell=True)


def start():
    print("Copy link to clipboard to start downloading!")
    inp = ""
    while True:
        tmp = pyperclip.paste()
        if inp!=tmp:
            inp = tmp
            if inp == "exit":
                exit(0)
            elif "&list" in inp:
                try:
                    link, pl = inp.split("list=")
                    if "?" in pl:
                        playlist, rest = pl.split("?")
                    else:
                        playlist = pl
                    command = 'youtube-dl -i ' + playlist + ' -x --audio-format mp3'
                    download(command)
                except:
                    print("Error!")
            else:
                try:
                    command = 'youtube-dl -x --audio-format mp3 ' + inp
                    t = threading.Thread(target=download, args=(command,))
                    t.start()
                except:
                    print("Error or wrong link!")


if __name__ == "__main__":
    start()
