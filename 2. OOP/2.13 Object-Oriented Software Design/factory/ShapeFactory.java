package factory;

public class ShapeFactory {
	public Shape createShape(String shape) {
		if (shape.equals("Circle")) {
			return new Circle();
		} else if (shape.equals("Square")) {
			return new Square();
		} else if (shape.equals("Rectangle")) {
			return new Rectangle();
		} else {
			return null;
		}
	}
}
