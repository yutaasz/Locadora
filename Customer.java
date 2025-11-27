package Locadora;

import java.util.Enumeration;
import java.util.Vector;

class Customer {

    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration enumRentals = rentals.elements();
        String result = "Rental Record for " + getName() + "\n";

        while (enumRentals.hasMoreElements()) {
            Rental each = (Rental) enumRentals.nextElement();
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";

        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration enumRentals = rentals.elements();

        while (enumRentals.hasMoreElements()) {
            Rental each = (Rental) enumRentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration enumRentals = rentals.elements();

        while (enumRentals.hasMoreElements()) {
            Rental each = (Rental) enumRentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }

    // NOVA FEATURE: HTML STATEMENT
    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getMovie().getTitle() + ": " +
                    String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" +
                String.valueOf(getTotalFrequentRenterPoints()) +
                "</EM> frequent renter points<P>";

        return result;
    }
}



