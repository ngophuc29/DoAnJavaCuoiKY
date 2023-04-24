package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.chitietDatPhong;
import entity.chitietdichVu;
import entity.dichVu;

public class chitietdichVuDAO {
	public List<chitietdichVu> getAllchiTietDichVu(){
		List<chitietdichVu> dsctdv=new ArrayList<chitietdichVu>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from chitietPhong";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
//				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
				dsctdv.add(new chitietdichVu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getDouble(6), rs.getDouble(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsctdv;
	}
	
}
;