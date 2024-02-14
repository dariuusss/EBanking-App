package project;

import javax.swing.*;

public class ComandaListarePortofoliuUtilizator implements Comanda {
    private BazaDeDate bd;
    private String email;

    JTextArea textArea;

    public ComandaListarePortofoliuUtilizator(BazaDeDate bd, String email,JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.textArea = textArea;
    }

    public void executa() {
        Utilizator u = null;
        int flag = 0; //nu exista
        for (Utilizator u2 : bd.getLista_useri())
            if (u2.getEmail().equals(email)) {
                u = u2;
                flag = 1;
                break;
            }

        if (flag == 0) {
            textArea.append("User with " + email + " doesn't exist\n");
        } else {
            int i;

            textArea.append("{\"stocks\":[");
            int nr = u.getNr_actiuni();
            int prev = 0;
            if (u.getNr_actiuni() != 0) {
                for (Actiuni a2 : u.getActiuni()) {
                    if (a2.nr > 0) {
                        if (prev == 1) System.out.print(",");
                        prev = 1;
                        textArea.append("{\"stockName\":\"");
                        textArea.append(a2.nume_companie);
                        textArea.append("\",\"amount\":");
                        textArea.append(a2.nr + "}");
                    }
                }
            }
            //de aici afisezi conturile


            textArea.append("],\"accounts\":[");
            nr = u.getConturi().size();

            for (Cont cont : u.getConturi()) {
                textArea.append("{\"currencyName\":\"" + cont.getValuta() + "\"," + "\"amount\":");
                textArea.append("\"" + Double.toString(u.getCont(cont.getValuta()).getSold()));
                textArea.append("\"}");
                nr--;
                if (nr > 0) textArea.append(",");
            }


            textArea.append("]}" + "\n");
        }
    }
}