package classes;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingCart {
    private Date created;
    private Account account;
    private WebUser webUser;
    private ArrayList<LineItem> list_LineItem;
    private boolean hasWebUser;
    private boolean hasAccount;
    public ShoppingCart() {

        list_LineItem = new ArrayList<LineItem>();
        hasWebUser=false;
        hasAccount=false;
    }

    public ShoppingCart(Date created) {
        this.created = created;
        list_LineItem = new ArrayList<LineItem>();
        hasWebUser=false;
        hasAccount=false;
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

   /* public void print(){
        System.out.println("object name: ShoppingCart, id:" + created );
    }
    public void printinfo(){
        System.out.println("created:" + created );
        System.out.println("connected: account, webuser, LineItem" );
    }*/

    @Override
    public String toString() {
        return "ShoppingCart";
    }

    public Date getCreated() {
        return created;
    }

    public Account getAccount() {
        return account;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public boolean HasWebUser() {
        return hasWebUser;
    }

    public boolean HasAccount() {
        return hasAccount;
    }

    public ArrayList<LineItem> getList_LineItem() {
        return list_LineItem;
    }



    public void setCreated(Date created) {
        this.created = created;
    }

    public void setAccount(Account account) {
        if(this.account==null) {
            this.account = account;
            hasAccount=true;
        }
    }

    public void setWebUser(WebUser webUser) {
        if(this.webUser==null) {
            this.webUser = webUser;
            hasWebUser=true;
        }
    }

    public void setList_LineItem(ArrayList<LineItem> list_LineItem) {
        this.list_LineItem = list_LineItem;
    }
}
