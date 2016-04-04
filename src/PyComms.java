import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextPane;

public class PyComms {
	
	
	public static void main(String[] args) {
	
		
		try{
			ServerSocket server = new ServerSocket(4444);
			System.out.println("Waiting for client on port 4444");
			while(true){
				Socket connected = server.accept();
				System.out.println("CONNECTED WITH CLIENT");
				BufferedReader inFromPi = new BufferedReader(new InputStreamReader(connected.getInputStream()));
				while(true){
					String fromclient = inFromPi.readLine();
					
					if(fromclient.equalsIgnoreCase("Occupied")){
						System.out.println("Client responded with "+fromclient + "\n");
					}
					else{
						System.out.println("Client responded with "+fromclient + "\n");
						connected.close();
					}
				}
				
			}	
			
		}
		catch(Exception e){
			System.out.println(e);
			
		}
		

	}

}
