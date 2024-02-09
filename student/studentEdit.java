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
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class studentEdit extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentEdit frame = new studentEdit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	//db

	String url = "jdbc:mysql://localhost:3306/CMS";
	String dbUsername = "root";
	String dbPassword = "";
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	
	private void addStudent1(String firstname, String lastname, String email, String password, int level, String course, int user_id) {
	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
	            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET firstname = ?, lastname = ?, email = ?, password = ?, std_level = ?, std_course = ? WHERE user_id = ?")) {
	    	preparedStatement.setString(1,firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.setInt(5, level);
            preparedStatement.setString(6, course);
            preparedStatement.setInt(7, user_id);
        	 
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Student Updated successfully!");
	            JOptionPane.showMessageDialog(null, "Student Updated Sucessfully");
	        } else {
	            System.out.println("Student not found with ID: " + user_id);
	            JOptionPane.showMessageDialog(null, "Failed to update Student !");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	/**
	 * Create the frame.
	 */
	public studentEdit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(UIManager.getColor("CheckBoxMenuItem.acceleratorForeground"));
		panel.setBounds(0, 0, 505, 62);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Edit Student");
		lblNewLabel.setFont(new Font("Dyuthi", Font.BOLD, 35));
		lblNewLabel.setBounds(164, 12, 190, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_1.setBounds(29, 88, 189, 43);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(248, 92, 212, 38);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname :");
		lblNewLabel_2.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2.setBounds(29, 166, 200, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(248, 158, 212, 38);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Lastname :");
		lblNewLabel_2_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2_1.setBounds(29, 233, 163, 30);
		contentPane.add(lblNewLabel_2_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(248, 225, 212, 38);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email :");
		lblNewLabel_2_1_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2_1_1.setBounds(29, 297, 109, 30);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(248, 289, 212, 38);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Password :");
		lblNewLabel_2_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2_1_1_1.setBounds(29, 354, 163, 30);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Level :");
		lblNewLabel_2_1_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2_1_1_1_1.setBounds(29, 410, 109, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"4", "5", "6"}));
		comboBox.setBounds(248, 411, 52, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Course :");
		lblNewLabel_2_1_1_1_1_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_2_1_1_1_1_1.setBounds(29, 465, 109, 30);
		contentPane.add(lblNewLabel_2_1_1_1_1_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(248, 457, 212, 38);
		contentPane.add(textField_5);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user_id = textField.getText();
				String firstName = textField_1.getText();
				String lastName = textField_2.getText();
				String Email = textField_3.getText(); 
				String Password = passwordField.getText();
				String Level = (String)comboBox.getSelectedItem();
				String Course = textField_5.getText();
				
				if ( !user_id.equals("") && !firstName.equals("") && !lastName.equals("") && !Email.equals("") && !Password.equals("") && !Level.equals("") && !Course.equals("")) {
					int lvl = Integer.parseInt(Level);
					int id = Integer.parseInt(user_id);
					addStudent1(firstName,lastName,Email,Password,lvl,Course,id); //calling the addCourse function
				}else {
					JOptionPane.showMessageDialog(null,"Value cannot be empty");
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Dyuthi", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.BLUE);
		btnNewButton_1.setBounds(175, 527, 98, 43);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Dyuthi", Font.BOLD, 25));
		btnNewButton.setBackground(SystemColor.controlShadow);
		btnNewButton.setBounds(415, 551, 90, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_2 = new JLabel(" ->");
		lblNewLabel_2_2.setFont(new Font("Dyuthi", Font.BOLD, 20));
		lblNewLabel_2_2.setBounds(380, 556, 29, 31);
		contentPane.add(lblNewLabel_2_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 348, 212, 36);
		contentPane.add(passwordField);
	}

}
