package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.thongke;

public class thongkeDAO {

	public List<thongke> thongkeee(Date truoc ,Date sau){
		List<thongke> dskh=new ArrayList<thongke>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="SELECT hd.mahoadon,maphong,makh,giora,tongthu FROM chitietHoaDonPhong cthdp JOIN hoadon hd ON hd.mahoadon = cthdp.mahoadon WHERE cthdp.giora BETWEEN ? AND ? ";
			PreparedStatement statement= con.prepareStatement(sql);
			statement.setDate(1, truoc);
			statement.setDate(2, sau);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				dskh.add(new thongke(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getDouble(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	
	
	public static double tienthongkeee(Date truoc ,Date sau){
		List<thongke> dskh=new ArrayList<thongke>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		double sum=0.0;
		try {
			String sql="SELECT sum(tongthu) FROM chitietHoaDonPhong cthdp JOIN hoadon hd ON hd.mahoadon = cthdp.mahoadon WHERE cthdp.giora BETWEEN ? AND ? ";
			PreparedStatement statement= con.prepareStatement(sql);
			statement.setDate(1, truoc);
			statement.setDate(2, sau);
			ResultSet rs =statement.executeQuery();
			if(rs.next()) {
				sum+=rs.getDouble(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sum;
	}
}
