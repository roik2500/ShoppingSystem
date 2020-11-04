package classes;

import java.util.ArrayList;

public class Product {

    private String id;
    private String name;
    // private String price;  //maybe need to be added
    private Supplier supplier;
    private ArrayList<LineItem> listLineItems;
    private PremiumAccount premiumAccount;

    public Product(String id, String name, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.listLineItems = new ArrayList<LineItem>();
        this.premiumAccount = null;
    }

    public void UpdateListLineItem(LineItem lineItem) {
        listLineItems.add(lineItem);
    }

    public void DeleteListLineItem(LineItem lineItem) {
        listLineItems.remove(lineItem);
    }

    public void setPremiumAccount(PremiumAccount premiumAccount) {
        this.premiumAccount = premiumAccount;
    }

    public void Delete()
    {
        for (LineItem lItem:listLineItems)
            lItem.Delete();
        listLineItems = null;
        this.supplier.DeleteFromHashProduct(id);
        this.supplier = null;
        if(this.premiumAccount != null){
            this.premiumAccount.DeleteFromHashProduct(id);
            this.premiumAccount = null;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ArrayList<LineItem> getListLineItems() {
        return listLineItems;
    }

    public void setListLineItems(LineItem lineItem) {
        {
            listLineItems.add(lineItem);
        }
    }

    public PremiumAccount getPremiumAccount() {
        return premiumAccount;
    }


}