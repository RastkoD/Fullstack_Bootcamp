package homework;

public class Homework {

	public static void main(String[] args) {
		
		/*
		// 1. zamena 2 lokacije
		int a = 21;
		int b = 54;
		int temp;
		
		System.out.println("Pre zamene: a = " + a + ", b = " + b);
		
		temp = a;
		a = b;
		b = temp;
		
		
		System.out.println("Posle zamene: a = " + a + ", b = " + b);
        */
		
		
		/*
		// 2. ulevo
		String x, y, z, temp;
		
		x = "svima!";
		y = "Dobro";
		z = "jutro";
		
		System.out.println("pre - " + x + " " + y + " " + z);
		
		temp = x;
		x = y;
		y = z;
		z = temp;
			        
	    System.out.println("posle - " + x + " " + y + " " + z);
		*/
		
		
		/*
		// 3. suma prvih n br
		int n, i, sum;
		
		n = 6;
		sum = 0;
		
		for (i = 1; i <= n; i++) {
			sum = sum + i;
		}
		
		System.out.println("Suma zadatih brojeva je: " + sum);
		*/
		
		
		/*
		// 4. minimum iz unetog skupa
		int n = 4;
		int[] array = {10, 2, 6, 7};
		int min = array[0];
		System.out.println(min);

		for (int i = 0; i <= n - 1; i++) {
			if (min > array[i]) {
				min = array[i];
			}
			
		}
		
		System.out.println(min);
		*/

		
		
		/*
		// 5. suma tri br
		int x, y, z, sum;
		
		x = 5;
		y = 43;
		z = -43;
		sum = x + y + z;
		
		System.out.println("Suma tri broja je: " + sum);
		*/
		
		
		/*
		// 6. suma n unetih br
		int n, i, sum;
				
		n = 4;
		sum = 0;
				
		for (i = 1; i <= n; i++) {
			
			double randomNum = Math.random();
			System.out.println("uneti broj je: " + randomNum * 100);
			
			sum = (int) (sum + (randomNum * 100));
		}
				
		System.out.println("Suma zadatih brojeva je: " + sum);
		*/
		
		
		/*
		// 1a. pozicija minimalne vrednosti u unetom nizu
		int n = 5;
		int[] array = {10, 2, 6, 7, 1};
		int min = array[0];
		int pos = 0;
		System.out.println(min);

		for (int i = 0; i < n; i++) {
			if (min > array[i]) {
				min = array[i];
				pos = i;
			}
			
		}
		
		System.out.println("Minimum value: " + min);
		System.out.println("Position of minimum value: " + pos);
		*/
		
		/*
		// 2a. svi min i njihove poz u unetom nizu
		int n = 8;
		int[] array = {3, 8, 3, 7, 7, 3, 9, 4};
		int min = array[0];

		for (int i = 1; i < n; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		
		System.out.println("Minimum value: " + min);
			
			
		System.out.print("Positions of minimum value: ");
		
		for (int j = 0; j < n; j++) {
			if (min == array[j]) {
				System.out.print(j + " ");
			}
		}
		*/
		
		
		/*
		// 3a. promalazenje n-te vrednosti u nizu vrednosti
		int n = 6;
		int x, y, nth;
		
		
		if (n < 2) {
			System.out.println("Enter a number bigger than 2");
		}
		
		x = 3;
		y = 6;
		nth = 0;
		
		for (int i = 2; i < n; i++) {
				nth = x + y;
				x = y;
				y = nth;
			
		}
		System.out.println(nth);
		*/
	}
}
