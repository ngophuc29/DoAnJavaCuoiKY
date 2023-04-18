package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class PhongUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhongUI frame = new PhongUI();
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
	public PhongUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1396, 809);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhng = new JButton("Phòng");
//		btnPhng.setIcon(new ImageIcon(Phong.class.getResource("/img/Shoji2-paper-sliding-door-icon.png")));
		btnPhng.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnPhng.setBorderPainted(false);
		btnPhng.setBackground(new Color(242, 208, 183));
		btnPhng.setBounds(41, 24, 206, 51);
		contentPane.add(btnPhng);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBackground(new Color(177, 234, 162));
		lblNewLabel.setBounds(375, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnpt = new JButton(" ");
		btnpt.setBackground(new Color(153, 204, 153));
		btnpt.setBounds(295, 55, 35, 14);
		contentPane.add(btnpt);
		
		JLabel lblpt = new JLabel("Phòng Trống");
		lblpt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpt.setBounds(340, 49, 144, 23);
		contentPane.add(lblpt);
		
		JButton btnpdck = new JButton(" ");
		btnpdck.setBackground(new Color(238, 114, 96));
		btnpdck.setBounds(511, 55, 35, 14);
		contentPane.add(btnpdck);
		
		JLabel lblpdck = new JLabel("Phòng Đã Có Khách");
		lblpdck.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpdck.setBounds(567, 49, 144, 23);
		contentPane.add(lblpdck);
		
		JButton btnpdsc = new JButton(" ");
		btnpdsc.setBackground(new Color(240, 245, 50));
		btnpdsc.setBounds(766, 58, 35, 14);
		contentPane.add(btnpdsc);
		
		JLabel lblpdsc = new JLabel("Phòng Đang Sửa Chữa");
		lblpdsc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblpdsc.setBounds(823, 49, 183, 23);
		contentPane.add(lblpdsc);
		
		JButton btnNewButton_6 = new JButton("Thoát");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_6.setBounds(1071, 44, 104, 31);
		contentPane.add(btnNewButton_6);
		
		JPanel panelPhongUITable = new JPanel();
		panelPhongUITable.setBackground(SystemColor.activeCaption);
		panelPhongUITable.setBounds(80, 143, 1200, 600);
		contentPane.add(panelPhongUITable);
		panelPhongUITable.setLayout(null);
		
		
		//menu khi click chuot phai
		JPopupMenu popupMenu = new JPopupMenu();
		JMenuItem menuItem1 = new JMenuItem("Đặt Phòng");
		JMenuItem menuItem2 = new JMenuItem("Chi Tiết Đặt Phòng");
		 
		popupMenu.add(menuItem1);
		popupMenu.add(menuItem2);
 
		
		//
		
		
		JPanel panelPhong101 = new JPanel();
		panelPhong101.setBackground(new Color(153, 204, 153));
		menuItem1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Xử lý sự kiện ở đây
		    	panelPhong101.setBackground(new Color(238, 114, 96));
		    }
		});
		
		
		menuItem2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Xử lý sự kiện ở đây
//		    	panelPhong101.setBackground(new Color(238, 114, 96));
		    	FormThongTinPhongVaThanhToan f=new FormThongTinPhongVaThanhToan();
		    	f.setVisible(true);
		    }
		});
		panelPhong101.addMouseListener(new MouseAdapter() {
//		    public void mousePressed(MouseEvent e) {
//		        if (e.isPopupTrigger()) {
//		            popupMenu.show(e.getComponent(), e.getX(), e.getY());
//		        }
//		    }
		 
			
			 public void mouseReleased(MouseEvent e) {
				 
				 if(panelPhong101.getBackground().equals(new Color(238, 114, 96))) {
					 
					 if (e.isPopupTrigger()) {
						 menuItem2.setEnabled(true);
						 popupMenu.show(e.getComponent(), e.getX(), e.getY());
					 }
				 }
				 
				 else {
					 
					 if (e.isPopupTrigger()) {
						 menuItem2.setEnabled(false);
						 popupMenu.show(e.getComponent(), e.getX(), e.getY());
					 }
				 }
			 
			 
			 }
		   
		});
		
		
		panelPhong101.setBounds(0, 0, 300, 150);
		panelPhongUITable.add(panelPhong101);
		panelPhong101.setLayout(null);
		
		JLabel lblTenPhong101 = new JLabel("Phòng 101");
		lblTenPhong101.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong101.setBounds(116, 28, 125, 27);
		panelPhong101.add(lblTenPhong101);
		
		JLabel lblLoaiPhong101 = new JLabel("(Thường)");
		lblLoaiPhong101.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong101.setBounds(116, 65, 100, 27);
		panelPhong101.add(lblLoaiPhong101);
		
		JLabel lblTrangThaiPhong101 = new JLabel("Phòng trống");
		lblTrangThaiPhong101.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong101.setBounds(103, 102, 113, 34);
		panelPhong101.add(lblTrangThaiPhong101);
		
		JPanel panelPhong102 = new JPanel();
		panelPhong102.setBackground(new Color(153, 204, 153));
		panelPhong102.setLayout(null);
		panelPhong102.setBounds(299, 0, 300, 150);
		panelPhongUITable.add(panelPhong102);
		
		JLabel lblTenPhong102 = new JLabel("Phòng 102");
		lblTenPhong102.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong102.setBounds(116, 28, 125, 27);
		panelPhong102.add(lblTenPhong102);
		
		JLabel lblLoaiPhong102 = new JLabel("(Thường)");
		lblLoaiPhong102.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong102.setBounds(116, 65, 100, 27);
		panelPhong102.add(lblLoaiPhong102);
		
		JLabel lblTrangThaiPhong102 = new JLabel("Phòng trống");
		lblTrangThaiPhong102.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong102.setBounds(103, 102, 113, 34);
		panelPhong102.add(lblTrangThaiPhong102);
		
		JPanel panelPhong103 = new JPanel();
		panelPhong103.setBackground(new Color(238, 114, 96));
		panelPhong103.setLayout(null);
		panelPhong103.setBounds(599, 0, 300, 150);
		panelPhongUITable.add(panelPhong103);
		
		JLabel lblTenPhong103 = new JLabel("Phòng 103");
		lblTenPhong103.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong103.setBounds(116, 28, 125, 27);
		panelPhong103.add(lblTenPhong103);
		
		JLabel lblLoaiPhong103 = new JLabel("(Thường)");
		lblLoaiPhong103.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong103.setBounds(116, 65, 100, 27);
		panelPhong103.add(lblLoaiPhong103);
		
		JLabel lblTrangThaiPhong103 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong103.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong103.setBounds(79, 102, 167, 34);
		panelPhong103.add(lblTrangThaiPhong103);
		
		JPanel panelPhong104 = new JPanel();
		panelPhong104.setBackground(new Color(240, 245, 50));
		panelPhong104.setLayout(null);
		panelPhong104.setBounds(900, 0, 300, 150);
		panelPhongUITable.add(panelPhong104);
		
		JLabel lblTenPhong104 = new JLabel("Phòng 104");
		lblTenPhong104.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong104.setBounds(116, 28, 125, 27);
		panelPhong104.add(lblTenPhong104);
		
		JLabel lblLoaiPhong104 = new JLabel("(Thường)");
		lblLoaiPhong104.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong104.setBounds(116, 65, 100, 27);
		panelPhong104.add(lblLoaiPhong104);
		
		JLabel lblTrangThaiPhong104 = new JLabel("Phòng đang sửa chữa");
		lblTrangThaiPhong104.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong104.setBounds(72, 102, 205, 34);
		panelPhong104.add(lblTrangThaiPhong104);
		
		JPanel panelPhong202 = new JPanel();
		panelPhong202.setBackground(new Color(153, 204, 153));
		panelPhong202.setLayout(null);
		panelPhong202.setBounds(299, 149, 300, 150);
		panelPhongUITable.add(panelPhong202);
		
		JLabel lblTenPhong202 = new JLabel("Phòng 202");
		lblTenPhong202.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong202.setBounds(116, 28, 125, 27);
		panelPhong202.add(lblTenPhong202);
		
		JLabel lblLoaiPhong202 = new JLabel("(Thường)");
		lblLoaiPhong202.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong202.setBounds(116, 65, 100, 27);
		panelPhong202.add(lblLoaiPhong202);
		
		JLabel lblTrangThaiPhong202 = new JLabel("Phòng trống");
		lblTrangThaiPhong202.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong202.setBounds(103, 102, 113, 34);
		panelPhong202.add(lblTrangThaiPhong202);
		
		JPanel panelPhong203 = new JPanel();
		panelPhong203.setBackground(new Color(153, 204, 153));
		panelPhong203.setLayout(null);
		panelPhong203.setBounds(599, 149, 300, 150);
		panelPhongUITable.add(panelPhong203);
		
		JLabel lblTenPhong203 = new JLabel("Phòng 203");
		lblTenPhong203.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong203.setBounds(116, 28, 125, 27);
		panelPhong203.add(lblTenPhong203);
		
		JLabel lblLoaiPhong203 = new JLabel("(Thường)");
		lblLoaiPhong203.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong203.setBounds(116, 65, 100, 27);
		panelPhong203.add(lblLoaiPhong203);
		
		JLabel lblTrangThaiPhong203 = new JLabel("Phòng trống");
		lblTrangThaiPhong203.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong203.setBounds(103, 102, 113, 34);
		panelPhong203.add(lblTrangThaiPhong203);
		
		JPanel panelPhong204 = new JPanel();
		panelPhong204.setBackground(new Color(153, 204, 153));
		panelPhong204.setLayout(null);
		panelPhong204.setBounds(900, 149, 300, 150);
		panelPhongUITable.add(panelPhong204);
		
		JLabel lblTenPhong204 = new JLabel("Phòng 204");
		lblTenPhong204.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong204.setBounds(116, 28, 125, 27);
		panelPhong204.add(lblTenPhong204);
		
		JLabel lblLoaiPhong204 = new JLabel("(Thường)");
		lblLoaiPhong204.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong204.setBounds(116, 65, 100, 27);
		panelPhong204.add(lblLoaiPhong204);
		
		JLabel lblTrangThaiPhong204 = new JLabel("Phòng trống");
		lblTrangThaiPhong204.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong204.setBounds(103, 102, 113, 34);
		panelPhong204.add(lblTrangThaiPhong204);
		
		JPanel panelPhong304 = new JPanel();
		panelPhong304.setBackground(new Color(153, 204, 153));
		panelPhong304.setLayout(null);
		panelPhong304.setBounds(900, 298, 300, 150);
		panelPhongUITable.add(panelPhong304);
		
		JLabel lblTenPhong304 = new JLabel("Phòng 304");
		lblTenPhong304.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong304.setBounds(116, 28, 125, 27);
		panelPhong304.add(lblTenPhong304);
		
		JLabel lblLoaiPhong304 = new JLabel("(VIP)");
		lblLoaiPhong304.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong304.setBounds(136, 65, 100, 27);
		panelPhong304.add(lblLoaiPhong304);
		
		JLabel lblTrangThaiPhong304 = new JLabel("Phòng trống");
		lblTrangThaiPhong304.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong304.setBounds(103, 102, 113, 34);
		panelPhong304.add(lblTrangThaiPhong304);
		
		JPanel panelPhong402 = new JPanel();
		panelPhong402.setBackground(new Color(153, 204, 153));
		panelPhong402.setLayout(null);
		panelPhong402.setBounds(299, 450, 300, 150);
		panelPhongUITable.add(panelPhong402);
		
		JLabel lblTenPhong402 = new JLabel("Phòng 402");
		lblTenPhong402.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong402.setBounds(116, 28, 125, 27);
		panelPhong402.add(lblTenPhong402);
		
		JLabel lblLoaiPhong402 = new JLabel("(Thường)");
		lblLoaiPhong402.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong402.setBounds(116, 65, 100, 27);
		panelPhong402.add(lblLoaiPhong402);
		
		JLabel lblTrangThaiPhong402 = new JLabel("Phòng trống");
		lblTrangThaiPhong402.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong402.setBounds(103, 102, 113, 34);
		panelPhong402.add(lblTrangThaiPhong402);
		
		JPanel panelPhong403 = new JPanel();
		panelPhong403.setBackground(new Color(153, 204, 153));
		panelPhong403.setLayout(null);
		panelPhong403.setBounds(599, 450, 300, 150);
		panelPhongUITable.add(panelPhong403);
		
		JLabel lblTenPhong403 = new JLabel("Phòng 403");
		lblTenPhong403.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong403.setBounds(116, 28, 125, 27);
		panelPhong403.add(lblTenPhong403);
		
		JLabel lblLoaiPhong403 = new JLabel("(Thường)");
		lblLoaiPhong403.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong403.setBounds(116, 65, 100, 27);
		panelPhong403.add(lblLoaiPhong403);
		
		JLabel lblTrangThaiPhong403 = new JLabel("Phòng trống");
		lblTrangThaiPhong403.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong403.setBounds(103, 102, 113, 34);
		panelPhong403.add(lblTrangThaiPhong403);
		
		JPanel panelPhong404 = new JPanel();
		panelPhong404.setBackground(new Color(153, 204, 153));
		panelPhong404.setLayout(null);
		panelPhong404.setBounds(900, 450, 300, 150);
		panelPhongUITable.add(panelPhong404);
		
		JLabel lblTenPhong404 = new JLabel("Phòng 404");
		lblTenPhong404.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong404.setBounds(116, 28, 125, 27);
		panelPhong404.add(lblTenPhong404);
		
		JLabel lblLoaiPhong404 = new JLabel("(Thường)");
		lblLoaiPhong404.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong404.setBounds(116, 65, 100, 27);
		panelPhong404.add(lblLoaiPhong404);
		
		JLabel lblTrangThaiPhong404 = new JLabel("Phòng trống");
		lblTrangThaiPhong404.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong404.setBounds(103, 102, 113, 34);
		panelPhong404.add(lblTrangThaiPhong404);
		
		JPanel panelPhong201 = new JPanel();
		panelPhong201.setBackground(new Color(238, 114, 96));
		panelPhong201.setLayout(null);
		panelPhong201.setBounds(0, 149, 300, 150);
		panelPhongUITable.add(panelPhong201);
		
		JLabel lblTenPhong201 = new JLabel("Phòng 201");
		lblTenPhong201.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong201.setBounds(116, 28, 125, 27);
		panelPhong201.add(lblTenPhong201);
		
		JLabel lblLoaiPhong201 = new JLabel("(Thường)");
		lblLoaiPhong201.setBackground(new Color(240, 245, 50));
		lblLoaiPhong201.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong201.setBounds(116, 65, 100, 27);
		panelPhong201.add(lblLoaiPhong201);
		
		JLabel lblTrangThaiPhong201 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong201.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong201.setBounds(79, 102, 167, 34);
		panelPhong201.add(lblTrangThaiPhong201);
		
		JPanel panelPhong301 = new JPanel();
		panelPhong301.setBackground(new Color(238, 114, 96));
		panelPhong301.setLayout(null);
		panelPhong301.setBounds(0, 298, 300, 150);
		panelPhongUITable.add(panelPhong301);
		
		JLabel lblTenPhong301 = new JLabel("Phòng 301");
		lblTenPhong301.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong301.setBounds(116, 28, 125, 27);
		panelPhong301.add(lblTenPhong301);
		
		JLabel lblLoaiPhong301 = new JLabel("(VIP)");
		lblLoaiPhong301.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong301.setBounds(126, 65, 100, 27);
		panelPhong301.add(lblLoaiPhong301);
		
		JLabel lblTrangThaiPhong301 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong301.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong301.setBounds(79, 102, 167, 34);
		panelPhong301.add(lblTrangThaiPhong301);
		
		JPanel panelPhong302 = new JPanel();
		panelPhong302.setBackground(new Color(238, 114, 96));
		panelPhong302.setLayout(null);
		panelPhong302.setBounds(299, 298, 300, 150);
		panelPhongUITable.add(panelPhong302);
		
		JLabel lblTenPhong302 = new JLabel("Phòng 302");
		lblTenPhong302.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong302.setBounds(116, 28, 125, 27);
		panelPhong302.add(lblTenPhong302);
		
		JLabel lblLoaiPhong302 = new JLabel("(VIP)");
		lblLoaiPhong302.setBackground(new Color(238, 114, 96));
		lblLoaiPhong302.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong302.setBounds(126, 65, 100, 27);
		panelPhong302.add(lblLoaiPhong302);
		
		JLabel lblTrangThaiPhong302 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong302.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong302.setBounds(79, 102, 167, 34);
		panelPhong302.add(lblTrangThaiPhong302);
		
		JPanel panelPhong303 = new JPanel();
		panelPhong303.setBackground(new Color(238, 114, 96));
		panelPhong303.setLayout(null);
		panelPhong303.setBounds(599, 298, 300, 150);
		panelPhongUITable.add(panelPhong303);
		
		JLabel lblTenPhong303 = new JLabel("Phòng 303");
		lblTenPhong303.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong303.setBounds(116, 28, 125, 27);
		panelPhong303.add(lblTenPhong303);
		
		JLabel lblLoaiPhong303 = new JLabel("(VIP)");
		lblLoaiPhong303.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong303.setBounds(126, 65, 100, 27);
		panelPhong303.add(lblLoaiPhong303);
		
		JLabel lblTrangThaiPhong303 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong303.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTrangThaiPhong303.setBounds(79, 102, 167, 34);
		panelPhong303.add(lblTrangThaiPhong303);
		
		JPanel panelPhong401 = new JPanel();
		panelPhong401.setBackground(new Color(240, 245, 50));
		panelPhong401.setLayout(null);
		panelPhong401.setBounds(0, 450, 300, 150);
		panelPhongUITable.add(panelPhong401);
		
		JLabel lblTenPhong401 = new JLabel("Phòng 401");
		lblTenPhong401.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTenPhong401.setBounds(116, 28, 125, 27);
		panelPhong401.add(lblTenPhong401);
		
		JLabel lblLoaiPhong401 = new JLabel("(Thường)");
		lblLoaiPhong401.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLoaiPhong401.setBounds(116, 65, 100, 27);
		panelPhong401.add(lblLoaiPhong401);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phòng đang sửa chữa");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1_1_1_1.setBounds(72, 102, 205, 34);
		panelPhong401.add(lblNewLabel_1_1_1_1_1);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
