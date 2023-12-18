package interfaces;

public class Main {

	public static void main(String[] args) {
		Izvedena d = new Izvedena();
		
		//Bazna b = new Bazna();
		
		Bazna b = new Izvedena();
		
		Klasa k = new Klasa();
		
		Interfejs i = new Izvedena();
		
		d.funkcija();
		
		b.funkcija();
		
		d.prikazi();
		
		b.prikazi();
		
		k.prikazi();
		
		i.prikazi();
	}

}
