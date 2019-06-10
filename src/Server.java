import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*
;public class Server //Codenamed 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	static Scanner scan = new Scanner(System.in);
	final static String TERMINATE = "end";
	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket ss = new ServerSocket(4999);
			out.println("Waiting on client...");
			
			Socket s = ss.accept(); //client makes connection request
			out.println("Client connected");
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			PrintWriter pr = new PrintWriter(s.getOutputStream());

			String clientStr="", serverStr="";
			while (!serverStr.equals(TERMINATE))
			{
				clientStr = bf.readLine(); //client message
				if (clientStr.equals(TERMINATE))
				{
					//TODO: reconnection problem
				}
				out.println(clientStr);
				out.print("Me: ");
				serverStr = scan.nextLine();
				if (serverStr.equals(TERMINATE))
				{
					ss.close();
					out.println("CONNECTION CLOSED BY SERVER");
					System.exit(0);
				}
				pr.println(serverStr);
				pr.flush();
			}
			s.close();
			ss.close();
		}
		catch (Throwable e)
		{
			err.println(e);
		}

	}

}
