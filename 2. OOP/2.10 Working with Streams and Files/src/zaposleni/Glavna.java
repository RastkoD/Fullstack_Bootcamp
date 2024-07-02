package zaposleni;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Glavna {
		
	public static void main(String[] args) throws IOException{
		
		int cenaRada;
		int n;
		String znak;
			
		FileReader ulaz = null;
		BufferedReader bafUlaz = null;
		FileWriter izlaz = null;
		BufferedWriter bafIzlaz = null;
			
		try
		{
			ulaz = new FileReader("spisak.txt");
			bafUlaz = new BufferedReader(ulaz);
			izlaz = new FileWriter("plate.txt");
			bafIzlaz = new BufferedWriter(izlaz);
			cenaRada = Integer.parseInt(bafUlaz.readLine());
			n = Integer.parseInt(bafUlaz.readLine());
			
			for(int i = 0; i < n; i++)
			{
				znak = bafUlaz.readLine();
				Radnik r;
				if(znak.startsWith("+")) {
					r = new AktivanRadnik();
				}
				else {
					r = new RadnikNaBolovanju();
				}
				r.unosTxt(bafUlaz);
				r.upisTxt(bafIzlaz, cenaRada);	
			}
			System.out.println("Program je uspesno izvrsen!");
				
		} catch(IOException e){
			System.out.println(e.getMessage());
		}
		finally {
			if (bafUlaz != null) {
				bafUlaz.close();
			}
			if (ulaz != null) {
				ulaz.close();
			}
			if (bafIzlaz != null) {
				bafIzlaz.close();
			}
			if (izlaz != null) {
				izlaz.close();
			}
		}
	}
}
