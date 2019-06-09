import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	static Scanner scan = new Scanner(System.in);
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
			pr.println(str);// prints on server side
			pr.flush();
			
			String serverStr ="";
			while (!serverStr.equals("end"))
			{
				serverStr = bf.readLine(); //server message
				out.println("Server: "+ serverStr);
				out.print(chatName+": ");
				String clientStr = scan.nextLine();
				pr.println(clientStr);
				pr.flush();
			}
			s.close();
		}
		catch (Throwable e)
		{
			err.println(e);
		}

	}

}
