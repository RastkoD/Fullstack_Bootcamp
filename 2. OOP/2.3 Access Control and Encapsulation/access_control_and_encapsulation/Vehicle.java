package access_control_and_encapsulation;

public class Vehicle {
	private String brand, type, regPlate;
	private int year, maxSpeed, power;

	void setVehicle(String b, String t, String rp, int y, int ms, int hp) {
		this.brand = b;
		this.type = t;
		this.regPlate = rp;
		this.year = y;
		this.maxSpeed = ms;
		this.power = hp;

	}

	String getBrand() {
		return this.brand;
	}

	String getType() {
		return this.type;
	}

	String getRegPlate() {
		return this.regPlate;
	}

	int getYear() {
		return this.year;
	}

	int getMaxSpeed() {
		return this.maxSpeed;
	}

	int getPower() {
		return this.power;
	}

	double vehicleValue() {
		return this.getMaxSpeed() * this.getPower() / (2023 - this.getYear());
	}

	void printData() {
		System.out.println("Vehicle: " + this.getBrand() + " " + this.getType() + " with reg. plates: " + this.getRegPlate() + ", has a value of: " + this.vehicleValue());
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
