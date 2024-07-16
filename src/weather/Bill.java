package weather;

import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Project.ConnectionProvider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Bill extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	String meter;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	 public double totalf;
	 double unitt=0;
	 String from11;
	 String to11;
	 String ser;
	 double tot=0;
	 String Supp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setUndecorated(true);
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
	public Bill() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0,1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DATE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(1190, 51, 78, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TIME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(1190, 109, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(1385, 55, 104, 13);
		contentPane.add(lblNewLabel_2);
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");
		Date date1 = new Date();
		lblNewLabel_2.setText(d.format(date1));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setBounds(1385, 109, 88, 13);
		contentPane.add(lblNewLabel_3);
		DateTimeFormatter da=DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		lblNewLabel_3.setText(da.format(now));
		
		JLabel lblNewLabel_4 = new JLabel("CUSTOMER DETAIL");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(44, 135, 178, 13);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("METERNO");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(46, 189, 120, 40);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("NAME");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setBounds(537, 203, 61, 13);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("EMAIL");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(1140, 203, 61, 13);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PHONE NO");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(42, 305, 88, 13);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String name=textField.getText();
				 meter=textField.getText();
				//String address=textField_2.getText();
				//String email=textField_3.getText();
				//String phoneno=textField_4.getText();
				//String address=textField_5.getText();
				
				try  {
					Connection con =ConnectionProvider.getCon();
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery("select * from detail where meterno ='"+meter+"'");
					
					if(rs.next())
					{
						
						textField_1.setText(rs.getString(1));
						textField_2.setText(rs.getString(4));
						textField_3.setText(rs.getString(5));
						//textField_1.setText(rs.getString(1));
											
					}
					else
					{
						JOptionPane.showMessageDialog(null, "contact doesn't exist");
					}
				    
				    
				    				    }
				catch (SQLException ex) {
				    ex.printStackTrace(); 
				}
			}
		});
		textField.setBounds(192, 202, 169, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(696, 202, 169, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(1293, 202, 196, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(192, 299, 169, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
			//String s = textField.getText();
				//btnNewButton_2.setEnabled(false);
				Connection con = ConnectionProvider.getCon();
				PreparedStatement pst = con.prepareStatement("SELECT detail.meterno, user,phone,from1,to1 ,unit, tot,service,type1 FROM detail, bill WHERE detail.meterno = bill.meterno and detail.meterno=? and bill.status1!='paid' and tot!='0.0' ");
				pst.setString(1, meter);
				ResultSet rs = pst.executeQuery();//no=bill.meterno and s==detail.meterno");
				/*if(rs.next())
				{
				 from11=rs.getString("from1");
				    to11=rs.getString("to1");
				     ser = rs.getString("serviceno");
				     Supp = rs.getString("Supply");
				}*/
				
				    ResultSetMetaData rsmd = rs.getMetaData();
				    int columnCount = rsmd.getColumnCount();
				    
				    DefaultTableModel model1 = (DefaultTableModel) table.getModel();
				    model1.setRowCount(0); // Clear existing rows
				    boolean firstRow = true;
				    while (rs.next()) {
				    	if (firstRow) {
				            from11 = rs.getString("from1");
				            to11 = rs.getString("to1");
				            ser = rs.getString("service");
				            Supp = rs.getString("type1");
				            firstRow = false;
				        }

				        Object[] row = new Object[columnCount];
				        for (int i = 1; i <= columnCount; i++) {
				            row[i - 1] = rs.getString(i);
				        }
				        model1.addRow(row);
				    }
				   
				    
				    
				    rs.close();
				    pst.close();
				    con.close();
				} catch (Exception ex) {
				    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
				}

			
			
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(1338, 315, 120, 29);
		contentPane.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 366, 1479, 8);
		contentPane.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 414, 864, 409);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"METERNO", "USERNAME", "PHONENO", "FROM", "TO", "UNIT", "AMOUNT"
			}
		));
		
		JLabel lblNewLabel_10 = new JLabel("TOTAL");
		lblNewLabel_10.setBounds(988, 545, 45, 13);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("PAID AMOUNT");
		lblNewLabel_11.setBounds(980, 632, 94, 13);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("RETURN AMOUNT");
		lblNewLabel_12.setBounds(980, 714, 127, 13);
		contentPane.add(lblNewLabel_12);
		
		textField_4 = new JTextField();
		textField_4.setBounds(1205, 542, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(1205, 629, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(1205, 711, 96, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("CALCULATE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int nrow = table.getRowCount();
		      tot = 0;
		        unitt = 0;
		       
		        for (int i = 0; i < nrow; i++) {
		            String valueString = table.getValueAt(i, 5).toString();
		            String valueString1 = table.getValueAt(i, 6).toString();
		           // String valueString2 = table.getValueAt(i, 6).toString();
		            
		            double value = 0.0; 
		            double value1=0.0;// Default value if the string is empty
		            if (!valueString.isEmpty() && !valueString1.isEmpty()) {
		                value = Double.valueOf(valueString);
		                value1 = Double.valueOf(valueString1);
		                
		                tot += value;
		                unitt+=value1;
		                
		            }

		        }
		        textField_4.setText(Double.toString(unitt));
		        //String paidText = textField_5.getText();
		        textField_5.setEnabled(true);
		        textField_5.requestFocus(); // Set focus to the paid amount text field
		        final double totValue = unitt; 

		        textField_5.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		                String paidText = textField_5.getText();
		                if (paidText.isEmpty()) {
		                    // If the paid amount is empty, display an error message
		                    JOptionPane.showMessageDialog(null, "Please enter the paid amount.");
		                } else {
		                    // Parse the paid amount
		                    double paid = Double.parseDouble(paidText);
		                    
		                    // Get the total amount from textField_4
		                    double total = Double.parseDouble(textField_4.getText());
		                    
		                    // Calculate the return amount
		                    double returnAmount = paid - total;
		                    
		                    // Display the return amount in the return amount text field
		                    textField_6.setText(String.valueOf(returnAmount));
		                }
		            }
		        });

		       
			       
			}
		});
		btnNewButton_1.setBounds(1048, 422, 175, 48);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DONE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					Connection con =ConnectionProvider.getCon();
					//Statement st=con.createStatement();
				
                   
				    	
				    	PreparedStatement updateStatement = con.prepareStatement("UPDATE bill SET status1=? WHERE meterno=?");
				        updateStatement.setString(1, "paid");
				        updateStatement.setString(2, meter);
				       // updateStatement.setString(3, u);
				        
				        updateStatement.executeUpdate();
				       
				       Billprint billprint = new Billprint(meter,unitt,tot,from11,to11,ser,Supp);
				       billprint.setUndecorated(true);				       
				       billprint.setVisible(true);
				}
				catch(Exception k)
				{
					System.out.println("jdhfjs");
				}
				
               
		}});
		btnNewButton_2.setBounds(1250, 440, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Home frame = new Home();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(989, 814, 85, 21);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\yadha\\Downloads\\Untitled design.png"));
		lblNewLabel_9.setBounds(-768, 0, 2320, 887);
		contentPane.add(lblNewLabel_9);
	}
}
