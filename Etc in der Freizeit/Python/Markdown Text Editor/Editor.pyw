# This script is inspired by the article How to Build a Toy 
# Markdown Editor with Python and Tkinter By Palash Bauri
# link: https://www.freecodecamp.org/news/lets-create-a-toy-markdown-editor-with-python-tkinter/

from tkinter import *
from tkinter import font, filedialog
from markdown2 import Markdown
from tkhtmlview import HTMLText
from tkinter import messagebox as mbox
import os
import subprocess


class Window(Frame):
    fontSize = 14
    currentFont = "Helvetica"
    currentFile = ""
    backgroundColor = "gray10"
    fgColor = "white"
    language = "txt"
    
    
    # ===== Constructor =====
    def __init__(self,master=None):
        Frame.__init__(self,master)
        self.master=master
        self.myfont = font.Font(family = self.currentFont, size = self.fontSize)
        self.init_window()
        self.preview = False
    
    
    # ===== Open File =====
    def openfileA(self,master):
        self.openfile()
        
        
    def openfile(self):
        openfilename = filedialog.askopenfilename(filetypes = ( ("Html File","*.html"), ("Python File", "*.py"), ("Haskell File", "*.hs"), ("Java File", "*.java"), ("Markdown File","*.md, *.mdown, *.markdown"), ("Text File", "*.txt"), ("All Files", "*.*") ))
        if openfilename:
            try:
                filedata = self.inputeditor.get(1.0,END)
                self.inputeditor.delete(1.0,END)
                self.inputeditor.insert(END, open(openfilename).read())
                self.currentFile = openfilename
                self.master.title(openfilename)
                if ".py" in self.currentFile:
                    self.language = "python"
                elif ".hs" in self.currentFile:
                    self.language = "haskell"
                else:
                    self.language = "txt"
            except Exception as e:
                mbox.showerror("Error opening selected file!", "The file {} could not be opened!".format(openfilename))
                print(e)
    
    
    def saveA(self, master):
        self.save()
    
    
    def saveasA(self,master):
        self.saveas()
        
        
    def quitA(self,master):
        self.save()
        self.quit()
    
        
    # ===== Save File =====
    def save(self):
        if self.currentFile:
            filedata = self.inputeditor.get(1.0,END)
            try:
                f = open(self.currentFile,"w+")
                f.write(filedata)
            except Exception as e:
                print(e)
        else:
            self.saveas()
    
    
    # ===== Save File As =====
    def saveas(self):
        savefilename = filedialog.asksaveasfilename(filetypes=( ("Html File","*.html"), ("Python File", "*.py"), ("Haskell File", "*.hs"), ("Java File", "*.java"), ("Markdown File","*.md, *.mdown, *.markdown"), ("Text File", "*.txt"), ("All Files", "*.*") ))
        if savefilename:
            self.currentFile = savefilename
            self.save()
            self.master.title(savefilename)
            if ".py" in self.currentFile:
                self.language = "python"
            elif ".hs" in self.currentFile:
                self.language = "haskell"
            else:
                self.language = "txt"
    
    
    # ===== Window =====
    def init_window(self):
        # ===== Editor =====
        self.master.title("Markdown Editor")
        self.pack(fill = BOTH, expand = 1)
        self.inputeditor = Text(self, width="1", font=self.myfont, bg = self.backgroundColor, fg = self.fgColor, insertbackground = "white", tabs = self.fontSize * 4)
        self.inputeditor.pack(fill = BOTH, expand = 1, side = LEFT)
        # ===== Menu Bar =====
        self.mainmenu = Menu(self)
        self.filemenu = Menu(self.mainmenu)
        self.preview = Menu(self.mainmenu)
        self.colormenu = Menu(self.mainmenu)
        self.preview.add_command(label = "Enable/Disable Preview", command = self.html_preview)
        self.preview.add_command(label = "Run Script", command = self.execute_program)
        self.filemenu.add_command(label = "Open", command = self.openfile)
        self.filemenu.add_command(label = "Save" , command = self.save)
        self.filemenu.add_command(label = "Save as", command = self.saveas)
        self.filemenu.add_separator()
       # self.colormenu.add_command(label ="Text Color", command = )
        #self.colormenu.add_command(label ="Background Color", command = )
        #self.colormenu.add_command(label ="Preview Color", command = )
        self.filemenu.add_command(label = "Exit", command = self.quit)
        self.mainmenu.add_cascade(label = "File", menu = self.filemenu)
        self.mainmenu.add_cascade(label = "Run", menu = self.preview)
        
        self.master.config(menu = self.mainmenu)
        # ===== Shortcut Keys =====
        self.inputeditor.bind("<Control-s>", self.saveA)
        self.inputeditor.bind("<Control-S>", self.saveasA)
        self.inputeditor.bind("<Control-q>", self.quitA)
        self.inputeditor.bind("<Control-r>",self.execute_programA)
        self.inputeditor.bind("<Control-p>",self.html_previewA)
        self.inputeditor.bind("<Control-o>",self.openfileA)
    
    
    # ===== Update Preview ===== 
    def onInputChangeA(self,master):
        self.onInputChange()
        
        
    def onInputChange(self):
        self.inputeditor.edit_modified(0)
        md2html = Markdown()
        self.outputbox.set_html(md2html.convert(self.inputeditor.get(1.0,END)))
    
    
    def execute_programA(self,master):
        self.execute_program()
        
        
    def execute_program(self):
        self.save()
        try:
            os.startfile(self.currentFile)
        except Exception as e:
            print(e)
    
    
    # ===== Preview =====
    def html_previewA(self,master):
        self.html_preview()
        
        
    def html_preview(self):
        # Enable Preview
        if not self.preview:
            self.outputbox = HTMLText(self, width = "1", background = "white", html = "")
            self.outputbox.pack(fill = BOTH, expand = 1, side = RIGHT)
            self.outputbox.fit_height()
            self.inputeditor.bind("<<Modified>>",self.onInputChangeA)
            self.onInputChange()
            self.preview = True
        # Disable Preview
        else:
            self.outputbox.forget()
            self.preview = False
            
            
root = Tk()
root.geometry("700x600")
app = Window(root)
app.mainloop()
