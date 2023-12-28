package test;

import java.util.Arrays;

public class Shorts {

	public static void main(String[] args) {
		// (n < 6 || n > 142) 
		
		// System.out.println();

		/*
		double x = 8;
		int y = 4;
		int z = 7;
		
		x /= y - z;
		
		System.out.println(x);
		*/
		
		/*
		int x = 1;
		int y = 2*x + 3*(x+3);
		
		for (int k =x; k<= y; k++) {
			if(k%4 < 3) continue; 
			System.out.println("D");
			
		}
		*/
		
		/*
		int x, y, z;
		
		if (Z < Y / X) {
			Z = Y * X;
		} else if (Z > Y * X) {
			Z = - 2;
		}
		*/
		
		/*
		int[] nizCelihBrojeva = {10, 10, 3, 8, 1, 2, 5};

        int razlika = nizCelihBrojeva[0] - nizCelihBrojeva[nizCelihBrojeva.length - 1];
        int[] nizManjih = new int[nizCelihBrojeva.length];
        int[] nizOstalih = new int[nizCelihBrojeva.length];
        int i = 0, j = 0;

        for (int broj : nizCelihBrojeva) {
            if (broj < razlika) {
                nizManjih[i] = broj;
                i++;
            } else {
                nizOstalih[j] = broj;
                j++;
            }
        }

        nizManjih = Arrays.copyOf(nizManjih, i);
        nizOstalih = Arrays.copyOf(nizOstalih, j);

        System.out.println("Prvi podniz (vrednosti manje od razlike): " + Arrays.toString(nizManjih));
        System.out.println("Drugi podniz (ostale vrednosti): " + Arrays.toString(nizOstalih));
	*/
	}

}
