package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.dichVu;

public class dichVuDAO {
	public List<dichVu> getAlldichvu(){
		List<dichVu> dsdv=new ArrayList<dichVu>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from dichvu";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsdv;
	}
	
	
	
	public String laytentheomaKh(String ma){
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		String ten="";
		try {
			String sql = "SELECT * FROM dichvu WHERE tendichvu=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				 ten=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ten;
	}
}
;