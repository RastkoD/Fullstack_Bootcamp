package facultyEmployees;

public class NonTeachingStaff extends Employees implements FacultyEmployee {
	private String position;
	private int yearsOfService;

	public NonTeachingStaff(String name, String surname, int age, double jobCoef, String position, int yos) {
		super(name, surname, age, jobCoef);
		this.setPosition(position);;
		this.setYOS(yos);;
	}

	protected void setPosition(String position) {
		this.position = position;
	}

	protected void setYOS(int yos) {
		this.yearsOfService = yos;
	}

	protected String getPosition() {
		return this.position;
	}

	protected int getYOS() {
		return this.yearsOfService;
	}

	public void calcSalary() {
		super.setSalary(30000 + this.getYOS() * 500);
	}

	@Override
	public void printSalary() {
		System.out.println(getName() + " has " + getYOS() + " Years of Service and" + " a salary of: " + getSalary() +".");
	}
	
	public void introduceYourself() {
		System.out.println("Name: " + getName() + ", Surname: " + getSurname() + ", Age: " + getAge() + ", Position: " + getPosition());
		
	}
}
