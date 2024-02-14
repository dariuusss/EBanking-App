package project;

public abstract class Cont {
    private double suma;
    private String valuta;

    public Cont(String valuta) {
        this.suma = 0;
        this.valuta = valuta;
    }

    public void alimenteaza_cont(double suma) {
        this.suma += suma;
    }

    public void retrage(double suma) {
        this.suma -= suma;
    }

    public double getSold() {
        return suma;
    }

    public String getValuta() {
        return valuta;
    }
}