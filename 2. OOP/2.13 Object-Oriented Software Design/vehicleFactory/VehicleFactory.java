package vehicleFactory;

public class VehicleFactory {
	public Product deliverProduct(String shape) {
		if (shape.equals("Truck")) {
			return new Truck();
		} else if (shape.equals("Car")) {
			return new Car();
		} else if (shape.equals("Motorcycle")) {
			return new Motorcycle();
		} else {
			return null;
		}
	}
}
