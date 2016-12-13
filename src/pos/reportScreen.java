package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class reportScreen extends JFrame{
	
	
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
	
	JLabel namaAplikasi= new JLabel("Halaman Laporan");
	JLabel tblScreen= new JLabel(new ImageIcon("images/table.png"));
	JLabel bgButt= new JLabel(new ImageIcon("images/bgButt.png"));
	Font dfont = new Font("Roboto", Font.TRUETYPE_FONT, 12);
	String hostname = "Unknown";
	
	// kasir screen
	JLabel ldari = new JLabel("Dari");
	JLabel lsampai = new JLabel("Sampai");
	JLabel lkodebarang = new JLabel("Kode Barang");
	JLabel totalharga = new JLabel("Total");
	JLabel bayar = new JLabel("Bayar");
	JLabel kembalian= new JLabel("Kembali");
	
	
	JTextField txdari= new JTextField();
	JTextField txsampai= new JTextField();
	JTextField txKoderang= new JTextField();
	JTextField txTotal= new JTextField();
	JTextField  txBayar =new JTextField();
	JTextField  txkembalian= new JTextField();	
	
	JButton cBarang= new JButton("...");
	JButton tampilkan=new JButton("Tampilkan",new ImageIcon("images/save.png"));
	JButton flatbut= new JButton("Bayar",new ImageIcon("images/btc.png"));
	JButton flatcancel= new JButton("Reset",new ImageIcon("images/cancel.png"));
	JButton flatBaru= new JButton("Baru",new ImageIcon("images/new.png"));
	JButton flatPrint= new JButton("Print",new ImageIcon("images/print.png"));
	
	
	// Tabel tabel 
	String header [] = {"No","Tanggal","Invoice","Total","Bayar","Kembali"};
	String data [][] = {{"1",dateFormat.format(date),getInpoice(),"23000","25000","3000"},
						{"2",dateFormat.format(date),getInpoice(),"10","5000","50000"},
						{"3",dateFormat.format(date),getInpoice(),"3","1200","50200"}
	};
	
	DefaultTableModel model = new DefaultTableModel(data,header);
	JTable table = new JTable(model);
	
	JScrollPane pane = new JScrollPane(table);
	TableColumn tc1 = new TableColumn();
	TableColumn tc2 = new TableColumn();;
	TableColumn tc3 = new TableColumn();
	TableColumn tc4 = new TableColumn();
	TableColumn tc5 = new TableColumn();
	TableColumn tc6 = new TableColumn();
	
	Dimension dim = new Dimension(15, 2);
	
	//end tabel
	
	public reportScreen() {
		setSize(1200,700);
		setLocation(65,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Aplikasi Point Of Sale");

	}
	
	public String getInpoice(){
		String head = "INV/";
		String teng = idateFormat.format(date);
		String inv= head+teng;
		return inv;
	}
	public void setInpoice(String i){
		this.inv=i;
	}
	void setTinggi(JTable table){
		int tinggi = table.getRowHeight();
		table.setRowHeight(tinggi+15);
	}
	void kom(){
		
		getContentPane().setLayout(null);
		getContentPane().setBackground(c);
		getContentPane().setFont(dfont);
		
		
		//kasir coy
		getContentPane().add(ldari);
		getContentPane().add(lsampai);
		getContentPane().add(lkodebarang);
		getContentPane().add(txdari);
		getContentPane().add(txsampai);
		getContentPane().add(txKoderang);
		getContentPane().add(cBarang);
		getContentPane().add(flatbut);
		getContentPane().add(flatBaru);
		getContentPane().add(tampilkan);
		getContentPane().add(flatcancel);
		getContentPane().add(flatPrint);
		getContentPane().add(pane);
		getContentPane().add(opsi);
		getContentPane().add(lpil);

		//tabel
		pane.setBounds(250, 150, 800, 420);
		table.setShowGrid(true);
		table.setShowVerticalLines(true);
		table.setIntercellSpacing(new Dimension(dim));
		table.setGridColor(d);
		table.setEnabled(false);;
		setTinggi(table);
		tc1 = table.getColumnModel().getColumn(0);
		tc2 = table.getColumnModel().getColumn(1);
		tc3 = table.getColumnModel().getColumn(2);
		tc4 = table.getColumnModel().getColumn(3);
		tc5 = table.getColumnModel().getColumn(4);
		tc6 = table.getColumnModel().getColumn(5);
		
		
		//end tabel
		
		//method setTinggi()
		
		
		ldari.setBounds(200, 100, 80, 25);
		txdari.setBounds(250, 100, 200, 25);
		txdari.setBorder(null);
	
		//txidTransaksi.setText(getInpoice());
		txdari.setHorizontalAlignment(JTextField.CENTER);
		lsampai.setBounds(500, 100, 80, 25);
		txsampai.setBounds(560, 100, 200, 25);
		txsampai.setBorder(null);
		//txTgl.setText(dateFormat.format(date));
		txsampai.setAlignmentX(CENTER_ALIGNMENT);
		txsampai.setHorizontalAlignment(JTextField.CENTER);
		
		tampilkan.setBounds(940, 600, 100, 30);
		tampilkan.setForeground(Color.WHITE);
		tampilkan.setBackground(d);
		tampilkan.setBorder(null);
		tampilkan.setBorderPainted(false);
		tampilkan.setFocusPainted(false);
		
		flatcancel.setBounds(830, 600, 100, 30);
		flatcancel.setForeground(Color.WHITE);
		flatcancel.setBackground(d);
		flatcancel.setBorder(null);
		flatcancel.setBorderPainted(false);
		flatcancel.setFocusPainted(false);
		
		flatPrint.setBounds(720, 600, 100, 30);
		flatPrint.setForeground(Color.WHITE);
		flatPrint.setBackground(d);
		flatPrint.setBorder(null);
		flatPrint.setBorderPainted(false);
		flatPrint.setFocusPainted(false);
		
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
		report.setIcon(new ImageIcon("images/1/report-a.png"));
		report.setRolloverIcon(new ImageIcon("images/2/report.png"));
		report.setPressedIcon(new ImageIcon("images/3/report.png"));
		
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
		
	
	}
	public void act(){
		tampilkan.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
		
						
							String d = txsampai.getText();
							String s = txdari.getText();
							try {
								Class.forName("com.mysql.jdbc.Driver");
								Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
								Statement statement = connection.createStatement();
								String sql = "select * from barang WHERE tgl >='"+d+"' AND tgl <='"+s+"'";
								ResultSet rs= statement.executeQuery(sql);
									while(rs.next()){
										Object obj []=new Object[8];
										obj [0] = rs.getString(1);
										obj [1] = rs.getString(2);
										obj [2] = rs.getString(3);
										obj [3] = rs.getString(4);
										obj [4] = rs.getString(5);
										obj [5] = rs.getString(7);
										obj [6] = rs.getString(8);					
										model.addRow(obj);
									}
								}catch (Exception e) {
									System.out.println(e);
							}
							
					/*		String d = dari.getText();
							String s = sampai.getText();
							String sql = "select * from penjualan WHERE tgl >='"+d+"' AND tgl <='"+s+"'";
							System.out.println("select * from Penjualan");
					*/	}
					
				});
		}
	
	public static void main(String[] args) {
		reportScreen anu = new reportScreen();
		anu.kom();
		anu.act();
	}
}
