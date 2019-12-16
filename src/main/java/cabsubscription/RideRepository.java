package cabsubscription;

import cabsubscription.Ride;

import java.util.*;

public class RideRepository
{
   Map<String, ArrayList<Ride>> userRides = null;

   public RideRepository()
   {
      this.userRides = new HashMap<>();
   }

   public void addRide(String userId, Ride[] ride)
   {
      this.userRides.put(userId, new ArrayList<>(Arrays.asList(ride)));
   }

   public Ride[] getRides(String userId)
   {
      return this.userRides.get(userId).toArray(new Ride[0]);
   }
}
