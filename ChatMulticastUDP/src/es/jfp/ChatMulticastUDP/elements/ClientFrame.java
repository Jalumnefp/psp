package es.jfp.ChatMulticastUDP.elements;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import es.jfp.ChatMulticastUDP.Client;

public class ClientFrame extends JFrame {
	
	private String userNick;
	private Client client;
	private JPanel panel;
	private JTextField sendTextField;
	private JTextArea chatTextArea;
	private JButton exitButton;
	private JButton sendButton;
	
	public ClientFrame(Client client) {
		this.userNick = client.getNickName();
		this.client = client;
		this.panel = new JPanel();
		this.sendTextField = new JTextField(20);
		this.chatTextArea = new JTextArea(14, 20);
		this.exitButton = new JButton("EXIT");
		this.sendButton = new JButton("SEND");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(400, 350);
		this.setContentPane(panel);
		this.setResizable(false);
		
		setUpPanel();
		setEvents();
	}
	
	private void setEvents() {
		sendButton.addActionListener(action -> {
			StringBuilder textToSend = new StringBuilder();
			textToSend.append('[').append(this.userNick).append("] ")
			.append(sendTextField.getText());
			sendTextField.setText("");
			if (!textToSend.isEmpty()) {
				Thread send = new Thread(new Send(textToSend.toString()), "[Send-Thread-" + userNick + "]");
				send.start();
			}
		});
		exitButton.addActionListener(action -> {
			new Thread(new Send(String.format("*** %s ens ha abandonat ***", this.userNick)), "[SendExit-Thread]");
			client.stopListening();
		});
	}
	
	private void setUpPanel() {
		appendElements();
	}
	
	private void appendElements() {
		this.panel.add(sendTextField);
		this.panel.add(sendButton);
		this.panel.add(chatTextArea);
		this.panel.add(exitButton);
	}
	
	public void appendChatTextArea(String text) {
		this.chatTextArea.append(text + '\n');
	}
	
	public void setUserNick(String nick) {
		this.userNick = nick;
	}

}
