package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class TrangDangNhapUI extends JFrame {

	private JPanel contentPane;
	private JTextField txttk;
	private JPasswordField txtpw;
	String selectedOption;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangDangNhapUI frame = new TrangDangNhapUI();
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
	public TrangDangNhapUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_imghotel_wrapp = new JLabel("");
		lblNewLabel_imghotel_wrapp.setIcon(new ImageIcon(TrangDangNhapUI.class.getResource("/img/zzz-removebg-preview.png")));
		lblNewLabel_imghotel_wrapp.setBounds(50, 11, 125, 86);
		contentPane.add(lblNewLabel_imghotel_wrapp);
		
		JLabel lblNewLabel = new JLabel("Khách Sạn Bình Dương");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(192, 11, 267, 66);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(68, 119, 93, 14);
		contentPane.add(lblNewLabel_1);
		
		txttk = new JTextField();
		txttk.setBounds(192, 113, 267, 30);
		contentPane.add(txttk);
		txttk.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(68, 175, 93, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(" ");
		chckbxNewCheckBox.setBackground(new Color(242, 208, 183));
		chckbxNewCheckBox.setBounds(192, 229, 29, 14);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("Hiển thị mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(227, 226, 166, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Đăng Nhập");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(192, 258, 134, 41);
		contentPane.add(btnNewButton);
		
		JButton btnngK = new JButton("Đổi mật khẩu");
		btnngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trangDoiPass tdk= new trangDoiPass();
				tdk.setVisible(true);
//				dispose();
			}
		});
		btnngK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnngK.setBounds(336, 258, 156, 41);
		contentPane.add(btnngK);
		
		txtpw = new JPasswordField();
		txtpw.setBounds(192, 167, 267, 30);
		contentPane.add(txtpw);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(269, 75, 106, 22);
		comboBox.addItem("Nhân Viên");
		comboBox.addItem("Quản Lý");
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption.equals("Nhân Viên")) {
                	txttk.setText("NV");
                	  
                }  if (selectedOption.equals("Quản Lý")) {
                	txttk.setText("QL");
                	 
                }
            }
        });
		JLabel lblNewLabel_3 = new JLabel("Bạn Là ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(202, 73, 141, 24);
		contentPane.add(lblNewLabel_3);
	}
}
