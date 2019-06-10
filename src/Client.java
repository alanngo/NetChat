import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	static Scanner scan = new Scanner(System.in);
	final static String TERMINATE = "end";
	public static void main(String[] args) 
	{
		try 
		{
			Socket s = new Socket("localhost", 4999); //client starts connection
			
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			out.print("Enter chat name: ");
			String chatName = scan.nextLine();
			
			out.print(chatName+": ");
			String str = scan.nextLine();
			if (str.equals(TERMINATE))
			{
				s.close();
			}
			pr.println(chatName+": "+str);// prints on server side
			pr.flush();
			
			String clientStr="", serverStr="";
			while (true)
			{
				serverStr = bf.readLine(); //server message
				if (serverStr==null||serverStr.equals(TERMINATE))
				{
					s.close();
					out.println("SERVER CLOSED");
					System.exit(0);
				}
				out.println("Server: "+ serverStr);
				out.print(chatName+": ");
				clientStr = scan.nextLine();
				if (clientStr.equals(TERMINATE))
				{
					s.close();
					out.println("CONNECTION CLOSED BY CLIENT");
					System.exit(0);
				}
				pr.println(chatName+": "+clientStr);
				pr.flush();
			}
		}
		catch (Throwable e)
		{
			err.println(e);
		}

	}

}
