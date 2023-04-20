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
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
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
	public DefaultTableModel modelkhachhang;
	public JLabel txtTongTienPhong;
	public JTable table_chitietdichvu;
	public DefaultTableModel modelchitietdichVu;
	public JLabel txttongtiendichvu;
	public JTextField textField_2;
	public JTextField soluongdichvucheck;
	String selectedOption;
	int luusoluongdichvu=1;
	JLabel txttongtienThanhToan ;
	
	double luutiendichvu;
	public JTextField txtphuThu;
	public JTextField txtstk;
	public JTextField txttienKhachDua;
	public JTextField txtTienkhachTraLai;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JLabel lblNewLabel = new JLabel("Thong Tin Phong");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(20, 11, 191, 31);
		panel.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 128, 255));
		panel_3.setBounds(10, 11, 962, 31);
		panel.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(128, 128, 255));
		panel_3.add(panel_3_1);
		
		JLabel lblNewLabel_1 = new JLabel("Khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(20, 53, 95, 20);
		panel.add(lblNewLabel_1);
		
		txttenKH = new JTextField();
		txttenKH.setBackground(new Color(240, 240, 240));
		txttenKH.setBounds(122, 53, 117, 20);
		panel.add(txttenKH);
		txttenKH.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Ngày Trả Phòng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(261, 53, 122, 20);
		panel.add(lblNewLabel_1_1);
		
		txtngaytraphong = new JTextField();
		txtngaytraphong.setColumns(10);
		txtngaytraphong.setBackground(SystemColor.menu);
		txtngaytraphong.setBounds(393, 53, 183, 20);
		panel.add(txtngaytraphong);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá Ngày");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(602, 53, 74, 20);
		panel.add(lblNewLabel_1_1_1);
		
		txtgiangay = new JLabel();
		txtgiangay.setForeground(new Color(255, 0, 0));
		txtgiangay.setFont(new Font("Tahoma", Font.BOLD, 15));
		 
		txtgiangay.setBackground(SystemColor.menu);
		txtgiangay.setBounds(682, 53, 95, 20);
		txtgiangay.setText("200");
		panel.add(txtgiangay);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá Giờ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
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
		modelkhachhang.addColumn("Mã Hóa ĐƠn");
		modelkhachhang.addColumn("Mã Khách Hàng");
		modelkhachhang.addColumn("Mã Nhân Viên");
		modelkhachhang.addColumn("Mã Phòng");
		modelkhachhang.addColumn("Giờ Vào");
		modelkhachhang.addColumn("Giờ ra");
		modelkhachhang.addColumn("Tổng Thời Gian");
		modelkhachhang.addColumn("Tổng Hóa ĐƠn");
		modelkhachhang.addColumn("Tổng Thu");
		modelkhachhang.addColumn("Tiền Phòng");
		tablekhachhang = new JTable(modelkhachhang);
		tablekhachhang.getColumnModel().getColumn(1).setPreferredWidth(93);
		tablekhachhang.getColumnModel().getColumn(6).setPreferredWidth(83);
		tablekhachhang.getColumnModel().getColumn(7).setPreferredWidth(87);
		scrollPane.setViewportView(tablekhachhang);
		
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
		panel_3_2.setBounds(10, 0, 962, 31);
		panelChivietDichVu.add(panel_3_2);
		panel_3_2.setLayout(null);
		
		JLabel lblChiTitDch = new JLabel("Chi tiết Dịch vụ");
		lblChiTitDch.setBounds(0, -3, 170, 34);
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
		modelchitietdichVu.addColumn("Phòng");
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
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(567, 42, 173, 36);
		panelChivietDichVu.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm Kiếm Dịch Vụ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(567, 89, 173, 25);
		panelChivietDichVu.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(567, 125, 219, 20);
		panelChivietDichVu.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
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
		comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 selectedOption = (String) comboBox.getSelectedItem();
                if (selectedOption.equals("Nước CoCa")) {
                    // Mở ra JFrame tương ứng với Option 1
                	  openOptionFrame();
                }  if (selectedOption.equals("Nước Pepsi")) {
                    // Mở ra JFrame tương ứng với Option 2
                	openOptionFrame();
                }  if (selectedOption.equals("Nước 7UP")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
                if (selectedOption.equals("Cà Phê")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
                if (selectedOption.equals("Bạc Xỉu")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
                if (selectedOption.equals("Bia Heneiken")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
                if (selectedOption.equals("Bia Sài Gòn Bạc")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
                if (selectedOption.equals("Bia 333")) {
                    // Mở ra JFrame tương ứng với Option 3
                	openOptionFrame();
                }
            }
        });
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
		
		JLabel lblNewLabel_6 = new JLabel("Hình Thức Thanh Toán");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(30, 98, 153, 31);
		panel_2.add(lblNewLabel_6);
		
		JLabel stk = new JLabel("Số Tài Khoản :");
		stk.setToolTipText("Ngân Hàng MB");
		stk.setFont(new Font("Tahoma", Font.BOLD, 13));
		stk.setBounds(35, 186, 101, 22);
		panel_2.add(stk);
		
		txtstk = new JTextField();
		txtstk.setFont(new Font("Tahoma", Font.BOLD, 13));
		txtstk.setEditable(false);
		txtstk.setEnabled(false);
		txtstk.setBounds(40, 217, 139, 20);
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
		hinhthucthanhtoan.setBounds(40, 140, 116, 22);
		panel_2.add(hinhthucthanhtoan);
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Phụ Thu");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(239, 98, 116, 31);
		panel_2.add(lblNewLabel_7);
		
		txtphuThu = new JTextField();
		txtphuThu.setBounds(239, 140, 128, 20);
		panel_2.add(txtphuThu);
		txtphuThu.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Tiền Khách Đưa");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1.setBounds(30, 260, 153, 31);
		panel_2.add(lblNewLabel_6_1);
		
		txttienKhachDua = new JTextField();
		txttienKhachDua.setColumns(10);
		txttienKhachDua.setBounds(30, 302, 128, 20);
		panel_2.add(txttienKhachDua);
		
		JLabel lblNewLabel_6_1_1 = new JLabel("Tiền Trả Lại");
		lblNewLabel_6_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6_1_1.setBounds(30, 342, 153, 31);
		panel_2.add(lblNewLabel_6_1_1);
		
		txtTienkhachTraLai = new JTextField();
		txtTienkhachTraLai.setColumns(10);
		txtTienkhachTraLai.setBounds(30, 381, 128, 20);
		panel_2.add(txtTienkhachTraLai);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 456, 375, 115);
		panel_2.add(textArea);
		
		JLabel lblNewLabel_8 = new JLabel("Ghi Chú");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(30, 431, 93, 14);
		panel_2.add(lblNewLabel_8);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
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
					}
				}
			}
		});
		btnThanhToan.setForeground(new Color(255, 255, 255));
		btnThanhToan.setBackground(new Color(128, 128, 255));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnThanhToan.setBounds(30, 637, 375, 47);
		panel_2.add(btnThanhToan);
		
		  btnTraPhong = new JButton("Trả Phòng");
		btnTraPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTraPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTraPhong.setBounds(225, 702, 180, 44);
		panel_2.add(btnTraPhong);
		
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(22, 486, 515, 288);
		contentPane.add(panel_4);
	
		
		 
	}
	 private void openOptionFrame() {
//	        JFrame option1Frame = new JFrame("Option 1 Frame");
//	        option1Frame.setSize(300, 200);
//	        option1Frame.setLocationRelativeTo(null);
//	        
//	        
//	        option1Frame.setVisible(true);
		 JFrame f=new JFrame();
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
			
			JLabel lblNewLabel_2 = new JLabel(selectedOption);
			lblNewLabel_2.setBounds(185, 58, 140, 14);
			f.getContentPane().add(lblNewLabel_2);
			
//			JButton btntru = new JButton("-");
//			btntru.setFont(new Font("Tahoma", Font.PLAIN, 18));
//
//			soluongdichvucheck = new JTextField();
//			soluongdichvucheck.setText("1");
//			soluongdichvucheck.setBounds(228, 118, 29, 23);
//			f.getContentPane().add(soluongdichvucheck);
//			soluongdichvucheck.setColumns(10);
//			
//			
//			btntru.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					int a=Integer.parseInt( soluongdichvucheck.getText()  );
//					 int k=a;
//					 k--;
//					 soluongdichvucheck.setText(Integer.toString(k));
//					 luusoluongdichvu+=k;
//				}
//			});
//			btntru.setBounds(158, 117, 61, 23);
//			f.getContentPane().add(btntru);
//			
//			JButton btncong = new JButton("+");
//			btncong.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					int a=Integer.parseInt( soluongdichvucheck.getText()  );
//
//					 int k=a;
//					 k++;
//					 soluongdichvucheck.setText(Integer.toString(k));
//					 luusoluongdichvu+=k;
//				}
//			});
//			
//		 
//			
//			btncong.setFont(new Font("Tahoma", Font.PLAIN, 18));
//			btncong.setBounds(267, 117, 75, 23);
//			f.getContentPane().add(btncong);
			
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
			spinner.setBounds(179, 118, 40, 20);
			f.getContentPane().add(spinner);
			spinner.setValue(1);
			
			JButton themdichvu = new JButton("Thêm");
			themdichvu.setFont(new Font("Tahoma", Font.PLAIN, 20));
			themdichvu.setBounds(93,159, 89, 42);
			f.getContentPane().add(themdichvu);
			themdichvu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
//					String []obj= {"a","b","c","d","e","đ"};
//					
//					modelchitietdichVu.addRow(obj);
					String ma="";
					String ten="";
					String phong ="";
					String dongia="";
					String soluong ="";
					String thanhtien="";
					double tinhthanhtien=0.0;
					double tongtiendichvu=0.0;
					
					if(selectedOption.equals("Nước CoCa")) {
						ma+="701";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="15.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
						 
					}
				 
					if(selectedOption.equals("Nước Pepsi")) {
						ma+="702";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="15.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
				 
					}
					
					if(selectedOption.equals("Nước 7UP")) {
						ma+="703";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="15.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
						 
					}
					if(selectedOption.equals("Cà Phê")) {
						ma+="704";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="25.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
					 
					}
					if(selectedOption.equals("Bạc Xỉu")) {
						ma+="705";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="20.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
						 
					}
					if(selectedOption.equals("Bia Heneiken")) {
						ma+="706";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="30.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
					 
					}
					if(selectedOption.equals("Bia Sài Gòn Bạc")) {
						ma+="707";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="30.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
						 
					}
				 
					if(selectedOption.equals("Bia 333")) {
						ma+="708";
						phong+="chua lam";
						ten+=selectedOption;
						dongia+="25.000";
						soluong+=spinner.getValue();
						tinhthanhtien=Integer.parseInt(soluong)*Double.parseDouble(dongia);
						thanhtien+=Double.toString(tinhthanhtien);
						 
					}
					
					
					
					String []obj= {ma,phong,ten,dongia,soluong,thanhtien};
					modelchitietdichVu.addRow(obj);
			
 				
//					 
					
					//TÍNH TỔNG TIỀN DỊCH VỤ QUA CỘT THÀNH TIỀN
					// lấy model bảng từ JTable
					TableModel model = table_chitietdichvu.getModel();

					// đặt chỉ số của cột để tính tổng
					int columnIndex = 5; // giả sử chỉ số cột là 2

					// khởi tạo biến tổng
					double sum = 0.0;

					// lặp qua từng dòng trong bảng
					for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
					    // lấy giá trị của ô trong cột được chỉ định
					    String cellValue = model.getValueAt(rowIndex, columnIndex).toString();
					    
					    // chuyển đổi giá trị ô từ chuỗi sang số thực và thêm vào tổng
					    sum += Double.parseDouble(cellValue);
					}

					   
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
					int columnIndex1 = 9; // giả sử chỉ số cột là 2

					// khởi tạo biến tổng
					double doubleValue = 0.0;

					// lặp qua từng dòng trong bảng
					for (int rowIndex = 0; rowIndex < model1.getRowCount(); rowIndex++) {
					    // lấy giá trị của ô trong cột được chỉ định
					    String cellValue = model1.getValueAt(rowIndex, columnIndex1).toString();
					    
					    // chuyển đổi giá trị ô từ chuỗi sang số thực và thêm vào tổng
					    doubleValue += Double.parseDouble(cellValue);
					}

					   
					// hiển thị tổng trong một nhãn hoặc trường văn bản
					txtTongTienPhong.setText(String.valueOf(doubleValue));

					
					txttongtienThanhToan.setText(String.valueOf(sum+doubleValue));
				}
			});
 
			 
			 
			
			
			 
			
			JButton btnCancale = new JButton("Cancel");
			btnCancale.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					f.setVisible(false);
				}
			});
			btnCancale.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnCancale.setBounds(228, 157, 132, 42);
			f.getContentPane().add(btnCancale);
			
		
			f.setVisible(true);
	    }
}
