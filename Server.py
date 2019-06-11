
import socket
TERMINATE = "end"
def main():
    ss = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    ss.bind(('', 1241))
    ss.listen(5)
    while 1:
        print("Waiting on client...")
        s,a = ss.accept()
        print("Client Conected")

        while 1:
            print("hi")
            clientStr = s.recv(4096).decode()
            if clientStr == 0 or clientStr == TERMINATE:
                print("CLIENT CLOSED")
                break
            print("hello")
            print(clientStr)
            serverStr = raw_input("Me: ")
            if serverStr == TERMINATE:
                ss.close()
                print("CONNECTION CLOSED BY SERVER")
                exit(0)
            print(serverStr)
            ss.send(serverStr.encode())
main()
