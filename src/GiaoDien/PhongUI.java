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
		btnpdck.setBackground(new Color(255, 153, 153));
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
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 156, 1197, 523);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(4,4));
		//		<html> <center> Phòng A01<br/>(VIP)<br/>Phòng Trống   </center></html>
				JButton btnNewButton_1 = new JButton("<html><div style='text-align: center;'>Phòng 101<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton_1.setBackground(new Color(153, 204, 153));
				panel.add(btnNewButton_1);
				
				JPopupMenu popupMenu = new JPopupMenu();
				addPopup(btnNewButton_1, popupMenu);
				
				JMenuItem mntmdatphong = new JMenuItem("Đặt Phòng");
				mntmdatphong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnNewButton_1.getBackground().equals(Color.red)) {
							  JOptionPane.showMessageDialog(null, "Phòng đã có người thuê");
						}
						else {
							  if (JOptionPane.showConfirmDialog(null, "Ban Muon Đặt Phòng ??","Lưu Ý !!!",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {

									 
									JFrame hmm= new JFrame();
									hmm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
									hmm.setBounds(100, 100, 450, 300);
							 
									setContentPane(contentPane);
									hmm.getContentPane().setLayout(null);
								 
									JButton btnhmm = new JButton("hmm");
									btnhmm.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent e) {
											btnNewButton_1.setBackground(new Color(224, 63, 63));
											btnNewButton_1.setText("<html><div style='text-align: center;'>Phòng 101<br> <br>(Thường)  <br> <br> Phòng Đã Có Khách</div></html>");
											 hmm.setVisible(false);
										}
									});
									btnhmm.setBounds(227, 202, 89, 23);
									hmm.getContentPane().add(btnhmm);
									 hmm.setVisible(true);
							  }
						}
					}
				});
				popupMenu.add(mntmdatphong);
				
				JMenuItem mntmTraPhong = new JMenuItem("Trả Phòng");
				mntmTraPhong.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null,"Phong chua dat Khong the tra");
					}
				});
				popupMenu.add(mntmTraPhong);
		
		JButton btnNewButton_2 = new JButton("<html><div style='text-align: center;'>Phòng 102<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_2.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("<html><div style='text-align: center;'>Phòng 103<br> <br>(Thường)  <br> <br> Phòng Đã Có Khách</div></html>");
		btnNewButton_3.setBackground(new Color(224, 63, 63));
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("<html><div style='text-align: center;'>Phòng 104<br> <br>(Thường)  <br> <br> Phòng Đang Sửa Chữa</div></html>");
		btnNewButton_4.setBackground(new Color(255, 255, 128));
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_8 = new JButton("<html><div style='text-align: center;'>Phòng 201<br> <br>(Thường)  <br> <br> Phòng Đã Có Khách</div></html>");
		btnNewButton_8.setBackground(new Color(224, 63, 63));
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_5 = new JButton("<html><div style='text-align: center;'>Phòng 202<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_5.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_12 = new JButton("<html><div style='text-align: center;'>Phòng 203<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_12.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_12);
		
		JButton btnNewButton = new JButton("<html><div style='text-align: center;'>Phòng 204<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton);
		
		JButton btnNewButton_10 = new JButton("<html><div style='text-align: center;'>Phòng 301<br> <br>(VIP)  <br> <br> Phòng Đã Có Khách</div></html>");
		btnNewButton_10.setBackground(new Color(224, 63, 63));
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("<html><div style='text-align: center;'>Phòng 302<br> <br>(VIP)  <br> <br> Phòng Đã Có Khách</div></html>");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_11.setBackground(new Color(224, 63, 63));
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_13 = new JButton("<html><div style='text-align: center;'>Phòng 303<br> <br>(VIP)  <br> <br> Phòng Đã Có Khách</div></html>");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_13.setBackground(new Color(224, 63, 63));
		panel.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("<html><div style='text-align: center;'>Phòng 304<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_14.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("<html><div style='text-align: center;'>Phòng 401<br> <br>(Thường)  <br> <br> Phòng Đang Sửa Chữa</div></html>");
		btnNewButton_15.setBackground(new Color(255, 255, 128));
		panel.add(btnNewButton_15);
		
		JButton btnNewButton_2_1 = new JButton("<html><div style='text-align: center;'>Phòng 402<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_2_1.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_2_1);
		
		JButton btnNewButton_2_1_1 = new JButton("<html><div style='text-align: center;'>Phòng 403<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_2_1_1.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_2_1_1);
		
		JButton btnNewButton_2_1_2 = new JButton("<html><div style='text-align: center;'>Phòng 404<br> <br>(Thường)  <br> <br> Phòng Trống</div></html>");
		btnNewButton_2_1_2.setBackground(new Color(153, 204, 153));
		panel.add(btnNewButton_2_1_2);
		
		JButton btnNewButton_6 = new JButton("Thoát");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_6.setBounds(1071, 44, 104, 31);
		contentPane.add(btnNewButton_6);
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
