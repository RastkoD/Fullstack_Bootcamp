package control_structures;

public class InputPractice {

	public static void main(String[] args) {
		/*
		int MarkovaOcena;
		
		System.out.print("Unesite neki ceo broj: ");
		MarkovaOcena = TextIO.getlnInt();
		
		
		System.out.println();
		System.out.println("Broj koji ste uneli je " + MarkovaOcena);
		System.out.println();
		*/
		
		int i, sum, n;
		
		System.out.println("Enter a number");
		n = TextIO.getInt();
		sum = 0;
		
		for (i = 1; i <= n; i++) {
			sum = sum + i;
		}
		
		System.out.println(sum);
		
	}
}


