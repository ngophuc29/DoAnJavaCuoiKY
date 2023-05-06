package entity;

public class chitietdichVu  {
	private String machitiethoadon;
	private String mahoadon;
 
	private String madichvu;
	private int soluongdichvu;
	public chitietdichVu (String mahoadon, String madichvu, int soluongdichvu) {
		super();
		this.mahoadon = mahoadon;
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
