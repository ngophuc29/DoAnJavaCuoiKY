package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

import DAO.khachHangDAO;
import database.ConnectDB;
import entity.KhachHang;
 
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.time.LocalDate;
import com.toedter.calendar.JDateChooser;
public class KhachhangUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	
	
	//
	
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtEmail;
	private JTextField txtngayThue;
	private JTextField txtngaySinh;
	JSpinner spinner;
	private JTextField txtgioitinh;
	private JTextField txtLoaikhach;
	private JTextField soPhong;
	private JButton btnThemnv;
	
	private khachHangDAO KHdao;
	private JTextField txtmakh;
	private JTextField txthovaten;
	private JTextField txtsdt;
	private JTextField txtcmnd;
	private JTextField txtemail;
	private JRadioButton rdbtnam ;
	private JRadioButton rdbtnnu;
	
	private JDateChooser dateNhanPhong;
	private JDateChooser datangaysinh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KhachhangUI frame = new KhachhangUI();
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
	public KhachhangUI() {
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1834, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 208, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 139, 1212, 476);
		 
		contentPane.add(scrollPane);
		
		model=new DefaultTableModel();
		model.addColumn("Mã KH");
		model.addColumn("Tên KH");
		model.addColumn("SĐT");
		model.addColumn("CMND");
		model.addColumn("Email");
		model.addColumn("Ngày Thuê");
		model.addColumn("Ngày Sinh");
		model.addColumn("Giới Tính");
		model.addColumn("Loại Khách");
 
//		model.addColumn("Trạng Thái");
//		table = new JTable(model =new DefaultTableModel(
//			new Object[][] {
//				{"A01", "Nguy\u1EC5n Tunn", "0987654321", "89389231", "tuannguyn@gmail.com", "1/4/2023", "29/1/1998", "Nam", "Vip", "301"},
//				{"A02", "Nguyễn Thúy Vy", "0873168712", "77823913", "vynguyen@gmail.com", "2/4/2023", "4/5/1998", "Nu", "Vip", "302"},
//				{"A03", "Phan Văn Hoàn", "091241241", "31244421414", "hoanPhan@gmail.com", "3/4/2023", "29/5/1991", "Nam", "Vip", "303"},
//				{"B01", "Phan Văn Phú", "097137124", "41341414", "phuphan@gmail.com", "5/4/2023", "29/6/1994", "Nam", "Thường", "103"},
//				 
//				{"B02", "Nguyễn Gia Bảo", "091841419", "79187498", "baonguyen@gmail.com", "5/4/2023", "29/6/1995", "Nam", "Thường", "201"},
//			},
//			new String[] {
//				"M\u00E3 Kh", "H\u1ECD V\u00E0 T\u00EAn", "S\u0110T", "CMND", "Email", "Ng\u00E0y Thu\u00EA", "Ng\u00E0y Sinh", "Gi\u1EDBi T\u00EDnh", "Lo\u1EA1i Kh\u00E1ch", "S\u1ED1 Ph\u00F2ng"
//			}
//		));
		table= new JTable(model);
		 
		scrollPane.setViewportView(table);
		
		KHdao = new khachHangDAO();
		for (KhachHang kh : KHdao.getAllKH()) {
			Object []obj= {kh.getMakh(),kh.getHoten(),kh.getSdt(),kh.getCmnd(),kh.getEmail(),kh.getNgaydky(),kh.getNgaysinh(),kh.getGioitinh(),kh.getMaloaiKhachHang(), kh.getTrangthai()};
			model.addRow(obj);
			
		}
//		ListSelectionModel selectionModel = table.getSelectionModel();
//        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        selectionModel.addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent e) {
//                if (!e.getValueIsAdjusting()) {
//                    int selectedRow = table.getSelectedRow();
//                    if (selectedRow != -1) {
//                        // Lấy dữ liệu từ JTable
//                        String firstName = (String) table.getValueAt(selectedRow, 0);
//                        String lastName = (String) table.getValueAt(selectedRow, 1);
//                        String lastName1 = (String) table.getValueAt(selectedRow, 2);
//
//                        // Tạo JFrame mới và hiển thị dữ liệu
//                        JFrame newFrame = new JFrame("Selected Row Data");
//                        JLabel label = new JLabel(firstName + " " + lastName + ", " + lastName1 + " years old");
//                        newFrame.getContentPane().add(label);
//                        newFrame.pack();
//                        newFrame.setLocationRelativeTo(null);
//                        newFrame.setVisible(true);
//                    }
//                }
//            }
//        });
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(1602, 465, 200, 54);
		contentPane.add(btnLuu);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(KhachhangUI.class.getResource("/img/man-icon.png")));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKhchHng.setBorderPainted(false);
		btnKhchHng.setBackground(new Color(182, 208, 252));
		btnKhchHng.setBounds(74, 31, 194, 48);
		contentPane.add(btnKhchHng);
		
		txtmakh = new JTextField();
		txtmakh.setBounds(1307, 31, -6, -3);
		contentPane.add(txtmakh);
		txtmakh.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên KH :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(1306, 92, 99, 48);
		contentPane.add(lblNewLabel_1_1);
		
		txthovaten = new JTextField();
		txthovaten.setColumns(10);
		txthovaten.setBounds(1415, 103, 274, 30);
		contentPane.add(txthovaten);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(1415, 177, 212, 30);
		contentPane.add(txtsdt);
		
		JLabel lblNewLabel_1_2 = new JLabel("SĐT :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(1310, 166, 67, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CMND :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(1307, 131, 67, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(1415, 139, 174, 30);
		contentPane.add(txtcmnd);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(1310, 207, 67, 48);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(1415, 213, 174, 30);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Giới Tính :");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(1614, 207, 67, 48);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		
		 rdbtnam = new JRadioButton("Nam");
		rdbtnam.setBackground(new Color(182, 208, 252));
		rdbtnam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnam.setSelected(true);
		rdbtnam.setBounds(1687, 221, 54, 23);
		contentPane.add(rdbtnam);
		
		 rdbtnnu = new JRadioButton("Nữ");
		rdbtnnu.setBackground(new Color(182, 208, 252));
		rdbtnnu.setSelected(true);
		rdbtnnu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnnu.setBounds(1748, 221, 54, 23);
		contentPane.add(rdbtnnu);
		
		
		ButtonGroup btngioitinh= new ButtonGroup();
		btngioitinh.add(rdbtnam);
		btngioitinh.add(rdbtnnu);
		
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Ngày Nhận Phòng :");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2.setBounds(1310, 247, 151, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_1.setBounds(1541, 247, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_1);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {

				try {
					String maKH = txtmakh.getText();
					String tenKH = txthovaten.getText().toString();
					String sdt = txtsdt.getText().toString();
					String cccd = txtcmnd.getText().toString();
					String email = txtemail.getText().toString();
//					String gioiTinh = cbogioiTinh.getSelectedItem().toString();
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
					
					Date datevaolam = dateNhanPhong.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDatevaolam = dateFormat.format(datevaolam);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
					
					
					//lay ngay sinh
					
					Date datengaysinh= datangaysinh.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					 
					String strDatengaysinh = dateFormat.format(datengaysinh);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
					
					
					//
					 
////							 
//								KhachHang kh = new KhachHang(maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai);
//								khachHangDAO.themDanhSachKH(kh);
////								 
//								Object []obj= {maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai};
//								model.addRow(obj);

					
					if(validData()) {
						KhachHang kh = new KhachHang(maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai);
						khachHangDAO.themDanhSachKH(kh);
//						 
						Object []obj= {maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai};
						model.addRow(obj);
						
riphet();
					}
								 
				}  catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(1310, 382, 102, 54);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				if(row>=0) {
					String makh= (String) table.getValueAt(row, 0);
					if(khachHangDAO.delete(makh)) {
						model.removeRow(row);
						
					}
				}
				
				
			}
		});
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(1440, 382, 102, 54);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row=table.getSelectedRow();
				
				if(row>=0) {
					String maKH = txtmakh.getText();
					String tenKH = txthovaten.getText().toString();
					String sdt = txtsdt.getText().toString();
					String cccd = txtcmnd.getText().toString();
					String email = txtemail.getText().toString();
//					String gioiTinh = cbogioiTinh.getSelectedItem().toString();
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
					
					Date datevaolam = dateNhanPhong.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDatevaolam = dateFormat.format(datevaolam);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
					
					
					//lay ngay sinh
					
					Date datengaysinh= datangaysinh.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					 
					String strDatengaysinh = dateFormat.format(datengaysinh);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
					
					
					KhachHang kh = new KhachHang(maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai);
					
					
					if(khachHangDAO.update(kh)) {
						
						table.setValueAt(txthovaten.getText(), row, 1);
						table.setValueAt(txtsdt.getText(), row, 2);
						table.setValueAt(txtcmnd.getText(), row, 3);
						table.setValueAt(txtemail.getText(), row, 4);
						
						java.sql.Date sqlDatengaynhaphpngsua = java.sql.Date.valueOf(strDatevaolam);
						table.setValueAt(sqlDatengaynhaphpngsua, row, 5);
//						String strsuadatenhanphong = dateFormat.format(datengaysinh);
						java.sql.Date sqlDatengaysinhsua = java.sql.Date.valueOf(strDatengaysinh);
						table.setValueAt(sqlDatengaysinhsua,row,6);
//						table.setValueAt(txthovaten, row, 8);
//						table.setValueAt(txthovaten, row, 9);
						
						
					}
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(1570, 382, 102, 54);
		contentPane.add(btnSua);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(1700, 382, 102, 54);
		contentPane.add(btnThoat);
		
		JButton btnLocCTT = new JButton("Lọc Theo Trạng Thái");
		btnLocCTT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			List<KhachHang>dsctt=KHdao.KHCTT();
			
			model.getDataVector().removeAllElements();
			for (KhachHang kh : dsctt) {
				String []obj= {kh.getMakh(),kh.getHoten(),kh.getSdt(),kh.getCmnd(),kh.getEmail(),kh.getNgaydky()+"",kh.getNgaysinh()+"",kh.getGioitinh(),kh.getMaloaiKhachHang(), kh.getTrangthai()};
				
				model.addRow(obj);
			}
			table.setModel(model);
			}
		});
		btnLocCTT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLocCTT.setBounds(1310, 466, 200, 54);
		contentPane.add(btnLocCTT);
		
		JButton btntailai = new JButton("Cài lại");
		btntailai.setIcon(new ImageIcon(KhachhangUI.class.getResource("/img/Button-Load-icon.png")));
		btntailai.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				List<KhachHang>dsctt=KHdao.getAllKH();
				
				model.getDataVector().removeAllElements();
				for (KhachHang kh : dsctt) {
					String []obj= {kh.getMakh(),kh.getHoten(),kh.getSdt(),kh.getCmnd(),kh.getEmail(),kh.getNgaydky()+"",kh.getNgaysinh()+"",kh.getGioitinh(),kh.getMaloaiKhachHang(), kh.getTrangthai()};
					
					model.addRow(obj);
				}
				table.setModel(model);
				xoaRong();
			}
		});
		btntailai.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btntailai.setBounds(1151, 74, 121, 43);
		contentPane.add(btntailai);
		
		 dateNhanPhong = new JDateChooser();
		dateNhanPhong.setBounds(1310, 308, 200, 30);
		contentPane.add(dateNhanPhong);
		
		dateNhanPhong.setDate(Calendar.getInstance().getTime());
		
		 datangaysinh = new JDateChooser();
		datangaysinh.setBounds(1541, 308, 200, 30);
		contentPane.add(datangaysinh);
		
		table.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row=table.getSelectedRow();
				txtmakh.setText(model.getValueAt(row, 0).toString());
				txthovaten.setText(model.getValueAt(row, 1).toString());
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
				try {
					date = format.parse(model.getValueAt(row, 5).toString());
//					calendarNgayVaoLam.setDate(date);
					dateNhanPhong.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//				 
				txtcmnd.setText(model.getValueAt(row, 3).toString());
				txtemail.setText(model.getValueAt(row, 4).toString());
//				txtemail.setText();
				
				try {
					date = format.parse(model.getValueAt(row, 6).toString());
					datangaysinh.setDate(date);
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
	
	private boolean validData() {
		String maKH = txtmakh.getText();
		String tenKH = txthovaten.getText().toString();
		String sdt = txtsdt.getText().toString();
		String cccd = txtcmnd.getText().toString();
		String email = txtemail.getText().toString();
//		String gioiTinh = cbogioiTinh.getSelectedItem().toString();
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
		
		Date datevaolam = dateNhanPhong.getDate();

		// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDatevaolam = dateFormat.format(datevaolam);

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
		
		
		//lay ngay sinh
		
		Date datengaysinh= datangaysinh.getDate();

		// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
		 
		String strDatengaysinh = dateFormat.format(datengaysinh);

		// Chuyển đổi chuỗi thành kiểu java.sql.Date
		java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
		
//		if(!(maSach.length() > 0 && maSach.matches("[A-Z]\\d{3}"))) {
//			JOptionPane.showMessageDialog(this, "Error: ma sach theo mau : [A-Z]\\d{3}");
//			return false;
//		}
		if(!(tenKH.length() >0 && tenKH.matches("[a-zA-Z' ]+"))) {
//			JOp ( "Error: Ten Kh khong duoc de trong ",tenKH);
			JOptionPane.showMessageDialog(null, "Error: Ten Kh khong duoc de trong");
			return false;
		}
		if(!(sdt.length() >0 && sdt.matches("^[0]+\\d{9}"))) {
//			showMessage( "Error: Số điện thoại phải gồm 10 số ",sdt);
			JOptionPane.showMessageDialog(null, "Error:  Số điện thoại phải gồm 10 số");
			return false;
		}
		if(!(cccd.length() >0 && cccd.matches("\\d{12}"))) {
//			showMessage( "Error: Số điện thoại phải gồm 10 số ",cccd);
			JOptionPane.showMessageDialog(null, "Error:  CCCD phải gồm 12 số");
			return false;
		}
		if(!(email.length() >0 && email.matches("[a-zA-Z0-9]+@[+a-zA-Z]+(.com)"))) {
//			showMessage( "Error: Số điện thoại phải gồm 10 số ",email);
			JOptionPane.showMessageDialog(null, "Error:  Định dạng email không hợp lệ");
			return false;
		}
//
		
		return true;
	}

	private void showMessage(String string, String tenKH) {
		// TODO Auto-generated method stub
		
	}
	
	public void riphet() {
		List<KhachHang>dsctt=KHdao.getAllKH();
		
		model.getDataVector().removeAllElements();
		for (KhachHang kh : dsctt) {
			String []obj= {kh.getMakh(),kh.getHoten(),kh.getSdt(),kh.getCmnd(),kh.getEmail(),kh.getNgaydky()+"",kh.getNgaysinh()+"",kh.getGioitinh(),kh.getMaloaiKhachHang(), kh.getTrangthai()};
			
			model.addRow(obj);
		}
		table.setModel(model);
	}
	
	private void xoaRong() {
		txtmakh.setText("");
		txthovaten.setText("");
		txtsdt.setText("");
		txtcmnd.setText("");
		txtemail.setText("");
		rdbtnam.setSelected(true);
		rdbtnnu.setSelected(false);
	}
}

