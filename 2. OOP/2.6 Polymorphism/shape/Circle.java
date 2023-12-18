package shape;

public class Circle extends Shape {
	private double radius;
	
	Circle(String type, String colour, int numOfSides, double radius) {
		super(type, colour, numOfSides);
		this.radius = radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}

	public double calcArea() {
		return Math.PI * getRadius() * getRadius();
	}
	
	public double calcPerimeter() {
		return 2 * getRadius() * Math.PI;
	}

	
	public void printData() {
		System.out.println("Shape: " + getType() + ", Colour: " + getColour() + ", Number of Sides: " + getNumOfSides() + ", Perimeter: " + calcPerimeter() + ", Area: " + calcArea());
	}
	
}
