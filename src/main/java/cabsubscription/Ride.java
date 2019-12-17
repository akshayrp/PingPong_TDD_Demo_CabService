package cabsubscription;

public class Ride
{
   double distance;
   double time;
   RideType ridetype;

   public Ride(double distance, int time, RideType rideType)
   {
      this.distance = distance;
      this.time = time;
      this.ridetype = rideType;
   }
}
