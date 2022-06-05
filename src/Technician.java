import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.Toolkit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Technician extends JFrame {
	private static JLabel lblLogo;
	private static Image img;
	public  static JFrame Technician;
	private static JPanel contentPane;
	private static JLabel lblEmployee;
	private static JSeparator separator;
	private static JLabel lblIcon;
	private static JLabel lblEmployeeSection;
	public static DefaultTableModel modelTechnicianInfo = new DefaultTableModel();
	private String[] columnInfo = {"TECHNICIAN ID", "TECHNICIAN NAME", "EXPERTISE", "CONTACT NO", "STATUS"};
	private String[] Technician1 = {"1800777","Glenmhar Aurelio","Computer Hardware","09219564201","Available"};
	private String[] Technician2 = {"1800778","Moises Adolfo","Computer Software","09759376009","Available"};
	private String[] Technician3 = {"1800779","John Kevin Junsay","Cellphone Hardware","09952776753","Available"};
	private String[] Technician4 = {"1800780","Joshwell Miko Decena","Cellphone Software","09195730841","Available"};
	private String[] Technician5 = {"1800781","Melbert Alegre","Cellphone Hardware","09195733242","Available"};
	public static DefaultTableModel modelUnavailable = new DefaultTableModel();
	public static DefaultTableModel modelAvailable = new DefaultTableModel();
	private String[] columnAvailableorNot = {"TECHNICIAN ID", "TECHNICIAN NAME", "EXPERTISE"};
	private static JLabel lblClock;
	public static Hire frmHire;
	public static MainAdmin frmAdminForm;
	private static JTabbedPane tabbedPane;
	private static JPanel pnlAvailable;
	private static JTable tblAvailable;
	private static JScrollPane spAvailable;
	private JButton btnBack;
	private static JPanel pnlUnavailable;
	private static JPanel pnlTechnicianInfo;
	private static JTable tblUnavailable;
	private static JScrollPane spUnavailable;
	public static JTable tblTechnicianInfo;
	private static JScrollPane spTechnicianInfo;
	private JButton btnFire;
	private JButton btnHire;
	private JButton btnUpdate;
	public static Update frmUpdate;
	private static JLabel lblRecord;
	private static JLabel lblRecordCount;
	public static int Record = 0;
	private JTextField txtSearch;
	private JComboBox<String> cboSearchIn;
	private static JLabel lblSearch;
	private static JLabel lblSearchIn;
	private TableRowSorter<DefaultTableModel> sorter;
	
	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
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
	
	public Technician() {
		frmAdminForm = new MainAdmin();
		frmHire = new Hire();
		frmUpdate = new Update();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setBounds(100, 100, 720, 549);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 0, 100, 100);
		contentPane.add(lblLogo);
		
		separator = new JSeparator();
		separator.setBounds(99, 67, 615, 2);
		contentPane.add(separator);
		
		lblEmployee = new JLabel("| Employee");
		lblEmployee.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblEmployee.setBounds(631, 43, 74, 26);
		contentPane.add(lblEmployee);
		
		lblIcon = new JLabel(" ");
		lblIcon.setHorizontalAlignment(SwingConstants.RIGHT);
		img = new ImageIcon(this.getClass().getResource("/customer.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(594, 29, 39, 40);
		contentPane.add(lblIcon);
		
		lblEmployeeSection = new JLabel("Employee Section");
		lblEmployeeSection.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblEmployeeSection.setBounds(100, 37, 171, 33);
		contentPane.add(lblEmployeeSection);
		
		
		lblClock = new JLabel(" ");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblClock.setBounds(10, 496, 196, 15);
		contentPane.add(lblClock);
		
		tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		tabbedPane.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				//to remove the items of cboFilter
				if (cboSearchIn.getItemCount() != 0){
					cboSearchIn.removeAllItems();
				}
				LoadItems();
				txtSearch.setText("");
				SearchIn(cboSearchIn.getSelectedIndex());
				RecordCounter();
			}
		});
		tabbedPane.setBackground(new Color(0, 204, 204));
		tabbedPane.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		tabbedPane.setBounds(10, 118, 694, 350);
		contentPane.add(tabbedPane);
		
		pnlAvailable = new JPanel();
		tabbedPane.addTab("Available", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\available.png"), pnlAvailable, null);
		pnlAvailable.setLayout(null);
		
		spAvailable = new JScrollPane();
		spAvailable.setBounds(10, 11, 522, 323);
		pnlAvailable.add(spAvailable);
		
		tblAvailable = new JTable(modelAvailable);
		tblAvailable.setDefaultEditor(Object.class, null);
		spAvailable.setViewportView(tblAvailable);
		modelAvailable.setColumnIdentifiers(columnAvailableorNot);
		modelAvailable.addRow(Technician1);
		modelAvailable.addRow(Technician2);
		modelAvailable.addRow(Technician3);
		modelAvailable.addRow(Technician4);
		modelAvailable.addRow(Technician5);
		
		pnlUnavailable = new JPanel();
		tabbedPane.addTab("Serving", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\serving.png"), pnlUnavailable, null);
		pnlUnavailable.setLayout(null);
		
		spUnavailable = new JScrollPane();
		spUnavailable.setBounds(10, 11, 522, 323);
		pnlUnavailable.add(spUnavailable);
		
		tblUnavailable = new JTable(modelUnavailable);
		tblUnavailable.setDefaultEditor(Object.class, null);
		modelUnavailable.setColumnIdentifiers(columnAvailableorNot);
		spUnavailable.setViewportView(tblUnavailable);
		
		pnlTechnicianInfo = new JPanel();
		tabbedPane.addTab("Technician Info", new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\techinfo.png"), pnlTechnicianInfo, null);
		pnlTechnicianInfo.setLayout(null);
		
		spTechnicianInfo = new JScrollPane();
		spTechnicianInfo.setBounds(10, 11, 522, 280);
		pnlTechnicianInfo.add(spTechnicianInfo);
		
		tblTechnicianInfo = new JTable(modelTechnicianInfo);
		tblTechnicianInfo.setDefaultEditor(Object.class, null);
		spTechnicianInfo.setViewportView(tblTechnicianInfo);
		modelTechnicianInfo.setColumnIdentifiers(columnInfo);
		modelTechnicianInfo.addRow(Technician1);
		modelTechnicianInfo.addRow(Technician2);
		modelTechnicianInfo.addRow(Technician3);
		modelTechnicianInfo.addRow(Technician4);
		modelTechnicianInfo.addRow(Technician5);
		
		btnHire = new JButton("HIRE");
		btnHire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnHire.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnHire.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnHire.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnHire.setBackground(new Color(240, 240, 240));
			}
		});
		btnHire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHire.setVisible(true);
				RecordCounter();
			}
		});
		
		img = new ImageIcon(this.getClass().getResource("/hire.png")).getImage();
		btnHire.setIcon(new ImageIcon(img));
		btnHire.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnHire.setBounds(118, 294, 95, 40);
		pnlTechnicianInfo.add(btnHire);
		
		btnFire = new JButton("FIRE");
		btnFire.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFire.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnFire.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFire.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnFire.setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//If there is no selected row
				if(tblTechnicianInfo.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please select a technician to fire");
				}
				//Execution of firing technician
				else if(tblTechnicianInfo.getSelectedRow() >= 0) {
					int dialog = JOptionPane.showConfirmDialog(null, "Are you sure?", "WARNING",JOptionPane.YES_NO_OPTION);
					if(dialog == JOptionPane.YES_OPTION) {
						//get the Id of tecnician
						String TechId = String.valueOf(tblTechnicianInfo.getValueAt(tblTechnicianInfo.getSelectedRow(), 0)) ;
						 	//looping for Find the Match technician
							for (int outerindex = 0 ; outerindex < modelUnavailable.getRowCount() ; outerindex++ ) {
						
									String Toverifyy = String.valueOf(modelUnavailable.getValueAt(outerindex, 0));
										
									if(TechId == Toverifyy) {
											JOptionPane.showMessageDialog(null, "Sorry the technician is currently serving ");
											outerindex = modelUnavailable.getRowCount();
											if(TechId != Toverifyy) {
												FireTechincian();
											}
										}
							}	
					

					}
				}
				RecordCounter();
			}
		});
		img = new ImageIcon(this.getClass().getResource("/fire.png")).getImage();
		btnFire.setIcon(new ImageIcon(img));
		btnFire.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnFire.setBounds(350, 294, 95, 40);
		pnlTechnicianInfo.add(btnFire);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnUpdate.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnUpdate.setBackground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnUpdate.setBackground(new Color(240, 240, 240));
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if there is no row has been selected
				if(tblTechnicianInfo.getSelectedRow() < 0) {
					JOptionPane.showMessageDialog(null, "Please Select a row!");
				}//Execution of updating info
				else if(tblTechnicianInfo.getSelectedRow() >= 0) {
				Update.MoveDataToUpdate();
				frmUpdate.setVisible(true);
				}
			}
		});
		img = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnUpdate.setIcon(new ImageIcon(img));
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnUpdate.setBounds(223, 294, 117, 40);
		pnlTechnicianInfo.add(btnUpdate);
		
		btnBack = new JButton("BACK");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBack.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnBack.setBackground(new Color(198, 226, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnBack.setBackground(new Color(240, 240, 240));
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainAdmin.ShowMain();
				setVisible(false);
			}
		});
		img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnBack.setIcon(new ImageIcon(img));
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBack.setBounds(594, 471, 105, 40);
		contentPane.add(btnBack);
		
		lblRecord = new JLabel("Record :");
		lblRecord.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblRecord.setBounds(156, 471, 52, 21);
		contentPane.add(lblRecord);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setText(String.valueOf(Record));
		lblRecordCount.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblRecordCount.setBounds(204, 471, 39, 21);
		contentPane.add(lblRecordCount);
		
		lblSearchIn = new JLabel("Search In");
		lblSearchIn.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\searchIn.png"));
		lblSearchIn.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSearchIn.setBounds(204, 80, 114, 35);
		contentPane.add(lblSearchIn);
		
		cboSearchIn = new JComboBox<String>();
		cboSearchIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtSearch.setText("");
				SearchIn(cboSearchIn.getSelectedIndex());
				RecordCounter();
			}
		});
		cboSearchIn.setBounds(305, 87, 141, 21);
		contentPane.add(cboSearchIn);
		
		lblSearch = new JLabel("Search");
		lblSearch.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\search.png"));
		lblSearch.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblSearch.setBounds(490, 80, 74, 31);
		contentPane.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				SearchIn(cboSearchIn.getSelectedIndex());
				RecordCounter();
			}
		});
		txtSearch.setColumns(10);
		txtSearch.setBounds(561, 87, 132, 20);
		contentPane.add(txtSearch);
		clock();
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("O M S | Repair Shop");
		LoadItems();
		RecordCounter();
		
	}
	
	
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblEmployeeSection.setForeground(Color.WHITE);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
			lblEmployee.setForeground(Color.WHITE);
			lblRecord.setForeground(Color.WHITE);
			lblRecordCount.setForeground(Color.WHITE);
			lblClock.setForeground(Color.WHITE);
			tblAvailable.setBackground(Color.DARK_GRAY);
			tblAvailable.setForeground(Color.WHITE);
			tblUnavailable.setBackground(Color.DARK_GRAY);
			tblUnavailable.setForeground(Color.WHITE);
			tblTechnicianInfo.setBackground(Color.DARK_GRAY);
			tblTechnicianInfo.setForeground(Color.WHITE);
			pnlAvailable.setBackground(Color.DARK_GRAY);
			pnlUnavailable.setBackground(Color.DARK_GRAY);
			pnlTechnicianInfo.setBackground(Color.DARK_GRAY);
			lblSearchIn.setForeground(Color.white);
			lblSearch.setForeground(Color.WHITE);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblEmployeeSection.setForeground(Color.BLACK);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblEmployee.setForeground(Color.BLACK);
			lblRecord.setForeground(Color.BLACK);
			lblRecordCount.setForeground(Color.BLACK);
			lblClock.setForeground(Color.BLACK);
			tblAvailable.setBackground(Color.WHITE);
			tblAvailable.setForeground(Color.BLACK);
			tblUnavailable.setBackground(Color.WHITE);
			tblUnavailable.setForeground(Color.BLACK);
			tblTechnicianInfo.setBackground(Color.WHITE);
			tblTechnicianInfo.setForeground(Color.BLACK);
			pnlAvailable.setBackground(Color.WHITE);
			pnlUnavailable.setBackground(Color.WHITE);
			pnlTechnicianInfo.setBackground(Color.WHITE);
			lblSearchIn.setForeground(Color.BLACK);
			lblSearch.setForeground(Color.BLACK);
		}
	}
	private void SearchIn(int ColumnIndex) {
		JTable TosearchIn [] = {tblAvailable,tblUnavailable,tblTechnicianInfo};
		DefaultTableModel ToSearch [] = {modelAvailable,modelUnavailable,modelTechnicianInfo};
			
		RowFilter<DefaultTableModel, Object> rowFilter = null ;
		rowFilter = RowFilter.regexFilter( "(?i)" + txtSearch.getText(), ColumnIndex);
		sorter = new TableRowSorter<DefaultTableModel>(ToSearch[tabbedPane.getSelectedIndex()]);
		sorter.setRowFilter(rowFilter);
		TosearchIn[tabbedPane.getSelectedIndex()].setRowSorter(sorter);
		
	}
	private void LoadItems() {
		
		
		if(tabbedPane.getSelectedIndex() == 0) {
			
			for(String Searchin : columnAvailableorNot ) {
				cboSearchIn.addItem(Searchin);
			}
		}
		
		else if (tabbedPane.getSelectedIndex() == 1) {
			for(String Searchin : columnAvailableorNot ) {
				cboSearchIn.addItem(Searchin);
			}
		}
		
		else if (tabbedPane.getSelectedIndex() == 2) {
			for(String Searchin : columnInfo ) {
				cboSearchIn.addItem(Searchin);
			}
		}
	}
	public static void RecordCounter() {
		JTable TosearchIn [] = {tblAvailable,tblUnavailable,tblTechnicianInfo};
		String Record = String.valueOf(TosearchIn[tabbedPane.getSelectedIndex()].getRowCount());
		lblRecordCount.setText(Record);
	}
	public static void FireTechincian() {
		
		String TechId = String.valueOf(tblTechnicianInfo.getValueAt(tblTechnicianInfo.getSelectedRow(), 0)) ;
		
		if(modelAvailable.getRowCount() != 0) {
			for (int index = 0 ; index < modelAvailable.getRowCount() ; index++){
				String Toverify = String.valueOf(modelAvailable.getValueAt(index, 0));
					if(TechId == Toverify) {
					modelAvailable.removeRow(index);
					break;
					}
				}
			}
			
			if(modelUnavailable.getRowCount() != 0) {
				for (int index = 0 ; index < modelUnavailable.getRowCount() ; index++)
				{	
					String Toverify = String.valueOf(modelUnavailable.getValueAt(index, 0));
					if(TechId == Toverify) {
						modelUnavailable.removeRow(index);
						break;
					}
				}
			}
			for (int index = 0 ; index < modelTechnicianInfo.getRowCount() ; index++){
				String Toverify = String.valueOf(modelTechnicianInfo.getValueAt(index, 0));
				if(TechId == Toverify) {
					modelTechnicianInfo.removeRow(index);	
					JOptionPane.showMessageDialog(null, "Selected technician has been fired!");
					break;
				}
				
				
			}
	}
}