package shape;

public class Square extends Shape {
	private double sideLength;

	Square(String type, String colour, int numOfSides, double sideLen) {
		super(type, colour, numOfSides);
		this.sideLength = sideLen;
	}

	public void setSideLength(double sideLen) {
		this.sideLength = sideLen;
	} 

	public double getSideLength() {
		return this.sideLength;
	}

	public double calcArea() {
		return getSideLength() * getSideLength();
	}

	public double calcPerimeter() {
		return 4 * getSideLength();
	}


	public void printData() {
		System.out.println("Shape: " + getType() + ", Colour: " + getColour() + ", Number of Sides: " + getNumOfSides() + ", Perimeter: " + calcPerimeter() + ", Area: " + calcArea());

	}

}
