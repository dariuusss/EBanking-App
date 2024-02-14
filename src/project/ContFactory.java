package project;

public class ContFactory {
    public static Cont creaza_cont(final String valuta) {
        return switch (valuta) {
            case "EUR" -> new ContEUR();
            case "USD" -> new ContUSD();
            case "GBP" -> new ContGBP();
            case "JPY" -> new ContJPY();
            case "CAD" -> new ContCAD();
            default -> throw new IllegalStateException("Valuta inexistenta " + valuta);
        };
    }
}