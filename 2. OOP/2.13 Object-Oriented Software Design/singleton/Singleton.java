package singleton;

public class Singleton {
	private static Singleton instanca = null;
	
	public String s;
	
	protected Singleton() {
		
		// Postoji samo kako bi sprecili instanciranje
		this.s = "Singleton";
	}
	
	public static Singleton pribaviInstancu() {

		if(instanca == null) {

			instanca = new Singleton();

		}
		return instanca;

	}
}
