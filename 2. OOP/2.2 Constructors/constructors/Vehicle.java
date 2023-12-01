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
	
	void comparePrices(Vehicle v) {
	    double firstValue = this.vehicleValue();
	    double secondValue = v.vehicleValue();

	    if (firstValue < secondValue) {
	        System.out.println("First vehicle is cheaper.");
	    } else if (firstValue > secondValue) {
	        System.out.println("Second vehicle is cheaper.");
	    } else {
	        System.out.println("Vehicles are equal in price.");
	    }
	}
	
}
