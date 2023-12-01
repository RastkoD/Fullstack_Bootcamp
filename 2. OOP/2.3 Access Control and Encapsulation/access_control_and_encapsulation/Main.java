package access_control_and_encapsulation;

public class Main {

	public static void main(String[] args) {
		/*
		Message p = new Message();
		//p.tekst = "Hello World!";
		p.setTxt("Hi OOP World");
		p.showTxt();
		 */

		/*
		Student first = new Student();
		first.setName("Frodo");
		first.setSurname("Baggins");
		first.setTestOne(88);
		first.setTestTwo(69);

		first.printAvg();
		 */

		/*
		Employees first = new Employees();
		Employees second = new Employees();
		Employees third = new Employees();	
		Employees fourth = new Employees();	

		first.setName("Frodo");
		first.setSurname("Baggins");
		first.setCoef(8);
		first.setDays(28);

		first.printPay();

		second.setName("Meriadoc");
		second.setSurname("Brandybuck");
		second.setCoef(7);
		second.setDays(22);

		second.printPay();

		third.setName("Peregrin");
		third.setSurname("Took");
		third.setCoef(2);
		third.setDays(22);

		third.printPay();

		fourth.setName("Samwise");
		fourth.setSurname("Gamgee");
		fourth.setCoef(15);
		fourth.setDays(31);

		fourth.printPay();
		 */

		/*
		Vehicle v1 = new Vehicle();
		Vehicle v2 = new Vehicle();
		Vehicle v3 = new Vehicle();
		Vehicle v4 = new Vehicle();
		Vehicle v5 = new Vehicle();

		v1.setVehicle("Tesla", "El. Sedan", "TSLA-001", 2019, 155 , 480);
		v2.setVehicle("Ford", "Truck", "FRD-2023", 2007, 130, 375);
		v3.setVehicle("BMW", "SUV", "BMW-X7", 2010, 180, 456);
		v4.setVehicle("Audi", "Sports", "DIAU-22", 2016, 184, 495);
		v5.setVehicle("Honda", "Hatchback", "HNDA-CV", 2022, 130, 180);

		v1.printData();
		v2.printData();
		v3.printData();
		v4.printData();
		v5.printData();

		v1.comparePrices(v5);
		*/
		
		Computer first = new Computer();
		Computer second = new Computer();
		Computer third = new Computer();
		Computer fourth = new Computer();
		Computer fifth = new Computer();
		
		Computer[] computers = {first, second, third, fourth, fifth};

		first.setComputer("Intel Core", 9, 4);
		second.setComputer("Pentium", 3.50, 8);
		third.setComputer("Altair", 2, 2);
		fourth.setComputer("Celeron", 3.30, 16);
		fifth.setComputer("AMD", 8.40, 32);
		
		for (int i = 0; i < computers.length; i++) {
            computers[i].perfIndexCalc();
        }

        for (int i = 0; i < computers.length - 1; i++) {
            for (int j = 0; j < computers.length - 1; j++) {
                if (computers[j].perfIndexCalc() < computers[j + 1].perfIndexCalc()) {
                    Computer temp = computers[j];
                    computers[j] = computers[j + 1];
                    computers[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < computers.length; i++) {
            computers[i].printIndex();
        }

	}

}
