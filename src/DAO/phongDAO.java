package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.nhanVien;
import entity.phong;

public class phongDAO {
	public List<phong> getAllPhong(){
		List<phong> dsphong=new ArrayList<phong>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from nhanvien";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				dsphong.add(new  phong(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getString(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsphong;
	}
	
}
;