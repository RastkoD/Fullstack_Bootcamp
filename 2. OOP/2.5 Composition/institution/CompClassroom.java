package institution;

public class CompClassroom extends Classroom {
	private static final int MAXIMUM = 20;
	private Computer[] computerList;
	private int numberOfComputers;
	
	CompClassroom(String sign, String type, int seatNum, double area) {
		super(sign, type, seatNum, area);
		this.computerList = new Computer[MAXIMUM];
		this.setNumberOfComputers(0);
	}

	private void setNumberOfComputers(int numOfComp) {
		this.numberOfComputers = numOfComp;
	}
	
	public int getNumberOfComputers() {
		return numberOfComputers;
	}
	
	public boolean addComputer(Computer c) {
		if (this.getNumberOfComputers() == MAXIMUM) {
			return false;
		} else {
			computerList[numberOfComputers++] = c;
			return true;
		}
	}
	
	public Computer[] computers() {
		return computerList;
	}
	
	public Computer computer(int i) {
		return computerList[i];
	}
	
	public String toString() {
		return super.toString() + ", number of computers: " + this.getNumberOfComputers();
	}
}
