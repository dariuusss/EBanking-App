package project;

import javax.swing.*;

public class ComandaRecomandareActiuni implements Comanda {

    private BazaDeDate bd;

    JTextArea textArea;

    public ComandaRecomandareActiuni(BazaDeDate bd, JTextArea textArea) {
        this.bd = bd;
        this.textArea = textArea;
    }


    public void executa() {
        int nr_recom = 0, nr = 0;
        double medie_scurta, medie_lunga;
        Actiuni[] recomandari = new Actiuni[100];
        for (int y = 0; y < 100; y++)
            recomandari[y] = new Actiuni();

        int i, j;
        for (Actiuni a : bd.getLista_actiuni()) {

            medie_scurta = medie_lunga = 0;
            for (j = 5; j < 10; j++)
                medie_scurta += a.getValori().get(j);
            medie_scurta /= 5;
            for (j = 0; j < 10; j++)
                medie_lunga += a.getValori().get(j);
            medie_lunga /= 10;


            if (medie_scurta > medie_lunga) {
                a.setMedie_scurta(medie_scurta);
                a.setMedie_lunga(medie_lunga);
                a.setTip(1); //o introducem la recomandate
                recomandari[nr_recom++] = a;
            }


        }


        Actiuni aux;
        for (i = 0; i < nr_recom - 1; i++)
            for (j = i + 1; j < nr_recom; j++)
                if (recomandari[i].getMedie_scurta() > recomandari[j].getMedie_scurta()) {
                    aux = recomandari[i];
                    recomandari[i] = recomandari[j];
                    recomandari[j] = aux;
                }


        for (i = 0; i < nr_recom; i++) {
            if (nr != 0) textArea.append(",");
            nr++;
            if (i == 0) {
                textArea.append("{\"stocksToBuy\":");
                textArea.append("[");
            }
            textArea.append("\"" + recomandari[i].nume_companie + "\"");
        }
        textArea.append("]}" + "\n");

    }

}