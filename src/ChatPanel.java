import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.*;

public class ChatPanel extends JPanel
{
	private static final long serialVersionUID = -2613494144670085375L;
	private JButton send;
	public ChatPanel()
	{
		//dimensions of panel
		Dimension size = getPreferredSize();
		size.width = 300;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Chatroom"));
	}
}
