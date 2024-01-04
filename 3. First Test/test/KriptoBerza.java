package test1;

/*Napisati klasu KriptoBerza koja nasleđuje apstraktnu klasu Berza i implementira 
	interfejs RadSaTransakcijama. Klasa ima atribute listaTrgovaca (tipa ArrayList<Trgovac>), 
	listaKriptoValuta (tipa ArrayList<KriptoValuta>) i listaTransakcija (tipa ArrayList<Transakcija>), 
	konstruktor (napomena: roditeljska klasa ima atribute: naziv, tipa String; grad, tipa String; 
	nazivIndeksa tipa String; vrednostIndeksa, tipa double) i metode za pribavljanje i postavljanje 
	atributa (getere i setere). Interfejs RadSaTransakcijama ima samo metodu izvrsiTransakciju koja 
	vlasnistvo nad kripto valutom iz niza listaKriptoValuta prenosi sa jednog na drugog trgovca 
	iz niza listaTrgovaca. Prepostaviti da je svaki element niza listaKriptoValuta kripto valuta 
	koji kao svoje atribute sadrži vlasnika, količinu i naziv valute. Kod svih atributa i metoda 
	navesti i odgovarajuće pristupne atribute.
*/

import java.util.ArrayList;

public class KriptoBerza extends Berza implements RadSaTransakcijama {
	private ArrayList<Trgovac> listaTrgovaca;
    private ArrayList<KriptoValuta> listaKriptoValuta;
    private ArrayList<Transakcija> listaTransakcija;

    public KriptoBerza(String naziv, String grad, String nazivIndeksa, double vrednostIndeksa) {
        super(naziv, grad, nazivIndeksa, vrednostIndeksa);
        this.listaTrgovaca = new ArrayList<>();
        this.listaKriptoValuta = new ArrayList<>();
        this.listaTransakcija = new ArrayList<>();
    }
    
    

    public void setListaTrgovaca(ArrayList<Trgovac> listaTrgovaca) {
        this.listaTrgovaca = listaTrgovaca;
    }
    
    public void setListaKriptoValuta(ArrayList<KriptoValuta> listaKriptoValuta) {
        this.listaKriptoValuta = listaKriptoValuta;
    }
    
    public void setListaTransakcija(ArrayList<Transakcija> listaTransakcija) {
        this.listaTransakcija = listaTransakcija;
    }
    
    public ArrayList<Trgovac> getListaTrgovaca() {
        return listaTrgovaca;
    }
    
    public ArrayList<KriptoValuta> getListaKriptoValuta() {
        return listaKriptoValuta;
    }

    public ArrayList<Transakcija> getListaTransakcija() {
        return listaTransakcija;
    }

	@Override
	public void izvrsiTransakciju(Trgovac prodavac, Trgovac kupac, KriptoValuta kriptoValuta, double kolicina) {
		// TODO Auto-generated method stub
		
	}

    
}
