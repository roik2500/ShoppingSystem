package classes;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    Date created;
    Account account;
    WebUser webUser;
    ArrayList<LineItem> list_LineItem;

    public ShoppingCart(Account account,WebUser webUser,Date created) {
        this.account=account;
        this.webUser=webUser;
        this.created = created;
        list_LineItem=new ArrayList<LineItem>();
    }
    public void UpdateListLineItem(LineItem lineItem)
    {
        list_LineItem.add(lineItem);
    }
    public void DeleteListLineItem(LineItem lineItem)
    {
        list_LineItem.remove(lineItem);
    }
    public void Delete()
    {
        for (LineItem l:list_LineItem)
            l.Delete();
        list_LineItem=null;
        if(webUser!=null)
            webUser.setShoppingCart(null);
        account.Delete();
        account=null;
    }
}
