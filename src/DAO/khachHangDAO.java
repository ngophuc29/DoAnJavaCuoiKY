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
	public static boolean themDanhSachKH(KhachHang kh) {

		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into KhachHang values (?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMakh());
			stmt.setString(2, kh.getHoten());
			stmt.setString(3, kh.getSdt());
			stmt.setString(4, kh.getCmnd());
			stmt.setString(5, kh.getEmail());
			stmt.setDate(6, kh.getNgaydky());
			stmt.setDate(7, kh.getNgaysinh());
			stmt.setString(8, kh.getGioitinh());
			stmt.setString(9, kh.getMaloaiKhachHang());
			stmt.setString(10, kh.getTrangthai());

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}
		return n>0;
	}
}
