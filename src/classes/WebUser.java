package classes;

import enums.UseState;

public class WebUser {
    private String login_id;
    private String password;

    private UseState state;
    private Customer customer;
    private ShoppingCart shoppingCart;

    public WebUser(String login_id,int PremiumOrRegular) {
        this.login_id = login_id;
        this.password = null; //we will update this member after it
        this.state = UseState.New;
        this.customer = new Customer(login_id);
        this.shoppingCart=null;
    }

    //The member of ShoppingItem could initialize with 0 interfaces
    //after the opening of account and generating of shoppingcart we will update the member
    public void setShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart!=null)
            this.shoppingCart = shoppingCart;
    }

    //After the delete of webuser,we have to delete the interface of shoppingcart because only 1 interface of web user is allowed
    public void Delete(){
        if(shoppingCart!=null)
            shoppingCart.Delete();
        shoppingCart=null;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setState(UseState state) {
        this.state = state;
    }

}
