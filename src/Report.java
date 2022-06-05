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
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;

public class Report extends JFrame {
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	private static JPanel contentPane;
	private Image img;
	public static JTable tblAllData;
	public static MainAdmin frmAdmin;
	private JScrollPane spAllData;
	private JSeparator separator;
	private static JLabel lblLogo;
	private static JLabel lblReportDetails;
	private JComboBox<String> cboSearchColumn;
	private JTextField txtSearch;
	private static JLabel lblSearch;
	private static JButton btnPrint;
	private static JButton btnShowDetails;
	private static JLabel lblClock;
	private static JLabel lblSearchIn;
	public static ShowDetails frmShowDetails;
	private TableRowSorter<DefaultTableModel> sorter;
	public static JLabel lblRecord;
	public static JLabel lblRecordCount;
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
	
	public Report() {
		 frmShowDetails = new ShowDetails();
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setBounds(100, 100, 1207, 490);
		setTitle("O M S | Repair Shop");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setSize(new Dimension(1366, 500));
		
		lblLogo = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 0, 100, 105);
		contentPane.add(lblLogo);
		
		separator = new JSeparator();
		separator.setBounds(99, 69, 1261, 2);
		contentPane.add(separator);
		
		lblReportDetails = new JLabel("Report details");
		img = new ImageIcon(this.getClass().getResource("/Report.png")).getImage();
		lblReportDetails.setIcon(new ImageIcon(img));
		lblReportDetails.setHorizontalAlignment(SwingConstants.LEFT);
		lblReportDetails.setFont(new Font("Century Gothic", Font.BOLD, 23));
		lblReportDetails.setBounds(99, 34, 227, 37);
		contentPane.add(lblReportDetails);
		
		spAllData = new JScrollPane();
		spAllData.setBounds(10, 116, 1340, 286);
		contentPane.add(spAllData);
		
		tblAllData = new JTable(MainAdmin.modelAllData);
		
		spAllData.setViewportView(tblAllData);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				SearchIn(cboSearchColumn.getSelectedIndex());
			}
		});
		txtSearch.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		txtSearch.setBounds(1190, 90, 160, 22);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		cboSearchColumn = new JComboBox<String>();
		cboSearchColumn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtSearch.setText("");
				SearchIn(cboSearchColumn.getSelectedIndex());
			}
		});
		cboSearchColumn.setBounds(955, 89, 115, 22);
		contentPane.add(cboSearchColumn);
		
		for(String search : MainAdmin.columnAllData) {
			cboSearchColumn.addItem(search);
		}
		
		lblSearch = new JLabel("Search");
		img = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		lblSearch.setIcon(new ImageIcon(img));
		lblSearch.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSearch.setBounds(1126, 84, 67, 33);
		contentPane.add(lblSearch);
		
		btnShowDetails = new JButton("Show Details");
		btnShowDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnShowDetails.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnShowDetails.setBackground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnShowDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnShowDetails.setBackground(new Color(240, 240, 240));
			}
		});
		btnShowDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblAllData.getSelectedRow() < 0 ) {
					JOptionPane.showMessageDialog(null, "Please Select a row");
				}
				else {
					ShowDetails.ShowtheDetails();
					frmShowDetails.setVisible(true);
				}
			}
		});
		img = new ImageIcon(this.getClass().getResource("/showDetails.png")).getImage();
		btnShowDetails.setIcon(new ImageIcon(img));
		btnShowDetails.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnShowDetails.setBounds(620, 413, 143, 37);
		contentPane.add(btnShowDetails);
		
		btnPrint = new JButton("Print");
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MessageFormat header= new MessageFormat(" \n OMS Repair Shop " + "\n" + " Daily Report \n ");
				MessageFormat footer= new MessageFormat("This copy is for Company Used Only");
				
				try {
					tblAllData.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				}catch(Exception e1) {
					JOptionPane.showInternalConfirmDialog(null, "Unable to print");
					
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnPrint.setFont(new Font("Century Gothic", Font.BOLD, 12));
				btnPrint.setBackground(Color.MAGENTA);
				btnPrint.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				btnPrint.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnPrint.setBackground(new Color(240, 240, 240));
				btnPrint.setForeground(Color.BLACK);
			}
		});
		img = new ImageIcon(this.getClass().getResource("/print.png")).getImage();
		btnPrint.setIcon(new ImageIcon(img));
		btnPrint.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPrint.setBounds(1261, 413, 89, 47);
		contentPane.add(btnPrint);
		
		lblClock = new JLabel("");
		lblClock.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblClock.setBounds(1170, 51, 190, 14);
		contentPane.add(lblClock);
		
		lblSearchIn = new JLabel("Search In");
		img = new ImageIcon(this.getClass().getResource("/searchIn.png")).getImage();
		lblSearchIn.setIcon(new ImageIcon(img));
		lblSearchIn.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSearchIn.setFont(new Font("Century Gothic", Font.BOLD, 12));
		lblSearchIn.setBounds(851, 82, 100, 33);
		contentPane.add(lblSearchIn);
		
		lblRecord = new JLabel("Record :");
		lblRecord.setFont(new Font("Century Gothic", Font.BOLD, 11));
		lblRecord.setBounds(20, 407, 52, 21);
		contentPane.add(lblRecord);
		
		lblRecordCount = new JLabel("");
		lblRecordCount.setText(String.valueOf(tblAllData.getRowCount()));
		lblRecordCount.setFont(new Font("Century Gothic", Font.BOLD, 15));
		lblRecordCount.setBounds(68, 407, 52, 21);
		contentPane.add(lblRecordCount);
		clock();
		setLocationRelativeTo(null);
		setResizable(false);
		lblRecordCount.setText(String.valueOf(tblAllData.getRowCount()));
	}
	
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\LogooDark.png"));
			lblReportDetails.setForeground(Color.WHITE);
			lblSearch.setForeground(Color.WHITE);
			lblClock.setForeground(Color.WHITE);
			lblSearchIn.setForeground(Color.WHITE);
			tblAllData.setBackground(Color.DARK_GRAY);
			tblAllData.setForeground(Color.WHITE);
			lblRecord.setForeground(Color.WHITE);
			lblRecordCount.setForeground(Color.WHITE);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250 ,250));
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblReportDetails.setForeground(Color.BLACK);
			lblSearch.setForeground(Color.BLACK);
			lblClock.setForeground(Color.BLACK);
			lblSearchIn.setForeground(Color.BLACK);
			tblAllData.setBackground(Color.WHITE);
			tblAllData.setForeground(Color.BLACK);
			lblRecord.setForeground(Color.BLACK);
			lblRecordCount.setForeground(Color.BLACK);
		}
	}

	private void SearchIn(int ColumnIndex) {
				
		RowFilter<DefaultTableModel, Object> rowFilter = null ;
		rowFilter = RowFilter.regexFilter( "(?i)" + txtSearch.getText() + "", ColumnIndex);
		sorter = new TableRowSorter<DefaultTableModel>(MainAdmin.modelAllData);
		sorter.setRowFilter(rowFilter);
		tblAllData.setRowSorter(sorter);
		lblRecordCount.setText(String.valueOf(tblAllData.getRowCount()));
		
	}
}
