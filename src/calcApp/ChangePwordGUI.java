package calcApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

public class ChangePwordGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUname;
	private JTextField textFieldEmail;
	private JTextField textFieldOpassword;
	private JTextField textFieldNPword;
	private JTextField txtSystemMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePwordGUI frame = new ChangePwordGUI();
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
	public ChangePwordGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblChngePword = new JLabel("Change Password");
		lblChngePword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblChngePword);
		
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
		
		JLabel lblOPassword = new JLabel("Old Password");
		contentPane.add(lblOPassword);
		
		textFieldOpassword = new JTextField();
		contentPane.add(textFieldOpassword);
		textFieldOpassword.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		contentPane.add(lblNewPassword);
		
		textFieldNPword = new JTextField();
		contentPane.add(textFieldNPword);
		textFieldNPword.setColumns(10);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setForeground(UIManager.getColor("Button.light"));
		contentPane.add(btnChangePassword);
		
		txtSystemMessage = new JTextField();
		txtSystemMessage.setEditable(false);
		txtSystemMessage.setForeground(UIManager.getColor("Button.disabledText"));
		txtSystemMessage.setText("System Message");
		contentPane.add(txtSystemMessage);
		txtSystemMessage.setColumns(10);
	}

}
