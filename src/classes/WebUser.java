package classes;

import enums.UseState;

public class WebUser {


    private String login_id;
    private String password;
    private UseState state;
    private Customer customer;
    private ShoppingCart shoppingCart;

    public WebUser(String login_id, String password) {
        this.login_id = login_id;
        this.password = password; //we will update this member after it
        this.state = UseState.New;
        this.customer = null;
        this.shoppingCart=null;
    }

    public void printinfo(){
        System.out.println("ID:"+login_id);
        System.out.println("Password:"+password);
        System.out.println("State:"+state);
        if(shoppingCart!=null){ System.out.println(shoppingCart); }
        if(customer!=null){ System.out.println(customer);}
    }

    //After the delete of webuser,we have to delete the interface of shoppingcart because only 1 interface of web user is allowed
    public void Delete(){
        if(shoppingCart!=null)
            shoppingCart.Delete();
        shoppingCart=null;
    }

    //The member of ShoppingItem could initialize with 0 interfaces
    //after the opening of account and generating of shoppingcart we will update the member
    public void setShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart!=null)
            this.shoppingCart = shoppingCart;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setState(UseState state) {
        this.state = state;
    }
    public void setLogin_id(String login_id) { this.login_id = login_id; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "WebUser";
    }

    public String getLogin_id() { return login_id; }
    public String getPassword() { return password; }
    public UseState getState() { return state; }
    public Customer getCustomer() { return customer; }
    public ShoppingCart getShoppingCart() { return shoppingCart; }
}
