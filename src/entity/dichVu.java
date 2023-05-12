package entity;

public class dichVu {
	private String madichvu;
	private String tendichvu;
	private double giadichvu;
	private int soluong;
	public dichVu(String madichvu,  int soluong,double giadichvu) {
		super();
		this.madichvu = madichvu;
		this.giadichvu = giadichvu;
		this.soluong = soluong;
	}



	public dichVu(String madichvu, String tendichvu, double giadichvu) {
		super();
		this.madichvu = madichvu;
		this.tendichvu = tendichvu;
		this.giadichvu = giadichvu;
	}
	 
	public String getMadichvu() {
		return madichvu;
	}
	public void setMadichvu(String madichvu) {
		this.madichvu = madichvu;
	}
	public String getTendichvu() {
		return tendichvu;
	}
	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}
	public double getGiadichvu() {
		return giadichvu;
	}
	public void setGiadichvu(double giadichvu) {
		this.giadichvu = giadichvu;
	}
	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	
}
