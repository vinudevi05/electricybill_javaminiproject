package weather;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Meterinfo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	JComboBox comboBox ;
	JComboBox comboBox_1; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meterinfo frame = new Meterinfo();
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
	public Meterinfo(String meter) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MORE INFO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(747, 10, 156, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SECTION");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(563, 160, 177, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CIRCLE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(563, 238, 177, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DISTRIBUTION");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(563, 323, 177, 13);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TARIFF");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(563, 427, 177, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PHASE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(563, 519, 177, 13);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("SANCTIONED LOAD");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_6.setBounds(563, 596, 177, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("METER TYPE");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(563, 668, 177, 13);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEnabled(true);
		        textField.requestFocus(); 
				String section=textField.getText();
				textField_1.setEnabled(true);
		        textField_1.requestFocus(); 
				String circle=textField_1.getText();
				textField_2.setEnabled(true);
		        textField_2.requestFocus(); 
				String distribution=textField_2.getText();
				  String tariff = (String) comboBox.getSelectedItem();
				  String phase = (String) comboBox_1.getSelectedItem();
				String sanctio1=textField_3.getText();
				
				// name = textField.getText();
	              //  pass = new String(passwordField.getPassword());
	                //confirmPass = new String(passwordField_1.getPassword());
	              //  String code = textField_3.getText();

	                if (section.trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please enter a section", "Input Error", JOptionPane.ERROR_MESSAGE);
	                    textField.setText("");
	                    return;
	                }

	                if (circle.trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please enter a circle name", "Input Error", JOptionPane.ERROR_MESSAGE);
	                    textField_1.setText("");
	                    
	                    return;
	                }
	                if (distribution.trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please enter a distribution name", "Input Error", JOptionPane.ERROR_MESSAGE);
	                    textField_1.setText("");
	                    
	                    return;
	                }
	                if (sanctio1.trim().isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Please enter the sactioned load", "Input Error", JOptionPane.ERROR_MESSAGE);
	                    textField_3.setText("");
	                    return;
	                }
	               
	               
	                
				String query = "INSERT INTO meterno VALUES (?, ?, ?,?,?,?,?)";
				try  {
					Connection con=ConnectionProvider.getCon();
					PreparedStatement statement = con.prepareStatement(query);
				    statement.setString(1, section);
				    statement.setString(2, circle);
				    statement.setString(3, distribution);
				   statement.setString(4, tariff);
				    statement.setString(5, phase);
				    statement.setString(6, sanctio1);
				    statement.setString(7, meter);
				   // statement.setString(6, address);
				    
				    int rowsInserted = statement.executeUpdate();
				    if (rowsInserted > 0) {
				        JOptionPane.showMessageDialog(null, "details successfully inserted");
				        setVisible(false);
				        Home frame = new Home();
						frame.setUndecorated(true);
						frame.setVisible(true);
						
				    }
				} catch (SQLException ex) {
				    ex.printStackTrace(); 
				}
				
			}
		});
		btnNewButton.setBounds(1108, 761, 85, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(786, 159, 151, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(786, 232, 151, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(786, 322, 151, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		 comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"LT1A", "LT1D", "LTII-B", "LTIII-B", "LTIV"}));
		comboBox.setBounds(791, 425, 146, 21);
		contentPane.add(comboBox);
		
		 comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ONE PHASE", "THREE PHASE"}));
		comboBox_1.setBounds(793, 511, 144, 21);
		contentPane.add(comboBox_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(793, 595, 144, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"SOLAR METER", "ELECTRIC METER", "SMART METER"}));
		comboBox_2.setBounds(797, 665, 151, 21);
		contentPane.add(comboBox_2);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(522, 761, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\yadha\\Downloads\\Untitled design.png"));
		lblNewLabel_8.setBounds(-812, 0, 2366, 865);
		contentPane.add(lblNewLabel_8);
	}

}
