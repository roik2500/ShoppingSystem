package classes;

import enums.UseState;

public class WebUser {
    private String login_id;
    private String password;
    private UseState state;
    private Customer customer;
    private ShoppingCart shoppingCart;

    public WebUser(String login_id) {
        this.login_id = login_id;
        this.password = null; //we will update this member after it
        this.state = UseState.New;
        this.customer = new Customer(login_id);
        this.shoppingCart=null;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        if (shoppingCart!=null)
            this.shoppingCart = shoppingCart;
    }

    public void Delete(){
        if(shoppingCart!=null)
            shoppingCart.Delete();
        shoppingCart=null;
    }



}
