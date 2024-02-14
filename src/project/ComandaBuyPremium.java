package project;


import javax.swing.*;

public class ComandaBuyPremium implements Comanda {
    private BazaDeDate bd;
    String email;

    JTextArea textArea;


    public ComandaBuyPremium(BazaDeDate bd, String email, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.textArea = textArea;
    }

    public void executa() {

        Utilizator u1 = null;
        for (Utilizator u : bd.getLista_useri())
            if (u.getEmail().equals(email)) {
                u1 = u;
                break;
            }


        if (u1 == null) {
            textArea.append("User with " + email + " doesn't exist\n");
        } else {
            if (u1.getCont("USD").getSold() < 100) {
                textArea.append("Insufficient amount in account for buying premium option\n");
            } else {
                u1.getCont("USD").retrage(100);
                u1.setTip(1);
            }
        }

    }

}