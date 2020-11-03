package classes;
import java.util.Date;

public class ImmediatePayment extends Payment {
    private Boolean phoneConfirmation;


    public ImmediatePayment(Account account, Order order, Boolean phoneConfirmation,
                            String id, Date paid, float total, String details) {
        this.account = account;
        this.order = order;
        this.phoneConfirmation = phoneConfirmation;
        this.id = id;
        this.paid = paid;
        this.total = total;
        this.details = details;
    }
}
