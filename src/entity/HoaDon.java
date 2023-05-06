package entity;

import java.util.Date;

public class HoaDon {
	private String maHoadon;
	private String maKH;
	private String manv;
	
	private int tonggio;
	private double tonghoadon;
	private double tongthu;
	private double tienPhong;
	private String trangThai;
	public HoaDon(String maHoadon, String maKH, String manv,   int tonggio, double tonghoadon,
			double tongthu, double tienPhong, String trangThai) {
		super();
		this.maHoadon = maHoadon;
		this.maKH = maKH;
		this.manv = manv;
	 
		this.tonggio = tonggio;
		this.tonghoadon = tonghoadon;
		this.tongthu = tongthu;
		this.tienPhong = tienPhong;
		this.trangThai = trangThai;
	}
	public HoaDon( String maKH, String manv , String trangThai) {
		super();
		this.maKH = maKH;
		this.manv = manv;
 
		this.trangThai = trangThai;
	}
	public String getMaHoadon() {
		return maHoadon;
	}
	public void setMaHoadon(String maHoadon) {
		this.maHoadon = maHoadon;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
 
	public int getTonggio() {
		return tonggio;
	}
	public void setTonggio(int tonggio) {
		this.tonggio = tonggio;
	}
	public double getTonghoadon() {
		return tonghoadon;
	}
	public void setTonghoadon(double tonghoadon) {
		this.tonghoadon = tonghoadon;
	}
	public double getTongthu() {
		return tongthu;
	}
	public void setTongthu(double tongthu) {
		this.tongthu = tongthu;
	}
	public double getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(double tienPhong) {
		this.tienPhong = tienPhong;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public Date getNgayLap() {
		// TODO Auto-generated method stub
		return null;
	}
	public Date getGioVao() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
