package classes;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;
import enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Order {
    String number;
    Date ordered;
    Date shipped;
    Address ship_to;
    OrderStatus status;
    float total;
    Account account;
    HashMap<String,Payment> hash_Payment;
    ArrayList<LineItem> list_LineItem;

    public Order(String number,Account account) {
        this.number = number;
        this.account=account;
        hash_Payment= new HashMap<String, Payment>();
        list_LineItem=new ArrayList<LineItem>();
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
        account.DeleteFromHashOrders(number);

    }
}
