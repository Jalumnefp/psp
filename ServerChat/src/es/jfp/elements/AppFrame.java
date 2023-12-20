package es.jfp.elements;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class AppFrame extends JFrame {
	
	
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public AppFrame() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Chat server");
		this.setResizable(false);
		
		configureBounds();
		appendChilds();
		
	}
	
	public void configureBounds() {
		
		int width = toolkit.getScreenSize().width;
		int height = toolkit.getScreenSize().height;
		
		this.setSize(width/4, (int)(height/2.5));
		this.setLocation(width/3, height/4);
		
	}
	
	public void appendChilds() {
		
		this.getContentPane().add(new ChatPanel());
		
	}
	
	

}
