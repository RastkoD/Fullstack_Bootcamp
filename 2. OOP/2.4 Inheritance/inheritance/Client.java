package inheritance;

public class Client extends Person {
	protected int accNumber;
	protected double accBalance;
	protected String address, jmbg;
	
	Client(String name, String surname, int age, int accNum, double accBal, String jmbg, String address) {
		super(name, surname, age);
		setAccNum(accNum);
		setAccBal(accBal);
		setJmbg(jmbg);
		setAddress(address);
	}
	
	void setAccNum(int accNum) {
		this.accNumber = accNum;
	}
	
	void setAccBal(double accBal) {
		this.accBalance = accBal;
	}
	
	void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	
	void setAddress(String address) {
		this.address = address;
	}
	
	int getAccNum() {
		return this.accNumber;
	}
	
	double getAccBal() {
		return this.accBalance;
	}
	
	String getJmbg() {
		return this.jmbg;
	}
	
	String getAddress() {
		return this.address;
	}

	void transferTo(Client recipient, double amount) {
        if (amount > 0 && this.accBalance >= amount) {
            this.accBalance -= amount;
            recipient.accBalance += amount;
            System.out.println("Transaction successful! " + amount + " transferred from " + this.getName() + "'s account to " + recipient.getName() + "'s account.");
        } else {
            System.out.println("Transaction failed! Insufficient funds or invalid amount.");
        }
    }

	void printClient() {
		System.out.println("Client: " + getName() + " " + getSurname() + ", account number: " + getAccNum() + ", account balance: " + getAccBal());
	}
}
