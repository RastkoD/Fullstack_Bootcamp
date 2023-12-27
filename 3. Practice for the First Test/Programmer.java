package mockTest;

public class Programmer extends Osoba implements Iterator {
	/*
	Napisati klasu Programer koja nasleđuje klasu Osoba i implementira 
	interfejs Iterator. Klasa ima atribute iskustvo (tipa String) i 
	plata (tipa double), konstruktor (napomena: roditeljska klasa ima
	atribute ime, tipa String, prezime, tipa String i starost, 
	tipa int) i metode za pribavljanje i postavljanje atributa (getere i setere).
	Kod svih atributa i metoda	navesti i odgovarajuće pristupne atribute.
	*/
	
	private String iskustvo;
	private double plata;
	
	public Programmer() {
		super();
	};
	
	public Programmer(String ime, String prezime, int starost, String iskustvo, double plata) {
		super(ime, prezime, starost);
		this.iskustvo = iskustvo;
		this.plata = plata;
	}
	
	public void setIskustvo(String iskustvo) {
		this.iskustvo = iskustvo;
	}
	
	public void setPlata(double plata) {
		this.plata = plata;
	}
	
	public String getIskustvo() {
		return this.iskustvo;
	}
	
	public double getPlata() {
		return this.plata;
	}
}
