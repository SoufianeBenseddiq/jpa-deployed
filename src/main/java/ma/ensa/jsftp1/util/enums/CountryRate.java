package ma.ensa.jsftp1.util.enums;

public enum CountryRate {
    US(0.1071),
    ES(0.0922),
    FR(0.0922),
    DE(0.0922),
    IT(0.0922),
    GB(0.0798),
    CN(0.7404),
    MA(1.0);

    private final double rate;

    CountryRate(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public static double getPourcentage(String countryCode) {
        try {
            return valueOf(countryCode.toUpperCase()).getRate();
        } catch (IllegalArgumentException | NullPointerException e) {
            return 1.0;
        }
    }
}

