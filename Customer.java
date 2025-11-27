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

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" +
                    String.valueOf(each.getCharge()) + "\n";
        }

        // footer
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
                " frequent renter points";

        return result;
    }

    // NOVO: substitui totalAmount
    private double getTotalCharge() {
        double result = 0;
        Enumeration enumRentals = rentals.elements();

        while (enumRentals.hasMoreElements()) {
            Rental each = (Rental) enumRentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

    // NOVO: substitui frequentRenterPoints
    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration enumRentals = rentals.elements();

        while (enumRentals.hasMoreElements()) {
            Rental each = (Rental) enumRentals.nextElement();
            result += each.getFrequentRenterPoints();
        }

        return result;
    }
}


