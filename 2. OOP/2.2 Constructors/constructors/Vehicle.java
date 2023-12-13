package constructors;

public class Vehicle {
	String brand, type, regPlate;
	int year, maxSpeed, hPower;
	double value;
	
	Vehicle() {}
	
	Vehicle(String b, String t, String rp, int y, int ms, int hp) {
		this.brand = b;
		this.type = t;
		this.regPlate = rp;
		this.year = y;
		this.maxSpeed = ms;
		this.hPower = hp;

	}
	
	double vehicleValue() {
		return value = maxSpeed * hPower / (2023 - year);
	}
	
	void printData() {
		System.out.println("Vehicle: " + brand + " " + type + " with reg. plates: " + regPlate + ", has a value of: " + value);
	}

	public void comparePrices(Vehicle v) {
		double firstPrice = this.vehicleValue();
		double secondPrice = v.vehicleValue();
		
		if (firstPrice > secondPrice) {
			System.out.println(v.brand + " priced at: " + v.vehicleValue() + " is cheaper than " + this.brand + "(" + this.vehicleValue() + ")");
		} else if (firstPrice < secondPrice) {
			System.out.println(this.brand + " priced at: " + this.vehicleValue() + " is cheaper than " + v.brand + "(" + v.vehicleValue() + ")");
		} else {
			System.out.println(this.brand + " priced at: " + this.vehicleValue() + " has the same value as " + v.brand + " (" + v.vehicleValue() + ")");
		}
		
	}
	
}
