package institution;

public class Computer {
	private String processor;
	private double clockRate;
	private int memory;

	Computer(String p, double cr, int m) {
		this.processor = p;
		this.clockRate = cr;
		this.memory = m;
	}
	
	void setProcessor(String p) {
		this.processor = p;
	}

	void setClockRate(double cr) {
		this.clockRate = cr;
	}

	void setMemory(int m) {
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
