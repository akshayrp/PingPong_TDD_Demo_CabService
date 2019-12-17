package cabsubscription;

public class InvoiceSummary
{
   private final double totalRides;
   private final double totalFare;
   private final double averageFare;

   public InvoiceSummary(double numberOfRide, double totalFare)
   {
      this.totalRides = numberOfRide;
      this.totalFare = totalFare;
      this.averageFare = this.totalFare / this.totalRides;
   }

   @Override
   public boolean equals(Object o)
   {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      InvoiceSummary that = (InvoiceSummary) o;
      return Double.compare(that.totalRides, totalRides) == 0 &&
            Double.compare(that.totalFare, totalFare) == 0 &&
            Double.compare(that.averageFare, averageFare) == 0;
   }
}
