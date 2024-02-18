package vehicleFactory;

public class Main {

	public static void main(String[] args) {
		VehicleFactory factory = new VehicleFactory();

		Product p1 = factory.deliverProduct("Truck");
		p1.deliverProduct();

		Product p2 = factory.deliverProduct("Car");
		p2.deliverProduct();

		Product p3 = factory.deliverProduct("Motorcycle");
		p3.deliverProduct();
	}

}
