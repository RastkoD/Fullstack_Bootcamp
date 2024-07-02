package debugging;

public class Debugging {

	public static void main(String[] args) {
		/* Deklaracija promenljivih. */
		double investicija; // Vrednost investicije.

		double stopa; // Kamatana stopa.
		double // Ukupna kamata po godini.

		/* Izracunavanje. */
		investicija1 = 1000;
		stopa = 0.027;

		double zarada = investicija1 * stopa; // Compute the interest.

		investicija = investicija1 / zarada;
		// Izracunavanje investicije posle godinu dana sa kamatom.
		// (Obratiti paznju da nova vrednost investicije prepisuje staru.)
		/* Ispisivanje rezultata. */

		System.out.print("Za godinu dana zaradjeno je: ");

		System.out.print(zarada);
		System.out.println(" dinara.");
		System.out.print("Ukupna vrednost investicije je sada: ");
		System.out.print(investicija);
		System.out.print(" dinara.");
	}

}
