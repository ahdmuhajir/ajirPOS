package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class dataBarang extends JFrame{
		JLabel lkdbarang = new JLabel("KD Barang");
		JLabel lnmbarang = new JLabel("Nama Barang");
		JLabel lhrgjual = new JLabel("Harga Jual (Rp.)");
		JLabel lhrgbeli= new JLabel("Harga Beli (Rp.)");
		JLabel lstock = new JLabel("Stock");
		
		JTextField kdbarang = new JTextField();
		JTextField nmbarang = new JTextField();
		JTextField hrgjual = new JTextField();
		JTextField hrgbeli = new JTextField();
		JTextField stokbrang = new JTextField();
		
		void idatabarang(){
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
			
			lkodebarang.setBounds(200, 70, 100, 20);
			lnmbarang.setBounds(200, 110, 100, 20);
			lhrgjual.setBounds(200, 150, 100, 20);
			lhrgbeli.setBounds(200, 190, 100, 20);
			lstock.setBounds(200, 230, 100, 20);
			kdbarang.setBounds(400, 70, 200, 25);
			nmbarang.setBounds(400, 110, 200, 25);
			hrgjual.setBounds(400, 150, 200, 25);
			hrgbeli.setBounds(400, 190, 200, 25);
			stokbrang.setBounds(400, 230, 200, 25);
			
			kdbarang.setBorder(null);
			nmbarang.setBorder(null);
			hrgjual.setBorder(null);
			hrgbeli.setBorder(null);
			stokbrang.setBorder(null);
			
			
		}
	
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
		JButton flatSave=new JButton("Simpan",new ImageIcon("images/save.png"));
		JButton flatbut= new JButton("Bayar",new ImageIcon("images/btc.png"));
		JButton flatcancel= new JButton("Reset",new ImageIcon("images/cancel.png"));
		JButton flatBaru= new JButton("Baru",new ImageIcon("images/new.png"));
		JButton flatPrint= new JButton("Print",new ImageIcon("images/print.png"));
		
		
		// Tabel tabel 
		String header [] = {"No","Kode Barang","Nama Barang","Harga Jual","Harga Beli","Stock"};
		String data [][] = {{"1","009421","Aqua","11000","10000","100"},
							{"2","039124","Kecap","12000","1000","120"},
							{"3","009220","mijone","11000","9000","50"},
							{"4","004421","Aqua","11000","10000","100"},
							{"5","039224","indomiw","12000","1000","120"},
							{"6","00220","sarimi","11000","9000","50"},
							{"1","009421","Aqua","11000","10000","100"},
							{"2","039124","Kecap","12000","1000","120"},
							{"3","009220","mijone","11000","9000","50"},
							{"4","004421","Aqua","11000","10000","100"},
							{"5","039224","indomiw","12000","1000","120"},
							{"6","00220","sarimi","11000","9000","50"}
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
		
	 public dataBarang() {
			setSize(1200,700);
			setLocation(65,35);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			setVisible(true);
			setTitle("Halaman Data Barang");

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
			getContentPane().add(flatBaru);
			getContentPane().add(flatSave);
			getContentPane().add(flatcancel);
			getContentPane().add(flatPrint);
			getContentPane().add(pane);
			
			
			//tabel
			pane.setBounds(200, 350, 800, 200);
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
			
			
			/*ltgl.setBounds(500, 100, 80, 25);
			txTgl.setBounds(560, 100, 200, 25);
			txTgl.setBorder(null);
			txTgl.setText(dateFormat.format(date));
			txTgl.setEditable(false);
			txTgl.setAlignmentX(CENTER_ALIGNMENT);
			txTgl.setHorizontalAlignment(JTextField.CENTER);
			*/
			
			/*flatbut.setBounds(1050, 300, 100, 30);
			flatbut.setForeground(Color.WHITE);
			flatbut.setBackground(d);
			flatbut.setBorder(null);
			flatbut.setBorderPainted(false);
			flatbut.setFocusPainted(false);*/
			
			
			flatSave.setBounds(940, 300, 100, 30);
			flatSave.setForeground(Color.WHITE);
			flatSave.setBackground(d);
			flatSave.setBorder(null);
			flatSave.setBorderPainted(false);
			flatSave.setFocusPainted(false);
			
			flatcancel.setBounds(830, 300, 100, 30);
			flatcancel.setForeground(Color.WHITE);
			flatcancel.setBackground(d);
			flatcancel.setBorder(null);
			flatcancel.setBorderPainted(false);
			flatcancel.setFocusPainted(false);
			
			flatBaru.setBounds(720, 300, 100, 30);
			flatBaru.setForeground(Color.WHITE);
			flatBaru.setBackground(d);
			flatBaru.setBorder(null);
			flatBaru.setBorderPainted(false);
			flatBaru.setFocusPainted(false);
			
			flatPrint.setBounds(610, 300, 100, 30);
			flatPrint.setForeground(Color.WHITE);
			flatPrint.setBackground(d);
			flatPrint.setBorder(null);
			flatPrint.setBorderPainted(false);
			flatPrint.setFocusPainted(false);
			
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
			home.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					homeScreen au = new homeScreen();
					dispose();
				}
				
			});

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
				public void mouseClicked(MouseEvent e) {
					dataBarang ah = new dataBarang();
					ah.komponenVisual();
					dispose();
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
			
		
		}
	public static void main(String[] args) {
		dataBarang ib = new dataBarang();
		ib.komponenVisual();
		ib.idatabarang();
		
	}

}
