
import socket

TERMINATE = "end"

try:
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(("NetChat", 4999))
    name = input("Enter chat name: ")
    str = input(name + ": ")

    if str == TERMINATE:
        s.close()
    print(name + ": "+ str)

    while 1:
        serverStr = s.recv()
        if serverStr == 0 or serverStr == TERMINATE:
            s.close()
            print("SERVER CLOSED")
            exit(0)
        print("Server: " + serverStr)
        clientStr = input(name + ": ")
        if clientStr == TERMINATE:
            s.close()
            print("CONNECTION CLOSED BY CLIENT")
            exit(0)
        print(name + ": "+ clientStr)

except:
    print("error")