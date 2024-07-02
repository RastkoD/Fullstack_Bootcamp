package accuracy_robustness_and_exception_handling;

public class Main {

	public static void main(String[] args) {
		System.out.println(koren(0, 5, 7));
		System.out.println(koren(4, 2, 7));
		System.out.println(koren(4, 15, 7));
	}	
	/*
	static public double koren( double A, double B, double C )
			throws IllegalArgumentException {

		if (A == 0) {
			throw new IllegalArgumentException("A ne moze biti nula!");
		}
		else {
			double disk = B*B - 4*A*C;
			if (disk < 0)
				throw new IllegalArgumentException("Diskriminanta manja od nule!");
			return (-B + Math.sqrt(disk)) / (2*A);
		}

	}
	 */

	static public double koren( double A, double B, double C ) {
		assert A != 0 : "Vodeci koeficijent kvadratne jednacine	ne sme biti nula!";

				double disk = B*B - 4*A*C;
		assert disk >= 0 : "Diskriminanta kvadratne jednacine ne sme biti negativna!";
		return (-B + Math.sqrt(disk)) / (2*A);
	}
}

