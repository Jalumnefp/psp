package es.jfp.elements;

import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ChatPanel extends JPanel {
	
	public static final JTextArea chatTextArea = new JTextArea(12, 25);
	
	public ChatPanel() {
		
		this.chatTextArea.disable();
		
		appendChilds();
		
	}
	
	
	private void appendChilds() {
		
		this.add(chatTextArea);
		
	}

}


