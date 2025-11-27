package Locadora;

import java.util.Enumeration;

public class HtmlStatement extends Statement {

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
        return "<H1>Rentals for <EM>" + aCustomer.getName() + "</EM></H1><P>\n";
    }

    protected String eachRental(Rental rental) {
        return rental.getMovie().getTitle() + ": " +
                rental.getCharge() + "<BR>\n";
    }

    protected String footer(Customer aCustomer) {
        return "<P>You owe <EM>" + aCustomer.getTotalCharge() + "</EM><P>\n"
                + "On this rental you earned <EM>"
                + aCustomer.getTotalFrequentRenterPoints()
                + "</EM> frequent renter points<P>";
    }
}

