package classes;

import java.util.Date;
import java.util.HashMap;

public class PremiumAccount extends Account {

    private HashMap<String,Product> hash_Product;

    public PremiumAccount(String id, String billing_address, Date open, int balanced) {
        super(id,billing_address,open,balanced);
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
        //hash_Product.clear();
        for (Product p:hash_Product.values())
           p.setPremiumAccount(null);
        hash_Product=null;
        this.Delete();
    }

    public void printPremium(){
        /*
        this.printinfo();
        for (Product p:hash_Product.values()){
            p.print();
        }

         */

    }

}
