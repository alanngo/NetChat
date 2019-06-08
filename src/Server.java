import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	public static void main(String[] args) 
	{
		try 
		{
			ServerSocket ss = new ServerSocket(4999);
			Socket s = ss.accept();
			out.println("Client connected");
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			String str = bf.readLine();
			out.println("Client: "+str);
			
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			pr.println("yes");
			pr.flush();
			
			s.close();
			ss.close();
		}
		catch (Throwable e)
		{
			err.println(e);
		}

	}

}
