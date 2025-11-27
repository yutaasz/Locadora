package Locadora;

public abstract class Price {

   public abstract int getPriceCode();
   public abstract double getCharge(int daysRented);

   // *** Novo método movido do Movie ***
   public int getFrequentRenterPoints(int daysRented) {
      // Lógica original:
      // Se o filme for NEW_RELEASE e alugado por mais de 1 dia → retorna 2
      // Senão → retorna 1
      if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
         return 2;
      }
      return 1;
   }
}

