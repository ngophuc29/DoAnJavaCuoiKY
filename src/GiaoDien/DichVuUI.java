package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.dichVuDAO;
import DAO.khachHangDAO;
import database.ConnectDB;
import entity.KhachHang;
import entity.dichVu;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class DichVuUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DichVuUI frame = new DichVuUI();
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	private JTable table_1;
	private dichVuDAO dichvuDAO;
	public DichVuUI() {
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1399, 868);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDchV = new JButton("Dịch Vụ");
		btnDchV.setIcon(new ImageIcon(DichVuUI.class.getResource("/img/Household-Bell-Service-icon.png")));
		btnDchV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDchV.setBorderPainted(false);
		btnDchV.setBackground(new Color(242, 208, 183));
		btnDchV.setBounds(41, 28, 194, 48);
		contentPane.add(btnDchV);
		
		JLabel lblNewLabel = new JLabel("Mã Dịch Vụ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(56, 83, 185, 30);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(53, 124, 188, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTnDchV = new JLabel("Tên Dịch Vụ");
		lblTnDchV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnDchV.setBounds(56, 165, 185, 30);
		contentPane.add(lblTnDchV);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(53, 206, 188, 30);
		contentPane .add(textField_1);
		
		JLabel lblPhDchV = new JLabel("Phí Dịch Vụ");
		lblPhDchV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhDchV.setBounds(56, 261, 185, 30);
		contentPane.add(lblPhDchV);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(53, 302, 188, 30);
		contentPane.add(textField_2);
		
		JLabel lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrngThi.setBounds(56, 353, 185, 30);
		contentPane.add(lblTrngThi);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Hỗ trợ");
		rdbtnNewRadioButton.setBackground(new Color(242, 208, 183));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNewRadioButton.setBounds(56, 390, 90, 36);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNgngHotng = new JRadioButton("Ngừng Hoạt Động");
		rdbtnNgngHotng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNgngHotng.setBackground(new Color(242, 208, 183));
		rdbtnNgngHotng.setBounds(147, 390, 148, 36);
		contentPane.add(rdbtnNgngHotng);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(56, 433, 89, 48);
		contentPane.add(btnNewButton);
		
		JButton btnXa = new JButton("Xóa");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXa.setBounds(168, 433, 89, 48);
		contentPane.add(btnXa);
		
		JButton btnSa = new JButton("Sửa");
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSa.setBounds(56, 503, 89, 48);
		contentPane.add(btnSa);
		
		JButton btnLu = new JButton("Lưu");
		btnLu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLu.setBounds(168, 503, 89, 48);
		contentPane.add(btnLu);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(307, 48, 99, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(416, 40, 585, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Tìm ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(1036, 39, 89, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Hủy");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1_1.setBounds(1158, 39, 89, 32);
		contentPane.add(btnNewButton_1_1);
		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(295, 124, 984, 495);
//		contentPane.add(scrollPane);
//		
//		JScrollPane scrollPane_1 = new JScrollPane();
//		scrollPane.setViewportView(scrollPane_1);
//		
//		table_1 = new JTable();
//		scrollPane_1.setViewportView(table_1);
//		
//		
//		model.addColumn("Mã DV");
//		model.addColumn("Tên DV");
//		model.addColumn("Phí DV");
//		model.addColumn("Tr");
//		model.addColumn("Địa Chỉ");
//		model.addColumn("Email");
//		model.addColumn("Chức Vụ");
//		model.addColumn("Giới Tính");
//		model.addColumn("Ngày Sinh");
//		model.addColumn("Ngày Vào Làm");
//		model.addColumn("Trạng Thái Làm Việc");
//		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(295, 124, 984, 495);
		contentPane.add(scrollPane);
		
		model= new DefaultTableModel();
		model.addColumn("Mã DV");
		model.addColumn("Tên DV");
		model.addColumn("Phí DV");
	 
		table = new JTable(model);
		 
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		dichvuDAO = new dichVuDAO();
		for (dichVu dv : dichvuDAO.getAlldichvu()) {
			Object []obj= {dv.getMadichvu(),dv.getTendichvu(),dv.getGiadichvu() };
			model.addRow(obj);
			
		}
		JButton btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnthoat.setBounds(57, 573, 200, 30);
		contentPane.add(btnthoat);
	}

}
