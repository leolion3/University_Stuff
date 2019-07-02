@echo Dieses ist die windows SHELL
@pause
@cls
echo mit "@" kann man die commands verstecken
@pause
@echo unzwar so "echo unzwar so" "-> zeigt den Pfad und Command nicht an"
@pause
@cls
@echo dieses geht aber auch mit "@ECHO off" dann braucht man gar keine "@" zu benutzen
@pause
@ECHO off
@cls
echo um Kommentare zu erstellen, benutzt man echo : "echo message" ergibt z.B. "message"
pause
cls
echo jede Command-zeile hat eine maximal Characterlaenge von 254 Buchstaben, also denk da dran!
pause
cls
echo mit "pause" kann man das Program anhalten, und der User muss eine Taste druecken um fortzufahren
pause 
cls
echo mit "cls" kann man alles auf dem Screen loeschen "(cls = clearScreen)"
pause
echo z.B. Huhu click ma weiter
pause
cls
echo Ta-da!
pause
cls
echo mit "start" kannst du ein neues Program starten
pause
start cmd /k @echo Hallo :]
echo wie ich jetzt z.B. bei dir gemacht habe! :]
pause
cls
echo mit copy, xcopy kannst du Files von einem Ort zu nem Anderen kopieren
pause
echo Dafuer benutz einfach "copy sourceFilePath destinationFilePath"
pause
cls
echo Wenn du hier fuer eine demonstration haben willst, schreibe bitte in klein ja, sonst druecke einfach ENTER um weiter zu machen.
set choice=
set /p choice=ja oder nein?
if '%choice%'=='ja' goto a
goto b
:a
cd > %userprofile%\Desktop\newFile
echo ich habe gerade eine leere Datei auf deinem desktop erstellt, ich wende jetzt "copy %userprofile%\Desktop\newFile %userprofile%\Documents\*" an
echo um den file in dein Documents folder zu kopieren
pause
copy %userprofile%\Desktop\newFile %userprofile%\Documents\*
echo Ta-da
pause
goto c
:b
goto c
:c
cls
echo mit "color" kannst du die Farbe des Textes aendern, z.B.
pause
cls
color 0c 
echo color 0c fuer Rot
pause
cls
color 0b 
echo color 0b fuer Cyan
pause
cls
color 07
echo und so weiter...
pause
cls
echo mit timeout kannst du die SCHELL warten lassen, z.B.
pause
echo timeout 5
timeout 5
pause
cls
echo mit ALT + ENTER kannst du die SHELL im FULLSCREEN modus nutzen
echo Dieses kann ich dir aber nicht zeigen, das musst du selbst versuchen
pause
cls
echo Mit ALT + SPACE kannst du die Einstellungen der SHELL aendern, z.b. deine default Text-farbe
pause
cls 
echo mit "mode" kannst du die SHELL vergroessern, z.B.
pause
cls
mode 300
echo das ist mode 300
pause
mode 122,30
echo Das wars erstmal, fuer mehr guck dir die anderen files an
echo es gibt naemlich sehr viele Sachen die du mit der SHELL anstellen kannst :]
echo p.s. lade dir diesen file runter, recht click und edit um zu erfahren wie er gemacht ist
pause
exit