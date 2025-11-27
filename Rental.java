package Locadora;

class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    // já deve existir no seu código
    public double getCharge() {
        double result = 0;

        switch (movie.getPriceCode()) {
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

    // MÉTODO QUE VOCÊ ACABOU DE EXTRair e MOVER PRA CÁ
    public int getFrequentRenterPoints() {
        // bonus se for lançamento e alugou por mais de 1 dia
        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
