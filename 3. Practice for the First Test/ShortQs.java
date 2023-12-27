package mockTest;

public class ShortQs {

	public static void main(String[] args) {
		/* 1. Q: Kolika će biti vrednost promenljive x nakon 
		         izvršavanja sledećeg Java programskog koda

		int x = 4;
		int y = 3;

		x /= y - 5;
		System.out.println(x);
		 */

		/* 2. Q: Napisati if izraz(e) koji implementira(ju) 
		         narednu definiciju:
		         c = a + b, a > 5;
			     c = a - b, a < 0;

		int a = -2, b = 0, c;

		if (a > 5) {
			System.out.println(c = a + b);
		} else if (a < 0) {
			System.out.println(c = a - b);
		} else {
			System.out.println("a je izmedju 0 i 5");
		}
		 */

		/* 3. Q: Koliko puta će se u narednom kodu prikazati slovo Q:
		int a, b, i;

		a = 5;
		b = 3 * a + a - 3;

		for (i = a; i <= b; i++) {
			if(i%2 != 0) continue;
			System.out.println("Q");
		}
		 */

		/* 4. Q: Napisati kod za sortiranje niza celih brojeva osnovne tačnosti.
		int[] array = new int[]{7, 5, 8, 2, -1};

		for (int i = 0; i < (array.length - 1); i++ ) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}		
		 */
		
		/* 5. Q: Nacrtati blok dijagram algoritma za prethodni zadatak.
		
		/* 6. Q: U okviru kog paketa Java platforme se nalazi interfejs List?
		java.util (java.util.List)
		 */
	}
}
