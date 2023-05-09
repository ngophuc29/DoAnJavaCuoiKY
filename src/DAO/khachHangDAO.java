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
	public String laymaKHtheoten(String hoten){
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		String maKH="";
		try {
			String sql = "SELECT * FROM khachhang WHERE hoten=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, hoten);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				 maKH=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maKH;
	}
	
	public String laytentheomaKh(String ma){
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		String ten="";
		try {
			String sql = "SELECT * FROM khachhang WHERE makh=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, ma);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				 ten=rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ten;
	}
	
	public static boolean themDanhSachKH(KhachHang kh) {

		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into KhachHang  ( hoten,sdt,cmnd,email,ngaydky,ngaysinh,gioitinh,maloaikhachnag,trangthai) values (?,?,?,?,?,?,?,?,?)");
//			stmt.setString(1, kh.getMakh());
			stmt.setString(1, kh.getHoten());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getCmnd());
			stmt.setString(4, kh.getEmail());
			stmt.setDate(5, kh.getNgaydky());
			stmt.setDate(6, kh.getNgaysinh());
			stmt.setString(7, kh.getGioitinh());
			stmt.setString(8, kh.getMaloaiKhachHang());
			stmt.setString(9, kh.getTrangthai());

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
	
	public static boolean delete(String makh) {
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt=con.prepareStatement("delete from khachhang where makh =?");
			stmt.setString(1,makh);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
		 
	}
	
	public static boolean update(KhachHang kh) {
		
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update khachhang set hoten=?,sdt=?,cmnd=?,email=?,ngaydky=?,ngaysinh=?,gioitinh=? where makh=?");
			 
			stmt.setString(1, kh.getHoten());
			stmt.setString(2, kh.getSdt());
			stmt.setString(3, kh.getCmnd());
			stmt.setString(4, kh.getEmail());
			stmt.setDate(5, kh.getNgaydky());
			stmt.setDate(6, kh.getNgaysinh());
			stmt.setString(7, kh.getGioitinh());
			stmt.setString(8, kh.getMakh());
			
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return n>0;
	}
	
	public List<KhachHang> KHCTT(){
		List<KhachHang> dskh=new ArrayList<KhachHang>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from khachhang where trangthai='CTT' ";
			PreparedStatement statement= con.prepareStatement(sql);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				dskh.add(new  KhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getDate(6)  , rs.getDate(7), rs.getString(8), rs.getString(9) , rs.getString(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dskh;
	}
	
}
