import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CancelReason extends JFrame {

	private JPanel contentPane;
	private Image img;
	private JLabel lblIcon;
	private JPanel pnlReason;
	private JTextArea txtReason;
	private JLabel lblAreYouSure;
	private JButton btnYes;
	private JLabel lblPleaseIndicate;
	private JButton btnNo;
	public static int User = 0 ;
	private static MainAdmin frmMain;

	public CancelReason() {
		setTitle("CANCELLATION");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\cancel.png"));
		setBounds(100, 100, 409, 269);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblIcon = new JLabel("");
		lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
		img = new ImageIcon(this.getClass().getResource("/warning.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setBounds(10, 23, 55, 45);
		contentPane.add(lblIcon);
		
		pnlReason = new JPanel();
		pnlReason.setBackground(new Color(169, 169, 169));
		pnlReason.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlReason.setBounds(62, 96, 291, 88);
		contentPane.add(pnlReason);
		pnlReason.setLayout(null);
		
		txtReason = new JTextArea();
		txtReason.setBounds(10, 11, 269, 68);
		pnlReason.add(txtReason);
		
		lblAreYouSure = new JLabel("Are you sure you want to cancel the transaction?");
		lblAreYouSure.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblAreYouSure.setBounds(62, 23, 336, 45);
		contentPane.add(lblAreYouSure);
		
		btnYes = new JButton("YES");
		btnYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnYes.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnYes.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnYes.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnYes.setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(txtReason.getText().contentEquals("")) {
					JOptionPane.showMessageDialog(null, "Please indicate your Reason to cancel");
				}else {
					if(User == 1) {
						MainAdmin.Reason = txtReason.getText() ;
						MainAdmin.CancelIt();
						setVisible(false);
					}
					else if(User == 2) {
						Receptionist.Reason = txtReason.getText() ;
						Receptionist.CancelIt();
						setVisible(false);
					}
				}
			}
		});
		btnYes.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\hire.png"));
		btnYes.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnYes.setBounds(72, 195, 107, 35);
		contentPane.add(btnYes);
		
		lblPleaseIndicate = new JLabel("| Please indicate your reason below");
		lblPleaseIndicate.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblPleaseIndicate.setBounds(62, 59, 274, 35);
		contentPane.add(lblPleaseIndicate);
		
		btnNo = new JButton("NO");
		btnNo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNo.setFont(new Font("Century Gothic", Font.BOLD, 13));
				btnNo.setBackground(Color.RED);
				btnNo.setForeground(Color.LIGHT_GRAY);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
				btnNo.setForeground(Color.BLACK);
				btnNo.setBackground(new Color(240, 240, 240));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		btnNo.setIcon(new ImageIcon("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\fire.png"));
		btnNo.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNo.setBounds(236, 195, 107, 35);
		contentPane.add(btnNo);
		setLocationRelativeTo(null);
	}
}
