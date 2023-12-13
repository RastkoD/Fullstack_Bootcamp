package access_control_and_encapsulation;

public class Client {
	private String name, surname, ssn, accNumber, address, phoneNum, email;
	private double accBalance;

	Client(String n, String s, String jmbg, String acc, String adrs, String pNum, String mail, double accB) {
		this.name = n;
		this.surname = s;
		this.ssn = jmbg;
		this.accNumber = acc;
		this.address = adrs;
		this.phoneNum = pNum;
		this.email = mail;
		this.accBalance = accB;
	}
	
	void setName(String n) {
		this.name = n;
	}

	void setSurname(String s) {
		this.surname = s;
	}

	void setSsn(String jmbg) {
		this.ssn = jmbg;
	}

	void setAccNumber(String acc) {
		this.accNumber = acc;
	}

	void setAddress(String adrs) {
		this.address = adrs;
	}

	void setPhoneNum(String pNum) {
		this.phoneNum = pNum;
	}

	void setEmail(String mail) {
		this.email = mail;
	}

	void setAccBalance(double accB) {
		this.accBalance = accB;
	}

	String getName() {
		return this.name;
	}

	String getSurname() {
		return this.surname;
	}

	String getSsn() {
		return this.ssn;
	}

	String getAccNumber() {
		return this.accNumber;
	}

	String getAddress() {
		return this.address;
	}

	String getPhoneNum() {
		return this.phoneNum;
	}

	String getEmail() {
		return this.email;
	}

	double getAccBalance() {
		return this.accBalance;
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
		System.out.println("Client: " + getName() + " " + getSurname() + ", account number: " + getAccNumber() + ", account balance: " + getAccBalance());
	}
}
