package entity;

public class chitietdichVu  {
	private String machitiethoadon;
	private String mahoadon;
	private String tendichvu;
	private int soluong;
	private double gia;
	public chitietdichVu(String machitiethoadon, String tendichvu, double gia, int soluongdichvu) {
		super();
		this.machitiethoadon = machitiethoadon;
		this.tendichvu = tendichvu;
		this.gia = gia;
		this.soluongdichvu = soluongdichvu;
	}
	public String getTendichvu() {
		return tendichvu;
	}
	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	private String madichvu;
	private int soluongdichvu;
	public chitietdichVu (String mahoadon, String madichvu, int soluongdichvu) {
		super();
		this.mahoadon = mahoadon;
		this.madichvu = madichvu;
		this.soluongdichvu = soluongdichvu;
	}
	 
	public chitietdichVu(double gia, String madichvu, int soluongdichvu) {
		super();
		this.gia = gia;
		this.madichvu = madichvu;
		this.soluongdichvu = soluongdichvu;
	}
	public String getMachitiethoadon() {
		return machitiethoadon;
	}
	public void setMachitiethoadon(String machitiethoadon) {
		this.machitiethoadon = machitiethoadon;
	}
	public String getMahoadon() {
		return mahoadon;
	}
	public void setMahoadon(String mahoadon) {
		this.mahoadon = mahoadon;
	}
	public String getMadichvu() {
		return madichvu;
	}
	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}
	public int getSoluongdichvu() {
		return soluongdichvu;
	}
	public void setSoluongdichvu(int soluongdichvu) {
		this.soluongdichvu = soluongdichvu;
	}
	 
 
 
	 
}
