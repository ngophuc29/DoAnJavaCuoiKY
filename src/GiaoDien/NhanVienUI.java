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
import java.util.Date;
import java.awt.event.ActionEvent;

public class NhanVienUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	
	//
	
	private JPanel contentPane1;
	private JTextField txtma;
	private JTextField txtten;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtchucvu;
	JSpinner spinner;
	private JTextField txtNgayVaoLam;
	private JTextField txtngaySinh;
	private JTextField txtTrangThai;
	private JButton btnThemnv;
	private nhanVienDAO nvdao;
	private JTextField txtmanv;
	private JTextField txttenNV;
	private JTextField txtsdt;
	private JTextField txtcmnd;
	private JTextField txtdiachi;
	private JTextField txtchucvuu;
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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnnhavien = new JButton("Nhân viên");
		btnnhavien.setIcon(new ImageIcon(NhanVienUI.class.getResource("/img/Administrator-icon.png")));
		btnnhavien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnnhavien.setBorderPainted(false);
		btnnhavien.setBackground(new Color(242, 208, 183));
		btnnhavien.setBounds(30, 26, 194, 48);
		contentPane.add(btnnhavien);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 139, 1212, 478);
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
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				FrmThemNhanVien tnv= new FrmThemNhanVien();
//				tnv.setVisible(true);  JPanel contentPane1;

            	Object o=e.getSource();
            	
            	JFrame frame  = new JFrame();
             
        		frame.setBounds(100, 100, 761, 507);
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.getContentPane().setLayout(null);
        		frame.setLocationRelativeTo(null);
        		frame.setSize(700,800);
        		
//        		frame.getContentPane()
        		JLabel lblNewLabel = new JLabel("Thông tin Nhân Viên");
        		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        		lblNewLabel.setBounds(40, 34, 213, 63);
        		frame.getContentPane().add(lblNewLabel);
        		
        		JLabel lblmanv = new JLabel("Mã Nhân Viên");
        		lblmanv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblmanv.setBounds(39, 108, 114, 31);
        		frame.getContentPane().add(lblmanv);
        		
        		txtma = new JTextField();
        		txtma.setBounds(163, 110, 380, 31);
        		frame.getContentPane().add(txtma);
        		txtma.setColumns(10);
        		
        		JLabel lbltennv = new JLabel("Tên Nhân Viên");
        		lbltennv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lbltennv.setBounds(39, 150, 114, 31);
        		frame.getContentPane().add(lbltennv);
        		
        		txtten = new JTextField();
        		txtten.setColumns(10);
        		txtten.setBounds(163, 152, 380, 31);
        		frame.getContentPane().add(txtten);
        		
        		JLabel lblSdt = new JLabel("SĐT");
        		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblSdt.setBounds(39, 192, 114, 31);
        		frame.getContentPane().add(lblSdt);
        		
        		txtSDT = new JTextField();
        		txtSDT.setColumns(10);
        		txtSDT.setBounds(163, 194, 380, 31);
        		frame.getContentPane().add(txtSDT);
        		
        		JLabel lblCmnd = new JLabel("CMND");
        		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblCmnd.setBounds(40, 234, 114, 31);
        		frame.getContentPane().add(lblCmnd);
        		
        		txtCMND = new JTextField();
        		txtCMND.setColumns(10);
        		txtCMND.setBounds(163, 236, 380, 31);
        		frame.getContentPane().add(txtCMND);
        		
        		JLabel lbldiachi = new JLabel("Địa chỉ");
        		lbldiachi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lbldiachi.setBounds(39, 276, 114, 31);
        		frame.getContentPane().add(lbldiachi);
        		
        		txtDiaChi = new JTextField();
        		txtDiaChi.setColumns(10);
        		txtDiaChi.setBounds(163, 283, 380, 31);
        		frame.getContentPane().add(txtDiaChi);
        		
        		JLabel lblEmail = new JLabel("Email");
        		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblEmail.setBounds(39, 318, 114, 31);
        		frame.getContentPane().add(lblEmail);
        		
        		txtEmail = new JTextField();
        		txtEmail.setColumns(10);
        		txtEmail.setBounds(163, 325, 380, 31);
        		frame.getContentPane().add(txtEmail);
        		
        		JLabel lblChucVu = new JLabel("Chức Vụ");
        		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblChucVu.setBounds(39, 369, 114, 31);
        		frame.getContentPane().add(lblChucVu);
        		
        		JRadioButton rdbtnNam = new JRadioButton("Nam");
        		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		rdbtnNam.setBounds(169, 426, 109, 23);
        		frame.getContentPane().add(rdbtnNam);
        		
        		JRadioButton rdbtnNu = new JRadioButton("Nữ");
        		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		rdbtnNu.setBounds(296, 426, 109, 23);
        		frame.getContentPane().add(rdbtnNu);
        		
        		txtchucvu = new JTextField();
        		txtchucvu.setColumns(10);
        		txtchucvu.setBounds(163, 367, 380, 31);
        		frame.getContentPane().add(txtchucvu);
        		
        		JLabel lblGioiTinh = new JLabel("Giới Tính");
        		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblGioiTinh.setBounds(39, 418, 114, 31);
        		frame.getContentPane().add(lblGioiTinh);
        		
        	 
        		
        		
//        		
        		 SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.HOUR_OF_DAY);

        	        // Tạo JSpinner và thiết lập model cho nó
        	         spinner = new JSpinner(dateModel);

        	        // Định dạng ngày giờ
        	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy ");
        	        spinner.setEditor(dateEditor);
        	        frame.getContentPane().add(spinner);
        	        
        	        JLabel lblNgayVaolam = new JLabel("Ngày Vào Làm");
        	        lblNgayVaolam.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblNgayVaolam.setBounds(40, 475, 114, 31);
        	        frame.getContentPane().add(lblNgayVaolam);
        	        
        	        txtNgayVaoLam = new JTextField();
        	        txtNgayVaoLam.setColumns(10);
        	        txtNgayVaoLam.setBounds(163, 475, 380, 31);
        	        frame.getContentPane().add(txtNgayVaoLam);
        	        
        	        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        	        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblNgaySinh.setBounds(39, 527, 114, 31);
        	        frame.getContentPane().add(lblNgaySinh);
        	        
        	        txtngaySinh = new JTextField();
        	        txtngaySinh.setColumns(10);
        	        txtngaySinh.setBounds(163, 527, 380, 31);
        	        frame.getContentPane().add(txtngaySinh);
        	        
        	        JLabel lblTrangThai = new JLabel("Trạng Thái");
        	        lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblTrangThai.setBounds(39, 576, 114, 31);
        	        frame.getContentPane().add(lblTrangThai);
        	        
        	        txtTrangThai = new JTextField();
        	        txtTrangThai.setColumns(10);
        	        txtTrangThai.setBounds(163, 569, 380, 31);
        	        frame.getContentPane().add(txtTrangThai);
        	        
        	        btnThemnv = new JButton("Thêm");
        	        btnThemnv.addActionListener(new ActionListener() {
        	        	public void actionPerformed(ActionEvent e) {
        	        		
//        	        		NhanVien nv=new NhanVien();
        	        		
        	        		String []obj= {txtma.getText(),txtten.getText(),txtSDT.getText(),txtCMND.getText(),txtDiaChi.getText(),txtEmail.getText(),txtchucvu.getText(),rdbtnNam.getText(),txtngaySinh.getText(),txtNgayVaoLam.getText(),txtTrangThai.getText()};
        	        		model.addRow(obj);;
        	        	}
        	        });
        	        btnThemnv.setFont(new Font("Tahoma", Font.PLAIN, 18));
        	        btnThemnv.setBounds(40, 638, 133, 51);
        	        frame.getContentPane().add(btnThemnv);
        	        
        	        JButton btnThoat = new JButton("Thoát");
        	        btnThoat.addActionListener(new ActionListener() {
        	        	public void actionPerformed(ActionEvent e) {
        	        		frame.setVisible(false);
        	        	}
        	        });
        	        btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        	        btnThoat.setBounds(237, 638, 133, 51);
        	        frame.getContentPane().add(btnThoat);
        			
        			
        	 
        		
            frame.setVisible(true);
			}
		});
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnThem.setBounds(129, 659, 216, 54);
		contentPane.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnXoa.setBounds(405, 659, 216, 54);
		contentPane.add(btnXoa);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnSua.setBounds(699, 659, 216, 54);
		contentPane.add(btnSua);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnLuu.setBounds(955, 659, 216, 54);
		contentPane.add(btnLuu);
		
		JButton Close = new JButton("Thoát");
		Close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		Close.setBounds(1212, 659, 89, 42);
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
		
		JLabel lblNewLabel_1_3 = new JLabel("CMND :");
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
		
		txtchucvuu = new JTextField();
		txtchucvuu.setColumns(10);
		txtchucvuu.setBounds(1644, 219, 165, 20);
		contentPane.add(txtchucvuu);
		
		JLabel lblNewLabel_1_2_1_2_1 = new JLabel("Giới Tính :");
		lblNewLabel_1_2_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_1.setBounds(1303, 244, 67, 48);
		contentPane.add(lblNewLabel_1_2_1_2_1);
		
		JRadioButton rdbtnam = new JRadioButton("Nam");
		rdbtnam.setBackground(new Color(242, 208, 183));
		rdbtnam.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnam.setSelected(true);
		rdbtnam.setBounds(1390, 258, 67, 23);
		contentPane.add(rdbtnam);
		
		JRadioButton rdbtnnu = new JRadioButton("Nữ");
		rdbtnnu.setBackground(new Color(242, 208, 183));
		rdbtnnu.setSelected(true);
		rdbtnnu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnnu.setBounds(1459, 258, 78, 23);
		contentPane.add(rdbtnnu);
		
		
		ButtonGroup btngioitinh= new ButtonGroup();
		btngioitinh.add(rdbtnam);
		btngioitinh.add(rdbtnnu);
		
		JLabel lblNewLabel_1_2_1_2_2 = new JLabel("Ngày Vào Làm :");
		lblNewLabel_1_2_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2.setBounds(1295, 288, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2);
		
		JCalendar calendarNgayVaoLam = new JCalendar();
		calendarNgayVaoLam.setBounds(1296, 347, 198, 153);
		contentPane.add(calendarNgayVaoLam);
		
		JLabel lblNewLabel_1_2_1_2_2_1 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_2_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_1.setBounds(1611, 288, 121, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_1);
		
		JCalendar calendarNgaySinh = new JCalendar();
		calendarNgaySinh.setBounds(1611, 347, 198, 153);
		contentPane.add(calendarNgaySinh);
		
		JLabel lblNewLabel_1_2_1_2_2_2 = new JLabel("Trạng Thái Làm Việc :");
		lblNewLabel_1_2_1_2_2_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2_1_2_2_2.setBounds(1295, 511, 173, 48);
		contentPane.add(lblNewLabel_1_2_1_2_2_2);
		
		JRadioButton rdbdangLamViec = new JRadioButton("Đang Làm Việc");
		rdbdangLamViec.setBackground(new Color(242, 208, 183));
		rdbdangLamViec.setBounds(1466, 526, 109, 23);
		contentPane.add(rdbdangLamViec);
		
		JRadioButton rdbdNghiViec = new JRadioButton("Nghỉ Việc");
		rdbdNghiViec.setBackground(new Color(242, 208, 183));
		rdbdNghiViec.setBounds(1595, 526, 109, 23);
		contentPane.add(rdbdNghiViec);
		
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
				txtchucvuu.setText(model.getValueAt(row, 5).toString());
//				txtemail.setText();
				
				try {
					date = format.parse(model.getValueAt(row,7).toString());
					calendarNgaySinh.setDate(date);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					date = format.parse(model.getValueAt(row,8).toString());
					calendarNgayVaoLam.setDate(date);
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
}
