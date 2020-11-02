package classes;

public class ImmediatePayment extends Payment {
    private Boolean phoneConfirmation;

    public ImmediatePayment(Account account, Order order, Boolean phoneConfirmation) {
        this.account = account;
        this.order = order;
        this.phoneConfirmation = phoneConfirmation;
    }
}
