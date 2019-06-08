import java.io.*;
import java.net.Socket;

public class Client 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	public static void main(String[] args) 
	{
		try 
		{
			Socket s = new Socket("localhost", 4999);
			PrintWriter pr = new PrintWriter(s.getOutputStream());
			pr.println("is it working?");
			pr.flush();
			
			InputStreamReader in = new InputStreamReader(s.getInputStream());
			BufferedReader bf = new BufferedReader(in);
			
			String str = bf.readLine();
			out.println("Server: "+ str);
			
			s.close();
		}
		catch (Throwable e)
		{
			err.println(e);
		}

	}

}
