import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MessageBox extends JFrame {

	private static JPanel contentPane;
	private static JTextField txtMessage;
	private JButton btnSend;
	public static JTextArea txtAreaMessageAdmin;
	private Image img;
	private static JLabel lblOMS;
	private static JLabel lblStatus;
	private static JLabel lblYouAreOnline;
	private static JLabel lblIcon;
	public static MessageBoxGuest frmMessageBoxGuest;
	private static JPanel pnlText;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MessageBox() {
		
		setFont(new Font("Century Gothic", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Service Queuing System(OMS Repair Shop)v3.02\\img\\chats.png"));
		setBounds(100, 100, 332, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlText = new JPanel();
		pnlText.setBounds(10, 81, 307, 358);
		contentPane.add(pnlText);
		pnlText.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 287, 294);
		pnlText.add(scrollPane);
		
		txtAreaMessageAdmin = new JTextArea();
		txtAreaMessageAdmin.setEditable(false);
		scrollPane.setViewportView(txtAreaMessageAdmin);
		txtAreaMessageAdmin.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		
		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					SendMessage();
					txtMessage.setText("");
				}
			}
		});
		txtMessage.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtMessage.setText("");
				txtMessage.setForeground(Color.BLACK);
				
			}
		});
		txtMessage.setForeground(new Color(169, 169, 169));
		txtMessage.setText("Write your message here");
		txtMessage.setBounds(10, 316, 207, 35);
		pnlText.add(txtMessage);
		txtMessage.setColumns(10);
		
		btnSend = new JButton("");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendMessage();
			}
		});
		img = new ImageIcon(this.getClass().getResource("/send.png")).getImage();
		btnSend.setIcon(new ImageIcon(img));
		btnSend.setBounds(227, 316, 70, 35);
		pnlText.add(btnSend);
		
		lblOMS = new JLabel("OMS |CHAT HUB");
		img = new ImageIcon(this.getClass().getResource("/online.png")).getImage();
		lblOMS.setIcon(new ImageIcon(img));
		lblOMS.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblOMS.setBounds(10, 11, 204, 46);
		contentPane.add(lblOMS);
		
		lblStatus = new JLabel("Status :");
		lblStatus.setForeground(new Color(50, 205, 50));
		lblStatus.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblStatus.setBounds(205, 59, 48, 23);
		contentPane.add(lblStatus);
		
		lblYouAreOnline = new JLabel("Online");
		lblYouAreOnline.setForeground(new Color(50, 205, 50));
		lblYouAreOnline.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblYouAreOnline.setBounds(253, 59, 41, 23);
		contentPane.add(lblYouAreOnline);
		
		lblIcon = new JLabel(" ");
		img = new ImageIcon(this.getClass().getResource("/status.png")).getImage();
		lblIcon.setIcon(new ImageIcon(img));
		lblIcon.setForeground(new Color(50, 205, 50));
		lblIcon.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblIcon.setBounds(292, 59, 25, 23);
		contentPane.add(lblIcon);
		setTitle("Admin MessageBox");
		setResizable(false);

	}
	public static void darkMode(boolean Status) {
		if(Status == true) {
			contentPane.setBackground(Color.DARK_GRAY);
			lblOMS.setForeground(Color.WHITE);
			pnlText.setBackground(Color.DARK_GRAY);
		}
		if(Status == false) {
			contentPane.setBackground(new Color(255, 250, 250));
			lblOMS.setForeground(Color.BLACK);
			pnlText.setBackground(new Color(240, 240, 240));
		}
	}
	
	public void SendMessage() {
		
		if(txtAreaMessageAdmin.getText().contentEquals("")) {
			frmMessageBoxGuest = new MessageBoxGuest();
		}
		
		String Name =MainAdmin.lblAdministrator.getText();
		String PreviousMessage = txtAreaMessageAdmin.getText();
		String Send = PreviousMessage + "\n" + Name + " :  " + txtMessage.getText();
		txtAreaMessageAdmin.setText(Send);
		if(MessageBoxGuest.txtAreaMessageGuest.getText().contentEquals("")) {
			frmMessageBoxGuest.setVisible(true);
		}
		MessageBoxGuest.txtAreaMessageGuest.setText(Send);
		txtMessage.setText("Write your message here");
		txtMessage.setForeground(new Color(169, 169, 169));
	
		
	}
}
