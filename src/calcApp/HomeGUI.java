package calcApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class HomeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSystemMessage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeGUI frame = new HomeGUI("System Message");
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
	public HomeGUI(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCalculator = new JLabel("Calculator App");
		lblCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCalculator);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisterGUI reg = new RegisterGUI();
				reg.setVisible(true);
				
			}
		});
		contentPane.add(btnRegister);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginGUI log = new LoginGUI();
				log.setVisible(true);
			}
		});
		contentPane.add(btnLogin);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ChangePwordGUI cPword = new ChangePwordGUI();
				cPword.setVisible(true);
			}
		});
		contentPane.add(btnChangePassword);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ResetPwordGUI resetPword = new ResetPwordGUI();
				resetPword.setVisible(true);
			}
		});
		contentPane.add(btnResetPassword);
		
		txtSystemMessage = new JTextField();
		txtSystemMessage.setHorizontalAlignment(SwingConstants.CENTER);
		txtSystemMessage.setEditable(false);
		txtSystemMessage.setForeground(Color.LIGHT_GRAY);
		txtSystemMessage.setText(s);
		contentPane.add(txtSystemMessage);
		txtSystemMessage.setColumns(10);
	} 

}
