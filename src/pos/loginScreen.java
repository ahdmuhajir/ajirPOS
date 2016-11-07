package pos;

import javax.swing.JFrame;


public class loginScreen extends JFrame{
	
	
	public static void main(String[] args) {
		KomponenVisual lg = new KomponenVisual();
		lg.loginpane();
		lg.loginpaneComp();
		lg.bgButt.setVisible(false);
		lg.home.setVisible(false);
		lg.pay.setVisible(false);
		
		
	}
}
