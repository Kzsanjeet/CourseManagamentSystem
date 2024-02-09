package student;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class addStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	
	
	private void addStudent1( String firstname, String lastname, String email, String password, int level, String course) {
		String url = "jdbc:mysql://localhost:3306/CMS";
	     String dbUsername = "root";
	     String dbPassword = "";

	     try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword)) {
			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (firstname, lastname, email, password, role, std_level,std_course) VALUES (?, ?, ?, ?, 'Student', ?, ?);");
             preparedStatement.setString(1,firstname);
             preparedStatement.setString(2, lastname);
             preparedStatement.setString(3, email);
             preparedStatement.setString(4, password);
             preparedStatement.setInt(5, level);
             preparedStatement.setString(6, course);
         	 
         	 
         	 preparedStatement.executeUpdate();
         	 
         	JOptionPane.showMessageDialog(null, "Added successfully");
			 
		}catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addStudent frame = new addStudent();
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
	public addStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 0, 643, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Student");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dyuthi", Font.BOLD, 35));
		lblNewLabel.setBounds(245, 12, 200, 46);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Student Firstname :");
		lblNewLabel_1_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(75, 98, 240, 26);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(75, 136, 258, 31);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Student Lastname :");
		lblNewLabel_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1_1.setBounds(75, 179, 218, 26);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(75, 217, 258, 31);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email :");
		lblNewLabel_1_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1_1_1.setBounds(75, 271, 218, 26);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(75, 310, 258, 31);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Password :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1.setBounds(75, 364, 218, 26);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Level :");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1_1.setBounds(75, 455, 84, 26);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		comboBox.setBounds(199, 455, 66, 26);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Course :");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Dyuthi", Font.BOLD, 25));
		lblNewLabel_1_1_1_1_1_2.setBounds(75, 499, 115, 26);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(75, 532, 258, 31);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Add Course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = textField.getText();
				String lastName = textField_1.getText();
				String Email = textField_2.getText(); 
				String Password = passwordField.getText();
				String Level = (String)comboBox.getSelectedItem();
				String Course = textField_4.getText();
				
				
				
				
				if (!firstName.equals("") && !lastName.equals("") && !Email.equals("") && !Password.equals("") && !Level.equals("") && !Course.equals("")) {
					int lvl = Integer.parseInt(Level);
					addStudent1(firstName,lastName,Email,Password,lvl,Course); //calling the addCourse function
				}else {
					JOptionPane.showMessageDialog(null,"Value cannot be empty");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Dyuthi", Font.BOLD, 16));
		btnNewButton.setBackground(UIManager.getColor("Button.select"));
		btnNewButton.setBounds(137, 598, 117, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dyuthi", Font.BOLD, 16));
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1.setBounds(566, 610, 89, 31);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_4 = new JLabel(" ->");
		lblNewLabel_4.setFont(new Font("Dyuthi", Font.BOLD, 20));
		lblNewLabel_4.setBounds(531, 620, 34, 20);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(75, 392, 253, 36);
		contentPane.add(passwordField);
	}
}
