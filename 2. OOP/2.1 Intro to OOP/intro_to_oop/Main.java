package intro_to_oop;

public class Main {

	public static void main(String[] args) {	
		
		/*
		Message firstMsg = new Message();
		firstMsg.text = "Zdravo svete!";
		firstMsg.setText("Zdravo OOP svete!");
		firstMsg.getText();
		*/
		
		/*
		Student first = new Student();
		Student second = new Student();
		
		first.setNameSurname("Petar", "Petrovic");
		second.setNameSurname("Ivana", "Petrovic");
		
		first.setPoints(4, 4);
		second.setPoints(2, 8);
		
		first.calcAvg();
		second.calcAvg();
		
		first.printPoints();
		second.printPoints();
		*/
		
		
		Employees first = new Employees();
		Employees second = new Employees();
		Employees third = new Employees();
		
		first.setNameSurname("Petar", "Petrovic");
		second.setNameSurname("Ivana", "Petrovic");
		third.setNameSurname("Petar", "Nesto");
		
		first.setCoef(11);
		second.setCoef(20);
		third.setCoef(18);
		
		first.calcPay();
		second.calcPay();
		third.calcPay();
		
		first.printPay();
		second.printPay();
		third.printPay();
		
	}

}
