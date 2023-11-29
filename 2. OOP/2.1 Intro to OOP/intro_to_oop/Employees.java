package intro_to_oop;

public class Employees {
	String name;
	String surname;
	
	double jobCoef, pay;
	
	void setNameSurname(String i, String p) {
		name = i;
		surname = p;
	}
	
	void setCoef(double koef) {
		jobCoef = koef;
	}
	
	void calcPay() {
		pay = jobCoef * 3600; 
	}
	
	void printPay() {
		System.out.println("Zaposleni: " + name + " " + surname + " ima platu: " + pay);
	}
}
