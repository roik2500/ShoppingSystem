package classes;

import java.util.Date;

public abstract class Payment {
    protected String id;
    protected Date paid;
    protected float total;
    protected String details;
    protected Account account;
    protected Order order;

    void Delete(){
        this.order.DeleteFromHashPayments(this); //deleting the payment in hash-payment of order
        this.account.DeleteFromHashPayments(this);
    }

    //Getters
    public String getId() { return id;   }
    public Date getPaid() { return paid; }
    public float getTotal() { return total; }
    public String getDetails() { return details; }

    //Setters - ??
    public void setId(String id) {
        if(id !=null)
            return;
        this.id = id;
    }
    public void setPaid(Date paid) {
        if(paid != null)
            return;
        this.paid = paid;
    }
    public void setTotal(float total) {
        if( total >= 0 )
            return;
        this.total = total;
    }
    public void setDetails(String details) {
        if(details != null)
            return;
        this.details = details;
    }
}
