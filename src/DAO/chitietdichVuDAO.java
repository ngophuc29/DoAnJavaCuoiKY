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
import entity.chitietDatPhong;
import entity.chitietdichVu;
import entity.dichVu;

public class chitietdichVuDAO {
	
	ArrayList<chitietdichVu>dshddv;
	
	public chitietdichVuDAO() {
	dshddv= new ArrayList<chitietdichVu>();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<chitietdichVu> getAllchiTietDichVu(){
		List<chitietdichVu> dsctdv=new ArrayList<chitietdichVu>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select * from chitiethoadondichvu";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
//				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
				dsctdv.add(new chitietdichVu(rs.getString(1), rs.getString(2), rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsctdv;
	}
	 
	
	
	public boolean insert(chitietdichVu ctdv) {
		int n=0;
		PreparedStatement stmt=null;
		Connection con=ConnectDB.getinstance().getConnection();
		
		try {
			String sql="  insert into chitiethoadondichvu (mahoadon,madichvu,soluongdichvu)values(?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, ctdv.getMahoadon());
			stmt.setString(2, ctdv.getMadichvu());
			stmt.setInt(3, ctdv.getSoluongdichvu());
		 
			
			
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
		return n>0;
	}
	public double tongtiendichvu(String makh) {
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double sum=0.0;
        try {
           
            String sql = "select sum(dv.giadichvu*ctdv.soluongdichvu) from chitiethoadondichvu ctdv join dichvu dv on ctdv.madichvu=dv.madichvu where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, makh); // set parameter value
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 sum += resultSet.getDouble(1);
                System.out.println("Total salary for code 123: " + sum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return sum;
	}
}



