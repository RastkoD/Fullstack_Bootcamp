package facultyEmployees;

public class Assistant extends Employees {
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
	
	public void introduceYourself() {
		System.out.println("Name: " + getName() + " Surname: " + getSurname() + " Age: " + getAge() + " Mentor: " + getMentor() + " Years of doctoral studies: " + getYODS());
    }

    @Override
    public void calcSalary() {
        super.setSalary(40000 + this.getYODS() * 2000);
        
    }
}
