package weather;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import p.Newbuyer;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10,1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("NEWCUSTOMER");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(497, 232, 116, 46);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("CUSTOMER DETAILS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_7.setBounds(977, 233, 165, 44);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_13 = new JLabel("CALCULATE BILL");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_13.setBounds(986, 448, 130, 58);
		contentPane.add(lblNewLabel_13);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_1.setBackground( new Color(51,151,51));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(null);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Newcustomer n = new Newcustomer(); // Create a new instance of the Login frame
		        n.setUndecorated(true); // Set the new Login frame to be undecorated
		        n.setVisible(true);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\yadha\\OneDrive\\Desktop\\PHOYTO BILL\\new buyer.png"));
		btnNewButton_1.setBounds(497, 134, 116, 77);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setBackground(new Color(51,151,51));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setBackground(null);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Customr frame = new Customr();
                frame.setUndecorated(true);
                frame.setVisible(true);
				
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\yadha\\OneDrive\\Desktop\\PHOYTO BILL\\buyer Details.png"));
		btnNewButton_4.setBounds(985, 134, 116, 77);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_7 = new JButton("");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_7.setBackground(new Color(51,151,51));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_7.setBackground(null);
				
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bill frame = new Bill();
				frame.setUndecorated(true);
				frame.setVisible(true);
			}
		});
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\yadha\\OneDrive\\Desktop\\PHOYTO BILL\\billing frame.png"));
		btnNewButton_7.setBounds(971, 349, 130, 73);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("");
		btnNewButton_8.setForeground(new Color(0,0,0));
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_8.setBackground(new Color(255,51,51));
				
			}
		});
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null, "do u want to ext","select",JOptionPane.YES_NO_OPTION);
				if(a==0)
				{
					setVisible(false); 

					Login login = new Login(); 
					login.setUndecorated(true); 
					login.setVisible(true); 
				}
			}
		});
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\yadha\\OneDrive\\Desktop\\PHOYTO BILL\\logout.png"));
		btnNewButton_8.setBounds(497, 587, 116, 73);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel = new JLabel("LOG OUT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(507, 687, 88, 44);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton.setBackground(new Color(51,151,51));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton.setBackground(null);
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\yadha\\OneDrive\\Desktop\\PHOYTO BILL\\details product.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CalculateBill frame = new CalculateBill();
				frame.setUndecorated(true);
                frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(497, 357, 116, 84);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("READINGS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(502, 462, 93, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ELECTRICITY BILLING SYSTEM");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(600, 35, 349, 33);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\yadha\\Downloads\\Untitled design.png"));
		lblNewLabel_4.setBounds(-756, -25, 2296, 887);
		contentPane.add(lblNewLabel_4);
	}

	public void undecoratd(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
