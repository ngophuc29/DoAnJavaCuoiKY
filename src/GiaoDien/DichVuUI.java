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
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;

public class DichVuUI extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	public static DefaultTableModel model;
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
	private JTextField txtmadv;
	private JTextField txttendv;
	private JTextField txtpgidv;
	private JTextField textField_3;

	private JTable table_1;
	private dichVuDAO dichvuDAO= new dichVuDAO();
	public DichVuUI() {
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1399, 868);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDchV = new FixButton("Dịch Vụ");
		btnDchV.setIcon(new ImageIcon(DichVuUI.class.getResource("/img/Household-Bell-Service-icon.png")));
		btnDchV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDchV.setBorderPainted(false);
		btnDchV.setBackground(new Color(242, 208, 183));
		btnDchV.setBounds(41, 28, 194, 48);
		contentPane.add(btnDchV);
		
		JLabel lblNewLabel = new JLabel("Mã Dịch Vụ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 83, 185, 30);
		contentPane.add(lblNewLabel);
		
		txtmadv = new JTextField();
		txtmadv.setBounds(53, 124, 188, 30);
		contentPane.add(txtmadv);
		txtmadv.setColumns(10);
		
		JLabel lblTnDchV = new JLabel("Tên Dịch Vụ");
		lblTnDchV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnDchV.setBounds(56, 165, 185, 30);
		contentPane.add(lblTnDchV);
		
		txttendv = new JTextField();
		txttendv.setColumns(10);
		txttendv.setBounds(53, 206, 188, 30);
		contentPane .add(txttendv);
		
		JLabel lblPhDchV = new JLabel("Phí Dịch Vụ");
		lblPhDchV.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhDchV.setBounds(56, 261, 185, 30);
		contentPane.add(lblPhDchV);
		
		txtpgidv = new JTextField();
		txtpgidv.setColumns(10);
		txtpgidv.setBounds(53, 302, 188, 30);
		contentPane.add(txtpgidv);
		
		JLabel lblTrngThi = new JLabel("Trạng Thái");
		lblTrngThi.setFont(new Font("Tahoma", Font.BOLD, 14));
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
		
		JButton them = new FixButton("Thêm");
		them.setBackground(new Color(0, 255, 0));
		them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			 String ma=txtmadv.getText();
			 String ten=txttendv.getText();
			 String phi = txtpgidv.getText();
			 
			 dichVu dv=new dichVu(ma, ten,Double.parseDouble(phi) );
			 
			 if(dichvuDAO.themDichVu(dv)) {
				 Object []obj= {txtmadv.getText(),txttendv.getText(),txtpgidv.getText()};
				 model.addRow(obj);
			 }
			 
			}
		});
		them.setFont(new Font("Tahoma", Font.BOLD, 12));
		them.setBounds(56, 433, 89, 48);
		contentPane.add(them);
		
		JButton btnXa = new FixButton("Xóa");
		//
		
		
		btnXa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXa.setForeground(Color.WHITE);
		btnXa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnXa.setBackground(Color.RED);
		btnXa.setBounds(10, 153, 300, 36);
		//
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row>=0) {
					String madichvu = (String) table.getValueAt(row, 0);
					if(dichVuDAO.delete(madichvu)) {
						model.removeRow(row);
						xoaRong();
					}
				}
				
			}
			
		});
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXa.setBounds(168, 433, 89, 48);
		contentPane.add(btnXa);
		
		JButton btnSa = new FixButton("Sửa");
		btnSa.setBackground(new Color(75, 0, 130));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row>=0) {
					String maDV = txtmadv.getText();
					String tenDV = txttendv.getText().toString();
					String phiDV = txtpgidv.getText().toString();
					
					dichVu dv = new dichVu(maDV,tenDV,Double.parseDouble(phiDV));
					
					
					if(dichVuDAO.update(dv)) {
						
						table.setValueAt(txtmadv.getText(), row, 0);
						table.setValueAt(txttendv.getText(), row, 1);
						table.setValueAt(txtpgidv.getText(), row, 2);
					
						
					}
				}
			
				
			}
		});
		btnSa.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSa.setBounds(56, 503, 89, 48);
		contentPane.add(btnSa);
		
		JButton btnLu = new FixButton("Lưu");
		btnLu.setBackground(new Color(0, 255, 255));
		btnLu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLu.setBounds(168, 503, 89, 48);
		contentPane.add(btnLu);
		
		JLabel lblNewLabel_1 = new JLabel("Tìm Kiếm");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(307, 48, 99, 23);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(416, 40, 585, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new FixButton("Tìm ");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(1036, 39, 89, 32);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new FixButton("Hủy");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
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
//		dichvuDAO = new dichVuDAO();
		for (dichVu dv : dichvuDAO.getAlldichvu()) {
			Object []obj= {dv.getMadichvu(),dv.getTendichvu(),dv.getGiadichvu() };
			model.addRow(obj);
			
		}
		JButton btnthoat = new FixButton("Thoát");
		btnthoat.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnthoat.setBounds(57, 573, 200, 40);
		contentPane.add(btnthoat);
		
		
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row =table.getSelectedRow();
				txtmadv.setText(table.getValueAt(row, 0).toString());
				txttendv.setText(table.getValueAt(row, 1).toString());
				txtpgidv.setText(table.getValueAt(row, 2).toString());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	private void xoaRong() {
		txtmadv.setText("");
		txttendv.setText("");
		txtpgidv.setText("");
	}

}
