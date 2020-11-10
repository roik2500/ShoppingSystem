package classes;

import java.util.Date;

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

    public void print(){
        System.out.println("quantity: " + quantity + "price:" + price);
    }

    public void printinfo(){
        System.out.println("quantity:" + quantity );
        System.out.println("price:" + price);
        System.out.println("Object connecting: ");
        if(this.order != null)
            System.out.println(order);
        if(this.shoppingCart!=null)
            System.out.println(shoppingCart);
        if(this.product!=null)
            System.out.println(product);

    }

    @Override
    public String toString() {
        return "LineItem";
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
