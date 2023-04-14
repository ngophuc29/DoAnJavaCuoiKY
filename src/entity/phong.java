package entity;

public class phong {
	private String maPhong ;
	private String maDichVu;
	private double giaphong;
	private int maloaiphong;
	private String trangthaiPhong;
	public phong(String maPhong, String maDichVu, double giaphong, int maloaiphong, String trangthaiPhong) {
		super();
		this.maPhong = maPhong;
		this.maDichVu = maDichVu;
		this.giaphong = giaphong;
		this.maloaiphong = maloaiphong;
		this.trangthaiPhong = trangthaiPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public double getGiaphong() {
		return giaphong;
	}
	public void setGiaphong(double giaphong) {
		this.giaphong = giaphong;
	}
	public int getMaloaiphong() {
		return maloaiphong;
	}
	public void setMaloaiphong(int maloaiphong) {
		this.maloaiphong = maloaiphong;
	}
	public String getTrangthaiPhong() {
		return trangthaiPhong;
	}
	public void setTrangthaiPhong(String trangthaiPhong) {
		this.trangthaiPhong = trangthaiPhong;
	}
	
}	
