package access_control_and_encapsulation;

public class Vehicle {
	private String brand, type, regPlate;
	private int year, maxSpeed, hPower;
	
	Vehicle() {}
	
	Vehicle(String b, String t, String rp, int y, int ms, int hp) {
		this.brand = b;
		this.type = t;
		this.regPlate = rp;
		this.year = y;
		this.maxSpeed = ms;
		this.hPower = hp;

	}
	
	public void setBrand(String b) {
		this.brand = b;
	}
	
	public void setType(String t) {
		this.type = t;
	}
	
	public void setRegPlate(String rp) {
		this.regPlate = rp;
	}
	
	public void setYear(int y) {
		this.year = y;
	}
	
	public void setMaxSpeed(int ms) {
		this.maxSpeed = ms;
	}
	
	public void setHpower(int hp) {
		this.hPower = hp;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getRegPlate() {
		return this.regPlate;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMaxSpeed() {
		return this.maxSpeed;
	}
	
	public int getHpower() {
		return this.hPower;
	}
	
	double vehicleValue() {
		return getMaxSpeed() * getHpower() / (2023 - getYear());
	}
	
	void printData() {
		System.out.println("Vehicle: " + getBrand() + " " + getType() + " with reg. plates: " + getRegPlate() + ", has a value of: " + vehicleValue());
	}

	public void comparePrices(Vehicle v) {
		double firstPrice = this.vehicleValue();
		double secondPrice = v.vehicleValue();
		
		if (firstPrice > secondPrice) {
			System.out.println(v.getBrand() + " priced at: " + v.vehicleValue() + " is cheaper than " + this.getBrand() + "(" + this.vehicleValue() + ")");
		} else if (firstPrice < secondPrice) {
			System.out.println(this.getBrand() + " priced at: " + this.vehicleValue() + " is cheaper than " + v.getBrand() + "(" + v.vehicleValue() + ")");
		} else {
			System.out.println(this.getBrand() + " priced at: " + this.vehicleValue() + " has the same value as " + v.getBrand() + " (" + v.vehicleValue() + ")");
		}
		
	}
	
}
