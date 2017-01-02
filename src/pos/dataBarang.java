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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class dataBarang extends JFrame{
		JLabel lkdbarang = new JLabel("KD Barang");
		JLabel lnmbarang = new JLabel("Nama Barang");
		JLabel lhrgjual = new JLabel("Harga Jual (Rp.)");
		JLabel lhrgbeli= new JLabel("Harga Beli (Rp.)");
		JLabel lstock = new JLabel("Stock");
		JLabel lsuplier = new JLabel("Suplier");
		JLabel ket = new JLabel("Keterangan");
		JLabel cari = new JLabel(new ImageIcon("images/search.png"));
		JLabel print = new JLabel(new ImageIcon("images/print.png"));
		
		JTextField kdbarang = new JTextField();
		JTextField nmbarang = new JTextField();
		JTextField hrgjual = new JTextField();
		JTextField hrgbeli = new JTextField();
		JTextField stokbrang = new JTextField();
		JTextField suplier = new JTextField();
		JTextArea txKet = new JTextArea(3,20);
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
		
		JLabel namaAplikasi= new JLabel("Halaman Data Barang");
		JLabel tblScreen= new JLabel(new ImageIcon("images/table.png"));
		JLabel bgButt= new JLabel(new ImageIcon("images/bgButt.png"));
		Font dfont = new Font("Roboto", Font.TRUETYPE_FONT, 12);
		String hostname = "Unknown";
		
		// kasir screen
		JLabel lidTransaksi = new JLabel("Invoice");
		JLabel ltgl = new JLabel("Tanggal");
		JLabel lkodebarang = new JLabel("Kode Barang");
		JLabel totalharga = new JLabel("");
		
		JTextField txidTransaksi= new JTextField();
		JTextField txTgl= new JTextField();
		JTextField txKoderang= new JTextField();
		
		
		JButton cBarang= new JButton("...");
		JButton hapus=new JButton("Hapus",new ImageIcon("images/save.png"));
		JButton flatbut= new JButton("Bayar",new ImageIcon("images/btc.png"));
		JButton batal= new JButton("Reset",new ImageIcon("images/cancel.png"));
		JButton edit= new JButton("Edit",new ImageIcon("images/new.png"));
		JButton save= new JButton("Tambah",new ImageIcon("images/print.pngg"));
		
		
		// Tabel tabel 
		String header [] = {"Kode Barang","Nama Barang","Harga Jual","Harga Beli","Stock","Suplier","Ket","Untung"};
		
		
		DefaultTableModel model = new DefaultTableModel(null,header);
		JTable table = new JTable(model);
		
		JScrollPane pane = new JScrollPane(table);
		TableColumn tc1 = new TableColumn();
		TableColumn tc2 = new TableColumn();;
		TableColumn tc3 = new TableColumn();
		TableColumn tc4 = new TableColumn();
		TableColumn tc5 = new TableColumn();
		TableColumn tc6 = new TableColumn();
		TableColumn tc7 = new TableColumn();
		TableColumn tc8 = new TableColumn();
		
		Dimension dim = new Dimension(15, 2);
		
		//end tabel
		
	 public dataBarang() {
			setSize(1200,700);
			setLocation(65,35);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//setResizable(false);
			setVisible(true);
			setTitle("Halaman Data Barang");
			tampilTabel();

		}
		public void action(){
			print.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					cetakHasil();
				}
				
			});
			cari.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent a) {
					String kb= kdbarang.getText();
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
						Statement st = con.createStatement();
						String sql= "select * from barang where kodebarang='"+kb+"'";
						ResultSet rs= st.executeQuery(sql);
						
						if(rs.next()){
							nmbarang.setText(rs.getString(2));
							hrgjual.setText(rs.getString(3));
							hrgbeli.setText(rs.getString(4));
							stokbrang.setText(rs.getString(5));
							suplier.setText(rs.getString(7));
							txKet.setText(rs.getString(8));
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.INFORMATION_MESSAGE);
					}
				}
				
			});
			
			
			batal.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent as) {
					bersihData();
					
				}
			});
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(d);
					try {
						Class.forName("com.mysql.jdbc.Driver").newInstance();
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
						String sql = "insert into barang values(?,?,?,?,?,?,?,?,?)";
						PreparedStatement pr = connection.prepareStatement(sql);
						pr.setString(1, kdbarang.getText());
						pr.setString(2, nmbarang.getText());
						pr.setString(3, hrgjual.getText());
						pr.setString(4, hrgbeli.getText());
						pr.setString(5, stokbrang.getText());
						pr.setString(6, txTgl.getText());
						pr.setString(7, suplier.getText());
						pr.setString(8, txKet.getText());
						int a =Integer.parseInt(hrgjual.getText());
						int b =Integer.parseInt(hrgbeli.getText());
						int c =Integer.parseInt(stokbrang.getText());
						pr.setString(9,String.valueOf((a-b)*c));
						pr.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Berhasil di Input","Pesan",JOptionPane.INFORMATION_MESSAGE);
						tampilTabel();
						bersihData();
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null,ex,"Error",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}
			});
			edit.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent aaa) {
					if(aaa.getSource()==edit){
						try {
							Class.forName("com.mysql.jdbc.Driver").newInstance();
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
							String sql = "update barang set namabarang=?, hrgjual=?, hrgbeli=?, stock=?, tgl=?, suplier=?,ket=?,untung=? where kodebarang=?";
							PreparedStatement pr = connection.prepareStatement(sql);
							pr.setString(1, nmbarang.getText());
							pr.setString(2, hrgjual.getText());
							pr.setString(3, hrgbeli.getText());
							pr.setString(4, stokbrang.getText());
							pr.setString(5, txTgl.getText());
							pr.setString(6, suplier.getText());
							pr.setString(7, txKet.getText());
							int a =Integer.parseInt(hrgjual.getText());
							int b =Integer.parseInt(hrgbeli.getText());
							int c =Integer.parseInt(stokbrang.getText());
							pr.setString(8,String.valueOf(a));
							pr.setString(9, kdbarang.getText());
							

							pr.executeUpdate();
							pr.close();
							connection.close();
							tampilTabel();
							bersihData();
							JOptionPane.showMessageDialog(null, "Data Sudah Diupdate","Konfirmasi",JOptionPane.INFORMATION_MESSAGE);
							
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			});
			hapus.addActionListener(new ActionListener()
			{
				public void actionPerformed (ActionEvent e)				{
					String kb=kdbarang.getText();
					int tanya = JOptionPane.showConfirmDialog(null,"Anda ingin Menghapus Data Barang "+kb+"?","Konfirmasi",JOptionPane.YES_NO_OPTION);
					{
						try{
							Class.forName("com.mysql.jdbc.Driver");
							Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root", "");
							String sql="DELETE FROM barang WHERE kodebarang=?";
							PreparedStatement pr = koneksi.prepareStatement(sql);
							pr.setString(1,kb);
							pr.executeUpdate();
							pr.close();
							koneksi.close();
							JOptionPane.showMessageDialog(null,"Data telah dihapus");
							tampilTabel(); //ambil data di void tampilTabel()
							bersihData();
						}
						catch (Exception ex){
							JOptionPane.showMessageDialog(null,"Error :"+ex,"Error",JOptionPane.ERROR_MESSAGE);
							} 
						} 
					} 
				} );
		}
		public void bersihData(){
			kdbarang.setText("");
			nmbarang.setText("");
			hrgjual.setText("");
			hrgbeli.setText("");
			stokbrang.setText("");
			suplier.setText("");
			txKet.setText("");
		}
		public void hapusTable(){
			int row =model.getRowCount();
			for (int i = 0; i < row; i++) {
				model.removeRow(0);
			}
		}
		public void tampilTabel(){
			hapusTable();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/ajirpos","root","");
				Statement statement = connection.createStatement();
				String sql = "select * from barang";
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
					obj [7] = rs.getString(9);
					model.addRow(obj);
					
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		public String getInpoice(){
			String head = "INV/";
			String teng = idateFormat.format(date);
			String inv= head+teng;
			return inv;
		}
		
		void setTinggi(JTable table){
			int tinggi = table.getRowHeight();
			table.setRowHeight(tinggi+15);
		}
		void komponenVisual(){
			
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
			getContentPane().add(edit);
			getContentPane().add(hapus);
			getContentPane().add(batal);
			getContentPane().add(save);
			getContentPane().add(pane);
			getContentPane().add(lsuplier);
			getContentPane().add(suplier);
			getContentPane().add(ket);
			getContentPane().add(txKet);
			getContentPane().add(lkdbarang);
			getContentPane().add(lnmbarang);
			getContentPane().add(lhrgjual);
			getContentPane().add(lhrgbeli);
			getContentPane().add(lstock);
			getContentPane().add(kdbarang);
			getContentPane().add(nmbarang);
			getContentPane().add(hrgjual);
			getContentPane().add(hrgbeli);
			getContentPane().add(stokbrang);
			getContentPane().add(cari);
			getContentPane().add(print);
			
			lkodebarang.setBounds(200, 70, 100, 20);
			lnmbarang.setBounds(200, 110, 100, 20);
			lhrgjual.setBounds(200, 150, 100, 20);
			lhrgbeli.setBounds(200, 190, 100, 20);
			lstock.setBounds(200, 230, 100, 20);
			kdbarang.setBounds(400, 70, 200, 25);
			cari.setBounds(610, 70, 30, 25);
			nmbarang.setBounds(400, 110, 200, 25);
			hrgjual.setBounds(400, 150, 200, 25);
			hrgbeli.setBounds(400, 190, 200, 25);
			stokbrang.setBounds(400, 230, 200, 25);
			print.setBounds(970, 270, 30, 30);
			
			kdbarang.setBorder(null);
			nmbarang.setBorder(null);
			hrgjual.setBorder(null);
			hrgbeli.setBorder(null);
			stokbrang.setBorder(null);
			//tabel
			pane.setBounds(200, 300, 800, 250);
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
			tc7 = table.getColumnModel().getColumn(6);
			
			
			ltgl.setBounds(700, 70, 100, 20);
			txTgl.setBounds(800, 70, 200, 25);
			txTgl.setBorder(null);
			txTgl.setText(dateFormat.format(date));
			txTgl.setEditable(false);
			txTgl.setAlignmentX(CENTER_ALIGNMENT);
			txTgl.setHorizontalAlignment(JTextField.CENTER);
			
			lsuplier.setBounds(700, 110, 100, 20);
			suplier.setBounds(800, 110, 200, 25);
			suplier.setBorder(null);
			
			ket.setBounds(700, 150, 100, 20);
			txKet.setBounds(800, 150,200, 106);
			txKet.setBorder(null);
			txKet.setWrapStyleWord(true);
			txKet.setLineWrap(true);
			
			hapus.setBounds(900, 600, 100, 30);
			hapus.setForeground(Color.WHITE);
			hapus.setBackground(d);
			hapus.setBorder(null);
			hapus.setBorderPainted(false);
			hapus.setFocusPainted(false);
			
			batal.setBounds(790, 600, 100, 30);
			batal.setForeground(Color.WHITE);
			batal.setBackground(d);
			batal.setBorder(null);
			batal.setBorderPainted(false);
			batal.setFocusPainted(false);
			
			edit.setBounds(680, 600, 100, 30);
			edit.setForeground(Color.WHITE);
			edit.setBackground(d);
			edit.setBorder(null);
			edit.setBorderPainted(false);
			edit.setFocusPainted(false);
			
			save.setBounds(570, 600, 100, 30);
			save.setForeground(Color.WHITE);
			save.setBackground(d);
			save.setBorder(null);
			save.setBorderPainted(false);
			save.setFocusPainted(false);

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
			
			//stock button
			getContentPane().add(stock);
			stock.setBounds(0, 100, 100, 100);
			stock.setOpaque(false);
			stock.setFocusPainted(false);
			stock.setContentAreaFilled(false);
			stock.setBorder(null);
			stock.setIcon(new ImageIcon("images/1/chart-a.png"));
			stock.setRolloverIcon(new ImageIcon("images/2/chart.png"));
			stock.setPressedIcon(new ImageIcon("images/3/chart.png"));
			
			
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
			//about
			getContentPane().add(setting);
			setting.setBounds(0, 300, 100, 100);
			setting.setOpaque(false);
			setting.setFocusPainted(false);
			setting.setContentAreaFilled(false);
			setting.setBorder(null);
			setting.setIcon(new ImageIcon("images/1/setting.png"));
			setting.setRolloverIcon(new ImageIcon("images/2/setting.png"));
			setting.setPressedIcon(new ImageIcon("images/3/setting.png"));
			setting.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					tentang ad= new tentang();
					ad.kom();
					dispose();
				}
				
			});
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
			namaAplikasi.setBounds(450,10,300,45);
			namaAplikasi.setFont(new Font("Lobster 1.4", Font.TRUETYPE_FONT, 30));
			namaAplikasi.setForeground(Color.BLACK);
			

			
			getContentPane().add(bgButt);
			bgButt.setBounds(-20, 0, 130, 700);
			
			//getContentPane().add(bg);
			//bg.setBounds(0, 0, 1200, 700);
			
		
		}
		void cetakHasil(){
			int y=0;
			Frame fr= new Frame();
			PrintJob printerJob=fr.getToolkit().getPrintJob(fr,"Printing",null,null);
			if(printerJob!=null){
				Graphics g = printerJob.getGraphics();
				if(g != null){
					Image image = new ImageIcon("Gambar/logo.png").getImage();
					g.setFont(new Font("Dialog", 1, 11));
					g.drawString("LAPORAN STOCK BARANG", 200, 40);
					g.setFont(new Font("Dialog", 1, 10));
					g.drawString("UD. MAJU MUNDUR", 220, 50);
					g.setFont(new Font("Dialog", 1, 9));
					g.drawString(date.toString(), 210, 60);
					
					//untukk NAMA KOLOM TABEL
					String kodebarang = table.getColumnName(0);
					String namabarang=table.getColumnName(1);
					String hrgjual= table.getColumnName(2);
					String hrgbeli=table.getColumnName(3);
					String stock= table.getColumnName(4);
					String suplier=table.getColumnName(5);
					String ket=table.getColumnName(6);
					
					g.setFont(new Font("Dialog", 1, 8));
					g.drawString(kodebarang, 30, 100);
					g.drawString(namabarang, 100, 100);
					g.drawString(hrgjual, 280, 100);
					g.drawString(hrgbeli, 330, 100);
					g.drawString(stock, 400, 100);
					g.drawString(suplier, 470, 100);
					g.drawString(ket, 510, 100);
					g.drawLine(30, 103, 550, 103);
					
					//untuk data tabel
					int n = model.getRowCount();
					for (int i = 0; i < n; i++) {
						int k =i+2;
						int j=10*k;
						y = 100+j;
						g.setFont(new Font("Dialog", 0, 8));
						String v1= model.getValueAt(i, 0).toString();
						String v2=model.getValueAt(i, 1).toString();
						String v3= model.getValueAt(i, 2).toString();
						String v4 = model.getValueAt(i, 3).toString();
						String v5=model.getValueAt(i, 4).toString();
						String v6= model.getValueAt(i, 5).toString();
						String v7= model.getValueAt(i, 6).toString();
						
						g.drawString(v1, 30, y);
						g.drawString(v2, 100, y);
						g.drawString(v3, 280, y);
						g.drawString(v4, 330, y);
						g.drawString(v5, 400, y);
						g.drawString(v6, 470, y);
						g.drawString(v7, 510, y);

					}
					
				}
				printerJob.end();
				printerJob.end();
			}
		}
	public static void main(String[] args) {
		dataBarang ib = new dataBarang();
		ib.komponenVisual();
		ib.action();

		
	}

}
