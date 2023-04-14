package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

import DAO.khachHangDAO;
import database.ConnectDB;
import entity.KhachHang;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;
import java.awt.event.ActionEvent;

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
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1399, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 139, 1212, 478);
		contentPane.add(scrollPane);
		
		model=new DefaultTableModel();
		model.addColumn("Mã KH");
		model.addColumn("Têm KH");
		model.addColumn("SĐT");
		model.addColumn("CMND");
		model.addColumn("Email");
		model.addColumn("Ngày Thuê");
		model.addColumn("Ngày Sinh");
		model.addColumn("Giới Tính");
		model.addColumn("Loại Khách");
		model.addColumn("Số Phòng");
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
			Object []obj= {kh.getMakh(),kh.getHoten(),kh.getSdt(),kh.getCmnd(),kh.getEmail(),kh.getNgaydky(),kh.getNgaysinh(),kh.getGioitinh(),kh.getMaloaiKhachHang(),kh.getSoPhong()};
			model.addRow(obj);
			
		}
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame f=new JFrame();
				f.setBounds(100, 100, 761, 507);
        		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		f.getContentPane().setLayout(null);
        		f.setLocationRelativeTo(null);
        		f.setSize(700,700);
				
				JLabel lblNewLabel = new JLabel("Thông tin Khách Hàng");
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
				lblNewLabel.setBounds(40, 34, 321, 63);
				f.getContentPane().add(lblNewLabel);
				
				JLabel lblmanv = new JLabel("Mã Nhân Viên");
				lblmanv.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblmanv.setBounds(39, 108, 114, 31);
				f.getContentPane().add(lblmanv);
				
				txtma = new JTextField();
				txtma.setBounds(163, 110, 380, 31);
				f.getContentPane().add(txtma);
				txtma.setColumns(10);
				
				JLabel lbltennv = new JLabel("Tên Nhân Viên");
				lbltennv.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lbltennv.setBounds(39, 150, 114, 31);
				f.getContentPane().add(lbltennv);
				
				txtten = new JTextField();
				txtten.setColumns(10);
				txtten.setBounds(163, 152, 380, 31);
				f.getContentPane().add(txtten);
				
				JLabel lblSdt = new JLabel("SĐT");
				lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblSdt.setBounds(39, 192, 114, 31);
				f.getContentPane().add(lblSdt);
				
				txtSDT = new JTextField();
				txtSDT.setColumns(10);
				txtSDT.setBounds(163, 194, 380, 31);
				f.getContentPane().add(txtSDT);
				
				JLabel lblCmnd = new JLabel("CMND");
				lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblCmnd.setBounds(40, 234, 114, 31);
				f.getContentPane().add(lblCmnd);
				
				txtCMND = new JTextField();
				txtCMND.setColumns(10);
				txtCMND.setBounds(163, 236, 380, 31);
				f.getContentPane().add(txtCMND);
				
				JLabel lblngaythue = new JLabel("Ngày Thuê");
				lblngaythue.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblngaythue.setBounds(39, 318, 114, 31);
				f.getContentPane().add(lblngaythue);
				
				txtngayThue = new JTextField();
				txtngayThue.setColumns(10);
				txtngayThue.setBounds(163, 320, 380, 31);
				f.getContentPane().add(txtngayThue);
				
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblEmail.setBounds(39, 276, 114, 31);
				f.getContentPane().add(lblEmail);
				
				txtEmail = new JTextField();
				txtEmail.setColumns(10);
				txtEmail.setBounds(163, 278, 380, 31);
				f.getContentPane().add(txtEmail);
				
				JLabel lblngaysinh = new JLabel("Ngày Sinh");
				lblngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblngaysinh.setBounds(39, 369, 114, 31);
				f.getContentPane().add(lblngaysinh);
				
				JRadioButton rdbtnNam = new JRadioButton("Nam");
				rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNam.setBounds(169, 426, 109, 23);
				f.getContentPane().add(rdbtnNam);
				
				JRadioButton rdbtnNu = new JRadioButton("Nữ");
				rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
				rdbtnNu.setBounds(296, 426, 109, 23);
				contentPane.add(rdbtnNu);
				
				txtngaySinh = new JTextField();
				txtngaySinh.setColumns(10);
				txtngaySinh.setBounds(163, 367, 380, 31);
				f.getContentPane().add(txtngaySinh);
				
				JLabel lblGioiTinh = new JLabel("Giới Tính");
				lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
				lblGioiTinh.setBounds(39, 418, 114, 31);
				f.getContentPane().add(lblGioiTinh);
				
			 
				
				
//				
				 SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.HOUR_OF_DAY);

			        // Tạo JSpinner và thiết lập model cho nó
			         spinner = new JSpinner(dateModel);

			        // Định dạng ngày giờ
			        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy ");
			        spinner.setEditor(dateEditor);
			        f.getContentPane().add(spinner);
			        
			        JLabel lblloaikhach = new JLabel("Loại Khách");
			        lblloaikhach.setFont(new Font("Tahoma", Font.PLAIN, 16));
			        lblloaikhach.setBounds(40, 475, 114, 31);
			        f.getContentPane().add(lblloaikhach);
			        
			        txtLoaikhach = new JTextField();
			        txtLoaikhach.setColumns(10);
			        txtLoaikhach.setBounds(163, 475, 380, 31);
			        f.getContentPane().add(txtLoaikhach);
			        
			        JLabel lblsoPhong = new JLabel("Số Phòng");
			        lblsoPhong.setFont(new Font("Tahoma", Font.PLAIN, 16));
			        lblsoPhong.setBounds(39, 527, 114, 31);
			        f.getContentPane().add(lblsoPhong);
			        
			        JTextField txtsoPhong = new JTextField();
			        txtsoPhong.setColumns(10);
			        txtsoPhong.setBounds(163, 527, 380, 31);
			        f.getContentPane().add(txtsoPhong);
			        
			        btnThemnv = new JButton("Thêm");
			        btnThemnv.addActionListener(new ActionListener() {
			        	public void actionPerformed(ActionEvent e) {
			        		
			        		NhanVienUI nv=new NhanVienUI();
			        		
			        		String []obj= {txtma.getText(),txtten.getText(),txtSDT.getText(),txtCMND.getText(),txtngayThue.getText(),txtEmail.getText(),txtngaySinh.getText(),rdbtnNam.getText(),txtsoPhong.getText(),txtLoaikhach.getText() };
			        		model.addRow(obj);;
			        	}
			        });
			        btnThemnv.setFont(new Font("Tahoma", Font.PLAIN, 18));
			        btnThemnv.setBounds(40, 588, 133, 51);
			        f.getContentPane().add(btnThemnv);
			        
			        JButton btnThoat = new JButton("Thoát");
			        btnThoat.addActionListener(new ActionListener() {
			        	public void actionPerformed(ActionEvent e) {
			        		f.setVisible(false);
			        	}
			        });
			        btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
			        btnThoat.setBounds(228, 588, 133, 51);
			        f.getContentPane().add(btnThoat);
			        
			        f.setVisible(true);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(129, 659, 216, 54);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(383, 659, 216, 54);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(630, 659, 216, 54);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(889, 659, 216, 54);
		contentPane.add(btnLuu);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(KhachhangUI.class.getResource("/img/man-icon.png")));
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnKhchHng.setBorderPainted(false);
		btnKhchHng.setBackground(new Color(242, 208, 183));
		btnKhchHng.setBounds(74, 31, 194, 48);
		contentPane.add(btnKhchHng);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1183, 659, 89, 54);
		contentPane.add(btnNewButton);
		
		
	}
}
