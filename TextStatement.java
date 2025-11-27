package Locadora;

import java.util.Enumeration;

public class TextStatement extends Statement {

    public String value(Customer aCustomer) {
        Enumeration rentals = aCustomer.getRentals();

        String result = header(aCustomer);

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += eachRental(each);
        }

        result += footer(aCustomer);

        return result;
    }

    protected String header(Customer aCustomer) {
        return "Rental Record for " + aCustomer.getName() + "\n";
    }

    protected String eachRental(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t" +
                rental.getCharge() + "\n";
    }

    protected String footer(Customer aCustomer) {
        return "Amount owed is " + aCustomer.getTotalCharge() + "\n"
                + "You earned " + aCustomer.getTotalFrequentRenterPoints()
                + " frequent renter points";
    }
}


