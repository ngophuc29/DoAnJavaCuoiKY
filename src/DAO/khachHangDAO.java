package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;

public class khachHangDAO {
	public List<KhachHang> getAllKH(){
		List<KhachHang> dskh=new ArrayList<KhachHang>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from khachhang";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				dskh.add(new  KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6)  , rs.getDate(7), rs.getString(8), rs.getString(9) , rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	
}
;