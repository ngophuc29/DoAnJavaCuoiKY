package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TrangChu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChu frame = new TrangChu();
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
	public TrangChu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1361, 794);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(242, 208, 183));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Khách Sạn Bình Dương");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 27, 296, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setIcon(new ImageIcon(TrangChu.class.getResource("/img/home-icon.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorderPainted(false);
		btnHome.setBackground(new Color(242, 208, 183));
		btnHome.setBounds(50, 102, 194, 48);
		contentPane.add(btnHome);
		
		
		
		JButton btnnhavien = new JButton("Nhân viên");
		btnnhavien.setBackground(new Color(242, 208, 183));
		btnnhavien.setIcon(new ImageIcon(TrangChu.class.getResource("/img/Administrator-icon.png")));
		btnnhavien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
	// su kien click vao button nv ra fram nhan vien
		btnnhavien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVien nv= new NhanVien();
				nv.setVisible(true);
				
				
			}
		});
		btnnhavien.setBorderPainted(false);
		btnnhavien.setBounds(46, 188, 194, 48);
		contentPane.add(btnnhavien);
		
		JButton btnKhchHng = new JButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(TrangChu.class.getResource("/img/man-icon.png")));
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhchHng.setBorderPainted(false);
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		// su kien click vao button khach hang ra frame khách hàng
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Khachhang kh= new Khachhang();
				kh.setVisible(true);
				
				
			}
		});
		
		
		btnKhchHng.setBackground(new Color(242, 208, 183));
		btnKhchHng.setBounds(46, 287, 194, 48);
		contentPane.add(btnKhchHng);
		
		JButton btnPhng = new JButton("Phòng");
		btnPhng.setIcon(new ImageIcon(TrangChu.class.getResource("/img/Shoji2-paper-sliding-door-icon.png")));
		btnPhng.setFont(new Font("Tahoma", Font.PLAIN, 17));
	
		// su kien click vao button phong ra frame phong
		btnPhng.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Phong phong= new Phong();
						phong.setVisible(true);
						
					}
				});
				
				
		btnPhng.setBackground(new Color(242, 208, 183));
		btnPhng.setBounds(46, 381, 194, 48);
		contentPane.add(btnPhng);
		btnPhng.setBorderPainted(false);
		
		
		JButton btnDchV = new JButton("Dịch Vụ");
		btnDchV.setIcon(new ImageIcon(TrangChu.class.getResource("/img/Household-Bell-Service-icon.png")));
		btnDchV.setFont(new Font("Tahoma", Font.PLAIN, 17));

		// su kien click vao button dich vu ra frame dich vu
		btnDchV.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DichVu dv= new DichVu();
						dv.setVisible(true);
						
					}
				});
		
		btnDchV.setBackground(new Color(242, 208, 183));
		btnDchV.setBounds(46, 477, 194, 48);
		contentPane.add(btnDchV);
		

		btnDchV.setBorderPainted(false);
		// sự kiện khi hover chuột vào và đổi màu jbutton
		btnnhavien.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnnhavien.setBackground(Color.white);
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnnhavien.setBackground(Color(255, 153, 153));
		    }

			private Color Color(int i, int j, int k) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		JButton btnThngK = new JButton("Thống kê");
		btnThngK.setIcon(new ImageIcon(TrangChu.class.getResource("/img/Numbers-icon.png")));
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		btnThngK.setBackground(new Color(242, 208, 183));
		btnThngK.setBounds(56, 573, 184, 48);
		contentPane.add(btnThngK);
		btnThngK.setBorderPainted(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 153, 153));
		lblNewLabel_1.setIcon(new ImageIcon(TrangChu.class.getResource("/img/homeslidehmm.png")));
		lblNewLabel_1.setBounds(273, 77, 1101, 544);
		 contentPane.add(lblNewLabel_1);
		
		
		
		// sự kiện khi hover chuột vào và đổi màu jbutton
		 
		 btnHome.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			    	btnHome.setBackground(Color.white);
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			    	btnHome.setBackground(Color(255, 153, 153));
			    }

				private Color Color(int i, int j, int k) {
					// TODO Auto-generated method stub
					return null;
				}
			});
		 
		 btnnhavien.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	btnnhavien.setBackground(Color.white);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	btnnhavien.setBackground(Color(255, 153, 153));
				    }

					private Color Color(int i, int j, int k) {
						// TODO Auto-generated method stub
						return null;
					}
				});
				btnKhchHng.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	btnKhchHng.setBackground(Color.white);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	btnKhchHng.setBackground(Color(255, 153, 153));
				    }

					private Color Color(int i, int j, int k) {
						// TODO Auto-generated method stub
						return null;
					}
				});
				btnPhng.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	btnPhng.setBackground(Color.white);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	btnPhng.setBackground(Color(255, 153, 153));
				    }

					private Color Color(int i, int j, int k) {
						// TODO Auto-generated method stub
						return null;
					}
				});
				btnDchV.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	btnDchV.setBackground(Color.white);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	btnDchV.setBackground(Color(255, 153, 153));
				    }

					private Color Color(int i, int j, int k) {
						// TODO Auto-generated method stub
						return null;
					}
				});
				btnThngK.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				    	btnThngK.setBackground(Color.white);
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				    	btnThngK.setBackground(Color(255, 153, 153));
				    }

					private Color Color(int i, int j, int k) {
						// TODO Auto-generated method stub
						return null;
					}
				});
	}

}
