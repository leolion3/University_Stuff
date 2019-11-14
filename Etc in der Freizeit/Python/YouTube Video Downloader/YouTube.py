# To use this, you must first download the youtube-dl library
# using pip: pip install --upgrade youtube-dl
# additionally you need to have either ffprobe or avprobe installed
# you can install one using pip install ffprobe/avprobe
# you also need to install ffmpeg or avconv
# you can install ffmpeg using pip install ffmpeg
# if that doesnt work, copy the exe's to the install location of youtube-dl.exe
import subprocess


def start():
    while True:
        print("Please insert link!")
        inp = input("#>")
        try:
            command = "youtube-dl -x --audio-format mp3 " + inp
            subprocess.run(command, shell=True)
        except:
            print("Error or wrong link!")


if __name__ == "__main__":
    start()