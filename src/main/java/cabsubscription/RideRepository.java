package cabsubscription;

import java.util.*;

public class RideRepository
{
   Map<String, List<Ride>> userRides = null;

   public RideRepository()
   {
      this.userRides = new HashMap<>();
   }

   public void addRide(String userId, Ride[] ride)
   {
      List<Ride> rideList = new ArrayList<>(Arrays.asList(ride));
      List<Ride> ridesFromRepoForDefinedUserId = this.userRides.get(userId);
      if (ridesFromRepoForDefinedUserId != null)
      {
         rideList.addAll(ridesFromRepoForDefinedUserId);
      }
      this.userRides.put(userId, rideList);
   }

   public List<Ride> getRides(String userId)
   {
      return this.userRides.get(userId);
   }
}
