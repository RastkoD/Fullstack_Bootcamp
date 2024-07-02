package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Tekstualna datoteka sadrži podatke o kripto valutama kojima se trguje 
na kriptoberzi u sledećem obliku: 5f99h1ew9fwq 5.00 Litecoin. 
Prvi parametar je jedinstveni identifikator korisnika, drugi je 
količina kripto valute, a treći naziv kripto valute. Napisati 
funkciju kojom se iz ove datoteke mogu učitati podaci o proizvoljnom 
broju kripto valuta u dinamički niz listaKriptoValuta.
 */

public class CryptoReadFile {	
	ArrayList<KriptoValuta> readDataFromFile(String file) {
		ArrayList<KriptoValuta> listaKriptoValuta = new ArrayList<>();
		try (BufferedReader buffReadFile = new BufferedReader(new FileReader(file))) {
			String line;

			while ((line = buffReadFile.readLine()) != null) {
				String[] kriptoInfo = line.split(" ");

				if (kriptoInfo.length == 3) {
					KriptoValuta kriptoValuta = new KriptoValuta(kriptoInfo[0], Double.parseDouble(kriptoInfo[1]), kriptoInfo[2]); 
					listaKriptoValuta.add(kriptoValuta);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		return listaKriptoValuta;

	}

	/*
	private ArrayList<KriptoValuta> listaKriptoValuta = new ArrayList<KriptoValuta>();

	public void readFromFile() {
		try {
			File fileToRead = new File("dataFile.txt");
			Scanner read;

			read = new Scanner(fileToRead);

			while (read.hasNextLine()) {
				String line = read.nextLine();
				String kriptoInfo[] = line.split(" ");
				KriptoValuta kriptoValuta = new KriptoValuta(kriptoInfo[0], Double.parseDouble(kriptoInfo[1]), kriptoInfo[2]);

				listaKriptoValuta.add(kriptoValuta);
			}
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 */

	/*
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
	 */
}

