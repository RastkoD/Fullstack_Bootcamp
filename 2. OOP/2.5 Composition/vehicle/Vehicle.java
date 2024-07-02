package vehicle;

public class Vehicle {
	protected String brand, type, regPlate;
	Engine driveUnit;
	protected int year;
	protected Person owner;
	
	Vehicle() {}
	
	 public Vehicle(String brand, String type, String regPlate, int year, boolean isRunning, String engineType, int power, int displacement,  Person owner){
	        this.driveUnit = new Engine(isRunning, engineType, power, displacement);
	        this.brand = brand;
	        this.type = type;
	        this.regPlate = regPlate;
	        this.year = year;
	        this.owner = owner;
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

	void printData() {
		System.out.println("Vehicle: " + getBrand() + " " + getType() + " with reg. plates: " + getRegPlate() + " Year: " + getYear() + " Engine power: " + this.driveUnit.getPower());
	}
	
	public void changeOwner(Person newOwner) {
		this.owner = newOwner;
	}
	
}
