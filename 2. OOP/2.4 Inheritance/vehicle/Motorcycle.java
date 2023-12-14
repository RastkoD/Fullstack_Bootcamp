package vehicle;

public class Motorcycle extends Vehicle {
	private boolean registered;

	Motorcycle(String b, String t, String rp, int y, boolean works, String engType, int power, int displ, Person owner, boolean registered) {
		super(b, t, rp, y, works, engType, power, displ, owner);
		this.registered = registered;
	}

	public void printData() {
		System.out.println(brand + " " + type + " " + year + regPlate + " " + registered + " " + owner.name + " " + owner.surname);
	}	
}
