package homework;

public class Main {

	public static void main(String[] args) {
		
		Square sqr = new Square("Square", "Green",  4, 0, 5);
		Circle circ = new Circle("Circle", "Blue", 0, 0, 3);
		
		
		sqr.calcArea();
		sqr.printData();
		sqr.changeClr("Red");
		sqr.printData();
		
        circ.calcArea();
        circ.printData();
        circ.changeClr("Yellow");
        circ.printData();
	}

}
