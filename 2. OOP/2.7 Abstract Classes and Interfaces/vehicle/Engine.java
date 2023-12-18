package vehicle;

public class Engine {
	private boolean isRunning;
	private String type;
	private int power;
	private int displacement;
	
	public Engine() {}
	
	Engine(boolean isRunning, String engType, int power, int displ) {
		this.isRunning = isRunning;
		this.type = engType;
		this.power = power;
		this.displacement = displ;
	}
	
	public void setIsRunning(boolean works) {
		this.isRunning = works;
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
	
	public boolean getIsRunning() {
		return this.isRunning;
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
	
	public void start() {
        this.setIsRunning(true);
    }

    public void stop() {
        this.setIsRunning(false);
    }
	
	public void printData() {
		System.out.println("Engine Info:");
		System.out.println("Is on:" + getIsRunning() + " Type: " + getType() + " Power: " + getPower() + " Displacement: " + getDisplacement());
	}
}
