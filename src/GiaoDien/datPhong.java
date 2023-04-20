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
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	private JTextField txtmahoadon;
	private JTextField txtmaKH;
	private JTextField txtmanv;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtgiovao;
	private JTextField txtgiora;
	private JTextField txttongthoigian;
    private Timer timer;
	  private SimpleDateFormat sdf;
	  private JTextField txttenKH;
	  
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(27, 21, 81, 26);
		contentPane.add(lblNewLabel);
		
		txtmahoadon = new JTextField();
		txtmahoadon.setBounds(128, 25, 86, 20);
		contentPane.add(txtmahoadon);
		txtmahoadon.setColumns(10);
		
		JLabel lblMKh = new JLabel("Mã KH");
		lblMKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMKh.setBounds(27, 58, 68, 26);
		contentPane.add(lblMKh);
		
		txtmaKH = new JTextField();
		txtmaKH.setColumns(10);
		txtmaKH.setBounds(128, 62, 86, 20);
		contentPane.add(txtmaKH);
		
		JLabel lblMNv = new JLabel("Mã NV");
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv.setBounds(27, 95, 68, 26);
		contentPane.add(lblMNv);
		
		txtmanv = new JTextField();
		txtmanv.setColumns(10);
		txtmanv.setBounds(128, 99, 86, 20);
		contentPane.add(txtmanv);
		
		JLabel lblMNv_1 = new JLabel("Mã NV");
		lblMNv_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1.setBounds(27, 132, 68, 26);
		contentPane.add(lblMNv_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(128, 136, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblMNv_1_1 = new JLabel("Mã Phòng");
		lblMNv_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1.setBounds(27, 169, 68, 26);
		contentPane.add(lblMNv_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(128, 173, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblMNv_1_1_1 = new JLabel("Mã Phòng");
		lblMNv_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1.setBounds(27, 206, 68, 26);
		contentPane.add(lblMNv_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 210, 142, 20);
		contentPane.add(textField_3);
		
		JLabel lblMNv_1_1_1_1 = new JLabel("Giờ Vào");
		lblMNv_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1_1.setBounds(27, 262, 68, 26);
		contentPane.add(lblMNv_1_1_1_1);
		
		txtgiovao = new JTextField();
		txtgiovao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtgiovao.setColumns(10);
		txtgiovao.setBounds(128, 265, 142, 20);
		
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
		lblNewLabel_1.setBounds(27, 237, 102, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxLoaiHInhThue = new JComboBox();
		comboBoxLoaiHInhThue.setBounds(127, 232, 143, 22);
		contentPane.add(comboBoxLoaiHInhThue);
		comboBoxLoaiHInhThue.addItem("Theo ngày");
		comboBoxLoaiHInhThue.addItem("Theo Giờ");
		
		
		JButton btnDatPhong = new JButton("Đặt Phòng");
		
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDatPhong.setBounds(145, 318, 154, 23);
		contentPane.add(btnDatPhong);
		
		JLabel lblNewLabel_2 = new JLabel("Tên KH:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(224, 102, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		txttenKH = new JTextField();
		txttenKH.setColumns(10);
		txttenKH.setBounds(293, 99, 109, 20);
		contentPane.add(txttenKH);
		
		
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
			public void actionPerformed(ActionEvent e) {
				TrangChuUI tcuil= new TrangChuUI();
				FormThongTinPhongVaThanhToan ftt= new FormThongTinPhongVaThanhToan();
				
			    ftt.btnTraPhong.addActionListener(new ActionListener() {
	    	        @Override
	    	        public void actionPerformed(ActionEvent e) {
	    	            timer.stop();
	    	        }
	    	    });
//			    txtgiora.getText().toString()
//			    txttongthoigian.getText().toString()
				String []obj= {txtmahoadon.getText().toString(),
						txtmaKH.getText().toString()
						,tcuil.txtmanvdn.getText().toString()
						,"111"
						,txtgiovao.getText().toString()
						,txtmahoadon.getText().toString()
						,""
						,""
						,"11"
						,ftt.txtgiagio.getText().toString()
						};
				ftt.modelkhachhang.addRow(obj);
				
				
				ftt.setVisible(true);
			}
		});
	}
}
