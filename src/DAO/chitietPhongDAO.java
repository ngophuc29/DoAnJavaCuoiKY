package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.chitietDatPhong;
import entity.dichVu;

 

public class chitietPhongDAO {

	ArrayList<chitietDatPhong>dshddp;
	
	public chitietPhongDAO() {
		// TODO Auto-generated constructor stub
		dshddp= new ArrayList<>();
	}
	
	
	public List<chitietDatPhong> getAllchiTietPhong(){
//		List<chitietDatPhong> dsctdp=new ArrayList<chitietDatPhong>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select c.machitietdatphong,c.maphong,c.mahoadon,giaphong,giovao,giora from chitietHoaDonPhong   ";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
//				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
				dshddp.add(new chitietDatPhong(rs.getString(1), rs.getString(2),    rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshddp;
	}
	
	
	
	
	public boolean insert(chitietDatPhong ctdp) {
		int n=0;
		PreparedStatement stmt=null;
		Connection con=ConnectDB.getinstance().getConnection();
		
		try {
			String sql="insert into chitietHoaDonPhong (maphong,mahoadon,giaphong,giovao) values(?,?,?,?)";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, ctdp.getMaphong());
			stmt.setString(2, ctdp.getMahoadon());
			stmt.setDouble(3, ctdp.getGiaphong());
			stmt.setDate(4, ctdp.getGiovao());
			
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
	
	
	public List<chitietDatPhong> getAllchiTietPhongCoMaKh(String maKh){
//		List<chitietDatPhong> dsctdp=new ArrayList<chitietDatPhong>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement stmt=null;
		try {
			String sql="  select * from chitietHoaDonPhong where mahoadon in (select mahoadon from hoadon where makh =? and trangthai='CTT')";
			stmt=con.prepareStatement(sql);
			stmt.setString(1, maKh);
			ResultSet rs =stmt.executeQuery();
			while(rs.next()) {
//				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
				dshddp.add(new chitietDatPhong(rs.getString(1), rs.getString(2),    rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dshddp;
	}
	
	public double tongtienphong(String maHD) {
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        double sum=0.0;
        try {
           
            String sql = "select sum(giaphong) from chitietHoaDonPhong where mahoadon=? group by mahoadon";
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, maHD); // set parameter value
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                 sum += resultSet.getDouble(1);
//                System.out.println("Total salary for code 123: " + sum);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
		return sum;
	}
	
	//
	
	public static boolean update(Date date,String mahoadon ) {
		Connection con=ConnectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement(" update chitietHoaDonPhong set giora=? where mahoadon=?");
			stmt.setDate(1, date);
			
			stmt.setString(2, mahoadon);
			 
			n=stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	//
}
;