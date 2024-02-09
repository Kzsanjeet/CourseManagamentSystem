package student;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class studentDlt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	String url = "jdbc:mysql://localhost:3306/CMS";
	String dbUsername = "root";
	String dbPassword = "";
	private JTextField textField_1;
	
	public void deleteStudent1(int id) {
	    try (Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);
	            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE user_id = ?")) {

	        preparedStatement.setInt(1, id);
	        int rows = preparedStatement.executeUpdate();

	        if (rows > 0) {
	            JOptionPane.showMessageDialog(null, "Deleted Sucessfully");
	        } else {
	            System.out.println("Student not found with ID: " + id);
//	            JOptionPane.showMessageDialog(null, "Course not deleted");
	        }

	    } catch (SQLException e) {
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
					studentDlt frame = new studentDlt();
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
	public studentDlt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 514, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Student");
		lblNewLabel.setFont(new Font("Dyuthi", Font.BOLD, 35));
		lblNewLabel.setBounds(144, 22, 229, 36);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Id :");
		lblNewLabel_1.setFont(new Font("Dyuthi", Font.BOLD, 30));
		lblNewLabel_1.setBounds(171, 134, 183, 37);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(171, 199, 144, 45);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String studentID = textField_1.getText();
				
				if (!studentID.equals("")) {
					int id = Integer.parseInt(studentID);
					deleteStudent1(id); //calling the addCourse function
				}else {
					JOptionPane.showMessageDialog(null,"Value cannot be empty");
				}
				
			}
			});
		btnNewButton.setFont(new Font("Dyuthi", Font.BOLD, 23));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(171, 284, 144, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Dyuthi", Font.BOLD, 20));
		btnNewButton_1.setBackground(SystemColor.controlShadow);
		btnNewButton_1.setBounds(420, 385, 94, 37);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ->");
		lblNewLabel_2.setFont(new Font("Dyuthi", Font.BOLD, 20));
		lblNewLabel_2.setBounds(386, 388, 29, 31);
		contentPane.add(lblNewLabel_2);
	}

}
