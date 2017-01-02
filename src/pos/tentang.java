package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.PrintJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class tentang extends JFrame{
	
	
	//opsi
	String pil[]={"Barang","Penjualan"};
	JComboBox opsi = new JComboBox(pil);
	JLabel lpil= new JLabel("Tipe Laporan"); 
	
	//date 
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	DateFormat idateFormat = new SimpleDateFormat("ddMMyyyy/HHmm");
	Date date = new Date();
	String inv="";
	//end date
	
	Color c = new Color(243, 156, 18);
	Color d = new Color(127, 140, 141);
	
	JButton home= new JButton();
	JButton pay = new JButton();
	JButton stock = new JButton();
	JButton report = new JButton();
	JButton setting= new JButton();
	JButton quit= new JButton();
	
	JLabel bg = new JLabel(new ImageIcon("images/bg.jpg"));
	
	JLabel namaAplikasi= new JLabel("Tentang");
	JLabel desAplikasi= new JLabel("Deskripsi Aplikasi");
	JLabel najir= new JLabel("Nama ");
	JLabel ajir = new JLabel(":  Ahd Muhajir");
	JLabel lttl = new JLabel("TTL");
	JLabel ttl = new JLabel(":  Aceh Barat, 11-April-1997");
	JLabel lhp = new JLabel("No. HP");
	JLabel hp = new JLabel(":  085358484618");
	JLabel lemail = new JLabel("Email");
	JLabel email = new JLabel(":  cnahmad59@gmail.com");

	JLabel tblScreen= new JLabel(new ImageIcon("images/table.png"));
	JLabel bgButt= new JLabel(new ImageIcon("images/bgButt.png"));
	Font dfont = new Font("Roboto", Font.TRUETYPE_FONT, 12);
	Font oo = new Font("Roboto", Font.BOLD, 16);
	Font ooo = new Font("Arial", Font.TRUETYPE_FONT, 14);
	String hostname = "Unknown";
	JLabel ldeskripsiaplikasiyangsudahdibuatuntukpemogramanjavavisual= new JLabel("<html><p align='center'>Point of sales (POS) atau yang biasa kita sebut sebagai sistem kasir merupakan sebuah progam khusus yang digunakan untuk mempermudah transaksi penjualan yang dibutuhkan oleh pengusaha toko maupun restoran.  Pada awalnya, point of sales digunakan sebagai sebutan untuk mesin kasir (Cash Register) namun,dalam perkembangannya istilah point of sale atau POS di¬nilai kurang tepat jika diasosiasikan dengan Cash Register karena Cash Register sendiri sebenarnya kalkulator yang dilengkapi dengan laci otomatis.  Sedangkan Point of Sales (POS) lebih tepat dikatakan sebagai sebuah software pengganti mesin kasir yang lebih canggih.  Point of Sales (POS)  konvensional yang berupa software yang diinstalkan ke sebuah computer.</p></html>");
	
	// kasir screen
	JLabel lfoto = new JLabel(new ImageIcon("images/osas.jpg"));
	
	 
	
	public tentang() {
		setSize(1200,700);
		setLocation(65,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Aplikasi Point Of Sale");
		

	}
	
	void kom(){
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(c);
		getContentPane().setFont(dfont);
		
				//end tabel
		
		//method setTinggi()
		getContentPane().add(desAplikasi);
		getContentPane().add(ldeskripsiaplikasiyangsudahdibuatuntukpemogramanjavavisual);
		getContentPane().add(lfoto);
		getContentPane().add(najir);
		getContentPane().add(ajir);
		getContentPane().add(lttl);
		getContentPane().add(ttl);
		getContentPane().add(lhp);
		getContentPane().add(hp);
		getContentPane().add(lemail);
		getContentPane().add(email);
		lfoto.setBounds(120,100,200,250);
		desAplikasi.setBounds(550,360,300,45);
		desAplikasi.setFont(new Font("Lobster 1.4", Font.TRUETYPE_FONT, 20));
		desAplikasi.setForeground(Color.BLACK);
		
		ldeskripsiaplikasiyangsudahdibuatuntukpemogramanjavavisual.setBounds(300, 350, 700, 300);
		ldeskripsiaplikasiyangsudahdibuatuntukpemogramanjavavisual.setFont(ooo);
		najir.setBounds(360,100,100,30);
		najir.setFont(oo);
		ajir.setBounds(460,100,200,30);
		ajir.setFont(oo);
		lttl.setBounds(360,150,100,30);
		lttl.setFont(oo);
		ttl.setBounds(460,150,300,30);
		ttl.setFont(oo);
		lhp.setBounds(360,200,200,30);
		lhp.setFont(oo);
		hp.setBounds(460,200,200,30);
		hp.setFont(oo);
		lemail.setBounds(360,250,200,30);
		lemail.setFont(oo);
		email.setBounds(460,250,200,30);
		email.setFont(oo);
		
		//pay button
		getContentPane().add(pay);
		pay.setToolTipText("Bayar");
		pay.setBounds(0, 0, 100, 100);
		pay.setOpaque(false);
		pay.setFocusPainted(false);
		pay.setContentAreaFilled(false);
		pay.setBorder(null);
		pay.setIcon(new ImageIcon("images/1/pay.png"));
		pay.setRolloverIcon(new ImageIcon("images/2/pay.png"));
		pay.setPressedIcon(new ImageIcon("images/3/pay.png"));
		pay.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				kasirScreen ah = new kasirScreen();
				ah.kom();
				ah.act();
				dispose();
			}
			
		});
		//getContentPane().add(appName);
		//appName.setBounds(0,0,75,75);
		
		//stock button
		getContentPane().add(stock);
		stock.setBounds(0, 100, 100, 100);
		stock.setOpaque(false);
		stock.setFocusPainted(false);
		stock.setContentAreaFilled(false);
		stock.setBorder(null);
		stock.setIcon(new ImageIcon("images/1/chart.png"));
		stock.setRolloverIcon(new ImageIcon("images/2/chart.png"));
		stock.setPressedIcon(new ImageIcon("images/3/chart.png"));
		stock.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				dataBarang ah = new dataBarang();
				ah.komponenVisual();
				ah.action();
				dispose();
			}
			
		});
		
		//report button
		getContentPane().add(report);
		report.setBounds(0, 200, 100, 100);
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
				reportScreen ad= new reportScreen();
				ad.kom();
				ad.act();
				dispose();
			}
			
		});
		
		//tentang
		getContentPane().add(setting);
		setting.setBounds(0, 300, 100, 100);
		setting.setOpaque(false);
		setting.setFocusPainted(false);
		setting.setContentAreaFilled(false);
		setting.setBorder(null);
		setting.setIcon(new ImageIcon("images/1/setting.png"));
		setting.setRolloverIcon(new ImageIcon("images/2/setting.png"));
		setting.setPressedIcon(new ImageIcon("images/3/setting.png"));
		
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
		
	
	}
	public static void main(String[] args) {
		tentang anu = new tentang();
		anu.kom();
	}
}
