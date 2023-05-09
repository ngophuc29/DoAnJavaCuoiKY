package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.nhanVienDAO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class trangDoiPass extends JFrame {

	private JPanel contentPane;
	private JTextField txtmkcu;
	private JTextField txtmkmoi;
	private JTextField textField_2;
	private JTextField txtmanv;
	
	private nhanVienDAO nvdao= new nhanVienDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					trangDoiPass frame = new trangDoiPass();
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
	public trangDoiPass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thay đổi thông tin");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(56, 28, 231, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lbluser = new JLabel("Mật Khẩu Cũ :");
		lbluser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbluser.setBounds(56, 131, 104, 29);
		contentPane.add(lbluser);
		
		txtmkcu = new JTextField();
		txtmkcu.setBounds(202, 128, 274, 39);
		contentPane.add(txtmkcu);
		txtmkcu.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật Khẩu Mới:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(56, 178, 136, 39);
		contentPane.add(lblNewLabel_1);
		
		txtmkmoi = new JTextField();
		txtmkmoi.setColumns(10);
		txtmkmoi.setBounds(202, 180, 274, 39);
		contentPane.add(txtmkmoi);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập Lại Mật Khẩu :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(56, 228, 143, 39);
		contentPane.add(lblNewLabel_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(202, 230, 274, 39);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				nvdao.doimk(txtmkmoi.getText(), txtmanv.getText());
				
				JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành Công");
				 
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(206, 299, 116, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Quay lại");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(365, 299, 106, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblMNhnVin = new JLabel("Mã Nhân Viên :");
		lblMNhnVin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMNhnVin.setBounds(56, 81, 133, 29);
		contentPane.add(lblMNhnVin);
		
		txtmanv = new JTextField();
		txtmanv.setColumns(10);
		txtmanv.setBounds(202, 78, 274, 39);
		contentPane.add(txtmanv);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(trangDoiPass.class.getResource("/img/iconregester.png")));
		lblNewLabel_2.setBounds(10, 14, 48, 56);
		contentPane.add(lblNewLabel_2);
	}
}
