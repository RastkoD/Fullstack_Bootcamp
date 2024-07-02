package female;

public class Female extends Person {
	String maidenName;

	Female(String name, String surname, String maidenName, int age) {
		super(name, surname, age);
		this.maidenName = maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getMaidenName() {
		return this.maidenName;
	}

	public void introduceYourself() {
		System.out.println("Name: " + getName() + " Surname: " + getSurname() + " Maiden name: " + getMaidenName());
	}
}
