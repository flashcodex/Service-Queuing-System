import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

public class ShowDetails extends JFrame {

	private JPanel contentPane;
	private JLabel lblDetails;
	private JButton btnBack;
	private static JTextArea txtAreaDetails;
	private JScrollPane scrollPane;
	private JLabel lblSummary;
	private JLabel lblLogo;


	public ShowDetails() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\repair.png"));
		setBounds(100, 100, 620, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\Logoo.png"));
		lblLogo.setBounds(0, 0, 99, 112);
		contentPane.add(lblLogo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(97, 61, 517, 2);
		contentPane.add(separator);
		
		lblSummary = new JLabel("Summary");
		lblSummary.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblSummary.setBounds(107, 32, 130, 31);
		contentPane.add(lblSummary);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 111, 419, 328);
		contentPane.add(scrollPane);
		
		txtAreaDetails = new JTextArea();
		txtAreaDetails.setFont(new Font("Mongolian Baiti", Font.BOLD, 16));
		scrollPane.setViewportView(txtAreaDetails);
		
		btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\back.png"));
		btnBack.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnBack.setBounds(532, 397, 72, 43);
		contentPane.add(btnBack);
		
		lblDetails = new JLabel("Details");
		lblDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblDetails.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblDetails.setBounds(103, 69, 419, 43);
		contentPane.add(lblDetails);
		setTitle("O M S | Repair Shop");
		setLocationRelativeTo(null);
		setResizable(false);
		txtAreaDetails.setEditable(false);
		
		JButton btnPrint = new JButton("");
		btnPrint.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\print.png"));
		btnPrint.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					//txtAreaDetails.print(JTextArea.PrintMode.FIT_WIDTH, header, footer);
					boolean complete= txtAreaDetails.print();
					
					if(complete) {
						JOptionPane.showMessageDialog(null,"Done Printing","Information",JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Printing!!!", "Printer", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(PrinterException e1) {
					JOptionPane.showMessageDialog(null,e1);
					
				}
			}
		});
		btnPrint.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnPrint.setBounds(532, 348, 72, 43);
		contentPane.add(btnPrint);
		
	}
	public static void ShowtheDetails() {
		
		String Details = "DETAILS OF TRANSACTION \n \n"  ;
		for(int index = 0 ; index < MainAdmin.columnAllData.length; index++) {
			Details += String.valueOf(MainAdmin.columnAllData[index] + " : " + Report.tblAllData.getValueAt(Report.tblAllData.getSelectedRow(), index)) + "\n";
		}
		txtAreaDetails.setText(Details);
	}
}
