import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.EventQueue;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.media.CannotRealizeException;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.bean.playerbean.MediaPlayer;
import javax.print.attribute.standard.Media;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.swing.JCheckBox;

public class WaitingDisplay extends JFrame {
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private Image img;
	
	private static JPanel contentPane;
	private static JLabel lblLogo;
	private static JLabel lblWaitingSection;
	private static JLabel lblServed;
	private static JList<String> listCustomerId;
	private static JList<String> listWaitingCustomer;
	private JScrollPane spCustomerId;
	private static JLabel lblCustomerId;
	public static DefaultListModel<String> modelServingCustomerID = new DefaultListModel<String>();
	public static DefaultListModel<String> modelWaitingCustomerID = new DefaultListModel<String>();
	private static JLabel lblWaitingToBe;
	private static JLabel lblClock;
	public static MainAdmin frmAdminForm;
	private static JLabel lblID;
	private JPanel pnlMarquee;
	public static int TechIdNo = 1800781;
	private int x = -1300, y = 685;
	public static JLabel lblNotification;
	private static JPanel pnlVideo;
	private static JSeparator separator_1;
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D)g;
		Font font = new Font("Century Gothic", Font.BOLD + Font.PLAIN, 40);
		g2.setFont(font);
		g2.setColor(Color.red);
		g2.drawString("THANK YOU FOR CHOOSING OMS REPAIR SHOP, HAPPY TO SERVE!!", x, y);
		
		try{
			Thread.sleep(50);
			}catch(Exception ex) {};
			
			x += 10;
			if(x>this.getWidth()) {
				x = -1300;
			}
			repaint();
	}
	
	public void clock() 
	{
		Thread clock = new Thread()
		{
			public void run() 
			{
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH)+1;
						int year = cal.get(Calendar.YEAR);
						
						int seconds = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						int aa = cal.get(Calendar.AM_PM) ;
						String AMPM = "";
						if(aa == 0) {
							AMPM = "AM";
						}
						if(aa == 1) {
							AMPM = "PM";
						}
						
						if(seconds < 10) {
							lblClock.setText("Time " + hour + ":" + minute + ":" + "0" + seconds + " " + AMPM + "   Date " + year + "/" + month + "/" + day);	
						}
						else
						
						lblClock.setText("Time " + hour + ":" + minute + ":" + seconds + " " + AMPM + "  Date " + year + "/" + month + "/" + day);
						
					
						if( seconds %2 == 0) {
							lblNotification.setFont(new Font("Century Gothic", Font.BOLD, 30));
							lblNotification.setForeground(new Color(168, 69, 87));
							
						}
						else {
							lblNotification.setFont(new Font("Century Gothic", Font.BOLD, 35));
							lblNotification.setForeground(Color.orange);
						}
						
						sleep(1000);
						}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}
	

	
	public WaitingDisplay() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setTitle("O M S | Repair Shop");
		setBounds(100, 100, 472, 324);
		setSize(new Dimension(1366, 690));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(99, 67, 1364, 21);
		contentPane.add(separator);
		
		lblLogo = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 0, 105, 109);
		contentPane.add(lblLogo);
		
		lblWaitingSection = new JLabel("Waiting Section");
		lblWaitingSection.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblWaitingSection.setBounds(115, 40, 226, 25);
		contentPane.add(lblWaitingSection);
		
		lblServed = new JLabel("NOW SERVING!");
		lblServed.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblServed.setForeground(new Color(0, 255, 0));
			}
			@Override
			public void focusLost(FocusEvent e) {
				lblServed.setForeground(new Color(128, 0, 0));
			}
		});
		lblServed.setForeground(new Color(128, 0, 0));
		lblServed.setHorizontalAlignment(SwingConstants.CENTER);
		lblServed.setFont(new Font("Century Gothic", Font.BOLD, 75));
		lblServed.setBounds(0, 120, 721, 75);
		contentPane.add(lblServed);
		
		lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblCustomerId.setBounds(212, 218, 280, 37);
		contentPane.add(lblCustomerId);
		
		spCustomerId = new JScrollPane();
		spCustomerId.setBounds(210, 266, 282, 318);
		contentPane.add(spCustomerId);
		
		listCustomerId = new JList<String>(modelServingCustomerID);
		listCustomerId.setForeground(new Color(0, 0, 128));
		listCustomerId.setFont(new Font("Century Gothic", Font.BOLD, 61));
		spCustomerId.setViewportView(listCustomerId);
		
		lblWaitingToBe = new JLabel("WAITING");
		lblWaitingToBe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWaitingToBe.setForeground(new Color(0, 0, 128));
		lblWaitingToBe.setFont(new Font("Century Gothic", Font.BOLD, 75));
		lblWaitingToBe.setBounds(795, 120, 512, 75);
		contentPane.add(lblWaitingToBe);
		
		lblID = new JLabel("Customer ID");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblID.setBounds(911, 218, 287, 37);
		contentPane.add(lblID);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(721, 67, 2, 550);
		contentPane.add(separator_1);
		
		JScrollPane spWaiting = new JScrollPane();
		spWaiting.setBounds(911, 266, 284, 318);
		contentPane.add(spWaiting);
		
		listWaitingCustomer = new JList<String>(modelWaitingCustomerID);
		listWaitingCustomer.setFont(new Font("Century Gothic", Font.BOLD, 63));
		listWaitingCustomer.setForeground(new Color(0, 0, 0));
		spWaiting.setViewportView(listWaitingCustomer);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblClock.setHorizontalAlignment(SwingConstants.CENTER);
		lblClock.setBounds(1101, 40, 239, 24);
		contentPane.add(lblClock);
		
		pnlMarquee = new JPanel();
		pnlMarquee.setBounds(0, 615, 1360, 47);
		contentPane.add(pnlMarquee);
		
		lblNotification = new JLabel("");
		lblNotification.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblNotification.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotification.setBounds(292, 27, 891, 37);
		contentPane.add(lblNotification);
		
		pnlVideo = new JPanel();
		pnlVideo.setBounds(70, 110, 1186, 507);
		contentPane.add(pnlVideo);
		pnlVideo.setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
		clock();

		
	}
	
	
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
			lblWaitingSection.setForeground(Color.white);
			lblClock.setForeground(Color.white);
			lblServed.setForeground(Color.ORANGE);
			lblWaitingToBe.setForeground(Color.YELLOW);
			lblCustomerId.setForeground(Color.WHITE);
			lblID.setForeground(Color.WHITE);
			lblNotification.setForeground(Color.WHITE);
		}if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblWaitingSection.setForeground(Color.BLACK);
			lblClock.setForeground(Color.BLACK);
			lblServed.setForeground(new Color(128, 0, 0));
			lblWaitingToBe.setForeground(new Color(0, 0, 128));
			lblCustomerId.setForeground(Color.BLACK);
			lblID.setForeground(Color.BLACK);
			lblNotification.setForeground(Color.BLACK);
		}
	
	}
	
	public static void UpdateContent() {
		
		modelWaitingCustomerID.removeAllElements();
		modelServingCustomerID.removeAllElements();
		
		for (int index = 0 ; index < MainAdmin.modelOngoing.getRowCount(); index++ ) {
			modelServingCustomerID.addElement(String.valueOf(MainAdmin.modelOngoing.getValueAt(index, 0)));
		}
		
		for (int index = 0 ; index < MainAdmin.modelQueue.getRowCount(); index++ ) {
			modelWaitingCustomerID.addElement(String.valueOf(MainAdmin.modelQueue.getValueAt(index, 0)));
		}
		
	}
	
	public static void ChangeVisibility(boolean Status) {
		lblServed.setVisible(Status);
		lblCustomerId.setVisible(Status);
		listCustomerId.setVisible(Status);
		lblWaitingToBe.setVisible(Status);
		listWaitingCustomer.setVisible(Status);
		separator_1.setVisible(Status);
		pnlVideo.setVisible(!Status);
	}
}
