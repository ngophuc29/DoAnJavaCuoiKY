package entity;

public class dichVu {
	private String madichvu;
	private String tendichvu;
	private double giadichvu;
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
	
}
