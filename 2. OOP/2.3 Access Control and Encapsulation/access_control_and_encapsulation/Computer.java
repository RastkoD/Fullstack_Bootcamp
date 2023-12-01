package access_control_and_encapsulation;

public class Computer {
	private String processor;
	private double clockRate;
	private int memory;

	void setComputer(String p, double cr, int m) {
		this.processor = p;
		this.clockRate = cr;
		this.memory = m;
	}

	String getProcessor() {
		return this.processor;
	}

	double getClockRate() {
		return this.clockRate;
	}

	int getMemory() {
		return this.memory;
	}

	double perfIndexCalc() {
		return 10 * clockRate + memory;
	}

	void printIndex() {
		System.out.println("Computer with " + this.getProcessor() + " has a CPU benchmark score of: " + perfIndexCalc());
	}
}
