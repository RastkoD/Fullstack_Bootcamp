package vehicle;

public class Main {

	public static void main(String[] args) {
		Person firstPerson = new Person("Peregrin", "Took", 28);	
		Person secondPerson = new Person("Samwise", "Gamgee", 30);
		
		Ownership vehicle, car, truck, motorcycle;
		
		//vehicle = new Vehicle();
		car = new Car("Opel", "Corsa", "NS021IT", 2004, false, "petrol", 55, 1199, firstPerson, 5);
		truck = new Truck("Volvo", "FH", "NS021RS", 2016, false, "diesel", 800, 5500, firstPerson, 3);
		motorcycle = new Motorcycle("Honda", "Rebel", "ZA018RS", 1998, false, "diesel", 22, 250, firstPerson, false);
		
		vehicle = car;
		vehicle.printData();
		car.printData();
		truck.printData();
		motorcycle.printData();
	
		car.changeOwner(secondPerson);
		truck.changeOwner(secondPerson);
		motorcycle.changeOwner(secondPerson);
		
		car.printData();
		truck.printData();
		motorcycle.printData();
		
		//car.driveUnit.printData();

	}		
}
