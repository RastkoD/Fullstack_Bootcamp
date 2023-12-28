package test1;

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
