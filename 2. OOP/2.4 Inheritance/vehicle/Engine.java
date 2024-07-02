package vehicle;

public class Engine {
	private boolean works;
	private String type;
	private int power;
	private int displacement;
	
	Engine(boolean works, String engType, int power, int displ) {
		this.works = works;
		this.type = engType;
		this.power = power;
		this.displacement = displ;
	}
	
	public void setWorks(boolean works) {
		this.works = works;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setDisplacement(int displ) {
		this.displacement = displ;
	}
	
	public boolean getWorks() {
		return this.works;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getPower() {
		return this.power;
	}
	
	public int getDisplacement() {
		return this.displacement;
	}
	
	public void printData() {
		System.out.println("Engine Info:");
		System.out.println("Is on:" + getWorks() + " Type: " + getType() + " Power: " + getPower() + " Displacement: " + getDisplacement());
	}
}
