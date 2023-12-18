package facultyEmployees;

public class Assistant extends Employees implements FacultyEmployee {
	private String mentor;
	private int yearsOfDoctoralStudies;
	
	public Assistant(String name, String surname, int age, double jobCoef, String mentor, int yods) {
		super(name, surname, age, jobCoef);
		this.mentor = mentor;
		this.yearsOfDoctoralStudies = yods;
	}
	
	protected void setMentor(String position) {
		this.mentor = position;
	}
	
	protected void setYODS(int yods) {
		this.yearsOfDoctoralStudies = yods;
	}
	
	protected String getMentor() {
		return this.mentor;
	}
	
	protected int getYODS() {
		return this.yearsOfDoctoralStudies;
	}
	
	@Override
    public void calcSalary() {
        super.setSalary(40000 + this.getYODS() * 2000);
        
    }
	
	@Override
	public void printSalary() {
		System.out.println(getName() + " has " + getYODS() + " Years of doctoral studies and" + " a salary of: " + getSalary() +".");
	}
	
	public void introduceYourself() {
		System.out.println("Name: " + getName() + ", Surname: " + getSurname() + ", Age: " + getAge() + ", Mentor: " + getMentor());
    }
}
