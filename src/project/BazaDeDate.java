package project;

import java.util.*;

class BazaDeDate {

    private static BazaDeDate instance;

    public static BazaDeDate getInstance() {
        if (instance == null)
            instance = new BazaDeDate();
        return instance;
    }

    private BazaDeDate() {
        lista_useri = new ArrayList<>();
        matrice = new double[5][5];
        lista_actiuni = new ArrayList<>();
    }

    private ArrayList<Utilizator> lista_useri;

    public ArrayList<Utilizator> getLista_useri() {
        return this.lista_useri;
    }

    double[][] matrice; //matricea cu ratele de conversie valutara

    private ArrayList<Actiuni> lista_actiuni;

    public ArrayList<Actiuni> getLista_actiuni() {
        return this.lista_actiuni;
    }

    public void adauga_cont(Utilizator u, String valuta) throws ConturiMultipleValutaException {
        ArrayList<Cont> conturi = u.getConturi();

        for (Cont c : conturi) {
            if (c.getValuta().equals(valuta)) {
                throw new ConturiMultipleValutaException("Account in currency " + valuta + " already exists for user");
            }
        }

        u.getConturi().add(ContFactory.creaza_cont(valuta));
    }

    public void reseteaza() {
        instance = null;
    }


}