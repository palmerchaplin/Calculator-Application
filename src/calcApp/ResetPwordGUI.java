package calcApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class ResetPwordGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldUname;
	private JTextField txtSystemMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetPwordGUI frame = new ResetPwordGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ResetPwordGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblResetPassword);
		
		JLabel lblEmail = new JLabel("Email");
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		contentPane.add(lblUsername);
		
		textFieldUname = new JTextField();
		contentPane.add(textFieldUname);
		textFieldUname.setColumns(10);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setForeground(UIManager.getColor("Button.light"));
		contentPane.add(btnResetPassword);
		
		txtSystemMessage = new JTextField();
		txtSystemMessage.setEditable(false);
		txtSystemMessage.setForeground(UIManager.getColor("Button.disabledText"));
		txtSystemMessage.setText("System Message");
		contentPane.add(txtSystemMessage);
		txtSystemMessage.setColumns(10);
	}

}
