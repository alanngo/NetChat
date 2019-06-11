
import socket

TERMINATE = "end"

def main():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(('', 1241))
    name = raw_input("Enter chat name: ")
    str = raw_input(name + ": ")

    if str == TERMINATE:
        s.close()
    print(name + ": "+ str)

    while 1:
        serverStr = s.recv(4096).decode()
        if serverStr == 0 or serverStr == TERMINATE:
            s.close()
            print("SERVER CLOSED")
            exit(0)
        print("Server: " + serverStr)
        clientStr = raw_input(name + ": ")
        if clientStr == TERMINATE:
            s.close()
            print("CONNECTION CLOSED BY CLIENT")
            exit(0)
       # print(name + ": "+ clientStr)
        s.send(clientStr.encode())
main()
