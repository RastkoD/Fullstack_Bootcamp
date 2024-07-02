package vehicle;

public class Car  extends Vehicle {
	private int doorNum;
	
	Car(String b, String t, String rp, int y, boolean works, String engType, int power, int displ, Person owner, int doorNum) {
		super(b, t, rp, y, works, engType, power, displ, owner);
		this.doorNum = doorNum;
	}

	public void printData() {
		System.out.println(brand + " " + type + " " + year + " " + regPlate + " " + doorNum + " " + owner.name + " " + owner.surname);
	}
}
