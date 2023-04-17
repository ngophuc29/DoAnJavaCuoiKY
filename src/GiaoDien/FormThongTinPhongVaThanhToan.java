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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.GridLayout;
import javax.swing.ScrollPaneConstants;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import javax.swing.JButton;

public class FormThongTinPhongVaThanhToan extends JFrame {

	private JPanel contentPane;
	private JTextField txttenKH;
	private JTextField txtngaytraphong;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	private JTextField txtTongTienPhong;
	private JTable table_1;
	private JTextField textField_2;

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
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBackground(SystemColor.menu);
		textField.setBounds(682, 53, 95, 20);
		panel.add(textField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Giá Giờ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(809, 53, 74, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(880, 53, 80, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hóa Đơn Chi Tiết");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(20, 84, 145, 31);
		panel.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 126, 938, 220);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 H\u00F3a \u0110\u01A1n", "M\u00E3 Kh\u00E1ch H\u00E0ng", "M\u00E3 NV", "M\u00E3 Ph\u00F2ng", "Gi\u1EDD V\u00E0o", "Gi\u1EDD ra", "T\u1ED5ng th\u1EDDi gian", "T\u1ED5ng H\u00F3a \u0110\u01A1n", "T\u1ED5ng Thu", "Ti\u1EC1n Ph\u00F2ng"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(93);
		table.getColumnModel().getColumn(6).setPreferredWidth(83);
		table.getColumnModel().getColumn(7).setPreferredWidth(87);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Tiền Phòng : ");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setBackground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(261, 357, 145, 36);
		panel.add(lblNewLabel_3);
		
		txtTongTienPhong = new JTextField();
		txtTongTienPhong.setBackground(new Color(240, 240, 240));
		txtTongTienPhong.setBounds(416, 367, 107, 20);
		panel.add(txtTongTienPhong);
		txtTongTienPhong.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("(VNĐ)");
		lblNewLabel_3_1.setForeground(Color.RED);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3_1.setBackground(Color.RED);
		lblNewLabel_3_1.setBounds(531, 357, 61, 36);
		panel.add(lblNewLabel_3_1);
		
		JPanel panelChivietDichVu = new JPanel();
		panelChivietDichVu.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelChivietDichVu.setBounds(10, 444, 538, 330);
		contentPane.add(panelChivietDichVu);
		panelChivietDichVu.setLayout(null);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(128, 128, 255));
		panel_3_2.setBounds(10, 0, 518, 31);
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
		scrollPane_1.setBounds(20, 43, 508, 276);
		panelChivietDichVu.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 D\u1ECBch V\u1EE5", "Ph\u00F2ng", "T\u00EAn D\u1ECBch V\u1EE5", "\u0110\u01A1n Gi\u00E1", "S\u1ED1 L\u01B0\u1EE3ng", "Th\u00E0nh Ti\u1EC1n"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(1004, 0, 415, 774);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(47, 199, 3, -2);
		panel_2.add(panel_5);
		
		JPanel panelListDichVu = new JPanel();
		panelListDichVu.setBounds(10, 45, 387, 521);
		panel_2.add(panelListDichVu);
		panelListDichVu.setBackground(new Color(255, 0, 128));
		panelListDichVu.setLayout(null);
		
		JPanel panelPepsi = new JPanel();
		panelPepsi.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelPepsi.setLayout(null);
		panelPepsi.setBackground(Color.WHITE);
		panelPepsi.setBounds(197, 0, 199, 125);
		panelListDichVu.add(panelPepsi);
		
		JLabel lblNcPepsi = new JLabel("Nước Pepsi");
		lblNcPepsi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNcPepsi.setBounds(59, 37, 99, 14);
		panelPepsi.add(lblNcPepsi);
		
		JLabel dongiaPepsi = new JLabel("15.000");
		dongiaPepsi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaPepsi.setBounds(69, 62, 71, 25);
		panelPepsi.add(dongiaPepsi);
		
		JPanel paneleachDichVu_2 = new JPanel();
		paneleachDichVu_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		paneleachDichVu_2.setLayout(null);
		paneleachDichVu_2.setBackground(Color.WHITE);
		paneleachDichVu_2.setBounds(0, 124, 199, 125);
		panelListDichVu.add(paneleachDichVu_2);
		
		JLabel lblSevenup = new JLabel("SevenUp");
		lblSevenup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSevenup.setBounds(69, 30, 99, 25);
		paneleachDichVu_2.add(lblSevenup);
		
		JLabel dongia_2 = new JLabel("15.000");
		dongia_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongia_2.setBounds(69, 62, 71, 25);
		paneleachDichVu_2.add(dongia_2);
		
		JPanel panelCaphe = new JPanel();
		panelCaphe.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCaphe.setLayout(null);
		panelCaphe.setBackground(Color.WHITE);
		panelCaphe.setBounds(197, 124, 199, 125);
		panelListDichVu.add(panelCaphe);
		
		JLabel lblCPh = new JLabel("Cà Phê");
		lblCPh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPh.setBounds(59, 37, 99, 14);
		panelCaphe.add(lblCPh);
		
		JLabel dongiaCaphe = new JLabel("25.000");
		dongiaCaphe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaCaphe.setBounds(69, 62, 71, 25);
		panelCaphe.add(dongiaCaphe);
		
		JPanel panelBacXiu = new JPanel();
		panelBacXiu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelBacXiu.setLayout(null);
		panelBacXiu.setBackground(Color.WHITE);
		panelBacXiu.setBounds(0, 249, 199, 125);
		panelListDichVu.add(panelBacXiu);
		
		JLabel lblBcXu = new JLabel("Bạc Xĩu");
		lblBcXu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBcXu.setBounds(68, 37, 99, 14);
		panelBacXiu.add(lblBcXu);
		
		JLabel dongiaBacXiu = new JLabel("20.000");
		dongiaBacXiu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaBacXiu.setBounds(69, 62, 71, 25);
		panelBacXiu.add(dongiaBacXiu);
		
		JPanel panelHeneiken = new JPanel();
		panelHeneiken.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelHeneiken.setLayout(null);
		panelHeneiken.setBackground(Color.WHITE);
		panelHeneiken.setBounds(197, 249, 199, 125);
		panelListDichVu.add(panelHeneiken);
		
		JLabel lblBiaHeneiken = new JLabel("Bia HeneiKen");
		lblBiaHeneiken.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiaHeneiken.setBounds(59, 37, 99, 14);
		panelHeneiken.add(lblBiaHeneiken);
		
		JLabel dongiaHeneiken = new JLabel("30.000");
		dongiaHeneiken.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaHeneiken.setBounds(69, 62, 71, 25);
		panelHeneiken.add(dongiaHeneiken);
		
		JPanel panelBaiSG = new JPanel();
		panelBaiSG.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panelBaiSG.setLayout(null);
		panelBaiSG.setBackground(Color.WHITE);
		panelBaiSG.setBounds(0, 373, 199, 125);
		panelListDichVu.add(panelBaiSG);
		
		JLabel lblSiGn = new JLabel("Bia Sài Gòn");
		lblSiGn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSiGn.setBounds(71, 37, 99, 14);
		panelBaiSG.add(lblSiGn);
		
		JLabel dongiaBiaSG = new JLabel("30.000");
		dongiaBiaSG.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaBiaSG.setBounds(69, 62, 71, 25);
		panelBaiSG.add(dongiaBiaSG);
		
		JPanel panelTiger = new JPanel();
		panelTiger.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelTiger.setLayout(null);
		panelTiger.setBackground(Color.WHITE);
		panelTiger.setBounds(197, 373, 199, 125);
		panelListDichVu.add(panelTiger);
		
		JLabel lblBiaTiger = new JLabel("Bia Tiger");
		lblBiaTiger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBiaTiger.setBounds(59, 37, 99, 14);
		panelTiger.add(lblBiaTiger);
		
		JLabel dongiaTiger = new JLabel("30.000");
		dongiaTiger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaTiger.setBounds(69, 62, 71, 25);
		panelTiger.add(dongiaTiger);
		
		JPanel panelCoca = new JPanel();
		panelCoca.setBounds(0, 0, 199, 125);
		panelListDichVu.add(panelCoca);
		panelCoca.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelCoca.setBackground(new Color(255, 255, 255));
		panelCoca.setLayout(null);
		
		JLabel tendichvuCoca = new JLabel("Nước CoCa");
		tendichvuCoca.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tendichvuCoca.setBounds(59, 37, 99, 14);
		panelCoca.add(tendichvuCoca);
		
		JLabel dongiaCoCa = new JLabel("15.000");
		dongiaCoCa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		dongiaCoCa.setBounds(69, 62, 71, 25);
		panelCoca.add(dongiaCoCa);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(22, 486, 515, 288);
		contentPane.add(panel_4);
		
		JPanel panelDichVu = new JPanel();
		panelDichVu.setBounds(556, 444, 436, 330);
		contentPane.add(panelDichVu);
		panelDichVu.setBorder(BorderFactory.createTitledBorder("Dịch Vụ"));
		panelDichVu.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Tìm Kiếm");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(10, 21, 75, 22);
		panelDichVu.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 24, 289, 20);
		panelDichVu.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane( );
		scrollPane_2.setBounds(20, 54, 389, 253);
		panelDichVu.add(scrollPane_2);
	}
}
