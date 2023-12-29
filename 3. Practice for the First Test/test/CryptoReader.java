package test1;

/*Tekstualna datoteka sadrži podatke o kripto valutama kojima se trguje na kriptoberzi u sledećem 
	obliku: 5f99h1ew9fwq 5.00 Litecoin. Prvi parametar je jedinstveni identifikator korisnika, drugi je 
	količina kripto valute, a treći naziv kripto valute. Napisati funkciju kojom se iz ove datoteke mogu 
	učitati podaci o proizvoljnom broju kripto valuta u dinamički niz listaKriptoValuta.
*/	

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CryptoReader {
	 public static List<KriptoValuta> ucitajPodatke(String putanjaDoDatoteke) {
	        List<KriptoValuta> listaKriptoValuta = new ArrayList<>();

	        try (Scanner scanner = new Scanner(new File(putanjaDoDatoteke))) {
	            while (scanner.hasNext()) {
	                String idKorisnika = scanner.next();
	                double kolicina = scanner.nextDouble();
	                String nazivValute = scanner.next();

	                KriptoValuta kriptoValuta = new KriptoValuta(idKorisnika, kolicina, nazivValute);
	                listaKriptoValuta.add(kriptoValuta);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }

	        return listaKriptoValuta;
	    }

	  
	}


