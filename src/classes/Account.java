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
    private boolean hasCustomer;
    private boolean hasShoppingCart;

    public Account(String id, String billing_address,  Date open, int balanced) {
        this.id = id;
        this.billing_address = billing_address;
        this.is_closed = true;
        this.open = open;
        this.closed = null;
        this.balanced = balanced;
        hash_Order = new HashMap<String,Order>();
        hash_Payment = new HashMap<String,Payment>();
        hasCustomer=false;
        hasShoppingCart=false;
    }

    public Account() {
        hash_Order = new HashMap<String,Order>();
        hash_Payment = new HashMap<String,Payment>();
        hasCustomer=false;
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

    public void setCustomer(Customer customer){
        if(this.customer==null) {
            this.customer = customer;
            hasCustomer=true;
        }
    }
    public  void setShoppingCart(ShoppingCart shoppingCart){
        if(this.shoppingCart==null) {
            this.shoppingCart = shoppingCart;
            hasShoppingCart=true;
        }
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


    /*public void print(){
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
    }*/

    @Override
    public String toString() {
        return "Account";
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

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public boolean HasCustomer() {
        return hasCustomer;
    }

    public boolean HasShoppingCart() {
        return hasShoppingCart;
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
