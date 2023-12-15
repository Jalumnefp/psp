package es.jfp.elements;

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


public class ChatPanel extends JPanel {
	
	public static final JTextArea chatTextArea = new JTextArea(12, 25);
	
	public ChatPanel() {
		this.chatTextArea.disable();
		this.add(chatTextArea);
		
	}
	

}


