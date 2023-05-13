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
import javax.swing.JTextField;

public class TrangChuUI extends JFrame {

	private JPanel contentPane;
	private TrangDangNhapUI tdnui1;
	public JLabel txtquyendangnhap;
	public JLabel txtmanvdn;
	public JButton btnnhavien;
	public DatPhong ftt= new DatPhong();
	private static String loggedInUser;
	public JButton btnPhng;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuUI frame = new TrangChuUI();
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
	public TrangChuUI() {
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
		lblNewLabel.setBounds(23, 51, 258, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnHome = new FixButton("Home");
		btnHome.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/home-icon.png")));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnHome.setBorderPainted(false);
		btnHome.setBackground(new Color(242, 208, 183));
		btnHome.setBounds(50, 131, 194, 48);
		contentPane.add(btnHome);
		
		
		
		  btnnhavien = new FixButton("Nhân viên");
		btnnhavien.setBackground(new Color(242, 208, 183));
		btnnhavien.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/Administrator-icon.png")));
		btnnhavien.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
	// su kien click vao button nv ra fram nhan vien
		btnnhavien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NhanVienUI nv= new NhanVienUI();
				nv.setVisible(true);
				
				
			}
		});
		btnnhavien.setBorderPainted(false);
		btnnhavien.setBounds(50, 225, 194, 48);
		contentPane.add(btnnhavien);
		 
		
		
		JButton btnKhchHng = new FixButton("Khách Hàng");
		btnKhchHng.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/man-icon.png")));
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhchHng.setBorderPainted(false);
		btnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 17));
		// su kien click vao button khach hang ra frame khách hàng
		btnKhchHng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachhangUI kh= new KhachhangUI();
				kh.setVisible(true);
				
				
			}
		});
		
		
		btnKhchHng.setBackground(new Color(242, 208, 183));
		btnKhchHng.setBounds(50, 321, 194, 48);
		contentPane.add(btnKhchHng);
		
		btnPhng = new FixButton("Phòng");
		btnPhng.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/Shoji2-paper-sliding-door-icon.png")));
		btnPhng.setFont(new Font("Tahoma", Font.PLAIN, 17));
	
		// su kien click vao button phong ra frame phong
		btnPhng.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PhongUI phong= new PhongUI();
						phong.setVisible(true);
						
					}
				});
				
				
		btnPhng.setBackground(new Color(242, 208, 183));
		btnPhng.setBounds(50, 421, 194, 48);
		contentPane.add(btnPhng);
		btnPhng.setBorderPainted(false);
		
		
		JButton btnDchV = new FixButton("Dịch Vụ");
		btnDchV.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/Household-Bell-Service-icon.png")));
		btnDchV.setFont(new Font("Tahoma", Font.PLAIN, 17));

		// su kien click vao button dich vu ra frame dich vu
		btnDchV.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DichVuUI dv= new DichVuUI();
						dv.setVisible(true);
						
					}
				});
		
		btnDchV.setBackground(new Color(242, 208, 183));
		btnDchV.setBounds(50, 507, 194, 48);
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
		
		JButton btnThngK = new FixButton("Thống kê");
		btnThngK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ThongKe tk= new ThongKe();
				tk.setVisible(true);
			}
		});
		btnThngK.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/Numbers-icon.png")));
		btnThngK.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		
		btnThngK.setBackground(new Color(242, 208, 183));
		btnThngK.setBounds(60, 619, 184, 48);
		contentPane.add(btnThngK);
		btnThngK.setBorderPainted(false);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 153, 153));
		lblNewLabel_1.setIcon(new ImageIcon(TrangChuUI.class.getResource("/img/homeslidehmm.png")));
		lblNewLabel_1.setBounds(273, 77, 1101, 544);
		 contentPane.add(lblNewLabel_1);
		 
		 JLabel lblNewLabel_2 = new JLabel("Quyền :");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_2.setBounds(23, 21, 88, 31);
		 contentPane.add(lblNewLabel_2);
		 
		 JLabel lblNewLabel_2_1 = new JLabel("Mã Nhân Viên :");
		 lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		 lblNewLabel_2_1.setBounds(248, 21, 155, 31);
		 contentPane.add(lblNewLabel_2_1);
		 
		  txtmanvdn = new JLabel("New label");
		 txtmanvdn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 txtmanvdn.setBounds(413, 25, 102, 26);
		 contentPane.add(txtmanvdn);
		 
		   txtquyendangnhap = new JLabel("New label");
		 txtquyendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 txtquyendangnhap.setBounds(110, 25, 102, 26);
		 contentPane.add(txtquyendangnhap);
		
		 
		  
		TrangDangNhapUI tdnui=new TrangDangNhapUI();
//	
//		System.out.println(	 tdnui.selectedOption);
//		
//		if(tdnui.selectedOption.equals(tdnui))
		
		 
//		Phân QUyền
//		 String input = tdnui.txttk.getText(); // Lấy chuỗi đầu vào từ JTextField
//		 String firstTwoChars = input.substring(0, 2);
//		 
//		 
//		if(firstTwoChars.equals("NV")) {
//			txtquyendangnhap.setText("Nhân Viên");
//			txttendk.setText(tdnui.txttk.getText());
//			btnnhavien.setEnabled(false);
//			btnnhavien.setToolTipText("Mục Này Dành Cho Quản Lý");
//		}
//		else {
//			txtquyendangnhap.setText("Quản Lý");
//			txttendk.setText(input);
//		}
		 
		 
		 
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
//				btnThngK.addMouseListener(new MouseAdapter() {
//				    @Override
//				    public void mouseEntered(MouseEvent e) {
//				    	btnThngK.setBackground(Color.white);
//				    }
//
//				    @Override
//				    public void mouseExited(MouseEvent e) {
//				    	btnThngK.setBackground(Color(255, 153, 153));
//				    }
//
//					private Color Color(int i, int j, int k) {
//						// TODO Auto-generated method stub
//						return null;
//					}
//				});
	}
	public static void setLoggedInUser(String username) {
        loggedInUser = username;
    }

    public static String getLoggedInUser() {
        return loggedInUser;
    }
}
