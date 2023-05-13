package entity;

import java.util.Date;

public class thongke {
	private String mahoadon;
	private String maphong;
	private String makhachhang;
	private Date ngaylap;
	private int thoigianthue;
	private double tongtien;
	public thongke(String mahoadon, String maphong, String makhachhang, Date ngaylap , double tongtien) {
		super();
		this.mahoadon = mahoadon;
		this.maphong = maphong;
		this.makhachhang = makhachhang;
		this.ngaylap = ngaylap;
	 
		this.tongtien = tongtien;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
	public String getMakhachhang() {
		return makhachhang;
	}
	public void setMakhachhang(String makhachhang) {
		this.makhachhang = makhachhang;
	}
	public Date getNgaylap() {
		return ngaylap;
	}
	public void setNgaylap(Date ngaylap) {
		this.ngaylap = ngaylap;
	}
	public int getThoigianthue() {
		return thoigianthue;
	}
	public void setThoigianthue(int thoigianthue) {
		this.thoigianthue = thoigianthue;
	}
	public double getTongtien() {
		return tongtien;
	}
	public void setTongtien(double tongtien) {
		this.tongtien = tongtien;
	}
	@Override
	public String toString() {
		return "thongke [mahoadon=" + mahoadon + ", maphong=" + maphong + ", makhachhang=" + makhachhang + ", ngaylap="
				+ ngaylap + ", thoigianthue=" + thoigianthue + ", tongtien=" + tongtien + "]";
	}
	
}
