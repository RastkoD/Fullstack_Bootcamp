package test1;

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


