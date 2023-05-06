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
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import entity.HoaDon;
import javax.swing.JButton;
 

public class FrmHoaDon<Graphics2D> extends JFrame  implements ActionListener{

	
	private static final long serialVersionUID = -6027396469314105075L;
	private JPanel pMain;
 
	private JTextPane txtHD;
	private HoaDon hd;
	private JTable tbCTHD;
	private String giamGia;
	private String tongTien;
	private String thanhTien;
	private SimpleDateFormat sfTime;
	private SimpleDateFormat sfdate;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public FrmHoaDon(HoaDon hd,JTable tbCTHD,String giamGia, String tongTien,String thanhTien )  {
		this.giamGia = giamGia;
		this.hd = hd;
		this.tbCTHD = tbCTHD;
		this.tongTien = tongTien;
		this.thanhTien = thanhTien;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 492, 664);
		setLocationRelativeTo(null);
		setTitle("Hóa đơn tạm");
 
		pMain = new JPanel();
		pMain.setBackground(new Color(255, 240, 245));
		pMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pMain);
		pMain.setLayout(null);
		
		txtHD = new JTextPane();
		txtHD.setBackground(Color.WHITE);
		txtHD.setFont(new Font("Monospaced", Font.BOLD, 13));
		txtHD.setEditable(false);
		txtHD.setBounds(10, 11, 460, 560);
		pMain.add(txtHD);
		
		JButton btnIn = new JButton("In Hoa Don");
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  PrinterJob job = PrinterJob.getPrinterJob();
				    job.setPrintable((Printable) new Printable() {
				        public int print1(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
				            // Thực hiện in ra dữ liệu
				            Graphics2D g2d = (Graphics2D)graphics;
//				            ((Graphics) g2d).translate(pageFormat.getImageableX(), pageFormat.getImageableY());
				            ((Graphics) g2d).drawString("Hello, world!", 100, 100);
				            return Printable.PAGE_EXISTS;
				        }

						@Override
						public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)
								throws PrinterException {
							// TODO Auto-generated method stub
							return 0;
						}
				    });
				    if (job.printDialog()) {
				        try {
				            job.print();
				        } catch (PrinterException ex) {
				            // Xử lý ngoại lệ in
				        }
				    }
			}
		});
		btnIn.setForeground(new Color(255, 255, 255));
		btnIn.setBackground(new Color(255, 128, 64));
		btnIn.setBounds(265, 591, 122, 23);
		pMain.add(btnIn);
		
		btnNewButton = new JButton("Hủy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(86, 591, 89, 23);
		pMain.add(btnNewButton);
		
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
		txtHD.setText("\t\t  Khách Sạn Bình Dương\n");
		txtHD.setText(txtHD.getText()+"      12 Nguyễn Văn Bảo, P.4, Gò Vấp, TP.Hồ Chí Minh\n");
		txtHD.setText(txtHD.getText() + "\t\t   SĐT: 0962447792\n");
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
		txtHD.setText(txtHD.getText()+ "\t\t      HÓA ĐƠN\n\n");
		txtHD.setText(txtHD.getText()+ "  Mã hóa đơn: \t"+"        Ngày lập: "+formattedDate+"\n");
		txtHD.setText(txtHD.getText()+ "  Phòng:  \t\t "+"Giờ vào: "+formattedDate+"\n");
		txtHD.setText(txtHD.getText()+ "  Mã khách hàng:  \t "+"Giờ ra: "+formattedDate+"\n");
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
		txtHD.setText(txtHD.getText()+ "  STT  Tên dịch vụ\t\tSL\t   Đơn giá\n");
//		int row = tbCTHD.getRowCount();
//		DefaultTableModel model = (DefaultTableModel) tbCTHD.getModel();
		
//		for(int i = 0; i<row;i++) {
//			int stt = i+1;
//			if(model.getValueAt(i, 0).toString().length() >=12)
//				txtHD.setText(txtHD.getText()+ "   "+stt+"   "+model.getValueAt(i, 0).toString()+"\t\t"+model.getValueAt(i, 2)+"\t   "+model.getValueAt(i, 3)+"\n");
//			else txtHD.setText(txtHD.getText()+ "   "+stt+"   "+model.getValueAt(i, 0).toString()+"\t\t\t"+model.getValueAt(i, 2)+"\t   "+model.getValueAt(i, 3)+"\n");
//		}
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
		txtHD.setText(txtHD.getText()+ "\t\t\tGiảm giá:   "+giamGia+"\n");
		txtHD.setText(txtHD.getText()+ "\t\t\tTiền thuê:        "+tongTien+"\n");
		txtHD.setText(txtHD.getText()+ "\t\t\tThành tiền:       "+thanhTien+"\n");
		txtHD.setText(txtHD.getText()+ "\t---------------------------------------\n");
		txtHD.setText(txtHD.getText()+ "\t\t   CẢM ƠN QUÝ KHÁCH\n");
		txtHD.setText(txtHD.getText()+ "\t\t      HẸN GẶP LẠI");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		 
	}
	
	
	public static void main(String[] args) {
		
		new FrmHoaDon(null, null, null, null, null).setVisible(true);
		
	}

}
