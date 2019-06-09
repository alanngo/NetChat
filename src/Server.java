import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*
;public class Server //Codenamed 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket ss = new ServerSocket(4999);
			Socket s = ss.accept(); //client makes connection request
			
			out.println("Client connected");
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			PrintWriter pr = new PrintWriter(s.getOutputStream());

			String clientStr="";
			while (!clientStr.equals("end"))
			{
				clientStr = bf.readLine(); //client message
				out.println("Client: "+clientStr);
				out.print("Me: ");
				String serverStr = scan.nextLine();
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
