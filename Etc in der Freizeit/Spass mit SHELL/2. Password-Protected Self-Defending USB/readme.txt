===========================Self Defending Usb===========================

Made by: Leonard Haddad

PLEASE NOTE THAT THIS IS FOR FUN ONLY! THE DATA ON YOUR DEVICE IS NOT ENCRYPTED
AND CAN BE ACCESSED AT ANY TIME USING A WINDOWS SHELL OR ADVANCED FOLDER VIEWER

THIS SHOULD THEREFOR NOT BE USED AS A PROPER WAY OF PROTECTING YOUR DATA!

IMPROPER USE OF THE PROVIDED SCRIPT MAY HAVE LEGAL CONSEQUENCES! I AM NOT
RESPONSIBLE FOR YOU ACTIONS! THIS SCRIPT IS FOR EDUCATIONAL PURPOSES ONLY! 

===========================SETUP===========================

1. Copy the DATA.bat Usb.bat and data files to a usb device

2. Open a Command Shell (CTRL+R > cmd > ENTER)

3. Navigate to your usb's drive, for a D:\ drive it is done by typing D: and hitting Enter

========================================================================
CHANGE THE PASSWORD USED BY EDITING THE DATA.bat FILE BEFORE CONTINUING
**DEFAULT PASSWORD IS: "password1234"**
========================================================================

4. Type in the following: attrib +s +h DATA.bat and then: attrib +s +h usbdata
(This will make the file a System Protected and Hidden file 

DONE!

To view the Usb's contents start the Usb.bat file, which will in turn start the DATA.bat file
where you will be able to input a password

INPUTTING THE WRONG PASSWORD IN THIS CASE WILL END WINDOWS EXPLORER!

To restart Windows Explorer hit CTRL + SHIFT + ESC, click on File > Run new task > Explorer.exe > Enter

===========================HOW IT WORKS===========================

The Usb.bat file starts the DATA.bat file and then closes itself.

The DATA.bat takes an input from the user. If the input is the correct password, it
goes to the correct password function. Otherwise it goes to the incorrect password one.

After that it choses either to kill windows explorer or open your usb's usbdata folder

OPTIONALLY: You can add the command shutdown /r /f /t 4 to the incorrect function to restart
the PC if an incorrect password was entered. 

===========================END===========================
