package project;


import javax.swing.*;

public class ComandaAdaugareCont implements Comanda {

    private BazaDeDate bd;
    private String email;
    private String valuta;

    JTextArea textArea;

    public ComandaAdaugareCont(BazaDeDate bd, String email, String valuta, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.valuta = valuta;
        this.textArea = textArea;
    }

    public void executa() {
        Utilizator u = null;
        for (Utilizator utilizator : bd.getLista_useri())
            if (utilizator.getEmail().equals(email)) {
                u = utilizator;
                break;
            }


        try {
            bd.adauga_cont(u, valuta);
        } catch (ConturiMultipleValutaException e) {
            textArea.append(e.getMessage());
        }

    }
}