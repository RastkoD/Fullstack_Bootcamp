package homework;

public class Circle extends Shape {
	private double radius;
	
	Circle(String type, String colour, int numOfSides, double area, double radius) {
		super(type, colour, numOfSides, area);
		setRadius(radius);
	}

	protected void setRadius(double radius) {
		this.radius = radius;
	}
	
	protected double getRadius() {
		return this.radius;
	}

	public void calcArea() {
		setArea(Math.PI * getRadius() * getRadius());
	}
}
