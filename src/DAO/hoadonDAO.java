package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import database.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;

public class hoadonDAO {
	
	
	ArrayList<HoaDon> dshd;
	public hoadonDAO() {
		// TODO Auto-generated constructor stub
		dshd= new ArrayList<HoaDon>();
	}
	
	public static boolean themHD(HoaDon kh) {

		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into hoadon(makh,manv,trangthai) values ( ?,?,?)");
//			stmt.setString(1, kh.getMakh());
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getManv());
			 
			stmt.setString(3, kh.getTrangThai());

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
	
	public static boolean update(int tonggio,double tonghoadon,double tongthu,double tienphong,String trangthai,String mahoadon ) {
		Connection con=ConnectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement(" update hoadon set tonggioo=? , tonghoadon=?, tongthu=? , tienPhong=? ,trangthai=? where mahoadon=?");
			stmt.setInt(1, tonggio);
			stmt.setDouble(2, tonghoadon);
			stmt.setDouble(3, tongthu);
			stmt.setDouble(4, tienphong);
			stmt.setString(5, trangthai);
			stmt.setString(6, mahoadon);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
}
