package vehicle;

public class Vehicle {
	protected String brand, type, regPlate;
	Engine driveUnit;
	protected int year;
	protected Person owner;
	
	Vehicle() {}
	
	Vehicle(String b, String t, String rp, int y, boolean works, String engType, int power, int displ, Person owner) {
		this.driveUnit = new Engine(works, engType, power, displ);
		this.brand = b;
		this.type = t;
		this.regPlate = rp;
		this.year = y;
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
