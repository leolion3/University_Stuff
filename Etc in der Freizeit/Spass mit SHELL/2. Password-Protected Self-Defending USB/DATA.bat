@ECHO off
color 0a
title Self-Defending-Usb
cls

ECHO.
set choice=
set /p choice=Please enter the Password!
if '%choice%'=='password1234' goto correct
goto incorrect

:incorrect
echo Incorrect Password! Retaliating!
timeout 2
taskkill /f /im explorer.exe
goto end
:correct
start usbdata
goto end
:end
exit