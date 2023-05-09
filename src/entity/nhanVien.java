package entity;

import java.sql.Date;

public class nhanVien {
	private String manv;
	private String tennv;
	private String sdt;
	private String cmnd;
	private String diachi;
	private String chucvu;
	private String gioitinh;
	private Date ngaysinh;
	private Date ngayvaolam;
	private String trangthailamviec;
	private String password;
	public nhanVien(String manv, String tennv, String sdt, String cmnd, String diachi, String chucvu,
			String gioitinh, Date ngaysinh, Date ngayvaolam, String trangthailamviec, String password) {
		super();
		this.manv = manv;
		this.tennv = tennv;
		this.sdt = sdt;
		this.cmnd = cmnd;
		this.diachi = diachi;
		this.chucvu = chucvu;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.ngayvaolam = ngayvaolam;
		this.trangthailamviec = trangthailamviec;
		this.password = password;
	}
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
	}
	public String getTennv() {
		return tennv;
	}
	public void setTennv(String tennv) {
		this.tennv = tennv;
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
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	public String getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public Date getNgayvaolam() {
		return ngayvaolam;
	}
	public void setNgayvaolam(Date ngayvaolam) {
		this.ngayvaolam = ngayvaolam;
	}
	public String getTrangthailamviec() {
		return trangthailamviec;
	}
	public void setTrangthailamviec(String trangthailamviec) {
		this.trangthailamviec = trangthailamviec;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "nhanVien [manv=" + manv + ", tennv=" + tennv + ", sdt=" + sdt + ", cmnd=" + cmnd + ", diachi=" + diachi
				+ ", chucvu=" + chucvu + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh + ", ngayvaolam="
				+ ngayvaolam + ", trangthailamviec=" + trangthailamviec + ", password=" + password + "]";
	}
	
}
