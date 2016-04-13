package SecurityCamera;

import java.io.BufferedReader;
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
	
	
	public void startServer(int port){
		try{
			server = new ServerSocket(port);
			System.out.println("Waiting for client on port: "+port);
			connected = server.accept();
			System.out.println("Connected with client");
		}
		catch(Exception e){
			System.out.println("ERROR: "+e);
		}
	}
	
	public void readInput(){
		while(connected.isConnected()){
			
		}
	}
	
	
	

}
