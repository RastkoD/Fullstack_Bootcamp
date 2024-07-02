package mockTest;

public abstract class Shape {
	/*
		Napisati apstraktnu klasu Oblik koja ima atribute: boja (tipa String),
		tip (tipa String) i brojStrana (tipa int); metode za pribavljanje
		i postavljanje	svih atributa (getere i setere), konstruktor kojim 
		se postavljajuju vrednosti svih atributa i apstraktne metode za
		računanje površine i obima. Kod svih atributa i metoda 
		navesti i odgovarajuće pristupne atribute.
	 */

	private String boja;
	private String tip;
	private int brojStrana;

	Shape() {};

	Shape(String boja, String tip, int brojStrana) {
		this.boja = boja;
		this.tip = tip;
		this.brojStrana = brojStrana;
	}

	public void setBoja(String boja) {
		this.boja = boja;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public String getBoja() {
		return this.boja;
	}

	public String getTip() {
		return this.tip;
	}

	public int getBrojStrana() {
		return this.brojStrana;
	}

	public abstract void racunajPovrsinu();

	public abstract void racunajObim();

}

