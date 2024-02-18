package factory;

public class Main {

	public static void main(String[] args) {
		ShapeFactory factory = new ShapeFactory();

		Shape sh1 = factory.createShape("Circle");
		sh1.writeShape();

		Shape sh2 = factory.createShape("Square");
		sh2.writeShape();

		Shape sh3 = factory.createShape("Rectangle");
		sh3.writeShape();
	}

}
