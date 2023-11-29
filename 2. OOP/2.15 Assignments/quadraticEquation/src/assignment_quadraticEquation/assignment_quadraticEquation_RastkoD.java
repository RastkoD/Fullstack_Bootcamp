package assignment_quadraticEquation;

public class assignment_quadraticEquation_RastkoD {

	public static void main(String[] args) {
		/*
		Implementirati program za računanje kvadratne jednačine. 
		Obezbediti sve obavezne provere ulaznih vrednosti. 
		Izračunati sva moguća rešenja u zavisnosti od mogućih 
		ulaznih vrednosti promenljivih a, b i c.
		Nakon što se izračuna rešenje kvadratne jednačine, 
		korisnika treba pitati da li želi da unese novu kvadratnu jednačinu.
		*/
		boolean solveAgain;
		
		do {
			double a = 0;
			double b = 0;
			double c = 0;
			
			double d = 0;
			
			double x, x1, y, y1;
			
			System.out.println("Enter the numbers for quadratic formula");
			System.out.println("a = ");
			a = TextIO.getlnDouble();			
			System.out.println("b = ");
			b = TextIO.getlnDouble();
			System.out.println("c = ");
			c = TextIO.getlnDouble();
			
			d = (b * b) - (4 * a * c);

			if (a == 0 && b == 0) {
				
				System.out.println("No possible solutions");
			
			} else if (a == 0) {
				
				x = -c / b;
					
				System.out.println("Not a quadratic, but linear equation because a = 0");
				System.out.println("x = " + x);
									
			} else if (b == 0 && c == 0) {
				
				System.out.println("Any number can be a solution because all three numbers are zero");
				
			} else if (d < 0) {
				
				y = Math.sqrt(-d) / (2 * a);
				y1 = -(Math.sqrt(-d) / (2 * a));
				
				System.out.println("Two solutions:");
				System.out.println("x = " + String.format("%.2f", y) + "i");
				System.out.println("x1 = " + String.format("%.2f", y1) + "i");
				
			} else if (d == 0) {
				
				x =  -b / (2 * a);
				
				System.out.println("One solution:");
				System.out.println("x = " + String.format("%.2f", x));
			
			} else {
				
				x = (-b + Math.sqrt(d)) / (2 * a);
				x1 = (-b - Math.sqrt(d)) / (2 * a);
				
				System.out.println("Two solutions:");
				System.out.println("x = " + String.format("%.2f", x));
				System.out.println("x1 = " + String.format("%.2f", x1));
			
			} 			
			
			System.out.println("Do you want to solve another one? (yes/no): ");
			String response = TextIO.getln().toLowerCase();
			solveAgain = response.contains("yes");
	        
		} while (solveAgain);
		

	}

}
