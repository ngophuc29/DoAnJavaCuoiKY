package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import com.toedter.calendar.JDateChooser;

import DAO.thongkeDAO;
import database.ConnectDB;
import entity.thongke;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ThongKe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKe frame = new ThongKe();
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
	public ThongKe() {
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1185, 465);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 208, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 51, 871, 245);
		contentPane.add(scrollPane);
		
		model = new DefaultTableModel();
		model.addColumn("Mã Hóa Đơn");
		model.addColumn("Mã Phòng");
		model.addColumn("Mã Khách Hàng");
		model.addColumn("Thời gian");
		model.addColumn("Tổng Tiền");
		table = new JTable(model);
		
		
		table.getColumnModel().getColumn(0).setPreferredWidth(90);
		table.getColumnModel().getColumn(1).setPreferredWidth(99);
		table.getColumnModel().getColumn(2).setPreferredWidth(112);
		table.getColumnModel().getColumn(3).setPreferredWidth(101);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(182, 208, 252));
		panel.setBounds(27, 301, 217, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ ngày: ");
		lblNewLabel.setBounds(10, 11, 58, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Đến ngày:");
		lblNewLabel_1.setBounds(10, 36, 58, 14);
		panel.add(lblNewLabel_1);
		
		JDateChooser truoc = new JDateChooser();
		truoc.setBounds(72, 11, 135, 20);
		panel.add(truoc);
		
		JDateChooser sau = new JDateChooser();
		sau.setBounds(72, 36, 135, 20);
		panel.add(sau);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(254, 301, 669, 114);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("             Tổng Tiền :");
		lblNewLabel_2.setForeground(new Color(241, 70, 39));
		lblNewLabel_2.setBackground(new Color(251, 80, 55));
		lblNewLabel_2.setBounds(167, 11, 333, 41);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel tongtienthongkeee = new JLabel("$");
		tongtienthongkeee.setFont(new Font("Tahoma", Font.BOLD, 20));
		tongtienthongkeee.setHorizontalAlignment(SwingConstants.CENTER);
		tongtienthongkeee.setBounds(257, 51, 142, 33);
		panel_1.add(tongtienthongkeee);
		
		JButton btnNewButton_1 = new JButton("Thống kê");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				thongkeDAO tkdao= new thongkeDAO();
				
				
				//	Lấy date trong jdatechose ra và đổi sang date của sql
				
				java.util.Date ngaytruoc =   truoc.getDate();

				// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String stringdatetruoc = dateFormat.format(ngaytruoc);

				// Chuyển đổi chuỗi thành kiểu java.sql.Date
				java.sql.Date datetruoc = java.sql.Date.valueOf(stringdatetruoc);
				//
			 
				//Lấy date sauu
				
				java.util.Date ngaysau =   sau.getDate();

				// Định dạng ngày thành chuỗi theo định dạng yyyy-MM-dd
				
				String strDatesau = dateFormat.format(ngaysau);

				// Chuyển đổi chuỗi thành kiểu java.sql.Date
				java.sql.Date datesau = java.sql.Date.valueOf(strDatesau);
				//
				
				
				
//				Date truoc =truoc.getDate();
				List<thongke>list=tkdao.thongkeee(datetruoc, datesau);
				
				for (thongke thongke : list) {
					Object []obj= {thongke.getMahoadon(),thongke.getMaphong(),thongke.getMakhachhang(),thongke.getNgaylap(),thongke.getTongtien()};
					model.addRow(obj);
				}
				table.setModel(model);
				//
				tongtienthongkeee.setText(Double.toString(tkdao.tienthongkeee(datetruoc, datesau)));
				//
			}
		});
		
//		thongkeDAO tkdao= new thongkeDAO();
//		tongtienthongkeee.setText(tkdao.tienthongkeee(null, null));
		
		
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(940, 148, 175, 49);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Cài lại");
		btnNewButton_1_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1_1.setBounds(940, 232, 175, 49);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Thống Kê");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(41, 11, 83, 29);
		contentPane.add(lblNewLabel_3);
	}
}
