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
    public void UpdateHashOrder(String id,Order order)
    {
        hash_Order.put(id,order);
    }

    public void UpdateHashPayment(String id,Payment payment)
    {
        hash_Payment.put(id,payment);
    }
    public void DeleteFromHashOrder(String id)
    {
        hash_Order.remove(id);
    }
    public void DeleteFromHashPayment(String id)
    {
        hash_Payment.remove(id);
    }
    public void Delete(){
        for (Payment p:hash_Payment.values())
            p.Delete();
        for (Order o:hash_Order.values())
            o.Delete();
        shoppingCart.Delete();
        shoppingCart=null;
        customer.Delete();
        customer=null;
    }
}
