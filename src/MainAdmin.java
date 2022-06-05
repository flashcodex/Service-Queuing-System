import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainAdmin {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel contentPane;
	private Image img;
	private JLabel lblLogo;
	public static JLabel lblAdministrator;
	private JSeparator separator;
	private JLabel lblQueue;
	private JLabel lblIcon;
	private JPanel pnlQueue;
	private  static JTabbedPane tbdQueue;
	private JPanel pnlOngoing;
	private JPanel pnlAllData;
	public static JCheckBox chkDarkNormal;
	public static JTable tblQueue;
	private JScrollPane spQueue;
	public static String[] columnQueue = {"Customer Id.", "Customer Name", "Device", "Technician", "Service Category"};
	public static String[] columnOngoing = {"Customer Id.", "Customer Name", "Technician", "Service Type"};
	public static String[] columnAllData = {"Customer Id.", "Customer Name","Contact No","Service Type","Service Category",
			"Diagnosis", "Repair Type", "Technician Id", "Technician Name", "Expertise", "Status", "Received" , "Finished",
			"Reason For Cancellation","Operator"};
	public static DefaultTableModel modelQueue = new DefaultTableModel();
	public static DefaultTableModel modelOngoing = new DefaultTableModel();
	public static DefaultTableModel modelAllData = new DefaultTableModel();
	public static JTable tblOngoing;
	private JScrollPane spOngoing;
	public static JTable tblAllData;
	private JScrollPane spAllData;
	public static JLabel lblClock;
	private JPanel pnlDropDown;
	private JButton btnEmployee;
	private JButton report;
	private JButton btnLogout;
	private JLabel lblFilter;
	private static JComboBox<String> cboFilter;
	private JLabel lblSearch;
	private static JTextField txtSearch;
	private JButton btnFinish;
	public static int Served = 0;
	private static int Record = 0;
	private static TableRowSorter<DefaultTableModel> sorter;
	private JButton btnCancel;
	private static JFrame AdminForm;
	public static LogInForm frmLogin;
	public static Technician frmtechnician;
	public static Report frmReport;
	public static MessageBox frmMessageBox;
	public static MessageBoxGuest frmMessageBoxGuest;
	public static DiagnosisInfo frmDiagnosisInfo;
	public static WaitingDisplay frmWaitingDisplay;
	public static CancelReason frmCancelReason;
	public static Customer frmCustomer;
	private static JLabel lblRecordCount;
	private JLabel lblRecord;
	private JButton btnMessage;
	public static String Reason = "";
	public static Receptionist frmReceptionist;

	/**
	 * Launch the application.
	 * @return 
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainAdmin window = new MainAdmin();
					MainAdmin.AdminForm.setVisible(false);
					frmReceptionist = new Receptionist();
					frmtechnician = new Technician();
					frmReport = new Report();
					frmLogin = new LogInForm();
					frmCustomer = new Customer();
					frmDiagnosisInfo = new DiagnosisInfo();
					frmWaitingDisplay = new WaitingDisplay();
					frmMessageBox = new MessageBox();
					frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
						
						if (hour  == 6 && minute == 0 && seconds == 0 && aa == 1) {
							chkDarkNormal.setSelected(true);
							DarkMode(true);
						}
						else if (hour  == 6 && minute == 0 && seconds == 0 && aa == 0) {
							chkDarkNormal.setSelected(false);
							DarkMode(false);
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
	
		
	/**
	 * Create the application.
	 */
	public MainAdmin() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AdminForm = new JFrame();
		AdminForm.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		AdminForm.setLocationRelativeTo(null);
		AdminForm.setTitle("O M S | Repair Shop");
		AdminForm.setBounds(100, 100, 905, 546);
		AdminForm.setSize(new Dimension(1366, 709));
		AdminForm.setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		AdminForm.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlDropDown = new JPanel();
		pnlDropDown.setBackground(new Color(0, 191, 255));
		pnlDropDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlDropDown.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlDropDown.setVisible(false);
			}
		});
		pnlDropDown.setBounds(1216, 67, 114, 106);
		contentPane.add(pnlDropDown);
		pnlDropDown.setLayout(null);
		pnlDropDown.setVisible(false);
		
		btnEmployee = new JButton("Employee");
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmtechnician.setVisible(true);
			}
		});
		btnEmployee.setForeground(Color.WHITE);
		btnEmployee.setBackground(new Color(0, 191, 255));
		btnEmployee.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlDropDown.setVisible(true);
			}
		});
		btnEmployee.setBounds(10, 11, 94, 23);
		pnlDropDown.add(btnEmployee);
		
		report = new JButton("Report");
		report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmReport.setVisible(true);
			}
		});
		report.setForeground(Color.WHITE);
		report.setFont(new Font("Century Gothic", Font.BOLD, 11));
		report.setBackground(new Color(0, 191, 255));
		report.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlDropDown.setVisible(true);
			}
		});
		report.setBounds(10, 41, 94, 23);
		pnlDropDown.add(report);
		
		btnLogout = new JButton("Log-out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminForm.setVisible(false);
				frmLogin.setVisible(true);
				frmLogin.Default();
				
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnLogout.setBackground(new Color(0, 191, 255));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlDropDown.setVisible(true);
			}
		});
		btnLogout.setBounds(10, 72, 94, 23);
		pnlDropDown.add(btnLogout);
		
		
		lblAdministrator = new JLabel(" | ADMINISTRATOR");
		lblAdministrator.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				pnlDropDown.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlDropDown.setVisible(false);
			}
		});
		lblAdministrator.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblAdministrator.setBounds(1206, 33, 134, 35);
		contentPane.add(lblAdministrator);
		
		separator = new JSeparator();
		separator.setBounds(97, 67, 1253, 21);
		contentPane.add(separator);
		separator.setSize(dim.width, 21);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 0, 100, 100);
		contentPane.add(lblLogo);
		
		tbdQueue = new JTabbedPane(JTabbedPane.LEFT);
		tbdQueue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//to remove the items of cboFilter
				if (cboFilter.getItemCount() != 0){
					cboFilter.removeAllItems();
				}
				
				LoadItems();
				
				int Operation = tbdQueue.getSelectedIndex();
				if (Operation == 0) {
					btnFinish.setEnabled(false);
					btnCancel.setEnabled(true);
				}
				else if  (Operation == 1) {
					btnFinish.setEnabled(true);
					btnCancel.setEnabled(true);
				}
				else if  (Operation == 2) {
					btnFinish.setEnabled(false);
					btnCancel.setEnabled(false);
				}
				RecordCounter();
			}
		});
		tbdQueue.setBackground(new Color(0, 204, 204));
		tbdQueue.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tbdQueue.setBounds(10, 120, 1196, 517);
		contentPane.add(tbdQueue);
		modelQueue.setColumnIdentifiers(columnQueue);
		
		pnlQueue = new JPanel();
		tbdQueue.addTab("Today's Queue", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\todayQueue.png"), pnlQueue, null);
		pnlQueue.setLayout(null);
		
		spQueue = new JScrollPane();
		spQueue.setBounds(0, 0, 1014, 512);
		pnlQueue.add(spQueue);
		
		tblQueue = new JTable(modelQueue);
		tblQueue.setBackground(Color.WHITE);
		tblQueue.setDefaultEditor(Object.class, null);
		
		spQueue.setViewportView(tblQueue);
		
		pnlOngoing = new JPanel();
		tbdQueue.addTab("Ongoing", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\ongoing.png"), pnlOngoing, null);
		pnlOngoing.setLayout(null);
		
		spOngoing = new JScrollPane();
		spOngoing.setBounds(0, 0, 1014, 512);
		pnlOngoing.add(spOngoing);
		
		tblOngoing = new JTable(modelOngoing);
		tblOngoing.setDefaultEditor(Object.class, null);
		modelOngoing.setColumnIdentifiers(columnOngoing);
		spOngoing.setViewportView(tblOngoing);
		
		pnlAllData = new JPanel();
		tbdQueue.addTab("All Data", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\alldata.png"), pnlAllData, null);
		pnlAllData.setLayout(null);
		
		spAllData = new JScrollPane();
		spAllData.setBounds(0, 0, 1014, 512);
		pnlAllData.add(spAllData);
		
		tblAllData = new JTable(modelAllData);
		tblAllData.setBackground(Color.WHITE);
		tblAllData.setDefaultEditor(Object.class, null);
		modelAllData.setColumnIdentifiers(columnAllData);
		spAllData.setViewportView(tblAllData);
		
		lblQueue = new JLabel(" | Queue, Ongoing and Report Details\r\n");
		img = new ImageIcon(this.getClass().getResource("/detail.png")).getImage();
		lblQueue.setIcon(new ImageIcon(img));
		lblQueue.setHorizontalAlignment(SwingConstants.LEFT);
		lblQueue.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblQueue.setBounds(110, 33, 466, 30);
		contentPane.add(lblQueue);
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		img = new ImageIcon(this.getClass().getResource("/UserIcon.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(1161, 21, 46, 47);
		contentPane.add(lblIcon);
		
		chkDarkNormal = new JCheckBox("Dark Mode");
		chkDarkNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chkDarkNormal.isSelected()) {
					DarkMode(true);
				}
				else {
					DarkMode(false);
				}
			}
		});
		chkDarkNormal.setBackground(new Color(255, 250, 250));
		chkDarkNormal.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		chkDarkNormal.setBounds(20, 638, 108, 21);
		contentPane.add(chkDarkNormal);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblClock.setBounds(1112, 638, 248, 33);
		contentPane.add(lblClock);
		
		lblFilter = new JLabel("Search In");
		lblFilter.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\searchIn.png"));
		lblFilter.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblFilter.setBounds(698, 88, 114, 35);
		contentPane.add(lblFilter);
		
	
		
		lblSearch = new JLabel("Search");
		img = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		lblSearch.setIcon(new ImageIcon(img));
		lblSearch.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSearch.setBounds(984, 88, 74, 31);
		contentPane.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				SearchIn(cboFilter.getSelectedIndex());
			}
		});
		txtSearch.setBounds(1055, 95, 141, 20);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		cboFilter = new JComboBox<String>();
		cboFilter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSearch.setText("");
				SearchIn(cboFilter.getSelectedIndex());
			}
		});
		cboFilter.setBounds(799, 95, 141, 21);
		contentPane.add(cboFilter);
		for(String Searchin : columnQueue ) {
			cboFilter.addItem(Searchin);
		}
		
		btnFinish = new JButton("Finish");
		btnFinish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnFinish.isEnabled()) {
					btnFinish.setFont(new Font("Century Gothic", Font.BOLD, 14));
					btnFinish.setBackground(Color.YELLOW);
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				if (btnFinish.isEnabled()) {
				btnFinish.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnFinish.setBackground(new Color(240, 240, 240));
				}
			}
		});
		btnFinish.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\finish.png"));
		btnFinish.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//condition for verifying if there is a selected row
				if (tblOngoing.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please Select a Row");
				}
				//execute if there is a selected row
				else if (tblOngoing.getSelectedRow() >= 0) {
				ServiceFinish();
				txtSearch.setText("");
				SearchIn(cboFilter.getSelectedIndex());
				FindTechnicianforWaiting();
				Served++;
				DiagnosisInfo.UpdateCounter();
				WaitingDisplay.UpdateContent();
				RecordCounter();
				}
			}
		});
		btnFinish.setBounds(1216, 184, 114, 47);
		contentPane.add(btnFinish);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setFont(new Font("Century Gothic", Font.BOLD, 14));
				btnCancel.setBackground(Color.RED);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnCancel.setBackground(new Color(240, 240, 240));
			}
		});
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table[] = {tblQueue,tblOngoing};
				//if there is no selected row
				if (table[tbdQueue.getSelectedIndex()].getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please Select a Row");
				}
				else if (table[tbdQueue.getSelectedIndex()].getSelectedRow() >= 0) {
					// get the Name of the Technician on the Selected Row
					frmCancelReason = new CancelReason();
					frmCancelReason.setVisible(true);
					CancelReason.User = 1 ;
				}
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\cancel.png"));
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.setBounds(1216, 242, 114, 47);
		contentPane.add(btnCancel);
		
		btnMessage = new JButton("Message");
		btnMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMessage.setFont(new Font("Century Gothic", Font.BOLD, 10));
				btnMessage.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnMessage.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnMessage.setBackground(new Color(240, 240, 240));
			}
		});
		btnMessage.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\chats.png"));
		btnMessage.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMessageBox.setVisible(true);

			}
		});
		btnMessage.setBounds(1216, 300, 114, 47);
		contentPane.add(btnMessage);
		AdminForm.setResizable(false);
		btnFinish.setEnabled(false);
		
		lblRecord = new JLabel("Record :");
		lblRecord.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblRecord.setBounds(1213, 616, 52, 21);
		contentPane.add(lblRecord);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setText(String.valueOf(Record));
		lblRecordCount.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblRecordCount.setBounds(1261, 616, 52, 21);
		contentPane.add(lblRecordCount);
		RecordCounter();
		
	}
	
	
	public static void ShowMain() {
		AdminForm.setVisible(true);
	}
	public void DarkMode(boolean Status) {
		
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblAdministrator.setForeground(Color.WHITE);
			img = new ImageIcon(this.getClass().getResource("/LogooDark.png")).getImage();
			lblLogo.setIcon(new ImageIcon(img));
			tbdQueue.setBackground(Color.DARK_GRAY);
			pnlQueue.setForeground(Color.WHITE);
			tbdQueue.setForegroundAt(0, Color.WHITE);
			tblQueue.setBackground(Color.DARK_GRAY);
			tblQueue.setForeground(Color.WHITE);
			pnlOngoing.setForeground(Color.WHITE);
			tblOngoing.setForeground(Color.WHITE);
			tblOngoing.setBackground(Color.DARK_GRAY);
			tbdQueue.setForegroundAt(1, Color.WHITE);
			pnlAllData.setForeground(Color.WHITE);
			tblAllData.setForeground(Color.WHITE);
			tblAllData.setBackground(Color.DARK_GRAY);
			tbdQueue.setForegroundAt(2, Color.WHITE);
			lblQueue.setForeground(Color.WHITE);
			chkDarkNormal.setForeground(Color.WHITE);
			chkDarkNormal.setBackground(Color.DARK_GRAY);
			lblClock.setForeground(Color.WHITE);
			pnlDropDown.setBackground(Color.DARK_GRAY);
			btnLogout.setBackground(Color.DARK_GRAY);
			btnEmployee.setBackground(Color.DARK_GRAY);
			report.setBackground(Color.DARK_GRAY);
			lblFilter.setForeground(Color.white);
			lblSearch.setForeground(Color.white);
			lblRecord.setForeground(Color.WHITE);
			lblRecordCount.setForeground(Color.WHITE);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblAdministrator.setForeground(Color.BLACK);
			img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
			lblLogo.setIcon(new ImageIcon(img));
			tbdQueue.setBackground(new Color(0, 204, 204));
			tblQueue.setBackground(Color.WHITE);
			tblQueue.setForeground(Color.BLACK);
			chkDarkNormal.setBackground(new Color(255, 250, 250));
			lblClock.setForeground(Color.BLACK);
			tbdQueue.setForegroundAt(0, Color.BLACK);
			pnlOngoing.setForeground(Color.BLACK);
			tblOngoing.setForeground(Color.BLACK);
			tblOngoing.setBackground(Color.WHITE);
			tbdQueue.setForegroundAt(1, Color.BLACK);
			tblAllData.setForeground(Color.BLACK);
			tblAllData.setBackground(Color.WHITE);
			tbdQueue.setForegroundAt(2, Color.BLACK);
			lblQueue.setForeground(Color.BLACK);
			chkDarkNormal.setForeground(Color.BLACK);
			chkDarkNormal.setBackground(Color.WHITE);
			pnlDropDown.setBackground(new Color(0, 191, 255));
			btnLogout.setBackground(new Color(0, 191, 255));
			btnEmployee.setBackground(new Color(0, 191, 255));
			report.setBackground(new Color(0, 191, 255));
			lblFilter.setForeground(Color.BLACK);
			lblSearch.setForeground(Color.BLACK);
			lblRecord.setForeground(Color.BLACK);
			lblRecordCount.setForeground(Color.BLACK);
			
		}
		DiagnosisInfo.darkMode(Status);
		WaitingDisplay.darkMode(Status);
		MessageBoxGuest.darkMode(Status);
		MessageBox.darkMode(Status);
		Report.darkMode(Status);
		Technician.darkMode(Status);
		Hire.darkMode(Status);
		Customer.darkMode(Status);
		Receptionist.DarkMode(Status);
		
		
	}
	public static void ServiceFinish() {
		
			//getting the Name of the Technician
			String TechnicianName = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 2));
				
				for (int index = 0 ; index < modelAllData.getRowCount(); index++) {
					// getting the Customer Id in Selected Row in tlbOngoing
				 	String CustomerId = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 0));
				 	// getting the value of customerId in each row through looping
					String TechnicianToFind = String.valueOf(modelAllData.getValueAt(index, 0));	
					//condition to find the row in the modelAllData that match with the Customer Id 
					//execute if the condition if true
					if (CustomerId.equals(TechnicianToFind) ) {
						//change the value of Transaction Status to Finished
						modelAllData.setValueAt("Finished", index, 10);
						//Set the value of Transaction Finished Time and Date
						modelAllData.setValueAt(lblClock.getText(), index, 12);
						MainAdmin.modelAllData.setValueAt(lblAdministrator.getText(), index, 14);
						JOptionPane.showMessageDialog(null, "The transaction has been finished successfully!");
						//Looping in finding the row in modelOngoing to remove
						for(int indexfind = 0 ; indexfind < modelOngoing.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(modelOngoing.getValueAt(indexfind , 0)))) {
								WaitingDisplay.lblNotification.setText("Customer " +String.valueOf(modelOngoing.getValueAt(indexfind , 0)) + " Your Device is Now Repaired");
								modelOngoing.removeRow(indexfind);
								indexfind =  modelOngoing.getRowCount();	
							}
						}
						
						break;
					}
			}
			
				//looping to find the Technician in modelUnabailable the move it to model Available
				for (int index = 0 ; index < Technician.modelUnavailable.getRowCount(); index++) {
					String TechnicianToFind = String.valueOf(Technician.modelUnavailable.getValueAt(index, 1));
					if (TechnicianName == TechnicianToFind ) {
					 Object[] rowData = new
							  Object[Technician.modelAvailable.getColumnCount()]; 
							  rowData[0] = Technician.modelUnavailable.getValueAt(index, 0); 
							  rowData[1] = Technician.modelUnavailable.getValueAt(index, 1); 
							  rowData[2] = Technician.modelUnavailable.getValueAt(index, 2); 
							  Technician.modelAvailable.addRow(rowData);
							  Technician.modelUnavailable.removeRow(index);
							  DiagnosisInfo.UpdateCounter();
							  break;
					}
				}
				
				//to change the Status of the Technian in the modelTechnicianInfo
				for (int index = 0 ; index < modelAllData.getRowCount(); index++) {
				String TechnicianToFind = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 1));
					if (TechnicianName == TechnicianToFind ) {
						Technician.modelTechnicianInfo.setValueAt("Available", index, 4);
						break;
					}
				}		
	}
	public static void FindTechnicianforWaiting() {
		String Experties = null ;
		String ToFindExperties = null;
		String ToFind = null ;
		
		for(int outindex = 0 ; outindex < modelQueue.getRowCount();outindex++) { 
		for(int index = 0 ; index < modelAllData.getRowCount();index++) { 
			ToFind = String.valueOf(modelQueue.getValueAt(outindex, 0)); 
			if (ToFind == String.valueOf(modelAllData.getValueAt(index, 0))) { // find with the same CustomerID
				Experties = String.valueOf(modelAllData.getValueAt(index, 9));
				for(int indexx = 0 ; indexx < Technician.modelAvailable.getRowCount();indexx++) {
					  ToFindExperties = String.valueOf(Technician.modelAvailable.getValueAt(indexx, 2)) + " Service";
					  if (ToFindExperties.contentEquals(Experties) )  {
						   //Add the Data to Ongoing
						   Object[] rowData = new Object[modelOngoing.getColumnCount()];
							rowData[0] = modelQueue.getValueAt(outindex, 0);
							rowData[1] = modelQueue.getValueAt(outindex, 1);
							rowData[2] = String.valueOf(Technician.modelAvailable.getValueAt(indexx, 1));
							rowData[3] = String.valueOf(modelAllData.getValueAt(index, 3));
							modelOngoing.addRow(rowData);
							//Change the value of data on AllData
							modelAllData.setValueAt(Technician.modelAvailable.getValueAt(indexx, 0), index, 7);
							modelAllData.setValueAt(Technician.modelAvailable.getValueAt(indexx, 1), index, 8);
							modelAllData.setValueAt("Serving", index, 10);
							//Make the Technician Serving Again
								  Object[] rowDataa = new
								  Object[Technician.modelUnavailable.getColumnCount()]; 
								  rowDataa[0] = Technician.modelAvailable.getValueAt(indexx, 0); 
								  rowDataa[1] = Technician.modelAvailable.getValueAt(indexx, 1); 
								  rowDataa[2] = Technician.modelAvailable.getValueAt(indexx, 2);
								  	String TechnicianIdToServe = String.valueOf(rowDataa[0]);
									for(int indexto = 0 ; indexto < Technician.modelTechnicianInfo.getRowCount() ; indexto++  ) {
									String ToChangeStatus = String.valueOf(Technician.modelTechnicianInfo.getValueAt(indexto, 0));
									if (TechnicianIdToServe.contentEquals(ToChangeStatus)) {
										Technician.modelTechnicianInfo.setValueAt("Serving", indexto, 4);
										indexto = Technician.modelTechnicianInfo.getRowCount();
										}
									}
								  Technician.modelUnavailable.addRow(rowDataa);
								  Technician.modelAvailable.removeRow(indexx);
							//Remove The data on the Queue
							modelQueue.removeRow(outindex);
							//Stop the loop
							outindex =  modelQueue.getRowCount();
							index =  modelAllData.getRowCount();
							break;
					  }
					}
				  }
		  		}
			  }
	}	
	private void LoadItems() {
			
		
			if(tbdQueue.getSelectedIndex() == 0) {
				
				for(String Searchin : columnQueue ) {
					cboFilter.addItem(Searchin);
				}
			}
			
			else if (tbdQueue.getSelectedIndex() == 1) {
				for(String Searchin : columnOngoing ) {
					cboFilter.addItem(Searchin);
				}
			}
			
			else if (tbdQueue.getSelectedIndex() == 2) {
				for(String Searchin : columnAllData ) {
					cboFilter.addItem(Searchin);
				}
			}
	}
	private static void SearchIn(int ColumnIndex) {
		JTable TosearchIn [] = {tblQueue,tblOngoing,tblAllData};
		DefaultTableModel ToSearch [] = {modelQueue,modelOngoing,modelAllData};
			
		RowFilter<DefaultTableModel, Object> rowFilter = null ;
		rowFilter = RowFilter.regexFilter( "(?i)" + txtSearch.getText(), ColumnIndex);
		sorter = new TableRowSorter<DefaultTableModel>(ToSearch[tbdQueue.getSelectedIndex()]);
		sorter.setRowFilter(rowFilter);
		TosearchIn[tbdQueue.getSelectedIndex()].setRowSorter(sorter);
		RecordCounter();	
	}	
	public static void ServiceCancel() {
		
		JTable table[] = {tblQueue,tblOngoing};
		
		//to identifiy if there is selected row on the table 
		if (table[tbdQueue.getSelectedIndex()].getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Please Select a Row");
		}
		else if (table[tbdQueue.getSelectedIndex()].getSelectedRow() >= 0) {
		// get the Name of the Technician on the Selected Row
		
		String TechnicianName = "";
		//condition for where to get the Technician Name
		if (tbdQueue.getSelectedIndex() == 1) {
		  TechnicianName = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 2));
		}
		else if (tbdQueue.getSelectedIndex() == 0) {
			TechnicianName = String.valueOf(tblQueue.getValueAt(tblQueue.getSelectedRow(), 3));
	 	}
			
		 for (int index = 0 ; index < modelAllData.getRowCount(); index++) {
			 	//get the customer Id on the selected row
			 	String CustomerId = "" ;
			 	//condition for where to get the Customer ID
			 	if (tbdQueue.getSelectedIndex() == 1) {
			 		 CustomerId = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 0));
			 	}
			 	else if (tbdQueue.getSelectedIndex() == 0) {
			 		 CustomerId = String.valueOf(tblQueue.getValueAt(tblQueue.getSelectedRow(), 0));
			 	}
			 	
			 	// find the row of the technician in the model of AllData
				String TechnicianToFind = String.valueOf(modelAllData.getValueAt(index, 0));
				if (CustomerId.equals(TechnicianToFind) ) {
					modelAllData.setValueAt("Canceled", index, 10);
					modelAllData.setValueAt(lblClock.getText(), index, 12);
					modelAllData.setValueAt(Reason, index, 13);
					MainAdmin.modelAllData.setValueAt(lblAdministrator.getText(), index, 14);
					if (tbdQueue.getSelectedIndex() == 1) {
						for(int indexfind = 0 ; indexfind < modelOngoing.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(modelOngoing.getValueAt(indexfind , 0)))) {
								modelOngoing.removeRow(indexfind);
								indexfind =  modelOngoing.getRowCount();	
							}
						}
					}
					else if (tbdQueue.getSelectedIndex() == 0) {
						for(int indexfind = 0 ; indexfind < modelQueue.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(modelQueue.getValueAt(indexfind , 0)))) {
								modelQueue.removeRow(indexfind);
								indexfind =  modelQueue.getRowCount();	
							}
						}
					}
					break;
				}
			}
		 	if (tbdQueue.getSelectedIndex() == 1) {
		 	//to Remove the Technician in the model of Unavailable and move it to Available
			for (int index = 0 ; index < Technician.modelUnavailable.getRowCount(); index++) {
				String TechnicianToFind = String.valueOf(Technician.modelUnavailable.getValueAt(index, 1));
				if (TechnicianName == TechnicianToFind ) {
					 Object[] rowData = new
							  Object[Technician.modelAvailable.getColumnCount()]; 
							  rowData[0] = Technician.modelUnavailable.getValueAt(index, 0); 
							  rowData[1] = Technician.modelUnavailable.getValueAt(index, 1); 
							  rowData[2] = Technician.modelUnavailable.getValueAt(index, 2); 
							  Technician.modelAvailable.addRow(rowData);
							  Technician.modelUnavailable.removeRow(index);
							  DiagnosisInfo.UpdateCounter();
							  break;
				}
			}
			//to change the status of the Technician in the modelTechnicianInfo
			for (int index = 0 ; index < modelAllData.getRowCount(); index++) {
				String TechnicianToFind = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 1));
				if (TechnicianName == TechnicianToFind ) {
					Technician.modelTechnicianInfo.setValueAt("Available", index, 4);
					FindTechnicianforWaiting();
					break;
				}
			}	
		}
	  }
	}
	public static void RecordCounter() {
		JTable TosearchIn [] = {tblQueue,tblOngoing,tblAllData};
		String Record = String.valueOf(TosearchIn[tbdQueue.getSelectedIndex()].getRowCount());
		lblRecordCount.setText(Record);
	}
	public static void CancelIt() {
		ServiceCancel();
		JOptionPane.showMessageDialog(null, "The transaction has been successfully cancelled");
		txtSearch.setText("");
		SearchIn(cboFilter.getSelectedIndex());
		DiagnosisInfo.UpdateCounter();
		WaitingDisplay.UpdateContent();
		RecordCounter();
	}
}
