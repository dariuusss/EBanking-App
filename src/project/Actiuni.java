package project;

import java.util.*;

class Actiuni {

    Actiuni() {
        this.tip = 0; //initial nu e recomandata
    }

    String nume_companie;
    private ArrayList<Double> valori = new ArrayList<>();

    public ArrayList<Double> getValori() {
        return this.valori;
    }

    private double medie_lunga = 0;

    public void setMedie_lunga(double medie) {
        this.medie_lunga = medie;
    }

    private double medie_scurta = 0;

    public void setMedie_scurta(double medie) {
        this.medie_scurta = medie;
    }

    public double getMedie_scurta() {
        return this.medie_scurta;
    }

    public int nr = 0; //nr de actiuni cumparate

    private int tip; //tip = 0 inseamna nerecomandata,1 da

    public int getTip() {
        return this.tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

}