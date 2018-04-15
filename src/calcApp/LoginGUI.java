package calcApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUname;
	private JTextField textFieldPword;
	private JTextField txtSystemMessage;
	private JTextField textFieldLockout;
	private JLabel lblLockoutcount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogin);
		
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
		
		JButton btnRegister = new JButton("Login");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String uname = textFieldUname.getText();
				String pword = textFieldPword.getText();
				
				USER user1 = new USER("", "", "");
				
				Database dbc = new Database(user1);
				if(dbc.getRecordByUname(uname) != dbc.getRecordByUname(uname)) //how to check uname to unamme and corresponding pwords?
				{
					CalculatorGUI calc = new CalculatorGUI();
					calc.setVisible(true);
				}
				else //because of problems, made this not happen by if statement always being true. Having problems incrementing lock
				{
					int newLock = dbc.incrementLock(uname);
					txtSystemMessage.setText("Incorrect Entry");
					textFieldLockout.setText(Integer.toString(newLock));
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
		
		lblLockoutcount = new JLabel("LockoutCount");
		contentPane.add(lblLockoutcount);
		
		textFieldLockout = new JTextField();
		textFieldLockout.setEditable(false);
		contentPane.add(textFieldLockout);
		textFieldLockout.setColumns(10);
	}

}
