package institution;

public class Institution {
	private static final int MAXIMUM = 20;
	private String instName, instAddress, idNumber;
	private Employees legalRep;
	private Classroom[] classroomList;
	private Employees[] employeeList;
	private int classroomNum, employeeNum;
	
	public Institution(String instName, String instAddress, String idNum, Employees legalRep) {
		this.instName = instName;
		this.instAddress = instAddress;
		this.idNumber = idNum; 
		this.legalRep = legalRep;
		this.classroomList = new Classroom[MAXIMUM];
		this.classroomNum = 0;
		this.employeeList = new Employees[MAXIMUM];;
		this.employeeNum = 0;
	}
	
	protected void setInstName(String instName) {
		this.instName = instName;
	}
	
	protected void setInstAddress(String instAddress) {
		this.instAddress = instAddress;
	}
	
	protected void setIDNum(String idNum) {
		this.idNumber = idNum;
	}
	
	protected void setLegalRep(Employees legalRep) {
		this.legalRep = legalRep;
	}
	
	protected String getInstName() {
		return this.instName;
	}
	
	protected String getInstAddress() {
		return this.instAddress;
	}
	
	protected String getIDNum() {
		return this.idNumber;
	}
	
	protected Person getLegalRep() {
		return legalRep;
	}
	
	protected Classroom[] getClassroomList() {
		return classroomList;
	}
	
	protected Employees[] getEmployeeList() {
		return employeeList;
	}
	
	protected int getClassroomNum() {
		return classroomNum;
	}
	
	protected int getEmployeeNum() {
		return employeeNum;
	}
	
	protected boolean addClassroom(String sign, String type, int seatNum, double area, boolean computer) {
		if (classroomNum == MAXIMUM) {
			return false;
		} 
		
		if(computer) {
			classroomList[classroomNum++] = new CompClassroom(sign, type, seatNum, area);
		} else {
			classroomList[classroomNum++] = new Classroom(sign, type, seatNum, area);
		}
		return true;
	}
	
	protected boolean addEmployee(String name, String surname, int age, double jobCoef) {
		if (employeeNum == MAXIMUM) {
			return false;
		}
		
		employeeList[employeeNum++] = new Employees(name, surname, age, jobCoef);
		return true;
	}
	
	protected Classroom findClassroom(String sign) {
		for (int i = 0; i < classroomNum; i++) {
			if(classroomList[i].getSign().equals(sign)) {
				return classroomList[i];
			}
		}
		return null;
	}
	
	protected boolean addComputerToClassroom(String sign, String processor, double clockRate, int memory) {
		Classroom cr = findClassroom(sign);
		
		if (cr == null) {
			return false;
		}
		
		if (!(cr instanceof CompClassroom)) {
			System.out.println("Computers can only be added to Computer Classrooms!");
			return false;
		}
		CompClassroom ccr = (CompClassroom) cr;
		ccr.addComputer(new Computer(processor, clockRate, memory));
		return true;
	}
	
	public String toString() {
		return "Institution name: " + getInstName() + ", Adress: " + getInstAddress() + ", ID Number: " + getIDNum() + ".";
	}

	public void printData() {
		System.out.println(this.toString());
		
		System.out.println("List of Employees: ");
		for (int i = 0; i < employeeNum; i++)
			System.out.println(this.employeeList[i]);
		
		System.out.println("List of Classrooms: ");
		for (int i = 0; i < classroomNum; i++)
			System.out.println(this.classroomList[i]);
	}
}
