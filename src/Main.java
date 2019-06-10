import java.io.*;
import java.net.*;
import javax.swing.*;

public class Main 
{
	static PrintStream out = System.out;
	static PrintStream err = System.err;
	static void displayFrame()
	{
		JFrame f = new ChatFrame("Network Chat");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	public static void main(String[] args) 
	{
		
	}
}
