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
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import java.time.LocalDate;
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
		contentPane.setBackground(new Color(242, 208, 183));
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
 
		model.addColumn("Trạng Thái");
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
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(1560, 544, 216, 54);
		contentPane.add(btnLuu);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(KhachhangUI.class.getResource("/img/man-icon.png")));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKhchHng.setBorderPainted(false);
		btnKhchHng.setBackground(new Color(242, 208, 183));
		btnKhchHng.setBounds(74, 31, 194, 48);
		contentPane.add(btnKhchHng);
		
		JLabel lblNewLabel_1 = new JLabel("Mã KH :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(1301, 71, 67, 48);
		contentPane.add(lblNewLabel_1);
		
		txtmakh = new JTextField();
		txtmakh.setBounds(1374, 87, 102, 20);
		contentPane.add(txtmakh);
		txtmakh.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Họ và tên KH :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(1497, 71, 99, 48);
		contentPane.add(lblNewLabel_1_1);
		
		txthovaten = new JTextField();
		txthovaten.setColumns(10);
		txthovaten.setBounds(1602, 87, 174, 20);
		contentPane.add(txthovaten);
		
		txtsdt = new JTextField();
		txtsdt.setColumns(10);
		txtsdt.setBounds(1374, 137, 102, 20);
		contentPane.add(txtsdt);
		
		JLabel lblNewLabel_1_2 = new JLabel("SĐT :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(1303, 121, 67, 48);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CMND :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(1497, 121, 99, 48);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtcmnd = new JTextField();
		txtcmnd.setColumns(10);
		txtcmnd.setBounds(1602, 137, 174, 20);
		contentPane.add(txtcmnd);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Email :");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_1.setBounds(1301, 168, 67, 48);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(1378, 184, 174, 20);
		contentPane.add(txtemail);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Giới Tính :");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(1585, 168, 67, 48);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		
		JRadioButton rdbtnam = new JRadioButton("Nam");
		rdbtnam.setBackground(new Color(242, 208, 183));
		rdbtnam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnam.setSelected(true);
		rdbtnam.setBounds(1662, 182, 78, 23);
		contentPane.add(rdbtnam);
		
		JRadioButton rdbtnnu = new JRadioButton("Nữ");
		rdbtnnu.setBackground(new Color(242, 208, 183));
		rdbtnnu.setSelected(true);
		rdbtnnu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnnu.setBounds(1740, 182, 78, 23);
		contentPane.add(rdbtnnu);
		
		
		ButtonGroup btngioitinh= new ButtonGroup();
		btngioitinh.add(rdbtnam);
		btngioitinh.add(rdbtnnu);
		
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Ngày Nhận Phòng :");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2.setBounds(1301, 219, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2);
		
		JCalendar calendarNgayVaoLam = new JCalendar();
		calendarNgayVaoLam.setBounds(1298, 269, 198, 153);
		contentPane.add(calendarNgayVaoLam);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_1.setBounds(1531, 227, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_1);
		
		JCalendar calendarNgaySinh = new JCalendar();
		calendarNgaySinh.setBounds(1531, 269, 198, 153);
		contentPane.add(calendarNgaySinh);
		
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
					
					Date datevaolam = calendarNgayVaoLam.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDatevaolam = dateFormat.format(datevaolam);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
					
					
					//lay ngay sinh
					
					Date datengaysinh= calendarNgaySinh.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					 
					String strDatengaysinh = dateFormat.format(datengaysinh);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
					
					
					//
					 
//							 
								KhachHang kh = new KhachHang(maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai);
								khachHangDAO.themDanhSachKH(kh);
//								 
								Object []obj= {maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai};
								model.addRow(obj);

								 
				}  catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(1301, 457, 113, 54);
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
		btnXoa.setBounds(1439, 457, 113, 54);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row=table.getSelectedRow();
				
				if(row>0) {
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
					
					Date datevaolam = calendarNgayVaoLam.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String strDatevaolam = dateFormat.format(datevaolam);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatevaolam = java.sql.Date.valueOf(strDatevaolam);
					
					
					//lay ngay sinh
					
					Date datengaysinh= calendarNgaySinh.getDate();

					// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
					 
					String strDatengaysinh = dateFormat.format(datengaysinh);

					// Chuyển đổi chuỗi thành kiểu java.sql.Date
					java.sql.Date sqlDatengaysinh = java.sql.Date.valueOf(strDatengaysinh);
					
					
					KhachHang kh = new KhachHang(maKH, tenKH,  sdt, cccd,email,  sqlDatevaolam,sqlDatengaysinh,gioiTinh,loaiKH,trangthai);
					
					
					if(khachHangDAO.update(kh)) {
						
						table.setValueAt(txthovaten, row, 1);
						table.setValueAt(txtsdt, row, 2);
						table.setValueAt(txtcmnd, row, 3);
						table.setValueAt(txtemail, row, 4);
						table.setValueAt(calendarNgayVaoLam.getDate(), row, 5);
						table.setValueAt(calendarNgaySinh,row,6);
//						table.setValueAt(txthovaten, row, 8);
//						table.setValueAt(txthovaten, row, 9);
						
						
					}
				}
			}
		});
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(1587, 457, 89, 54);
		contentPane.add(btnSua);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThoat.setBounds(1707, 458, 89, 54);
		contentPane.add(btnThoat);
		
		JButton btnNewButton = new JButton("Loc Theo Trang Thai");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1307, 545, 189, 54);
		contentPane.add(btnNewButton);
		
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
					calendarNgayVaoLam.setDate(date);
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
					calendarNgaySinh.setDate(date);
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
}
