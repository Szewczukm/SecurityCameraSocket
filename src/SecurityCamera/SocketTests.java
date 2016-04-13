package SecurityCamera;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class SocketTests {
	
	private ServerSocket server;
	private JOptionPane occ;
	private JDialog dlg;
	private String prev = "", fromClient;
	private Socket connected;
	private BufferedReader inFromPi;
	
	
	public SocketTests(){
		super();
		occ = new JOptionPane("INTRUDER INTRUDER!!!!", JOptionPane.WARNING_MESSAGE);
		dlg = occ.createDialog("WARNING");
	}
	
	public SocketTests(String warningMessage, String title){
		super();
		occ = new JOptionPane(warningMessage, JOptionPane.WARNING_MESSAGE);
		dlg = occ.createDialog(title);
	}
	
	public void startServer(int port){
		try{
			server = new ServerSocket(port);
			System.out.println("Waiting for client on port: "+port);
			connected = server.accept();
			System.out.println("Connected with client");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void readInput(){
		while(connected.isConnected()){
			try {
				inFromPi = new BufferedReader(new InputStreamReader(connected.getInputStream()));
				if(prev.equalsIgnoreCase(fromClient));
				else{
					if(fromClient.equalsIgnoreCase("occupied")){
						dlg.setVisible(true);
					}
					else{
						dlg.setVisible(false);
					}
					//print out the response from the pi, for testing purposes
					System.out.println("Client responded with "+fromClient);
				}
				//Set the previous to the current 
				prev = fromClient;
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
