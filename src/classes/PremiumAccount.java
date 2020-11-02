package classes;

import java.util.HashMap;

public class PremiumAccount extends Account {

    private HashMap<String,Product> hash_Product;

    public PremiumAccount(String id, Customer customer) {
        super(id, customer);
        hash_Product = new HashMap<String,Product>();
    }
    public void UpdateHashProduct(String id,Product product)
    {
        hash_Product.put(id,product);
    }

    public void DeleteFromHashProduct(String id)
    {
        hash_Product.remove(id);
    }


    public void DeletePremium(){
        for (Product p:hash_Product.values())
            p.Deletehash();
        this.Delete();
    }
}
