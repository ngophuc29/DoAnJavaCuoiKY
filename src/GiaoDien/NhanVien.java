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
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class NhanVien extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanVien frame = new NhanVien();
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
	public NhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1399, 778);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnnhavien = new JButton("Nhân viên");
		btnnhavien.setIcon(new ImageIcon(NhanVien.class.getResource("/img/Administrator-icon.png")));
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
		model.addColumn("Email");
		model.addColumn("Chức Vụ");
		model.addColumn("Giới Tính");
		model.addColumn("Ngày Sinh");
		model.addColumn("Ngày Vào Làm");
		model.addColumn("Trạng Thái Làm Việc");
		table = new JTable(model);
		 
		scrollPane.setViewportView(table);
		
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
        		frame.add(lblNewLabel);
        		
        		JLabel lblmanv = new JLabel("Mã Nhân Viên");
        		lblmanv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblmanv.setBounds(39, 108, 114, 31);
        		frame.add(lblmanv);
        		
        		txtma = new JTextField();
        		txtma.setBounds(163, 110, 380, 31);
        		frame.add(txtma);
        		txtma.setColumns(10);
        		
        		JLabel lbltennv = new JLabel("Tên Nhân Viên");
        		lbltennv.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lbltennv.setBounds(39, 150, 114, 31);
        		frame.add(lbltennv);
        		
        		txtten = new JTextField();
        		txtten.setColumns(10);
        		txtten.setBounds(163, 152, 380, 31);
        		frame.add(txtten);
        		
        		JLabel lblSdt = new JLabel("SĐT");
        		lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblSdt.setBounds(39, 192, 114, 31);
        		frame.add(lblSdt);
        		
        		txtSDT = new JTextField();
        		txtSDT.setColumns(10);
        		txtSDT.setBounds(163, 194, 380, 31);
        		frame.add(txtSDT);
        		
        		JLabel lblCmnd = new JLabel("CMND");
        		lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblCmnd.setBounds(40, 234, 114, 31);
        		frame.add(lblCmnd);
        		
        		txtCMND = new JTextField();
        		txtCMND.setColumns(10);
        		txtCMND.setBounds(163, 236, 380, 31);
        		frame.add(txtCMND);
        		
        		JLabel lbldiachi = new JLabel("Địa chỉ");
        		lbldiachi.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lbldiachi.setBounds(39, 276, 114, 31);
        		frame.add(lbldiachi);
        		
        		txtDiaChi = new JTextField();
        		txtDiaChi.setColumns(10);
        		txtDiaChi.setBounds(163, 283, 380, 31);
        		frame.add(txtDiaChi);
        		
        		JLabel lblEmail = new JLabel("Email");
        		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblEmail.setBounds(39, 318, 114, 31);
        		frame.add(lblEmail);
        		
        		txtEmail = new JTextField();
        		txtEmail.setColumns(10);
        		txtEmail.setBounds(163, 325, 380, 31);
        		frame.add(txtEmail);
        		
        		JLabel lblChucVu = new JLabel("Chức Vụ");
        		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblChucVu.setBounds(39, 369, 114, 31);
        		frame.add(lblChucVu);
        		
        		JRadioButton rdbtnNam = new JRadioButton("Nam");
        		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		rdbtnNam.setBounds(169, 426, 109, 23);
        		frame.add(rdbtnNam);
        		
        		JRadioButton rdbtnNu = new JRadioButton("Nữ");
        		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
        		rdbtnNu.setBounds(296, 426, 109, 23);
        		frame.add(rdbtnNu);
        		
        		txtchucvu = new JTextField();
        		txtchucvu.setColumns(10);
        		txtchucvu.setBounds(163, 367, 380, 31);
        		frame.add(txtchucvu);
        		
        		JLabel lblGioiTinh = new JLabel("Giới Tính");
        		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        		lblGioiTinh.setBounds(39, 418, 114, 31);
        		frame.add(lblGioiTinh);
        		
        	 
        		
        		
//        		
        		 SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, java.util.Calendar.HOUR_OF_DAY);

        	        // Tạo JSpinner và thiết lập model cho nó
        	         spinner = new JSpinner(dateModel);

        	        // Định dạng ngày giờ
        	        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "dd/MM/yyyy ");
        	        spinner.setEditor(dateEditor);
        	        frame.add(spinner);
        	        
        	        JLabel lblNgayVaolam = new JLabel("Ngày Vào Làm");
        	        lblNgayVaolam.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblNgayVaolam.setBounds(40, 475, 114, 31);
        	        frame.add(lblNgayVaolam);
        	        
        	        txtNgayVaoLam = new JTextField();
        	        txtNgayVaoLam.setColumns(10);
        	        txtNgayVaoLam.setBounds(163, 475, 380, 31);
        	        frame.add(txtNgayVaoLam);
        	        
        	        JLabel lblNgaySinh = new JLabel("Ngày sinh");
        	        lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblNgaySinh.setBounds(39, 527, 114, 31);
        	        frame.add(lblNgaySinh);
        	        
        	        txtngaySinh = new JTextField();
        	        txtngaySinh.setColumns(10);
        	        txtngaySinh.setBounds(163, 527, 380, 31);
        	        frame.add(txtngaySinh);
        	        
        	        JLabel lblTrangThai = new JLabel("Trạng Thái");
        	        lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 16));
        	        lblTrangThai.setBounds(39, 576, 114, 31);
        	        frame.add(lblTrangThai);
        	        
        	        txtTrangThai = new JTextField();
        	        txtTrangThai.setColumns(10);
        	        txtTrangThai.setBounds(163, 569, 380, 31);
        	        frame.add(txtTrangThai);
        	        
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
        	        frame.add(btnThemnv);
        	        
        	        JButton btnThoat = new JButton("Thoát");
        	        btnThoat.addActionListener(new ActionListener() {
        	        	public void actionPerformed(ActionEvent e) {
        	        		frame.setVisible(false);
        	        	}
        	        });
        	        btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
        	        btnThoat.setBounds(237, 638, 133, 51);
        	        frame.add(btnThoat);
        			
        			
        	 
        		
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
		
		
	}
	 public DefaultTableModel getModel() {
	        return model;
	    }
}
