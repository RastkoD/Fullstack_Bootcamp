package shape;

public class Shape {
	private String colour, type;
	private int numOfSides;

	Shape() {}

	Shape(String type, String colour, int nos) {
		this.type = type;
		this.colour = colour;
		this.numOfSides = nos;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setNumOfSides(int nos) {
		this.numOfSides = nos;
	}

	public String getColour() {
		return this.colour;
	}

	public String getType() {
		return this.type;
	}

	public int getNumOfSides() {
		return this.numOfSides;
	}

	public void changeClr(String newClr) {
		this.colour = newClr;
	}

	public void printData() {
		System.out.println("Shape: " + type + ", Colour: " + colour + ", Number of Sides: " + numOfSides);

	}
}
