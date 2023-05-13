package GiaoDien;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.chitietdichVuDAO;
import DAO.dichVuDAO;
import DAO.khachHangDAO;
import database.ConnectDB;

import java.util.Date;
import java.util.List;

import entity.HoaDon;
import entity.KhachHang;
import entity.chitietdichVu;
import entity.dichVu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
 

public class FrmHoaDon  extends JFrame  implements ActionListener{

	
	private static final long serialVersionUID = -6027396469314105075L;
	private JPanel pMain;
 
	private JTextPane txtHD;
	private HoaDon hd;
	private JTable tbCTHD;
	private String giamGia;
	private String tongTien;
	private String thanhTien,makh,mahoadon;
	private SimpleDateFormat sfTime;
	private SimpleDateFormat sfdate;
	private JTable chuahoadon;
	public DefaultTableModel modelhoadon;
	private JButton btnNewButton;
	private DichVuUI dvui= new DichVuUI();
	private chitietdichVuDAO ctdvdao ;
	public JTable table;
	
	private dichVuDAO dvdao;
//	public static String mahoadon="" ,makh,maphong ="",giolaphoadon="",giora="";
//	public static String getMahoadon() {
//		return mahoadon;
//	}
//
//	public static void setMahoadon(String mahoadon) {
//		FrmHoaDon.mahoadon = mahoadon;
//	}
//
//	public static String getMakh() {
//		return makh;
//	}
//
//	public static void setMakh(String makh) {
//		FrmHoaDon.makh = makh;
//	}
//
//	public static String getMaphong() {
//		return maphong;
//	}
//
//	public static void setMaphong(String maphong) {
//		FrmHoaDon.maphong = maphong;
//	}
//
//	public static String getGiolaphoadon() {
//		return giolaphoadon;
//	}
//
//	public static void setGiolaphoadon(String giolaphoadon) {
//		FrmHoaDon.giolaphoadon = giolaphoadon;
//	}
//
//	public static String getGiora() {
//		return giora;
//	}
//
//	public static void setGiora(String giora) {
//		FrmHoaDon.giora = giora;
//	}

	/**
	 * Create the frame.
	 */
	public FrmHoaDon(HoaDon hd)  {
		this.giamGia = giamGia;
		this.hd = hd;
		this.tbCTHD = tbCTHD;
		this.tongTien = tongTien;
		this.thanhTien = thanhTien;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(1000, 1000, 521, 670);
		setLocationRelativeTo(null);
		setTitle("Hóa đơn tạm");
 
		pMain = new JPanel();
		pMain.setBackground(new Color(255, 255, 255));
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pMain);
		pMain.setLayout(null);
		
		txtHD = new JTextPane();
		txtHD.setBackground(Color.WHITE);
		txtHD.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtHD.setEditable(false);
		txtHD.setBounds(10, 11, 462, 233);
		pMain.add(txtHD);
		
		JButton btnIn = new FixButton("In Hóa Đơn");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				  PrinterJob job = PrinterJob.getPrinterJob();
//				    job.setPrintable((Printable) new Printable() {
//				        public int print1(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
//				            // Thực hiện in ra dữ liệu
//				            Graphics2D g2d = (Graphics2D)graphics;
////				            ((Graphics) g2d).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//				            ((Graphics) g2d).drawString("Hello, world!", 100, 100);
//				            return Printable.PAGE_EXISTS;
//				        }
//
//						@Override
//						public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
//								throws PrinterException {
//							// TODO Auto-generated method stub
//							return 0;
//						}
//				    });
//				    if (job.printDialog()) {
//				        try {
//				            job.print();
//				        } catch (PrinterException ex) {
//				            // Xử lý ngoại lệ in
//				        }
//				    }
			}
		});
		btnIn.setForeground(new Color(255, 255, 255));
		btnIn.setBackground(new Color(255, 128, 64));
		btnIn.setBounds(265, 591, 122, 23);
		pMain.add(btnIn);
		
		btnNewButton = new FixButton("Hủy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(86, 591, 89, 23);
		pMain.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("  CẢM ƠN QUÝ KHÁCH");
		lblNewLabel.setBounds(183, 521, 122, 14);
		pMain.add(lblNewLabel);
		
		JLabel lblHnGpLi = new JLabel("HẸN GẶP LẠI");
		lblHnGpLi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHnGpLi.setBounds(135, 546, 219, 14);
		pMain.add(lblHnGpLi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 255, 453, 222);
		pMain.add(scrollPane);
		
		modelhoadon= new DefaultTableModel();
		modelhoadon.addColumn("STT");
		modelhoadon.addColumn("Ten Dich Vu");
		modelhoadon.addColumn("So Luong");
		modelhoadon.addColumn("Don gia");
		table = new JTable(modelhoadon);
		table.setBorder(null);
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"STT", "T\u00EAn D\u1ECBch V\u1EE5", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1"
//			}
//		));
		scrollPane.setViewportView(table);
		System.out.println(hd.getMaKH());
		ctdvdao= new chitietdichVuDAO();
//		
		
//		List<chitietdichVu>ds=ctdvdao.hoadonlist(hd.getMaKH());
		
		
//		dvdao= new dichVuDAO();
//		List<dichVu>ds=dvdao.hoadonlist(hd.getMaKH());
//		modelhoadon.getDataVector().removeAllElements();
//		for (dichVu ctdv : ds) {
//			String obj[]= {1+"",ctdv.getMadichvu(),ctdv.getGiadichvu()+"",ctdv.getSoluong()+""};
//			modelhoadon.addRow(obj);
//		}
//		table.setModel(modelhoadon);
		
		//
		
		//TEST
		
//		
//		ConnectDB.getinstance();
//		Connection con =ConnectDB.getConnection();
//		PreparedStatement stmt=null;
//		try {
//			String sql="select d.madichvu,soluongdichvu,giadichvu*soluongdichvu from dichvu d join chitiethoadondichvu ctdv on d.madichvu=ctdv.madichvu join hoadon hd on ctdv.mahoadon=hd.mahoadon where makh=? and trangthai='CTT'";
//			stmt=con.prepareStatement(sql);
//			stmt.setString(1, hd.getMaKH());
//			ResultSet rs =stmt.executeQuery();
//			int var =1;
//			while(rs.next()) {
////				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
//				Object []obj= {var,rs.getString(1), rs.getString(2),    rs.getDouble(3) };
//				modelhoadon.addRow(obj);
//				var++;
////				Object []obj1= {"1","2","3","4"};
////				modelhoadon.addRow(obj);
////				modelhoadon.addRow(obj1);
////				System.out.println(rs.getString(1));
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
		
		
//		END TEST
		
		JLabel lblNewLabel_1 = new JLabel("Giảm Giá :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(311, 488, 76, 14);
		pMain.add(lblNewLabel_1);
		
		JLabel txtgiamgia = new JLabel("");
		txtgiamgia.setBounds(396, 488, 46, 14);
		pMain.add(txtgiamgia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Thành Tiền :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(311, 513, 85, 14);
		pMain.add(lblNewLabel_1_1);
		
		JLabel txtthanhtien = new JLabel("");
		txtthanhtien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtthanhtien.setBounds(406, 513, 85, 14);
		txtthanhtien.setText(Double.toString(hd.getTienPhong()));
		pMain.add(txtthanhtien);
		
		
		
		
//		btnIn = new FixButton("In hóa đơn");
//		btnIn.setForeground(Color.WHITE);
//		btnIn.setFont(new Font("SansSerif", Font.BOLD, 14));
//		btnIn.setBackground(new Color(114, 23, 153));
//		btnIn.setBounds(117, 585, 261, 33);
//		
//		Icon iconInHD = IconFontSwing.buildIcon(FontAwesome.PRINT, 20, new Color(255, 255 ,255));
//		btnIn.setIcon(iconInHD);
//		pMain.add(btnIn);
//		
		sfdate = new SimpleDateFormat("dd/MM/yyyy");
		sfTime = new SimpleDateFormat("HH:mm");
		loadHD();
		
//		btnIn.addActionListener(this);
		
	
	}
	
	public void loadHD() {
//		if(giamGia.equalsIgnoreCase(""))
			giamGia = "0";
		
		    Date now = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	        String formattedDate = dateFormat.format(now);
//	        String formattedDate1 = dateFormat.format(hd.getGiora());
	        txtHD.setText("\t\t   Khách Sạn Bình Dương\n");
			txtHD.setText(txtHD.getText()+"      12 Nguyễn Văn Bảo, P.4, Gò Vấp, TP.Hồ Chí Minh\n");
			txtHD.setText(txtHD.getText() + "\t\t   SĐT: 0363435011\n");
			txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
			txtHD.setText(txtHD.getText()+ "\t\t      HÓA ĐƠN\n\n");
			txtHD.setText(txtHD.getText()+ "  Mã hóa đơn: "+hd.getMaHoadon()+"\t"+"  Ngày lập: "+formattedDate+"\n");
			txtHD.setText(txtHD.getText()+ "  Phòng: "+hd.getMaphong()+"\t\t   "+"Giờ vào:\t"+formattedDate+"\n");
			txtHD.setText(txtHD.getText()+ "  Mã khách hàng: "+hd.getMaKH()+"\t  "+"Giờ ra:\t"+hd.getGiora()+"\n");
			txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
			txtHD.setText(txtHD.getText()+ "  STT  Tên dịch vụ\t\tSL\t   Đơn giá\n");
			

			
			double thanhtien= ctdvdao.tongtiendichvu(hd.getMaKH());
			int soluong=ctdvdao.laysoluongkhac(hd.getMaKH());
			

		
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
//		txtHD.setText(txtHD.getText()+ "\t\t\tGiảm giá:   "+0+"\n");
 
		txtHD.setText(txtHD.getText()+ "\t\t\tThành tiền:       "+hd.getTienPhong()+"\n");
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 
	}
}
