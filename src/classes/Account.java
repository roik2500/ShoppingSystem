package classes;

import java.util.Date;
import java.util.HashMap;

public class Account {
    String id;
    String billing_address;
    boolean is_closed;
    Date open;
    Date closed;
    int balanced;
    Customer customer;
    ShoppingCart shoppingCart;
    HashMap<String,Order> hash_Order;
    HashMap<String,Payment> hash_Payment;

    public Account(String id,Customer customer) {
        this.id = id;
        this.shoppingCart=new ShoppingCart(this,new WebUser(id,customer), new Date() );
        this.customer=customer;
        hash_Order = new HashMap<String,Order>();
        hash_Payment = new HashMap<String,Payment>();
    }

    public void UpdateHashOrders(String id,Order order)
    {
        hash_Order.put(id,order);
    }

    public void UpdateHashPayments(Payment payment)
    {
        hash_Payment.put(payment.getId(),payment);
    }
    public void DeleteFromHashOrders(String id)
    {
        hash_Order.remove(id);
    }


    public void DeleteFromHashPayments(Payment payment)
    {
        hash_Payment.remove(payment.getId());
    }


    public void Delete(){
        for (Payment p:hash_Payment.values())
            p.Delete();
        for (Order o:hash_Order.values())
            o.Delete();
        shoppingCart=null;
        customer.Delete();
        customer=null;
    }

    public String getId() {
        return id;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public Date getOpen() {
        return open;
    }

    public Date getClosed() {
        return closed;
    }

    public int getBalanced() {
        return balanced;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public void setBalanced(int balanced) {
        this.balanced = balanced;
    }
}
