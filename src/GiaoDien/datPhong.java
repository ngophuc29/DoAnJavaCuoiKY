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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

public class datPhong extends JFrame {

	private JPanel contentPane;
	private JTextField txtmahoadon;
	private JTextField txtmaKH;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField txtgiovao;

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
		setBounds(100, 100, 450, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Hóa đơn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(27, 21, 81, 26);
		contentPane.add(lblNewLabel);
		
		txtmahoadon = new JTextField();
		txtmahoadon.setBounds(108, 25, 86, 20);
		contentPane.add(txtmahoadon);
		txtmahoadon.setColumns(10);
		
		JLabel lblMKh = new JLabel("Mã KH");
		lblMKh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMKh.setBounds(27, 58, 68, 26);
		contentPane.add(lblMKh);
		
		txtmaKH = new JTextField();
		txtmaKH.setColumns(10);
		txtmaKH.setBounds(108, 58, 86, 20);
		contentPane.add(txtmaKH);
		
		JLabel lblMNv = new JLabel("Mã NV");
		lblMNv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv.setBounds(27, 95, 68, 26);
		contentPane.add(lblMNv);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(105, 99, 86, 20);
		contentPane.add(textField);
		
		JLabel lblMNv_1 = new JLabel("Mã NV");
		lblMNv_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1.setBounds(27, 132, 68, 26);
		contentPane.add(lblMNv_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(108, 136, 86, 20);
		contentPane.add(textField_1);
		
		JLabel lblMNv_1_1 = new JLabel("Mã Phòng");
		lblMNv_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1.setBounds(27, 169, 68, 26);
		contentPane.add(lblMNv_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(108, 173, 86, 20);
		contentPane.add(textField_2);
		
		JLabel lblMNv_1_1_1 = new JLabel("Mã Phòng");
		lblMNv_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1.setBounds(27, 206, 68, 26);
		contentPane.add(lblMNv_1_1_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(108, 210, 142, 20);
		contentPane.add(textField_3);
		
		JLabel lblMNv_1_1_1_1 = new JLabel("Giờ Vào");
		lblMNv_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1_1.setBounds(27, 243, 68, 26);
		contentPane.add(lblMNv_1_1_1_1);
		
		txtgiovao = new JTextField();
		txtgiovao.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtgiovao.setColumns(10);
		txtgiovao.setBounds(108, 247, 86, 20);
		
		
		//
		 Date now = new Date();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	        String currentTime = dateFormat.format(now);
	       
		//
		txtgiovao.setText(currentTime.toString());
		contentPane.add(txtgiovao);
		
		JFormattedTextField txtgiora = new JFormattedTextField();
		txtgiora.setBounds(108, 284, 142, 20);
		contentPane.add(txtgiora);
		
		JLabel lblMNv_1_1_1_1_1 = new JLabel("Giờ Vào");
		lblMNv_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMNv_1_1_1_1_1.setBounds(27, 280, 68, 26);
		contentPane.add(lblMNv_1_1_1_1_1);
	 
		
	}
}
