package intro_to_oop;

public class Student {
	String name;
	String surname;
	
	double test1, test2, avg;
	
	void setNameSurname(String n, String s){
		name = n;
		surname = s;
	}
	
	
	
	void setPoints(double t1, double t2) {
		test1 = t1;
		test2 = t2;
	}
	
	void calcAvg() {
		avg = (test1 + test2) / 2; 
	}
	
	void printPoints() {
		System.out.println("Student " + name + " " + surname + ": Rez. prvog testa: " + test1 + ". Rez. drugog testa: " + test2 + " Average is: " + avg);
	}
}
