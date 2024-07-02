package test1;

public abstract class Berza {
    protected String naziv;
    protected String grad;
    protected String nazivIndeksa;
    protected double vrednostIndeksa;

    public Berza(String naziv, String grad, String nazivIndeksa, double vrednostIndeksa) {
        this.naziv = naziv;
        this.grad = grad;
        this.nazivIndeksa = nazivIndeksa;
        this.vrednostIndeksa = vrednostIndeksa;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getNazivIndeksa() {
        return nazivIndeksa;
    }

    public void setNazivIndeksa(String nazivIndeksa) {
        this.nazivIndeksa = nazivIndeksa;
    }

    public double getVrednostIndeksa() {
        return vrednostIndeksa;
    }

    public void setVrednostIndeksa(double vrednostIndeksa) {
        this.vrednostIndeksa = vrednostIndeksa;
    }
}


