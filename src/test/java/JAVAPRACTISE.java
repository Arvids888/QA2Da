import org.junit.jupiter.api.Test;

public class JAVAPRACTISE { //Nazavanija klase s bolsoi bukvi

    @Test
    public void firstJavaCode() {
        Double distance = 135.7;
        Double fuelAmount = 20.00;

        double ticketMonthlyPrice = 50.00;

        int ridesCount = 80;

        int zojasRidesCount = 2;

        double consumption = fuelAmount / distance * 100;

        double pricePerRide = calculatePricePerRide(ridesCount);

        double pricePerRideForZoja = calculatePricePerRide (zojasRidesCount);

        System.out.println(" Current fuel consumtion is " + consumption +
        " but using Trolley it cost " + pricePerRide + " per month " +
                " and now Zoja spend " + pricePerRideForZoja + " per ride ");

        int a = 15;
        int b = 10;

        String c = "15";
        String d = "10";

        System.out.println(a + b);
        System.out.println(c + d);
    }

    private double calculatePricePerRide(int ridesCount) {
      final double PRICE = 50.00;

      double pricePerRide = PRICE / ridesCount;
      return pricePerRide;
    }


}
