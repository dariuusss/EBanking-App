package project;

import javax.swing.*;

public class ComandaCumparareActiuni implements Comanda {
    private BazaDeDate bd;
    private String email, company;
    private int number_of_stocks;

    JTextArea textArea;

    public ComandaCumparareActiuni(BazaDeDate bd, String email, String company, int number_of_stocks, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.company = company;
        this.number_of_stocks = number_of_stocks;
        this.textArea = textArea;
    }

    public void executa() {
        Utilizator u = null;
        Actiuni a = null;
        double pret = 0;
        for (Actiuni a2 : bd.getLista_actiuni())
            if (a2.nume_companie.equals(company)) {
                pret = a2.getValori().get(9);
                a = a2;
                break;
            }

        pret = pret * 100000;
        pret = Math.floor(pret);
        pret = pret / 100000;

        for (Utilizator u2 : bd.getLista_useri())
            if (u2.getEmail().equals(email)) {
                u = u2;
                break;
            }

        double pret_total = 0;
        if (u.getTip() == 1 && a.getTip() == 1) pret_total = pret * number_of_stocks * 0.95;
        else pret_total = pret * number_of_stocks;


        if (pret_total > u.getCont("USD").getSold()) {
            textArea.append("Insufficient amount in account for buying stock\n");
        } else {
            u.getCont("USD").retrage(pret_total);
            for (Actiuni a2 : u.getActiuni())
                if (a2.nume_companie.equals(company)) {
                    a2.nr += number_of_stocks;
                    break;
                }
        }


    }

}