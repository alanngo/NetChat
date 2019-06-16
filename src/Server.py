import socket
TERMINATE = "end"
def main():
    ss = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    ss.bind(('', 1250))
    ss.listen(5)
    while 1:
        #establish connection and receive message
        print("Waiting on client...")
        s,a = ss.accept()
        print("Client Conected")
        clientName = s.recv(4096).decode()
        print("Begin chat")
        serverStr = "Hi, let's begin chat"
        s.send(serverStr.encode())
        
        while 1:
            clientStr = s.recv(4096).decode()

            if clientStr == 0 or clientStr == TERMINATE:
                print("CLIENT CLOSED")
                break
            #client message
            print(clientName + ": " + clientStr)
            serverStr = raw_input("Me: ")
            s.send(serverStr.encode())
            if serverStr == TERMINATE:
                ss.close()
                print("CONNECTION CLOSED BY SERVER")
                exit(0)

main()
