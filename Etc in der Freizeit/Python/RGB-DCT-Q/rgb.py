# This module calculates the:
# - YCbCr Color Conversion
# - DCT
# and Quantisierung
from os import system, name


r1,r2,r3,r4 = "0","0","0","0"
g1,g2,g3,g4 = "0","0","0","0"
b1,b2,b3,b4 = "0","0","0","0"
q1,q2,q3,q4 = "0","0","0","0"
y1,y2,y3,y4 = "0","0","0","0"
cb1,cb2,cb3,cb4 = "0","0","0","0"
cr1,cr2,cr3,cr4 = "0","0","0","0"


def clear():
    if name == 'nt': 
        _ = system('cls') 
    else: 
        _ = system('clear')
        
        
def quantisieren():
    global q1,q2,q3,q4
    print("|" + str(round(round(0.5*(float(y1)+float(y2)+float(y3)+float(y4)),2)/float(q1))) + "|" + str(round(round(0.5*(float(y1)-float(y2)+float(y3)-float(y4)),2)/float(q2))) + "|\n|" + str(round(round(0.5*(float(y1)+float(y2)-float(y3)-float(y4)),2)/float(q3))) + "|" + str(round(round(0.5*(float(y1)-float(y2)-float(y3)+float(y4)),2)/float(q4))) + "|\n" )


# Calculate dct using the dct formulas
def dct():
    global y1,y2,y3,y4
    print("|" + str(round(0.5*(float(y1)+float(y2)+float(y3)+float(y4)),2)) + "|" + str(round(0.5*(float(y1)-float(y2)+float(y3)-float(y4)),2)) + "|\n|" + str(round(0.5*(float(y1)+float(y2)-float(y3)-float(y4)),2)) + "|" + str(round(0.5*(float(y1)-float(y2)-float(y3)+float(y4)),2)) + "|\n")


# Calculate the cr color space
def cr(r,g,b):
    return str(round(0.5*int(r)-0.418688*int(g)-0.081312*int(b),2))


# Calculate the cb color space
def cb(r,g,b):
    return str(round(-0.168736*int(r)-0.331264*int(g)+0.5*int(b),2))


# Calculate the y color space
def y(r,g,b):
    return str(round(0.299*int(r)+0.587*int(g)+0.114*int(b),2))


def calculate():
    global b1,b2,b3,b4
    global y1,y2,y3,y4
    global cb1,cb2,cb3,cb4
    global cr1,cr2,cr3,cr4
    print("Enter value for Blue")
    blue = input("#>")
    clear()
    b1,b2,b3,b4 = blue,blue,blue,blue
    y1 = y(r1,g1,b1)
    y2 = y(r2,g2,b2)
    y3 = y(r3,g3,b3)
    y4 = y(r4,g4,b4)
    cb1 = cb(r1,g1,b1)
    cb2 = cb(r2,g2,b2)
    cb3 = cb(r3,g3,b3)
    cb4 = cb(r4,g4,b4)
    cr1 = cr(r1,g1,b1)
    cr2 = cr(r2,g2,b2)
    cr3 = cr(r3,g3,b3)
    cr4 = cr(r4,g4,b4)
    print("Answer:"+"\n")
    print("Y:\n|" + y1 +"|"+ y2 +"|\n|"+ y3 +"|"+ y4 +"|\n")
    print("Cb:\n|" + cb1 +"|"+ cb2 +"|\n|"+ cb3 +"|"+ cb4 +"|\n")
    print("Cb heruntergesamplet:"+str(round(float(cb1) + float(cb2) + float(cb3) + float(cb4),1)/4)+"\n")
    print("Cr:\n|" + cr1 +"|"+ cr2 +"|\n|"+ cr3 +"|"+ cr4 +"|\n\n")
    print("Cr heruntergesamplet:"+str(round(float(cr1) + float(cr2) + float(cr3) + float(cr4),1)/4)+"\n")
    print("DCT:\n")
    dct()
    print("Quantisiert:")
    quantisieren()
    calculate()
    

# Set starting variables
def setup():
    global r1,r2,r3,r4
    global g1,g2,g3,g4
    global q1,q2,q3,q4
    print("Enter values for Red, seperated by ,")
    red = input("#>")
    r1,r2,r3,r4 = red.split(",")
    print("Enter values for Green, seperated by ,")
    green = input("#>")
    g1,g2,g3,g4 = green.split(",")
    print("Enter values for Q, seperated by ,")
    Q = input("#>")
    q1,q2,q3,q4 = Q.split(",")
    calculate()
    
    
if __name__ == "__main__":
    setup()