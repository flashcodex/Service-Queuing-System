import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class DiagnosisInfo extends JFrame {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private static JPanel contentPane;
	private static JLabel lblClock;
	private static JLabel lblLogo;
	private JSeparator separator;
	public static JLabel lblGuest;
	private JLabel lblIcon;
	private Image img;
	private static JLabel lblSection;
	private static JLabel lblCustomerID;
	private static JLabel lblCustomNum;
	private static JLabel lblCustomerName;
	private static JLabel lblCustomName;
	private static JLabel lblServiceType;
	private static JLabel lblType;
	private static JLabel lblServiceCategory;
	private static JRadioButton rdoHardware;
	private static JRadioButton rdoSoftware;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JTextArea txtAreaDiag;
	private static JPanel pnlDiagnosis;
	private static JLabel lblRepairType;
	private JScrollPane scrollPane;
	private static JList<String> listRepairType;
	public static DefaultListModel<String> modelRepairType;
	public static DefaultListModel<String> modelRepairTypeComputerHardware;
	public static DefaultListModel<String> modelRepairTypeComputerSoftware;
	public static DefaultListModel<String> modelRepairTypeCellphoneHardware;
	public static DefaultListModel<String> modelRepairTypeCellphoneSoftware;
	private String[] RepairTypeComputerHardware = { "Change Keyboard", "Change Battery", "Change LCD",
			"Accessories Repair", "Customization" };
	private String[] RepairTypeComputerSoftware = { "Data Recovery & Backup", "Virus Removal", "Reformat",
			"OS Installation" };
	private String[] RepairTypeCellphoneHardware = { "Change Charging Port", "Change LCD", "Change Button" };
	private String[] RepairTypeCellphoneSoftware = { "Reformat", "OS Update", "BackUp and Restore" };
	private static JPanel pnlRepairType;
	private static JLabel lblDiagnosis;
	private static JPanel pnlCategory;
	private JTextField txtRepairType;
	private JButton btnAdd;
	private static JPanel pnlUpdate;
	private static JLabel lblCustomer;
	private static JLabel lblServe;
	private static JLabel lblOnGoing;
	private static JLabel lblServed;
	private static JLabel lblOngoing2;
	private JSeparator separator_1;
	private JButton btnAddQueue;
	private static JTable tblTechnicians;
	private JScrollPane spTechnicians;
	private static DefaultTableModel modelTechnician = new DefaultTableModel();
	private String[] technicians = { "TECHNICIAN ID", "TECHNICIAN NAME", "CUSTOMER ID" };
	public static Customer frmCustomer;
	private static JLabel lblContactNum;
	private static JTextField txtAccessCode;
	public static LogInForm frmLogin;
	public static Technician frmtechnician;
	public static WaitingDisplay frmWaitingDisplay;
	public static MessageBoxGuest frmMessageBoxGuest;
	public static String ServiceCategory = "";
	private static JLabel lblAccess;
	private JScrollPane spTxtArea;
	private JButton btnBack;
	private static JTextPane txtNote;
	private static JLabel lblNum;
	private static JPanel pnlCustomer;

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
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
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		clock.start();
	}

	public DiagnosisInfo() {
		frmLogin = new LogInForm();
		frmMessageBoxGuest = new MessageBoxGuest();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setBounds(100, 100, 845, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setSize(new Dimension(871, 488));
		contentPane.setLayout(null);

		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblClock.setBounds(10, 418, 203, 23);
		contentPane.add(lblClock);

		lblLogo = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setBounds(0, 0, 100, 100);
		contentPane.add(lblLogo);

		separator = new JSeparator();
		separator.setBounds(97, 67, 838, 2);
		contentPane.add(separator);

		lblGuest = new JLabel(" | Receptionist");
		lblGuest.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblGuest.setBounds(746, 34, 109, 35);
		contentPane.add(lblGuest);

		lblIcon = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/UserIcon.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIcon.setBounds(705, 22, 46, 47);
		contentPane.add(lblIcon);

		lblSection = new JLabel("Diagnosis Section");
		lblSection.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				AccessCode(true);
			}
		});
		lblSection.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblSection.setBounds(110, 34, 240, 35);
		contentPane.add(lblSection);

		pnlCategory = new JPanel();
		pnlCategory.setBackground(new Color(255, 250, 250));
		pnlCategory.setBounds(10, 121, 158, 86);
		contentPane.add(pnlCategory);
		pnlCategory.setLayout(null);

		lblServiceCategory = new JLabel("Service Category");
		lblServiceCategory.setBounds(0, 1, 160, 23);
		pnlCategory.add(lblServiceCategory);
		lblServiceCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblServiceCategory.setFont(new Font("Century Gothic", Font.BOLD, 13));

		rdoHardware = new JRadioButton("Hardware Service");
		rdoHardware.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FindExpertise(rdoHardware.getText());
			}
		});
		rdoHardware.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DependentJlist();
			}
		});
		rdoHardware.setBounds(17, 28, 139, 23);
		pnlCategory.add(rdoHardware);
		buttonGroup.add(rdoHardware);
		rdoHardware.setBackground(new Color(255, 250, 250));
		rdoHardware.setFont(new Font("Century Gothic", Font.PLAIN, 11));

		rdoSoftware = new JRadioButton("Software Service");
		rdoSoftware.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindExpertise(rdoSoftware.getText());
			}
		});
		rdoSoftware.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DependentJlist();
			}
		});
		rdoSoftware.setBounds(16, 54, 139, 23);
		pnlCategory.add(rdoSoftware);
		buttonGroup.add(rdoSoftware);
		rdoSoftware.setBackground(new Color(255, 250, 250));
		rdoSoftware.setFont(new Font("Century Gothic", Font.PLAIN, 11));

		pnlDiagnosis = new JPanel();
		pnlDiagnosis.setBounds(178, 121, 375, 86);
		contentPane.add(pnlDiagnosis);
		pnlDiagnosis.setLayout(null);

		lblDiagnosis = new JLabel("Diagnosis");
		lblDiagnosis.setBounds(10, 7, 63, 17);
		pnlDiagnosis.add(lblDiagnosis);
		lblDiagnosis.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiagnosis.setFont(new Font("Century Gothic", Font.BOLD, 13));
		
		spTxtArea = new JScrollPane();
		spTxtArea.setBounds(10, 28, 355, 48);
		pnlDiagnosis.add(spTxtArea);

		txtAreaDiag = new JTextArea();
		spTxtArea.setViewportView(txtAreaDiag);
		txtAreaDiag.setBackground(Color.WHITE);

		pnlRepairType = new JPanel();
		pnlRepairType.setBounds(563, 121, 292, 198);
		contentPane.add(pnlRepairType);
		pnlRepairType.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 28, 272, 130);
		pnlRepairType.add(scrollPane);

		modelRepairType = new DefaultListModel<String>();

		modelRepairTypeComputerHardware = new DefaultListModel<String>();
		for (String items : RepairTypeComputerHardware) {
			modelRepairTypeComputerHardware.addElement(items);
		}
		modelRepairTypeComputerSoftware = new DefaultListModel<String>();
		for (String items : RepairTypeComputerSoftware) {
			modelRepairTypeComputerSoftware.addElement(items);
		}
		modelRepairTypeCellphoneHardware = new DefaultListModel<String>();
		for (String items : RepairTypeCellphoneHardware) {
			modelRepairTypeCellphoneHardware.addElement(items);
		}
		modelRepairTypeCellphoneSoftware = new DefaultListModel<String>();
		for (String items : RepairTypeCellphoneSoftware) {
			modelRepairTypeCellphoneSoftware.addElement(items);
		}

		listRepairType = new JList<String>(modelRepairType);
		scrollPane.setViewportView(listRepairType);

		lblRepairType = new JLabel("Repair Type");
		lblRepairType.setBounds(0, 5, 101, 17);
		pnlRepairType.add(lblRepairType);
		lblRepairType.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepairType.setFont(new Font("Century Gothic", Font.BOLD, 13));

		txtRepairType = new JTextField();
		txtRepairType.setBounds(10, 167, 191, 20);
		pnlRepairType.add(txtRepairType);
		txtRepairType.setColumns(10);

		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (lblType.getText().contentEquals("Computer") && rdoHardware.isSelected() == true) {
					modelRepairTypeComputerHardware.addElement(txtRepairType.getText());
				}
				if (lblType.getText().contentEquals("Computer") && rdoSoftware.isSelected() == true) {
					modelRepairTypeComputerSoftware.addElement(txtRepairType.getText());
				}
				if (lblType.getText().contentEquals("Cellphone") && rdoHardware.isSelected() == true) {
					modelRepairTypeCellphoneHardware.addElement(txtRepairType.getText());
				}
				if (lblType.getText().contentEquals("Cellphone") && rdoSoftware.isSelected() == true) {
					modelRepairTypeCellphoneSoftware.addElement(txtRepairType.getText());
				}

				txtRepairType.setText("");
				txtRepairType.requestFocus();
			}
		});
		btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAdd.setBounds(207, 166, 75, 21);
		pnlRepairType.add(btnAdd);

		pnlUpdate = new JPanel();
		pnlUpdate.setBounds(563, 330, 292, 111);
		contentPane.add(pnlUpdate);
		pnlUpdate.setLayout(null);

		lblCustomer = new JLabel("Customer");
		lblCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomer.setFont(new Font("Century Gothic", Font.BOLD, 13));
		lblCustomer.setBounds(103, 0, 101, 17);
		pnlUpdate.add(lblCustomer);

		lblServe = new JLabel("Served :");
		lblServe.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblServe.setBounds(82, 28, 60, 23);
		pnlUpdate.add(lblServe);

		lblOnGoing = new JLabel("On going :");
		lblOnGoing.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblOnGoing.setBounds(66, 61, 76, 23);
		pnlUpdate.add(lblOnGoing);

		lblServed = new JLabel("0");
		lblServed.setForeground(new Color(0, 0, 128));
		lblServed.setHorizontalAlignment(SwingConstants.CENTER);
		lblServed.setFont(new Font("Century Gothic", Font.BOLD, 43));
		lblServed.setBounds(135, 22, 70, 37);
		pnlUpdate.add(lblServed);

		lblOngoing2 = new JLabel(" 0");
		lblOngoing2.setForeground(new Color(128, 0, 0));
		lblOngoing2.setHorizontalAlignment(SwingConstants.CENTER);
		lblOngoing2.setFont(new Font("Century Gothic", Font.BOLD, 43));
		lblOngoing2.setBounds(135, 62, 70, 37);
		pnlUpdate.add(lblOngoing2);

		separator_1 = new JSeparator();
		separator_1.setBounds(10, 218, 543, 2);
		contentPane.add(separator_1);

		btnAddQueue = new JButton("Add Queue");
		btnAddQueue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAddQueue.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnAddQueue.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAddQueue.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnAddQueue.setBackground(new Color(240, 240, 240));
			}
		});
		btnAddQueue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VerifyData();
				lblServed.setText(String.valueOf(MainAdmin.Served));
				lblOngoing2.setText(String.valueOf(MainAdmin.modelOngoing.getRowCount()));
				WaitingDisplay.UpdateContent();
				MainAdmin.RecordCounter();
				Report.lblRecordCount.setText(String.valueOf(Report.tblAllData.getRowCount()));
			}
		});
		
		btnAddQueue.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAddQueue.setBounds(421, 228, 132, 30);
		contentPane.add(btnAddQueue);

		spTechnicians = new JScrollPane();
		spTechnicians.setBounds(10, 228, 401, 191);
		contentPane.add(spTechnicians);

		tblTechnicians = new JTable(modelTechnician);
		modelTechnician.setColumnIdentifiers(technicians);
		spTechnicians.setViewportView(tblTechnicians);

		txtAccessCode = new JTextField();
		txtAccessCode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AccessCode();
					AccessCode(false);

				}
			}
		});
		txtAccessCode.setBounds(397, 34, 86, 20);
		contentPane.add(txtAccessCode);
		txtAccessCode.setColumns(10);
		txtAccessCode.setVisible(false);

		lblAccess = new JLabel("Access Code");
		lblAccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccess.setBounds(397, 22, 86, 14);
		contentPane.add(lblAccess);
		lblAccess.setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("O M S | Repair Shop");
		clock();
		lblServed.setText(String.valueOf(MainAdmin.Served));
		lblOngoing2.setText(String.valueOf(MainAdmin.modelOngoing.getRowCount()));
		
		btnBack = new JButton("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBack.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnBack.setBackground(new Color(240, 240, 240));
			}
		});
		btnBack.setBounds(217, 61, 75, 50);
		pnlUpdate.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmCustomer = new Customer();
				frmCustomer.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\back1.png"));
		
		txtNote = new JTextPane();
		txtNote.setForeground(new Color(0, 0, 255));
		txtNote.setBackground(new Color(255, 250, 250));
		txtNote.setFont(new Font("Century Gothic", Font.BOLD, 11));
		txtNote.setEditable(false);
		txtNote.setText("[..]NOTE:\r\n[..]This table displays your designated technician.\r\n\r\n[..]If this table doesn't displayed your technician, you will be added on queue list.");
		txtNote.setBounds(421, 269, 132, 150);
		contentPane.add(txtNote);
		
		pnlCustomer = new JPanel();
		pnlCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(105, 105, 105)));
		pnlCustomer.setBackground(new Color(255, 250, 250));
		pnlCustomer.setBounds(107, 72, 748, 47);
		contentPane.add(pnlCustomer);
		pnlCustomer.setLayout(null);
		
		lblCustomerName = new JLabel("Customer Name :");
		lblCustomerName.setBounds(140, 11, 100, 25);
		pnlCustomer.add(lblCustomerName);
		lblCustomerName.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				
		lblCustomName = new JLabel(" ");
		lblCustomName.setBounds(239, 11, 123, 25);
	    pnlCustomer.add(lblCustomName);
		lblCustomName.setFont(new Font("Century Gothic", Font.BOLD, 11));
						
		lblCustomerID = new JLabel("Customer Id :");
	    lblCustomerID.setBounds(10, 11, 83, 25);
		pnlCustomer.add(lblCustomerID);
		lblCustomerID.setFont(new Font("Century Gothic", Font.PLAIN, 11));
								
		lblCustomNum = new JLabel(" ");
		lblCustomNum.setBounds(84, 11, 53, 25);
		pnlCustomer.add(lblCustomNum);
		lblCustomNum.setFont(new Font("Century Gothic", Font.BOLD, 11));
										
		lblNum = new JLabel("Contact Number :");
		lblNum.setBounds(372, 11, 100, 25);
		pnlCustomer.add(lblNum);
	    lblNum.setFont(new Font("Century Gothic", Font.PLAIN, 11));
												
        lblContactNum = new JLabel(" ");
		lblContactNum.setBounds(475, 11, 89, 25);
		pnlCustomer.add(lblContactNum);
        lblContactNum.setFont(new Font("Century Gothic", Font.BOLD, 11));
														
	    lblServiceType = new JLabel("Service Type :");
	    lblServiceType.setBounds(574, 11, 75, 25);
	    pnlCustomer.add(lblServiceType);
	    lblServiceType.setFont(new Font("Century Gothic", Font.PLAIN, 11));
																
		lblType = new JLabel(" ");
		lblType.setBounds(654, 11, 84, 25);
		pnlCustomer.add(lblType);
	    lblType.setFont(new Font("Century Gothic", Font.BOLD, 11));
		
	}
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
			lblClock.setForeground(Color.WHITE);
			lblGuest.setForeground(Color.WHITE);
			lblSection.setForeground(Color.WHITE);
			lblCustomerID.setForeground(Color.WHITE);
			lblCustomNum.setForeground(Color.WHITE);
			lblCustomerName.setForeground(Color.WHITE);
			lblCustomName.setForeground(Color.WHITE);
			lblServiceType.setForeground(Color.WHITE);
			lblType.setForeground(Color.WHITE);
			lblServiceCategory.setForeground(Color.WHITE);
			rdoHardware.setForeground(Color.WHITE);
			rdoSoftware.setForeground(Color.WHITE);
			rdoHardware.setBackground(Color.DARK_GRAY);
			rdoSoftware.setBackground(Color.DARK_GRAY);
			pnlDiagnosis.setBackground(Color.DARK_GRAY);
			lblRepairType.setForeground(Color.WHITE);
			pnlRepairType.setBackground(Color.DARK_GRAY);
			lblDiagnosis.setForeground(Color.WHITE);
			pnlCategory.setBackground(Color.DARK_GRAY);
			pnlUpdate.setBackground(Color.DARK_GRAY);
			lblCustomer.setForeground(Color.WHITE);
			lblServe.setForeground(Color.WHITE);
			lblServed.setForeground(Color.WHITE);
			lblOngoing2.setForeground(Color.WHITE);
			lblOnGoing.setForeground(Color.WHITE);
			tblTechnicians.setBackground(Color.DARK_GRAY);
			tblTechnicians.setForeground(Color.WHITE);
			lblContactNum.setForeground(Color.WHITE);
			lblAccess.setForeground(Color.WHITE);
			lblNum.setForeground(Color.WHITE);
			txtNote.setBackground(Color.DARK_GRAY);
			txtNote.setForeground(Color.WHITE);
			pnlCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
			pnlCustomer.setBackground(Color.DARK_GRAY);
		}
		
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblClock.setForeground(Color.BLACK);
			lblGuest.setForeground(Color.BLACK);
			lblSection.setForeground(Color.BLACK);
			lblCustomerID.setForeground(Color.BLACK);
			lblCustomNum.setForeground(Color.BLACK);
			lblCustomerName.setForeground(Color.BLACK);
			lblCustomName.setForeground(Color.BLACK);
			lblServiceType.setForeground(Color.BLACK);
			lblType.setForeground(Color.BLACK);
			lblServiceCategory.setForeground(Color.BLACK);
			rdoHardware.setForeground(Color.BLACK);
			rdoSoftware.setForeground(Color.BLACK);
			rdoHardware.setBackground(new Color(255, 250, 250));
			rdoSoftware.setBackground(new Color(255, 250, 250));
			pnlDiagnosis.setBackground(new Color(240, 240, 240));
			lblRepairType.setForeground(Color.BLACK);
			pnlRepairType.setBackground(new Color(240, 240, 240));
			lblDiagnosis.setForeground(Color.BLACK);
			pnlCategory.setBackground(new Color(255, 250, 250));
			pnlUpdate.setBackground(new Color(240, 240, 240));
			lblCustomer.setForeground(Color.BLACK);
			lblServe.setForeground(Color.BLACK);
			lblServed.setForeground(new Color(0, 0, 128));
			lblOngoing2.setForeground(new Color(128, 0, 0));
			lblOnGoing.setForeground(Color.BLACK);
			tblTechnicians.setBackground(Color.WHITE);
			tblTechnicians.setForeground(Color.BLACK);
			lblContactNum.setForeground(Color.BLACK);
			lblAccess.setForeground(Color.BLACK);
			lblNum.setForeground(Color.BLACK);
			pnlCustomer.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Customer Details", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
			pnlCustomer.setBackground(new Color(255, 250, 250));
			txtNote.setBackground(new Color(255, 250, 250));
			txtNote.setForeground(new Color(0, 0, 255));
		}
	}
	public static void CustomerInfoInput(String[] Info) {

		String[] CustomerInformation = Info;
		JLabel[] lblInfo = { lblCustomNum, lblCustomName, lblType, lblContactNum };
		for (int index = 0; index < lblInfo.length; index++) {
			lblInfo[index].setText(CustomerInformation[index]);
		}

	}

	private void AccessCode() {
		if (txtAccessCode.getText().contentEquals("Omaiwa")) {
			frmLogin.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Invalid Access Code");
			txtAccessCode.setText(null);
		}
	}

	private void AccessCode(boolean Status) {
		txtAccessCode.setVisible(Status);
		lblAccess.setVisible(Status);

	}

	public void DependentJlist() {
		if (lblType.getText().contentEquals("Computer") && rdoHardware.isSelected() == true) {
			listRepairType.setModel(modelRepairTypeComputerHardware);
		}
		if (lblType.getText().contentEquals("Computer") && rdoSoftware.isSelected() == true) {
			listRepairType.setModel(modelRepairTypeComputerSoftware);
		}
		if (lblType.getText().contentEquals("Cellphone") && rdoHardware.isSelected() == true) {
			listRepairType.setModel(modelRepairTypeCellphoneHardware);
		}
		if (lblType.getText().contentEquals("Cellphone") && rdoSoftware.isSelected() == true) {
			listRepairType.setModel(modelRepairTypeCellphoneSoftware);
		}
	}

	public static void AddDatatoModelAllData() {
		
		AddDataToServing();

		if (rdoHardware.isSelected() == true) {
			ServiceCategory = rdoHardware.getText();
		}
		if (rdoSoftware.isSelected() == true) {
			ServiceCategory = rdoSoftware.getText();
		}

		String Tofind = lblType.getText() + " " + ServiceCategory;

		Object[] rowData = new Object[MainAdmin.modelAllData.getColumnCount()];
		rowData[0] = lblCustomNum.getText();
		rowData[1] = lblCustomName.getText();
		rowData[2] = lblContactNum.getText();
		rowData[3] = lblType.getText();
		rowData[4] = ServiceCategory;
		rowData[5] = txtAreaDiag.getText();
		rowData[6] = GetRepairType();
		if(modelTechnician.getRowCount() != 0) {
			rowData[7] = modelTechnician.getValueAt(0, 0);
			rowData[8] = modelTechnician.getValueAt(0, 1);
			rowData[9] = Tofind;
			rowData[10] = "Serving";
		}
		
		else if (modelTechnician.getRowCount() == 0) {
			rowData[7] = "Not Available";
			rowData[8] = "Not Available";
			rowData[9] = Tofind;
			rowData[10] = "Waiting";
		}
		rowData[11] = lblClock.getText(); ;
		rowData[12] = "------" ;
		rowData[13] = "" ;
		rowData[14] = "" ;
		
		MainAdmin.modelAllData.addRow(rowData);
		JOptionPane.showMessageDialog(null, "The Data Has been Saved");
		RemoveToAvailable();

	}

	public static String GetRepairType() {
		String RepairType = "";

		if (lblType.getText().contentEquals("Computer") && rdoHardware.isSelected() == true) {
			RepairType = modelRepairTypeComputerHardware.getElementAt(listRepairType.getSelectedIndex());
		}
		if (lblType.getText().contentEquals("Computer") && rdoSoftware.isSelected() == true) {
			RepairType = modelRepairTypeComputerSoftware.getElementAt(listRepairType.getSelectedIndex());
		}
		if (lblType.getText().contentEquals("Cellphone") && rdoHardware.isSelected() == true) {
			RepairType = modelRepairTypeCellphoneHardware.getElementAt(listRepairType.getSelectedIndex());
		}
		if (lblType.getText().contentEquals("Cellphone") && rdoSoftware.isSelected() == true) {
			RepairType = modelRepairTypeCellphoneSoftware.getElementAt(listRepairType.getSelectedIndex());
		}

		return RepairType;
	}

	private void VerifyData() {
		boolean ServiceCategory = true;
		boolean Diagnosis = true;
		boolean RepairType = true;
		String InfoDialog = "Please Fill Up the following";

		if (rdoHardware.isSelected() == false && rdoSoftware.isSelected() == false) {
			ServiceCategory = false;
			InfoDialog += "\n Service Category";
		}

		if (txtAreaDiag.getText().contentEquals("")) {
			Diagnosis = false;
			InfoDialog += "\n Diagnosis";
		}

		if (listRepairType.getSelectedIndex() < 0) {
			RepairType = false;
			InfoDialog += "\n Repair Type";
		}

		if (ServiceCategory == true && Diagnosis == true && RepairType == true) {
			AddDatatoModelAllData();
			Default();
			Customer.plusCustomerId();
			setVisible(false);
			frmCustomer = new Customer();
			frmCustomer.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(null, InfoDialog);
		}
	}

	private void Default() {
		lblServed.setText(String.valueOf(MainAdmin.Served));
		lblOngoing2.setText(String.valueOf(MainAdmin.modelOngoing.getRowCount()));
		lblCustomNum.setText("");
		lblCustomName.setText("");
		lblContactNum.setText("");
		lblType.setText("");
		buttonGroup.clearSelection();
		txtAreaDiag.setText("");
		listRepairType.clearSelection();
		listRepairType.setModel(modelRepairType);
		for (int index = 0; index < modelTechnician.getRowCount(); index++) {
			modelTechnician.removeRow(index);
		}
	}

	public static void FindExpertise(String ServiceCategory) {

		String Tofind = lblType.getText() + " " + ServiceCategory;

		for (int index = 0; index < modelTechnician.getRowCount(); index++) {
			modelTechnician.removeRow(index);
		}

		if (modelTechnician.getRowCount() != 0) {
			for (int index = 0; index < modelTechnician.getRowCount(); index++) {
				modelTechnician.removeRow(index);
			}
		}
		if (modelTechnician.getRowCount() == 0) {
			for (int index = 0; index < Technician.modelAvailable.getRowCount(); index++) {

				String Expertise = Technician.modelAvailable.getValueAt(index, 2) + " Service";

				if (Tofind.contentEquals(Expertise)) {

					Object[] rowData = new Object[modelTechnician.getColumnCount()];
					rowData[0] = Technician.modelAvailable.getValueAt(index, 0);
					rowData[1] = Technician.modelAvailable.getValueAt(index, 1);
					rowData[2] = lblCustomNum.getText();
					modelTechnician.addRow(rowData);
					for (int indexes = 1; indexes < modelTechnician.getRowCount(); indexes++) {
						modelTechnician.setValueAt("Waiting", indexes, 2);
					}
				}
			}
		}

	}

	public static void RemoveToAvailable() {
		if(modelTechnician.getRowCount() != 0) {
		for (int index = 0; index < Technician.modelTechnicianInfo.getRowCount(); index++) {
			String TechnicianIdToServe = String.valueOf(modelTechnician.getValueAt(0, 0));
			String ToChangeStatus = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 0));
			if (TechnicianIdToServe.contentEquals(ToChangeStatus)) {
				Technician.modelTechnicianInfo.setValueAt("Serving", index, 4);
			}
		}
		}
		
		
		for (int index = 0; index < Technician.modelTechnicianInfo.getRowCount(); index++) {
			if(modelTechnician.getRowCount() != 0) {
			String TechnicianIdToServe = String.valueOf(modelTechnician.getValueAt(0, 0));
			String IdtoRemove = String.valueOf(Technician.modelAvailable.getValueAt(index, 0));

			if (TechnicianIdToServe == IdtoRemove) {

				
				  Object[] rowData = new
				  Object[Technician.modelUnavailable.getColumnCount()]; 
				  rowData[0] = Technician.modelAvailable.getValueAt(index, 0); 
				  rowData[1] = Technician.modelAvailable.getValueAt(index, 1); 
				  rowData[2] = Technician.modelAvailable.getValueAt(index, 2); 
				  Technician.modelUnavailable.addRow(rowData);
				 
				Technician.modelAvailable.removeRow(index);
				modelTechnician.removeRow(0);
				break;
			}
			}
			
			
		}
	}
	
	public static void AddDataToServing() {
		
		if(modelTechnician.getRowCount() != 0) {
			Object[] rowData = new
					  Object[MainAdmin.modelOngoing.getColumnCount()]; 
					  rowData[0] = lblCustomNum.getText();
					  rowData[1] = lblCustomName.getText();
					  rowData[2] = modelTechnician.getValueAt(0, 1); 
					  rowData[3] = lblType.getText();
					  MainAdmin.modelOngoing.addRow(rowData);
		}
		else if (modelTechnician.getRowCount() == 0) {
			Object[] rowData = new
					  Object[MainAdmin.modelQueue.getColumnCount()]; 
					  rowData[0] = lblCustomNum.getText();
					  rowData[1] = lblCustomName.getText();
					  rowData[2] = lblType.getText(); 
					  rowData[3] = "Waiting"; 
					  rowData[4] = ServiceCategory;
					  MainAdmin.modelQueue.addRow(rowData);
		}
				  
	}
	
	public static void UpdateCounter() {
		lblServed.setText(String.valueOf(MainAdmin.Served));
		lblOngoing2.setText(String.valueOf(MainAdmin.modelOngoing.getRowCount()));
	}
}
