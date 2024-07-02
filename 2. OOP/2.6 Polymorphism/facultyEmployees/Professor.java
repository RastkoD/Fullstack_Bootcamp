package facultyEmployees;

public class Professor extends Employees {
	private String title;
	private int numOfResearchPapers;

	Professor(String name, String surname, int age, double jobCoef, String title, int norp) {
		super(name, surname, age, jobCoef);
		this.setTitle(title);
		this.setNORP(norp);
	}

	protected void setTitle(String title) {
		this.title = title;
	}

	protected void setNORP(int norp) {
		this.numOfResearchPapers = norp;
	}

	protected String getTitle() {
		return this.title;
	}

	protected int getNORP() {
		return this.numOfResearchPapers;
	}

	public void introduceYourself() {
		System.out.println("Name: " + getName() + " Surname: " + getSurname() + " Age: " + getAge() + " Title: " + getTitle() + " Number of Research Papers:" + getNORP());
	}

	public void calcSalary() {
		super.setSalary(60000 + this.getNORP() * 3000);
	}
}