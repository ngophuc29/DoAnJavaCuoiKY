package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTD;

import DAO.chitietPhongDAO;
import DAO.chitietdichVuDAO;
import DAO.dichVuDAO;
import DAO.hoadonDAO;
import DAO.phongDAO;
import database.ConnectDB;
import entity.HoaDon;
import entity.chitietDatPhong;
import entity.chitietdichVu;
import entity.dichVu;
import entity.phong;

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
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 

public class PhongUI extends JFrame {

	private JPanel contentPane;
	private phongDAO phongdaoo = new phongDAO();
	private boolean isMenu2EventAdded = false;
	private chitietdichVuDAO ctdvdao= new chitietdichVuDAO();
	private chitietPhongDAO ctpdao= new chitietPhongDAO();
	private static FormThongTinPhongVaThanhToan f;
	private dichVuDAO dvdao= new dichVuDAO();	
	private hoadonDAO hddao= new hoadonDAO();
	private chitietdichVuDAO ctdvdao1= new chitietdichVuDAO();
	private chitietPhongDAO ctpdao1= new chitietPhongDAO();
	private SimpleDateFormat sdf;
	private static FrmHoaDon frmhd;
	
	private static boolean ktra=false;
	
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
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1396, 809);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(182, 208, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPhng = new FixButton("Phòng");
//		btnPhng.setIcon(new ImageIcon(Phong.class.getResource("/img/Shoji2-paper-sliding-door-icon.png"))); 	
		btnPhng.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPhng.setBorderPainted(false);
		btnPhng.setBackground(new Color(182, 208, 252));
		btnPhng.setBounds(41, 24, 206, 51);
		contentPane.add(btnPhng);
		
		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setBackground(new Color(177, 234, 162));
		lblNewLabel.setBounds(375, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnpt = new FixButton(" ");
		btnpt.setBackground(new Color(153, 204, 153));
		btnpt.setBounds(295, 55, 35, 14);
		contentPane.add(btnpt);
		
		JLabel lblpt = new JLabel("Phòng Trống");
		lblpt.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpt.setBounds(340, 49, 144, 23);
		contentPane.add(lblpt);
		
		JButton btnpdck = new FixButton(" ");
		btnpdck.setBackground(new Color(238, 114, 96));
		btnpdck.setBounds(511, 55, 35, 14);
		contentPane.add(btnpdck);
		
		JLabel lblpdck = new JLabel("Phòng Đã Có Khách");
		lblpdck.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpdck.setBounds(567, 49, 144, 23);
		contentPane.add(lblpdck);
		
		JButton btnpdsc = new FixButton(" ");
		btnpdsc.setBackground(new Color(240, 245, 50));
		btnpdsc.setBounds(766, 58, 35, 14);
		contentPane.add(btnpdsc);
		
		JLabel lblpdsc = new JLabel("Phòng Đang Sửa Chữa");
		lblpdsc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblpdsc.setBounds(823, 49, 183, 23);
		contentPane.add(lblpdsc);
		
		JButton btnNewButton_6 = new FixButton("Thoát");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 16));
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
		JMenuItem menuItem3 = new JMenuItem("Dọn Phòng");
		popupMenu.add(menuItem1);
		popupMenu.add(menuItem2);
 
		
		//
		
		
		JPanel panelPhong101 = new JPanel();
		panelPhong101.setBackground(new Color(153, 204, 153));
		
		
		
		panelPhong101.setBounds(0, 0, 300, 150);
		panelPhongUITable.add(panelPhong101);
		panelPhong101.setLayout(null);
		
		JLabel lblTenPhong101 = new JLabel("101");
		lblTenPhong101.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong101.setBounds(127, 27, 43, 27);
		panelPhong101.add(lblTenPhong101);
		
		JLabel lblLoaiPhong101 = new JLabel("(Thường)");
		lblLoaiPhong101.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong101.setBounds(116, 65, 100, 27);
		panelPhong101.add(lblLoaiPhong101);
		
		JLabel lblTrangThaiPhong101 = new JLabel("Phòng trống");
		lblTrangThaiPhong101.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong101.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong101.setBounds(55, 103, 175, 34);
		panelPhong101.add(lblTrangThaiPhong101);
		
		
		//sự kiện Phòng 1
		
		menuItem1.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Xử lý sự kiện ở đây
		    	 JPanel panel = (JPanel) popupMenu.getInvoker();
		    	 JLabel label1 = (JLabel) panel.getComponent(0);
		    	 //them form dat phong
		    	 DatPhong dt=new DatPhong();
		    	 dt.setVisible(true);
		    	 dt.txtmaphongdat.setText(label1.getText());
		    	 dt.btnDatPhong.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
				    	 panel.setBackground(new Color(238, 114, 96));
				    	 JLabel label = (JLabel) panel.getComponent(2);
				    	  label.setText("Phòng đã có khách");				    	  
						    	 
				    	  JLabel label1 = (JLabel) panel.getComponent(0);
				    	  phongdaoo.update("Phòng đã có khách",label1.getText());
//							ConnectDB.getinstance();
//							Connection con =ConnectDB.getConnection();
//							String sql="select c. from chitietPhong c join ";
				    	  try {
							
							String maKH=dt.combomaKH.getSelectedItem().toString();
							String maNV=TrangDangNhapUI.getMaNV();
							String maPhong=dt.txtmaphongdat.getText();
							String trangthai="CTT";
							
							
							if(kiemtraTonTaiCTT(maKH)==0) {
								
								HoaDon hd= new HoaDon(maKH, maNV, trangthai);
								hoadonDAO.themHD(hd);
							}
							
							
							
							String mahoadon= laymahoadon(maKH);
						 
							//
							long millis=System.currentTimeMillis();  
							java.sql.Date date=new java.sql.Date(millis);  
							//
							
						chitietDatPhong ctdp=new chitietDatPhong(maPhong, mahoadon, 800,date);
							ctpdao.insert(ctdp);
							
							
							
						} catch (Exception e2) {
							e2.printStackTrace();
						}
					}
				});
		    	 //
		        
//		    	panelPhong101.setBackground(new Color(238, 114, 96));
//		    	lblTrangThaiPhong101.setText("Phòng Đã Có Khách");
		    }
		});
		
		
		menuItem2.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Xử lý sự kiện ở đây
//		    	panelPhong101.setBackground(new Color(238, 114, 96));
		    	JPanel panel = (JPanel) popupMenu.getInvoker();
		    	JLabel label1 = (JLabel) panel.getComponent(0);
		    	ktra=false;
		        f = new FormThongTinPhongVaThanhToan();
		        f.setVisible(true);
		    	 
		    	String makh= laymaKH(label1.getText());
		    	f.txttenKH.setText(makh);
		    	f.txttenKH.setText(laymaKH(label1.getText()));
		    	f.modelkhachhang.setRowCount(0);
				
				ConnectDB.getinstance();
				Connection con =ConnectDB.getConnection();
				PreparedStatement stmt=null;
				try {
					String sql="  select * from chitietHoaDonPhong where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
					stmt=con.prepareStatement(sql);
					stmt.setString(1, makh);
					ResultSet rs =stmt.executeQuery();
					while(rs.next()) {
//						dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
						Object []obj= {rs.getString(1), rs.getString(2),    rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)};
						f.modelkhachhang.addRow(obj);
	
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
					String mahoadon= laymahoadon(makh);
					String madv= dvdao.laytentheomaKh(f.comboBox.getSelectedItem().toString());
					int solluong = 3;
					
					f.txtTongTienPhong.setText(Double.toString(ctpdao.tongtienphong(mahoadon)));
					 
					f.comboBox.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            	
			            	ConnectDB.getinstance();
							Connection con =ConnectDB.getConnection();
							PreparedStatement stmt=null;
							
			                String selectedOption = (String) f.comboBox.getSelectedItem();
			                if (selectedOption.equals("Nước CoCa")) {
			                    // Mở ra JFrame tương ứng với Option 1
			                	  f.openOptionFrame("Nước CoCa",mahoadon,"DV101");
			                }  if (selectedOption.equals("Nước Pepsi")) {
			                    // Mở ra JFrame tương ứng với Option 2
			                	f.openOptionFrame("Nước Pepsi",mahoadon,"DV102");
			                }  if (selectedOption.equals("Nước 7UP")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Nước 7UP",mahoadon,"DV103");
			                }
			                if (selectedOption.equals("Cà Phê")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Cà Phê",mahoadon,"DV104");
			                }
			                if (selectedOption.equals("Bạc Xỉu")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Bạc Xỉu",mahoadon,"DV105");
			                }
			                if (selectedOption.equals("Bia Heneiken")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Bia Heneiken",mahoadon,"DV106");
			                }
			                if (selectedOption.equals("Bia Sài Gòn Bạc")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Bia Sài Gòn Bạc",mahoadon,"DV107");
			                }
			                if (selectedOption.equals("Bia 333")) {
			                    // Mở ra JFrame tương ứng với Option 3
			                	f.openOptionFrame("Bia 333",mahoadon,"DV108");
			                		
								try {
									String sql="  select ctdv.machitiethoadon,dv.tendichvu,dv.giadichvu,ctdv.soluongdichvu from chitiethoadondichvu ctdv join dichvu dv on ctdv.madichvu=dv.madichvu where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
									stmt=con.prepareStatement(sql);
									stmt.setString(1, makh);
									ResultSet rs =stmt.executeQuery();
									while(rs.next()) {
//										dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
										Object []obj= {rs.getString(1), rs.getString(2),    rs.getDouble(3), rs.getInt(4), rs.getDouble(3)*rs.getInt(4)};
										f.modelchitietdichVu.addRow(obj);
										System.out.println(rs.getString(1));
									}
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
			                	
			                }
			            }
			        });
					
//					
//					f.txtTongTienPhong.setText(Double.toString(ctpdao.tongtienphong(mahoadon)));
					
					try {
						String sql="  select ctdv.machitiethoadon,dv.tendichvu,dv.giadichvu,ctdv.soluongdichvu from chitiethoadondichvu ctdv join dichvu dv on ctdv.madichvu=dv.madichvu where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
						stmt=con.prepareStatement(sql);
						stmt.setString(1, makh);
						ResultSet rs =stmt.executeQuery();
						while(rs.next()) {
//							dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
							Object []obj= {rs.getString(1), rs.getString(2),    rs.getDouble(3), rs.getInt(4), rs.getDouble(3)*rs.getInt(4)};
							 
							
							f.modelchitietdichVu.addRow(obj);
	
							
							//
							
							 
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					f.txttongtiendichvu.setText(Double.toString(ctdvdao.tongtiendichvu(makh)));
				
				 
					
					f.txttongtienThanhToan.setText(Double.toString(ctdvdao.tongtiendichvu(makh)+ctpdao.tongtienphong(mahoadon)));
					
					
				 
				f.btnThanhToan.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
//						 panel.setBackground(new Color(153, 204, 153));
						// TODO Auto-generated method stub
						//label1.gettext() la de lay ma phong
						
//						JOptionPane.showMessageDialog(null, "OKKKKK");
						
						
						//
//						Date date = new Date();
//						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//						String dateString = dateFormat.format(date);
				        
						LocalDateTime dateTime = LocalDateTime.now();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
						String dateTimeString = dateTime.format(formatter);
						
						
						
						
						sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						dvdao= new dichVuDAO();
						if(ktra==true) {
							if(!f.txttienKhachDua.getText().equals("")  && !(Double.parseDouble(f.txttienKhachDua.getText())<Double.parseDouble(f.txttongtienThanhToan.getText()))) {
								HoaDon hdnew= new HoaDon(mahoadon, makh, "", label1.getText(),ctdvdao1.tongtiendichvu(makh)+ctpdao1.tongtienphong(mahoadon),f.txtngaytraphong.getText());
								frmhd = new FrmHoaDon(hdnew);
								List<dichVu>ds=dvdao.hoadonlist(makh);
								frmhd.modelhoadon.getDataVector().removeAllElements();
								int i=1;
								for (dichVu ctdv : ds) {
									String obj[]= {i+"",ctdv.getMadichvu(), ctdv.getSoluong()+"",ctdv.getGiadichvu()+""};
									frmhd.modelhoadon.addRow(obj);
									i++;
								}
								frmhd.table.setModel(frmhd.modelhoadon);
								phongdaoo.update1("Phòng trống", makh);
								
								//
								
								//update trang thai va them tien phong tien dich vu
								hddao.update(24,  ctdvdao1.tongtiendichvu(makh) , ctdvdao1.tongtiendichvu(makh)+ctpdao1.tongtienphong(mahoadon), ctpdao1.tongtienphong(mahoadon), "DTT", mahoadon);
								phongDAO dsphong=new phongDAO();
								List<phong> ds1= dsphong.laytenPhongtheott("Phòng trống");
								for (phong phong : ds1) {
									  Component[] components =panelPhongUITable.getComponents();
									    for (Component component : components) {
									        if (component instanceof JPanel) {
									          JPanel panel=(JPanel)component;
									          JLabel label=(JLabel) panel.getComponent(0);
									          JLabel label1=(JLabel) panel.getComponent(2);
									            if(label.getText().equals(phong.getMaPhong())) {		            
									            	panel.setBackground(new Color(153, 204, 153));
									            	label1.setText("Phòng trống");
									            }
									        }
									    }
								}
//							
								frmhd.setVisible(true);
							}
							
						}else {
							JOptionPane.showMessageDialog(null, "Vui lòng bấm trả phòng !!");
						}
						
						
//						HoaDon hdnew= new HoaDon(mahoadon, makh, "", label1.getText(),ctdvdao1.tongtiendichvu(makh)+ctpdao1.tongtienphong(mahoadon));
//						frmhd = new FrmHoaDon(hdnew);
						
						
						//
//						dvdao= new dichVuDAO();
//						List<dichVu>ds=dvdao.hoadonlist(makh);
//						frmhd.modelhoadon.getDataVector().removeAllElements();
//						for (dichVu ctdv : ds) {
//							String obj[]= {1+"",ctdv.getMadichvu(),ctdv.getGiadichvu()+"",ctdv.getSoluong()+""};
//							frmhd.modelhoadon.addRow(obj);
//						}
//						frmhd.table.setModel(frmhd.modelhoadon);
						//
						
						
						
						
						
					}
				});
				//nut traphong
				f.btnTraPhong.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ktra=true;
						Long a = System.currentTimeMillis();
						Date cr=new Date(a);
						ctpdao1.update(cr, mahoadon);
						
						//test
						
//						if(f.txttienKhachDua.getText().equals("")) {
//							f.txttienKhachDua.requestFocus();
//							JOptionPane.showMessageDialog(null, "Nhập Số Tiền Khách Hàng Đưa !!!");
//						}else {
//							if(Double.parseDouble(f.txttienKhachDua.getText())<Double.parseDouble(f.txttongtienThanhToan.getText())) {
//								 JOptionPane.showMessageDialog(null, "Khách Chưa Đưa Đủ Tiền");
//							}
//							else {
//								JOptionPane.showMessageDialog(null, "Thanh Toán Thành Công");
//								f.txtTienkhachTraLai.setText(Double.toString(Double.parseDouble(f.txttienKhachDua.getText())-Double.parseDouble(f.txttongtienThanhToan.getText())));
////								btnInHoaDon.setVisible(true);
//							}
//						}
						//
						
					}
				});
				
				//end tra phong
		    }
		});
		
		
		MouseListener mouseListener = new MouseAdapter() {
		    @Override
		    public void mouseReleased(MouseEvent e) {
		  
		        if (e.getSource() instanceof JPanel) {
		            JPanel panel = (JPanel) e.getSource();
		            if(panel.getBackground().equals(new Color(238, 114, 96))) {
						 
						 if (e.isPopupTrigger()) {
							 menuItem2.setEnabled(true);
							 menuItem1.setEnabled(false);
							 popupMenu.show(e.getComponent(), e.getX(), e.getY());
						 }
					 }
					 
					 else {
						 if (e.isPopupTrigger()) {
							 menuItem2.setEnabled(false);
							 menuItem1.setEnabled(true);
							 popupMenu.show(e.getComponent(), e.getX(), e.getY());
						 }
					 }
		        }
		    }
		};
		
		
		
		
//		panelPhong101.addMouseListener(new MouseAdapter() {
//		    public void mousePressed(MouseEvent e) {
//		        if (e.isPopupTrigger()) {
//		            popupMenu.show(e.getComponent(), e.getX(), e.getY());
//		        }
//		    }
		 
			
//			 public void mouseReleased(MouseEvent e) {
//				 
//				 if(panelPhong101.getBackground().equals(new Color(238, 114, 96))) {
//					 
//					 if (e.isPopupTrigger()) {
//						 menuItem2.setEnabled(true);
//						 popupMenu.show(e.getComponent(), e.getX(), e.getY());
//					 }
//				 }
//				 
//				 else {
//					 
//					 if (e.isPopupTrigger()) {
//						 menuItem2.setEnabled(false);
//						 popupMenu.show(e.getComponent(), e.getX(), e.getY());
//					 }
//				 }
//			 
//			 
//			 }
//		   
//		});
//		
		
		//
		
		
		panelPhong101.addMouseListener(mouseListener);
		JPanel panelPhong102 = new JPanel();
		panelPhong102.setBackground(new Color(153, 204, 153));
		panelPhong102.setLayout(null);
		panelPhong102.setBounds(299, 0, 300, 150);
		panelPhongUITable.add(panelPhong102);
		panelPhong102.addMouseListener(mouseListener);
		JLabel lblTenPhong102 = new JLabel("102");
		lblTenPhong102.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong102.setBounds(132, 28, 48, 27);
		panelPhong102.add(lblTenPhong102);
		
		JLabel lblLoaiPhong102 = new JLabel("(Thường)");
		lblLoaiPhong102.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong102.setBounds(116, 65, 100, 27);
		panelPhong102.add(lblLoaiPhong102);
		
		JLabel lblTrangThaiPhong102 = new JLabel("Phòng trống");
		lblTrangThaiPhong102.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong102.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong102.setBounds(60, 105, 175, 34);
		panelPhong102.add(lblTrangThaiPhong102);
		
		JPanel panelPhong103 = new JPanel();
		panelPhong103.setBackground(new Color(238, 114, 96));
		panelPhong103.setLayout(null);
		panelPhong103.setBounds(599, 0, 300, 150);
		panelPhongUITable.add(panelPhong103);
		
		//sk
		panelPhong103.addMouseListener(mouseListener);
		//
		
		JLabel lblTenPhong103 = new JLabel("103");
		lblTenPhong103.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong103.setBounds(136, 28, 125, 27);
		panelPhong103.add(lblTenPhong103);
		
		JLabel lblLoaiPhong103 = new JLabel("(Thường)");
		lblLoaiPhong103.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong103.setBounds(116, 65, 100, 27);
		panelPhong103.add(lblLoaiPhong103);
		panelPhong103.addMouseListener(mouseListener);
		JLabel lblTrangThaiPhong103 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong103.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong103.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong103.setBounds(60, 103, 175, 34);
		panelPhong103.add(lblTrangThaiPhong103);
		
		JPanel panelPhong104 = new JPanel();
		panelPhong104.setBackground(new Color(240, 245, 50));
		panelPhong104.setLayout(null);
		panelPhong104.setBounds(900, 0, 300, 150);
		panelPhongUITable.add(panelPhong104);
		
		//sk
				panelPhong104.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong104 = new JLabel("104");
		lblTenPhong104.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong104.setBounds(132, 29, 125, 27);
		panelPhong104.add(lblTenPhong104);
		
		JLabel lblLoaiPhong104 = new JLabel("(Thường)");
		lblLoaiPhong104.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong104.setBounds(116, 65, 100, 27);
		panelPhong104.add(lblLoaiPhong104);
		
		JLabel lblTrangThaiPhong104 = new JLabel("Phòng đang sửa chữa");
		lblTrangThaiPhong104.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong104.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong104.setBounds(60, 103, 175, 34);
		panelPhong104.add(lblTrangThaiPhong104);
		
		JPanel panelPhong202 = new JPanel();
		panelPhong202.setBackground(new Color(153, 204, 153));
		panelPhong202.setLayout(null);
		panelPhong202.setBounds(299, 149, 300, 150);
		panelPhongUITable.add(panelPhong202);
		
		//sk
				panelPhong202.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong202 = new JLabel("202");
		lblTenPhong202.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong202.setBounds(126, 27, 125, 27);
		panelPhong202.add(lblTenPhong202);
		
		JLabel lblLoaiPhong202 = new JLabel("(Thường)");
		lblLoaiPhong202.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong202.setBounds(116, 65, 100, 27);
		panelPhong202.add(lblLoaiPhong202);
		
		JLabel lblTrangThaiPhong202 = new JLabel("Phòng trống");
		lblTrangThaiPhong202.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong202.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong202.setBounds(60, 103, 175, 34);
		panelPhong202.add(lblTrangThaiPhong202);
		
		JPanel panelPhong203 = new JPanel();
		panelPhong203.setBackground(new Color(153, 204, 153));
		panelPhong203.setLayout(null);
		panelPhong203.setBounds(599, 149, 300, 150);
		panelPhongUITable.add(panelPhong203);
		//sk
				panelPhong203.addMouseListener(mouseListener);
				//
		JLabel lblTenPhong203 = new JLabel("203");
		lblTenPhong203.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong203.setBounds(126, 27, 125, 27);
		panelPhong203.add(lblTenPhong203);
		
		JLabel lblLoaiPhong203 = new JLabel("(Thường)");
		lblLoaiPhong203.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong203.setBounds(116, 65, 100, 27);
		panelPhong203.add(lblLoaiPhong203);
		
		JLabel lblTrangThaiPhong203 = new JLabel("Phòng trống");
		lblTrangThaiPhong203.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong203.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong203.setBounds(60, 103, 175, 34);
		panelPhong203.add(lblTrangThaiPhong203);
		
		JPanel panelPhong204 = new JPanel();
		panelPhong204.setBackground(new Color(153, 204, 153));
		panelPhong204.setLayout(null);
		panelPhong204.setBounds(900, 149, 300, 150);
		panelPhongUITable.add(panelPhong204);
		
		//sk
				panelPhong204.addMouseListener(mouseListener);
				//
		
		
		JLabel lblTenPhong204 = new JLabel("204");
		lblTenPhong204.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong204.setBounds(130, 27, 125, 27);
		panelPhong204.add(lblTenPhong204);
		
		JLabel lblLoaiPhong204 = new JLabel("(Thường)");
		lblLoaiPhong204.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong204.setBounds(116, 65, 100, 27);
		panelPhong204.add(lblLoaiPhong204);
		
		JLabel lblTrangThaiPhong204 = new JLabel("Phòng trống");
		lblTrangThaiPhong204.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong204.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong204.setBounds(60, 103, 175, 34);
		panelPhong204.add(lblTrangThaiPhong204);
		
		JPanel panelPhong304 = new JPanel();
		panelPhong304.setBackground(new Color(153, 204, 153));
		panelPhong304.setLayout(null);
		panelPhong304.setBounds(900, 298, 300, 150);
		panelPhongUITable.add(panelPhong304);
		
		
		//sk
				panelPhong304.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong304 = new JLabel("304");
		lblTenPhong304.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong304.setBounds(136, 27, 125, 27);
		panelPhong304.add(lblTenPhong304);
		
		JLabel lblLoaiPhong304 = new JLabel("(VIP)");
		lblLoaiPhong304.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong304.setBounds(136, 65, 100, 27);
		panelPhong304.add(lblLoaiPhong304);
		
		JLabel lblTrangThaiPhong304 = new JLabel("Phòng trống");
		lblTrangThaiPhong304.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong304.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong304.setBounds(60, 103, 175, 34);
		panelPhong304.add(lblTrangThaiPhong304);
		
		JPanel panelPhong402 = new JPanel();
		panelPhong402.setBackground(new Color(153, 204, 153));
		panelPhong402.setLayout(null);
		panelPhong402.setBounds(299, 450, 300, 150);
		panelPhongUITable.add(panelPhong402);
		
		//sk
				panelPhong402.addMouseListener(mouseListener);
				//
		
		
		JLabel lblTenPhong402 = new JLabel("402");
		lblTenPhong402.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong402.setBounds(134, 27, 125, 27);
		panelPhong402.add(lblTenPhong402);
		
		JLabel lblLoaiPhong402 = new JLabel("(Thường)");
		lblLoaiPhong402.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong402.setBounds(116, 65, 100, 27);
		panelPhong402.add(lblLoaiPhong402);
		
		JLabel lblTrangThaiPhong402 = new JLabel("Phòng trống");
		lblTrangThaiPhong402.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong402.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong402.setBounds(60, 103, 175, 34);
		panelPhong402.add(lblTrangThaiPhong402);
		
		JPanel panelPhong403 = new JPanel();
		panelPhong403.setBackground(new Color(153, 204, 153));
		panelPhong403.setLayout(null);
		panelPhong403.setBounds(599, 450, 300, 150);
		panelPhongUITable.add(panelPhong403);
		
		
		//sk
				panelPhong403.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong403 = new JLabel("403");
		lblTenPhong403.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong403.setBounds(132, 28, 125, 27);
		panelPhong403.add(lblTenPhong403);
		
		JLabel lblLoaiPhong403 = new JLabel("(Thường)");
		lblLoaiPhong403.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong403.setBounds(116, 65, 100, 27);
		panelPhong403.add(lblLoaiPhong403);
		
		JLabel lblTrangThaiPhong403 = new JLabel("Phòng trống");
		lblTrangThaiPhong403.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong403.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong403.setBounds(60, 103, 175, 34);
		panelPhong403.add(lblTrangThaiPhong403);
		
		JPanel panelPhong404 = new JPanel();
		panelPhong404.setBackground(new Color(153, 204, 153));
		panelPhong404.setLayout(null);
		panelPhong404.setBounds(900, 450, 300, 150);
		panelPhongUITable.add(panelPhong404);
		
		
		//sk
				panelPhong404.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong404 = new JLabel("404");
		lblTenPhong404.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong404.setBounds(133, 27, 125, 27);
		panelPhong404.add(lblTenPhong404);
		
		JLabel lblLoaiPhong404 = new JLabel("(Thường)");
		lblLoaiPhong404.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong404.setBounds(116, 65, 100, 27);
		panelPhong404.add(lblLoaiPhong404);
		
		JLabel lblTrangThaiPhong404 = new JLabel("Phòng trống");
		lblTrangThaiPhong404.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong404.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong404.setBounds(60, 103, 175, 34);
		panelPhong404.add(lblTrangThaiPhong404);
		
		JPanel panelPhong201 = new JPanel();
		panelPhong201.setBackground(new Color(238, 114, 96));
		panelPhong201.setLayout(null);
		panelPhong201.setBounds(0, 149, 300, 150);
		panelPhongUITable.add(panelPhong201);
		
		//sk
				panelPhong201.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong201 = new JLabel("201");
		lblTenPhong201.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong201.setBounds(126, 27, 125, 27);
		panelPhong201.add(lblTenPhong201);
		
		JLabel lblLoaiPhong201 = new JLabel("(Thường)");
		lblLoaiPhong201.setForeground(new Color(0, 0, 0));
		lblLoaiPhong201.setBackground(new Color(240, 245, 50));
		lblLoaiPhong201.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong201.setBounds(116, 65, 100, 27);
		panelPhong201.add(lblLoaiPhong201);
		
		JLabel lblTrangThaiPhong201 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong201.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong201.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong201.setBounds(55, 103, 175, 34);
		panelPhong201.add(lblTrangThaiPhong201);
		
		JPanel panelPhong301 = new JPanel();
		panelPhong301.setBackground(new Color(238, 114, 96));
		panelPhong301.setLayout(null);
		panelPhong301.setBounds(0, 298, 300, 150);
		panelPhongUITable.add(panelPhong301);
		
		//sk
				panelPhong301.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong301 = new JLabel("301");
		lblTenPhong301.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong301.setBounds(126, 27, 125, 27);
		panelPhong301.add(lblTenPhong301);
		
		JLabel lblLoaiPhong301 = new JLabel("(VIP)");
		lblLoaiPhong301.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong301.setBounds(126, 65, 100, 27);
		panelPhong301.add(lblLoaiPhong301);
		
		JLabel lblTrangThaiPhong301 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong301.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong301.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong301.setBounds(55, 102, 175, 34);
		panelPhong301.add(lblTrangThaiPhong301);
		
		JPanel panelPhong302 = new JPanel();
		panelPhong302.setBackground(new Color(238, 114, 96));
		panelPhong302.setLayout(null);
		panelPhong302.setBounds(299, 298, 300, 150);
		panelPhongUITable.add(panelPhong302);
		
		
		//sk
				panelPhong302.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong302 = new JLabel("302");
		lblTenPhong302.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong302.setBounds(126, 27, 125, 27);
		panelPhong302.add(lblTenPhong302);
		
		JLabel lblLoaiPhong302 = new JLabel("(VIP)");
		lblLoaiPhong302.setBackground(new Color(238, 114, 96));
		lblLoaiPhong302.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong302.setBounds(126, 65, 100, 27);
		panelPhong302.add(lblLoaiPhong302);
		
		JLabel lblTrangThaiPhong302 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong302.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong302.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong302.setBounds(60, 103, 175, 34);
		panelPhong302.add(lblTrangThaiPhong302);
		
		JPanel panelPhong303 = new JPanel();
		panelPhong303.setBackground(new Color(238, 114, 96));
		panelPhong303.setLayout(null);
		panelPhong303.setBounds(599, 298, 300, 150);
		panelPhongUITable.add(panelPhong303);
		
		
		//sk
				panelPhong303.addMouseListener(mouseListener);
				//

		JLabel lblTenPhong303 = new JLabel("303");
		lblTenPhong303.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong303.setBounds(121, 28, 125, 27);
		panelPhong303.add(lblTenPhong303);
		
		JLabel lblLoaiPhong303 = new JLabel("(VIP)");
		lblLoaiPhong303.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong303.setBounds(126, 65, 100, 27);
		panelPhong303.add(lblLoaiPhong303);
		
		JLabel lblTrangThaiPhong303 = new JLabel("Phòng đã có khách");
		lblTrangThaiPhong303.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrangThaiPhong303.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTrangThaiPhong303.setBounds(60, 103, 175, 34);
		panelPhong303.add(lblTrangThaiPhong303);
		
		JPanel panelPhong401 = new JPanel();
		panelPhong401.setBackground(new Color(240, 245, 50));
		panelPhong401.setLayout(null);
		panelPhong401.setBounds(0, 450, 300, 150);
		panelPhongUITable.add(panelPhong401);
		
		//sk
				panelPhong401.addMouseListener(mouseListener);
				//
		
		JLabel lblTenPhong401 = new JLabel("401");
		lblTenPhong401.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTenPhong401.setBounds(127, 27, 125, 27);
		panelPhong401.add(lblTenPhong401);
		
		JLabel lblLoaiPhong401 = new JLabel("(Thường)");
		lblLoaiPhong401.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLoaiPhong401.setBounds(116, 65, 100, 27);
		panelPhong401.add(lblLoaiPhong401);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Phòng đang sửa chữa");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1.setBounds(55, 102, 175, 34);
		panelPhong401.add(lblNewLabel_1_1_1_1_1);
		phongDAO dsphong=new phongDAO();
		List<phong> ds= dsphong.laytenPhongtheott("Phòng đã có khách");
		List<phong> ds1= dsphong.laytenPhongtheott("Phòng trống");
		for (phong phong : ds) {
			  Component[] components =panelPhongUITable.getComponents();
			    for (Component component : components) {
			        if (component instanceof JPanel) {
			          JPanel panel=(JPanel)component;
			          JLabel label=(JLabel) panel.getComponent(0);
			          JLabel label1=(JLabel) panel.getComponent(2);
			            if(label.getText().equals(phong.getMaPhong())) {		            
			            	panel.setBackground(new Color(238, 114, 96));
			            	label1.setText("Phòng đã có khách");
			            }
			        }
			    }
		}
		for (phong phong : ds1) {
			  Component[] components =panelPhongUITable.getComponents();
			    for (Component component : components) {
			        if (component instanceof JPanel) {
			          JPanel panel=(JPanel)component;
			          JLabel label=(JLabel) panel.getComponent(0);
			          JLabel label1=(JLabel) panel.getComponent(2);
			            if(label.getText().equals(phong.getMaPhong())) {		            
			            	panel.setBackground(new Color(153, 204, 153));
			            	label1.setText("Phòng trống");
			            }
			        }
			    }
		}
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
	
	
	public int kiemtraTonTaiCTT(String makh) {
		 String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=doAnCuoiKyJava";
	        String username = "sa";
	        String password = "sapassword";
		int count=0;
		 try {
		      // Tạo kết nối đến cơ sở dữ liệu
			 Connection conn = DriverManager.getConnection(jdbcUrl, username, password);

		      // Tạo câu truy vấn SQL để kiểm tra sự trùng lặp của mã phòng
		      String sql = "SELECT COUNT(*) FROM hoadon WHERE makh=? and trangthai='CTT'";

		      // Tạo đối tượng PreparedStatement để thực hiện truy vấn
		      PreparedStatement stmt = conn.prepareStatement(sql);

		      // Thiết lập giá trị tham số cho câu truy vấn
//		      String ma_phong_moi = "ABC123";
		      stmt.setString(1, makh);
		 
		      // Thực hiện truy vấn và lấy kết quả trả về
		      ResultSet rs = stmt.executeQuery();
		      rs.next();
		       count += rs.getInt(1);

		      // Kiểm tra xem có bản ghi nào trùng với mã phòng mới không
//		      if (count > 0) {
//		        System.out.println("Mã phòng " + ma_phong_moi + " đã tồn tại trong cơ sở dữ liệu");
//		      } else {
//		        System.out.println("Mã phòng " + ma_phong_moi + " không trùng lặp với bất kỳ mã phòng nào trong cơ sở dữ liệu");
//		      }
		      
		      // Đóng các tài nguyên đã sử dụng
		      rs.close();
		      stmt.close();
		      conn.close();
		      
		      
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		 return count;
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
	
	public String  laymaKH(String maphong) {
		 String jdbcUrl = "jdbc:sqlserver://localhost:1433;databasename=doAnCuoiKyJava";
	        String username = "sa";
	        String password = "sapassword";
	        String columnValue="";
	        PreparedStatement stmt=null;
	        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password))
	        		{	
	        	String sql = "SELECT hd.makh FROM hoadon hd join chitietHoaDonPhong cthd on hd.mahoadon = cthd.mahoadon where maphong=? and trangthai='CTT'";
	        	stmt = conn.prepareStatement(sql);
	        	stmt.setString(1, maphong);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                  columnValue += rs.getString("makh");
	               
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return columnValue;
	}
}
