package SecurityCamera;


import javax.management.timer.Timer;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class JOptionTest {

	@SuppressWarnings("deprecation")
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


