package project;


public class ComandaAlimentareCont implements Comanda {

    private BazaDeDate bd;
    private String email;
    private String valuta;
    private double suma;

    public ComandaAlimentareCont(BazaDeDate bd, String email, String valuta, double suma) {
        this.bd = bd;
        this.email = email;
        this.valuta = valuta;
        this.suma = suma;
    }

    public void executa() {
        Utilizator u = null;
        for (Utilizator utilizator : bd.getLista_useri())
            if (utilizator.getEmail().equals(email)) {
                u = utilizator;
                break;
            }

        u.getCont(valuta).alimenteaza_cont(suma);
    }

}