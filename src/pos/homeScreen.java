package pos;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class homeScreen extends JFrame{
	Color c = new Color(243, 156, 18);
	
	JButton home= new JButton();
	JButton pay = new JButton();
	JButton stock = new JButton();
	JButton report = new JButton();
	JButton setting= new JButton();
	JButton quit= new JButton();
	
	
	JLabel bg = new JLabel(new ImageIcon("images/bg.jpg"));
	
	JLabel namaAplikasi= new JLabel("Aplikasi Point Of Sale");
	JLabel tblScreen= new JLabel(new ImageIcon("images/table.png"));
	JLabel bgButt= new JLabel(new ImageIcon("images/bgButt.png"));
	
	JLabel info =new JLabel("<html><center>Aplikasi point of sales (POS) atau software kasir kami desain untuk mendukung produktifitas tinggi.<br> Dengan tampilan antarmuka sederhana dan mudah digunakan meskipun tanpa melibatkan mouse dalam operasionalnya. Meskipun mudah dan sederhana, tetapi software ini kami lengkapi dengan fasilitas lengkap dan berteknologi canggih.Saat ini kami mengembangkan point of sales berbasis Java.</center></html>");
	Font dfont = new Font("Roboto", Font.TRUETYPE_FONT, 12);
	
	public homeScreen() {
		setSize(1200,700);
		setLocation(65,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Aplikasi Point Of Sale");
		getContentPane().setLayout(null);
		getContentPane().setBackground(c);
		getContentPane().setFont(dfont);
		
		//home button
		getContentPane().add(home);
		home.setToolTipText("Home");
		home.setBounds(0, 0, 100, 100);
		home.setOpaque(false);
		home.setFocusPainted(false);
		home.setContentAreaFilled(false);
		home.setBorder(null);
		home.setIcon(new ImageIcon("images/1/home.png"));
		home.setRolloverIcon(new ImageIcon("images/2/home.png"));
		home.setPressedIcon(new ImageIcon("images/3/home.png"));

		//pay button
		getContentPane().add(pay);
		pay.setToolTipText("Bayar");
		pay.setBounds(0, 100, 100, 100);
		pay.setOpaque(false);
		pay.setFocusPainted(false);
		pay.setContentAreaFilled(false);
		pay.setBorder(null);
		pay.setIcon(new ImageIcon("images/1/pay.png"));
		pay.setRolloverIcon(new ImageIcon("images/2/pay.png"));
		pay.setPressedIcon(new ImageIcon("images/3/pay.png"));
		//getContentPane().add(appName);
		//appName.setBounds(0,0,75,75);
		pay.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				kasirScreen ah = new kasirScreen();
				ah.kom();
				dispose();
			}
			
		});
		
		//stock button
		getContentPane().add(stock);
		stock.setBounds(0, 200, 100, 100);
		stock.setOpaque(false);
		stock.setFocusPainted(false);
		stock.setContentAreaFilled(false);
		stock.setBorder(null);
		stock.setIcon(new ImageIcon("images/1/chart.png"));
		stock.setRolloverIcon(new ImageIcon("images/2/chart.png"));
		stock.setPressedIcon(new ImageIcon("images/3/chart.png"));

		
		//report button
		getContentPane().add(report);
		report.setBounds(0, 300, 100, 100);
		report.setOpaque(false);
		report.setFocusPainted(false);
		report.setContentAreaFilled(false);
		report.setBorder(null);
		report.setIcon(new ImageIcon("images/1/report.png"));
		report.setRolloverIcon(new ImageIcon("images/2/report.png"));
		report.setPressedIcon(new ImageIcon("images/3/report.png"));

		
		//setting button
	/*	getContentPane().add(setting);
		setting.setBounds(0, 400, 100, 100);
		setting.setOpaque(false);
		setting.setFocusPainted(false);
		setting.setContentAreaFilled(false);
		setting.setBorder(null);
		setting.setIcon(new ImageIcon("images/1/setting.png"));
		setting.setRolloverIcon(new ImageIcon("images/2/setting.png"));
		setting.setPressedIcon(new ImageIcon("images/3/setting.png"));*/
		
		//quit button
		getContentPane().add(quit);
		quit.setBounds(0, 570, 100, 100);
		quit.setOpaque(false);
		quit.setFocusPainted(false);
		quit.setContentAreaFilled(false);
		quit.setBorder(null);
		quit.setIcon(new ImageIcon("images/1/power-off.png"));
		quit.setRolloverIcon(new ImageIcon("images/2/power-off.png"));
		quit.setPressedIcon(new ImageIcon("images/3/power-off.png"));
		quit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
		});
		
		
		getContentPane().add(namaAplikasi);
		namaAplikasi.setBounds(550,10,300,45);
		namaAplikasi.setFont(new Font("Lobster 1.4", Font.TRUETYPE_FONT, 30));
		namaAplikasi.setForeground(Color.BLACK);
		

		
		getContentPane().add(bgButt);
		bgButt.setBounds(-20, 0, 130, 700);
		
		//getContentPane().add(bg);
		//bg.setBounds(0, 0, 1200, 700);
		
		getContentPane().add(info);
		info.setAlignmentX(CENTER_ALIGNMENT);;
		info.setBounds(350,70,600,100);
	
	}
	
	public static void main(String[] args) {
		homeScreen home= new homeScreen();
		
		
	}
}
