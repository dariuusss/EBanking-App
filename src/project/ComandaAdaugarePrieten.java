package project;


import javax.swing.*;

public class ComandaAdaugarePrieten implements Comanda {
    private BazaDeDate bd;
    private String emailUser;
    private String emailFriend;

    JTextArea textArea;

    public ComandaAdaugarePrieten(BazaDeDate bd, String emailUser, String emailFriend, JTextArea textArea) {
        this.bd = bd;
        this.emailUser = emailUser;
        this.emailFriend = emailFriend;
        this.textArea = textArea;
    }

    public void executa() {
        int i, j, flag = 0; //flag = 0 inseamna ca nu sunt prieteni
        Utilizator u1, u2;
        u1 = u2 = null;
        for (Utilizator u : bd.getLista_useri()) {

            if (u.getEmail().equals(emailUser)) u1 = u;
            if (u.getEmail().equals(emailFriend)) u2 = u;

            if (u1 != null && u2 != null) //i-am gasit pe amandoi
                break;
        }

        if (u1 == null) {
            textArea.append("User with " + emailUser + " doesn't exist\n");
        } else if(u2 == null) {
            textArea.append("User with " + emailFriend + " doesn't exist\n");
        } else {
            for (Utilizator u : u1.getPrieteni())
                if (u.getEmail().equals(emailFriend)) {
                    flag = 1; //aparent sunt prieteni
                    textArea.append("User with " + emailFriend + " is already a friend\n");
                    break;
                }


            if (flag == 0) {
                u1.getPrieteni().add(u2);
                u2.getPrieteni().add(u1);
            }

        }
    }
}