package es.jfp.elements;

<<<<<<< HEAD
import javax.swing.JPanel;
import javax.swing.JTextArea;

=======
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
>>>>>>> c8e77a8b8d93a5b65985c116e559ef1ba6d0107a


public class ChatPanel extends JPanel {
	
	public static final JTextArea chatTextArea = new JTextArea(12, 25);
	
	public ChatPanel() {
<<<<<<< HEAD
		
		this.chatTextArea.disable();
		
		appendChilds();
		
	}
	
	
	private void appendChilds() {
		
		this.add(chatTextArea);
		
	}
=======
		this.chatTextArea.disable();
		this.add(chatTextArea);
		
	}
	
>>>>>>> c8e77a8b8d93a5b65985c116e559ef1ba6d0107a

}


