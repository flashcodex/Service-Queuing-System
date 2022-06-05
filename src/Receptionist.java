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

public class Receptionist extends JFrame{
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private static JPanel contentPane;
	private static Image img;
	private static JLabel lblLogo;
	public static JLabel lblAdministrator;
	private JSeparator separator;
	private static JLabel lblQueue;
	private static JLabel lblIcon;
	private static JPanel pnlQueue;
	private static JTabbedPane tbdQueue;
	private static JPanel pnlOngoing;
	private static JPanel pnlAllData;
	private static JTable tblQueue;
	private JScrollPane spQueue;
	private static JTable tblOngoing;
	private JScrollPane spOngoing;
	public static JTable tblAllData;
	private JScrollPane spAllData;
	public static JLabel lblClock;
	private static JPanel pnlDropDown;
	private static JButton btnLogout;
	private static JLabel lblFilter;
	private static JComboBox<String> cboFilter;
	private static JLabel lblSearch;
	private static JTextField txtSearch;
	private JButton btnFinish;
	public static int Served = 0;
	private static int Record = 0;
	private static TableRowSorter<DefaultTableModel> sorter;
	private JButton btnCancel;
	public static LogInForm frmLogin;
	public static Technician frmtechnician;
	public static Report frmReport;
	public static MessageBox frmMessageBox;
	public static MessageBoxGuest frmMessageBoxGuest;
	public static DiagnosisInfo frmDiagnosisInfo;
	public static WaitingDisplay frmWaitingDisplay;
	public static Customer frmCustomer;
	public static CancelReason frmCancelReason;
	private static JLabel lblRecordCount;
	private static JLabel lblRecord;
	private JButton btnMessage;
	private JButton btnAdd;
	public static String Reason = "";

	
	
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
	 * Create the application.
	 */
	public Receptionist() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setLocationRelativeTo(null);
		setTitle("O M S | Repair Shop");
		setBounds(100, 100, 905, 546);
		setSize(new Dimension(1366, 709));
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
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
		pnlDropDown.setBounds(1216, 67, 114, 56);
		contentPane.add(pnlDropDown);
		pnlDropDown.setLayout(null);
		pnlDropDown.setVisible(false);
		
		btnLogout = new JButton("Log-out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				frmLogin = new LogInForm();
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
		btnLogout.setBounds(10, 11, 94, 36);
		pnlDropDown.add(btnLogout);
		
		
		lblAdministrator = new JLabel(" | RECEPTIONIST");
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
		MainAdmin.modelQueue.setColumnIdentifiers(MainAdmin.columnQueue);
		
		pnlQueue = new JPanel();
		tbdQueue.addTab("Today's Queue", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\todayQueue.png"), pnlQueue, null);
		pnlQueue.setLayout(null);
		
		spQueue = new JScrollPane();
		spQueue.setBounds(0, 0, 1014, 512);
		pnlQueue.add(spQueue);
		
		tblQueue = new JTable(MainAdmin.modelQueue);
		tblQueue.setBackground(Color.WHITE);
		tblQueue.setDefaultEditor(Object.class, null);
		
		spQueue.setViewportView(tblQueue);
		
		pnlOngoing = new JPanel();
		tbdQueue.addTab("Ongoing", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\ongoing.png"), pnlOngoing, null);
		pnlOngoing.setLayout(null);
		
		spOngoing = new JScrollPane();
		spOngoing.setBounds(0, 0, 1014, 512);
		pnlOngoing.add(spOngoing);
		
		tblOngoing = new JTable(MainAdmin.modelOngoing);
		tblOngoing.setDefaultEditor(Object.class, null);
		MainAdmin.modelOngoing.setColumnIdentifiers(MainAdmin.columnOngoing);
		spOngoing.setViewportView(tblOngoing);
		
		pnlAllData = new JPanel();
		tbdQueue.addTab("All Data", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\alldata.png"), pnlAllData, null);
		pnlAllData.setLayout(null);
		
		spAllData = new JScrollPane();
		spAllData.setBounds(0, 0, 1014, 512);
		pnlAllData.add(spAllData);
		
		tblAllData = new JTable(MainAdmin.modelAllData);
		tblAllData.setBackground(Color.WHITE);
		tblAllData.setDefaultEditor(Object.class, null);
		MainAdmin.modelAllData.setColumnIdentifiers(MainAdmin.columnAllData);
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
		for(String Searchin : MainAdmin.columnQueue ) {
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
				ServiceFinish();
				
				txtSearch.setText("");
				SearchIn(cboFilter.getSelectedIndex());
				MainAdmin.FindTechnicianforWaiting();
				Served++;
				DiagnosisInfo.UpdateCounter();
				WaitingDisplay.UpdateContent();
				RecordCounter();
			}
		});
		btnFinish.setBounds(1216, 236, 114, 47);
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
				if (table[tbdQueue.getSelectedIndex()].getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please Select a Row");
				}
				else if (table[tbdQueue.getSelectedIndex()].getSelectedRow() >= 0) {
					// get the Name of the Technician on the Selected Row
					frmCancelReason = new CancelReason();
					frmCancelReason.setVisible(true);
					CancelReason.User = 2 ;
				}
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\cancel.png"));
		btnCancel.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnCancel.setBounds(1216, 294, 114, 47);
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
				frmMessageBoxGuest.setVisible(true);

			}
		});
		btnMessage.setBounds(1216, 352, 114, 47);
		contentPane.add(btnMessage);
		setResizable(false);
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
		
		btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAdd.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnAdd.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnAdd.setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (frmCustomer.isShowing() == false) {
					frmCustomer = new Customer();
				}
				
				frmCustomer.setVisible(true);
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\add.png"));
		btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAdd.setBounds(1216, 181, 114, 47);
		contentPane.add(btnAdd);
		RecordCounter();
		frmCustomer = new Customer();
		frmMessageBoxGuest = new MessageBoxGuest();
		
		
	}
	
	
	
	public static void DarkMode(boolean Status) {
		
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblAdministrator.setForeground(Color.WHITE);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
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
			lblClock.setForeground(Color.WHITE);
			pnlDropDown.setBackground(Color.DARK_GRAY);
			btnLogout.setBackground(Color.DARK_GRAY);
			lblFilter.setForeground(Color.white);
			lblSearch.setForeground(Color.white);
			lblRecord.setForeground(Color.WHITE);
			lblRecordCount.setForeground(Color.WHITE);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblAdministrator.setForeground(Color.BLACK);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			tbdQueue.setBackground(new Color(0, 204, 204));
			tblQueue.setBackground(Color.WHITE);
			tblQueue.setForeground(Color.BLACK);
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
			pnlDropDown.setBackground(new Color(0, 191, 255));
			btnLogout.setBackground(new Color(0, 191, 255));
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
		
	}
	public static void ServiceFinish() {
		
		//condition for verifying if there is a selected row
		if (tblOngoing.getSelectedRow() < 0) {
			JOptionPane.showMessageDialog(null, "Please Select a Row");
		}
		//execute if there is a selected row
		else if (tblOngoing.getSelectedRow() >= 0) {
			//getting the Name of the Technician
			String TechnicianName = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 2));
				
				for (int index = 0 ; index < MainAdmin.modelAllData.getRowCount(); index++) {
					// getting the Customer Id in Selected Row in tlbOngoing
				 	String CustomerId = String.valueOf(tblOngoing.getValueAt(tblOngoing.getSelectedRow(), 0));
				 	// getting the value of customerId in each row through looping
					String TechnicianToFind = String.valueOf(MainAdmin.modelAllData.getValueAt(index, 0));	
					//condition to find the row in the modelAllData that match with the Customer Id 
					//execute if the condition if true
					if (CustomerId.equals(TechnicianToFind) ) {
						//change the value of Transaction Status to Finished
						MainAdmin.modelAllData.setValueAt("Finished", index, 10);
						//Set the value of Transaction Finished Time and Date
						MainAdmin.modelAllData.setValueAt(lblClock.getText(), index, 12);
						MainAdmin.modelAllData.setValueAt(lblAdministrator.getText(), index, 14);
						JOptionPane.showMessageDialog(null, "Sucessfuly Finish the Transaction");
						//Looping in finding the row in modelOngoing to remove
						for(int indexfind = 0 ; indexfind < MainAdmin.modelOngoing.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(MainAdmin.modelOngoing.getValueAt(indexfind , 0)))) {
								WaitingDisplay.lblNotification.setText("Customer " +String.valueOf(MainAdmin.modelOngoing.getValueAt(indexfind , 0)) + " Your Device is Now Repaired");
								MainAdmin.modelOngoing.removeRow(indexfind);
								indexfind =  MainAdmin.modelOngoing.getRowCount();	
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
				
				//to change the Status of the Technician in the modelTechnicianInfo
				for (int index = 0 ; index < MainAdmin.modelAllData.getRowCount(); index++) {
				String TechnicianToFind = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 1));
					if (TechnicianName == TechnicianToFind ) {
						Technician.modelTechnicianInfo.setValueAt("Available", index, 4);
						break;
					}
				}	
		}	
	}
	
	private void LoadItems() {
			
		
			if(tbdQueue.getSelectedIndex() == 0) {
				
				for(String Searchin : MainAdmin.columnQueue ) {
					cboFilter.addItem(Searchin);
				}
			}
			
			else if (tbdQueue.getSelectedIndex() == 1) {
				for(String Searchin : MainAdmin.columnOngoing ) {
					cboFilter.addItem(Searchin);
				}
			}
			
			else if (tbdQueue.getSelectedIndex() == 2) {
				for(String Searchin : MainAdmin.columnAllData ) {
					cboFilter.addItem(Searchin);
				}
			}
	}
	private static void SearchIn(int ColumnIndex) {
		JTable TosearchIn [] = {tblQueue,tblOngoing,tblAllData};
		DefaultTableModel ToSearch [] = {MainAdmin.modelQueue, MainAdmin.modelOngoing, MainAdmin.modelAllData};
			
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
			
		 for (int index = 0 ; index < MainAdmin.modelAllData.getRowCount(); index++) {
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
				String TechnicianToFind = String.valueOf(MainAdmin.modelAllData.getValueAt(index, 0));
				if (CustomerId.equals(TechnicianToFind) ) {
					MainAdmin.modelAllData.setValueAt("Canceled", index, 10);
					MainAdmin.modelAllData.setValueAt(lblClock.getText(), index, 12);
					MainAdmin.modelAllData.setValueAt(Reason, index, 13);
					MainAdmin.modelAllData.setValueAt(lblAdministrator.getText(), index, 14);
					if (tbdQueue.getSelectedIndex() == 1) {
						for(int indexfind = 0 ; indexfind < MainAdmin.modelOngoing.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(MainAdmin.modelOngoing.getValueAt(indexfind , 0)))) {
								MainAdmin.modelOngoing.removeRow(indexfind);
								indexfind =  MainAdmin.modelOngoing.getRowCount();	
							}
						}
					}
					else if (tbdQueue.getSelectedIndex() == 0) {
						for(int indexfind = 0 ; indexfind < MainAdmin.modelQueue.getRowCount() ; indexfind ++) {
							if(CustomerId.contentEquals(String.valueOf(MainAdmin.modelQueue.getValueAt(indexfind , 0)))) {
								MainAdmin.modelQueue.removeRow(indexfind);
								indexfind =  MainAdmin.modelQueue.getRowCount();	
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
			for (int index = 0 ; index < MainAdmin.modelAllData.getRowCount(); index++) {
				String TechnicianToFind = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 1));
				if (TechnicianName == TechnicianToFind ) {
					Technician.modelTechnicianInfo.setValueAt("Available", index, 4);
					MainAdmin.FindTechnicianforWaiting();
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
		JOptionPane.showMessageDialog(null, "The transaction has been successfully canceled");
		txtSearch.setText("");
		SearchIn(cboFilter.getSelectedIndex());
		DiagnosisInfo.UpdateCounter();
		WaitingDisplay.UpdateContent();
		RecordCounter();
	}
}
