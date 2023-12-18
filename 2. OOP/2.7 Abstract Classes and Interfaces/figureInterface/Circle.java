package figureInterface;

public class Circle extends Shape implements Figure {
	private double radius;
	
	Circle(String type, String colour, int numOfSides, double area, double radius) {
		super(type, colour, numOfSides, area);
		this.radius = radius;
	}

	protected void setRadius(double radius) {
		this.radius = radius;
	}
	
	protected double getRadius() {
		return this.radius;
	}

	public double calcArea() {
		return Math.PI * getRadius() * getRadius();
	}
	
	public double calcPerimeter() {
		return 2 * getRadius() * Math.PI;
	}

	public void printData() {
		System.out.println("Colour: " + getColour() + " Type: " +	getType() + " Area: " + calcArea() + " Perimeter: " + calcPerimeter());

	}
}
