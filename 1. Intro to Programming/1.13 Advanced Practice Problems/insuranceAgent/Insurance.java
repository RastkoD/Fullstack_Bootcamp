package insuranceAgent;



public class Insurance {
	static final int DANI = 3;
	static final int KATEGORIJE = 5;
	public static void main(String[] args) {
		
		double[][] evidOsig= new double[][] {{100, 57, 88, 74, 123},
											 {123, 234, 11, 234, 777},
											 {12, 565, 99, 344, 879}};
		char izbor = '0';
		
		do {
			// meni
			ispitMeni();
			
			// izbor
			izbor = preuzmiChar("", "Morate odabrati vrednost u opsegu 0-8", '0', '8');
			
			switch(izbor) {
				case '1': unesiPrihod(evidOsig);
					break;
				case '2': povecajPrihod(evidOsig);
					break;
				case '3': sortiraniPrikazKategorijaZaDan(evidOsig);
					break;
				case '4': sortiraniDanaZaKategoriju(evidOsig);
					break;
				case '5': danSaNajmanjimPrihodom(evidOsig);
					break;
				case '6': // mesecni prihod za svaku kategoriju
					break;
				case '7': // mesecni prihod
					break;
				case '8': izlistajMatricu(evidOsig, "DANI", "KATEGORIJE");
			}
			
			
		}while(izbor !='0');
	}
	static void ispitMeni() {
		System.out.println("--Program za vođenje evidencije agenta osiguranja--");
		System.out.println("  Izaberite jednu od opcija->");
		System.out.println("\t0. Izlazak iz programa");
		System.out.println("\t1. Unos ostvarenog prihoda za željenu kategoriju i željeni dan");
		System.out.println("\t2. Izmena ostvarenog prihoda za željenu kategoriju i željeni dan");
		System.out.println("\t3. ................");
		System.out.println("\t4. ................");
		System.out.println("\t5. ................");
		System.out.println("\t6. ................");
		System.out.println("\t7. ................");
		System.out.println("\t8. ................");
	}
	
	static char preuzmiChar(String poruka, String porukaGreska, char dole, char gore){
		char vred = '0';
		do {
			System.out.println(poruka);
			vred = TextIO.getlnChar();
			if (vred < dole || vred > gore) {
				System.out.println(porukaGreska);
			}
		}while (vred < dole || vred > gore);
		
		return vred;
	}
	
	static int preuzmiInt(String poruka, String porukaGreska, int dole, int gore){
		int vred = 0;
		do {
			System.out.println(poruka);
			vred = TextIO.getlnInt();
			if (vred < dole || vred > gore) {
				System.out.println(porukaGreska);
			}
		}while (vred < dole || vred > gore);
		
		return vred;
	}
	
	static void unesiPrihod(double[][] eo) {
		int dan, kat;
		char odg;
		
		do {
			
			dan = preuzmiInt("Unesi dan za koji unosite prihod", 
					         "Dan mora biti u opsegu 1-"+DANI, 
					         1, DANI);
			kat = preuzmiInt("Unesi kategoriju za koju unosite prihod", 
							 "Kategorija mora biti u opsegu 1-"+KATEGORIJE, 
							 1, KATEGORIJE);
			System.out.println("Prihod " + dan + ". dana od " + kat + ". kategorije je:");
			eo[dan-1][kat-1] = TextIO.getlnDouble();
			
			izlistajMatricu(eo, "DANI", "KATEGORIJE");
			
			System.out.println("Za unos jos jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
		
	}
	
	static void povecajPrihod(double[][] eo) {
		int dan, kat;
		char odg;
		
		do {			
			dan = preuzmiInt("Unesi dan za koji unosite prihod", 
					         "Dan mora biti u opsegu 1-"+DANI, 
					         1, DANI);
			kat = preuzmiInt("Unesi kategoriju za koju unosite prihod", 
							 "Kategorija mora biti u opsegu 1-"+KATEGORIJE, 
							 1, KATEGORIJE);
			System.out.println("Prihod " + dan + ". dana od " + kat + ". kategorije je:");
			eo[dan-1][kat-1] += TextIO.getlnDouble();
			
			izlistajMatricu(eo, "DANI", "KATEGORIJE");
			
			System.out.println("Za izmenu jos jednog prihoda pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
		
	}
	
	static void prikazKategorijaZaDan(double[][] eo) {
		int dan;
		char odg;
		
		do {			
			dan = preuzmiInt("Unesi dan za koji zelite da pregledate prihode", 
					         "Dan mora biti u opsegu 1-"+DANI, 
					         1, DANI);
			
			
			System.out.println("Prodaja kategorija za " + dan + ". dana izgleda:");
			for (int i = 0; i < KATEGORIJE; i++)
				System.out.println("Kategorija " + (i+1) + ": " + eo[dan-1][i]); 
			
			System.out.println("Za pregled jos jednog dana pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
	}
	
	static void sortiraniPrikazKategorijaZaDan(double[][] eo) {
		int dan;
		char odg;
		
		double[] sortKategorije = new double[KATEGORIJE];
		int[] indeksSortKategorije = new int[KATEGORIJE];
		
		do {			
			dan = preuzmiInt("Unesi dan za koji zelite da pregledate prihode", 
					         "Dan mora biti u opsegu 1-"+DANI, 
					         1, DANI);
			
			
			System.out.println("Sortirana prodaja kategorija za " + dan + ". dana izgleda:");
			for (int i = 0; i < KATEGORIJE; i++) {
				sortKategorije[i] = eo[dan-1][i];
				indeksSortKategorije[i]=i;
			}
			
			sortiranjeNizove(sortKategorije, indeksSortKategorije, KATEGORIJE);
			
			/*for (int i = 0; i < KATEGORIJE-1; i++)
				for (int j = i+1; j < KATEGORIJE; j++) {
					if (sortKategorije[i] < sortKategorije[j]) {
						double tpmD = sortKategorije[i];
						int tmpI = indeksSortKategorije[i];
						
						sortKategorije[i] = sortKategorije[j];
						indeksSortKategorije[i] = indeksSortKategorije[j];
						
						sortKategorije[j] = tpmD;
						indeksSortKategorije[j] = tmpI;
					}
						
				}*/
			
			for (int i = 0; i < KATEGORIJE; i++)				
				System.out.println("Kategorija " + (indeksSortKategorije[i]+1) + ": " + sortKategorije[i]); 
			
			System.out.println("Za pregled jos jednog dana pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
	}
	
	static void prikazDanaZaKategoriju(double[][] eo) {
		int kat;
		char odg;
		
		do {			
			kat = preuzmiInt("Unesi kategoriju za koju zelita da pregledate prihode po danima", 
					 "Kategorija mora biti u opsegu 1-"+KATEGORIJE, 
					 1, KATEGORIJE);
	
			
			System.out.println("Prodaja kategorije " + kat + ". po danima izgleda:");
			for (int i = 0; i < DANI; i++)
				System.out.println("Dan " + (i+1) + ": " + eo[i][kat - 1]); 
			
			System.out.println("Za pregled jos jedne kategorije pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
	}
	
	static void sortiraniDanaZaKategoriju(double[][] eo) {
		int kat;
		char odg;
		
		double[] sortDana = new double[DANI];
		int[] indeksSortDana = new int[DANI];
		
		do {			
			kat = preuzmiInt("Unesi kategoriju za koju zelita da pregledate prihode po danima", 
					 "Kategorija mora biti u opsegu 1-"+KATEGORIJE, 
					 1, KATEGORIJE);
			
			
			System.out.println("Sortirana prodaja kategorije " + kat + ". po danima izgleda:");
			for (int i = 0; i < DANI; i++) {
				sortDana[i] = eo[i][kat-1];
				indeksSortDana[i]=i;
			}
			sortiranjeNizove(sortDana, indeksSortDana, DANI);
			
			/*for (int i = 0; i < DANI-1; i++)
			for (int j = i+1; j < DANI; j++) {
				if (sortDana[i] < sortDana[j]) {
					double tpmD = sortDana[i];
					int tmpI = indeksSortDana[i];
					
					sortDana[i] = sortDana[j];
					indeksSortDana[i] = indeksSortDana[j];
					
					sortDana[j] = tpmD;
					indeksSortDana[j] = tmpI;
				}
					
			}*/
		
			
			for (int i = 0; i < DANI; i++)				
				System.out.println("Dan " + (indeksSortDana[i]+1) + ": " + sortDana[i]); 
			
			System.out.println("Za pregled jos jedne kategorije pritisnite taster d");
			odg = TextIO.getlnChar();
		}while(odg == 'd' || odg == 'D');	
	}
	
	static void sortiranjeNizove(double[] doubleNiz, int[] intNiz, int duzNiza) {
		
		
		for (int i = 0; i < duzNiza-1; i++)
			for (int j = i+1; j < duzNiza; j++) {
				if (doubleNiz[i] < doubleNiz[j]) {
					double tpmD = doubleNiz[i];
					int tmpI = intNiz[i];
					
					doubleNiz[i] = doubleNiz[j];
					intNiz[i] = intNiz[j];
					
					doubleNiz[j] = tpmD;
					intNiz[j] = tmpI;
				}
					
			}
	}
	
	static void danSaNajmanjimPrihodom(double[][] eo) {
		int i,j;
		
		int pozMin = 0;
		
		double[] zaradaPoDanu = new double[DANI];
		
		for (i = 0; i < DANI; i++) {
			for (j = 0; j < KATEGORIJE; j++)
				zaradaPoDanu[i] += eo[i][j];
			System.out.println((i+1)+". dana ostvaren je " + zaradaPoDanu[i]+" prihod");
		}
		
		for (i = 1; i < DANI; i++) {
			if (zaradaPoDanu[i] < zaradaPoDanu[pozMin])
				pozMin = i;
		}
		
		System.out.println((pozMin+1)+". dana ostvaren je najmanji prihod koji iznosi "+zaradaPoDanu[pozMin]);
	}
	
	static void izlistajMatricu(double[][] eo, String nazivVrste, String nazivKolone) {
		int i,j;
		
		int duzinaNazivaVrste = nazivVrste.length();
		
		ispisiPraznaMesta(duzinaNazivaVrste+20);
		System.out.println(nazivKolone);
		
		System.out.println(nazivVrste);
		
		for (i = 0; i < DANI; i++) {
			ispisiPraznaMesta(duzinaNazivaVrste + 2);
			for (j = 0; j < KATEGORIJE; j++)
				System.out.printf("%10.2f", eo[i][j]);
			System.out.println();
		}
		
		
	}
	
	static void ispisiPraznaMesta(int brPraznihMesta) {
		for (int i = 0; i < brPraznihMesta; i++)
			System.out.print(" ");
	}
}
