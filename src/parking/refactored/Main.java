package parking.refactored;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = new FileLogger("parking.log");
        ParkingService garage = new ParkingService(logger, new ReceiptAndReportFormat());

        Vehicle car   = new Car("12345-A-6");
        Vehicle bike  = new Motorbike("67890-B-1");
        Vehicle truck = new Truck("24680-D-8");

        RefundablePaymentMethod card = new CardPayment("4242");
        PaymentMethod cash = new CashPayment();

        garage.checkout(car, 3, card);
        garage.checkout(bike, 2, cash);
        garage.checkout(truck, 4, card);

        garage.refundAtDesk(bike, 2);
        garage.cancel(truck, 4, card);

        System.out.println(garage.dailyReport());
    }
}
