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
				dsphong.add(new  phong(rs.getString(1), rs.getDouble(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsphong;
	}
	public List<phong> laytenPhongtheott(String tt){
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		List<phong> dsphong=new ArrayList<phong>();
		try {
			String sql = "SELECT * FROM phong WHERE trangThaiPhong=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, tt);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				dsphong.add(new  phong(rs.getString(1),  rs.getDouble(2), rs.getInt(3), rs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsphong;
	}
	
	public boolean update(String phongtrong,String id) {
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("update phong set trangThaiPhong =? where maphong =?");
			stmt.setString (1,phongtrong);
			stmt.setString(2,id);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
	public boolean update1(String phongtrong,String id) {
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement(" update phong set trangThaiPhong =? from phong p join chitietHoaDonPhong cthd on p.maphong=cthd.maphong where mahoadon in(select mahoadon from hoadon where makh=? and trangthai='CTT')");
			stmt.setString (1,phongtrong);
			stmt.setString(2,id);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
}
