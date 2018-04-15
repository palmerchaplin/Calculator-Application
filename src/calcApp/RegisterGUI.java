package calcApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterGUI extends JFrame{

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldUname;
	private JTextField textFieldPword;
	private JTextField txtSystemMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegister.setBounds(194, 6, 61, 25);
		contentPane.add(lblRegister);
		
		JLabel lblNewLabel = new JLabel("Email");
		contentPane.add(lblNewLabel);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		contentPane.add(lblUsername);
		
		textFieldUname = new JTextField();
		contentPane.add(textFieldUname);
		textFieldUname.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		contentPane.add(lblPassword);
		
		textFieldPword = new JTextField();
		contentPane.add(textFieldPword);
		textFieldPword.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				
				String email = textFieldEmail.getText();
				String uname = textFieldUname.getText();
				String pword = textFieldPword.getText();
		
				USER user1 = new USER(email, uname, pword);
				//checks for valid entries and if username is already taken
				if(user1.validateEmail(email) && user1.validateUname(uname) && user1.validatePword(pword))
				{
					Database dbc = new Database(user1);
					dbc.sendEmail(user1.getEmailAdd(), "Registration Successful. Welcome.");
					HomeGUI home = new HomeGUI("Successful Registration");
					home.setVisible(true);
					
				}
				else
				{
					txtSystemMessage.setText("Invalid Entries. Please Try Again.");
				}
				
			}
		});
		btnRegister.setForeground(UIManager.getColor("Button.light"));
		contentPane.add(btnRegister);
		
		txtSystemMessage = new JTextField();
		txtSystemMessage.setForeground(Color.LIGHT_GRAY);
		txtSystemMessage.setEditable(false);
		txtSystemMessage.setText("System Message");
		contentPane.add(txtSystemMessage);
		txtSystemMessage.setColumns(10);
	}
}
