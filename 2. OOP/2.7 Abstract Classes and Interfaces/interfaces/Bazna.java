package interfaces;
 
abstract class Bazna implements Interfejs{
	
	Bazna() {
		System.out.println("Pozvan konstruktor bazne klase.");
	}

	abstract void funkcija();
	
	public void prikazi() 
    { 
        System.out.println("Poziv metoda."); 
        System.out.println(a);
    } 
}
