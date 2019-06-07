import java.io.PrintStream;
import javax.swing.JFrame;

public class Main 
{
	static PrintStream out = System.out;
	public static void main(String[] args) 
	{
		JFrame f = new ChatFrame("Network Chat");
		f.setSize(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
