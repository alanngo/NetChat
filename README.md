# NetChat

#Prerequisites

Python version: Python 2.7.15+
Java version: openjdk 11.0.3 2019-04-16

#Running the chat program on Java version
In order to run the Java chat program:
1) open two terminals and go to NetChat/src
2) run make clean && make all on terminal 1
3) run make server on terminal 1
4) run make client on terminal 2
5) In order to end the chat, type "end" on either the client or server side

#Running the chat program on Python version
In order to run the Python chat program:
1) open two terminals and go to NetChat/src
2) run make pyServer on terminal 1
3) run make pyClient on terminal 2
4) In order to end the chat, type "end" on either the client or server side
Note: if there's an scoket connection error, change the port number on line 5 of 
Server.py and line 7 to something else.
#Authors
Code by:Alan Ngo, Yunhao Yang, and Lucinda Nguyen
