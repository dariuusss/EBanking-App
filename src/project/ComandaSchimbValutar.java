package project;


import javax.swing.*;

public class ComandaSchimbValutar implements Comanda {

    private BazaDeDate bd;
    private String email;
    private String sursa, destinatie;
    private double suma;

    JTextArea textArea;

    public ComandaSchimbValutar(BazaDeDate bd, String email, String sursa, String destinatie, double suma, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.sursa = sursa;
        this.destinatie = destinatie;
        this.suma = suma;
        this.textArea = textArea;
    }

    public void executa() {

        String[] nume_valute = {"EUR", "GBP", "JPY", "CAD", "USD"};
        Cont c1, c2;
        Utilizator u = null;
        c1 = c2 = null;
        for (Utilizator u2 : bd.getLista_useri())
            if (u2.getEmail().equals(email)) {
                u = u2;
                break;
            }


        int i, j;
        for (i = 0; i < 5; i++)
            if (nume_valute[i].equals(sursa)) break;
        for (j = 0; j < 5; j++)
            if (nume_valute[j].equals(destinatie)) break;

        c1 = u.getCont(nume_valute[i]);
        c2 = u.getCont(nume_valute[j]);


        double pret_total = 0;
        if (u.getTip() == 0 && suma * bd.matrice[j][i] > 0.5 * c1.getSold())
            pret_total = suma * bd.matrice[j][i] * 1.01;
        else pret_total = suma * bd.matrice[j][i];
        if (pret_total > c1.getSold()) {
            textArea.append("Insufficient amount in account " + nume_valute[i] + " for exchange\n");
        } else {
            c1.retrage(pret_total);
            c2.alimenteaza_cont(suma);
        }


    }

}