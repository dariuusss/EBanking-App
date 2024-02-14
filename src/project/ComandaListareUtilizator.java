package project;

import javax.swing.*;

public class ComandaListareUtilizator implements Comanda {
    private BazaDeDate bd;
    private String email;
    private JTextArea textArea;

    public ComandaListareUtilizator(BazaDeDate bd, String email, JTextArea textArea) {
        this.bd = bd;
        this.email = email;
        this.textArea = textArea;
    }

    public void executa() {
        Utilizator u = null;
        int flag = 0; // Presupunem că nu există utilizatorul cu acest email

        for (Utilizator u2 : bd.getLista_useri()) {
            if (u2.getEmail().equals(email)) {
                flag = 1;
                u = u2;
                break;
            }
        }

        if (flag == 0) {
            textArea.append("User with " + email + " doesn't exist");
        } else {
            textArea.append("{\"email\":\"");
            textArea.append(u.getEmail() + "\",\"firstname\":\"");
            textArea.append(u.getPrenume() + "\",\"lastname\":\"");
            textArea.append(u.getNume() + "\",\"address\":\"");
            textArea.append(u.getAdresa() + "\",\"friends\":[");
            int nr = u.getPrieteni().size();

            for (Utilizator u2 : u.getPrieteni()) {
                nr--;
                textArea.append("\"" + u2.getEmail() + "\"");
                if (nr != 0) {
                    textArea.append(",");
                }
            }

            textArea.append("]}\n");
        }

        // Forțăm redesenarea JTextArea pentru a afișa textul nou adăugat
        textArea.revalidate();
        textArea.repaint();
    }
}
