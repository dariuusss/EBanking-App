package project;

import javax.swing.*;

public class ComandaCreareUtilizator implements Comanda {
    private BazaDeDate bd;
    String email;
    String firstname, lastname;
    String address;

    JTextArea textArea;

    public ComandaCreareUtilizator(BazaDeDate bd, String email, String firstname, String lastname, String address,JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.textArea = textArea;
    }

    public void executa() {

        int i, flag = 1;
        for (Utilizator u : bd.getLista_useri())
            if (u.getEmail().equals(email)) {
                flag = 0;
                break;
            }

        if (flag == 1) { //e unic
            Utilizator user = new UtilizatorBuilder().cuEmail(email).cuNume(lastname).cuPrenume(firstname).cuAdresa(address).cuTip(0).build();
            bd.getLista_useri().add(user);
            for (Actiuni a : bd.getLista_actiuni()) {
                Actiuni b = new Actiuni();
                b.nume_companie = a.nume_companie;
                b.nr = 0;
                user.getActiuni().add(b);
            }

        } else {
            textArea.append("User with " + email + " already exists\n");
        }
    }
}