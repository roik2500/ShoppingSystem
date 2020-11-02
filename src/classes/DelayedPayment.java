package classes;

import java.util.Date;

public class DelayedPayment extends Payment {
    private Date paymentDate;

    public DelayedPayment(Account account, Order order, Date paymentDate) {
        this.account = account;
        this.order = order;
        this.paymentDate = paymentDate;
    }
}
