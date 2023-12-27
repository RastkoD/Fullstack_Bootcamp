package mockTest;

public class Osoba {

	// nije trazeno, stoga nije obavezno
	private String ime, prezime;
	private int starost;

	public Osoba() {}

	public Osoba(String ime, String prezime, int starost) {
		this.ime = ime;
		this.prezime = prezime;
		this.starost = starost;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public int getStarost() {
		return starost;
	}

}
