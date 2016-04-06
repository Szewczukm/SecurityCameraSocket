package SecurityCamera;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class PyComms {
	
	
	public static void main(String[] args) {
	
		String prev = "";
		
		JOptionPane occ = new JOptionPane("WARNING",JOptionPane.WARNING_MESSAGE);
		JDialog dlg = occ.createDialog("OCCUPIED");
		
		try{
			ServerSocket server = new ServerSocket(4444);
			System.out.println("Waiting for client on port 4444");
			Socket connected = server.accept();
			System.out.println("CONNECTED WITH CLIENT");
			while(true){
				BufferedReader inFromPi = new BufferedReader(new InputStreamReader(connected.getInputStream()));
				String fromclient = inFromPi.readLine();
				
				if(prev.equalsIgnoreCase(fromclient));
				else{
					System.out.println("Client responded with "+fromclient);
				}
				
				prev = fromclient;
				
			}	
			
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		

	}

}
