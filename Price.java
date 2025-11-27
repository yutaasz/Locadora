package Locadora;

public abstract class Price {

    public abstract int getPriceCode();

    // Passo 4: método movido de Movie para Price
    public double getCharge(int daysRented) {
        double result = 0;

        switch (getPriceCode()) {

            case Movie.REGULAR:
                result += 2;
                if (daysRented > 2)
                    result += (daysRented - 2) * 1.5;
                break;

            case Movie.NEW_RELEASE:
                result += daysRented * 3;
                break;

            case Movie.CHILDRENS:
                result += 1.5;
                if (daysRented > 3)
                    result += (daysRented - 3) * 1.5;
                break;
        }

        return result;
    }

    // Passo 2 encaminhado pro Price também, caso já tenha movido
    public int getFrequentRenterPoints(int daysRented) {
        if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        else
            return 1;
    }
}
