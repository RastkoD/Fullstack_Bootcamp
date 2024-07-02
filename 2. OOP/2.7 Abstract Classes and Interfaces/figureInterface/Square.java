package figureInterface;

public class Square extends Shape implements Figure {
	private double sideLength;
	
	Square(String type, String colour, int numOfSides, double area, double sideLen) {
	    super(type, colour, numOfSides, area);
	    this.sideLength = sideLen;
	}

	protected void setSideLength(double sideLen) {
		this.sideLength = sideLen;
	} 
	
	protected double getSideLength() {
		return this.sideLength;
	}
	
	public double calcArea() {
		return getSideLength() * getSideLength();
	}
	
	public double calcPerimeter() {
		return 4 * getSideLength();
	}
	
	public void printData() {
		System.out.println("Colour: " + getColour() + " Type: " +	getType() + " Area: " + calcArea() + " Perimeter: " + calcPerimeter());

	}
}
