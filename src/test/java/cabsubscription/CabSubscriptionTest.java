package cabsubscription;

import org.junit.Assert;
import org.junit.Test;

public class CabSubscriptionTest
{
   @Test
   public void givenDistanceAndTime_ShouldReturnTotalFair()
   {
      InvoiceService invoiceService = new InvoiceService();
      Double distance = 2.0;
      double time = 5.0;
      double value = invoiceService.calculateFare(distance, time,RideType.PREMIUM);
      Assert.assertEquals(50, value, 0.0);
   }

   @Test
   public void givenMinimumDistanceAndTime_ShouldReturnMinimumAmount()
   {
      InvoiceService invoiceService = new InvoiceService();
      Double distance = 0.1;
      int time = 1;
      double value = invoiceService.calculateFare(distance, time,RideType.NORMAL);
      Assert.assertEquals(5.0, value, 0.0);
   }

   @Test
   public void givenMultipleRide_ShouldReturnInvoice()
   {
      InvoiceService invoiceService = new InvoiceService();
      Ride[] ride = {new Ride(2.0, 5,RideType.NORMAL),
            new Ride(0.1, 1,RideType.NORMAL)
      };
      InvoiceSummary summary = invoiceService.addRide(ride);
      InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
      Assert.assertEquals(expectedSummary, summary);
   }

   @Test
   public void givenUserIdRidesAndRideType_ShouldCalculateFareBasedOnRideType()
   {
      InvoiceService invoiceService = new InvoiceService();
      String userId = "a@b";
      Ride[] ride = {new Ride(2.0, 5,RideType.PREMIUM),
            new Ride(0.1, 1,RideType.NORMAL),
            new Ride(0.1, 1,RideType.NORMAL)
      };
      invoiceService.addRide(userId, ride);
      InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
      InvoiceSummary expectedSummary = new InvoiceSummary(3, 60);
      Assert.assertEquals(expectedSummary, summary);
   }

   @Test
   public void givenMinimumDistanceAndTimeForPremiumRide_ShouldReturnMinimumAmount()
   {
      InvoiceService invoiceService = new InvoiceService();
      Double distance = 0.1;
      int time = 1;
      double value = invoiceService.calculateFare(distance, time,RideType.PREMIUM);
      Assert.assertEquals(10, value, 0.0);
   }
}

