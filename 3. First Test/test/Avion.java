package test1;

/*Napisati apstraktnu klasu Avion koja ima atribute: naziv (tipa String), 
	vrsta (tipa String) i domet (tipa double); metode za pribavljanje
	i postavljanje svih atributa (getere i setere), konstruktor kojim se 
	postavljaju vrednosti svih atributa i apstraktne metode za poletanje i sletanje. 
	Kod svih atributa i metoda navesti i odgovarajuće pristupne atribute.
*/	

public abstract class Avion {
	private String naziv;
	private String vrsta;
	private double domet;
	
	Avion() {};
	
	Avion(String naziv, String vrsta, double domet) {
		this.naziv = naziv;
		this.vrsta = vrsta;
		this.domet = domet;
	}
	
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public void setVrsta(String vrsta) {
		this.vrsta = vrsta;
	}

	public void setDomet(double domet) {
		this.domet = domet;
	}
	
	public String getNaziv() {
		return this.naziv;
	}

	public String getVrsta() {
		return this.vrsta;
	}

	public double getDomet() {
		return this.domet;
	}
	
	public abstract void poletanje();
	
	public abstract void sletanje();
}
