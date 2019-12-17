package cabsubscription;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RideRepositoryTest
{
   String userId = "a@b";

   @Test
   public void givenUserIdAndRides_ShouldAddDataToRepositoryAndGivesCount()
   {
      RideRepository rideRepository = new RideRepository();
      Ride[] ride = {new Ride(2.0, 5, RideType.PREMIUM),
            new Ride(0.1, 1, RideType.NORMAL),
            new Ride(0.1, 1, RideType.NORMAL)
      };
      rideRepository.addRide(userId, ride);
      List allRideForRideRepository = rideRepository.getRides(userId);
      int actualValue = allRideForRideRepository.size();
      Assert.assertEquals(3, actualValue);

   }

   @Test
   public void givenUserIdAndNullRides_ShouldReturnCountZero()
   {
      RideRepository rideRepository = new RideRepository();
      Ride[] ride = {};
      rideRepository.addRide(userId, ride);
      List allRideForRideRepository = rideRepository.getRides(userId);
      int actualValue = allRideForRideRepository.size();
      Assert.assertEquals(0, actualValue);
   }


   @Test
   public void givenUserIdAndMultipleRides_ShouldReturnExactCount()
   {
      RideRepository rideRepository = new RideRepository();
      Ride[] firstSetOfRides = {
            new Ride(2.0, 5, RideType.PREMIUM),
            new Ride(0.1, 1, RideType.NORMAL),
            new Ride(0.1, 1, RideType.NORMAL)
      };
      Ride[] secondSetOfRide = {
            new Ride(2.0, 5, RideType.PREMIUM),
            new Ride(0.1, 1, RideType.NORMAL),
            new Ride(0.1, 1, RideType.NORMAL)
      };

      rideRepository.addRide(userId, firstSetOfRides);
      rideRepository.addRide(userId, secondSetOfRide);
      List<Ride> allRidesFromRepository = rideRepository.getRides(userId);
      int actualValue = allRidesFromRepository.size();
      Assert.assertEquals(6, actualValue);
   }

   @Test
   public void givenMultipleUserIdAndRides_ShouldReturnExactCountOfDefinedUserId()
   {
      RideRepository rideRepository = new RideRepository();
      Ride[] firstSetOfRides = {
            new Ride(2.0, 5, RideType.PREMIUM),
            new Ride(0.1, 1, RideType.NORMAL),
            new Ride(0.1, 1, RideType.NORMAL)
      };
      Ride[] secondSetOfRide = {
            new Ride(2.0, 5, RideType.PREMIUM),
            new Ride(0.1, 1, RideType.NORMAL),
            new Ride(0.1, 1, RideType.NORMAL)
      };

      rideRepository.addRide("a@b", firstSetOfRides);

      rideRepository.addRide("b@a", secondSetOfRide);
      List<Ride> allRidesFromRepository = rideRepository.getRides("a@b");
      int actualValue = allRidesFromRepository.size();
      Assert.assertEquals(3, actualValue);
   }
}
