package classes;

import java.util.HashMap;

public class Supplier {

    private String id;
    private String name;
    private HashMap<String, Product> hashProducts;

    public Supplier(String id, String name) {
        this.id = id;
        this.name = name;
        this.hashProducts = new HashMap<String, Product>();
    }

    //setters and getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Product> getHashProducts() {
        return hashProducts;
    }

    public void setHashProducts(String id, Product product) {
        this.hashProducts.put(id, product);
    }

    //delete functions
    public void DeleteFromHashProduct(String id)
    {
        hashProducts.remove(id);
    }

    public void Delete(){
       for (Product p:hashProducts.values())
           p.setPremiumAccount(null);
       hashProducts.clear();
    }

    //prints
    @Override
    public String toString() {
        return "Supplier";
    }

    public void print(){
        System.out.println("Object's name: " + this.name + "and object's id:" + this.id);
    }

    public void printInfo(){
        System.out.println("Object's name: " + this.name );
        System.out.println("and object's id:" + this.id);
        if(!this.hashProducts.isEmpty())
            System.out.println("Object connecting: Product");
        else
            System.out.println("Object connecting: no body");
    }

}
