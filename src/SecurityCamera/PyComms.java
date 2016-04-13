package SecurityCamera;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

import javax.management.timer.Timer;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

public class PyComms {

	
	
	public static void main(String[] args) {
		
		//prev is for storing the previous string to determine if there was a change 
		//between last time and this time
		String prev = "";
		
		//Creation of the pop-up menu
		JOptionPane occ = new JOptionPane("INTRUDER INTRUDER!!!!",JOptionPane.WARNING_MESSAGE);
		JDialog dlg = occ.createDialog("WARNING");
		
		//Try/catch block in order to wait for the client to connect to the server on port 4444
		try{
			//Creation of Socket server on port 4444
			ServerSocket server = new ServerSocket(4444);
			System.out.println("Waiting for client on port 4444");
			
			//Creates a socket for the connected client once it is connected
			Socket connected = server.accept();
			System.out.println("CONNECTED WITH CLIENT");
			//While loop, continuously running reading input lines from the raspberry pi's
			//output when it receives data from the pi (should only affect this code when 
			//prev is different from the last time)
			while(true){
				BufferedReader inFromPi = new BufferedReader(new InputStreamReader(connected.getInputStream()));
				String fromclient = inFromPi.readLine();
				
				//If prev is the same as the current, do nothing
				//Else if the current is "occupied" then show pop-up, else don't show the pop-up
				if(prev.equalsIgnoreCase(fromclient));
				else{
					if(fromclient.equalsIgnoreCase("occupied")){
						dlg.setVisible(true);
					}
					else{
						dlg.setVisible(false);
					}
					//print out the response from the pi, for testing purposes
					System.out.println("Client responded with "+fromclient);
				}
				
				//Set the previous to the current 
				prev = fromclient;
				
			}		
		}
		catch(Exception e){
			//Print out the exception that occured, generally it is Connected Refused
			//-- if the connection is abruptly terminated
			//Add safety catch for refusing connections and attempt to reconnect
			System.out.println(e);
			
		}
		

	}

}
