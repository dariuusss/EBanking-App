package project;

import javax.swing.*;

public class ComandaTransfer implements Comanda {
    private BazaDeDate bd;
    private String email, friendEmail, valuta;
    private double suma;

    JTextArea textArea;

    public ComandaTransfer(BazaDeDate bd, String email, String friendEmail, String valuta, double suma, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.friendEmail = friendEmail;
        this.valuta = valuta;
        this.suma = suma;
        this.textArea = textArea;
    }

    public void executa() {
        Utilizator u1, u2;
        u1 = u2 = null;
        for (Utilizator u3 : bd.getLista_useri())
            if (u3.getEmail().equals(email)) {
                u1 = u3;
                break;
            }

        for (Utilizator u3 : u1.getPrieteni())
            if (u3.getEmail().equals(friendEmail)) {
                u2 = u3;
                break;
            }


        ////////////////////
        String[] nume_valute = {"EUR", "GBP", "JPY", "CAD", "USD"};
        Cont c1, c2;
        c1 = c2 = null;
        int i;
        for (i = 0; i < 5; i++)
            if (nume_valute[i].equals(valuta)) break;

        c1 = u1.getCont(valuta);
        c2 = u2.getCont(valuta);


        if (u2 == null) {
            textArea.append("You are not allowed to transfer money to " + friendEmail);
        } else {
            if (suma > c1.getSold()) {
                textArea.append("Insufficient amount in account " + valuta + " for transfer\n");
            } else {
                c1.retrage(suma);
                c2.alimenteaza_cont(suma);
            }
        }
    }
}