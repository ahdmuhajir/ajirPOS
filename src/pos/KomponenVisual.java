package pos;

import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class KomponenVisual extends JFrame {
	JLabel appName= new JLabel(new ImageIcon("images/logo-small2.png"));
	Color c = new Color(243, 156, 18);
	JLabel iventory = new JLabel(new ImageIcon("images/button/inventory.png"));
	JLabel iventoryh = new JLabel(new ImageIcon("images/button/inventory-hover.png"));
	
	// for login pane
	JLabel luname= new JLabel("User Name :");
	JLabel lpass= new JLabel("Password   :");
	JTextField uname= new JTextField();
	JPasswordField pass= new JPasswordField();
	JButton login = new JButton("Login");
	JButton cancel= new JButton("Cancel");
	
	//end login pane
	//for input barang
	JLabel idBarang = new JLabel("Id Barang");
	JLabel namaBarang = new JLabel("Nama Barang");
	JLabel hargaBarang = new JLabel("Harga");
	JLabel jumlahBarang = new JLabel("Jumlah");
	JLabel stockBarang = new JLabel("Tersedia");
	JLabel satuan=new JLabel("Satuan");
	
	JTextField iidBarang = new JTextField(20);
	JTextField inamaBarang= new JTextField(20);
	JTextField ihargaBarang= new JTextField(20);
	JTextField ijumlahBrang= new JTextField(20);
	JTextField istockBarang= new JTextField(20);
	String asatuan[]= {"Pcs","Lusin","Kodi","Kotak","Kg"};
	JComboBox isatuan = new JComboBox(asatuan);
	
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
	
	JInternalFrame payo = new JInternalFrame("Pembayaran",true,true,false,false);
	JDesktopPane pane = new JDesktopPane();
	
	
	public KomponenVisual(){
		setSize(1200,700);
		setLocation(65,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Aplikasi Point Of Sale");
		getContentPane().setLayout(null);
		//getContentPane().setBackground(c);
		
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
		stock.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				inputBarang(); 
			}
			
		});
		
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
		report.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				reportScreen(); 
			}
			
		});
		
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
		
		
		getContentPane().add(namaAplikasi);
		namaAplikasi.setBounds(550,10,300,45);
		namaAplikasi.setFont(new Font("Lobster 1.4", Font.TRUETYPE_FONT, 30));
		namaAplikasi.setForeground(Color.BLACK);
		
		//table
		//getContentPane().add(tblScreen);
		//tblScreen.setSize(800, 500);
		//tblScreen.setBounds(100, 20, 900, 600);
		
		getContentPane().add(bgButt);
		bgButt.setBounds(-20, 0, 130, 700);
		
		//getContentPane().add(bg);
		//bg.setBounds(0, 0, 1200, 700);
		
		
		
		
	}
	void reportScreen(){
		setTitle("Repor Screen");
		setBackground(Color.RED);
		
	}
	void loginpane(){
		setSize(400,250);
		setLocation(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	void loginpaneComp(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(c);
		getContentPane().add(luname);
		luname.setBounds(20, 30, 80, 25);
		getContentPane().add(uname);
		uname.setBounds(110, 30, 175, 25);
		uname.setBorder(null);
		getContentPane().add(lpass);
		lpass.setBounds(20, 70, 80, 25);
		getContentPane().add(pass);
		pass.setBorder(null);
		pass.setBounds(110, 70, 175, 25);
		getContentPane().add(login);
		login.setBounds(40, 150, 80, 25);
		login.setBorderPainted(isOpaque());
		login.setBorder(null);
		getContentPane().add(cancel);
		cancel.setBounds(150, 150, 80, 25);
		cancel.setBorderPainted(isOpaque());
		cancel.setBorder(null);


			
	}
	
	//for input barang
	void inputBarang(){
		getContentPane().setLayout(null);
		getContentPane().setBackground(c);
		getContentPane().add(idBarang);
		getContentPane().add(iidBarang);
		getContentPane().add(namaBarang);
		getContentPane().add(inamaBarang);
		getContentPane().add(hargaBarang);
		getContentPane().add(ihargaBarang);
		getContentPane().add(jumlahBarang);
		getContentPane().add(ijumlahBrang);
		getContentPane().add(stockBarang);
		getContentPane().add(istockBarang);
		getContentPane().add(satuan);
		getContentPane().add(isatuan);
		idBarang.setBounds(30, 20, 80, 25);
		iidBarang.setBounds(140, 20, 200, 25);
		namaBarang.setBounds(30, 60, 80, 25);
		inamaBarang.setBounds(140, 60, 200, 25);
		hargaBarang.setBounds(30, 100, 80, 25);
		ihargaBarang.setBounds(140, 100, 200, 25);
		jumlahBarang.setBounds(30, 140, 80, 25);
		ijumlahBrang.setBounds(140, 140, 200, 25);
		satuan.setBounds(30, 180, 80, 25);
		isatuan.setBounds(140, 180, 200, 25);
		
	}
	
	void aksiApalah(){
		
		quit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
	}
	
}
