package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import database.ConnectDB;
import database.ConnectDB;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TrangDangNhapUI extends JFrame {

	private JPanel contentPane;
	public JTextField txttk;
	public JPasswordField txtpw;
	public String selectedOption;
	public JComboBox comboBoxPhanQuyen;
	public String savema="";
	private static String maNV;
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
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
		txttk.setText("NV");
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật Khẩu");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(68, 175, 93, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox(" ");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		chckbxNewCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    txtpw.setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                    txtpw.setEchoChar('\u2022'); // Ẩn mật khẩu
                }
            }
        });
		chckbxNewCheckBox.setBackground(new Color(242, 208, 183));
		chckbxNewCheckBox.setBounds(192, 229, 29, 14);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_2 = new JLabel("Hiển thị mật khẩu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(227, 226, 166, 16);
		contentPane.add(lblNewLabel_2);
		
		JButton btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if (e.getKeyCode()==KeyEvent.VK_ENTER){
					 JOptionPane.showMessageDialog(null, "hello");
			        }
			}
		});
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConnectDB.getinstance();
				Connection con =ConnectDB.getConnection();
				try {
					
					 
					String sqlLogin="Select * From nhanvien where manv=? and password =?";
				 
						PreparedStatement pst = con.prepareStatement(sqlLogin);
						 pst.setString(1, txttk.getText());
						pst.setString(2, txtpw.getText());
						
						ResultSet rs= pst.executeQuery();
					
						
						if(txttk.getText().equals("")||txtpw.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Chua nhap tai khoan va mat khau");
						}
						else if(rs.next()) {
							TrangChuUI tc= new TrangChuUI();
							DatPhong dt= new DatPhong();
							tc.setVisible(true);
							tc.txtmanvdn.setText(txttk.getText());
							dt.txtmanvintable.setText(txttk.getText());
							maNV=txttk.getText();
							//Phân quyền
							String input =  txttk.getText(); // Lấy chuỗi đầu vào từ JTextField
							String firstTwoChars = input.substring(0, 2);
							
							if(firstTwoChars.equals("NV")) {
								tc.txtquyendangnhap.setText("Nhân Viên");
								 
								tc.btnnhavien.setEnabled(false);
								tc.btnnhavien.setToolTipText("Mục Này Dành Cho Quản Lý");
							}
							else {
								tc.txtquyendangnhap.setText("Quản Lý");
								tc.btnnhavien.setEnabled(true);
							}
							
							// End Phân Quyền
							
							JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
							
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
						}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		txttk.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				maNV=txttk.getText();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				maNV=txttk.getText();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				maNV=txttk.getText();
			}
		});
		
		
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangNhap.setBounds(192, 258, 134, 41);
		contentPane.add(btnDangNhap);
		
		JButton btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrangDoiPass tdk= new TrangDoiPass();
				tdk.setVisible(true);
//				dispose();
			}
		});
		btnDoiMK.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDoiMK.setBounds(336, 258, 156, 41);
		contentPane.add(btnDoiMK);
		
		txtpw = new JPasswordField();
		txtpw.setBounds(192, 167, 267, 30);
		contentPane.add(txtpw);
		
		comboBoxPhanQuyen = new JComboBox();
		comboBoxPhanQuyen.setBounds(269, 75, 106, 22);
		comboBoxPhanQuyen.addItem("Nhân Viên");
		comboBoxPhanQuyen.addItem("Quản Lý");
		contentPane.add(comboBoxPhanQuyen);
		
		comboBoxPhanQuyen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 selectedOption = (String) comboBoxPhanQuyen.getSelectedItem();
                if (selectedOption.equals("Nhân Viên")) {
                	txttk.setText("NV");
                	  
                }  if (selectedOption.equals("Quản Lý")) {
                	txttk.setText("QL");
                	 
                }
            }
        });
		JLabel lblNewLabel_3 = new JLabel("Bạn Là ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(202, 72, 69, 24);
		contentPane.add(lblNewLabel_3);
		
	}
	
	 public JTextField getTxttk() {
		return txttk;
	}
	
	public void itemStateChanged(ItemEvent e) {
	        if (e.getStateChange() == ItemEvent.SELECTED) {
	        	txtpw.setEchoChar((char) 0);
	        } else {
txtpw.setEchoChar('*');
	        }
	    }
	 public  String savema  () {
		return savema;
		
	}

	public static String getMaNV() {
		return maNV;
	}

	
	 
}