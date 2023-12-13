package access_control_and_encapsulation;

public class Main {

	public static void main(String[] args) {
		/*
		Message first = new Message();
		first.setText("Hello OOP World");
		first.showMsg();
		*/
		
		/*
		Student first = new Student();
		Student second = new Student();
		
		first.setName("Frodo");
		first.setSurname("Baggins");
		first.setTest1(88);
		first.setTest2(69);

		first.calcAvg();
		first.printPoints();
		
		second.setName("Samwise");
		second.setSurname("Gamgee");
		second.setTest1(78);
		second.setTest2(92);

		second.calcAvg();
		second.printPoints();
		*/
		
		/*
		Employees first = new Employees();
		Employees second = new Employees();
		Employees third = new Employees();	
		Employees fourth = new Employees();	

		first.setName("Frodo");
		first.setSurname("Baggins");
		first.setJobCoef(8);
		first.setDays(28);

		first.printEmployee();

		second.setName("Meriadoc");
		second.setSurname("Brandybuck");
		second.setJobCoef(7);
		second.setDays(22);

		second.printEmployee();

		third.setName("Peregrin");
		third.setSurname("Took");
		third.setJobCoef(2);
		third.setDays(22);

		third.printEmployee();

		fourth.setName("Samwise");
		fourth.setSurname("Gamgee");
		fourth.setJobCoef(15);
		fourth.setDays(31);

		fourth.printEmployee();
		*/
		
		/*
		Computer first = new Computer("Intel Core", 9, 4);
		Computer second = new Computer("Pentium", 3.50, 8);
		Computer third = new Computer("Altair", 2, 2);
		Computer fourth = new Computer("Celeron", 3.30, 16);
		Computer fifth = new Computer("AMD", 8.40, 32);

		Computer[] computers = {first, second, third, fourth, fifth};
		
		Computer.sortComputers(computers);

		for (int i = 0; i < computers.length; i++) {
			computers[i].printIndex();
		}
		*/
		
		/*
		Vehicle v1 = new Vehicle("Tesla", "El. Sedan", "TSLA-001", 2019, 155 , 480);
		Vehicle v2 = new Vehicle("Ford", "Truck", "FRD-2023", 2007, 130, 375);
		Vehicle v3 = new Vehicle("BMW", "SUV", "BMW-X7", 2010, 180, 456);;
		Vehicle v4 = new Vehicle("Audi", "Sports", "DIAU-22", 2016, 184, 495);
		Vehicle v5 = new Vehicle("Honda", "Hatchback", "HNDA-CV", 2022, 130, 180);

		v1.printData();
		v2.printData();
		v3.printData();
		v4.printData();
		v5.printData();

		v1.comparePrices(v5);
		*/
		
		
		Client first = new Client("Frodo", "Baggins", "45362718", "123456", "Bag End, Hobiton", "420-420", "myprecious@mearth.ring", 1035445);
		Client second = new Client("Samwise", "Gamgee", "45400034", "123488", "1 Bagshot Row, Hobiton", "444-3450", "truehero@mearth.ring", 35445);
		Client third = new Client("Aragorn", "Elessar", "45123456", "789012", "Minas Tirith", "123-4567", "kingofgondor@mearth.ring", 908765);
		Client fourth = new Client("Gimli", "Son of Glóin", "45987654", "567890", "Glittering Caves, Aglarond", "987-6543", "axeandbeard@mearth.ring", 654321);
		Client fifth = new Client("Legolas", "Greenleaf", "45789012", "345678", "Woodland Realm", "876-5432", "opelf@mearth.ring", 112233);

		first.printClient();
		second.printClient();
		third.printClient();
		fourth.printClient();
		fifth.printClient();

		System.out.println("-----------------------------------------------------------------------------------");

		first.transferTo(second, 35445);

		System.out.println("-----------------------------------------------------------------------------------");

		first.printClient();
		
	}

}
