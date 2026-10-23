package parking.refactored;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParkingService {
    private final List<String> receipts = new ArrayList<>();
    private final Logger logger;
    private final ReceiptAndReportFormat formatter;
    private double total;

    public ParkingService(Logger logger, ReceiptAndReportFormat formatter) {
        this.logger = logger;
        this.formatter = formatter;
    }

    public void checkout(Vehicle vehicle, int hours, PaymentMethod method)
            throws IOException {
        double amount = vehicle.getFee(hours);
        method.pay(amount);
        total += amount;

        String receipt = formatter.formatReceipt(vehicle, hours, amount, method);
        receipts.add(receipt);
        logger.log(receipt);
    }

    public void cancel(Vehicle vehicle, int hours, RefundablePaymentMethod method) {
        double amount = vehicle.getFee(hours);
        method.refund(amount);
        total -= amount;
    }

    // non-refundable payments (cash): the customer is paid back at the desk
    public void refundAtDesk(Vehicle vehicle, int hours) {
        double amount = vehicle.getFee(hours);
        System.out.println("Refund " + amount + " MAD at the desk for "
                + vehicle.getPlate());
        total -= amount;
    }

    public String dailyReport() {
        return formatter.formatDailyReport(receipts, total);
    }
}
