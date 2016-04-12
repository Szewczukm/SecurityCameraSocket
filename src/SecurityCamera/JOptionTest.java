package SecurityCamera;


import javax.swing.JDialog;
import javax.swing.JOptionPane;


/**
 * Example code for creating an alert
 * @author Mark Szewczuk
 *
 *
 * This code creates a pop-up window that closes by itself after 10 seconds or if you press
 * "OK."  The thread is for waiting 10 seconds before automatically closing the window.
 * The reason this wait is in its own thread is so that you can still do more things while
 * waiting for the window to close after 10 seconds.
 */
public class JOptionTest {

	public static void main(String[] args) {
		JOptionPane test = new JOptionPane("MOTION HAS BEEN DETECTED",JOptionPane.WARNING_MESSAGE);
		JDialog occ = test.createDialog("INTRUDER ALERT!!!");
		
		new Thread(new Runnable(){
			public void run(){
				try{
					Thread.sleep(10000);
					occ.dispose();
				}
				catch(Throwable th){
					System.out.println(th);
				}
			}
		}).start();
		
		occ.setVisible(true);
		
	}

}


