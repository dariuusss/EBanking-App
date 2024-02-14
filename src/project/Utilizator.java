package project;

import java.util.*;

class Utilizator {
    private String email; //este unic

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String nume;

    public String getNume() {
        return this.nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    private String prenume;

    public String getPrenume() {
        return this.prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    private String adresa;

    public String getAdresa() {
        return this.adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }


    private ArrayList<Utilizator> prieteni = new ArrayList<>();

    public ArrayList<Utilizator> getPrieteni() {
        return this.prieteni;
    }

    private ArrayList<Cont> conturi = new ArrayList<>();

    public ArrayList<Cont> getConturi() {
        return conturi;
    }

    public Cont getCont(final String valuta) {
        for (Cont c : conturi) {
            if (c.getValuta().equals(valuta)) return c;
        }

        return null;
    }

    private ArrayList<Actiuni> actiuni = new ArrayList<>();

    public ArrayList<Actiuni> getActiuni() {
        return this.actiuni;
    }


    private int nr_actiuni = 0;

    public int getNr_actiuni() {
        int nr = 0;
        for (int i = 0; i < actiuni.size(); i++)
            if (actiuni.get(i).nr > 0) nr++;
        return nr;
    }

    private int tip; //tip = 0 inseamna normal,1 premium

    public int getTip() {
        return this.tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

}