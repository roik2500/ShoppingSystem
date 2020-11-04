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

    public void DeleteFromHashProduct(String id)
    {
        hashProducts.remove(id);
    }

    public void Delete(){
       for (Product p:hashProducts.values())
           p.setPremiumAccount(null);
       hashProducts.clear();
    }
}
