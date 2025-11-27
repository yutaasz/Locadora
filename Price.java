package Locadora;

public abstract class Price {

    public abstract int getPriceCode();

    // Agora vira abstrato
    public abstract double getCharge(int daysRented);

    // FrequentRenterPoints continua igual
    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        else
            return 1;
    }
}
