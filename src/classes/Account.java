package classes;

import java.util.Date;
import java.util.HashMap;

public class Account {
    private String id;
    private String billing_address;
    private boolean is_closed;
    private Date open;
    private Date closed;
    private int balanced;
    private Customer customer;
    private ShoppingCart shoppingCart;
    private HashMap<String,Order> hash_Order;
    private HashMap<String,Payment> hash_Payment;

    public Account(String id, String billing_address, boolean is_closed, Date open, Date closed, int balanced) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balanced = balanced;
        hash_Order = new HashMap<String,Order>();
        hash_Payment = new HashMap<String,Payment>();
    }

    public Account() {
        hash_Order = new HashMap<String,Order>();
        hash_Payment = new HashMap<String,Payment>();
    }

    public void UpdateHashOrders(Order order)
    {
        hash_Order.put(order.getNumber(),order);
    }

    public void UpdateHashPayments(Payment payment)
    {
        hash_Payment.put(payment.getId(),payment);
    }
    public void DeleteFromHashOrders(Order order)
    {
        hash_Order.remove(order.getNumber());
    }


    public void DeleteFromHashPayments(Payment payment)
    {
        hash_Payment.remove(payment.getId());
    }

    public void setCustomer(Customer customer){
        if(this.customer==null)
            this.customer=customer;
    }
    public  void setShoppingCart(ShoppingCart shoppingCart){
        if(this.shoppingCart==null)
            this.shoppingCart=shoppingCart;
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


    public void print(){
        System.out.println("object name: Account, id:" + id );
    }
    public void printinfo(){
        System.out.println("id:" + id );
        System.out.println("billing_address:" + billing_address );
        System.out.println("is_closed:" + is_closed );
        System.out.println("open:" + open );
        System.out.println("closed:" + closed );
        System.out.println("balanced:" + balanced );
        System.out.println("connected: shoppingCart, order, payment" );
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
