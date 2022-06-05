import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Component;
import java.awt.Event;

import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.nio.charset.Charset;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customer extends JFrame {

	protected static final JLabel show_validation_here = null;
	private static JPanel contentPane;
	private static JLabel lblLogo;
	private Image img;
	private static JLabel lblUser;
	private JSeparator separator;
	private static JLabel lblIcon;
	private static JLabel lblTitle;
	private static JLabel lblCustomerNo;
	public static JLabel lblCustomNum;
	
	public static int customNum = 1800;
	private static JLabel lblPersonalInformation;
	private static JLabel lblClock;
	public static JLabel lblCustomerName;
	public static JTextField txtCustomerName;
	public static JTextField txtContactNum;
	private static JLabel lblNote;
	private static JButton btnPhone;
	private JButton btnComputer;
	private static JLabel lblOr;
	private static JLabel lblContactNumber;
	public static DiagnosisInfo frmDiagnosisInfo;
	public static MessageBox frmMessageBox;
	public static String ServiceType = ""; 
	
	
	

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
						
						if(seconds < 10) {
							lblClock.setText("Time " + hour + ":" + minute + ":" + "0" + seconds + "   Date " + year + "/" + month + "/" + day);	
						}
						else
						lblClock.setText("Time " + hour + ":" + minute + ":" + seconds + "   Date " + year + "/" + month + "/" + day);
						
						sleep(1000);
						}
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		clock.start();
	}
	
	/**
	 * Create the frame.
	 */
	public Customer() {
		setResizable(false);
		frmMessageBox = new MessageBox();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setTitle("O M S | Repair Shop");
		setBounds(100, 100, 455, 305);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblUser = new JLabel(" | Receptionist");
		lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUser.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblUser.setBounds(320, 34, 105, 35);
		contentPane.add(lblUser);
		
		separator = new JSeparator();
		separator.setBounds(97, 67, 328, 2);
		contentPane.add(separator);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 0, 100, 100);
		contentPane.add(lblLogo);
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		img = new ImageIcon(this.getClass().getResource("/customer.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(279, 23, 44, 46);
		contentPane.add(lblIcon);
		
		lblTitle = new JLabel("Customer Section");
		lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitle.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblTitle.setBounds(110, 31, 197, 35);
		contentPane.add(lblTitle);
		
		lblCustomerNo = new JLabel("Customer No :");
		lblCustomerNo.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblCustomerNo.setBounds(279, 242, 100, 20);
		contentPane.add(lblCustomerNo);
		
		lblCustomNum = new JLabel("");
		lblCustomNum.setText(String.valueOf(customNum));
		lblCustomNum.setFont(new Font("Courier New", Font.PLAIN, 12));
		lblCustomNum.setBounds(379, 242, 50, 20);
		contentPane.add(lblCustomNum);
		
		lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblPersonalInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalInformation.setBounds(183, 75, 136, 14);
		contentPane.add(lblPersonalInformation);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 9));
		lblClock.setBounds(21, 242, 207, 14);
		contentPane.add(lblClock);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblCustomerName.setBounds(80, 100, 106, 14);
		contentPane.add(lblCustomerName);
		
		txtCustomerName = new JTextField();
		txtCustomerName.setBounds(193, 98, 176, 20);
		contentPane.add(txtCustomerName);
		txtCustomerName.setColumns(10);
		
		lblContactNumber = new JLabel("Contact Number :");
		lblContactNumber.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblContactNumber.setBounds(80, 124, 106, 14);
		contentPane.add(lblContactNumber);
		
		txtContactNum = new JTextField();
		txtContactNum.setColumns(10);
		txtContactNum.setBounds(193, 122, 176, 20);
		contentPane.add(txtContactNum);
		
		lblNote = new JLabel("| Please choose what device you want to be repaired (only one)");
		lblNote.setBackground(Color.WHITE);
		lblNote.setHorizontalAlignment(SwingConstants.CENTER);
		lblNote.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblNote.setBounds(21, 149, 404, 20);
		contentPane.add(lblNote);
		
		btnPhone = new JButton("CELLPHONE");
		btnPhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnPhone.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnPhone.setBackground(new Color(132, 244, 95));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnPhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnPhone.setBackground(new Color(240, 240, 240));
			}
		});
		btnPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyInput(0);
			}
		});
		img = new ImageIcon(this.getClass().getResource("/cp.png")).getImage();
		btnPhone.setIcon(new ImageIcon(img));
		btnPhone.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPhone.setBounds(54, 180, 152, 46);
		contentPane.add(btnPhone);
		
		btnComputer = new JButton("COMPUTER");
		btnComputer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnComputer.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnComputer.setBackground(new Color(58, 234, 164));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnComputer.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnComputer.setBackground(new Color(240, 240, 240));
			}
		});
		btnComputer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerifyInput(1);
			}
		});
		img = new ImageIcon(this.getClass().getResource("/computer.png")).getImage();
		btnComputer.setIcon(new ImageIcon(img));
		btnComputer.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnComputer.setBounds(242, 180, 145, 46);
		contentPane.add(btnComputer);
		
		lblOr = new JLabel("OR");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblOr.setBounds(197, 180, 50, 46);
		contentPane.add(lblOr);
		clock();
		DarkMode();
	}
	public void DarkMode() {
		if(MainAdmin.chkDarkNormal.isSelected()) {
			darkMode(true);
		}else{
			darkMode(false);
		}
	}
	
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
			lblTitle.setForeground(Color.WHITE);
			lblPersonalInformation.setForeground(Color.WHITE);
			lblUser.setForeground(Color.WHITE);
			lblCustomerName.setForeground(Color.WHITE);
			lblCustomerNo.setForeground(Color.WHITE);
			lblNote.setForeground(Color.WHITE);
			lblOr.setForeground(Color.WHITE);
			lblContactNumber.setForeground(Color.WHITE);
			lblCustomNum.setForeground(Color.WHITE);
			lblClock.setForeground(Color.WHITE);
		}if(Status == false) {
			contentPane.setBackground(Color.WHITE);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblTitle.setForeground(Color.BLACK);
			lblPersonalInformation.setForeground(Color.BLACK);
			lblUser.setForeground(Color.BLACK);
			lblCustomerName.setForeground(Color.BLACK);
			lblCustomerNo.setForeground(Color.BLACK);
			lblNote.setForeground(Color.BLACK);
			lblOr.setForeground(Color.BLACK);
			lblContactNumber.setForeground(Color.BLACK);
			lblCustomNum.setForeground(Color.BLACK);
			lblClock.setForeground(Color.BLACK);
		}
	}
	public static void CustomerInfo(){
	    String [] CustomerInformation = {lblCustomNum.getText(),txtCustomerName.getText(),ServiceType,txtContactNum.getText()};
		ServiceType = "";
		DiagnosisInfo.CustomerInfoInput(CustomerInformation);
	}
	
	public static void plusCustomerId(){
		customNum++;
	}
	
	public void VerifyInput(int frame) {
		
		boolean CustomerName = true;
		boolean CustomerContactNum = true ;
		
		if (txtCustomerName.getText().contentEquals("")) {
			CustomerName = false;
		}
		
		if (txtContactNum.getText().contentEquals("")) {
			CustomerContactNum = false;
		}
	
		if (CustomerName == false && CustomerContactNum==false) {
			JOptionPane.showMessageDialog(null, "Please Enter Input ");	
		}
		
		else if(CustomerName==false) {
			JOptionPane.showMessageDialog(null, "Please Enter Customer Name");
			
		}
		else if(CustomerContactNum==false) {
			JOptionPane.showMessageDialog(null, "Please Enter Customer Contact Number");
		}
		
		if (CustomerName == true && CustomerContactNum == true) {
			if (frame == 0) {
				frmDiagnosisInfo = new DiagnosisInfo();
				frmDiagnosisInfo.setVisible(true);
				setVisible(false);
				ServiceType = "Cellphone" ;
				CustomerInfo();
			}	
			if (frame == 1) {
				frmDiagnosisInfo = new DiagnosisInfo();
				frmDiagnosisInfo.setVisible(true);
				setVisible(false);
				ServiceType = "Computer" ;
				CustomerInfo();
			}
		}
				
	}
	
}
