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
        this.account = null;
        this.order = null;
    }

    //Getters
    public String getId() { return id;   }
    public Date getPaid() { return paid; }
    public float getTotal() { return total; }
    public String getDetails() { return details; }

    //Setters - ??
    public void setId(String id) {
        if(id !=null)
            this.id =id;
    }
    public void setPaid(Date paid) {
        if(paid != null)
            this.paid = paid;
    }
    public void setTotal(float total) {
        if( total >= 0 )
            this.total = total;
    }
    public void setDetails(String details) {
        if(details != null)
            this.details = details;
    }

    public void printinfo()
    {
        System.out.println("Payment's id: " + id  );
        System.out.println(", it's date: " + paid);
        System.out.println(", total pay: " + total);
        System.out.println(", pay's details:" + details);
        System.out.println("Object connecting: ");
        if(this.order != null)
            System.out.println(order);
        if(this.account!=null)
            System.out.println(account);

      /*  account.printinfo();
        protected Account account;
        System.out.println();
        protected Order order
        System.out.println(); */
    }
}
