package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;

import DAO.khachHangDAO;
import DAO.nhanVienDAO;
import database.ConnectDB;
import entity.KhachHang;
import entity.nhanVien;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;

public class NhanVienUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	
	//
	private JButton btnThem;
	private JButton btnXoa;
	private JPanel contentPane1;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JComboBox txtcomboBox;
	JSpinner spinner;
	private JTextField txtNgayVaoLam;
	private JTextField txtngaySinh;
	private JTextField txtTrangThai;
	private JButton btnThemnv;
	private nhanVienDAO nvdao= new nhanVienDAO();
	private JTextField txtmanv;
	private JTextField txttenNV;
	private JTextField txtsdt;
	private JTextField txtcmnd;
	private JTextField txtdiachi;
	private JRadioButton rdbtnam;
	private JRadioButton rdbtnnu;
	private JDateChooser dateeNgayVaoLam;
	private JDateChooser dateengaysinh;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVienUI frame = new NhanVienUI();
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
	public NhanVienUI() {
		
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1880, 778);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 208, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	                  
	

		JButton btnnhavien = new JButton("Nhân viên");
		
		btnnhavien.setIcon(new ImageIcon(NhanVienUI.class.getResource("/img/Administrator-icon.png")));
		btnnhavien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnnhavien.setBorderPainted(false);
		btnnhavien.setBackground(new Color(182, 208, 252));
		btnnhavien.setBounds(30, 26, 194, 48);
		contentPane.add(btnnhavien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 139, 1184, 471);
		contentPane.add(scrollPane);
		
		model= new DefaultTableModel();
		model=new DefaultTableModel();
		model.addColumn("Mã NV");
		model.addColumn("Họ Tên ");
		model.addColumn("SĐT");
		model.addColumn("CMND");
		model.addColumn("Địa Chỉ");
		model.addColumn("Chức Vụ");
		model.addColumn("Giới Tính");
		model.addColumn("Ngày Sinh");
		model.addColumn("Ngày Vào Làm");
		model.addColumn("Trạng Thái Làm Việc");
		model.addColumn("Password");
		table = new JTable(model);
		 
		scrollPane.setViewportView(table);
		nvdao = new nhanVienDAO();
		for (nhanVien nv : nvdao.getAllnhanvien()) {
			Object []obj= {nv.getManv(),nv.getTennv(),nv.getSdt(),nv.getCmnd(),nv.getDiachi(),nv.getChucvu(),nv.getGioitinh(),nv.getNgaysinh(),nv.getNgayvaolam(),nv.getTrangthailamviec(),nv.getPassword()};
			model.addRow(obj);
			
		}
		
		JButton btnThem = new JButton("Thêm");
		
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(1294, 453, 216, 54);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row>=0) {
					String manv= (String) table.getValueAt(row, 0);
					if(nhanVienDAO.delete(manv)) {
						model.removeRow(row);
						
					}
				}
				
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(1593, 453, 216, 54);
		contentPane.add(btnXoa);
	
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(1294, 556, 216, 54);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(1593, 556, 216, 54);
		contentPane.add(btnLuu);
		
		JButton Close = new JButton("Thoát");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		Close.setBounds(1502, 630, 89, 42);
		contentPane.add(Close);
		
		JLabel lblNewLabel_1 = new JLabel("Mã Nhân Viên :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1303, 120, 113, 34);
		contentPane.add(lblNewLabel_1);
		
		txtmanv = new JTextField();
		txtmanv.setBounds(1412, 129, 98, 20);
		contentPane.add(txtmanv);
		txtmanv.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Nhân Viên :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(1531, 120, 113, 34);
		contentPane.add(lblNewLabel_1_1);
		
		txttenNV = new JTextField();
		txttenNV.setColumns(10);
		txttenNV.setBounds(1644, 129, 165, 20);
		contentPane.add(txttenNV);
		
		JLabel lblNewLabel_1_2 = new JLabel("SĐT :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(1303, 165, 98, 34);
		contentPane.add(lblNewLabel_1_2);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(1390, 174, 120, 20);
		contentPane.add(txtsdt);
		
		JLabel lblNewLabel_1_3 = new JLabel("Căn Cước :");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3.setBounds(1531, 165, 98, 34);
		contentPane.add(lblNewLabel_1_3);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(1644, 174, 165, 20);
		contentPane.add(txtcmnd);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Địa Chỉ :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1.setBounds(1303, 210, 89, 34);
		contentPane.add(lblNewLabel_1_2_1);
		
		txtdiachi = new JTextField();
		txtdiachi.setColumns(10);
		txtdiachi.setBounds(1390, 219, 120, 20);
		contentPane.add(txtdiachi);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Chức Vụ");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_3_1.setBounds(1531, 210, 98, 34);
		contentPane.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Giới Tính :");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(1303, 244, 98, 48);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		
		 rdbtnam = new JRadioButton("Nam");
		rdbtnam.setBackground(new Color(182, 208, 252));
		rdbtnam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnam.setSelected(true);
		rdbtnam.setBounds(1423, 258, 67, 23);
		contentPane.add(rdbtnam);
		
		 rdbtnnu = new JRadioButton("Nữ");
		rdbtnnu.setBackground(new Color(182, 208, 252));
		rdbtnnu.setSelected(true);
		rdbtnnu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnnu.setBounds(1492, 258, 78, 23);
		contentPane.add(rdbtnnu);
		
		
		ButtonGroup btngioitinh= new ButtonGroup();
		btngioitinh.add(rdbtnam);
		btngioitinh.add(rdbtnnu);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Ngày Vào Làm :");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2.setBounds(1296, 381, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_1.setBounds(1593, 381, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_1);
		
		JLabel lblNewLabel_1_2_1_2_2_2 = new JLabel("Trạng Thái Làm Việc :");
		lblNewLabel_1_2_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_2.setBounds(1300, 302, 173, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_2);
		
		JRadioButton rdbdangLamViec = new JRadioButton("Đang Làm Việc");
		rdbdangLamViec.setBackground(new Color(182, 208, 252));
		rdbdangLamViec.setBounds(1303, 337, 173, 42);
		contentPane.add(rdbdangLamViec);
		
		JRadioButton rdbdNghiViec = new JRadioButton("Nghỉ Việc");
		rdbdNghiViec.setBackground(new Color(182, 208, 252));
		rdbdNghiViec.setBounds(1502, 337, 173, 42);
		contentPane.add(rdbdNghiViec);
		
		JDateChooser dateeNgayVaoLam = new JDateChooser();
		dateeNgayVaoLam.setBounds(1416, 398, 141, 20);
		contentPane.add(dateeNgayVaoLam);
		dateeNgayVaoLam.setDate(Calendar.getInstance().getTime());
		JDateChooser dateeNgaySinhh = new JDateChooser();
		dateeNgaySinhh.setBounds(1688, 398, 141, 20);
		contentPane.add(dateeNgaySinhh);
		
		JComboBox txtcomboBox = new JComboBox();
		txtcomboBox.setBounds(1645, 218, 164, 22);
		contentPane.add(txtcomboBox);
//			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nước CoCa", "Nước Nước Pepsi", "Nước 7UP", "Cà Phê", "Bạc Xĩu", "Bia Heneiken", "Bia Sài Gòn Bạc", "Bia 333"}));
			txtcomboBox.addItem("Quản lí");
			txtcomboBox.addItem("Nhân viên thu ngân");
			txtcomboBox.addItem("Nhân viên hành lý và đứng cửa");
			txtcomboBox.addItem("Nhân viên đặt phòng");
			txtcomboBox.addItem("Nhân viên trực tổng đài ");
			txtcomboBox.addItem("Nhân viên lễ tân");
			txtcomboBox.addItem("Nhân viên phục vụ");
			txtcomboBox.addItem("Nhân viên pha chế");
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String maNV = txtmanv.getText().toString();
					String tenNV = txttenNV.getText().toString();
					String sdt = txtsdt.getText().toString();
					String cccd = txtcmnd.getText().toString();
					String diachi = txtdiachi.getText().toString();
					String chucvu = txtcomboBox.getSelectedItem().toString();
					String gioiTinh ="";
					if(rdbtnam.isSelected()) {
						gioiTinh+="Nam";
					}
					if(rdbtnnu.isSelected()) {
						gioiTinh+="Nữ";
					}
					
					String trangthai="Đang làm việc";
					String loaiKH = "111";
					
					 
					// lay ngay thang
					
					Date datevaolam = dateeNgayVaoLam.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDatevaolam = dateFormat.format(datevaolam);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
					
					
					//lay ngay sinh
					
					Date dateengaysinh= dateeNgaySinhh.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					 
					String strDatengaysinh = dateFormat.format(dateengaysinh);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
					if(validData()) {
						nhanVien nv = new nhanVien(maNV, tenNV, sdt, cccd, diachi, chucvu, gioiTinh, sqlDatengaysinh, sqlDatevaolam, trangthai, "1");
						
						if(nvdao.themDanhSachNV(nv)) {
							Object []obj= {maNV, tenNV, sdt, cccd, diachi, chucvu, gioiTinh, sqlDatengaysinh, sqlDatevaolam, trangthai, "1"};
							model.addRow(obj);
						}
						riphet();						
					}
//						
						
//						nvdao.getAllnhanvien();
								 
				}  catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
	table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				txtmanv.setText(model.getValueAt(row, 0).toString());
				txttenNV.setText(model.getValueAt(row, 1).toString());
				txtsdt.setText(model.getValueAt(row, 2).toString());
				
//				if(model.getValueAt(row, 4).toString().equalsIgnoreCase("Nam")) {
//					phaiNam.setSelected(true);
//					phaiNu.setSelected(false);
//				}else {
//					phaiNam.setSelected(false);
//					phaiNu.setSelected(true);
//				}
			 
				SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
				Date date;
				 
//				 
				txtcmnd.setText(model.getValueAt(row, 3).toString());
				txtdiachi.setText(model.getValueAt(row, 4).toString());
				txtcomboBox.setSelectedItem(model.getValueAt(row, 5).toString());
//				txtemail.setText();
				
				try {
					date = format.parse(model.getValueAt(row,7).toString());
					dateeNgaySinhh.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					date = format.parse(model.getValueAt(row,8).toString());
					dateeNgayVaoLam.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(model.getValueAt(row, 7).toString().equalsIgnoreCase("Nam")) {
					rdbtnam.setSelected(true);
					rdbtnnu.setSelected(false);
				}else {
					rdbtnam.setSelected(false);
					rdbtnnu.setSelected(true);
				}
				if(model.getValueAt(row, 9).toString().equalsIgnoreCase("Đang Làm Việc")) {
					rdbdangLamViec.setSelected(true);
					rdbdNghiViec.setSelected(false);
				}else {
					rdbdangLamViec.setSelected(false);
					rdbdNghiViec.setSelected(true);
				}
//				txtemail.setText(model.getValueAt(row, 7).toString());
//				txtemail.setText(model.getValueAt(row, 8).toString());
				
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
	 public DefaultTableModel getModel() {
	        return model;
	    }
	 
	 private boolean validData() {
		 String maNV = txtmanv.getText().toString();
			String tenNV = txttenNV.getText().toString();
			String sdt = txtsdt.getText().toString();
			String cccd = txtcmnd.getText().toString();
			String diachi = txtdiachi.getText().toString();
//			String chucvu = txtcomboBox.getSelectedItem().toString();
//			String gioiTinh = cbogioiTinh.getSelectedItem().toString();
			String gioiTinh ="";
			if(rdbtnam.isSelected()) {
				gioiTinh+="Nam";
			}
			if(rdbtnnu.isSelected()) {
				gioiTinh+="Nữ";
			}
			
			String trangthai="CTT";
			String loaiKH = "111";
			 
			 
			// lay ngay thang
			
			Date datevaolam = dateeNgayVaoLam.getDate();

			// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDatevaolam = dateFormat.format(datevaolam);

			// Chuyển đổi chuỗi thành kiểu java.sql.Date
			java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
			
			
			//lay ngay sinh
			
			Date datengaysinh= dateengaysinh.getDate();

			// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
			 
			String strDatengaysinh = dateFormat.format(datengaysinh);

			// Chuyển đổi chuỗi thành kiểu java.sql.Date
			java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
			
				nhanVien nv = new nhanVien(maNV, tenNV, sdt, cccd, diachi, null, gioiTinh, sqlDatengaysinh, sqlDatevaolam, trangthai, "1");
				
				if(nvdao.themDanhSachNV(nv)) {
					Object []obj= {maNV, tenNV, sdt, cccd, diachi, null, gioiTinh, sqlDatengaysinh, sqlDatevaolam, trangthai, "1"};
					model.addRow(obj);
				}
//				
				
//				nvdao.getAllnhanvien();
			
//			if(!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
//				JOptionPane.showMessageDialog(this, "Error: ma sach theo mau : [A-Z]\\d{3}");
//				return false;
//			}
			if(!(maNV.length() >0 && maNV.matches("[a-zA-Z' ]+"))) {
//					JOp ( "Error: Ten nv khong duoc de trong ",tenKH);
					JOptionPane.showMessageDialog(null, "Error: Tên nhân viên không được để trống");
					return false;
				}
			if(!(tenNV.length() >0 && tenNV.matches("[a-zA-Z' ]+"))) {
//				JOp ( "Error: Ten nv khong duoc de trong ",tenKH);
				JOptionPane.showMessageDialog(null, "Error: Tên nhân viên không được để trống");
				return false;
			}
			if(!(sdt.length() >0 && sdt.matches("^[0]+\\d{9}"))) {
//				showMessage( "Error: Số điện thoại phải gồm 10 số ",sdt);
				JOptionPane.showMessageDialog(null, "Error:  Số điện thoại phải gồm 10 số");
				return false;
			}
			if(!(cccd.length() >0 && cccd.matches("\\d{12}"))) {
//				showMessage( "Error: Số điện thoại phải gồm 10 số ",cccd);
				JOptionPane.showMessageDialog(null, "Error:  CCCD phải gồm 12 số");
				return false;
			}
			if(!(diachi.length() >0 && diachi.matches("\"[a-zA-Z' ]+\""))) {
				JOptionPane.showMessageDialog(null, "Error:  Địa chỉ không được để trống");
				return false;
			}
			return true;
	 }
	public void riphet() {
			List<nhanVien>dsctt=nvdao.getAllnhanvien();
			
			model.getDataVector().removeAllElements();
			for (nhanVien nv : dsctt) {
				String []obj= {nv.getManv(),nv.getTennv(),nv.getSdt(),nv.getCmnd(),nv.getDiachi(),nv.getChucvu(),nv.getGioitinh(),nv.getNgaysinh()+"",nv.getNgayvaolam()+"",nv.getTrangthailamviec(), nv.getPassword()};
				
				model.addRow(obj);
			}
			table.setModel(model);
		}
}
