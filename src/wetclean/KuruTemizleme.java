package wetclean;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Frame;

import java.awt.ScrollPane;
import java.awt.Component;
import java.awt.Window.Type;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import java.util.Calendar;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;


import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.JavaBean;
import javax.swing.Box;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;



public class KuruTemizleme extends JFrame {
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txt_toplam;
	public double toplamfiyat = 0;
	DefaultTableModel modelim = new DefaultTableModel();
	
	Object [] kolonlar = {"T�r","A��klama","Adet","Toplam Fiyat"};
	Object [] sat�rlar = new Object[100];
	
	DefaultTableModel modelim2 = new DefaultTableModel();
	
	Object [] kolonlar1 = {"Makbuz No","Sipari� No","Sipari� Tarihi","Teslim Tarihi","Sipari� Tutar�" };
	Object [] sat�rlar1 = new Object[50];
	
	
	private JTextField �t�;
	private JTextField kuru;
	private JTextField temiz;
	public int ka��nc�sat�r=0;
	public int haf�za1;
	public int haf�za2;
	public String hhaf�za;
	public String hhhaf�za;
	public String kthaf�za,�t�haf�za,temizlemehaf�za;
	public double ktfiyat,�t�fiyat,temizlemefiyat;
	public double ffiyat;
	public String tarih;
	public double haf�zaa = 0.0;
	public double haf�zaaa =0.0;
	public double ckt =0.0;
	public double c� =0.0;
	public String tarihtut=null;
	//VER�TABANI VER�LER�
	public double btkt, bt�, bluzkt, bluz�, ceketkt, ceket�, damatl�kkt, damatl�k�, derimontkt, d�piyeskt,
	d�piyes�, elbisekt, elbise�, etekkt, etek�, gekt, ge�, g�mlekkt, g�mlek�, iekt, ie�, i�kt, i��, kabankt,
	kaban�, kazakkt, kazak�, ibkt, ib�, montkt, mont�, paltokt, palto�, pantolonkt, pantolon�, pardes�kt,
	pardes��, tekt, te�, tren�kotkt, tren�kot�, ti��rtkt, ti��rt�, yelekkt, yelek�, dkm��, skm��, onikikm��,
	nevresim�, yast�k�, y��, alezy, battaniyey, elyafyorgany, kazt�y�yorgany, dkm�y, skm�y, onikikm�y, nevresimy,
	pamukyorgany, yast�ky, yatak�rt�s�y, �ar�afy, cambalkony,gelinliky,t�lperdey,fonperdey,kruvazeperdey,g�ne�liky,
	bstorperdey,istorperdey,�storperdey,bzebraperdey,izebraperdey,�zebraperdey,abiyey   ;
	//VER�TABANI VER�LER�
	int numara =0;
	
	public void gelenlerVeriler(String isim,String soyisim,String tarih,String borc, String alacak,int no) throws SQLException{
        //Gelen verileri txtGelenlere Aktar�yoruz.
        
		txt_ad.setText(isim);
        txt_soyad.setText(soyisim);
        txt_tarih.setText(tarih);
        txt_borc.setText(borc);
        txt_alacak.setText(alacak);
         
        this.numara=no;
        
        int temp = 0;
        ResultSet myRs1 = null;
        String mustericari = "select * from mustericari where idmustericari ="+no+"";
        myRs1 = SqlSorgu.sorgula(mustericari);
        while(myRs1.next()) {
        	temp = myRs1.getInt("siparis_sayisi")+1;
        }
        String sipariss = String.valueOf(temp);
        siparis1.setText(sipariss);
        String id = String.valueOf(no);
        musteriid.setText(id);

    }
	
	
	public void fiyatlistesi(double ckt,double c�) {
		this.ckt = ckt;
		this.c� = c�;
		

	}
	
	public void showDate() { 				//TAR�H FORMATI
		Date d = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("dd.MM.yyyy");
		
		tarih = sf.format(d);
		
		
	}
	
	ArrayList<String> t�r = new ArrayList<String>();
	private JTextField txt_ad;
	private JTextField txt_soyad;
	private JTextField txt_iskonto;
	private JTextField txt_geneltoplam;
	private JTextField txt_isim;
	private JTextField txt_fiyat;
	private JTextField txt_isimm;
	private JTextField txt_fiyatt;
	private JTextField txt_zam;
	private JButton etek;
	private JTextField txt_borc;
	private JTextField txt_alacak;
	private JTextField txt_tarih;
	private JTextField saatt;
	ArrayList<Double> �r�nlerr = new ArrayList<Double>();
	
	
	Double[] �r�nler = {null,btkt, bt�, bluzkt, bluz�, ceketkt, ceket�, damatl�kkt, damatl�k�, derimontkt, d�piyeskt, d�piyes�, elbisekt, elbise�, etekkt, etek�, gekt, ge�, g�mlekkt, g�mlek�, iekt, ie�, i�kt, i��, kabankt, kaban�, kazakkt, kazak�, ibkt, ib�, montkt, mont�, paltokt, palto�, pantolonkt, pantolon�, pardes�kt, pardes��, tekt, te�, tren�kotkt, tren�kot�, ti��rtkt, ti��rt�, yelekkt, yelek�, dkm��, skm��, onikikm��, nevresim�, yast�k�, y��, alezy, battaniyey, elyafyorgany, kazt�y�yorgany, dkm�y, skm�y, onikikm�y, nevresimy, pamukyorgany, yast�ky, yatak�rt�s�y, �ar�afy, cambalkony,gelinliky,t�lperdey,fonperdey,kruvazeperdey,g�ne�liky,bstorperdey,istorperdey,�storperdey,bzebraperdey,izebraperdey,�zebraperdey,abiyey};
	private JTextField temizleme_isim;
	private JTextField temizleme_fiyat;
	private JTextField teslimtarihi;
	private JTextField siparis;
	private JTextField musteriid;
	private JTextField siparis1;
	private JTable table_1;
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KuruTemizleme frame = new KuruTemizleme();
					 frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public KuruTemizleme() throws SQLException, ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(KuruTemizleme.class.getResource("/ikonlar/natura.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {


				modelim2.setRowCount(0);
				String model2 = "Select * from siparisdurumu where idmusteri ='"+numara+"' and teslimdurumu=0";
				ResultSet myRs2=SqlSorgu.sorgula(model2);
				
				try {
					while(myRs2.next()) {
						sat�rlar1[0]=myRs2.getInt("makbuzno");
						sat�rlar1[1]=myRs2.getInt("siparisno");
						sat�rlar1[2]=myRs2.getString("siparistarihi");
						sat�rlar1[3]=myRs2.getString("teslimtarihi");
						sat�rlar1[4]=myRs2.getString("siparistutari");
						modelim2.addRow(sat�rlar1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
		table_1.setModel(modelim2);
			
			
			}
		});
								// VER�TABANINDAN F�YATLARI AL
		
		
		String sql_sorgu = "select * from �r�nler ";
		//double btkt, bt�, bluzkt, bluz�, ceketkt, ceket�, damatl�kkt, damatl�k�, derimontkt, d�piyeskt, d�piyes�, elbisekt, elbise�, etekkt, etek�, gekt, ge�, g�mlekkt, g�mlek�, iekt, ie�, i�kt, i��, kabankt, kaban�, kazakkt, kazak�, ibkt, ib�, montkt, mont�, paltokt, palto�, pantolonkt, pantolon�, pardes�kt, pardes��, tekt, te�, tren�kotkt, tren�kot�, ti��rtkt, ti��rt�, yelekkt, yelek�, dkm��, skm��, onikikm��, nevresim�, yast�k�, y��, alezy, battaniyey, elyafyorgany, kazt�y�yorgany, dkm�y, skm�y, onikikm�y, nevresimy, pamukyorgany, yast�ky, yatak�rt�s�y, �ar�afy;
		ResultSet myRs = null;
		SqlSorgu.�r�nler();
		myRs = SqlSorgu.sorgula(sql_sorgu);
		
			
				try {
					while(myRs.next()) {
						for (int i = 1; i <�r�nler.length; i++) {
						btkt= myRs.getDouble("btkt");
						bt� = myRs.getDouble("bt�");
						bluzkt = myRs.getDouble("bluzkt");
						bluz�=myRs.getDouble("bluz�");
						ceketkt=myRs.getDouble("ceketkt");
						ceket�=myRs.getDouble("ceket�");
						damatl�kkt=myRs.getDouble("damatl�kkt");
						damatl�k�=myRs.getDouble("damatl�k�");
						derimontkt=myRs.getDouble("derimontkt");
						d�piyeskt=myRs.getDouble("d�piyeskt");
						d�piyes�=myRs.getDouble("d�piyes�");
						elbisekt=myRs.getDouble("elbisekt");
						elbise�=myRs.getDouble("elbise�");
						etekkt= myRs.getDouble("etekkt");
						etek�=myRs.getDouble("etek�");
						gekt=myRs.getDouble("gekt");
						ge�=myRs.getDouble("ge�");
						g�mlekkt=myRs.getDouble("g�mlekkt");
						g�mlek�=myRs.getDouble("g�mlek�");
						iekt=myRs.getDouble("iekt");
						ie�= myRs.getDouble("ie�");
						i�kt=myRs.getDouble("i�kt");
						i��= myRs.getDouble("i��");
						kabankt=myRs.getDouble("kabankt");
						kaban�=myRs.getDouble("kaban�");
						kazakkt=myRs.getDouble("kazakkt");
						kazak�= myRs.getDouble("kazak�");
						ibkt= myRs.getDouble("ibkt");
						ib�=myRs.getDouble("ib�");
						montkt= myRs.getDouble("montkt");
						mont�=myRs.getDouble("mont�");
						paltokt=myRs.getDouble("paltokt");
						palto�=myRs.getDouble("palto�");
						pantolonkt=myRs.getDouble("pantolonkt");
						pantolon�=myRs.getDouble("pantolon�");
						pardes�kt=myRs.getDouble("pardes�kt");
						pardes��=myRs.getDouble("pardes��");
						tekt=myRs.getDouble("tekt");
						te�=myRs.getDouble("te�");
						tren�kotkt=myRs.getDouble("tren�kotkt");
						tren�kot�=myRs.getDouble("tren�kot�");
						ti��rtkt=myRs.getDouble("ti��rtkt");
						ti��rt�=myRs.getDouble("ti��rt�");
						yelekkt=myRs.getDouble("yelekkt");
						yelek�=myRs.getDouble("yelek�");
						dkm��=myRs.getDouble("dkm��");
						skm��=myRs.getDouble("skm��");
						onikikm��=myRs.getDouble("onikikm��");
						nevresim�=myRs.getDouble("nevresim�");
						yast�k�=myRs.getDouble("yast�k�");
						y��=myRs.getDouble("y��");
						alezy=myRs.getDouble("alezy");
						battaniyey=myRs.getDouble("battaniyey");
						elyafyorgany=myRs.getDouble("elyafyorgany");
						kazt�y�yorgany=myRs.getDouble("kazt�y�yorgany");
						dkm�y=myRs.getDouble("dkm�y");
						skm�y=myRs.getDouble("skm�y");
						onikikm�y=myRs.getDouble("onikikm�y");
						nevresimy=myRs.getDouble("nevresimy");
						pamukyorgany=myRs.getDouble("pamukyorgany");
						yast�ky=myRs.getDouble("yast�ky");
						yatak�rt�s�y=myRs.getDouble("yatak�rt�s�y");
						cambalkony=myRs.getDouble("cambalkony");
						gelinliky=myRs.getDouble("gelinliky");
						t�lperdey=myRs.getDouble("t�lperdey");
						fonperdey=myRs.getDouble("fonperdey");
						kruvazeperdey=myRs.getDouble("kruvazeperdey");
						g�ne�liky=myRs.getDouble("g�ne�liky");
						bstorperdey=myRs.getDouble("bstorperdey");
						istorperdey=myRs.getDouble("istorperdey");
						�storperdey=myRs.getDouble("�storperdey");
						bzebraperdey=myRs.getDouble("bzebraperdey");
						izebraperdey=myRs.getDouble("izebraperdey");
						�zebraperdey=myRs.getDouble("�zebraperdey");
						�ar�afy=myRs.getDouble("�ar�afy");
						abiyey=myRs.getDouble("abiyey");
						
						
						
						
						
						
						
						
						
						
						
						
						//btkt, bt�, bluzkt, bluz�, ceketkt, ceket�, damatl�kkt, damatl�k�, derimontkt, d�piyeskt, d�piyes�, elbisekt, elbise�, etekkt, etek�, gekt, ge�, g�mlekkt, g�mlek�, iekt, ie�, i�kt, i��, kabankt, kaban�, kazakkt, kazak�, ibkt, ib�, montkt, mont�, paltokt, palto�, pantolonkt, pantolon�, pardes�kt, pardes��, tekt, te�, tren�kotkt, tren�kot�, ti��rtkt, ti��rt�, yelekkt, yelek�, dkm��, skm��, onikikm��, nevresim�, yast�k�, y��, alezy, battaniyey, elyafyorgany, kazt�y�yorgany, dkm�y, skm�y, onikikm�y, nevresimy, pamukyorgany, yast�ky, yatak�rt�s�y, �ar�afy;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
		
				
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 20, 1700, 1000);
		contentPane = new JPanel();
		contentPane.setFocusable(false);
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton anasayfa = new JButton("Ana Sayfa");
		anasayfa.setBounds(10, 18, 115, 46);
		contentPane.add(anasayfa);
		anasayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dashboard yein = new Dashboard();
				yein.setVisible(true);
				setVisible(false);
			}
		});
		anasayfa.setFont(new Font("Tahoma", Font.BOLD, 12));
		anasayfa.setFocusable(false);
		anasayfa.setBorder(UIManager.getBorder("CheckBox.border"));
		
		JLabel label = new JLabel("TL");
		label.setBounds(1488, 616, 55, 14);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(label);
		
		JLabel lblKuruTemizleme = new JLabel("S\u0130PAR\u0130\u015E OLU\u015ETUR");
		lblKuruTemizleme.setBounds(685, 18, 206, 22);
		contentPane.add(lblKuruTemizleme);
		lblKuruTemizleme.setHorizontalAlignment(SwingConstants.CENTER);
		lblKuruTemizleme.setForeground(Color.WHITE);
		lblKuruTemizleme.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1173, 351, 393, 251);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		
		table.setAlignmentX(Component.CENTER_ALIGNMENT);
		table.setFont(new Font("Tahoma", Font.BOLD, 11)); 
		table.setIntercellSpacing(new Dimension(2, 2));
		table.setFocusable(false);
		
		table.setRowSelectionAllowed(false);
		modelim.setColumnIdentifiers(kolonlar);
		//modelim.addRow(sat�rlar);
		table.setModel(modelim);
		table.setBackground(Color.LIGHT_GRAY);
		
		table.setBounds(227, 316, 261, 210);
		scrollPane.setViewportView(table);
		
		
		txt_toplam = new JTextField();
		txt_toplam.setBounds(1395, 613, 91, 20);
		txt_toplam.setFont(new Font("Tahoma", Font.BOLD, 12));
		double fiyat = 0;
		String st = Double.toString(fiyat);
		txt_toplam.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_toplam.setEditable(false);
		txt_toplam.setFocusable(false);
		txt_toplam.setText(st);
		contentPane.add(txt_toplam);
		txt_toplam.setColumns(10);
		
		JLabel labeltoplam = new JLabel("ARA TOPLAM");
		labeltoplam.setBounds(1259, 614, 126, 14);
		labeltoplam.setForeground(Color.WHITE);
		labeltoplam.setFont(new Font("Tahoma", Font.BOLD, 14));
		labeltoplam.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(labeltoplam);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 69, 1153, 881);
		tabbedPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, new Color(165, 42, 42), null, null));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(tabbedPane);
		ImageIcon kticon = (new ImageIcon(Dashboard.class.getResource("/kticon.png")));
		
		
		
		
		
		JPanel panel_1 = new JPanel();
		�t� = new JTextField();
		�t�.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				�t�.setText(null);
			}
		});
		�t�.setText("1");
		�t�.setHorizontalAlignment(SwingConstants.CENTER);
		�t�.setFont(new Font("Tahoma", Font.BOLD, 12));
		�t�.setBounds(1060, 17, 39, 20);
		panel_1.add(�t�);
		�t�.setColumns(10);
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel_1.setBackground(new Color(0, 150, 96));
		ImageIcon �t�icon = (new ImageIcon(Dashboard.class.getResource("/�t�.png")));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 51, 51));
		tabbedPane.addTab(null, kticon, panel, null);
		panel.setLayout(null);
		
		JButton G�mlek = new JButton("");
		G�mlek.setBounds(576, 161, 83, 90);
		G�mlek.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/gomlek.png")));
		G�mlek.setFocusable(false);
		panel.add(G�mlek);
		G�mlek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("G�mlek");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*g�mlekkt;												//de�i�tir
				sat�rlar[0] = "G�mlek";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*g�mlekkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("G�mlek");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "G�mlek zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		//contentPane.add(table);
		
		
		
		
		JButton Ceket = new JButton("");
		Ceket.setBounds(294, 17, 83, 90);
		Ceket.setFocusable(false);
		Ceket.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ceket.png")));
		panel.add(Ceket);
		
		JButton Pantolon = new JButton("");
		Pantolon.setBounds(294, 449, 83, 90);
		Pantolon.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/pantolon.png")));
		Pantolon.setFocusable(false);
		panel.add(Pantolon);
		Pantolon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Pantolon");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*pantolonkt;												//de�i�tir
				sat�rlar[0] = "Pantolon";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*pantolonkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Pantolon");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Pantolon zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		
		JButton Yelek = new JButton("");
		Yelek.setBounds(436, 593, 83, 90);
		Yelek.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yelek.png")));
		Yelek.setFocusable(false);
		panel.add(Yelek);
		Yelek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yelek");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*yelekkt;												//de�i�tir
				sat�rlar[0] = "Yelek";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*yelekkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yelek");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yelek zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		
		kuru = new JTextField();
		kuru.setBounds(1060, 17, 39, 20);
		kuru.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				kuru.setText(null);
			}
		});
		kuru.setText("1");
		kuru.setHorizontalAlignment(SwingConstants.CENTER);
		kuru.setFont(new Font("Tahoma", Font.BOLD, 12));
		kuru.setColumns(10);
		panel.add(kuru);
		
		JButton btnNewButton_1 = new JButton("Son sat\u0131r\u0131 sil");
		btnNewButton_1.setBounds(1028, 48, 104, 23);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setFocusable(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int rowCount = modelim.getRowCount();
				for (int i = rowCount-1; i>=0 ; i++) {
					double d = (double) modelim.getValueAt(i, 3);
					
					
					//System.out.println(d);
					toplamfiyat=toplamfiyat-d;
					modelim.removeRow(i);
					String temp = txt_toplam.getText();
					double temp2= Double.valueOf(temp);
					temp2=temp2-d;
					String stcevir = Double.toString(temp2);
					txt_toplam.setText(stcevir);
					txt_geneltoplam.setText(stcevir);
					
					t�r.remove(i);
					
					break;
					
				}
			
			}
		});
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("-");
		btnNewButton_3.setBounds(337, 130, 42, 20);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Ceket");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Ceket") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Ceket");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ceketkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ceketkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}}
		);
		btnNewButton_3.setFocusable(false);
		panel.add(btnNewButton_3);
		
		JButton button_1 = new JButton("+");
		button_1.setBounds(295, 130, 42, 20);
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_1.setForeground(new Color(255, 255, 255));
		button_1.setBackground(Color.BLACK);
		button_1.setFocusable(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Ceket");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ceketkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ceketkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		panel.add(button_1);
		
		JButton button_2 = new JButton("+");
		button_2.setBounds(576, 274, 42, 20);
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_2.setForeground(new Color(255, 255, 255));
		button_2.setBackground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("G�mlek");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=g�mlekkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += g�mlekkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_2.setFocusable(false);
		panel.add(button_2);
		
		JButton button_3 = new JButton("+");
		button_3.setBounds(293, 562, 42, 20);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_3.setForeground(new Color(255, 255, 255));
		button_3.setBackground(Color.BLACK);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Pantolon");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=pantolonkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += pantolonkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_3.setFocusable(false);
		panel.add(button_3);
		
		JButton button_4 = new JButton("+");
		button_4.setBounds(437, 706, 42, 20);
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_4.setForeground(new Color(255, 255, 255));
		button_4.setBackground(Color.BLACK);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yelek");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=yelekkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += yelekkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_4.setFocusable(false);
		panel.add(button_4);
		
		JButton button_5 = new JButton("-");
		button_5.setBounds(618, 274, 42, 20);
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_5.setForeground(new Color(255, 255, 255));
		button_5.setBackground(Color.BLACK);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("G�mlek");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="G�mlek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("G�mlek");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=g�mlekkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= g�mlekkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}});
		button_5.setFocusable(false);
		panel.add(button_5);
		
		JButton button_6 = new JButton("-");
		button_6.setBounds(335, 562, 42, 20);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_6.setForeground(new Color(255, 255, 255));
		button_6.setBackground(Color.BLACK);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Pantolon");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Pantolon") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Pantolon");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=pantolonkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= pantolonkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}
		});
		button_6.setFocusable(false);
		panel.add(button_6);
		
		JButton button_7 = new JButton("-");
		button_7.setBounds(479, 706, 42, 20);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_7.setForeground(new Color(255, 255, 255));
		button_7.setBackground(Color.BLACK);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Yelek");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Yelek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Yelek");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=yelekkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= yelekkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}
		});
		button_7.setFocusable(false);
		panel.add(button_7);
		
		JButton takimelbise = new JButton("");
		takimelbise.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/takimelbise.png")));
		//button_52.setIcon(new ImageIcon(Dashboard.class.getResource("/abiye.png")));
		takimelbise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Tak�m");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*tekt;												//de�i�tir
				sat�rlar[0] = "Tak�m Elbise";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*tekt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Tak�m");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Tak�m Elbise zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		takimelbise.setFocusable(false);
		takimelbise.setBounds(10, 593, 83, 90);
		panel.add(takimelbise);
		
		JButton button_53 = new JButton("+");
		button_53.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Tak�m");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=tekt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += tekt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_53.setForeground(Color.WHITE);
		button_53.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_53.setFocusable(false);
		button_53.setBackground(Color.BLACK);
		button_53.setBounds(10, 706, 42, 20);
		panel.add(button_53);
		
		JButton button_54 = new JButton("-");
		button_54.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Tak�m");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Tak�m Elbise") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Tak�m");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=tekt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= tekt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}
		});
		button_54.setForeground(Color.WHITE);
		button_54.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_54.setFocusable(false);
		button_54.setBackground(Color.BLACK);
		button_54.setBounds(52, 706, 42, 20);
		panel.add(button_54);
		
		JButton dopiyes = new JButton("");
		dopiyes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("D�piyes");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*d�piyeskt;												//de�i�tir
				sat�rlar[0] = "D�piyes";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*d�piyeskt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("D�piyes");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "D�piyes zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		dopiyes.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/dopiyes.png")));
		dopiyes.setFocusable(false);
		dopiyes.setBounds(11, 161, 83, 90);
		panel.add(dopiyes);
		
		JButton button_32 = new JButton("+");
		button_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("D�piyes");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=d�piyeskt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += d�piyeskt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_32.setForeground(Color.WHITE);
		button_32.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_32.setFocusable(false);
		button_32.setBackground(Color.BLACK);
		button_32.setBounds(11, 274, 42, 20);
		panel.add(button_32);
		
		JButton button_33 = new JButton("-");
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("D�piyes");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="D�piyes") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("D�piyes");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=d�piyeskt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= d�piyeskt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_33.setForeground(Color.WHITE);
		button_33.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_33.setFocusable(false);
		button_33.setBackground(Color.BLACK);
		button_33.setBounds(53, 274, 42, 20);
		panel.add(button_33);
		
		JButton ipekesarp = new JButton("");
		ipekesarp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek E�arp");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*iekt;												//de�i�tir
				sat�rlar[0] = "�pek E�arp";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*iekt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek E�arp");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek E�arp zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		ipekesarp.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipekesarp.png")));
		ipekesarp.setFocusable(false);
		ipekesarp.setBounds(12, 305, 83, 90);
		panel.add(ipekesarp);
		
		JButton button_35 = new JButton("+");
		button_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek E�arp");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=iekt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += iekt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_35.setForeground(Color.WHITE);
		button_35.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_35.setFocusable(false);
		button_35.setBackground(Color.BLACK);
		button_35.setBounds(11, 418, 42, 20);
		panel.add(button_35);
		
		JButton button_36 = new JButton("-");
		button_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek E�arp");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek E�arp") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek E�arp");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=iekt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= iekt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_36.setForeground(Color.WHITE);
		button_36.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_36.setFocusable(false);
		button_36.setBackground(Color.BLACK);
		button_36.setBounds(53, 418, 42, 20);
		panel.add(button_36);
		
		JButton trenckot = new JButton("");
		trenckot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Tren�kot");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*tren�kotkt;												//de�i�tir
				sat�rlar[0] = "Tren�kot";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*tren�kotkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Tren�kot");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Tren�kot zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		trenckot.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/trenckot.png")));
		trenckot.setFocusable(false);
		trenckot.setBounds(151, 593, 83, 90);
		panel.add(trenckot);
		
		JButton button_41 = new JButton("+");
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Tren�kot");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=tren�kotkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += tren�kotkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_41.setForeground(Color.WHITE);
		button_41.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_41.setFocusable(false);
		button_41.setBackground(Color.BLACK);
		button_41.setBounds(152, 706, 42, 20);
		panel.add(button_41);
		
		JButton button_42 = new JButton("-");
		button_42.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Tren�kot");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Tren�kot") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Tren�kot");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=tren�kotkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= tren�kotkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_42.setForeground(Color.WHITE);
		button_42.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_42.setFocusable(false);
		button_42.setBackground(Color.BLACK);
		button_42.setBounds(194, 706, 42, 20);
		panel.add(button_42);
		
		JButton elbise = new JButton("");
		elbise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Elbise");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*elbisekt;												//de�i�tir
				sat�rlar[0] = "Elbise";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*elbisekt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Elbise");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Elbise zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		elbise.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/elbise.png")));
		elbise.setFocusable(false);
		elbise.setBounds(153, 161, 83, 90);
		panel.add(elbise);
		
		JButton button_47 = new JButton("+");
		button_47.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Elbise");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=elbisekt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += elbisekt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_47.setForeground(Color.WHITE);
		button_47.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_47.setFocusable(false);
		button_47.setBackground(Color.BLACK);
		button_47.setBounds(153, 274, 42, 20);
		panel.add(button_47);
		
		JButton button_48 = new JButton("-");
		button_48.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Elbise");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Elbise") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Elbise");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=elbisekt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= elbisekt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_48.setForeground(Color.WHITE);
		button_48.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_48.setFocusable(false);
		button_48.setBackground(Color.BLACK);
		button_48.setBounds(195, 274, 42, 20);
		panel.add(button_48);
		
		JButton ipeksal = new JButton("");
		ipeksal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek �al");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*i�kt;												//de�i�tir
				sat�rlar[0] = "�pek �al";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*i�kt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek �al");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek �al zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		ipeksal.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipeksal.png")));
		ipeksal.setFocusable(false);
		ipeksal.setBounds(154, 305, 83, 90);
		panel.add(ipeksal);
		
		JButton button_50 = new JButton("+");
		button_50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek �al");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=i�kt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += i�kt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_50.setForeground(Color.WHITE);
		button_50.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_50.setFocusable(false);
		button_50.setBackground(Color.BLACK);
		button_50.setBounds(153, 418, 42, 20);
		panel.add(button_50);
		
		JButton button_51 = new JButton("-");
		button_51.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek �al");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek �al") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek �al");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=i�kt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= i�kt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_51.setForeground(Color.WHITE);
		button_51.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_51.setFocusable(false);
		button_51.setBackground(Color.BLACK);
		button_51.setBounds(195, 418, 42, 20);
		panel.add(button_51);
		
		JButton palto = new JButton("");
		palto.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/palto.png")));
		palto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Palto");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*paltokt;												//de�i�tir
				sat�rlar[0] = "Palto";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*paltokt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Palto");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Palto zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		palto.setFocusable(false);
		palto.setBounds(153, 449, 83, 90);
		panel.add(palto);
		
		JButton button_56 = new JButton("+");
		button_56.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Palto");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=paltokt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += paltokt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_56.setForeground(Color.WHITE);
		button_56.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_56.setFocusable(false);
		button_56.setBackground(Color.BLACK);
		button_56.setBounds(152, 562, 42, 20);
		panel.add(button_56);
		
		JButton button_57 = new JButton("-");
		button_57.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Palto");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Palto") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Palto");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=paltokt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= paltokt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_57.setForeground(Color.WHITE);
		button_57.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_57.setFocusable(false);
		button_57.setBackground(Color.BLACK);
		button_57.setBounds(194, 562, 42, 20);
		panel.add(button_57);
		
		JButton tshirt = new JButton("");
		tshirt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Ti��rt");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ti��rtkt;												//de�i�tir
				sat�rlar[0] = "Ti��rt";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ti��rtkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Ti��rt");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Ti��rt zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		tshirt.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/tshirt.png")));
		tshirt.setFocusable(false);
		tshirt.setBounds(293, 593, 83, 90);
		panel.add(tshirt);
		
		JButton button_59 = new JButton("+");
		button_59.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Ti��rt");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ti��rtkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ti��rtkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_59.setForeground(Color.WHITE);
		button_59.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_59.setFocusable(false);
		button_59.setBackground(Color.BLACK);
		button_59.setBounds(294, 706, 42, 20);
		panel.add(button_59);
		
		JButton button_60 = new JButton("-");
		button_60.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Ti��rt");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Ti��rt") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Ti��rt");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ti��rtkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ti��rtkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_60.setForeground(Color.WHITE);
		button_60.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_60.setFocusable(false);
		button_60.setBackground(Color.BLACK);
		button_60.setBounds(336, 706, 42, 20);
		panel.add(button_60);
		
		JButton bayantakim = new JButton("");
		bayantakim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Bayan Tak�m");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*btkt;												//de�i�tir
				sat�rlar[0] = "Bayan Tak�m";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*btkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Bayan Tak�m");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Bayan Tak�m zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		bayantakim.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/bayantakim.png")));
		bayantakim.setFocusable(false);
		bayantakim.setBounds(10, 17, 83, 90);
		panel.add(bayantakim);
		
		JButton button_62 = new JButton("+");
		button_62.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index= t�r.indexOf("Bayan Tak�m");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=btkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += btkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_62.setForeground(Color.WHITE);
		button_62.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_62.setFocusable(false);
		button_62.setBackground(Color.BLACK);
		button_62.setBounds(11, 130, 42, 20);
		panel.add(button_62);
		
		JButton button_63 = new JButton("-");
		button_63.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int index= t�r.indexOf("Bayan Tak�m");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Bayan Tak�m") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Bayan Tak�m");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=btkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= btkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_63.setForeground(Color.WHITE);
		button_63.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_63.setFocusable(false);
		button_63.setBackground(Color.BLACK);
		button_63.setBounds(53, 130, 42, 20);
		panel.add(button_63);
		
		JButton kaban = new JButton("");
		kaban.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kaban");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kabankt;												//de�i�tir
				sat�rlar[0] = "Kaban";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kabankt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kaban");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kaban zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		kaban.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kaban.png")));
		kaban.setFocusable(false);
		kaban.setBounds(296, 305, 83, 90);
		panel.add(kaban);
		
		JButton button_68 = new JButton("+");
		button_68.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kaban");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kabankt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kabankt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_68.setForeground(Color.WHITE);
		button_68.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_68.setFocusable(false);
		button_68.setBackground(Color.BLACK);
		button_68.setBounds(295, 418, 42, 20);
		panel.add(button_68);
		
		JButton button_69 = new JButton("-");
		button_69.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kaban");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kaban") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kaban");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kabankt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kabankt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_69.setForeground(Color.WHITE);
		button_69.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_69.setFocusable(false);
		button_69.setBackground(Color.BLACK);
		button_69.setBounds(337, 418, 42, 20);
		panel.add(button_69);
		
		JButton bluz = new JButton("");
		bluz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index = t�r.indexOf("Bluz");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*bluzkt;												//de�i�tir
				sat�rlar[0] = "Bluz";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*bluzkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Bluz");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Bluz zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		bluz.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/bluz.png")));
		bluz.setFocusable(false);
		bluz.setBounds(151, 17, 83, 90);
		panel.add(bluz);
		
		JButton button_77 = new JButton("+");
		button_77.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index= t�r.indexOf("Bluz");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=bluzkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += bluzkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_77.setForeground(Color.WHITE);
		button_77.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_77.setFocusable(false);
		button_77.setBackground(Color.BLACK);
		button_77.setBounds(152, 130, 42, 20);
		panel.add(button_77);
		
		JButton button_78 = new JButton("-");
		button_78.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Bluz");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Bluz") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Bluz");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=bluzkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= bluzkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_78.setForeground(Color.WHITE);
		button_78.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_78.setFocusable(false);
		button_78.setBackground(Color.BLACK);
		button_78.setBounds(194, 130, 42, 20);
		panel.add(button_78);
		
		etek = new JButton("");
		etek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Etek");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*etekkt;												//de�i�tir
				sat�rlar[0] = "Etek";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*etekkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Etek");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Etek zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		etek.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/etek.png")));
		etek.setFocusable(false);
		etek.setBounds(294, 161, 83, 90);
		panel.add(etek);
		
		JButton button_80 = new JButton("+");
		button_80.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Etek");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=etekkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += etekkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_80.setForeground(Color.WHITE);
		button_80.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_80.setFocusable(false);
		button_80.setBackground(Color.BLACK);
		button_80.setBounds(294, 274, 42, 20);
		panel.add(button_80);
		
		JButton button_81 = new JButton("-");
		button_81.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Etek");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Etek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Etek");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=etekkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= etekkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_81.setForeground(Color.WHITE);
		button_81.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_81.setFocusable(false);
		button_81.setBackground(Color.BLACK);
		button_81.setBounds(336, 274, 42, 20);
		panel.add(button_81);
		
		JButton kazak = new JButton("");
		kazak.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kazak");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kazakkt;												//de�i�tir
				sat�rlar[0] = "Kazak";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kazakkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kazak");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kazak zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		kazak.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kazak.png")));
		kazak.setFocusable(false);
		kazak.setBounds(438, 305, 83, 90);
		panel.add(kazak);
		
		JButton button_83 = new JButton("+");
		button_83.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kazak");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kazakkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kazakkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_83.setForeground(Color.WHITE);
		button_83.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_83.setFocusable(false);
		button_83.setBackground(Color.BLACK);
		button_83.setBounds(437, 418, 42, 20);
		panel.add(button_83);
		
		JButton button_84 = new JButton("-");
		button_84.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kazak");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kazak") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kazak");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kazakkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kazakkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_84.setForeground(Color.WHITE);
		button_84.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_84.setFocusable(false);
		button_84.setBackground(Color.BLACK);
		button_84.setBounds(479, 418, 42, 20);
		panel.add(button_84);
		
		JButton ipekbluz = new JButton("");
		ipekbluz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek Bluz");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ibkt;												//de�i�tir
				sat�rlar[0] = "�pek Bluz";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ibkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek Bluz");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek Bluz zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		ipekbluz.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipekbluz.png")));
		ipekbluz.setFocusable(false);
		ipekbluz.setBounds(576, 305, 83, 90);
		panel.add(ipekbluz);
		
		JButton button_86 = new JButton("+");
		button_86.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek Bluz");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ibkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ibkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_86.setForeground(Color.WHITE);
		button_86.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_86.setFocusable(false);
		button_86.setBackground(Color.BLACK);
		button_86.setBounds(575, 418, 42, 20);
		panel.add(button_86);
		
		JButton button_87 = new JButton("-");
		button_87.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek Bluz");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek Bluz") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek Bluz");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ibkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ibkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_87.setForeground(Color.WHITE);
		button_87.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_87.setFocusable(false);
		button_87.setBackground(Color.BLACK);
		button_87.setBounds(617, 418, 42, 20);
		panel.add(button_87);
		
		JButton button_91 = new JButton("+");
		button_91.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Mont");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=montkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += montkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_91.setForeground(Color.WHITE);
		button_91.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_91.setFocusable(false);
		button_91.setBackground(Color.BLACK);
		button_91.setBounds(10, 562, 42, 20);
		panel.add(button_91);
		
		JButton button_92 = new JButton("-");
		button_92.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Mont");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Mont") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Mont");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=montkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= montkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_92.setForeground(Color.WHITE);
		button_92.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_92.setFocusable(false);
		button_92.setBackground(Color.BLACK);
		button_92.setBounds(52, 562, 42, 20);
		panel.add(button_92);
		
		JButton mont = new JButton("");
		mont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Mont");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*montkt;												//de�i�tir
				sat�rlar[0] = "Mont";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*montkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Mont");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Mont zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		mont.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/mont.png")));
		mont.setFocusable(false);
		mont.setBounds(10, 449, 83, 90);
		panel.add(mont);
		
		JButton button_94 = new JButton("+");
		button_94.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Pardes�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=pardes�kt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += pardes�kt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_94.setForeground(Color.WHITE);
		button_94.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_94.setFocusable(false);
		button_94.setBackground(Color.BLACK);
		button_94.setBounds(435, 562, 42, 20);
		panel.add(button_94);
		
		JButton button_95 = new JButton("-");
		button_95.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Pardes�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Pardes�") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Pardes�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=pardes�kt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= pardes�kt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_95.setForeground(Color.WHITE);
		button_95.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_95.setFocusable(false);
		button_95.setBackground(Color.BLACK);
		button_95.setBounds(477, 562, 42, 20);
		panel.add(button_95);
		
		JButton pardesu = new JButton("");
		pardesu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Pardes�");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*pardes�kt;												//de�i�tir
				sat�rlar[0] = "Pardes�";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*pardes�kt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Pardes�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Pardes� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		pardesu.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/pardesu.png")));
		pardesu.setFocusable(false);
		pardesu.setBounds(436, 449, 83, 90);
		panel.add(pardesu);
		
		JButton button_100 = new JButton("+");
		button_100.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Gece Elbisesi");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=gekt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += gekt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_100.setForeground(Color.WHITE);
		button_100.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_100.setFocusable(false);
		button_100.setBackground(Color.BLACK);
		button_100.setBounds(436, 274, 42, 20);
		panel.add(button_100);
		
		JButton button_101 = new JButton("-");
		button_101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Gece Elbisesi");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Gece Elbisesi") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Gece Elbisesi");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=gekt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= gekt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_101.setForeground(Color.WHITE);
		button_101.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_101.setFocusable(false);
		button_101.setBackground(Color.BLACK);
		button_101.setBounds(478, 274, 42, 20);
		panel.add(button_101);
		
		JButton geceelbisesi = new JButton("");
		geceelbisesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Gece Elbisesi");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*gekt;												//de�i�tir
				sat�rlar[0] = "Gece Elbisesi";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*gekt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Gece Elbisesi");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Gece Elbisesi zaten se�ili.","", 1);		//de�i�tir
				}
					
			
				
			}
		});
		geceelbisesi.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/geceelbisesi.png")));
		geceelbisesi.setFocusable(false);
		geceelbisesi.setBounds(436, 161, 83, 90);
		panel.add(geceelbisesi);
		
		JButton damatlik = new JButton("");
		damatlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Damatl�k");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*damatl�kkt;												//de�i�tir
				sat�rlar[0] = "Damatl�k";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*damatl�kkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Damatl�k");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Damatl�k zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		damatlik.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/damatlik.png")));
		damatlik.setFocusable(false);
		damatlik.setBounds(436, 17, 83, 90);
		panel.add(damatlik);
		
		JButton button_16 = new JButton("+");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Damatl�k");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=damatl�kkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += damatl�kkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_16.setForeground(Color.WHITE);
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_16.setFocusable(false);
		button_16.setBackground(Color.BLACK);
		button_16.setBounds(437, 130, 42, 20);
		panel.add(button_16);
		
		JButton button_17 = new JButton("-");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Damatl�k");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Damatl�k") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Damatl�k");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=damatl�kkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= damatl�kkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_17.setForeground(Color.WHITE);
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_17.setFocusable(false);
		button_17.setBackground(Color.BLACK);
		button_17.setBounds(479, 130, 42, 20);
		panel.add(button_17);
		
		JButton derimont = new JButton("");
		derimont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Deri Mont");											//de�i�tir
				
				if (index==-1) {				
				String st = kuru.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*derimontkt;												//de�i�tir
				sat�rlar[0] = "Deri Mont";														//de�i�tir
				sat�rlar[1] = "Kuru Temizleme";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*derimontkt;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Deri Mont");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					kuru.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Deri Mont zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		derimont.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/derimont.png")));
		derimont.setFocusable(false);
		derimont.setBounds(576, 17, 83, 90);
		panel.add(derimont);
		
		JButton button_19 = new JButton("+");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Deri Mont");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=derimontkt*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += derimontkt*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_19.setForeground(Color.WHITE);
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_19.setFocusable(false);
		button_19.setBackground(Color.BLACK);
		button_19.setBounds(576, 130, 42, 20);
		panel.add(button_19);
		
		JButton button_20 = new JButton("-");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Deri Mont");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Deri Mont") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Deri Mont");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=derimontkt*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= derimontkt*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_20.setForeground(Color.WHITE);
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_20.setFocusable(false);
		button_20.setBackground(Color.BLACK);
		button_20.setBounds(618, 130, 42, 20);
		panel.add(button_20);
		
		JLabel lblNewLabel = new JLabel("TAKIM ELB\u0130SE");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(8, 684, 95, 20);
		panel.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("MONT");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(32, 541, 42, 20);
		panel.add(label_1);
		
		JLabel lblBayanTakm = new JLabel("BAYAN TAKIM");
		lblBayanTakm.setHorizontalAlignment(SwingConstants.CENTER);
		lblBayanTakm.setForeground(Color.WHITE);
		lblBayanTakm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBayanTakm.setBounds(0, 107, 104, 20);
		panel.add(lblBayanTakm);
		
		JLabel lblBluz = new JLabel("BLUZ");
		lblBluz.setHorizontalAlignment(SwingConstants.CENTER);
		lblBluz.setForeground(Color.WHITE);
		lblBluz.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBluz.setBounds(152, 111, 83, 20);
		panel.add(lblBluz);
		
		JLabel lblCeket = new JLabel("CEKET");
		lblCeket.setHorizontalAlignment(SwingConstants.CENTER);
		lblCeket.setForeground(Color.WHITE);
		lblCeket.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCeket.setBounds(295, 110, 83, 20);
		panel.add(lblCeket);
		
		JLabel lblDamatlk = new JLabel("DAMATLIK");
		lblDamatlk.setHorizontalAlignment(SwingConstants.CENTER);
		lblDamatlk.setForeground(Color.WHITE);
		lblDamatlk.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDamatlk.setBounds(436, 111, 83, 20);
		panel.add(lblDamatlk);
		
		JLabel lblDeriMont = new JLabel("DER\u0130 MONT");
		lblDeriMont.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeriMont.setForeground(Color.WHITE);
		lblDeriMont.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDeriMont.setBounds(576, 109, 83, 20);
		panel.add(lblDeriMont);
		
		JLabel lblDpiyes = new JLabel("D\u00D6P\u0130YES");
		lblDpiyes.setHorizontalAlignment(SwingConstants.CENTER);
		lblDpiyes.setForeground(Color.WHITE);
		lblDpiyes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDpiyes.setBounds(10, 253, 83, 20);
		panel.add(lblDpiyes);
		
		JLabel lblElbise = new JLabel("ELB\u0130SE");
		lblElbise.setHorizontalAlignment(SwingConstants.CENTER);
		lblElbise.setForeground(Color.WHITE);
		lblElbise.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblElbise.setBounds(152, 253, 83, 20);
		panel.add(lblElbise);
		
		JLabel lblEtek = new JLabel("ETEK");
		lblEtek.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtek.setForeground(Color.WHITE);
		lblEtek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEtek.setBounds(294, 253, 83, 20);
		panel.add(lblEtek);
		
		JLabel lblGeceElbisesi = new JLabel("GECE ELB\u0130SES\u0130");
		lblGeceElbisesi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeceElbisesi.setForeground(Color.WHITE);
		lblGeceElbisesi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGeceElbisesi.setBounds(425, 253, 109, 20);
		panel.add(lblGeceElbisesi);
		
		JLabel lblGmlek = new JLabel("G\u00D6MLEK");
		lblGmlek.setHorizontalAlignment(SwingConstants.CENTER);
		lblGmlek.setForeground(Color.WHITE);
		lblGmlek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGmlek.setBounds(576, 253, 83, 20);
		panel.add(lblGmlek);
		
		JLabel lblIpekBluz = new JLabel("\u0130PEK BLUZ");
		lblIpekBluz.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpekBluz.setForeground(Color.WHITE);
		lblIpekBluz.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIpekBluz.setBounds(575, 397, 83, 20);
		panel.add(lblIpekBluz);
		
		JLabel lblIpekEarp = new JLabel("\u0130PEK E\u015EARP");
		lblIpekEarp.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpekEarp.setForeground(Color.WHITE);
		lblIpekEarp.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIpekEarp.setBounds(10, 397, 83, 20);
		panel.add(lblIpekEarp);
		
		JLabel lblIpekal = new JLabel("\u0130PEK \u015EAL");
		lblIpekal.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpekal.setForeground(Color.WHITE);
		lblIpekal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIpekal.setBounds(152, 397, 83, 20);
		panel.add(lblIpekal);
		
		JLabel lblKaban = new JLabel("KABAN");
		lblKaban.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaban.setForeground(Color.WHITE);
		lblKaban.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKaban.setBounds(294, 397, 83, 20);
		panel.add(lblKaban);
		
		JLabel lblKazak = new JLabel("KAZAK");
		lblKazak.setHorizontalAlignment(SwingConstants.CENTER);
		lblKazak.setForeground(Color.WHITE);
		lblKazak.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblKazak.setBounds(437, 397, 83, 20);
		panel.add(lblKazak);
		
		JLabel lblPalto = new JLabel("PALTO");
		lblPalto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPalto.setForeground(Color.WHITE);
		lblPalto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPalto.setBounds(151, 541, 83, 20);
		panel.add(lblPalto);
		
		JLabel lblPantolon = new JLabel("PANTOLON");
		lblPantolon.setHorizontalAlignment(SwingConstants.CENTER);
		lblPantolon.setForeground(Color.WHITE);
		lblPantolon.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPantolon.setBounds(294, 541, 83, 20);
		panel.add(lblPantolon);
		
		JLabel lblPardes = new JLabel("PARDES\u00DC");
		lblPardes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPardes.setForeground(Color.WHITE);
		lblPardes.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPardes.setBounds(435, 541, 83, 20);
		panel.add(lblPardes);
		
		JLabel lblTrenkot = new JLabel("TREN\u00C7KOT");
		lblTrenkot.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrenkot.setForeground(Color.WHITE);
		lblTrenkot.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTrenkot.setBounds(151, 684, 83, 20);
		panel.add(lblTrenkot);
		
		JLabel lblTirt = new JLabel("T\u0130\u015E\u00D6RT");
		lblTirt.setHorizontalAlignment(SwingConstants.CENTER);
		lblTirt.setForeground(Color.WHITE);
		lblTirt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTirt.setBounds(292, 684, 83, 20);
		panel.add(lblTirt);
		
		JLabel lblYelek = new JLabel("YELEK");
		lblYelek.setHorizontalAlignment(SwingConstants.CENTER);
		lblYelek.setForeground(Color.WHITE);
		lblYelek.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblYelek.setBounds(436, 684, 83, 20);
		panel.add(lblYelek);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/\u00FCt\u00FC.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (kthaf�za==txt_isim.getText()) {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
						
					//de�i�tir
					String isim = txt_isim.getText();
					String fiy = txt_fiyat.getText();
					double fiyat = Double.valueOf(fiy);
					int index = t�r.indexOf(isim); 
					
					if (index==-1) {
						kthaf�za=isim;
						ktfiyat=fiyat;
						
					String st = kuru.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*fiyat;												//de�i�tir
					sat�rlar[0] = isim;														//de�i�tir
					sat�rlar[1] = "Kuru Temizleme";
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*fiyat;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add(isim);															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						kuru.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
				} catch (Exception e2) {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�sim veya fiyat belirleyiniz.","", 1);
				}
				
					}
		});
		button.setFocusable(false);
		button.setBounds(923, 345, 163, 124);
		panel.add(button);
		
		JLabel lblBakaBirTr = new JLabel("BA\u015EKA B\u0130R T\u00DCR G\u0130R");
		lblBakaBirTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblBakaBirTr.setForeground(Color.WHITE);
		lblBakaBirTr.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblBakaBirTr.setBounds(931, 471, 149, 20);
		panel.add(lblBakaBirTr);
		
		JButton button_103 = new JButton("+");
		button_103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf(kthaf�za);									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ktfiyat*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ktfiyat*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_103.setForeground(Color.WHITE);
		button_103.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_103.setFocusable(false);
		button_103.setBackground(Color.BLACK);
		button_103.setBounds(962, 562, 42, 20);
		panel.add(button_103);
		
		JButton button_104 = new JButton("-");
		button_104.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf(kthaf�za);													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim==kthaf�za) {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf(kthaf�za);													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ktfiyat*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ktfiyat*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}
		});
		button_104.setForeground(Color.WHITE);
		button_104.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_104.setFocusable(false);
		button_104.setBackground(Color.BLACK);
		button_104.setBounds(1016, 562, 42, 20);
		panel.add(button_104);
		
		txt_isim = new JTextField();
		txt_isim.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_TAB)
					
					txt_fiyat.requestFocus();
					txt_fiyat.setText("");
			}
		});
		txt_isim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_isim.setText("");
			}
		});
		txt_isim.setHorizontalAlignment(SwingConstants.CENTER);
		txt_isim.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_isim.setBorder(null);
		txt_isim.setBounds(941, 493, 134, 20);
		panel.add(txt_isim);
		txt_isim.setColumns(10);
		
		txt_fiyat = new JTextField();
		txt_fiyat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_fiyat.setText("");
			}
		});
		txt_fiyat.setHorizontalAlignment(SwingConstants.CENTER);
		txt_fiyat.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_fiyat.setColumns(10);
		txt_fiyat.setBorder(null);
		txt_fiyat.setBounds(941, 524, 134, 20);
		panel.add(txt_fiyat);
		
		JLabel lblrnIsmi = new JLabel("\u00DCr\u00FCn ismi");
		lblrnIsmi.setHorizontalAlignment(SwingConstants.CENTER);
		lblrnIsmi.setForeground(Color.WHITE);
		lblrnIsmi.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblrnIsmi.setBounds(848, 496, 83, 20);
		panel.add(lblrnIsmi);
		
		JLabel lblFiyat = new JLabel("Fiyat");
		lblFiyat.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiyat.setForeground(Color.WHITE);
		lblFiyat.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiyat.setBounds(848, 527, 83, 20);
		panel.add(lblFiyat);
		
		
		
		
		Ceket.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		int index = t�r.indexOf("Ceket");											//de�i�tir
		if (index==-1) {				
		String st = kuru.getText();
		int temizleme = Integer.valueOf(st);
		toplamfiyat += temizleme*ceketkt;												//de�i�tir
		sat�rlar[0] = "Ceket";														//de�i�tir
		sat�rlar[1] = "Kuru Temizleme";
		sat�rlar[2] = temizleme;
		sat�rlar[3] = temizleme*ceketkt;												//de�i�tir
		modelim.addRow(sat�rlar);
		
		ka��nc�sat�r+=1;
		haf�za1=ka��nc�sat�r;
		t�r.add("Ceket");															//de�i�tir
		
			
			String s = String.valueOf(toplamfiyat);
			txt_toplam.setText(s);
			kuru.setText("1");
			txt_geneltoplam.setText(s);
		}
		
		else {
			JOptionPane uyar� = new JOptionPane();
			uyar�.showMessageDialog(null, "Ceket zaten se�ili.","", 1);
		}
			}
		});
		//panel_1.setBounds(x, y, width, height);
		tabbedPane.addTab(null,�t�icon, panel_1, null);
		panel_1.setLayout(null);
		
		JButton Ceket� = new JButton("");
		Ceket�.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ceket.png")));
		Ceket�.setBounds(294, 17, 83, 90);
		panel_1.add(Ceket�);
		Ceket�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Ceket�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ceket�;												//de�i�tir
				sat�rlar[0] = "Ceket";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ceket�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Ceket�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Ceket zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		Ceket�.setFocusable(false);
		
		JButton G�mlek� = new JButton("");
		G�mlek�.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/gomlek.png")));
		G�mlek�.setBounds(581, 161, 83, 90);
		panel_1.add(G�mlek�);
		G�mlek�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("G�mlek�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*g�mlek�;												//de�i�tir
				sat�rlar[0] = "G�mlek";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*g�mlek�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("G�mlek�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "G�mlek zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		G�mlek�.setFocusable(false);
		
		JButton Pantolon� = new JButton("");
		Pantolon�.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/pantolon.png")));
		Pantolon�.setBounds(437, 449, 83, 90);
		panel_1.add(Pantolon�);
		Pantolon�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Pantolon�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*pantolon�;												//de�i�tir
				sat�rlar[0] = "Pantolon";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*pantolon�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Pantolon�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Pantolon zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		Pantolon�.setFocusable(false);
		
		JButton Yelek� = new JButton("");
		Yelek�.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yelek.png")));
		Yelek�.setBounds(721, 17, 83, 90);
		panel_1.add(Yelek�);
		Yelek�.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yelek�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*yelek�;												//de�i�tir
				sat�rlar[0] = "Yelek";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*yelek�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yelek�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yelek zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		Yelek�.setFocusable(false);
		
		JButton btnNewButton = new JButton("Son sat�r� sil");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(165, 42, 42));
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int rowCount = modelim.getRowCount();
				for (int i = rowCount-1; i>=0 ; i++) {
					double d = (double) modelim.getValueAt(i, 3);
					
					
					//System.out.println(d);
					toplamfiyat=toplamfiyat-d;
					modelim.removeRow(i);
					String temp = txt_toplam.getText();
					double temp2= Double.valueOf(temp);
					temp2=temp2-d;
					String stcevir = Double.toString(temp2);
					txt_toplam.setText(stcevir);
					txt_geneltoplam.setText(stcevir);
					
					t�r.remove(i);
					
					break;
					
				}
			
			}
		});
		btnNewButton.setBounds(1028, 48, 104, 23);
		panel_1.add(btnNewButton);
		
		JButton button_8 = new JButton("+");
		button_8.setForeground(new Color(255, 255, 255));
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_8.setBackground(new Color(165, 42, 42));
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Ceket�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ceket�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ceket�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_8.setFocusable(false);
		button_8.setBounds(294, 130, 42, 20);
		panel_1.add(button_8);
		
		JButton button_9 = new JButton("+");
		button_9.setForeground(new Color(255, 255, 255));
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_9.setBackground(new Color(165, 42, 42));
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("G�mlek�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=g�mlek�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += g�mlek�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_9.setFocusable(false);
		button_9.setBounds(581, 274, 42, 20);
		panel_1.add(button_9);
		
		JButton button_10 = new JButton("+");
		button_10.setForeground(new Color(255, 255, 255));
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_10.setBackground(new Color(165, 42, 42));
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Pantolon�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=pantolon�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += pantolon�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_10.setFocusable(false);
		button_10.setBounds(437, 562, 42, 20);
		panel_1.add(button_10);
		
		JButton button_11 = new JButton("+");
		button_11.setForeground(new Color(255, 255, 255));
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_11.setBackground(new Color(165, 42, 42));
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yelek�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=yelek�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += yelek�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_11.setFocusable(false);
		button_11.setBounds(721, 130, 42, 20);
		panel_1.add(button_11);
		
		JButton button_12 = new JButton("-");
		button_12.setForeground(new Color(255, 255, 255));
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_12.setBackground(new Color(165, 42, 42));
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Ceket");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Ceket") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Ceket");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ceket�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ceket�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				}
		});
		button_12.setFocusable(false);
		button_12.setBounds(336, 130, 42, 20);
		panel_1.add(button_12);
		
		JButton button_13 = new JButton("-");
		button_13.setForeground(new Color(255, 255, 255));
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_13.setBackground(new Color(165, 42, 42));
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("G�mlek�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="G�mlek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("G�mlek�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=g�mlek�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= g�mlek�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				}
		});
		button_13.setFocusable(false);
		button_13.setBounds(623, 274, 42, 20);
		panel_1.add(button_13);
		
		JButton button_14 = new JButton("-");
		button_14.setForeground(new Color(255, 255, 255));
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_14.setBackground(new Color(165, 42, 42));
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Pantolon�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Pantolon") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Pantolon�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=pantolon�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= pantolon�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				}
		});
		button_14.setFocusable(false);
		button_14.setBounds(479, 562, 42, 20);
		panel_1.add(button_14);
		
		JButton button_15 = new JButton("-");
		button_15.setForeground(new Color(255, 255, 255));
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_15.setBackground(new Color(165, 42, 42));
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Yelek�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Yelek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Yelek�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=3.0*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= 3.0*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				}
		});
		button_15.setFocusable(false);
		button_15.setBounds(763, 130, 42, 20);
		panel_1.add(button_15);
		
		JButton button_27 = new JButton("");
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek Bluz�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ib�;												//de�i�tir
				sat�rlar[0] = "�pek Bluz";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ib�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek Bluz�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek Bluz zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_27.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipekbluz.png")));
		button_27.setFocusable(false);
		button_27.setBounds(581, 17, 83, 90);
		panel_1.add(button_27);
		
		JLabel label_4 = new JLabel("\u0130PEK BLUZ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(581, 109, 83, 20);
		panel_1.add(label_4);
		
		JButton button_34 = new JButton("");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Mont�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*mont�;												//de�i�tir
				sat�rlar[0] = "Mont";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*mont�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Mont�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Mont zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_34.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/mont.png")));
		button_34.setFocusable(false);
		button_34.setBounds(10, 449, 83, 90);
		panel_1.add(button_34);
		
		JLabel label_5 = new JLabel("MONT");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(32, 541, 42, 20);
		panel_1.add(label_5);
		
		JButton button_43 = new JButton("");
		button_43.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Tak�m Elbise�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*te�;												//de�i�tir
				sat�rlar[0] = "Tak�m Elbise";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*te�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Tak�m Elbise�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Tak�m Elbise zaten se�ili.","", 1);		//de�i�tir
				}
					
			}
		});
		button_43.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/takimelbise.png")));
		button_43.setFocusable(false);
		button_43.setBounds(10, 593, 83, 90);
		panel_1.add(button_43);
		
		JLabel label_6 = new JLabel("TAKIM ELB\u0130SE");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(9, 684, 95, 20);
		panel_1.add(label_6);
		
		JButton button_61 = new JButton("");
		button_61.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("D�piyes�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*d�piyes�;												//de�i�tir
				sat�rlar[0] = "D�piyes";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*d�piyes�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("D�piyes�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "D�piyes zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_61.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/dopiyes.png")));
		button_61.setFocusable(false);
		button_61.setBounds(11, 161, 83, 90);
		panel_1.add(button_61);
		
		JLabel label_8 = new JLabel("D\u00D6P\u0130YES");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(10, 253, 83, 20);
		panel_1.add(label_8);
		
		JButton button_70 = new JButton("");
		button_70.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek E�arp�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ie�;												//de�i�tir
				sat�rlar[0] = "�pek E�arp";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ie�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek E�arp�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek E�arp zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_70.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipekesarp.png")));
		button_70.setFocusable(false);
		button_70.setBounds(12, 305, 83, 90);
		panel_1.add(button_70);
		
		JLabel label_9 = new JLabel("\u0130PEK E\u015EARP");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_9.setBounds(10, 397, 83, 20);
		panel_1.add(label_9);
		
		JButton button_79 = new JButton("");
		button_79.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Nevresim Tak�m��");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*nevresim�;												//de�i�tir
				sat�rlar[0] = "Nevresim Tak�m�";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*nevresim�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Nevresim Tak�m�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Nevresim Tak�m� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_79.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/nevresim.png")));
		button_79.setFocusable(false);
		button_79.setBounds(153, 449, 83, 90);
		panel_1.add(button_79);
		
		JLabel label_10 = new JLabel("NEVRES\u0130M");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_10.setBounds(153, 541, 83, 20);
		panel_1.add(label_10);
		
		JButton button_88 = new JButton("");
		button_88.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Tren�kot�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*tren�kot�;												//de�i�tir
				sat�rlar[0] = "Tren�kot";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*tren�kot�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Tren�kot�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Tren�kot zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_88.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/trenckot.png")));
		button_88.setFocusable(false);
		button_88.setBounds(153, 593, 83, 90);
		panel_1.add(button_88);
		
		JLabel label_11 = new JLabel("TREN\u00C7KOT");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_11.setBounds(153, 684, 83, 20);
		panel_1.add(label_11);
		
		JButton button_106 = new JButton("");
		button_106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Elbise�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*elbise�;												//de�i�tir
				sat�rlar[0] = "Elbise";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*elbise�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Elbise�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Elbise zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_106.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/elbise.png")));
		button_106.setFocusable(false);
		button_106.setBounds(153, 161, 83, 90);
		panel_1.add(button_106);
		
		JLabel label_13 = new JLabel("ELB\u0130SE");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_13.setBounds(152, 253, 83, 20);
		panel_1.add(label_13);
		
		JButton button_109 = new JButton("");
		button_109.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�pek �al�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*i��;												//de�i�tir
				sat�rlar[0] = "�pek �al";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*i��;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�pek �al�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�pek �al zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_109.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/ipeksal.png")));
		button_109.setFocusable(false);
		button_109.setBounds(154, 305, 83, 90);
		panel_1.add(button_109);
		
		JLabel label_14 = new JLabel("\u0130PEK \u015EAL");
		label_14.setHorizontalAlignment(SwingConstants.CENTER);
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_14.setBounds(152, 397, 83, 20);
		panel_1.add(label_14);
		
		JButton button_112 = new JButton("");
		button_112.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Palto�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*palto�;												//de�i�tir
				sat�rlar[0] = "Palto";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*palto�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Palto�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Palto zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_112.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/palto.png")));
		button_112.setFocusable(false);
		button_112.setBounds(296, 449, 83, 90);
		panel_1.add(button_112);
		
		JLabel label_15 = new JLabel("PALTO");
		label_15.setHorizontalAlignment(SwingConstants.CENTER);
		label_15.setForeground(Color.WHITE);
		label_15.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_15.setBounds(294, 541, 83, 20);
		panel_1.add(label_15);
		
		JButton button_115 = new JButton("");
		button_115.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Ti��rt�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ti��rt�;												//de�i�tir
				sat�rlar[0] = "Ti��rt";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ti��rt�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Ti��rt�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Ti��rt zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_115.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/tshirt.png")));
		button_115.setFocusable(false);
		button_115.setBounds(295, 593, 83, 90);
		panel_1.add(button_115);
		
		JLabel label_16 = new JLabel("T\u0130\u015E\u00D6RT");
		label_16.setHorizontalAlignment(SwingConstants.CENTER);
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_16.setBounds(294, 684, 83, 20);
		panel_1.add(label_16);
		
		JButton button_118 = new JButton("");
		button_118.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Bayan Tak�m�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*bt�;												//de�i�tir
				sat�rlar[0] = "Bayan Tak�m";														//de�i�tir
				sat�rlar[1] = "�t�";														
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*bt�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Bayan Tak�m�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Bayan Tak�m zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_118.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/bayantakim.png")));
		button_118.setFocusable(false);
		button_118.setBounds(10, 17, 83, 90);
		panel_1.add(button_118);
		
		JLabel label_17 = new JLabel("BAYAN TAKIM");
		label_17.setHorizontalAlignment(SwingConstants.CENTER);
		label_17.setForeground(Color.WHITE);
		label_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_17.setBounds(0, 107, 104, 20);
		panel_1.add(label_17);
		
		JButton button_124 = new JButton("");
		button_124.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kaban�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kaban�;												//de�i�tir
				sat�rlar[0] = "Kaban";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kaban�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kaban");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kaban� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_124.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kaban.png")));
		button_124.setFocusable(false);
		button_124.setBounds(296, 305, 83, 90);
		panel_1.add(button_124);
		
		JLabel label_19 = new JLabel("KABAN");
		label_19.setHorizontalAlignment(SwingConstants.CENTER);
		label_19.setForeground(Color.WHITE);
		label_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_19.setBounds(294, 397, 83, 20);
		panel_1.add(label_19);
		
		JButton button_130 = new JButton("");
		button_130.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yast�k�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*yast�k�;												//de�i�tir
				sat�rlar[0] = "Yast�k";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*yast�k�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yast�k�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yast�k zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_130.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yastik.png")));
		button_130.setFocusable(false);
		button_130.setBounds(437, 593, 83, 90);
		panel_1.add(button_130);
		
		JLabel label_21 = new JLabel("YASTIK");
		label_21.setHorizontalAlignment(SwingConstants.CENTER);
		label_21.setForeground(Color.WHITE);
		label_21.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_21.setBounds(437, 684, 83, 20);
		panel_1.add(label_21);
		
		JButton button_133 = new JButton("");
		button_133.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Bluz�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*bluz�;												//de�i�tir
				sat�rlar[0] = "Bluz";														//de�i�tir
				sat�rlar[1] = "�t�";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*bluz�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Bluz�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Bluz zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_133.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/bluz.png")));
		button_133.setFocusable(false);
		button_133.setBounds(152, 17, 83, 90);
		panel_1.add(button_133);
		
		JLabel label_22 = new JLabel("BLUZ");
		label_22.setHorizontalAlignment(SwingConstants.CENTER);
		label_22.setForeground(Color.WHITE);
		label_22.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_22.setBounds(153, 111, 83, 20);
		panel_1.add(label_22);
		
		JButton button_136 = new JButton("");
		button_136.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Etek�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*etek�;												//de�i�tir
				sat�rlar[0] = "Etek";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*etek�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Etek�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Etek zaten se�ili.","", 1);		//de�i�tir
				}
					
			
				
			}
		});
		button_136.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/etek.png")));
		button_136.setFocusable(false);
		button_136.setBounds(297, 161, 83, 90);
		panel_1.add(button_136);
		
		JLabel label_23 = new JLabel("ETEK");
		label_23.setHorizontalAlignment(SwingConstants.CENTER);
		label_23.setForeground(Color.WHITE);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_23.setBounds(297, 253, 83, 20);
		panel_1.add(label_23);
		
		JButton button_139 = new JButton("");
		button_139.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kazak�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kazak�;												//de�i�tir
				sat�rlar[0] = "Kazak";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kazak�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kazak�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kazak zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_139.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kazak.png")));
		button_139.setFocusable(false);
		button_139.setBounds(438, 305, 83, 90);
		panel_1.add(button_139);
		
		JLabel label_24 = new JLabel("KAZAK");
		label_24.setHorizontalAlignment(SwingConstants.CENTER);
		label_24.setForeground(Color.WHITE);
		label_24.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_24.setBounds(437, 397, 83, 20);
		panel_1.add(label_24);
		
		JLabel label_25 = new JLabel("PANTOLON");
		label_25.setHorizontalAlignment(SwingConstants.CENTER);
		label_25.setForeground(Color.WHITE);
		label_25.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_25.setBounds(438, 541, 83, 20);
		panel_1.add(label_25);
		
		JButton button_145 = new JButton("");
		button_145.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yatak �rt�s��");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*y��;												//de�i�tir
				sat�rlar[0] = "Yatak �rt�s�";														//de�i�tir
				sat�rlar[1] = "�t�";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*y��;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yatak �rt�s��");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yatak �rt�s� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_145.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yatakortusu.png")));
		button_145.setFocusable(false);
		button_145.setBounds(579, 593, 83, 90);
		panel_1.add(button_145);
		
		JLabel label_26 = new JLabel("YATAK \u00D6RT\u00DCS\u00DC");
		label_26.setHorizontalAlignment(SwingConstants.CENTER);
		label_26.setForeground(Color.WHITE);
		label_26.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_26.setBounds(569, 684, 104, 20);
		panel_1.add(label_26);
		
		JLabel label_27 = new JLabel("CEKET");
		label_27.setHorizontalAlignment(SwingConstants.CENTER);
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_27.setBounds(295, 110, 83, 20);
		panel_1.add(label_27);
		
		JButton button_151 = new JButton("");
		button_151.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Gece Elbisesi�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*ge�;												//de�i�tir
				sat�rlar[0] = "Gece Elbisesi";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*ge�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Gece Elbisesi�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Gece Elbisesi zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_151.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/geceelbisesi.png")));
		button_151.setFocusable(false);
		button_151.setBounds(439, 161, 83, 90);
		panel_1.add(button_151);
		
		JLabel label_28 = new JLabel("GECE ELB\u0130SES\u0130");
		label_28.setHorizontalAlignment(SwingConstants.CENTER);
		label_28.setForeground(Color.WHITE);
		label_28.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_28.setBounds(428, 253, 109, 20);
		panel_1.add(label_28);
		
		JButton button_157 = new JButton("");
		button_157.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Pardes��");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*pardes��;												//de�i�tir
				sat�rlar[0] = "Pardes�";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*pardes��;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Pardes��");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Pardes� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_157.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/pardesu.png")));
		button_157.setFocusable(false);
		button_157.setBounds(580, 449, 83, 90);
		panel_1.add(button_157);
		
		JLabel label_30 = new JLabel("PARDES\u00DC");
		label_30.setHorizontalAlignment(SwingConstants.CENTER);
		label_30.setForeground(Color.WHITE);
		label_30.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_30.setBounds(579, 541, 83, 20);
		panel_1.add(label_30);
		

		JFormattedTextField teslimtarihi = new JFormattedTextField(new MaskFormatter("##.##.####"));
		teslimtarihi.setHorizontalAlignment(SwingConstants.CENTER);
		teslimtarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		teslimtarihi.setColumns(10);
		teslimtarihi.setBorder(null);
		teslimtarihi.setBackground(Color.WHITE);
		teslimtarihi.setBounds(1475, 144, 106, 20);
		contentPane.add(teslimtarihi);
		
		tarihtut=teslimtarihi.getText();
		
		JLabel label_31 = new JLabel("YELEK");
		label_31.setHorizontalAlignment(SwingConstants.CENTER);
		label_31.setForeground(Color.WHITE);
		label_31.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_31.setBounds(721, 108, 83, 20);
		panel_1.add(label_31);
		
		JButton button_163 = new JButton("");
		button_163.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("damatl�k�");											//de�i�tir
				
				if (index==-1) {				
				String st = �t�.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*damatl�k�;												//de�i�tir
				sat�rlar[0] = "Damatl�k";														//de�i�tir
				sat�rlar[1] = "�t�";
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*damatl�k�;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("damatl�k�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					�t�.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Damatl�k zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			}
		});
		button_163.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/damatlik.png")));
		button_163.setFocusable(false);
		button_163.setBounds(436, 17, 83, 90);
		panel_1.add(button_163);
		
		JLabel label_32 = new JLabel("DAMATLIK");
		label_32.setHorizontalAlignment(SwingConstants.CENTER);
		label_32.setForeground(Color.WHITE);
		label_32.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_32.setBounds(436, 111, 83, 20);
		panel_1.add(label_32);
		
		JLabel label_33 = new JLabel("G\u00D6MLEK");
		label_33.setHorizontalAlignment(SwingConstants.CENTER);
		label_33.setForeground(Color.WHITE);
		label_33.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_33.setBounds(581, 253, 83, 20);
		panel_1.add(label_33);
		
		
		JComboBox masaortusu = new JComboBox();
		masaortusu.setModel(new DefaultComboBoxModel(new String[] {"4 ki\u015Filik", "8 ki\u015Filik", "12 ki\u015Filik"}));
		masaortusu.setBounds(668, 315, 39, 22);
		panel_1.add(masaortusu);
		
		JButton button_169 = new JButton("");
		button_169.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusu.getSelectedIndex();
				if (secilen==0) {
				

					int index = t�r.indexOf("4kMasa �rt�s��");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*dkm��;												//de�i�tir
					sat�rlar[0] = "D�rt K Masa �rt�s�";														//de�i�tir
					sat�rlar[1] = "�t�";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*dkm��;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("4kMasa �rt�s��");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "4 ki�ilik masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
					}
						
				
				
				
				
				}
				if (secilen==1){

					int index = t�r.indexOf("8kMasa �rt�s��");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*skm��;												//de�i�tir
					sat�rlar[0] = "Sekiz K Masa �rt�s�";														//de�i�tir
					sat�rlar[1] = "�t�";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*skm��;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("8kMasa �rt�s��");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Sekiz K Masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
					}
						
				
					
					
				}
				if (secilen==2){

					int index = t�r.indexOf("12kMasa �rt�s��");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*onikikm��;												//de�i�tir
					sat�rlar[0] = "Oniki K Masa �rt�s�";														//de�i�tir
					sat�rlar[1] = "�t�";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*onikikm��;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("12kMasa �rt�s��");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Oniki K Masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
					}
						
				
					
				
				}
				
				
				
			}
		});
		button_169.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/masaortusu.png")));
		button_169.setFocusable(false);
		button_169.setBounds(581, 305, 83, 90);
		panel_1.add(button_169);
		
		JLabel label_34 = new JLabel("MASA \u00D6RT\u00DCS\u00DC");
		label_34.setHorizontalAlignment(SwingConstants.CENTER);
		label_34.setForeground(Color.WHITE);
		label_34.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_34.setBounds(569, 397, 106, 20);
		panel_1.add(label_34);
		
		JButton button_18 = new JButton("+");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yatak �rt�s��");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=y��*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += y��*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_18.setForeground(Color.WHITE);
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_18.setFocusable(false);
		button_18.setBackground(new Color(165, 42, 42));
		button_18.setBounds(579, 706, 42, 20);
		panel_1.add(button_18);
		
		JButton button_21 = new JButton("-");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Yatak �rt�s��");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Yatak �rt�s�") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Yatak �rt�s��");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=y��*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= y��*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_21.setForeground(Color.WHITE);
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_21.setFocusable(false);
		button_21.setBackground(new Color(165, 42, 42));
		button_21.setBounds(621, 706, 42, 20);
		panel_1.add(button_21);
		
		JButton button_25 = new JButton("+");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yast�k�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=yast�k�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += yast�k�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_25.setForeground(Color.WHITE);
		button_25.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_25.setFocusable(false);
		button_25.setBackground(new Color(165, 42, 42));
		button_25.setBounds(437, 706, 42, 20);
		panel_1.add(button_25);
		
		JButton button_26 = new JButton("-");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Yast�k�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Yast�k") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Yast�k�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=yast�k�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= yast�k�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_26.setForeground(Color.WHITE);
		button_26.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_26.setFocusable(false);
		button_26.setBackground(new Color(165, 42, 42));
		button_26.setBounds(479, 706, 42, 20);
		panel_1.add(button_26);
		
		JButton button_28 = new JButton("+");
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Ti��rt�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ti��rt�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ti��rt�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_28.setForeground(Color.WHITE);
		button_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_28.setFocusable(false);
		button_28.setBackground(new Color(165, 42, 42));
		button_28.setBounds(295, 706, 42, 20);
		panel_1.add(button_28);
		
		JButton button_31 = new JButton("-");
		button_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Ti��rt�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Ti��rt") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Ti��rt�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ti��rt�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ti��rt�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_31.setForeground(Color.WHITE);
		button_31.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_31.setFocusable(false);
		button_31.setBackground(new Color(165, 42, 42));
		button_31.setBounds(337, 706, 42, 20);
		panel_1.add(button_31);
		
		JButton button_37 = new JButton("+");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Tak�m Elbise�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=te�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += te�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			}
		});
		button_37.setForeground(Color.WHITE);
		button_37.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_37.setFocusable(false);
		button_37.setBackground(new Color(165, 42, 42));
		button_37.setBounds(10, 706, 42, 20);
		panel_1.add(button_37);
		
		
		
		JButton button_40 = new JButton("-");
		button_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Tak�m Elbise�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Tak�m Elbise") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Tak�m Elbise�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=te�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= te�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				}
		});
		button_40.setForeground(Color.WHITE);
		button_40.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_40.setFocusable(false);
		button_40.setBackground(new Color(165, 42, 42));
		button_40.setBounds(52, 706, 42, 20);
		panel_1.add(button_40);
		
		JButton button_46 = new JButton("+");
		button_46.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Tren�kot�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=tren�kot�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += tren�kot�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_46.setForeground(Color.WHITE);
		button_46.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_46.setFocusable(false);
		button_46.setBackground(new Color(165, 42, 42));
		button_46.setBounds(154, 706, 42, 20);
		panel_1.add(button_46);
		
		JButton button_49 = new JButton("-");
		button_49.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Tren�kot�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Tren�kot") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Tren�kot�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=tren�kot�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= tren�kot�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_49.setForeground(Color.WHITE);
		button_49.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_49.setFocusable(false);
		button_49.setBackground(new Color(165, 42, 42));
		button_49.setBounds(196, 706, 42, 20);
		panel_1.add(button_49);
		
		JButton button_55 = new JButton("+");
		button_55.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek Bluz�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ib�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ib�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_55.setForeground(Color.WHITE);
		button_55.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_55.setFocusable(false);
		button_55.setBackground(new Color(165, 42, 42));
		button_55.setBounds(581, 130, 42, 20);
		panel_1.add(button_55);
		
		JButton button_58 = new JButton("-");
		button_58.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek Bluz�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek Bluz") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek Bluz�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ib�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ib�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_58.setForeground(Color.WHITE);
		button_58.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_58.setFocusable(false);
		button_58.setBackground(new Color(165, 42, 42));
		button_58.setBounds(622, 130, 42, 20);
		panel_1.add(button_58);
		
		JButton button_64 = new JButton("+");
		button_64.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek E�arp�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ie�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ie�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_64.setForeground(Color.WHITE);
		button_64.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_64.setFocusable(false);
		button_64.setBackground(new Color(165, 42, 42));
		button_64.setBounds(12, 418, 42, 20);
		panel_1.add(button_64);
		
		JButton button_67 = new JButton("-");
		button_67.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek E�arp�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek E�arp") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek E�arp�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ie�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ie�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_67.setForeground(Color.WHITE);
		button_67.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_67.setFocusable(false);
		button_67.setBackground(new Color(165, 42, 42));
		button_67.setBounds(54, 418, 42, 20);
		panel_1.add(button_67);
		
		JButton button_73 = new JButton("+");
		button_73.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�pek �al�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=i��*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += i��*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_73.setForeground(Color.WHITE);
		button_73.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_73.setFocusable(false);
		button_73.setBackground(new Color(165, 42, 42));
		button_73.setBounds(153, 418, 42, 20);
		panel_1.add(button_73);
		
		JButton button_76 = new JButton("-");
		button_76.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�pek �al�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�pek �al") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�pek �al�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=i��*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= i��*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_76.setForeground(Color.WHITE);
		button_76.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_76.setFocusable(false);
		button_76.setBackground(new Color(165, 42, 42));
		button_76.setBounds(195, 418, 42, 20);
		panel_1.add(button_76);
		
		JButton button_82 = new JButton("+");
		button_82.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kaban�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kaban�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kaban�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_82.setForeground(Color.WHITE);
		button_82.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_82.setFocusable(false);
		button_82.setBackground(new Color(165, 42, 42));
		button_82.setBounds(295, 418, 42, 20);
		panel_1.add(button_82);
		
		JButton button_85 = new JButton("-");
		button_85.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kaban�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kaban") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kaban�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kaban�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kaban�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_85.setForeground(Color.WHITE);
		button_85.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_85.setFocusable(false);
		button_85.setBackground(new Color(165, 42, 42));
		button_85.setBounds(337, 418, 42, 20);
		panel_1.add(button_85);
		
		JButton button_93 = new JButton("+");
		button_93.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kazak�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kazak�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kazak�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_93.setForeground(Color.WHITE);
		button_93.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_93.setFocusable(false);
		button_93.setBackground(new Color(165, 42, 42));
		button_93.setBounds(437, 418, 42, 20);
		panel_1.add(button_93);
		
		JButton button_96 = new JButton("-");
		button_96.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kazak�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kazak") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kazak�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kazak�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kazak�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_96.setForeground(Color.WHITE);
		button_96.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_96.setFocusable(false);
		button_96.setBackground(new Color(165, 42, 42));
		button_96.setBounds(479, 418, 42, 20);
		panel_1.add(button_96);
		
		JButton button_110 = new JButton("+");
		button_110.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("D�piyes�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=d�piyes�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += d�piyes�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_110.setForeground(Color.WHITE);
		button_110.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_110.setFocusable(false);
		button_110.setBackground(new Color(165, 42, 42));
		button_110.setBounds(11, 274, 42, 20);
		panel_1.add(button_110);
		
		JButton button_111 = new JButton("-");
		button_111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("D�piyes�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="D�piyes") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("D�piyes�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=d�piyes�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= d�piyes�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_111.setForeground(Color.WHITE);
		button_111.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_111.setFocusable(false);
		button_111.setBackground(new Color(165, 42, 42));
		button_111.setBounds(53, 274, 42, 20);
		panel_1.add(button_111);
		
		JButton button_113 = new JButton("+");
		button_113.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Elbise�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=elbise�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += elbise�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_113.setForeground(Color.WHITE);
		button_113.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_113.setFocusable(false);
		button_113.setBackground(new Color(165, 42, 42));
		button_113.setBounds(152, 274, 42, 20);
		panel_1.add(button_113);
		
		JButton button_114 = new JButton("-");
		button_114.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Elbise�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Elbise") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Elbise�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=10.0*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= 10.0*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_114.setForeground(Color.WHITE);
		button_114.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_114.setFocusable(false);
		button_114.setBackground(new Color(165, 42, 42));
		button_114.setBounds(194, 274, 42, 20);
		panel_1.add(button_114);
		
		JButton button_119 = new JButton("+");
		button_119.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Etek�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=etek�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += etek�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_119.setForeground(Color.WHITE);
		button_119.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_119.setFocusable(false);
		button_119.setBackground(new Color(165, 42, 42));
		button_119.setBounds(296, 274, 42, 20);
		panel_1.add(button_119);
		
		JButton button_120 = new JButton("-");
		button_120.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Etek�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Etek") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Etek�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=etek�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= etek�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_120.setForeground(Color.WHITE);
		button_120.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_120.setFocusable(false);
		button_120.setBackground(new Color(165, 42, 42));
		button_120.setBounds(338, 274, 42, 20);
		panel_1.add(button_120);
		
		JButton button_122 = new JButton("+");
		button_122.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Gece Elbisesi�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=ge�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += ge�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_122.setForeground(Color.WHITE);
		button_122.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_122.setFocusable(false);
		button_122.setBackground(new Color(165, 42, 42));
		button_122.setBounds(438, 274, 42, 20);
		panel_1.add(button_122);
		
		JButton button_123 = new JButton("-");
		button_123.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Gece Elbisesi�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Gece Elbisesi") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Gece Elbisesi�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=ge�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= ge�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_123.setForeground(Color.WHITE);
		button_123.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_123.setFocusable(false);
		button_123.setBackground(new Color(165, 42, 42));
		button_123.setBounds(480, 274, 42, 20);
		panel_1.add(button_123);
		
		JButton button_134 = new JButton("+");
		button_134.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Bayan Tak�m�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=bt�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += bt�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_134.setForeground(Color.WHITE);
		button_134.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_134.setFocusable(false);
		button_134.setBackground(new Color(165, 42, 42));
		button_134.setBounds(10, 130, 42, 20);
		panel_1.add(button_134);
		
		JButton button_135 = new JButton("-");
		button_135.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Bayan Tak�m�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Bayan Tak�m") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Bayan Tak�m�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=bt�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= bt�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_135.setForeground(Color.WHITE);
		button_135.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_135.setFocusable(false);
		button_135.setBackground(new Color(165, 42, 42));
		button_135.setBounds(52, 130, 42, 20);
		panel_1.add(button_135);
		
		JButton button_137 = new JButton("+");
		button_137.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Bluz�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=bluz�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += bluz�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_137.setForeground(Color.WHITE);
		button_137.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_137.setFocusable(false);
		button_137.setBackground(new Color(165, 42, 42));
		button_137.setBounds(152, 130, 42, 20);
		panel_1.add(button_137);
		
		JButton button_138 = new JButton("-");
		button_138.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Bluz�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Bluz") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Bluz�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=bluz�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= bluz�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_138.setForeground(Color.WHITE);
		button_138.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_138.setFocusable(false);
		button_138.setBackground(new Color(165, 42, 42));
		button_138.setBounds(194, 130, 42, 20);
		panel_1.add(button_138);
		
		JButton button_140 = new JButton("+");
		button_140.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Mont�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=mont�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += mont�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_140.setForeground(Color.WHITE);
		button_140.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_140.setFocusable(false);
		button_140.setBackground(new Color(165, 42, 42));
		button_140.setBounds(10, 562, 42, 20);
		panel_1.add(button_140);
		
		JButton button_141 = new JButton("-");
		button_141.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Mont�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Mont") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Mont�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=mont�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= mont�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_141.setForeground(Color.WHITE);
		button_141.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_141.setFocusable(false);
		button_141.setBackground(new Color(165, 42, 42));
		button_141.setBounds(51, 562, 42, 20);
		panel_1.add(button_141);
		
		JButton button_142 = new JButton("+");
		button_142.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Nevresim Tak�m��");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=nevresim�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += nevresim�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_142.setForeground(Color.WHITE);
		button_142.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_142.setFocusable(false);
		button_142.setBackground(new Color(165, 42, 42));
		button_142.setBounds(154, 562, 42, 20);
		panel_1.add(button_142);
		
		JButton button_143 = new JButton("-");
		button_143.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Nevresim Tak�m��");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Nevresim Tak�m�") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Nevresim Tak�m��");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=nevresim�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= nevresim�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_143.setForeground(Color.WHITE);
		button_143.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_143.setFocusable(false);
		button_143.setBackground(new Color(165, 42, 42));
		button_143.setBounds(196, 562, 42, 20);
		panel_1.add(button_143);
		
		JButton button_144 = new JButton("+");
		button_144.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Palto�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=palto�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += palto�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_144.setForeground(Color.WHITE);
		button_144.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_144.setFocusable(false);
		button_144.setBackground(new Color(165, 42, 42));
		button_144.setBounds(295, 562, 42, 20);
		panel_1.add(button_144);
		
		JButton button_146 = new JButton("-");
		button_146.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Palto�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Palto") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Palto�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=palto�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= palto�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_146.setForeground(Color.WHITE);
		button_146.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_146.setFocusable(false);
		button_146.setBackground(new Color(165, 42, 42));
		button_146.setBounds(337, 562, 42, 20);
		panel_1.add(button_146);
		
		JButton button_149 = new JButton("+");
		button_149.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Damatl�k�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=damatl�k�*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += damatl�k�*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_149.setForeground(Color.WHITE);
		button_149.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_149.setFocusable(false);
		button_149.setBackground(new Color(165, 42, 42));
		button_149.setBounds(436, 130, 42, 20);
		panel_1.add(button_149);
		
		JButton button_150 = new JButton("-");
		button_150.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Damatl�k�");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Damatl�k") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Damatl�k�");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=damatl�k�*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= damatl�k�*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_150.setForeground(Color.WHITE);
		button_150.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_150.setFocusable(false);
		button_150.setBackground(new Color(165, 42, 42));
		button_150.setBounds(478, 130, 42, 20);
		panel_1.add(button_150);
		
		JButton button_152 = new JButton("+");
		button_152.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusu.getSelectedIndex();
				if (secilen==0) {
				
					int index= t�r.indexOf("4kMasa �rt�s��");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=dkm��*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += dkm��*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
				else if(secilen==1){
					int index= t�r.indexOf("8kMasa �rt�s��");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=skm��*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += skm��*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
				else if(secilen==2){
					int index= t�r.indexOf("12kMasa �rt�s��");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=onikikm��*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += onikikm��*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
				
				}
			
		});
		button_152.setForeground(Color.WHITE);
		button_152.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_152.setFocusable(false);
		button_152.setBackground(new Color(165, 42, 42));
		button_152.setBounds(581, 418, 42, 20);
		panel_1.add(button_152);
		
		JButton button_153 = new JButton("-");
		button_153.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusu.getSelectedIndex();
				if (secilen==0) {
					
					int index= t�r.indexOf("4kMasa �rt�s��");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="D�rt K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("4kMasa �rt�s��");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=dkm��*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= dkm��*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
			
				}
				else if(secilen==1){


					
					int index= t�r.indexOf("8kMasa �rt�s��");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Sekiz K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("8kMasa �rt�s��");									
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=skm��*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= skm��*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
			
				
				}
				else if (secilen==2){

					
					int index= t�r.indexOf("12kMasa �rt�s��");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Oniki K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("12kMasa �rt�s��");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=onikikm��*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= onikikm��*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
					
				
					
				}
				
				
			}
		});
		button_153.setForeground(Color.WHITE);
		button_153.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_153.setFocusable(false);
		button_153.setBackground(new Color(165, 42, 42));
		button_153.setBounds(623, 418, 42, 20);
		panel_1.add(button_153);
		
		JButton button_155 = new JButton("+");
		button_155.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Pardes��");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=pardes��*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += pardes��*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_155.setForeground(Color.WHITE);
		button_155.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_155.setFocusable(false);
		button_155.setBackground(new Color(165, 42, 42));
		button_155.setBounds(579, 562, 42, 20);
		panel_1.add(button_155);
		
		JButton button_156 = new JButton("-");
		button_156.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Pardes��");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Pardes�") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Pardes��");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=pardes��*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= pardes��*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_156.setForeground(Color.WHITE);
		button_156.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_156.setFocusable(false);
		button_156.setBackground(new Color(165, 42, 42));
		button_156.setBounds(621, 562, 42, 20);
		panel_1.add(button_156);
		
		JButton button_22 = new JButton("");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (�t�haf�za==txt_isim.getText()) {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
						
					//de�i�tir
					String isim = txt_isimm.getText();
					String fiy = txt_fiyatt.getText();
					double fiyat = Double.valueOf(fiy);
					int index = t�r.indexOf(isim); 
					
					if (index==-1) {
						�t�haf�za=isim;
						�t�fiyat=fiyat;
						
					String st = �t�.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*fiyat;												//de�i�tir
					sat�rlar[0] = isim;														//de�i�tir
					sat�rlar[1] = "�t�";
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*fiyat;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add(isim);															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						�t�.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
				} catch (Exception e2) {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�sim veya fiyat belirleyiniz.","", 1);
				}
				
					
			}
		});
		button_22.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/\u00FCt\u00FC.png")));
		button_22.setFocusable(false);
		button_22.setBounds(923, 345, 163, 124);
		panel_1.add(button_22);
		
		JLabel label_2 = new JLabel("BA\u015EKA B\u0130R T\u00DCR G\u0130R");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(931, 471, 149, 20);
		panel_1.add(label_2);
		
		txt_isimm = new JTextField();
		txt_isimm.setHorizontalAlignment(SwingConstants.CENTER);
		txt_isimm.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_isimm.setColumns(10);
		txt_isimm.setBorder(null);
		txt_isimm.setBounds(941, 493, 134, 20);
		panel_1.add(txt_isimm);
		
		JLabel label_18 = new JLabel("\u00DCr\u00FCn ismi");
		label_18.setHorizontalAlignment(SwingConstants.CENTER);
		label_18.setForeground(Color.WHITE);
		label_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_18.setBounds(848, 496, 83, 20);
		panel_1.add(label_18);
		
		JLabel label_20 = new JLabel("Fiyat");
		label_20.setHorizontalAlignment(SwingConstants.CENTER);
		label_20.setForeground(Color.WHITE);
		label_20.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_20.setBounds(848, 527, 83, 20);
		panel_1.add(label_20);
		
		txt_fiyatt = new JTextField();
		txt_fiyatt.setHorizontalAlignment(SwingConstants.CENTER);
		txt_fiyatt.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_fiyatt.setColumns(10);
		txt_fiyatt.setBorder(null);
		txt_fiyatt.setBounds(941, 524, 134, 20);
		panel_1.add(txt_fiyatt);
		
		JButton button_23 = new JButton("+");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf(�t�haf�za);									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=�t�fiyat*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += �t�fiyat*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_23.setForeground(Color.WHITE);
		button_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_23.setFocusable(false);
		button_23.setBackground(new Color(165, 42, 42));
		button_23.setBounds(962, 562, 42, 20);
		panel_1.add(button_23);
		
		JButton button_29 = new JButton("-");
		button_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf(�t�haf�za);													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim==�t�haf�za) {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf(�t�haf�za);													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=�t�fiyat*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= �t�fiyat*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			}
		});
		button_29.setForeground(Color.WHITE);
		button_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_29.setFocusable(false);
		button_29.setBackground(new Color(165, 42, 42));
		button_29.setBounds(1016, 562, 42, 20);
		panel_1.add(button_29);
	
		
		JPanel panel_2 = new JPanel();
		ImageIcon perdeicon = (new ImageIcon(Dashboard.class.getResource("/perde.png")));
		panel_2.setBackground(new Color(128, 0, 128));
		tabbedPane.addTab(null, perdeicon, panel_2, null);
		panel_2.setLayout(null);
		
		temiz = new JTextField();
		temiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				temiz.setText(null);
			}
		});
		temiz.setText("1");
		temiz.setHorizontalAlignment(SwingConstants.CENTER);
		temiz.setFont(new Font("Tahoma", Font.BOLD, 12));
		temiz.setColumns(10);
		temiz.setBounds(1060, 17, 39, 20);
		panel_2.add(temiz);
		
		JButton btnNewButton_2 = new JButton("Son sat\u0131r\u0131 sil");
		btnNewButton_2.setBackground(new Color(0, 0, 128));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFocusable(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				int rowCount = modelim.getRowCount();
				for (int i = rowCount-1; i>=0 ; i++) {
					double d = (double) modelim.getValueAt(i, 3);
					
					
					//System.out.println(d);
					toplamfiyat=toplamfiyat-d;
					modelim.removeRow(i);
					String temp = txt_toplam.getText();
					double temp2= Double.valueOf(temp);
					temp2=temp2-d;
					String stcevir = Double.toString(temp2);
					txt_toplam.setText(stcevir);
					
					t�r.remove(i);
					
					break;
					
				}
			
			}
		});
		btnNewButton_2.setBounds(1028, 48, 104, 23);
		panel_2.add(btnNewButton_2);
		
		
		
		txt_ad = new JTextField();
		txt_ad.setForeground(new Color(0, 0, 0));
		txt_ad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_ad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_ad.setEditable(false);
		txt_ad.setFocusable(false);
		txt_ad.setBounds(1195, 81, 190, 20);
		

		txt_ad.setColumns(10);
		txt_ad.setBorder(null);
		txt_ad.setBackground(new Color(230, 230, 250));
		contentPane.add(txt_ad);
		
		txt_soyad = new JTextField();
		txt_soyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_soyad.setHorizontalAlignment(SwingConstants.CENTER);
		txt_soyad.setEditable(false);
		txt_soyad.setFocusable(false);
		txt_soyad.setBounds(1195, 103, 190, 20);
		txt_soyad.setColumns(10);
		txt_soyad.setBorder(null);
		txt_soyad.setBackground(new Color(230, 230, 250));
		contentPane.add(txt_soyad);
		
		JLabel lbl_tarih = new JLabel(tarih);
		lbl_tarih.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tarih.setForeground(Color.WHITE);
		lbl_tarih.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_tarih.setBounds(1569, 7, 115, 22);
		contentPane.add(lbl_tarih);
		showDate();
		lbl_tarih.setText(tarih);
		

		JLabel makbuzno = new JLabel("");
		makbuzno.setForeground(new Color(255, 255, 240));
		makbuzno.setFont(new Font("Tahoma", Font.BOLD, 16));
		makbuzno.setHorizontalAlignment(SwingConstants.CENTER);
		makbuzno.setBounds(1550, 42, 72, 22);
		contentPane.add(makbuzno);
		
		JButton btnNewButton_5 = new JButton("Sipari\u015Fi Onayla");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String kontrol = txt_geneltoplam.getText();
				double dkontrol = Double.valueOf(kontrol);
				int sat�rsay�s� = modelim.getRowCount();
				
				if (sat�rsay�s�==0) {
					JOptionPane uyar�2 = new JOptionPane();
					uyar�2.showMessageDialog(null, "L�tfen en az 1 �r�n se�iniz.", "", 2);	}
				else if (dkontrol<0.0) {
					JOptionPane uyar�3 = new JOptionPane();
					uyar�3.showMessageDialog(null, "Toplam tutar yanl��.", "", 2);
				}
				else {
					JOptionPane uyar�1 = new JOptionPane();
					int rv = uyar�1.showConfirmDialog(null,"Sipari�i onayl�yor musunuz?","Onay", 2);
					if (rv==0) {
						String sql_sorgu,sorgula,siparis,geneltoplam = null;
						siparis = txt_geneltoplam.getText();
						sorgula= "select * from toplamkazanc";
						
						SqlSorgu.bakiye();
						
						ResultSet myRs = SqlSorgu.sorgula(sorgula);
						
						try {
							while(myRs.next()) {
							geneltoplam= myRs.getString("ToplamKazan�");
							
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						double sp = Double.valueOf(siparis);
					
						
						
						txt_toplam.setText("0.0");
						txt_geneltoplam.setText("0.0");
						
						//mustericari tablosu
						String mustericari = "update mustericari set siparis_sayisi=siparis_sayisi+1 , gelir=gelir+"+sp+" where idmustericari="+numara+"";
						SqlSorgu.guncelle(mustericari);
						
						//
						
						int satirsayisi = modelim.getRowCount();

						for (int i = 0; i < satirsayisi; i++) {
							String kont = (String) modelim.getValueAt(i, 1);
							
							if(kont=="Kuru Temizleme") {
							String �r�nn = (String) modelim.getValueAt(i, 0);
							String �r�n = �r�nn.replaceAll("\\s","");
							int adets = (int) modelim.getValueAt(i, 2);
							String sipariskayit= "update sipariskayit set "+�r�n+"="+�r�n+"+"+adets+" where idsipariskayit="+numara+"";
							//System.out.println(sipariskayit);
							SqlSorgu.guncelle(sipariskayit);	}
							
							else if (kont=="�t�") {
								String �r�nn = (String) modelim.getValueAt(i, 0);
								String �r�n = �r�nn.replaceAll("\\s","");
								int adets = (int) modelim.getValueAt(i, 2);
								String sipariskayit= "update sipariskayit set "+�r�n+"�t�="+�r�n+"�t�+"+adets+" where idsipariskayit="+numara+"";
								//System.out.println(sipariskayit);
								SqlSorgu.guncelle(sipariskayit);
							}
							
							else if (kont=="Temizleme") {
								String �r�nn = (String) modelim.getValueAt(i, 0);
								String �r�n = �r�nn.replaceAll("\\s","");
								int adets = (int) modelim.getValueAt(i, 2);
								String sipariskayit= "update sipariskayit set "+�r�n+"="+�r�n+"+"+adets+" where idsipariskayit="+numara+"";
								//System.out.println(sipariskayit);
								SqlSorgu.guncelle(sipariskayit);
							}
							
						}
						// S�PAR�SDURUMU TABLOSU
						
						String tut = musteriid.getText();
						int mid = Integer.valueOf(tut);
						String tut1 = lbl_tarih.getText();
						String al�nantarih = teslimtarihi.getText();
						String ttarih = al�nantarih.replaceAll("\\s", "");
						ttarih=ttarih.replaceAll("\\.", "");
						
						String sno = siparis1.getText();
						int siparisno = Integer.valueOf(sno);
						
						
						String siparisdurumu = "insert into siparisdurumu(idmusteri,ad,soyad,siparisno,siparistarihi,teslimtarihi,teslimdurumu,siparistutari,makbuzno) values"
								+ "("+mid+",'"+txt_ad.getText()+"','"+txt_soyad.getText()+"',"+siparisno+",'"+tut1+"','"+teslimtarihi.getText()+"',0,"+sp+","+makbuzno.getText()+")";
						SqlSorgu.guncelle(siparisdurumu);
						
						for (int i1 = 0; i1 < satirsayisi; i1++) {
							String kontrolet = (String) modelim.getValueAt(i1, 1);
							
							if (kontrolet=="Kuru Temizleme") {							
							String �r�nn1 = (String) modelim.getValueAt(i1, 0);
							String �r�n1 = �r�nn1.replaceAll("\\s","");
							int adets = (int) modelim.getValueAt(i1, 2);
							String siparisguncelle= "update siparisdurumu set "+�r�n1+"="+�r�n1+"+"+adets+" where siparisno="+siparisno+"";
							SqlSorgu.guncelle(siparisguncelle);
							}
							else if (kontrolet=="�t�") {
								String �r�nn1 = (String) modelim.getValueAt(i1, 0);
								String �r�n1 = �r�nn1.replaceAll("\\s","");
								int adets = (int) modelim.getValueAt(i1, 2);
								String siparisguncelle= "update siparisdurumu set "+�r�n1+"�t�="+�r�n1+"�t�+"+adets+" where siparisno="+siparisno+"";
								SqlSorgu.guncelle(siparisguncelle);
							}
							else if (kontrolet=="Temizleme") {
								String �r�nn1 = (String) modelim.getValueAt(i1, 0);
								String �r�n1 = �r�nn1.replaceAll("\\s","");
								int adets = (int) modelim.getValueAt(i1, 2);
								String siparisguncelle= "update siparisdurumu set "+�r�n1+"="+�r�n1+"+"+adets+" where siparisno="+siparisno+"";
								SqlSorgu.guncelle(siparisguncelle);
							}
						}
						
								// S�PAR�SDURUMU TABLOSU
		
						
						}
				//		String siparisdurumu= "insert into siparisdurumu idmusteri="+musteriid.getText()+" ad='"+txt_ad.getText()+"' soyad ='"+txt_soyad.getText()+"' "
					//			+ "siparisno="+sipariss+" siparistarihi = '"+tut1+"' teslimtarihi='"+tut2+"' teslimdurumu = 0 ";
						
					//	String formattedStr01 = strWithSpaceTabNewline.replaceAll("\\s","");
					//	formattedStr01 = formattedStr01.replaceAll("\\.","");
						
						
						
						YeniSiparis d�n = new YeniSiparis();
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Sipari� Ba�ar�l�", "", 1);
						d�n.setVisible(true);
						setVisible(false);
						
					}
			

				}
			
			
			
		});
		btnNewButton_5.setForeground(SystemColor.textHighlight);
		btnNewButton_5.setBackground(new Color(0, 0, 0));
		btnNewButton_5.setFocusable(false);
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setBounds(1323, 780, 140, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnMteriSeimineDn = new JButton("M\u00FC\u015Fteri se\u00E7imine d\u00F6n");
		btnMteriSeimineDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				YeniSiparis frm = new YeniSiparis();
				frm.setVisible(true);
				setVisible(false);
			}
		});
		btnMteriSeimineDn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMteriSeimineDn.setFocusable(false);
		btnMteriSeimineDn.setBorder(UIManager.getBorder("CheckBox.border"));
		btnMteriSeimineDn.setBounds(151, 18, 163, 46);
		contentPane.add(btnMteriSeimineDn);
		
		txt_iskonto = new JTextField();
		txt_iskonto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				
				String a = txt_geneltoplam.getText();
				String b = txt_iskonto.getText();
				double aa = Double.valueOf(a);
				double bb = Double.valueOf(b);
				aa=aa+haf�zaa;
				aa = aa-bb;
				haf�zaa=bb;
				String gt = String.valueOf(aa);
				
				txt_geneltoplam.setText(gt);
				
			
			
			}
		});
		txt_iskonto.setForeground(Color.RED);
		txt_iskonto.setBorder(null);
		txt_iskonto.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_iskonto.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_iskonto.setColumns(10);
		txt_iskonto.setBounds(1395, 644, 91, 20);
		contentPane.add(txt_iskonto);
		
		JLabel label_35 = new JLabel("TL");
		label_35.setForeground(Color.WHITE);
		label_35.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_35.setBounds(1488, 648, 55, 14);
		contentPane.add(label_35);
		
		JLabel label_36 = new JLabel("\u0130SKONTO");
		label_36.setHorizontalAlignment(SwingConstants.CENTER);
		label_36.setForeground(Color.WHITE);
		label_36.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_36.setBounds(1259, 646, 126, 14);
		contentPane.add(label_36);
		
		JLabel label_37 = new JLabel("GENEL TOPLAM");
		label_37.setHorizontalAlignment(SwingConstants.CENTER);
		label_37.setForeground(Color.WHITE);
		label_37.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_37.setBounds(1259, 700, 126, 14);
		contentPane.add(label_37);
		
		txt_geneltoplam = new JTextField();
		txt_geneltoplam.setText("0.0");
		txt_geneltoplam.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_geneltoplam.setFont(new Font("Tahoma", Font.BOLD, 12));
		txt_geneltoplam.setFocusable(false);
		txt_geneltoplam.setEditable(false);
		txt_geneltoplam.setColumns(10);
		txt_geneltoplam.setBounds(1395, 698, 91, 20);
		contentPane.add(txt_geneltoplam);
		/*
		String isk,top,genelt;
		double iskonto,toplam,geneltoplam;
		isk = txt_iskonto.getText();
		iskonto = Double.valueOf(isk);
		top = txt_toplam.getText();
		toplam = Double.valueOf(top);
		
		geneltoplam= toplam-iskonto;
		genelt = String.valueOf(geneltoplam);
		txt_geneltoplam.setText(genelt);
		*/
		
		
		
		
		
		JLabel label_38 = new JLabel("TL");
		label_38.setForeground(Color.WHITE);
		label_38.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_38.setBounds(1488, 702, 55, 14);
		contentPane.add(label_38);
		
		JLabel lbl_zam = new JLabel("EKSTRA");
		lbl_zam.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_zam.setForeground(Color.WHITE);
		lbl_zam.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_zam.setBounds(1259, 673, 126, 14);
		contentPane.add(lbl_zam);
		
		txt_zam = new JTextField();
		txt_zam.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String a = txt_geneltoplam.getText();
				String b = txt_zam.getText();
				double aa = Double.valueOf(a);
				double bb = Double.valueOf(b);
				aa=aa-haf�zaaa;
				aa = aa+bb;
				haf�zaaa=bb;
				String gt = String.valueOf(aa);
				
				txt_geneltoplam.setText(gt);
				
			
			}
		});
		txt_zam.setHorizontalAlignment(SwingConstants.RIGHT);
		txt_zam.setForeground(Color.RED);
		txt_zam.setFont(new Font("Tahoma", Font.BOLD, 13));
		txt_zam.setColumns(10);
		txt_zam.setBorder(null);
		txt_zam.setBounds(1395, 671, 91, 20);
		contentPane.add(txt_zam);
		
		JLabel label_39 = new JLabel("TL");
		label_39.setForeground(Color.WHITE);
		label_39.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_39.setBounds(1488, 675, 55, 14);
		contentPane.add(label_39);
		
		JButton btnUygula = new JButton("Uygula");
		btnUygula.setForeground(SystemColor.textHighlight);
		btnUygula.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUygula.setBackground(Color.BLACK);
		btnUygula.setBounds(1395, 729, 91, 23);
		contentPane.add(btnUygula);
		
		JComboBox masaortusucb = new JComboBox();
		masaortusucb.setBackground(new Color(255, 255, 255));
		masaortusucb.setModel(new DefaultComboBoxModel(new String[] {"4 ki\u015Filik", "8 ki\u015Filik", "12 ki\u015Filik"}));
		masaortusucb.setBounds(103, 179, 30, 22);
		panel_2.add(masaortusucb);
		
		JComboBox storperdecb = new JComboBox();
		storperdecb.setBackground(new Color(255, 255, 255));
		storperdecb.setModel(new DefaultComboBoxModel(new String[] {"25", "30", "35"}));
		storperdecb.setBounds(387, 473, 30, 22);
		panel_2.add(storperdecb);
		
		JComboBox zebraperdecb = new JComboBox();
		zebraperdecb.setModel(new DefaultComboBoxModel(new String[] {"25", "30", "35"}));
		zebraperdecb.setBackground(new Color(255, 255, 255));
		zebraperdecb.setBounds(529, 473, 30, 22);
		panel_2.add(zebraperdecb);
		
		
		txt_borc = new JTextField();
		txt_borc.setForeground(new Color(255, 255, 255));
		txt_borc.setHorizontalAlignment(SwingConstants.CENTER);
		txt_borc.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_borc.setFocusable(false);
		txt_borc.setEditable(false);
		txt_borc.setColumns(10);
		txt_borc.setBorder(null);
		txt_borc.setBackground(new Color(128, 0, 0));
		txt_borc.setBounds(1294, 128, 91, 20);
		contentPane.add(txt_borc);
		
		txt_alacak = new JTextField();
		txt_alacak.setForeground(new Color(255, 255, 255));
		txt_alacak.setHorizontalAlignment(SwingConstants.CENTER);
		txt_alacak.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_alacak.setFocusable(false);
		txt_alacak.setEditable(false);
		txt_alacak.setColumns(10);
		txt_alacak.setBorder(null);
		txt_alacak.setBackground(new Color(0, 0, 128));
		txt_alacak.setBounds(1294, 153, 91, 20);
		contentPane.add(txt_alacak);
		
		JLabel lblToplamBorcumuz = new JLabel("BORCUMUZ");
		lblToplamBorcumuz.setHorizontalAlignment(SwingConstants.CENTER);
		lblToplamBorcumuz.setForeground(Color.WHITE);
		lblToplamBorcumuz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblToplamBorcumuz.setBounds(1177, 130, 126, 14);
		contentPane.add(lblToplamBorcumuz);
		
		JLabel lblAlacamz = new JLabel("ALACA\u011EIMIZ");
		lblAlacamz.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlacamz.setForeground(Color.WHITE);
		lblAlacamz.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlacamz.setBounds(1171, 154, 126, 16);
		contentPane.add(lblAlacamz);
		
		JLabel label_29 = new JLabel("TL");
		label_29.setForeground(Color.WHITE);
		label_29.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_29.setBounds(1387, 131, 55, 14);
		contentPane.add(label_29);
		
		JLabel label_44 = new JLabel("TL");
		label_44.setForeground(Color.WHITE);
		label_44.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_44.setBounds(1387, 156, 53, 14);
		contentPane.add(label_44);
		
		txt_tarih = new JTextField();
		txt_tarih.setHorizontalAlignment(SwingConstants.CENTER);
		txt_tarih.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_tarih.setFocusable(false);
		txt_tarih.setEditable(false);
		txt_tarih.setColumns(10);
		txt_tarih.setBorder(null);
		txt_tarih.setBackground(new Color(255, 255, 255));
		txt_tarih.setBounds(1240, 44, 106, 20);
		contentPane.add(txt_tarih);
		
		JLabel lblKaytTarihi = new JLabel("M\u00FC\u015Fteri Kay\u0131t Tarihi");
		lblKaytTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lblKaytTarihi.setForeground(Color.WHITE);
		lblKaytTarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKaytTarihi.setBounds(1217, 28, 150, 14);
		contentPane.add(lblKaytTarihi);
		
		JButton btnNewqButton = new JButton("");
		btnNewqButton.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/alez.png")));
		btnNewqButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Alez");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*alezy;												//de�i�tir
				sat�rlar[0] = "Alez";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*alezy;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Alez");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Alez zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		btnNewqButton.setBounds(10, 17, 83, 90);
		panel_2.add(btnNewqButton);
		
		JButton button1 = new JButton("");
		button1.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/battaniye.png")));
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Battaniye");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*battaniyey;												//de�i�tir
				sat�rlar[0] = "Battaniye";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*battaniyey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Battaniye");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Battaniye zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button1.setBounds(152, 17, 83, 90);
		panel_2.add(button1);
		
		JButton button_131 = new JButton("");
		button_131.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/elyafyorgan.png")));
		button_131.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Elyaf Yorgan");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*elyafyorgany;												//de�i�tir
				sat�rlar[0] = "Elyaf Yorgan";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*elyafyorgany;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Elyaf Yorgan");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Elyaf Yorgan zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_131.setBounds(294, 17, 83, 90);
		panel_2.add(button_131);
		
		JButton button_268 = new JButton("");
		button_268.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kaztuyuyorgan.png")));
		button_268.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kaz T�y� Yorgan");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kazt�y�yorgany;												//de�i�tir
				sat�rlar[0] = "Kaz T�y� Yorgan";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kazt�y�yorgany;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kaz T�y� Yorgan");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kaz T�y� Yorgan zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_268.setBounds(436, 17, 83, 90);
		panel_2.add(button_268);
		
		JButton button_243 = new JButton("");
		button_243.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/masaortusu.png")));
		button_243.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusucb.getSelectedIndex();
				if (secilen==0) {
				int index = t�r.indexOf("D�rt K Masa �rt�s�");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*dkm�y;												//de�i�tir
				sat�rlar[0] = "D�rt K Masa �rt�s�";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*dkm�y;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("D�rt K Masa �rt�s�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "D�rt K Masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
				}
				}
				else if (secilen==1) {
					int index = t�r.indexOf("Sekiz K Masa �rt�s�");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*skm�y;												//de�i�tir
					sat�rlar[0] = "Sekiz K Masa �rt�s�";														//de�i�tir
					sat�rlar[1] = "Temizleme";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*skm�y;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("Sekiz K Masa �rt�s�");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Sekiz K Masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
					}}
					else if(secilen==2){

						int index = t�r.indexOf("Oniki K Masa �rt�s�");											//de�i�tir
						
						if (index==-1) {				
						String st = temiz.getText();
						int temizleme = Integer.valueOf(st);
						toplamfiyat += temizleme*onikikm�y;												//de�i�tir
						sat�rlar[0] = "Oniki K Masa �rt�s�";														//de�i�tir
						sat�rlar[1] = "Temizleme";														//de�i�tir
						sat�rlar[2] = temizleme;
						sat�rlar[3] = temizleme*onikikm�y;												//de�i�tir
						modelim.addRow(sat�rlar);
						
						ka��nc�sat�r+=1;
						haf�za1=ka��nc�sat�r;
						t�r.add("Oniki K Masa �rt�s�");															//de�i�tir
						
							
							String s = String.valueOf(toplamfiyat);
							txt_toplam.setText(s);
							temiz.setText("1");
							txt_geneltoplam.setText(s);
						}
						
						else {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "12 K Masa �rt�s� zaten se�ili.","", 1);		//de�i�tir
						}}}
						
					
					
				

		});
		button_243.setBounds(10, 161, 83, 90);
		panel_2.add(button_243);
		
		JButton button_412 = new JButton("");
		button_412.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/nevresim.png")));
		button_412.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Nevresim");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*nevresimy;												//de�i�tir
				sat�rlar[0] = "Nevresim";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*nevresimy;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Nevresim");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Nevresim zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_412.setBounds(152, 161, 83, 90);
		panel_2.add(button_412);
		
		JButton button_514 = new JButton("");
		button_514.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/pamukyorgan.png")));
		button_514.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Pamuk Yorgan");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*pamukyorgany;												//de�i�tir
				sat�rlar[0] = "Pamuk Yorgan";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*pamukyorgany;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Pamuk Yorgan");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Pamuk Yorgan zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_514.setBounds(294, 161, 83, 90);
		panel_2.add(button_514);
		
		JButton button_611 = new JButton("");
		button_611.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yastik.png")));
		button_611.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yast�k");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*yast�ky;												//de�i�tir
				sat�rlar[0] = "Yast�k";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*yast�ky;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yast�k");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yast�k zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_611.setBounds(436, 161, 83, 90);
		panel_2.add(button_611);
		
		JButton button_71 = new JButton("");
		button_71.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/yatakortusu.png")));
		button_71.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Yatak �rt�s�");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*yatak�rt�s�y;												//de�i�tir
				sat�rlar[0] = "Yatak �rt�s�";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*yatak�rt�s�y;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Yatak �rt�s�");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Yatak �rt�s� zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_71.setBounds(10, 305, 83, 90);
		panel_2.add(button_71);
		
		JButton button_811 = new JButton("");
		button_811.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/\u00E7ar\u015Faf.png")));
		button_811.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("�ar�af");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*�ar�afy;												//de�i�tir
				sat�rlar[0] = "�ar�af";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*�ar�afy;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("�ar�af");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�ar�af zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_811.setBounds(152, 305, 83, 90);
		panel_2.add(button_811);
		
		JButton button_911 = new JButton("");
		button_911.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/cambalkonperdesi.png")));
		button_911.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Cam Balkon Perdesi");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*cambalkony;												//de�i�tir
				sat�rlar[0] = "Cam Balkon Perdesi";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*cambalkony;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Cam Balkon Perdesi");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Cam Balkon Perdesi zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_911.setBounds(294, 305, 83, 90);
		panel_2.add(button_911);
		
		JButton button_1011 = new JButton("");
		button_1011.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/gelinlik.png")));
		button_1011.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("T�l Perde");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*t�lperdey;												//de�i�tir
				sat�rlar[0] = "T�l Perde";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*t�lperdey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("T�l Perde");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "T�l Perde zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_1011.setBounds(436, 305, 83, 90);
		panel_2.add(button_1011);
		
		JButton button_1111 = new JButton("");
		button_1111.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/tulperde.png")));
		button_1111.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Gelinlik");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*gelinliky;												//de�i�tir
				sat�rlar[0] = "Gelinlik";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*gelinliky;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Gelinlik");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Gelinlik zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_1111.setBounds(10, 452, 83, 90);
		panel_2.add(button_1111);
		
		JButton button_121 = new JButton("");
		button_121.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/fonperde.png")));
		button_121.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Fon Perde");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*fonperdey;												//de�i�tir
				sat�rlar[0] = "Fon Perde";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*fonperdey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Fon Perde");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Fon Perde zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_121.setBounds(152, 452, 83, 90);
		panel_2.add(button_121);
		
		JButton button_181 = new JButton("");
		button_181.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/storperde.png")));
		button_181.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = storperdecb.getSelectedIndex();
				if (secilen==0) {
				int index = t�r.indexOf("K�sa Stor Perde");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*bstorperdey;												//de�i�tir
				sat�rlar[0] = "K�sa Stor Perde";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*bstorperdey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("K�sa Stor Perde");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "K�sa Stor Perde zaten se�ili.","", 1);		//de�i�tir
				}
				}
				else if (secilen==1) {
					int index = t�r.indexOf("Orta Stor Perde");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*istorperdey;												//de�i�tir
					sat�rlar[0] = "Orta Stor Perde";														//de�i�tir
					sat�rlar[1] = "Temizleme";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*istorperdey;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("Orta Stor Perde");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Orta Stor Perde zaten se�ili.","", 1);		//de�i�tir
					}}
					else if(secilen==2){

						int index = t�r.indexOf("Uzun Stor Perde");											//de�i�tir
						
						if (index==-1) {				
						String st = temiz.getText();
						int temizleme = Integer.valueOf(st);
						toplamfiyat += temizleme*�storperdey;												//de�i�tir
						sat�rlar[0] = "Uzun Stor Perde";														//de�i�tir
						sat�rlar[1] = "Temizleme";														//de�i�tir
						sat�rlar[2] = temizleme;
						sat�rlar[3] = temizleme*�storperdey;												//de�i�tir
						modelim.addRow(sat�rlar);
						
						ka��nc�sat�r+=1;
						haf�za1=ka��nc�sat�r;
						t�r.add("Uzun Stor Perde");															//de�i�tir
						
							
							String s = String.valueOf(toplamfiyat);
							txt_toplam.setText(s);
							temiz.setText("1");
							txt_geneltoplam.setText(s);
						}
						
						else {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "Uzun Stor Perde zaten se�ili.","", 1);		//de�i�tir
						}}}
		});
		button_181.setBounds(294, 452, 83, 90);
		panel_2.add(button_181);
		
		JButton button_1411 = new JButton("");
		button_1411.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/zebraperde.png")));
		button_1411.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = zebraperdecb.getSelectedIndex();
				if (secilen==0) {
				int index = t�r.indexOf("K�sa Zebra Perde");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*bzebraperdey;												//de�i�tir
				sat�rlar[0] = "K�sa Zebra Perde";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*bzebraperdey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("K�sa Zebra Perde");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "K�sa Zebra Perde zaten se�ili.","", 1);		//de�i�tir
				}
				}
				else if (secilen==1) {
					int index = t�r.indexOf("Orta Zebra Perde");											//de�i�tir
					
					if (index==-1) {				
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*izebraperdey;												//de�i�tir
					sat�rlar[0] = "Orta Zebra Perde";														//de�i�tir
					sat�rlar[1] = "Temizleme";														//de�i�tir
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*izebraperdey;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add("Orta Zebra Perde");															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Orta Zebra Perde zaten se�ili.","", 1);		//de�i�tir
					}}
					else if(secilen==2){

						int index = t�r.indexOf("Uzun Zebra Perde");											//de�i�tir
						
						if (index==-1) {				
						String st = temiz.getText();
						int temizleme = Integer.valueOf(st);
						toplamfiyat += temizleme*�zebraperdey;												//de�i�tir
						sat�rlar[0] = "Uzun Zebra Perde";														//de�i�tir
						sat�rlar[1] = "Temizleme";														//de�i�tir
						sat�rlar[2] = temizleme;
						sat�rlar[3] = temizleme*�zebraperdey;												//de�i�tir
						modelim.addRow(sat�rlar);
						
						ka��nc�sat�r+=1;
						haf�za1=ka��nc�sat�r;
						t�r.add("Uzun Zebra Perde");															//de�i�tir
						
							
							String s = String.valueOf(toplamfiyat);
							txt_toplam.setText(s);
							temiz.setText("1");
							txt_geneltoplam.setText(s);
						}
						
						else {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "Uzun Zebra Perde zaten se�ili.","", 1);		//de�i�tir
						}}}
		});
		button_1411.setBounds(436, 452, 83, 90);
		panel_2.add(button_1411);
		
		JButton button_1511 = new JButton("");
		button_1511.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/kruvazeperde.png")));
		button_1511.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Kruvaze Perde");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*kruvazeperdey;												//de�i�tir
				sat�rlar[0] = "Kruvaze Perde";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*kruvazeperdey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Kruvaze Perde");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Kruvaze Perde zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_1511.setBounds(10, 596, 83, 90);
		panel_2.add(button_1511);
		
		JButton button_161 = new JButton("");
		button_161.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/g\u00FCne\u015Flik.png")));
		button_161.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("G�ne�lik");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*g�ne�liky;												//de�i�tir
				sat�rlar[0] = "G�ne�lik";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*g�ne�liky;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("G�ne�lik");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "G�ne�lik zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_161.setBounds(152, 596, 83, 90);
		panel_2.add(button_161);
		
		JLabel label1 = new JLabel("ALEZ");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label1.setBounds(10, 107, 83, 20);
		panel_2.add(label1);
		
		JLabel label_111 = new JLabel("BATTAN\u0130YE");
		label_111.setHorizontalAlignment(SwingConstants.CENTER);
		label_111.setForeground(Color.WHITE);
		label_111.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_111.setBounds(152, 107, 83, 20);
		panel_2.add(label_111);
		
		JLabel label_211 = new JLabel("ELYAF YORGAN");
		label_211.setHorizontalAlignment(SwingConstants.CENTER);
		label_211.setForeground(Color.WHITE);
		label_211.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_211.setBounds(285, 107, 100, 20);
		panel_2.add(label_211);
		
		JLabel label_3 = new JLabel("KAZ T YORGAN");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(428, 108, 98, 20);
		panel_2.add(label_3);
		
		JLabel label_41 = new JLabel("MASA \u00D6RT\u00DCS\u00DC");
		label_41.setHorizontalAlignment(SwingConstants.CENTER);
		label_41.setForeground(Color.WHITE);
		label_41.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_41.setBounds(0, 251, 106, 20);
		panel_2.add(label_41);
		
		JLabel label_51 = new JLabel("NEVRES\u0130M");
		label_51.setHorizontalAlignment(SwingConstants.CENTER);
		label_51.setForeground(Color.WHITE);
		label_51.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_51.setBounds(152, 251, 83, 20);
		panel_2.add(label_51);
		
		JLabel label_61 = new JLabel("PAMUK YORGAN");
		label_61.setHorizontalAlignment(SwingConstants.CENTER);
		label_61.setForeground(Color.WHITE);
		label_61.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_61.setBounds(284, 251, 101, 20);
		panel_2.add(label_61);
		
		JLabel label_7 = new JLabel("YASTIK");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(436, 251, 83, 20);
		panel_2.add(label_7);
		
		JLabel label_81 = new JLabel("YATAK \u00D6RT\u00DCS\u00DC");
		label_81.setHorizontalAlignment(SwingConstants.CENTER);
		label_81.setForeground(Color.WHITE);
		label_81.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_81.setBounds(0, 394, 104, 20);
		panel_2.add(label_81);
		
		JLabel label_91 = new JLabel("\u00C7AR\u015EAF");
		label_91.setHorizontalAlignment(SwingConstants.CENTER);
		label_91.setForeground(Color.WHITE);
		label_91.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_91.setBounds(142, 394, 104, 20);
		panel_2.add(label_91);
		
		JLabel label_101 = new JLabel("CAM BALKON PERDES\u0130");
		label_101.setHorizontalAlignment(SwingConstants.CENTER);
		label_101.setForeground(Color.WHITE);
		label_101.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_101.setBounds(265, 394, 145, 20);
		panel_2.add(label_101);
		
		JLabel label_1111 = new JLabel("GEL\u0130NL\u0130K");
		label_1111.setHorizontalAlignment(SwingConstants.CENTER);
		label_1111.setForeground(Color.WHITE);
		label_1111.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1111.setBounds(428, 394, 98, 20);
		panel_2.add(label_1111);
		
		JLabel label_12 = new JLabel("T\u00DCL PERDE");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setForeground(Color.WHITE);
		label_12.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_12.setBounds(10, 541, 83, 20);
		panel_2.add(label_12);
		
		JLabel label_131 = new JLabel("FON PERDE");
		label_131.setHorizontalAlignment(SwingConstants.CENTER);
		label_131.setForeground(Color.WHITE);
		label_131.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_131.setBounds(152, 541, 83, 20);
		panel_2.add(label_131);
		
		JLabel label_141 = new JLabel("STOR PERDE");
		label_141.setHorizontalAlignment(SwingConstants.CENTER);
		label_141.setForeground(Color.WHITE);
		label_141.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_141.setBounds(285, 541, 100, 20);
		panel_2.add(label_141);
		
		JLabel label_151 = new JLabel("ZEBRA PERDE");
		label_151.setHorizontalAlignment(SwingConstants.CENTER);
		label_151.setForeground(Color.WHITE);
		label_151.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_151.setBounds(429, 540, 98, 20);
		panel_2.add(label_151);
		
		JLabel label_161 = new JLabel("KRUVAZE PERDE");
		label_161.setHorizontalAlignment(SwingConstants.CENTER);
		label_161.setForeground(Color.WHITE);
		label_161.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_161.setBounds(0, 685, 101, 20);
		panel_2.add(label_161);
		
		JLabel label_171 = new JLabel("G\u00DCNE\u015EL\u0130K");
		label_171.setHorizontalAlignment(SwingConstants.CENTER);
		label_171.setForeground(Color.WHITE);
		label_171.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_171.setBounds(149, 685, 83, 20);
		panel_2.add(label_171);
		
		JButton btnNewButton_11 = new JButton("+");
		btnNewButton_11.setFocusable(false);
		btnNewButton_11.setForeground(new Color(255, 255, 255));
		btnNewButton_11.setBackground(new Color(0, 0, 128));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Alez");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=alezy*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += alezy*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		btnNewButton_11.setBounds(10, 130, 42, 20);
		panel_2.add(btnNewButton_11);
		
		JButton btnNewButton_21 = new JButton("-");
		btnNewButton_21.setFocusable(false);
		btnNewButton_21.setForeground(new Color(255, 255, 255));
		btnNewButton_21.setBackground(new Color(0, 0, 128));
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Alez");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Alez") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Alez");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=alezy*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= alezy*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		btnNewButton_21.setBounds(52, 130, 42, 20);
		panel_2.add(btnNewButton_21);
		
		JButton button_171 = new JButton("+");
		button_171.setFocusable(false);
		button_171.setForeground(new Color(255, 255, 255));
		button_171.setBackground(new Color(0, 0, 128));
		button_171.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Battaniye");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=battaniyey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += battaniyey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_171.setBounds(152, 130, 42, 20);
		panel_2.add(button_171);
		
		JButton button_167 = new JButton("-");
		button_167.setFocusable(false);
		button_167.setForeground(new Color(255, 255, 255));
		button_167.setBackground(new Color(0, 0, 128));
		button_167.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Battaniye");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Battaniye") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Battaniye");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=battaniyey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= battaniyey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_167.setBounds(193, 130, 42, 20);
		panel_2.add(button_167);
		
		JButton button_191 = new JButton("+");
		button_191.setFocusable(false);
		button_191.setForeground(new Color(255, 255, 255));
		button_191.setBackground(new Color(0, 0, 128));
		button_191.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Elyaf Yorgan");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=elyafyorgany*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += elyafyorgany*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_191.setBounds(294, 130, 42, 20);
		panel_2.add(button_191);
		
		JButton button_201 = new JButton("-");
		button_201.setFocusable(false);
		button_201.setForeground(new Color(255, 255, 255));
		button_201.setBackground(new Color(0, 0, 128));
		button_201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Elyaf Yorgan");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Elyaf Yorgan") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Elyaf Yorgan");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=elyafyorgany*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= elyafyorgany*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_201.setBounds(335, 130, 42, 20);
		panel_2.add(button_201);
		
		JButton button_211 = new JButton("+");
		button_211.setFocusable(false);
		button_211.setForeground(new Color(255, 255, 255));
		button_211.setBackground(new Color(0, 0, 128));
		button_211.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kaz T�y� Yorgan");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kazt�y�yorgany*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kazt�y�yorgany*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_211.setBounds(436, 130, 42, 20);
		panel_2.add(button_211);
		
		JButton button_221 = new JButton("-");
		button_221.setFocusable(false);
		button_221.setForeground(new Color(255, 255, 255));
		button_221.setBackground(new Color(0, 0, 128));
		button_221.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kaz T�y� Yorgan");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kaz T�y� Yorgan") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kaz T�y� Yorgan");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kazt�y�yorgany*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kazt�y�yorgany*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_221.setBounds(477, 130, 42, 20);
		panel_2.add(button_221);
		
		JButton button_231 = new JButton("+");
		button_231.setFocusable(false);
		button_231.setForeground(new Color(255, 255, 255));
		button_231.setBackground(new Color(0, 0, 128));
		button_231.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusucb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("D�rt K Masa �rt�s�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=dkm�y*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += dkm�y*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}}
				else if(secilen==1) {
					int index= t�r.indexOf("Sekiz K Masa �rt�s�");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=skm�y*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += skm�y*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}}
				else if(secilen==2) {
					int index= t�r.indexOf("Oniki K Masa �rt�s�");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=onikikm�y*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += onikikm�y*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}}
			
			
			
			}
		});
		button_231.setBounds(10, 274, 42, 20);
		panel_2.add(button_231);
		
		JButton button_24 = new JButton("-");
		button_24.setFocusable(false);
		button_24.setForeground(new Color(255, 255, 255));
		button_24.setBackground(new Color(0, 0, 128));
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = masaortusucb.getSelectedIndex();
				if (secilen==0) {

					
					int index= t�r.indexOf("D�rt K Masa �rt�s�");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="D�rt K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("D�rt K Masa �rt�s�");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=dkm�y*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= dkm�y*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
				
				}
				else if (secilen==1) {

					
					int index= t�r.indexOf("Sekiz K Masa �rt�s�");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Sekiz K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Sekiz K Masa �rt�s�");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=skm�y*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= skm�y*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
				
				}
				else if(secilen==2) {

					
					int index= t�r.indexOf("Oniki K Masa �rt�s�");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Oniki K Masa �rt�s�") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Oniki K Masa �rt�s�");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=onikikm�y*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= onikikm�y*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
						
					}
				
					kuru.setText("1");
				
				}
					
				
				}
			}
		});
		button_24.setBounds(51, 274, 42, 20);
		panel_2.add(button_24);
		
		JButton button_251 = new JButton("+");
		button_251.setFocusable(false);
		button_251.setForeground(new Color(255, 255, 255));
		button_251.setBackground(new Color(0, 0, 128));
		button_251.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Nevresim");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=nevresimy*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += nevresimy*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_251.setBounds(152, 274, 42, 20);
		panel_2.add(button_251);
		
		JButton button_261 = new JButton("-");
		button_261.setFocusable(false);
		button_261.setForeground(new Color(255, 255, 255));
		button_261.setBackground(new Color(0, 0, 128));
		button_261.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Nevresim");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Nevresim") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Nevresim");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=nevresimy*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= nevresimy*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_261.setBounds(193, 274, 42, 20);
		panel_2.add(button_261);
		
		JButton button_271 = new JButton("+");
		button_271.setFocusable(false);
		button_271.setForeground(new Color(255, 255, 255));
		button_271.setBackground(new Color(0, 0, 128));
		button_271.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Pamuk Yorgan");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=pamukyorgany*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += pamukyorgany*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_271.setBounds(294, 274, 42, 20);
		panel_2.add(button_271);
		
		JButton button_281 = new JButton("-");
		button_281.setFocusable(false);
		button_281.setForeground(new Color(255, 255, 255));
		button_281.setBackground(new Color(0, 0, 128));
		button_281.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Pamuk Yorgan");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Pamuk Yorgan") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Pamuk Yorgan");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=pamukyorgany*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= pamukyorgany*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_281.setBounds(335, 274, 42, 20);
		panel_2.add(button_281);
		
		JButton button_291 = new JButton("+");
		button_291.setFocusable(false);
		button_291.setForeground(new Color(255, 255, 255));
		button_291.setBackground(new Color(0, 0, 128));
		button_291.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yast�k");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=yast�ky*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += yast�ky*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_291.setBounds(436, 274, 42, 20);
		panel_2.add(button_291);
		
		JButton button_30 = new JButton("-");
		button_30.setFocusable(false);
		button_30.setForeground(new Color(255, 255, 255));
		button_30.setBackground(new Color(0, 0, 128));
		button_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Yast�k");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Yast�k") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Yast�k");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=yast�ky*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= yast�ky*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_30.setBounds(477, 274, 42, 20);
		panel_2.add(button_30);
		
		JButton button_311 = new JButton("+");
		button_311.setFocusable(false);
		button_311.setForeground(new Color(255, 255, 255));
		button_311.setBackground(new Color(0, 0, 128));
		button_311.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Yatak �rt�s�");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=yatak�rt�s�y*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += yatak�rt�s�y*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_311.setBounds(10, 421, 42, 20);
		panel_2.add(button_311);
		

		
		
		JButton button_321 = new JButton("-");
		button_321.setFocusable(false);
		button_321.setForeground(new Color(255, 255, 255));
		button_321.setBackground(new Color(0, 0, 128));
		button_321.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen=masaortusucb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("Ceket");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Ceket") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Ceket");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=15.0*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= 15.0*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
				}
				}
			
				kuru.setText("1");
			
			}
				else if(secilen==1) {

					int index= t�r.indexOf("Ceket");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Ceket") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Ceket");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=15.0*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= 15.0*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				else if(secilen==2) {

					int index= t�r.indexOf("Ceket");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Ceket") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Ceket");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=15.0*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= 15.0*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				}
		});
		button_321.setBounds(51, 421, 42, 20);
		panel_2.add(button_321);
		
		JButton button_331 = new JButton("+");
		button_331.setFocusable(false);
		button_331.setForeground(new Color(255, 255, 255));
		button_331.setBackground(new Color(0, 0, 128));
		button_331.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("�ar�af");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=�ar�afy*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += �ar�afy*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_331.setBounds(152, 421, 42, 20);
		panel_2.add(button_331);
		
		JButton button_341 = new JButton("-");
		button_341.setFocusable(false);
		button_341.setForeground(new Color(255, 255, 255));
		button_341.setBackground(new Color(0, 0, 128));
		button_341.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("�ar�af");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="�ar�af") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("�ar�af");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=�ar�afy*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= �ar�afy*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_341.setBounds(193, 421, 42, 20);
		panel_2.add(button_341);
		
		JButton button_351 = new JButton("+");
		button_351.setFocusable(false);
		button_351.setForeground(new Color(255, 255, 255));
		button_351.setBackground(new Color(0, 0, 128));
		button_351.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Cam Balkon Perdesi");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=cambalkony*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += cambalkony*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_351.setBounds(294, 421, 42, 20);
		panel_2.add(button_351);
		
		JButton button_361 = new JButton("-");
		button_361.setFocusable(false);
		button_361.setForeground(new Color(255, 255, 255));
		button_361.setBackground(new Color(0, 0, 128));
		button_361.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Cam Balkon Perdesi");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Cam Balkon Perdesi") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Cam Balkon Perdesi");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=cambalkony*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= cambalkony*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_361.setBounds(335, 421, 42, 20);
		panel_2.add(button_361);
		
		JButton button_371 = new JButton("+");
		button_371.setFocusable(false);
		button_371.setForeground(new Color(255, 255, 255));
		button_371.setBackground(new Color(0, 0, 128));
		button_371.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Gelinlik");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=gelinliky*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += gelinliky*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_371.setBounds(436, 421, 42, 20);
		panel_2.add(button_371);
		
		JButton button_38 = new JButton("-");
		button_38.setFocusable(false);
		button_38.setForeground(new Color(255, 255, 255));
		button_38.setBackground(new Color(0, 0, 128));
		button_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Gelinlik");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Gelinlik") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Gelinlik");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=gelinliky*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= gelinliky*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_38.setBounds(477, 421, 42, 20);
		panel_2.add(button_38);
		
		JButton button_39 = new JButton("+");
		button_39.setFocusable(false);
		button_39.setForeground(new Color(255, 255, 255));
		button_39.setBackground(new Color(0, 0, 128));
		button_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("T�l Perde");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=t�lperdey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += t�lperdey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_39.setBounds(10, 562, 42, 20);
		panel_2.add(button_39);
		
		JButton button_401 = new JButton("-");
		button_401.setFocusable(false);
		button_401.setForeground(new Color(255, 255, 255));
		button_401.setBackground(new Color(0, 0, 128));
		button_401.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("T�l Perde");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="T�l Perde") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("T�l Perde");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=t�lperdey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= t�lperdey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_401.setBounds(51, 562, 42, 20);
		panel_2.add(button_401);
		
		JButton button_411 = new JButton("+");
		button_411.setFocusable(false);
		button_411.setForeground(new Color(255, 255, 255));
		button_411.setBackground(new Color(0, 0, 128));
		button_411.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Fon Perde");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=fonperdey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += fonperdey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_411.setBounds(152, 562, 42, 20);
		panel_2.add(button_411);
		
		JButton button_421 = new JButton("-");
		button_421.setFocusable(false);
		button_421.setForeground(new Color(255, 255, 255));
		button_421.setBackground(new Color(0, 0, 128));
		button_421.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Fon Perde");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Fon Perde") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Fon Perde");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=fonperdey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= fonperdey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_421.setBounds(193, 562, 42, 20);
		panel_2.add(button_421);
		
		JButton button_431 = new JButton("+");
		button_431.setFocusable(false);
		button_431.setForeground(new Color(255, 255, 255));
		button_431.setBackground(new Color(0, 0, 128));
		button_431.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = storperdecb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("K�sa Stor Perde");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=bstorperdey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += bstorperdey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}}
				else if(secilen==1) {

					int index= t�r.indexOf("Orta Stor Perde");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=istorperdey*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += istorperdey*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
				else if(secilen==2) {

					int index= t�r.indexOf("Uzun Stor Perde");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=�storperdey*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += �storperdey*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
			
			
			
			}
		});
		button_431.setBounds(294, 562, 42, 20);
		panel_2.add(button_431);
		
		JButton button_44 = new JButton("-");
		button_44.setFocusable(false);
		button_44.setForeground(new Color(255, 255, 255));
		button_44.setBackground(new Color(0, 0, 128));
		button_44.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen=storperdecb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("K�sa Stor Perde");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="K�sa Stor Perde") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("K�sa Stor Perde");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=bstorperdey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= bstorperdey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
				}
				}
			
				kuru.setText("1");
			
			}
				else if(secilen==1) {

					int index= t�r.indexOf("Orta Stor Perde");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Orta Stor Perde") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Orta Stor Perde");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=istorperdey*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= istorperdey*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				else if(secilen==2) {

					int index= t�r.indexOf("Uzun Stor Perde");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Uzun Stor Perde") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Uzun Stor Perde");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=�storperdey*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= �storperdey*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				}
		});
		button_44.setBounds(335, 562, 42, 20);
		panel_2.add(button_44);
		
		JButton button_45 = new JButton("+");
		button_45.setFocusable(false);
		button_45.setForeground(new Color(255, 255, 255));
		button_45.setBackground(new Color(0, 0, 128));
		button_45.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen = zebraperdecb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("K�sa Zebra Perde");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=bzebraperdey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += bzebraperdey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}}
				else if(secilen==1) {

					int index= t�r.indexOf("Orta Zebra Perde");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=izebraperdey*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += izebraperdey*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
				else if(secilen==2) {

					int index= t�r.indexOf("Uzun Zebra Perde");									//de�i�tir
					
					for (int i = index; i>=0 ;) {
						int adet = (int) modelim.getValueAt(i, 2);
						
						String st = kuru.getText();
						int temiz = Integer.valueOf(st);
						adet=adet+temiz;
						
						modelim.setValueAt(adet, i, 2);
						
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat +=�zebraperdey*temiz;												//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat += �zebraperdey*temiz;										//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						break;
						
					}
				}
			
			
			
			}
		});
		button_45.setBounds(436, 562, 42, 20);
		panel_2.add(button_45);
		
		JButton button_461 = new JButton("-");
		button_461.setFocusable(false);
		button_461.setForeground(new Color(255, 255, 255));
		button_461.setBackground(new Color(0, 0, 128));
		button_461.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int secilen=zebraperdecb.getSelectedIndex();
				if (secilen==0) {
				int index= t�r.indexOf("K�sa Zebra Perde");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="K�sa Zebra Perde") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("K�sa Zebra Perde");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=bzebraperdey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= bzebraperdey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
				}
				}
			
				kuru.setText("1");
			
			}
				else if(secilen==1) {

					int index= t�r.indexOf("Orta Zebra Perde");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Orta Zebra Perde") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Orta Zebra Perde");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=izebraperdey*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= izebraperdey*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				else if(secilen==2) {

					int index= t�r.indexOf("Uzun Zebra Perde");													//de�i�tir
					String isim = (String) modelim.getValueAt(index, 0);
					if (isim=="Uzun Zebra Perde") {																//de�i�tir
					
					for (int i = index; i>=0 ;) {
						index= t�r.indexOf("Uzun Zebra Perde");													//de�i�tir													
						
						int adet = (int) modelim.getValueAt(i, 2);
						if (adet<1)
							break;
						else if (adet==1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								t�r.remove(index);
								
								break;
								
							}
						}
						else {
						
						String st = kuru.getText();
						int cevir = Integer.valueOf(st);
						
						adet -=cevir;
						if (adet<1) {
							
							for (int i1 = index; i1>=0 ;) {
								double d = (double) modelim.getValueAt(i1, 3);
								
								
								//System.out.println(d);
								toplamfiyat=toplamfiyat-d;
								modelim.removeRow(i1);
								t�r.remove(index);
								String temp = txt_toplam.getText();
								double temp2= Double.valueOf(temp);
								temp2=temp2-d;
								String stcevir = Double.toString(temp2);
								txt_toplam.setText(stcevir);
								txt_geneltoplam.setText(stcevir);
								
								break;
								
							}
							kuru.setText("1");
						
						}
						modelim.setValueAt(adet, i, 2);
						
						double fiyat = (double) modelim.getValueAt(i, 3);
						fiyat -=�zebraperdey*cevir;														//de�i�tir
						modelim.setValueAt(fiyat, i, 3);
						
						toplamfiyat -= �zebraperdey*cevir;												//de�i�tir
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s); //toplamfiyata yaz
						txt_geneltoplam.setText(s);
						}
						break;
					}
					}
				
					kuru.setText("1");
				
				
				}
				}
		});
		button_461.setBounds(477, 562, 42, 20);
		panel_2.add(button_461);
		
		JButton button_471 = new JButton("+");
		button_471.setFocusable(false);
		button_471.setForeground(new Color(255, 255, 255));
		button_471.setBackground(new Color(0, 0, 128));
		button_471.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Kruvaze Perde");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=kruvazeperdey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += kruvazeperdey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_471.setBounds(10, 706, 42, 20);
		panel_2.add(button_471);
		
		JButton button_481 = new JButton("-");
		button_481.setFocusable(false);
		button_481.setForeground(new Color(255, 255, 255));
		button_481.setBackground(new Color(0, 0, 128));
		button_481.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("Kruvaze Perde");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Kruvaze Perde") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Kruvaze Perde");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=kruvazeperdey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= kruvazeperdey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_481.setBounds(51, 706, 42, 20);
		panel_2.add(button_481);
		
		JButton button_491 = new JButton("+");
		button_491.setFocusable(false);
		button_491.setForeground(new Color(255, 255, 255));
		button_491.setBackground(new Color(0, 0, 128));
		button_491.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("G�ne�lik");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=g�ne�liky*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += g�ne�liky*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			}
		});
		button_491.setBounds(152, 706, 42, 20);
		panel_2.add(button_491);
		
		JButton button_501 = new JButton("-");
		button_501.setFocusable(false);
		button_501.setForeground(new Color(255, 255, 255));
		button_501.setBackground(new Color(0, 0, 128));
		button_501.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf("G�ne�lik");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="G�ne�lik") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("G�ne�lik");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=g�ne�liky*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= g�ne�liky*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
			}
		});
		button_501.setBounds(193, 706, 42, 20);
		panel_2.add(button_501);
		
		JButton button_52 = new JButton("");
		button_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (temizlemehaf�za==txt_isim.getText()) {
							JOptionPane uyar� = new JOptionPane();
							uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
						
					//de�i�tir
					String isim = temizleme_isim.getText();
					String fiy = temizleme_fiyat.getText();
					double fiyat = Double.valueOf(fiy);
					int index = t�r.indexOf(isim); 
					
					if (index==-1) {
						temizlemehaf�za=isim;
						temizlemefiyat=fiyat;
						
					String st = temiz.getText();
					int temizleme = Integer.valueOf(st);
					toplamfiyat += temizleme*fiyat;												//de�i�tir
					sat�rlar[0] = isim;														//de�i�tir
					sat�rlar[1] = "Temizleme";
					sat�rlar[2] = temizleme;
					sat�rlar[3] = temizleme*fiyat;												//de�i�tir
					modelim.addRow(sat�rlar);
					
					ka��nc�sat�r+=1;
					haf�za1=ka��nc�sat�r;
					t�r.add(isim);															//de�i�tir
					
						
						String s = String.valueOf(toplamfiyat);
						txt_toplam.setText(s);
						temiz.setText("1");
						txt_geneltoplam.setText(s);
					}
					
					else {
						JOptionPane uyar� = new JOptionPane();
						uyar�.showMessageDialog(null, "Bunu zaten se�tiniz.","", 1);
					}
				} catch (Exception e2) {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "�sim veya fiyat belirleyiniz.","", 1);
				}
				
					
			
			}
		});
		button_52.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/\u00FCt\u00FC.png")));
		button_52.setFocusable(false);
		button_52.setBounds(923, 345, 163, 124);
		panel_2.add(button_52);
		
		JLabel label_40 = new JLabel("BA\u015EKA B\u0130R T\u00DCR G\u0130R");
		label_40.setHorizontalAlignment(SwingConstants.CENTER);
		label_40.setForeground(Color.WHITE);
		label_40.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_40.setBounds(931, 471, 149, 20);
		panel_2.add(label_40);
		
		temizleme_isim = new JTextField();
		temizleme_isim.setHorizontalAlignment(SwingConstants.CENTER);
		temizleme_isim.setFont(new Font("Tahoma", Font.BOLD, 12));
		temizleme_isim.setColumns(10);
		temizleme_isim.setBorder(null);
		temizleme_isim.setBounds(941, 493, 134, 20);
		panel_2.add(temizleme_isim);
		
		JLabel label_42 = new JLabel("\u00DCr\u00FCn ismi");
		label_42.setHorizontalAlignment(SwingConstants.CENTER);
		label_42.setForeground(Color.WHITE);
		label_42.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_42.setBounds(848, 496, 83, 20);
		panel_2.add(label_42);
		
		JLabel label_43 = new JLabel("Fiyat");
		label_43.setHorizontalAlignment(SwingConstants.CENTER);
		label_43.setForeground(Color.WHITE);
		label_43.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_43.setBounds(848, 527, 83, 20);
		panel_2.add(label_43);
		
		temizleme_fiyat = new JTextField();
		temizleme_fiyat.setHorizontalAlignment(SwingConstants.CENTER);
		temizleme_fiyat.setFont(new Font("Tahoma", Font.BOLD, 12));
		temizleme_fiyat.setColumns(10);
		temizleme_fiyat.setBorder(null);
		temizleme_fiyat.setBounds(941, 524, 134, 20);
		panel_2.add(temizleme_fiyat);
		
		JButton button_65 = new JButton("+");
		button_65.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf(temizlemehaf�za);									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = �t�.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=temizlemefiyat*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += temizlemefiyat*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			
			
			
			
			}
		});
		button_65.setForeground(Color.WHITE);
		button_65.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_65.setFocusable(false);
		button_65.setBackground(new Color(165, 42, 42));
		button_65.setBounds(962, 562, 42, 20);
		panel_2.add(button_65);
		
		JButton button_66 = new JButton("-");
		button_66.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int index= t�r.indexOf(temizlemehaf�za);													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim==temizlemehaf�za) {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf(temizlemehaf�za);													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = �t�.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						�t�.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=temizlemefiyat*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= temizlemefiyat*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				�t�.setText("1");
			
			}
				
			
			}
		});
		button_66.setForeground(Color.WHITE);
		button_66.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button_66.setFocusable(false);
		button_66.setBackground(new Color(165, 42, 42));
		button_66.setBounds(1016, 562, 42, 20);
		panel_2.add(button_66);
		
		JButton button_72 = new JButton("");
		button_72.setIcon(new ImageIcon(KuruTemizleme.class.getResource("/ikonlar/abiye.png")));
		button_72.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = t�r.indexOf("Abiye");											//de�i�tir
				
				if (index==-1) {				
				String st = temiz.getText();
				int temizleme = Integer.valueOf(st);
				toplamfiyat += temizleme*abiyey;												//de�i�tir
				sat�rlar[0] = "Abiye";														//de�i�tir
				sat�rlar[1] = "Temizleme";														//de�i�tir
				sat�rlar[2] = temizleme;
				sat�rlar[3] = temizleme*abiyey;												//de�i�tir
				modelim.addRow(sat�rlar);
				
				ka��nc�sat�r+=1;
				haf�za1=ka��nc�sat�r;
				t�r.add("Abiye");															//de�i�tir
				
					
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s);
					temiz.setText("1");
					txt_geneltoplam.setText(s);
				}
				
				else {
					JOptionPane uyar� = new JOptionPane();
					uyar�.showMessageDialog(null, "Abiye zaten se�ili.","", 1);		//de�i�tir
				}
					
			
			
			
			}
		});
		button_72.setBounds(294, 596, 83, 90);
		panel_2.add(button_72);
		
		JLabel lblAbiye = new JLabel("AB\u0130YE");
		lblAbiye.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbiye.setForeground(Color.WHITE);
		lblAbiye.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAbiye.setBounds(294, 685, 83, 20);
		panel_2.add(lblAbiye);
		
		JButton button_74 = new JButton("+");
		button_74.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index= t�r.indexOf("Abiye");									//de�i�tir
				
				for (int i = index; i>=0 ;) {
					int adet = (int) modelim.getValueAt(i, 2);
					
					String st = kuru.getText();
					int temiz = Integer.valueOf(st);
					adet=adet+temiz;
					
					modelim.setValueAt(adet, i, 2);
					
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat +=abiyey*temiz;												//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat += abiyey*temiz;										//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					break;
					
				}
			}
		});
		button_74.setForeground(Color.WHITE);
		button_74.setFocusable(false);
		button_74.setBackground(new Color(0, 0, 128));
		button_74.setBounds(294, 706, 42, 20);
		panel_2.add(button_74);
		
		JButton button_75 = new JButton("-");
		button_75.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int index= t�r.indexOf("Abiye");													//de�i�tir
				String isim = (String) modelim.getValueAt(index, 0);
				if (isim=="Abiye") {																//de�i�tir
				
				for (int i = index; i>=0 ;) {
					index= t�r.indexOf("Abiye");													//de�i�tir													
					
					int adet = (int) modelim.getValueAt(i, 2);
					if (adet<1)
						break;
					else if (adet==1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							t�r.remove(index);
							
							break;
							
						}
					}
					else {
					
					String st = kuru.getText();
					int cevir = Integer.valueOf(st);
					
					adet -=cevir;
					if (adet<1) {
						
						for (int i1 = index; i1>=0 ;) {
							double d = (double) modelim.getValueAt(i1, 3);
							
							
							//System.out.println(d);
							toplamfiyat=toplamfiyat-d;
							modelim.removeRow(i1);
							t�r.remove(index);
							String temp = txt_toplam.getText();
							double temp2= Double.valueOf(temp);
							temp2=temp2-d;
							String stcevir = Double.toString(temp2);
							txt_toplam.setText(stcevir);
							txt_geneltoplam.setText(stcevir);
							
							break;
							
						}
						kuru.setText("1");
					
					}
					modelim.setValueAt(adet, i, 2);
					
					double fiyat = (double) modelim.getValueAt(i, 3);
					fiyat -=abiyey*cevir;														//de�i�tir
					modelim.setValueAt(fiyat, i, 3);
					
					toplamfiyat -= abiyey*cevir;												//de�i�tir
					String s = String.valueOf(toplamfiyat);
					txt_toplam.setText(s); //toplamfiyata yaz
					txt_geneltoplam.setText(s);
					}
					break;
					
				}
			
				kuru.setText("1");
			
			}
				
		}
			});
		button_75.setForeground(Color.WHITE);
		button_75.setFocusable(false);
		button_75.setBackground(new Color(0, 0, 128));
		button_75.setBounds(335, 706, 42, 20);
		panel_2.add(button_75);
		
		
		JLabel lblTeslimTarihi = new JLabel("Teslim Tarihi");
		lblTeslimTarihi.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeslimTarihi.setForeground(Color.WHITE);
		lblTeslimTarihi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTeslimTarihi.setBounds(1452, 128, 150, 14);
		contentPane.add(lblTeslimTarihi);
		
		JLabel lblAdlMterinin = new JLabel("Adl\u0131 m\u00FC\u015Fterinin ");
		lblAdlMterinin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdlMterinin.setForeground(Color.WHITE);
		lblAdlMterinin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdlMterinin.setBounds(1375, 94, 150, 14);
		contentPane.add(lblAdlMterinin);
		
		JLabel lblNoluSiparii = new JLabel("no'lu sipari\u015Fi");
		lblNoluSiparii.setVisible(true);
		lblNoluSiparii.setHorizontalAlignment(SwingConstants.CENTER);
		lblNoluSiparii.setForeground(Color.WHITE);
		lblNoluSiparii.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNoluSiparii.setBounds(1511, 93, 150, 14);
		contentPane.add(lblNoluSiparii);
		
		musteriid = new JTextField();
		musteriid.setVisible(false);
		musteriid.setHorizontalAlignment(SwingConstants.CENTER);
		musteriid.setFont(new Font("Tahoma", Font.BOLD, 14));
		musteriid.setFocusable(false);
		musteriid.setEditable(false);
		musteriid.setColumns(10);
		musteriid.setBorder(null);
		musteriid.setBackground(Color.WHITE);
		musteriid.setBounds(1196, 44, 34, 20);
		contentPane.add(musteriid);
		
		siparis1 = new JTextField();
		siparis1.setFocusable(false);
		siparis1.setEditable(false);
		siparis1.setHorizontalAlignment(SwingConstants.CENTER);
		siparis1.setForeground(Color.RED);
		siparis1.setFont(new Font("Tahoma", Font.BOLD, 13));
		siparis1.setColumns(10);
		siparis1.setBorder(null);
		siparis1.setBounds(1504, 91, 34, 20);
		contentPane.add(siparis1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1173, 221, 393, 91);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		modelim2.setColumnIdentifiers(kolonlar1);
		//modelim2.addRow(sat�rlar1);
		table_1.setModel(modelim2);
		table_1.setBounds(1441, 221, 161, 91);
		scrollPane_1.setViewportView(table_1);
		
				
		
		JLabel lblNewLabel_1 = new JLabel("Makbuz No : ");
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(1454, 42, 99, 22);
		contentPane.add(lblNewLabel_1);	
		
		JLabel lblSeilenMteriyeAit = new JLabel("Se\u00E7ilen M\u00FC\u015Fteriye Ait Teslim Edilmemi\u015F Sipari\u015Fler :");
		lblSeilenMteriyeAit.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeilenMteriyeAit.setForeground(Color.WHITE);
		lblSeilenMteriyeAit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeilenMteriyeAit.setBounds(1201, 189, 335, 22);
		contentPane.add(lblSeilenMteriyeAit);
		
		
		
	
		
			SqlSorgu.siparisdurumu();

		String makbuz = "select count(*) from siparisdurumu";
		ResultSet myRs1 = SqlSorgu.sorgula(makbuz);
		try {
			while(myRs1.next()) {
				String sttut = myRs1.getString(1);
				int tut = Integer.valueOf(sttut);
				tut+=1;
				String cevir = String.valueOf(tut);
				makbuzno.setText(cevir);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}


