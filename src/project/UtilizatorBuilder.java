package project;

public class UtilizatorBuilder {
    private Utilizator utilizator = new Utilizator();

    public Utilizator build() {
        return utilizator;
    }

    public UtilizatorBuilder cuEmail(String email) {
        utilizator.setEmail(email);
        return this;
    }

    public UtilizatorBuilder cuNume(String nume) {
        utilizator.setNume(nume);
        return this;
    }

    public UtilizatorBuilder cuPrenume(String prenume) {
        utilizator.setPrenume(prenume);
        return this;
    }

    public UtilizatorBuilder cuAdresa(String adresa) {
        utilizator.setAdresa(adresa);
        return this;
    }

    public UtilizatorBuilder cuTip(int tip) {
        utilizator.setTip(0);
        return this;
    }


}