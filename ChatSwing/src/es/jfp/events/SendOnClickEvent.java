package es.jfp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.jfp.controllers.Send;

public class SendOnClickEvent implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Thread sendThread = new Thread(new Send());
		
		sendThread.start();
		
		System.out.println("ok");
		
		
	}

}
