package vehicle;

public class Car  extends Vehicle implements Ownership {
	private int doorNum;
	
	Car(String b, String t, String rp, int y, boolean isRunning, String engType, int power, int displ, Person owner, int doorNum) {
		super(b, t, rp, y, isRunning, engType, power, displ, owner);
		this.doorNum = doorNum;
	}

	public void printData() {
		System.out.println(brand + " " + type + " " + year + " " + regPlate + " " + doorNum + " " + owner.name + " " + owner.surname);
	}
	
	public void changeOwner(Person newOwner) {
		this.owner = newOwner;
	}
}
