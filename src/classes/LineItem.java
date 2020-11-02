package classes;

import java.util.Date;
import java.util.HashMap;

public class LineItem {
    private int quantity;
    private int  price;
    private Order order;
    private ShoppingCart shoppingCart;
    private Product product;

    public LineItem(int quantity, int price, Order order, ShoppingCart shoppingCart, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        this.shoppingCart = shoppingCart;
        this.product = product;
    }

    public void Delete(){
        shoppingCart.DeleteListLineItem(this);
        product.DeleteListLineItem(this);
        order.DeleteListLineItems(this);
        order=null;
        shoppingCart=null;
        product=null;

    }
}
