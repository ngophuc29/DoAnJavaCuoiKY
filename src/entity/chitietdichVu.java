package entity;

public class chitietdichVu {
	private String machitiethoadon;
	private String mahoadon;
	private String manv;
	private String madichvu;
	private int soluongdichvu;
	private double discount;
	private double giadichvu;
	public chitietdichVu(String machitiethoadon, String mahoadon, String manv, String madichvu, int soluongdichvu,
			double discount, double giadichvu) {
		super();
		this.machitiethoadon = machitiethoadon;
		this.mahoadon = mahoadon;
		this.manv = manv;
		this.madichvu = madichvu;
		this.soluongdichvu = soluongdichvu;
		this.discount = discount;
		this.giadichvu = giadichvu;
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
	public String getManv() {
		return manv;
	}
	public void setManv(String manv) {
		this.manv = manv;
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
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGiadichvu() {
		return giadichvu;
	}
	public void setGiadichvu(double giadichvu) {
		this.giadichvu = giadichvu;
	}
	
	 
}
