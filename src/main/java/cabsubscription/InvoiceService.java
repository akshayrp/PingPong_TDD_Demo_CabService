package cabsubscription;

import java.util.List;

public class InvoiceService
{
   private static final double MIN_DISTANCE_FARE = 10.0;
   private static final double MIN_TRAVEL_TIME = 5.0;
   private static final double COST_PER_TIME = 1.0;
   private static final double MIN_PREMIUM_RIDE_DISTANCE_FARE = 20.0;
   private static final double COST_PER_TIME_PREMIUM_RIDE = 2.0;
   private static final double MIN_TRAVEL_TIME_PREMIUM_RIDE = 10.0;

   RideRepository rideRepository;

   public InvoiceService()
   {
      this.rideRepository = new RideRepository();
   }

   public Double calculateFare(double distance, double time, RideType rideType)
   {
      if (rideType.equals(RideType.PREMIUM))
      {
         Double fare = MIN_PREMIUM_RIDE_DISTANCE_FARE * distance + time * COST_PER_TIME_PREMIUM_RIDE;
         if (fare < 5)
            return MIN_TRAVEL_TIME_PREMIUM_RIDE;
         return fare;
      }
      else
      {
         Double fare = MIN_DISTANCE_FARE * distance + time * COST_PER_TIME;
         if (fare < 5)
            return MIN_TRAVEL_TIME;
         return fare;
      }
   }

   public InvoiceSummary calculateFareForMultipleRide(List<Ride> listOfAllRides)
   {
      double totalFare = 0;
      for (Ride rides : listOfAllRides)
      {
         totalFare += this.calculateFare(rides.distance, rides.time, rides.ridetype);
      }
      return new InvoiceSummary(listOfAllRides.size(), totalFare);
   }

   public void addRide(String userId, Ride[] ride)
   {
      rideRepository.addRide(userId, ride);
   }

   public InvoiceSummary getInvoiceSummary(String userId)
   {
      return this.calculateFareForMultipleRide(rideRepository.getRides(userId));
   }
}
