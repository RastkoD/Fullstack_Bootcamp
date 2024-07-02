package vehicle;

public class Motorcycle extends Vehicle {
	private boolean registered;

	Motorcycle(String b, String t, String rp, int y, boolean isRunning, String engType, int power, int displ, Person owner, boolean registered) {
		super(b, t, rp, y, isRunning, engType, power, displ, owner);
		this.registered = registered;
	}

	public void printData() {
		System.out.println(brand + " " + type + " " + year + regPlate + " " + registered + " " + owner.name + " " + owner.surname);
	}	
}
