package parking.refactored;

import java.io.IOException;

public class ParkingServiceTest {

    // fake logger: does nothing, so no file is created
    static class FakeLogger implements Logger {
        public void log(String line) { }
    }

    public static void main(String[] args) throws IOException {
        Vehicle car   = new Car("12345-A-6");
        Vehicle bike  = new Motorbike("67890-B-1");
        Vehicle truck = new Truck("24680-D-8");
        System.out.println("Car fee (3 h): " + car.getFee(3));
        System.out.println("Motorbike fee (2 h): " + bike.getFee(2));
        System.out.println("Truck fee (4 h): " + truck.getFee(4));
        ParkingService service = new ParkingService(new FakeLogger(), new ReceiptAndReportFormat());
        RefundablePaymentMethod card = new CardPayment("4242");
        PaymentMethod cash = new CashPayment();
        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);
        service.refundAtDesk(bike, 2);
        service.cancel(truck, 4, card);
        System.out.println(service.dailyReport());
    }
}
