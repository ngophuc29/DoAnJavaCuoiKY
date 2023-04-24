package entity;

import java.sql.Date;

public class chitietDatPhong {
	private String machitietdatphong;
	private String maphong;
 
	private String mahoadon;
	private double giaphong;
	private Date giovao;
	private Date tongthoigian;
	public chitietDatPhong(String machitietdatphong, String maphong, String mahoadon, double giaphong,
			Date giovao, Date tongthoigian) {
		super();
		this.machitietdatphong = machitietdatphong;
		this.maphong = maphong;
		 
		this.mahoadon = mahoadon;
		this.giaphong = giaphong;
		this.giovao = giovao;
		this.tongthoigian = tongthoigian;
	}
	public String getMachitietdatphong() {
		return machitietdatphong;
	}
	public void setMachitietdatphong(String machitietdatphong) {
		this.machitietdatphong = machitietdatphong;
	}
	public String getMaphong() {
		return maphong;
	}
	public void setMaphong(String maphong) {
		this.maphong = maphong;
	}
 
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public double getGiaphong() {
		return giaphong;
	}
	public void setGiaphong(double giaphong) {
		this.giaphong = giaphong;
	}
	public Date getGiovao() {
		return giovao;
	}
	public void setGiovao(Date giovao) {
		this.giovao = giovao;
	}
	public Date getTongthoigian() {
		return tongthoigian;
	}
	public void setTongthoigian(Date tongthoigian) {
		this.tongthoigian = tongthoigian;
	}
 
	 
	
	
	
}
