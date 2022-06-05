import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	public static JTextField txtId;
	public static JTextField txtName;
	public static JTextField txtContactNum;
	private JLabel lblUpdate;
	private JLabel lblTechnicianId;
	private JLabel lblTechnicianName;
	public static JComboBox<String> cboExpertise;
	private JLabel lblContactNo;
	private JButton btnUpdate;
	private String[] expertise = {"Computer Hardware", "Computer Software", "Cellphone Hardware", "Cellphone Software"};

	public Update() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setTitle("O M S | Repair Shop");
		setBounds(100, 100, 438, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		lblUpdate = new JLabel("UPDATE");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Century Gothic", Font.BOLD, 25));
		lblUpdate.setBounds(0, 37, 434, 23);
		contentPane.add(lblUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 47, 166, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(268, 47, 166, 2);
		contentPane.add(separator_1);
		
		cboExpertise = new JComboBox<String>();
		cboExpertise.setBounds(194, 186, 181, 22);
		contentPane.add(cboExpertise);
		for(String Experties : expertise) {
			cboExpertise.addItem(Experties);
		}
		
		lblTechnicianId = new JLabel("Technician Id :");
		lblTechnicianId.setHorizontalAlignment(SwingConstants.CENTER);
		lblTechnicianId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTechnicianId.setBounds(110, 71, 112, 23);
		contentPane.add(lblTechnicianId);
		
		txtId = new JTextField();
		txtId.setBounds(219, 74, 76, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		lblTechnicianName = new JLabel("Technician Name :");
		lblTechnicianName.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblTechnicianName.setBounds(60, 122, 142, 23);
		contentPane.add(lblTechnicianName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(194, 125, 181, 20);
		contentPane.add(txtName);
		
		JLabel lblExpertise = new JLabel("Repair Expertise :");
		lblExpertise.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpertise.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblExpertise.setBounds(58, 179, 128, 32);
		contentPane.add(lblExpertise);
		
		lblContactNo = new JLabel("Contact Number :");
		lblContactNo.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblContactNo.setBounds(60, 153, 128, 23);
		contentPane.add(lblContactNo);
		
		txtContactNum = new JTextField();
		txtContactNum.setColumns(10);
		txtContactNum.setBounds(194, 156, 181, 20);
		contentPane.add(txtContactNum);
		
		btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerifyUpdate();
				setVisible(false);
			}
		});
		btnUpdate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnUpdate.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\update.png"));
		btnUpdate.setBounds(157, 232, 125, 37);
		contentPane.add(btnUpdate);
		txtId.setEditable(false);
		
	}
	
	public static void MoveDataToUpdate() {
		
		txtId.setText(String.valueOf(Technician.tblTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 0)));
		txtName.setText(String.valueOf(Technician.tblTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 1)));
		for(int index = 0 ; index < Hire.cboExpertise.getItemCount() ; index++) {
			String Experties = String.valueOf(Technician.tblTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 2));
			if(Experties.contentEquals(Hire.cboExpertise.getItemAt(index))) {
				cboExpertise.setSelectedIndex(index);
				break;	
			}
		}
			txtContactNum.setText(String.valueOf(Technician.modelTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 3)));
	}
	
	public static void UpdateData() {
		
		String TechId = String.valueOf(Technician.tblTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 0)) ;
		
		for (int index = 0 ; index < Technician.modelTechnicianInfo.getRowCount() ; index++){
			String Toverify = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 0));
			if(TechId == Toverify) {
				Technician.modelTechnicianInfo.setValueAt(txtName.getText(), index , 1);
				Technician.modelTechnicianInfo.setValueAt(cboExpertise.getItemAt(cboExpertise.getSelectedIndex()), index , 2);
				Technician.modelTechnicianInfo.setValueAt(txtContactNum.getText(), index , 3);
				index = Technician.modelTechnicianInfo.getRowCount();
			}
		}
		
	
		
		for(int index = 0 ; index < Technician.modelAvailable.getRowCount() ; index++) {
			String Toverify = String.valueOf(Technician.modelTechnicianInfo.getValueAt(index, 0));
			if(TechId == Toverify) {
				Technician.modelAvailable.setValueAt(txtName.getText(), index , 1);
				Technician.modelAvailable.setValueAt(cboExpertise.getItemAt(cboExpertise.getSelectedIndex()), index , 2);

				JOptionPane.showMessageDialog(null, "Technician Information Updated");
				index = Technician.modelAvailable.getRowCount();
			}
		}
		
		
	}
	
	public static void VerifyUpdate() {
		String TechId = String.valueOf(Technician.tblTechnicianInfo.getValueAt(Technician.tblTechnicianInfo.getSelectedRow(), 0)) ;
	 	//looping for Find the Match technician
		if (Technician.modelUnavailable.getRowCount() <=0) {
			UpdateData();
		}
		for (int outerindex = 0 ; outerindex < Technician.modelUnavailable.getRowCount() ; outerindex++ ) {
	
				String Toverifyy = String.valueOf(Technician.modelUnavailable.getValueAt(outerindex, 0));
					
				if(TechId == Toverifyy) {
						JOptionPane.showMessageDialog(null, "Sorry the technician is currently serving ");
						outerindex = Technician.modelUnavailable.getRowCount();
					}
				if(TechId != Toverifyy) {
					UpdateData();
				}
		}
	}
}
