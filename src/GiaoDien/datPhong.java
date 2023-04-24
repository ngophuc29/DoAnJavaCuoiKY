package GiaoDien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.common.base.Strings;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.components.JSpinField;

import DAO.khachHangDAO;
import database.ConnectDB;
import entity.KhachHang;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.Timer;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JButton;
public class datPhong extends JFrame {

	private JPanel contentPane;
	public JTextField txtmaKHtheoten;
	public JTextField txtmaphongdat;
	public JTextField txtgiovao;
	public JTextField txtgiora;
	public JTextField txttongthoigian;
    private Timer timer;
    private khachHangDAO KHdao;
	  private SimpleDateFormat sdf;
	  public String manvintable;
	 public TrangChuUI kkk;
	public JLabel txtmanvintable; 
	public JButton btnDatPhong;
	public JComboBox combotenKH;
	private DAO.phongDAO phongDAO;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					datPhong frame = new datPhong();
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
	public datPhong() {
		try {
			ConnectDB.getinstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 476, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMKh = new JLabel("Mã KH");
		lblMKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMKh.setBounds(27, 27, 68, 26);
		contentPane.add(lblMKh);
		
		txtmaKHtheoten = new JTextField();
		txtmaKHtheoten.setColumns(10);
		txtmaKHtheoten.setBounds(128, 31, 86, 20);
		contentPane.add(txtmaKHtheoten);
		
		JLabel lblMNv_1 = new JLabel("Mã Phòng");
		lblMNv_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1.setBounds(27, 64, 68, 26);
		contentPane.add(lblMNv_1);
		
		txtmaphongdat = new JTextField();
		txtmaphongdat.setColumns(10);
		txtmaphongdat.setBounds(128, 68, 86, 20);
		contentPane.add(txtmaphongdat);
		
		JLabel lblMNv_1_1_1_1 = new JLabel("Giờ Vào");
		lblMNv_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1_1.setBounds(27, 140, 68, 26);
		contentPane.add(lblMNv_1_1_1_1);
		
		txtgiovao = new JTextField();
		txtgiovao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtgiovao.setColumns(10);
		txtgiovao.setBounds(138, 143, 142, 20);
		
		sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	    // Cập nhật giá trị cho textfield 1
		txtgiovao.setText(sdf.format(new Date()));
		//
//		 Date now = new Date();
//	        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
//	        String currentTime = dateFormat.format(now);
//	       
//		//
//		txtgiovao.setText(currentTime.toString());
		contentPane.add(txtgiovao);
		
		JLabel lblNewLabel_1 = new JLabel("Loại Hình Thuê");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(28, 114, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxLoaiHInhThue = new JComboBox();
		comboBoxLoaiHInhThue.setBounds(128, 111, 143, 22);
		contentPane.add(comboBoxLoaiHInhThue);
		comboBoxLoaiHInhThue.addItem("Theo ngày");
		comboBoxLoaiHInhThue.addItem("Theo Giờ");
		
		
		btnDatPhong = new JButton("Đặt Phòng");
		
		btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDatPhong.setBounds(157, 191, 154, 42);
		contentPane.add(btnDatPhong);
		
		JLabel lblNewLabel_2 = new JLabel("Tên KH:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(224, 33, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		  combotenKH = new JComboBox();
		combotenKH.setBounds(291, 30, 109, 22);
		contentPane.add(combotenKH);
		
		  txtmanvintable = new JLabel("");
		txtmanvintable.setBounds(128, 102, 86, 14);
		
//		txtmanvintable.setText(kkk.txtmanvdn.getText());
		
		contentPane.add(txtmanvintable);
		KHdao = new khachHangDAO();
		for (KhachHang kh : KHdao.KHCTT()) {
			Object obj= kh.getHoten();
			combotenKH.addItem(obj);
		}
		String name=combotenKH.getItemAt(0).toString();
		String customerId = KHdao.laymaKHtheoten(name);
		txtmaKHtheoten.setText(customerId);
		combotenKH.addItemListener(new ItemListener() {
		    public void itemStateChanged(ItemEvent event) {
		        if (event.getStateChange() == ItemEvent.SELECTED) {
		            String name = event.getItem().toString();
		            String customerId = KHdao.laymaKHtheoten(name);
		            
		            // Cập nhật mã khách hàng vào label nào đó trên giao diện
		            txtmaKHtheoten.setText(customerId);
		            //
		            FormThongTinPhongVaThanhToan abc= new FormThongTinPhongVaThanhToan();
		            abc.txttenKH.setText(name);
		            //
		        }
		    }
		});
		timer = new Timer(1000, new ActionListener() {
 	        @Override
 	        public void actionPerformed(ActionEvent e) {
 	            // Cập nhật giá trị cho textfield 2
 	            txtgiora.setText(sdf.format(new Date()));

 	            // Tính thời gian chạy được giữa textfield 2 và textfield 1
 	            Date startDate = null;
 	            Date endDate = null;

 	            try {
 	                startDate = sdf.parse(txtgiovao.getText());
 	                endDate = sdf.parse(txtgiora.getText());
 	            } catch (Exception ex) {
 	                ex.printStackTrace();
 	            }

 	            long diff = endDate.getTime() - startDate.getTime();

 	            // Cập nhật giá trị cho textfield 3
 	            txttongthoigian.setText(String.format("%d giây", diff / 1000));
 	        }
 	    });
		btnDatPhong.addActionListener(new ActionListener() {

//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				dispose();
//			}
			public void actionPerformed(ActionEvent e) {
				TrangChuUI tcuil= new TrangChuUI();
				TrangDangNhapUI tdnui= new TrangDangNhapUI();
				FormThongTinPhongVaThanhToan ftt= new FormThongTinPhongVaThanhToan();
				
			    ftt.btnTraPhong.addActionListener(new ActionListener() {
	    	        @Override
	    	        public void actionPerformed(ActionEvent e) {
	    	            timer.stop();
	    	        }
	    	    });
//			    txtgiora.getText().toString()
//			    txttongthoigian.getText().toString()
//			    String manvintable="";
//				String []obj= {
//						txtmaKHtheoten.getText().toString(),
//						combotenKH.getSelectedItem().toString()
//						, txtmanvintable.getText()
//						,txtmaphongdat.getText()
//						,txtgiovao.getText().toString()
//						,""
//						,""
//						,"11"
//						,ftt.txtgiagio.getText().toString()
//						};
//				ftt.modelkhachhang.addRow(obj);
//				
//			    phongDAO.update("Phòng Đã Có Khách");
				dispose();
//				ftt.setVisible(true);
			
			}
		});
	}
}
