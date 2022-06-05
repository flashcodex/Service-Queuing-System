import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hire extends JFrame {

	private static JPanel contentPane;
	private static JLabel lblLogo;
	private static Image img;
	private JSeparator separator;
	private static JLabel lblWelcomeToOms;
	private static JLabel lblPleaseFillUp;
	private static JLabel lblTechnicianId;
	public static JLabel lblTechnicianNum;
	private static JLabel lblTechnicianName;
	public static JTextField txtTechName;
	private static JLabel lblRepairExpertise;
	public static JTextField txtTechContactNo;
	public static JComboBox<String> cboExpertise;
	public static String[] expertise = {"Computer Hardware", "Computer Software", "Cellphone Hardware", "Cellphone Software"};
	private static JLabel lblContactNumber;
	private JButton btnAdd;
	public static Technician frmtechnician;
	public static int TechIdNo = 1800782;
	private static JLabel lblRequired2;
	private static JLabel lblRequired1;
	

	public Hire() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setBounds(100, 100, 466, 294);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblLogo = new JLabel("");
		img = new ImageIcon(this.getClass().getResource("/Logoo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(0, 0, 100, 100);
		contentPane.add(lblLogo);
		
		separator = new JSeparator();
		separator.setBounds(99, 64, 362, 2);
		contentPane.add(separator);
		
		lblWelcomeToOms = new JLabel("Technician Application Form");
		lblWelcomeToOms.setFont(new Font("Century Gothic", Font.BOLD, 14));
		lblWelcomeToOms.setBounds(102, 34, 208, 32);
		contentPane.add(lblWelcomeToOms);
		
		lblPleaseFillUp = new JLabel("Please fill up the following credentials");
		lblPleaseFillUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseFillUp.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblPleaseFillUp.setBounds(126, 64, 237, 36);
		contentPane.add(lblPleaseFillUp);
		
		lblTechnicianId = new JLabel("Technician ID :");
		lblTechnicianId.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTechnicianId.setBounds(305, 0, 92, 36);
		contentPane.add(lblTechnicianId);
		
		lblTechnicianNum = new JLabel("");
		lblTechnicianNum.setEnabled(false);
		lblTechnicianNum.setText(String.valueOf(TechIdNo));
		lblTechnicianNum.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTechnicianNum.setBounds(395, 0, 66, 36);
		contentPane.add(lblTechnicianNum);
		
		lblTechnicianName = new JLabel("Technician Name :");
		lblTechnicianName.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblTechnicianName.setBounds(77, 105, 114, 32);
		contentPane.add(lblTechnicianName);
		
		txtTechName = new JTextField();
		txtTechName.setBounds(190, 112, 177, 20);
		contentPane.add(txtTechName);
		txtTechName.setColumns(10);
		
		lblRepairExpertise = new JLabel("Repair Expertise :");
		lblRepairExpertise.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblRepairExpertise.setBounds(77, 176, 114, 32);
		contentPane.add(lblRepairExpertise);
		
		cboExpertise = new JComboBox<String>();
		cboExpertise.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		Expertise();
		cboExpertise.setBounds(190, 183, 156, 20);
		contentPane.add(cboExpertise);
		
		lblContactNumber = new JLabel("Contact Number :");
		lblContactNumber.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		lblContactNumber.setBounds(77, 141, 114, 32);
		contentPane.add(lblContactNumber);
		
		txtTechContactNo = new JTextField();
		txtTechContactNo.setColumns(10);
		txtTechContactNo.setBounds(190, 145, 177, 20);
		contentPane.add(txtTechContactNo);
		
		btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtTechName.getText().contentEquals("") && txtTechContactNo.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Please fill up the required informations");
					lblRequired1.setVisible(true);
					lblRequired2.setVisible(true);
					txtTechName.requestFocus();
				}else {
				setVisible(false);
				TechnicianInfo();
				LoadDefault();
				MainAdmin.FindTechnicianforWaiting();
				DiagnosisInfo.UpdateCounter();
				WaitingDisplay.UpdateContent();
				}
			}
		});
		img = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnAdd.setIcon(new ImageIcon(img));
		btnAdd.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnAdd.setBounds(190, 219, 96, 36);
		contentPane.add(btnAdd);
		
		lblRequired1 = new JLabel("Required");
		lblRequired1.setForeground(Color.RED);
		lblRequired1.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRequired1.setBounds(369, 115, 74, 14);
		lblRequired1.setVisible(false);
		contentPane.add(lblRequired1);
		
		lblRequired2 = new JLabel("Required");
		lblRequired2.setForeground(Color.RED);
		lblRequired2.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblRequired2.setBounds(369, 151, 74, 14);
		lblRequired2.setVisible(false);
		contentPane.add(lblRequired2);
		DarkMode();
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("O M S | Repair Shop");
	}
	
	public static void TechnicianInfo() {
		Object[] techInfo = new Object[Technician.modelTechnicianInfo.getColumnCount()];
		techInfo[0] = lblTechnicianNum.getText();
		techInfo[1] = txtTechName.getText();
		techInfo[2] = cboExpertise.getSelectedItem();
		techInfo[3] = txtTechContactNo.getText();
		techInfo[4] = "Available";
		Technician.modelTechnicianInfo.addRow(techInfo);
		Technician.modelAvailable.addRow(techInfo);
		TechIdNo++;
		lblTechnicianNum.setText(String.valueOf(TechIdNo));
		lblRequired1.setVisible(false);
		lblRequired2.setVisible(false);
	}
	
	public static void Expertise() {
		for(String expertise: expertise) {
			cboExpertise.addItem(expertise);
		}
	}
	
	public void LoadDefault() {
		txtTechName.setText("");
		txtTechContactNo.setText("");
		cboExpertise.setSelectedIndex(0);
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
			lblWelcomeToOms.setForeground(Color.WHITE);
			lblTechnicianId.setForeground(Color.WHITE);
			lblTechnicianNum.setForeground(Color.WHITE);
			lblPleaseFillUp.setForeground(Color.WHITE);
			lblTechnicianName.setForeground(Color.WHITE);
			lblContactNumber.setForeground(Color.WHITE);
			lblRepairExpertise.setForeground(Color.WHITE);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
			lblWelcomeToOms.setForeground(Color.BLACK);
			lblTechnicianId.setForeground(Color.BLACK);
			lblTechnicianNum.setForeground(Color.BLACK);
			lblPleaseFillUp.setForeground(Color.BLACK);
			lblTechnicianName.setForeground(Color.BLACK);
			lblContactNumber.setForeground(Color.BLACK);
			lblRepairExpertise.setForeground(Color.BLACK);
		}
	}
}
