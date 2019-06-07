import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class ChatFrame extends JFrame 
{
	private static final long serialVersionUID = 3536526127619569534L;
	
	private JTextArea history;
	private JTextArea chat;
	private ChatPanel panel;

	public ChatFrame(String s)
	{
		super(s);
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create swing components
		history = new JTextArea();
		chat = new JTextArea();
		panel = new ChatPanel();
		
		//add listener TODO
		
		//add swing components to content pane
		Container c = getContentPane();
		
		c.add(history, BorderLayout.CENTER);
		c.add(panel, BorderLayout.WEST); 
	}

}
