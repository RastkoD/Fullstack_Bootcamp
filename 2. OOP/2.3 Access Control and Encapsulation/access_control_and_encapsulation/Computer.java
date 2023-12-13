package access_control_and_encapsulation;

public class Computer {
	private String processor;
	private double clockRate;
	private int memory;

	Computer(String p, double cr, int m) {
		this.processor = p;
		this.clockRate = cr;
		this.memory = m;
	}

	public void setProcessor(String p) {
		this.processor = p;
	}

	public void setClockRate(double cr) {
		this.clockRate = cr;
	}

	public void setMemory(int m) {
		this.memory = m;
	}

	public String getProcessor() {
		return this.processor;
	}

	public double getClockRate() {
		return this.clockRate;
	}

	public int getMemory() {
		return this.memory;
	}

	public double getPerfIndex() {
		return 10 * getClockRate() + getMemory();
	}

	public static void sortComputers(Computer[] computers) {
		for (int i = 0; i < computers.length - 1; i++) {
			for (int j = 0; j < computers.length - 1; j++) {
				if (computers[j].getPerfIndex() < computers[j + 1].getPerfIndex()) {
					Computer temp = computers[j];
					computers[j] = computers[j + 1];
					computers[j + 1] = temp;
				}
			}
		}
	}

	public void printIndex() {
		System.out.println("Computer with " + getProcessor() + " has a CPU benchmark score of: " + getPerfIndex());
	}
}
