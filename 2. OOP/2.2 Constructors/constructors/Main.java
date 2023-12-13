package constructors;

public class Main {

	public static void main(String[] args) {/*
		Cylinder tube = new Cylinder(2.0f, 200.0f);
		System.out.println("Radius: " + tube.r + ", height: " + tube.H);
		*/
		
		/*
		Student first = new Student("Frodo",	"Baggins",	39.5, 53.8);
		Student second = new Student("Samwise", "Gamgee",	38.7, 57.5);
		
		first.calcAvg();
		first.printPoints();
		second.calcAvg();
		second.printPoints();
		*/
		
		/*
		Employees e1 = new Employees("Frodo","Baggins", 3600);
		Employees e2 = new Employees("Samwise","Gamgee", 3600);
		Employees e3 = new Employees("Meriadoc","Brandybuck", 3600);
		Employees e4 = new Employees("Peregrin","Took", 3600);
		
		e1.calcSalary(22);
		e1.printEmployee();

		e2.calcSalary(18);
		e2.printEmployee();

		e3.calcSalary(8);
		e3.printEmployee();

		e4.calcSalary(13);
		e4.printEmployee();
		*/
		
		Vehicle v1 = new Vehicle("Tesla", "El. Sedan", "TSLA-001", 2019, 155 , 480);
		Vehicle v2 = new Vehicle("Ford", "Truck", "FRD-2023", 2007, 130, 375);
		Vehicle v3 = new Vehicle("BMW", "SUV", "BMW-X7", 2010, 180, 456);
		Vehicle v4 = new Vehicle("Audi", "Sports", "DIAU-22", 2016, 184, 495);
		Vehicle v5 = new Vehicle("Honda", "Hatchback", "HNDA-CV", 2022, 130, 180);

		v1.vehicleValue();
		v2.vehicleValue();
		v3.vehicleValue();
		v4.vehicleValue();
		v5.vehicleValue();

		v1.printData();
		v2.printData();
		v3.printData();
		v4.printData();
		v5.printData();
		
		v5.comparePrices(v1);
	}
}