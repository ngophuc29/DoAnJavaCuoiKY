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

public class nhanVienDAO {
	public List<nhanVien> getAllnhanvien(){
		List<nhanVien> dsnv=new ArrayList<nhanVien>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from nhanvien";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
				dsnv.add(new  nhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getDate(8), rs.getDate(9), rs.getString(10), rs.getString(11)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsnv;
	}
	
	
	public static boolean themDanhSachNV(nhanVien nv) {

		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into nhanvien values (?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getManv());
			stmt.setString(2, nv.getTennv());
			stmt.setString(3, nv.getSdt());
			stmt.setString(4, nv.getCmnd());
			stmt.setString(5, nv.getDiachi());
			stmt.setString(6, nv.getChucvu());
			stmt.setString(7, nv.getGioitinh());
			stmt.setDate(8, nv.getNgaysinh());
			stmt.setDate(9, nv.getNgayvaolam());
			stmt.setString(10, nv.getTrangthailamviec());
			stmt.setString(11, nv.getPassword());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}  
		return n>0;
	}
	
	public static boolean delete(String manv) {
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt=con.prepareStatement("delete from nhanvien where manv =?");
			stmt.setString(1,manv);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
		 
	}
	
	public static boolean update(nhanVien nv) {
		
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("update nhanvien set manv=?, hoten=?,sdt=?,cmnd=?,diachi=?,chucvu=?,gioitinh=?,ngaysinh=?,ngayvaolam=?,trangthai=?");
			stmt.setString(1, nv.getManv());
			stmt.setString(2, nv.getTennv());
			stmt.setString(3, nv.getSdt());
			stmt.setString(4, nv.getCmnd());
			stmt.setString(5, nv.getDiachi());
			stmt.setString(6, nv.getChucvu());
			stmt.setString(7, nv.getGioitinh());
			stmt.setDate(8, nv.getNgaysinh());
			stmt.setDate(9, nv.getNgayvaolam());
			stmt.setString(10, nv.getTrangthailamviec());

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
	public boolean doimk(String passmoi,String manv) {
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		
		
		PreparedStatement stmt=null;
		int n=0;
		
		
		try {
			stmt=con.prepareStatement("update nhanvien set password =? where manv =?");
			stmt.setString (1,passmoi);
			stmt.setString(2,manv);
			n= stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return n>0;
		
	}
}
;