package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class kasirScreen extends JFrame{
	
	JButton add= new JButton(new ImageIcon("images/search.png"));
	
	//date 
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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
	
	JLabel namaAplikasi= new JLabel("Halaman Kasir");
	JLabel tblScreen= new JLabel(new ImageIcon("images/table.png"));
	JLabel bgButt= new JLabel(new ImageIcon("images/bgButt.png"));
	Font dfont = new Font("Roboto", Font.TRUETYPE_FONT, 12);
	String hostname = "Unknown";
	
	// kasir screen
	JLabel lidTransaksi = new JLabel("Invoice");
	JLabel ltgl = new JLabel("Tanggal");
	JLabel lkodebarang = new JLabel("Kd Barang");
	JLabel totalharga = new JLabel("Total");
	JLabel bayar = new JLabel("Bayar");
	JLabel kembalian= new JLabel("Kembali");
	
	
	JTextField txidTransaksi= new JTextField();
	JTextField txTgl= new JTextField();
	JTextField txKoderang= new JTextField();
	JTextField txTotal= new JTextField();
	JTextField  txBayar =new JTextField();
	JTextField  txkembalian= new JTextField();	
	
	JTextField cBarang= new JTextField();
	JButton flatSave=new JButton("Simpan",new ImageIcon("images/save.png"));
	JButton flatbut= new JButton("Bayar",new ImageIcon("images/bbtc.png"));
	JButton flatcancel= new JButton("Reset",new ImageIcon("images/cancel.png"));
	JButton flatBaru= new JButton("Hitung",new ImageIcon("images/new.png"));
	JButton flatPrint= new JButton("Print",new ImageIcon("images/print.png"));
	
	
	// Tabel tabel 
	String header [] = {"Kode Barang","Nama Barang","Jumlah Barang","Harga Satuan","Subtotal"};
	String data [][] ;

	
	DefaultTableModel model = new DefaultTableModel(data,header);
	JTable table = new JTable(model);
	
	JScrollPane pane = new JScrollPane(table);
	TableColumn tc1 = new TableColumn();
	TableColumn tc2 = new TableColumn();;
	TableColumn tc3 = new TableColumn();
	TableColumn tc4 = new TableColumn();
	TableColumn tc5 = new TableColumn();
	
	
	Dimension dim = new Dimension(15, 2);
	
	//end tabel
	
	public kasirScreen() {
		setSize(1200,700);
		setLocation(65,35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		setTitle("Aplikasi Point Of Sale");

	}
	
	public void act(){
		flatSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
					String sql = "insert into penjualan values(?,?,?,?,?)";
					PreparedStatement pr = connection.prepareStatement(sql);
					pr.setString(1, txidTransaksi.getText());
					pr.setString(2, txTgl.getText());
					pr.setString(3, txTotal.getText());
					pr.setString(4, txBayar.getText());
					pr.setString(5, txkembalian.getText());
					pr.executeUpdate();
					JOptionPane.showMessageDialog(null, "Transaksi Berhasil Disimpan","Pesan",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		flatcancel.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent oah) {
				txKoderang.setText("");
				cBarang.setText("");
				txBayar.setText("");
				txTotal.setText("");
				txkembalian.setText("");
				int bbar=model.getRowCount();
				for (int i = bbar-1; i >=0; i--) {
					model.removeRow(i);
				}
				
			}
		});
		flatBaru.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent xx) {
				int x = Integer.parseInt(txBayar.getText())-Integer.parseInt(txTotal.getText());
				txkembalian.setText(x+"");
				
			}
		});
		add.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String c = txKoderang.getText();
				String d= cBarang.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
					Statement statement = connection.createStatement();
					String sql = "select kodebarang,namabarang,hrgjual from barang where kodebarang='"+c+"'";
					ResultSet rs= statement.executeQuery(sql);
					while(rs.next()){
						
						Object obj []=new Object[5];
						obj [0] = rs.getString(1);
						obj [1] = rs.getString(2);
						obj [2] = d;
						obj [3] = rs.getString(3);
						int kal=Integer.parseInt(d)*Integer.valueOf((String) obj[3]);
						obj [4] = kal;					
						model.addRow(obj);
						//int temp=kal;
						int total = 0;
						for (int i = 0; i < table.getRowCount(); i++) {
							
							int Amount = Integer.parseInt(table.getValueAt(i, 4)+"");
					        total = Amount+total;
					        txTotal.setText(Integer.toString(total));
						}
						
					}
				} catch (Exception em) {
					System.out.println(em);
				}
				
			}
		});
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
		getContentPane().add(lidTransaksi);
		getContentPane().add(ltgl);
		getContentPane().add(lkodebarang);
		getContentPane().add(totalharga);
		getContentPane().add(txidTransaksi);
		getContentPane().add(txTgl);
		getContentPane().add(txKoderang);
		getContentPane().add(cBarang);
		getContentPane().add(flatbut);
		getContentPane().add(flatBaru);
		getContentPane().add(flatSave);
		getContentPane().add(flatcancel);
		getContentPane().add(flatPrint);
		getContentPane().add(pane);
		getContentPane().add(bayar);
		getContentPane().add(kembalian);
		getContentPane().add(txTotal);
		getContentPane().add(txBayar);
		getContentPane().add(txkembalian);
		getContentPane().add(add);
		
	
		
		// bayar,total,kembalian
		
		totalharga.setBounds(170, 500, 80, 25);
		txTotal.setBounds(250, 500, 200, 25);
		txTotal.setBorder(null);
		
		bayar.setBounds(490, 500, 80, 25);
		txBayar.setBounds(550, 500, 200, 25);
		txBayar.setBorder(null);
		
		kembalian.setBounds(780, 500, 200, 25);
		txkembalian.setBounds(850, 500, 200, 25);
		txkembalian.setBorder(null);
		// bayar,total,kembalian
		
		//tabel
		pane.setBounds(250, 150, 800, 300);
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

		
		
		//end tabel
		
		//method setTinggi()
		
		
		lidTransaksi.setBounds(170, 100, 80, 25);
		txidTransaksi.setBounds(250, 100, 200, 25);
		txidTransaksi.setBorder(null);
	
		txidTransaksi.setText(getInpoice());
		txidTransaksi.setEditable(false);
		txidTransaksi.setHorizontalAlignment(JTextField.CENTER);
		ltgl.setBounds(490, 100, 80, 25);
		txTgl.setBounds(550, 100, 200, 25);
		txTgl.setBorder(null);
		txTgl.setText(dateFormat.format(date));
		txTgl.setEditable(false);
		lkodebarang.setBounds(780, 100, 80, 25);
		txKoderang.setBounds(850, 100, 200, 25);
		txKoderang.setBorder(null);
		cBarang.setBounds(1060, 100, 50, 25);
		cBarang.setBorder(null);
		txTgl.setAlignmentX(CENTER_ALIGNMENT);
		txTgl.setHorizontalAlignment(JTextField.CENTER);
		add.setBounds(1060, 130, 50, 30);
		
		flatbut.setBounds(940, 600, 100, 30);
		flatbut.setForeground(Color.WHITE);
		flatbut.setBackground(d);
		flatbut.setBorder(null);
		flatbut.setBorderPainted(false);
		flatbut.setFocusPainted(false);
		
		flatSave.setBounds(830, 600, 100, 30);
		flatSave.setForeground(Color.WHITE);
		flatSave.setBackground(d);
		flatSave.setBorder(null);
		flatSave.setBorderPainted(false);
		flatSave.setFocusPainted(false);
		
		flatcancel.setBounds(610, 600, 100, 30);
		flatcancel.setForeground(Color.WHITE);
		flatcancel.setBackground(d);
		flatcancel.setBorder(null);
		flatcancel.setBorderPainted(false);
		flatcancel.setFocusPainted(false);
		
		flatBaru.setBounds(720, 600, 100, 30);
		flatBaru.setForeground(Color.WHITE);
		flatBaru.setBackground(d);
		flatBaru.setBorder(null);
		flatBaru.setBorderPainted(false);
		flatBaru.setFocusPainted(false);
		
		flatPrint.setBounds(1050, 600, 100, 30);
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
		pay.setIcon(new ImageIcon("images/1/pay-a.png"));
		pay.setRolloverIcon(new ImageIcon("images/2/pay.png"));
		pay.setPressedIcon(new ImageIcon("images/3/pay.png"));
		
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
				dispose();
			}
			
		});


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
		
	
	}
	
	
	public static void main(String[] args) {
		kasirScreen anu = new kasirScreen();
		anu.kom();
		anu.act();
		
	}
}
