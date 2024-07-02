package vehicle;

public class Truck  extends Vehicle {
	private int axleNum;
	
	Truck(String b, String t, String rp, int y, boolean works, String engType, int power, int displ, Person owner, int axleNum) {
		super(b, t, rp, y, works, engType, power, displ, owner);
		this.axleNum = axleNum;
	}
	
	public void printData() {
		System.out.println(brand + " " + type + " " + year + regPlate + " " + axleNum + " " + owner.name + " " + owner.surname);
	}	
}
