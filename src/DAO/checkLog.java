package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.ConnectDB;

public class checkLog {
	public static Connection con=null;
	public static ResultSet rs=null;
	public static PreparedStatement pst=null;
	public static String testConnect() {
		ConnectDB.getinstance();
		
		try {
			Connection con =ConnectDB.getConnection();
			return "Ket noi thanh cong ";
		} catch (Exception e) {
			return "Ket noi k thanh cong ";
		}
		 
	}
	
	
	public static ResultSet Clog(String user,String pass){
		String sql="select * from nhanvien where manv=? and password=?";
		try {
			pst=con.prepareStatement(sql);
		pst.setString(1,user);
		pst.setString(2,pass);
		return rs=pst.executeQuery();
		} catch (Exception e) {
			// TODO: handle exception
			return rs=null;
		}
	
	}
}
