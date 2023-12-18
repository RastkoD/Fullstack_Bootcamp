package figureInterface;

public class Main {

	public static void main(String[] args) {
		Figure f1, f2;
		
		f1 = new Square("Square", "Green",  4, 0, 5);
		f2 = new Circle("Circle", "Blue", 0, 0, 3);
		
		f1.calcArea();
		f1.printData();
		f1.changeClr("Red");
		f1.printData();
		
        f2.calcArea();
        f2.printData();
        f2.changeClr("Yellow");
        f2.printData();
	}

}
