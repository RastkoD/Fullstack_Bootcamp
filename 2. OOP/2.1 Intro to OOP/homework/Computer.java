package homework;

public class Computer {
	String processor;
	double clockRate, perfIndex;
	int memory;
	
	void setName(String p) {
		processor = p;
	}
	
	void setclockRate(double cr) {
		clockRate = cr;
	}
	
	void setMemory(int m) {
		memory = m;
	}
	
	void perfIndexCalc() {
		perfIndex = (10 * clockRate) + memory;
	}
	
	void printIndex() {
		System.out.println("Computer with " + processor + " has a CPU benchmark score of: " + perfIndex);
	}
}
