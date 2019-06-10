
import socket
TERMINATE = "end"

try:
    ss = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    ss.bind(("NetChat", 4999))
    ss.listen()
    while 1:
        print("Waiting on client...")
        s = ss.accept()
        print("Client Coneected")

        while 1:
            clientStr = s.recv()
            if clientStr == 0 or clientStr == TERMINATE:
                print("CLIENT CLOSED")
                break
            print(clientStr)
            serverStr = input("Me: ")
            if serverStr == TERMINATE:
                ss.close()
                print("CONNECTION CLOSED BY SERVER")
                exit(0)
            print(serverStr)

except:
    print("Error")