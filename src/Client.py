import socket

TERMINATE = "end"

def main():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.connect(('', 1248))
    name = raw_input("Enter chat name: ")
    s.send(name.encode())
    str = s.recv(4096).decode()
    print("Server: " + str)
    str = raw_input(name + ": ")

    s.send(str.encode())
    
    if str == TERMINATE:
        s.close()

    while 1:
        serverStr = s.recv(4096).decode()
        if serverStr == 0 or serverStr == TERMINATE:
            s.close()
            print("SERVER CLOSED")
            exit(0)
        print("Server: " + serverStr)
        clientStr = raw_input(name + ": ")
        s.send(clientStr.encode())
        if clientStr == TERMINATE:
            s.close()
            print("CONNECTION CLOSED BY CLIENT")
            exit(0)

main()
