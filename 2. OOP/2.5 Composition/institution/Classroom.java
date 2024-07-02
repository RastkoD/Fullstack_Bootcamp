package institution;

public class Classroom {
	protected String sign, type;
	protected int seatNumber;
	protected double area;
	
	public Classroom(String sign, String type, int seatNum, double area) {
		this.sign = sign;
		this.type = type;
		this.seatNumber = seatNum;
		this.area = area;
	}
	
	protected void setSign(String sign) {
		this.sign = sign;
	}
	
	protected void setType(String type) {
		this.type = type;
	}
	
	protected void setSeatNum(int seatNum) {
		this.seatNumber = seatNum;
	}
	
	protected void setArea(double area) {
		this.area = area;
	}
	
	protected String getSign() {
		return this.sign;
	}
	
	protected String getType() {
		return this.type;
	}
	
	protected int getSeatNum() {
		return this.seatNumber;
	}
	
	protected double getArea() {
		return this.area;
	}
	
	public String toString() {
		return getSign() + " (" + getType() + "), number of seats: " + getSeatNum() + ", area: " + getArea() + " m2";  
	}
}
