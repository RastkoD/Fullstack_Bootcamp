package shape;

public class Main {

	public static void main(String[] args) {
		
		Shape sqr = new Square("Square", "Green",  4, 5);
		Shape circ = new Circle("Circle", "Blue", 0, 3);
		
		
		sqr.printData();
		sqr.changeClr("Red");
		sqr.printData();
		
        circ.printData();
        circ.changeClr("Yellow");
        circ.printData();
	}

}
