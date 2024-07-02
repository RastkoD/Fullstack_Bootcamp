package bank;

public class Client {
	private String name;
	private String surname;
	private String ssn;
	private Account accNumber;
	
	Client(String name, String surname, String ssn, int accNumber) {
		this.name = name;
		this.surname = surname;
		this.ssn = ssn;
		this.accNumber = new Account(accNumber, accNumber, false, ssn);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.name = surname;
	}
	
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}
	
	public void setAccNumber(Account accNumber) {
		this.accNumber = accNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getSSN() {
		return this.ssn;
	}
	
	public Account getAccNumber() {
		return this.accNumber;
	}
	
	public void introduceYourself() {
        System.out.println("Client - " + "name: " + getName() + ", surname: " + getSurname() + ", ssn: " + getSSN() + ", account number: " + getAccNumber());
    }

}
