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
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEntry;
	private JTextField textFieldOutput;
	private JTextField txtSystemMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
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
	public CalculatorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblCalculator = new JLabel("Calculator");
		lblCalculator.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblCalculator);
		
		JLabel lblEnterEquation = new JLabel("Enter Equation");
		contentPane.add(lblEnterEquation);
		
		textFieldEntry = new JTextField();
		contentPane.add(textFieldEntry);
		textFieldEntry.setColumns(10);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setForeground(UIManager.getColor("Button.light"));
		contentPane.add(btnCalculate);
		
		JLabel lblOutput = new JLabel("Output");
		contentPane.add(lblOutput);
		
		textFieldOutput = new JTextField();
		contentPane.add(textFieldOutput);
		textFieldOutput.setColumns(10);
		
		txtSystemMessage = new JTextField();
		txtSystemMessage.setForeground(Color.GREEN);
		txtSystemMessage.setText("Successful Login");
		contentPane.add(txtSystemMessage);
		txtSystemMessage.setColumns(10);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				System.exit(0);
				
			}
		});
		btnLogout.setForeground(Color.RED);
		contentPane.add(btnLogout);
	}

}
