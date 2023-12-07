package homework;

public class Shape {
	private String colour, type;
	private int numOfSides;
	private double area;

	Shape() {}

	Shape(String type, String colour, int nos, double area) {
		setColour(colour);
		setType(type);
		setNumOfSides(nos);
		setArea(area);
	}

	protected void setColour(String colour) {
		this.colour = colour;
	}

	protected void setType(String type) {
		this.type = type;
	}

	protected void setNumOfSides(int nos) {
		this.numOfSides = nos;
	}

	protected void setArea(double area) {
		this.area = area;
	}

	protected String getColour() {
		return this.colour;
	}

	protected String getType() {
		return this.type;
	}

	protected int getNumOfSides() {
		return this.numOfSides;
	}

	protected double getArea() {
		return this.area;
	}
	
	public void changeClr(String newClr) {
		this.colour = newClr;
	}

	public void printData() {
		System.out.println("Shape: " + type + ", Colour: " + colour + ", Number of Sides: " + numOfSides + ", Area: " + area);

	}









}
