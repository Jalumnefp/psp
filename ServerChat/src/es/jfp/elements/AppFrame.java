package es.jfp.elements;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class AppFrame extends JFrame {
	
	
	private final Toolkit toolkit = Toolkit.getDefaultToolkit();
	
	public AppFrame() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
<<<<<<< HEAD
		this.setTitle("Chat server");
=======
		this.setTitle("Chat servidor");
>>>>>>> c8e77a8b8d93a5b65985c116e559ef1ba6d0107a
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
