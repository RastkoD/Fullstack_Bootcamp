package homework;

public class Square extends Shape {
	private double sideLength;
	
	Square(String colour, String type, int numOfSides, double area, double sideLen) {
		super(colour, type, numOfSides, area);
		setSideLength(sideLen);
	}

	protected void setSideLength(double sideLen) {
		this.sideLength = sideLen;
	} 
	
	protected double getSideLength() {
		return this.sideLength;
	}
	
	public void calcArea() {
		setArea(getSideLength() * getSideLength());
	}
	
}
