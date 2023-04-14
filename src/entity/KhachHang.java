package entity;

import java.sql.Date;

public class KhachHang {
	private String makh;
	private String hoten;
	private String sdt;
	private String cmnd ;
	private String email;
	private Date ngaydky;
	private Date ngaysinh;
	private String gioitinh;
	private String maloaiKhachHang;
	private int soPhong;
	public KhachHang(String makh, String hoten, String sdt, String cmnd, String email, Date ngaydky, Date ngaysinh,
			String gioitinh, String maloaiKhachHang, int soPhong) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.email = email;
		this.ngaydky = ngaydky;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.maloaiKhachHang = maloaiKhachHang;
		this.soPhong = soPhong;
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getNgaydky() {
		return ngaydky;
	}
	public void setNgaydky(Date ngaydky) {
		this.ngaydky = ngaydky;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getMaloaiKhachHang() {
		return maloaiKhachHang;
	}
	public void setMaloaiKhachHang(String maloaiKhachHang) {
		this.maloaiKhachHang = maloaiKhachHang;
	}
	public int getSoPhong() {
		return soPhong;
	}
	public void setSoPhong(int soPhong) {
		this.soPhong = soPhong;
	}
	
}
