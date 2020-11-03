package classes;
import java.util.Date;

public class DelayedPayment extends Payment {
    private Date paymentDate;

    public DelayedPayment(Account account, Order order, Date paymentDate,
                          String id, Date paid, float total, String details) {
        this.account = account;
        this.order = order;
        this.paymentDate = paymentDate;
        this.id = id;
        this.paid = paid;
        this.total = total;
        this.details = details;
    }
}
