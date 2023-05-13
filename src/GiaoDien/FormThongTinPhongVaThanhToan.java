package GiaoDien;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.chitietPhongDAO;
import DAO.chitietdichVuDAO;
import DAO.khachHangDAO;
import DAO.phongDAO;
import database.ConnectDB;
import entity.chitietDatPhong;
import entity.chitietdichVu;

import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class FormThongTinPhongVaThanhToan extends JFrame {
	public JButton btnTraPhong; 
	public JPanel contentPane;
	public JTextField txttenKH;
	public JTextField txtngaytraphong;
	public JLabel txtgiangay;
	public JLabel txtgiagio;
	public JTable tablekhachhang;
	public static DefaultTableModel modelkhachhang;
	public JLabel txtTongTienPhong;
	public JTable table_chitietdichvu;
	public DefaultTableModel modelchitietdichVu;
	public JLabel txttongtiendichvu;

	public JTextField soluongdichvucheck;
	String selectedOption;
	int luusoluongdichvu=1;
	JLabel txttongtienThanhToan ;
	  private SimpleDateFormat sdf;
	double luutiendichvu;
	public JTextField txtphuThu;
	public JButton btnInHoaDon;
	public JTextField txtstk;
	public JTextField txttienKhachDua;
	public JTextField txtTienkhachTraLai;
	String gioraa="";
	public JComboBox comboBox ;
	public JButton themdichvu;
	public JSpinner spinner;
	private khachHangDAO khdao;
	public JFrame f;
	private phongDAO phongdaoo = new phongDAO();
	private chitietdichVuDAO ctdvdao= new chitietdichVuDAO();
	private chitietPhongDAO ctdpdao= new chitietPhongDAO();
	
	private static FrmHoaDon frmhd;
	
	public JButton btnThanhToan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormThongTinPhongVaThanhToan frame = new FormThongTinPhongVaThanhToan();
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
	public FormThongTinPhongVaThanhToan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1445, 824);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "D\u1ECBch V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(new Color(240, 240, 240));
		panel.setBounds(10, 0, 982, 433);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Thông Tin Phòng");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 191, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBounds(0, 0, 972, 42);
		panel.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(128, 128, 255));
		panel_3.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(20, 53, 95, 20);
		panel.add(lblNewLabel_1);
		
		txttenKH = new JTextField();
		txttenKH.setEditable(false);
		txttenKH.setBackground(new Color(240, 240, 240));
		txttenKH.setBounds(122, 53, 117, 20);
		panel.add(txttenKH);
		
		
		txttenKH.setColumns(10);
		
		
		//
		
		//
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày Trả Phòng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(261, 53, 138, 20);
		panel.add(lblNewLabel_1_1);
		
		txtngaytraphong = new JTextField();
		txtngaytraphong.setColumns(10);
		txtngaytraphong.setBackground(SystemColor.menu);
		txtngaytraphong.setBounds(409, 53, 183, 20);
		panel.add(txtngaytraphong);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá Ngày");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(602, 53, 74, 20);
		panel.add(lblNewLabel_1_1_1);
		
		txtgiangay = new JLabel();
		txtgiangay.setForeground(new Color(255, 0, 0));
		txtgiangay.setFont(new Font("Tahoma", Font.BOLD, 15));
		 
		txtgiangay.setBackground(SystemColor.menu);
		txtgiangay.setBounds(682, 53, 95, 20);
		txtgiangay.setText("800");
		panel.add(txtgiangay);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá Giờ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(809, 53, 74, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		txtgiagio = new JLabel();
		txtgiagio.setForeground(new Color(255, 0, 0));
		txtgiagio.setFont(new Font("Tahoma", Font.BOLD, 15));
		 
		txtgiagio.setBackground(SystemColor.menu);
		txtgiagio.setBounds(880, 53, 80, 20);
		txtgiagio.setText("400");
		panel.add(txtgiagio);
		
		JLabel lblNewLabel_2 = new JLabel("Hóa Đơn Chi Tiết");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 84, 145, 31);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 126, 938, 220);
		panel.add(scrollPane);
		
//		tablekhachhang.setModel(new DefaultTableModel(
//				new Object[][] {
//					{"1", "1", "1", "1", "1", "1", "1", "1", "1", "120.000"},
//				},
//				new String[] {
//						"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 NV", "M\u00E3 Ph\u00F2ng", "Gi\u1EDD V\u00E0o", "Gi\u1EDD ra", "T\u1ED5ng th\u1EDDi gian", "T\u1ED5ng H\u00F3a \u0110\u01A1n", "T\u1ED5ng Thu", "Ti\u1EC1n Ph\u00F2ng"
//				}
//				));
//		
		
		modelkhachhang= new DefaultTableModel();
		modelkhachhang.addColumn("Mã chi tiết đặt phòng");
		modelkhachhang.addColumn("Mã phòng");
//		modelkhachhang.addColumn("So Luong Phong");
		modelkhachhang.addColumn("Ma hóa đơn");
//		modelkhachhang.addColumn("Giờ Vào");
//		modelkhachhang.addColumn("Giờ ra");
		modelkhachhang.addColumn("Giá phòng");
		modelkhachhang.addColumn("Giờ vào ");
//		modelkhachhang.addColumn("Tổng Thu");
		modelkhachhang.addColumn("Giờ ra");
		tablekhachhang = new JTable(modelkhachhang);
		tablekhachhang.getColumnModel().getColumn(1).setPreferredWidth(93);
//		tablekhachhang.getColumnModel().getColumn(6).setPreferredWidth(83);
//		tablekhachhang.getColumnModel().getColumn(7).setPreferredWidth(87);
		scrollPane.setViewportView(tablekhachhang);
		
		
		
//		for (chitietDatPhon ctdp : ctdpdao.getAllchiTietPhongCoMaKh(gioraa)) {
//			
//		}
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Tiền Phòng : ");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(261, 357, 145, 36);
		panel.add(lblNewLabel_3);
		
		txtTongTienPhong = new JLabel();
		txtTongTienPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
//		txtTongTienPhong.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		txtTongTienPhong.setEditable(false);
		txtTongTienPhong.setEnabled(false);
		txtTongTienPhong.setBackground(new Color(240, 240, 240));
		txtTongTienPhong.setBounds(416, 367, 107, 20);
		panel.add(txtTongTienPhong);
//		txtTongTienPhong.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("(VNĐ)");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBackground(Color.RED);
		lblNewLabel_3_1.setBounds(531, 357, 61, 36);
		panel.add(lblNewLabel_3_1);
		
		JPanel panelChivietDichVu = new JPanel();
		panelChivietDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelChivietDichVu.setBounds(10, 444, 982, 330);
		contentPane.add(panelChivietDichVu);
		panelChivietDichVu.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(128, 128, 255));
		panel_3_2.setBounds(0, 0, 982, 31);
		panelChivietDichVu.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblChiTitDch = new JLabel("Chi tiết Dịch vụ");
		lblChiTitDch.setBounds(10, -3, 160, 34);
		lblChiTitDch.setForeground(Color.WHITE);
		lblChiTitDch.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblChiTitDch.setBackground(Color.WHITE);
		panel_3_2.add(lblChiTitDch);
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBounds(573, 12, 10, 10);
		panel_3_1_1.setBackground(new Color(128, 128, 255));
		panel_3_2.add(panel_3_1_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 64, 495, 255);
		panelChivietDichVu.add(scrollPane_1);
		
		
		modelchitietdichVu= new DefaultTableModel();
		modelchitietdichVu.addColumn("Mã Dịch Vụ");
//		modelchitietdichVu.addColumn("Phòng");
		modelchitietdichVu.addColumn("Tên Dịch Vụ");
		modelchitietdichVu.addColumn("Đơn giá");
		modelchitietdichVu.addColumn("Số Lượng");
		modelchitietdichVu.addColumn("Thành Tiền");
		
		
		
		table_chitietdichvu = new JTable(modelchitietdichVu);
//		table_dichvu.setModel(new DefaultTableModel(
//			new Object[][] {
//				{null, null, null, null, null, null},
//			},
//			new String[] {
//				"M\u00E3 D\u1ECBch V\u1EE5", "Ph\u00F2ng", "T\u00EAn D\u1ECBch V\u1EE5", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
//			}
		
//		));
		
		
		
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	    // Cập nhật giá trị cho textfield 1
//		txtgiovao.setText(sdf.format(new Date()));
		
		
		
		scrollPane_1.setViewportView(table_chitietdichvu);
		
		JLabel lblNewLabel_3_2 = new JLabel("Tổng Dịch Vụ : ");
		lblNewLabel_3_2.setForeground(Color.RED);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_2.setBackground(Color.RED);
		lblNewLabel_3_2.setBounds(571, 204, 119, 36);
		panelChivietDichVu.add(lblNewLabel_3_2);
		
		txttongtiendichvu = new JLabel();
		txttongtiendichvu.setForeground(new Color(255, 0, 0));
		txttongtiendichvu.setFont(new Font("Tahoma", Font.BOLD, 15));
		txttongtiendichvu.setEnabled(false);
//		txttongtiendichvu.setEditable(false);
//		txttongtiendichvu.setColumns(10);
		txttongtiendichvu.setBackground(SystemColor.menu);
		txttongtiendichvu.setBounds(685, 214, 107, 20);
		panelChivietDichVu.add(txttongtiendichvu);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("(VNĐ)");
		lblNewLabel_3_1_1.setForeground(Color.RED);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_1.setBackground(Color.RED);
		lblNewLabel_3_1_1.setBounds(773, 204, 61, 36);
		panelChivietDichVu.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("Thêm Dịch Vụ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_4.setBounds(567, 96, 173, 36);
		panelChivietDichVu.add(lblNewLabel_4);
		
		  comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Nước CoCa", "Nước Nước Pepsi", "Nước 7UP", "Cà Phê", "Bạc Xĩu", "Bia Heneiken", "Bia Sài Gòn Bạc", "Bia 333"}));
		comboBox.addItem("Nước CoCa");
		comboBox.addItem("Nước Pepsi");
		comboBox.addItem("Nước 7UP");
		comboBox.addItem("Cà Phê");
		comboBox.addItem("Bạc Xỉu");
		comboBox.addItem("Bia Heneiken");
		comboBox.addItem("Bia Sài Gòn Bạc");
		comboBox.addItem("Bia 333");
		 
		comboBox.setBounds(567, 156, 219, 22);
		panelChivietDichVu.add(comboBox);
//		comboBox.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 selectedOption = (String) comboBox.getSelectedItem();
//                if (selectedOption.equals("Nước CoCa")) {
//                    // Mở ra JFrame tương ứng với Option 1
//                	  openOptionFrame();
//                }  if (selectedOption.equals("Nước Pepsi")) {
//                    // Mở ra JFrame tương ứng với Option 2
//                	openOptionFrame();
//                }  if (selectedOption.equals("Nước 7UP")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//                if (selectedOption.equals("Cà Phê")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//                if (selectedOption.equals("Bạc Xỉu")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//                if (selectedOption.equals("Bia Heneiken")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//                if (selectedOption.equals("Bia Sài Gòn Bạc")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//                if (selectedOption.equals("Bia 333")) {
//                    // Mở ra JFrame tương ứng với Option 3
//                	openOptionFrame();
//                }
//            }
//        });
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1002, -15, 415, 774);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(47, 199, 3, -2);
		panel_2.add(panel_5);
		
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setBounds(10, 11, 395, 31);
		panel_2.add(panel_3_3);
		panel_3_3.setBackground(new Color(128, 128, 255));
		panel_3_3.setLayout(null);
		
		JLabel lblThanhTon = new JLabel("Thanh Toán");
		lblThanhTon.setBounds(10, 0, 170, 34);
		lblThanhTon.setForeground(Color.WHITE);
		lblThanhTon.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThanhTon.setBackground(Color.WHITE);
		panel_3_3.add(lblThanhTon);
		
		JPanel panel_3_1_2 = new JPanel();
		panel_3_1_2.setBounds(280, 12, 10, 10);
		panel_3_1_2.setBackground(new Color(128, 128, 255));
		panel_3_3.add(panel_3_1_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Tổng Tiền Thanh Toán: ");
		lblNewLabel_3_3.setForeground(Color.RED);
		lblNewLabel_3_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_3.setBackground(Color.RED);
		lblNewLabel_3_3.setBounds(20, 53, 185, 36);
		panel_2.add(lblNewLabel_3_3);
		
		  txttongtienThanhToan = new JLabel();
		  txttongtienThanhToan.setForeground(new Color(255, 0, 0));
		  txttongtienThanhToan.setFont(new Font("Tahoma", Font.BOLD, 15));
		txttongtienThanhToan.setEnabled(false);
//		txttongtienThanhToan.setEditable(false);
//		txttongtienThanhToan.setColumns(10);
		txttongtienThanhToan.setBackground(SystemColor.menu);
		txttongtienThanhToan.setBounds(195, 63, 61, 20);
		panel_2.add(txttongtienThanhToan);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("(VNĐ)");
		lblNewLabel_3_1_2.setForeground(Color.RED);
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1_2.setBackground(Color.RED);
		lblNewLabel_3_1_2.setBounds(256, 53, 61, 36);
		panel_2.add(lblNewLabel_3_1_2);
		
		JLabel lblNewLabel_6 = new JLabel("Hình Thức Thanh Toán :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6.setBounds(30, 98, 175, 31);
		panel_2.add(lblNewLabel_6);
		
		JLabel stk = new JLabel("Số Tài Khoản :");
		stk.setToolTipText("Ngân Hàng MB");
		stk.setFont(new Font("Tahoma", Font.BOLD, 15));
		stk.setBounds(30, 186, 121, 22);
		panel_2.add(stk);
		
		txtstk = new JTextField();
		txtstk.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtstk.setEditable(false);
		txtstk.setEnabled(false);
		txtstk.setBounds(30, 229, 139, 20);
		panel_2.add(txtstk);
		txtstk.setColumns(10);
		
		JComboBox hinhthucthanhtoan = new JComboBox();
		hinhthucthanhtoan.addItem("Tiền Mặt");
		hinhthucthanhtoan.addItem("Qua Ngân Hàng");
		hinhthucthanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        String item = (String) hinhthucthanhtoan.getSelectedItem();
		        if (item.equals("Qua Ngân Hàng")) {
		        	txtstk.setText("12345567");
		        	 
		        }  
		        else   {
		        	txtstk.setText("");
		    		 
		        }

			}
		});
		hinhthucthanhtoan.setBounds(30, 140, 116, 22);
		panel_2.add(hinhthucthanhtoan);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Phụ Thu :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_7.setBounds(239, 98, 116, 31);
		panel_2.add(lblNewLabel_7);
		
		txtphuThu = new JTextField();
		txtphuThu.setBounds(239, 140, 128, 20);
		panel_2.add(txtphuThu);
		txtphuThu.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tiền Khách Đưa :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1.setBounds(30, 260, 153, 31);
		panel_2.add(lblNewLabel_6_1);
		
		txttienKhachDua = new JTextField();
		txttienKhachDua.setColumns(10);
		txttienKhachDua.setBounds(30, 302, 139, 20);
		panel_2.add(txttienKhachDua);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Tiền Trả Lại :");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_6_1_1.setBounds(30, 342, 153, 31);
		panel_2.add(lblNewLabel_6_1_1);
		
		txtTienkhachTraLai = new JTextField();
		txtTienkhachTraLai.setColumns(10);
		txtTienkhachTraLai.setBounds(30, 381, 139, 20);
		panel_2.add(txtTienkhachTraLai);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 456, 375, 115);
		panel_2.add(textArea);
		
		JLabel lblNewLabel_8 = new JLabel("Ghi Chú");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(30, 431, 93, 14);
		panel_2.add(lblNewLabel_8);
		
		 btnThanhToan = new FixButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txttienKhachDua.getText().equals("")) {
					txttienKhachDua.requestFocus();
					JOptionPane.showMessageDialog(null, "Nhập Số Tiền Khách Hàng Đưa !!!");
				}else {
					if(Double.parseDouble(txttienKhachDua.getText())<Double.parseDouble(txttongtienThanhToan.getText())) {
						 JOptionPane.showMessageDialog(null, "Khách Chưa Đưa Đủ Tiền");
					}
					else {
						JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công");
						txtTienkhachTraLai.setText(Double.toString(Double.parseDouble(txttienKhachDua.getText())-Double.parseDouble(txttongtienThanhToan.getText())));
						btnInHoaDon.setVisible(true);
					}
				}
				
			}
			
			
		});
		
		btnThanhToan.setForeground(new Color(255, 255, 255));
		btnThanhToan.setBackground(new Color(128, 128, 255));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnThanhToan.setBounds(30, 637, 375, 47);
		panel_2.add(btnThanhToan);
		
//		
//		String []testtablekhachhang= {"1","2","3","4","5",sdf.format(new Date()),gioraa};
		String []testtablekhachhang1= {"1","2","4","5",sdf.format(new Date()),gioraa};
		modelkhachhang.addRow(testtablekhachhang1);
//		modelkhachhang.addRow(testtablekhachhang1);
		  btnTraPhong = new FixButton("Trả Phòng");
		btnTraPhong.addActionListener(new ActionListener() {
			 @Override
			    public void actionPerformed(ActionEvent e) {
				 TableModel model = tablekhachhang.getModel();
 
				 int rowCount = model.getRowCount();
 
				 for (int i = 0; i < rowCount; i++) {
				     model.setValueAt(sdf.format(new Date()), i, 5);
				 }
				 txtngaytraphong.setText((sdf.format(new Date()).toString()));
				 
			    }
		});
		btnTraPhong.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTraPhong.setBounds(252, 704, 153, 42);
		panel_2.add(btnTraPhong);
		
		  btnInHoaDon = new FixButton("In Hóa Đơn");
		btnInHoaDon.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnInHoaDon.setBounds(30, 704, 153, 42);
		panel_2.add(btnInHoaDon);
		
	
		
		btnInHoaDon.setVisible(false);
		//TESt
		
		
		
		
		ListSelectionModel selectionModel = tablekhachhang.getSelectionModel();
		selectionModel.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
		    public void valueChanged1(ListSelectionEvent e) {
		        if (!e.getValueIsAdjusting()) {
		            int row = tablekhachhang.getSelectedRow();
		            int col = tablekhachhang.getSelectedColumn();
		            if (col == 0) { // chỉnh sửa giá trị cột thứ nhất
		                String value = (String) tablekhachhang.getValueAt(row, col);
		                // code xử lý để thay đổi giá trị cột
		            }
		        }
		    }

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(22, 486, 515, 288);
		contentPane.add(panel_4);
	
		
		 
	}
	 public void openOptionFrame(String sp,String mhd,String madv) {
//	        JFrame option1Frame = new JFrame("Option 1 Frame");
//	        option1Frame.setSize(300, 200);
//	        option1Frame.setLocationRelativeTo(null);
//	        
//	        
//	        option1Frame.setVisible(true);
		   f=new JFrame();
			f.setBounds(0,0,434,225);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.getContentPane().setLayout(null);
			f.setLocationRelativeTo(null);
			f.setSize(400,260);
			
			JLabel lblNewLabel = new JLabel("Tên Dịch Vụ :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel.setBounds(53, 41, 110, 42);
			f.getContentPane().add(lblNewLabel);
			
			
			JLabel lblSLng = new JLabel("Số Lượng  :");
			lblSLng.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblSLng.setBounds(53, 104, 110, 42);
			f.getContentPane().add(lblSLng);
			
			JLabel lblNewLabel_2 = new JLabel(sp);
			lblNewLabel_2.setBounds(185, 58, 140, 14);
			f.getContentPane().add(lblNewLabel_2);
		
			  spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner.setBounds(179, 118, 40, 20);
			f.getContentPane().add(spinner);
			spinner.setValue(1);
			
			  themdichvu = new FixButton("Thêm");
			themdichvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			themdichvu.setBounds(93,159, 89, 42);
			f.getContentPane().add(themdichvu);
			themdichvu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					String []obj= {"a","b","c","d","e","đ"};
//					
//					modelchitietdichVu.addRow(obj);
//					String ma="";
//					String ten="";
//					String phong ="";
//					String dongia="";
//					String soluong ="";
//					String thanhtien="";
//					double tinhthanhtien=0.0;
//					double tongtiendichvu=0.0;
//					
//					if(selectedOption.equals("Nước CoCa")) {
//						ma+="DV101";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="15.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//						 
//					}
//				 
//					if(selectedOption.equals("Nước Pepsi")) {
//						ma+="DV102";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="15.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//				 
//					}
//					
//					if(selectedOption.equals("Nước 7UP")) {
//						ma+="DV103";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="15.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//						 
//					}
//					if(selectedOption.equals("Cà Phê")) {
//						ma+="DV104";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="25.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//					 
//					}
//					if(selectedOption.equals("Bạc Xỉu")) {
//						ma+="DV105";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="20.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//						 
//					}
//					if(selectedOption.equals("Bia Heneiken")) {
//						ma+="DV106";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="30.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//					 
//					}
//					if(selectedOption.equals("Bia Sài Gòn Bạc")) {
//						ma+="DV107";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="30.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//						 
//					}
//				 
//					if(selectedOption.equals("Bia 333")) {
//						ma+="DV108";
//						phong+="chua lam";
//						ten+=selectedOption;
//						dongia+="25.000";
//						soluong+=spinner.getValue();
//						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
//						thanhtien+=Double.toString(tinhthanhtien);
//						 
//					}
//					
//					
//					
//					String []obj= {ma,phong,ten,dongia,soluong,thanhtien};
//					modelchitietdichVu.addRow(obj);
					int soluong=Integer.parseInt(spinner.getValue().toString());
					chitietdichVu ctdv=new chitietdichVu(mhd, madv, soluong);
					ctdvdao.insert(ctdv);
					
//					 
					
					//TÍNH TỔNG TIỀN DỊCH VỤ QUA CỘT THÀNH TIỀN
					// lấy model bảng từ JTable
					TableModel model = table_chitietdichvu.getModel();

					// đặt chỉ số của cột để tính tổng
					int columnIndex = 5; // giả sử chỉ số cột là 2

					// khởi tạo biến tổng
					double sum = 0.0;

					// lặp qua từng dòng trong bảng
//					for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
//					    // lấy giá trị của ô trong cột được chỉ định
//					    String cellValue = model.getValueAt(rowIndex, columnIndex).toString();
//					    
//					    // chuyển đổi giá trị ô từ chuỗi sang số thực và thêm vào tổng
//					    sum += Double.parseDouble(cellValue);
//					}

					   
					// hiển thị tổng trong một nhãn hoặc trường văn bản
					txttongtiendichvu.setText(String.valueOf(sum));

					
					
					//lấy giá trị của cột tiền phòng trong bảng table khách hàng\
//					int row = tablekhachhang.getSelectedRow(); // lấy vị trí dòng đang được chọn
//					int col = tablekhachhang.getSelectedColumn(); // lấy vị trí cột đang được chọn
//					Object value = tablekhachhang.getValueAt(0,9); // lấy giá trị của ô được chọn
//
//					// chuyển giá trị từ chuỗi sang double
//					double doubleValue = Double.parseDouble(value.toString()); // chuyển giá trị thành kiểu double
//					//
					
					// lấy model bảng từ JTable
					TableModel model1 = tablekhachhang.getModel();

					// đặt chỉ số của cột để tính tổng
					int columnIndex1 = 3; // giả sử chỉ số cột là 2

					// khởi tạo biến tổng
					double doubleValue = 0.0;
					
					// lặp qua từng dòng trong bảng
//					for (int rowIndex = 0; rowIndex < model1.getRowCount(); rowIndex++) {
//					    // lấy giá trị của ô trong cột được chỉ định
//					    String cellValue = model1.getValueAt(rowIndex, columnIndex1).toString();
//					    
//					    // chuyển đổi giá trị ô từ chuỗi sang số thực và thêm vào tổng
//					    doubleValue += Double.parseDouble(cellValue);
//					}
//
//					   
//					// hiển thị tổng trong một nhãn hoặc trường văn bản
//					txtTongTienPhong.setText(String.valueOf(doubleValue));
//					
//					
//					txttongtienThanhToan.setText(String.valueOf(sum+doubleValue));
					String makh= txttenKH.getText();
					ConnectDB.getinstance();
					Connection con =ConnectDB.getConnection();
					PreparedStatement stmt=null;
					try {
						modelchitietdichVu.setRowCount(0);
						String sql="  select ctdv.machitiethoadon,dv.tendichvu,dv.giadichvu,ctdv.soluongdichvu from chitiethoadondichvu ctdv join dichvu dv on ctdv.madichvu=dv.madichvu where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
						stmt=con.prepareStatement(sql);
						stmt.setString(1, makh);
						ResultSet rs =stmt.executeQuery();
						while(rs.next()) {
//							dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
							Object []obj= {rs.getString(1), rs.getString(2),    rs.getDouble(3), rs.getInt(4), rs.getDouble(3)*rs.getInt(4)};
							modelchitietdichVu.addRow(obj);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					String mahoadon=laymahoadon(makh);
					txttongtiendichvu.setText(Double.toString(ctdvdao.tongtiendichvu(makh)));
					txttongtienThanhToan.setText(Double.toString(ctdvdao.tongtiendichvu(makh)+ctdpdao.tongtienphong(mahoadon)));
					
					
					//test
					 
					
					//
					f.dispose();
				}
			});
 
			
			
			 
			
			JButton btnCancale = new FixButton("Cancel");
			btnCancale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f.setVisible(false);
				}
			});
			btnCancale.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancale.setBounds(228, 157, 132, 42);
			f.getContentPane().add(btnCancale);
			 int sum=0;
			int rowCount = tablekhachhang.getRowCount();
//			for (int i = 0; i < rowCount; i++) {
//			    int col1Value =  Integer.parseInt(tablekhachhang.getValueAt(i, 1).toString()); // Lấy giá trị của cột col1
//			    Double col2Value =Double.parseDouble(tablekhachhang.getValueAt(i, 3).toString()); // Lấy giá trị của cột col2
//			    int col3Value = col1Value * (col2Value - col1Value); // Tính giá trị mới của cột col3
//			    sum+=col3Value;
//			    
//			}
//			System.out.println("Giá trị mới của cột col3 tại dòng " + sum);
		
			f.setVisible(true);
	    }
	 public String  laymahoadon(String makh) {
		 String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=doAnCuoiKyJava";
	        String username = "sa";
	        String password = "sapassword";
	        String columnValue="";
	        PreparedStatement stmt=null;
	        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password))
	        		{	
	        	String sql = "SELECT mahoadon FROM hoadon where trangthai='CTT' and makh=?";
	        	stmt = conn.prepareStatement(sql);
	        	stmt.setString(1, makh);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                  columnValue += rs.getString("mahoadon");
	               
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return columnValue;
	}
}
