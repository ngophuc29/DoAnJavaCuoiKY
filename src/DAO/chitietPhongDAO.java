package DAO;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectDB;
import entity.KhachHang;
import entity.chitietDatPhong;
import entity.dichVu;

public class chitietPhongDAO {
	public List<chitietDatPhong> getAllchiTietPhong(){
		List<chitietDatPhong> dsctdp=new ArrayList<chitietDatPhong>();
		ConnectDB.getinstance();
		Connection con =ConnectDB.getConnection();
		try {
			String sql="select c.machitietdatphong,c.maphong,c.mahoadon,giaphong,giovao,giora from chitietPhong";
			Statement statement= con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) {
//				dsdv.add(new  dichVu(rs.getString(1), rs.getString(2), rs.getDouble(3)));
				dsctdp.add(new chitietDatPhong(rs.getString(1), rs.getString(2),    rs.getString(3), rs.getDouble(4), rs.getDate(5), rs.getDate(6)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsctdp;
	}
	
}
;