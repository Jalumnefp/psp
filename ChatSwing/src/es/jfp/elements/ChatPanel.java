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

import es.jfp.events.SendOnClickEvent;

public class ChatPanel extends JPanel {
	
	public static final JTextField userTextField = new JTextField(25);
	public static final JTextArea chatTextArea = new JTextArea(12, 25);
	public static final JTextField messageTextField = new JTextField(18);
	private final JButton sendButton = new JButton("Send");
	
	public ChatPanel() {
		
		this.chatTextArea.disable();
		
		sendButton.addActionListener(new SendOnClickEvent());
		
		appendChilds();
		
	}
	
	
	private void appendChilds() {
		
		this.add(userTextField);
		this.add(chatTextArea);
		this.add(messageTextField);
		this.add(sendButton);
		
	}

}


