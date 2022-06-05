import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.toedter.calendar.JCalendar;

public class LogInForm extends JFrame {

	private JLabel lblPleaseEnter;
	private JTextField txtUserName;
	private JLabel lblPassword;
	private Image img;
	private JButton btnLogIn;
	private JCheckBox chkShowPassword;
	private JLabel lblLogo;
	private JPasswordField txtPassword;
	private JLabel lblUserName;
	private JLabel lblClock;
	private static Customer frmCustomer;
	private static WaitingDisplay frmWaitingDisplay;
	private static Receptionist frmReceptionist;
	private static MainAdmin frmMainAdmin;
	
	

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
	public LogInForm() {
		setTitle("O M S | Repair Shop");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		getContentPane().setBackground(new Color(255, 245, 238));
		getContentPane().setLayout(null);
		
		lblPleaseEnter = new JLabel("PLEASE ENTER THE CREDENTIALS TO LOG IN");
		lblPleaseEnter.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPleaseEnter.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnter.setBounds(119, 0, 245, 35);
		getContentPane().add(lblPleaseEnter);
		
		txtUserName = new JTextField("");
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login();
				}
			}
		});
		txtUserName.setText("Username");
		txtUserName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if(txtUserName.getText().equals("Username")) {
					txtUserName.setText(null);
					txtUserName.setForeground(new Color(0, 0, 0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtUserName.getText().equals("")) {
					txtUserName.setText("Username");
					txtUserName.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtUserName.setForeground(new Color(192, 192, 192));
		txtUserName.setBounds(198, 40, 145, 24);
		getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		
		lblPassword = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/passwordIcon.png")).getImage();
		lblPassword.setIcon(new ImageIcon(img));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tekton Pro", Font.PLAIN, 13));
		lblPassword.setBounds(151, 65, 32, 41);
		getContentPane().add(lblPassword);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnLogIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
				btnLogIn.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogIn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnLogIn.setBackground(new Color(240, 240, 240));
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login();
			}
		});
		img = new ImageIcon(this.getClass().getResource("/Login.png")).getImage();
		btnLogIn.setIcon(new ImageIcon(img));
		btnLogIn.setBounds(177, 133, 166, 38);
		getContentPane().add(btnLogIn);
		
		chkShowPassword = new JCheckBox("Show Password");
		chkShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkShowPassword.isSelected()) {
					txtPassword.setEchoChar((char)0);
				}else {
					txtPassword.setEchoChar('\u2022');
				}
			}
		});
		chkShowPassword.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		chkShowPassword.setBackground(new Color(255, 245, 238));
		chkShowPassword.setBounds(219, 100, 136, 24);
		getContentPane().add(chkShowPassword);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 17, 145, 124);
		getContentPane().add(lblLogo);
		
		txtPassword = new JPasswordField("");
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					Login();
				}
			}
		});
		txtPassword.setText("Password");
		txtPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				String password = new String(txtPassword.getPassword());
				if(password.equals("Password")) {
					txtPassword.setText(null);
					txtPassword.setForeground(new Color(0, 0, 0));
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				String password = new String(txtPassword.getPassword());
				if(password.equals("")) {
					txtPassword.setText("Password");
					txtPassword.setForeground(new Color(192, 192, 192));
				}
			}
		});
		txtPassword.setForeground(new Color(192, 192, 192));
		txtPassword.setBounds(198, 75, 145, 24);
		getContentPane().add(txtPassword);
		
		lblUserName = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/UserIcon.png")).getImage();
		lblUserName.setIcon(new ImageIcon(img));
		lblUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserName.setFont(new Font("Tekton Pro", Font.PLAIN, 13));
		lblUserName.setBounds(141, 29, 57, 41);
		getContentPane().add(lblUserName);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 10));
		lblClock.setBounds(10, 152, 173, 19);
		getContentPane().add(lblClock);
		setBounds(100, 100, 380, 210);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		clock();
	}
	public void Login() {
		
		boolean varifyUsername = false;
		boolean varifyPassword = false;
		int UserNum = -1;
		int PassNum = -1;
		String Username = txtUserName.getText();
		String Password = txtPassword.getText();
		
		String [] AccountUser = {"Admin","User"};
		String [] AccountPass = {"Admin123","User123"};
		
		for (int index = 0 ; index < AccountUser.length ; index++) {
			if (Username.contentEquals(AccountUser[index])) {
				varifyUsername = true ;
				UserNum = index;
				break;
			}
		}
		
		for (int index = 0 ; index < AccountPass.length ; index++) {
			if (Password.contentEquals(AccountPass[index])) {
				varifyPassword = true ;
				PassNum = index;
				break;
			}
		}
		
		if (varifyUsername == true && varifyPassword == true) {

				
				if ((UserNum == 0 && PassNum == 0 ) || (UserNum == 1 && PassNum == 1 )) {
					
					setVisible(false);
					txtUserName.setText(null);
					txtPassword.setText(null);
					chkShowPassword.setSelected(false);
					JOptionPane.showMessageDialog(null, "Successfully Logged in!");
					
					if (UserNum == 0 && PassNum == 0 )
					{
						MainAdmin.ShowMain();
					}
					if (UserNum == 1 && PassNum == 1 )
					{
						ShowDisplay();
						frmReceptionist = new Receptionist();
						Receptionist.DarkMode(MainAdmin.chkDarkNormal.isSelected());
						frmReceptionist.setVisible(true);
					}
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Your Username and Password Does not Match");
				}	
			}
		
		if(varifyUsername == false && varifyPassword == true) {
			//Showing a messageDialog for incorrect password
			JOptionPane.showMessageDialog(null, "Incorrect username!");
			//Setting the cursor in txtPassword
			txtUserName.requestFocus();
			//Highlighting the text of txtPassword
			txtUserName.selectAll();
		}
		
		if(varifyUsername == true && varifyPassword == false) {
			//Showing a messageDialog for incorrect password
			JOptionPane.showMessageDialog(null, "Incorrect password!");
			//Setting the cursor in txtPassword
			txtPassword.requestFocus();
			//Highlighting the text of txtPassword
			txtPassword.selectAll();
		}
		
		if (varifyUsername == false && varifyPassword == false) {
			JOptionPane.showMessageDialog(null, "Incorrect Log in details!");
		}
		
	}
	
	public void ShowDisplay() {
		
			
			frmWaitingDisplay = new WaitingDisplay();
			frmWaitingDisplay.setVisible(true);
				
	}
	
	public void Default() {
		
		txtPassword.setText("Password");
		txtPassword.setForeground(new Color(192, 192, 192));
		txtUserName.setText("Username");
		txtUserName.setForeground(new Color(192, 192, 192));
		txtUserName.requestFocus();
		chkShowPassword.setSelected(false);
	}
}
