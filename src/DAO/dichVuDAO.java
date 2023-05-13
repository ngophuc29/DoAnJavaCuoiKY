 
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
import entity.chitietdichVu;
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
	
	public List<dichVu> hoadonlist(String makh){
		List<dichVu> dshd=new ArrayList<dichVu>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="select tendichvu,soluongdichvu,giadichvu*soluongdichvu from dichvu d join chitiethoadondichvu ctdv on d.madichvu=ctdv.madichvu join hoadon hd on ctdv.mahoadon=hd.mahoadon where makh=? and trangthai='CTT'";
			  statement= con.prepareStatement(sql);
			statement.setString(1, makh);
			ResultSet rs =statement.executeQuery();
			while(rs.next()) {
				
				String ma =rs.getString(1);
				int soluong=rs.getInt(2);
				double gia =rs.getDouble(3);
			 
				
				dichVu ctdv= new dichVu(ma,   soluong,gia);
				dshd.add(ctdv);
				System.out.println(ma);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshd;
	}

	public static boolean themDichVu(dichVu dv) {

		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		try { 
			stmt = con.prepareStatement("insert into dichVu  ( madichvu, tendichvu, giadichvu) values (?,?,?)");

			stmt.setString(1, dv.getMadichvu());
			stmt.setString(2, dv.getTendichvu());
			stmt.setDouble(3, dv.getGiadichvu());
	
			

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

	public static boolean delete(String madichvu) {
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt=con.prepareStatement("delete from dichvu where madichvu =?");
			stmt.setString(1,madichvu);
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	

	public static boolean update(dichVu dv) {
		
		ConnectDB.getinstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n=0;
		
		try {
			stmt = con.prepareStatement("  update dichvu set giadichvu=? ,tendichvu=? where madichvu=?");
			 
			stmt.setDouble(1, dv.getGiadichvu());
			stmt.setString(2,dv.getTendichvu());
			
			stmt.setString(3, dv.getMadichvu());
			
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return n>0;
	}
	
}
;
