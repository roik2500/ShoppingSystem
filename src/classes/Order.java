package classes;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Order {
    private String number;
    private Date ordered;
    private Date shipped;
    private Address ship_to;
    private OrderStatus status;
    private float total;
    private Account account;
    private HashMap<String,Payment> hash_Payment;
    private ArrayList<LineItem> list_LineItem;
    private boolean hasAccount;

    public Order(String number, Date ordered, Date shipped, Address ship_to, OrderStatus status, float total) {
        this.number = number;
        this.ordered = ordered;
        this.shipped = shipped;
        this.ship_to = ship_to;
        this.status = status;
        this.total = total;
        hash_Payment= new HashMap<String, Payment>();
        list_LineItem=new ArrayList<LineItem>();
        hasAccount=false;
    }

    public Order() {
        hash_Payment= new HashMap<String, Payment>();
        list_LineItem=new ArrayList<LineItem>();
        hasAccount=false;
    }
    public void UpdateHashPayments(Payment payment)
    {
        hash_Payment.put(payment.getId(),payment);
    }

    public void UpdateListLineItems(LineItem lineItem)
    {
        list_LineItem.add(lineItem);
    }


    public void DeleteFromHashPayments(Payment payment)
    {
        hash_Payment.remove(payment.getId());
    }

    public void DeleteListLineItems(LineItem lineItem)
    {
        list_LineItem.remove(lineItem);
    }

    public void Delete(){
        for (Payment p:hash_Payment.values())
            p.Delete();
        hash_Payment=null;
        for (LineItem l:list_LineItem)
            l.Delete();
        list_LineItem=null;
        account.DeleteFromHashOrders(this);

    }
    /*public void print(){
        System.out.println("object name: Order, id:" + number );
    }
    public void printinfo(){
        System.out.println("number:" + number );
        System.out.println("ordered:" + ordered );
        System.out.println("shipped:" + shipped );
        System.out.println("ship_to:" + ship_to );
        System.out.println("status:" + status );
        System.out.println("total:" + total );
        System.out.println("connected: account, LineItem, payment" );
    }*/

    @Override
    public String toString() {
        return "Order";
    }

    public void setAccount(Account account) {
        if(this.account==null) {
            this.account = account;
            hasAccount=true;
        }
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public void setShip_to(Address ship_to) {
        this.ship_to = ship_to;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNumber() {
        return number;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Account getAccount() {
        return account;
    }

    public HashMap<String, Payment> getHash_Payment() {
        return hash_Payment;
    }

    public ArrayList<LineItem> getList_LineItem() {
        return list_LineItem;
    }

    public boolean HasAccount() {
        return hasAccount;
    }

    public Date getShipped() {
        return shipped;
    }

    public Address getShip_to() {
        return ship_to;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public float getTotal() {
        return total;
    }
}
