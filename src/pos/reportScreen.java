package pos;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class reportScreen extends JFrame{
	Color c = new Color(243, 156, 18);
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
	
	public static void main(String[] args) {

	}

}
