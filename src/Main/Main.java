package Main;
import classes.*;
import enums.UseState;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import static enums.UseState.Active;

public class Main {

    public static void main(String[] args) {
        //when the user log in we add him to hashmap "connected" by the login_id
       // HashMap<String, String> users= new HashMap<String, String>();//all the users in the system
        //HashMap<String,String> AllProducts= new HashMap<String, String>();
        HashMap<String,Object> AllObjects= new HashMap<String, Object>();
        HashMap<String, ArrayList<String>> IdListUsers= new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> IdListProducts= new HashMap<String, ArrayList<String>>();
        Account connected;

        //////////Already exist in the System (נתון לנו)////////////
        Supplier moshe=new Supplier("123","Moshe");
        AllObjects.put("1",moshe);
        Product bamba=new Product("Bamba", "Bamba",4,moshe);
        AllObjects.put("2",bamba);
        IdListProducts.put(bamba.getId(),new ArrayList<String>());
        IdListProducts.get(bamba.getId()).add("2");
        Product raman=new Product("Raman", "Raman", 50, moshe);
        AllObjects.put("3",raman);
        IdListProducts.put(raman.getId(),new ArrayList<String>());
        IdListProducts.get(raman.getId()).add("3");

        moshe.setHashProducts(bamba.getId(),bamba);
        moshe.setHashProducts(raman.getId(),raman);

        WebUser webUser=new WebUser("Dani", "Dani123");
        AllObjects.put("4",webUser);
        IdListUsers.put(webUser.getLogin_id(),new ArrayList<String>());
        IdListUsers.get(webUser.getLogin_id()).add("4");
        Customer customer1 =new Customer(webUser);
        AllObjects.put("5",customer1);
        IdListUsers.get(webUser.getLogin_id()).add("5");
        Account account=new Account();
        AllObjects.put("6",account);
        IdListUsers.get(webUser.getLogin_id()).add("6");
        customer1.setAccount(account);
        account.setCustomer(customer1);
        ShoppingCart shoppingCart1 =new ShoppingCart(account,webUser,new Date());
        account.setShoppingCart(shoppingCart1);
        AllObjects.put("7",shoppingCart1);
        IdListUsers.get(webUser.getLogin_id()).add("7");
       //need to finish that!!!???!!
        int counter = 8; // counter global

        while (true){
            System.out.println("1: Add WebUser");
            System.out.println("2: Remove WebUser ");
            System.out.println("3: Log In");
            System.out.println("4: Add Product ");
            System.out.println("5: Delete Product");
            System.out.println("6: ShowAllObjects");
            System.out.println("7: ShowObjectId ");

            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();
            //String loginIDToRemove=scanner.next();
            String login;
            String password;
            Order last_order=null;

            switch (num) {
                case 1://Add WebUser
                    //webUser
                    System.out.println("Details about web user:");
                    String webUesrId = System.console().readLine("Enter web user id:");
                    password = System.console().readLine("password:");

                    //customer
                    System.out.println("Details about customer:");
                    String customerId = System.console().readLine("Enter customer id:");
                    String customerAddress = System.console().readLine("Enter customer address:");
                    Address address = new Address(customerAddress);
                    String customerPhone = System.console().readLine("Enter customer phone:");
                    String customerEmail = System.console().readLine("Enter customer email:");

                    //Account
                    System.out.println("Details about account:");
                    String accountId = System.console().readLine("Enter account id:");
                    String accountBillingAddress = System.console().readLine("Enter billing address account:");
                    String accountBalance = System.console().readLine("Enter account balance:");
                    String isPremium = System.console().readLine("Is a premium account? y/n");

                    //Building the objects:
                    WebUser WebUser = new WebUser(webUesrId, password);//1

                    //add WebUser to to Allobject and crate an arraylist and add the ID to the arraylist in IdListUsers
                    AllObjects.put(Integer.toString(counter),WebUser);
                    IdListUsers.put(WebUser.getLogin_id(),new ArrayList<String>());
                    IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                    counter++;


                    Customer customer = new Customer(customerId, address, customerPhone, customerEmail,webUser);//2

                    //add customer to to Allobject and add the ID to the arraylist in IdListUsers
                    AllObjects.put(Integer.toString(counter),customer);
                    IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                    counter++;


                    if(isPremium == "y") {
                        PremiumAccount premiumAccount = new PremiumAccount(accountId,customer);//3

                        //add premiumAccount to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),premiumAccount);
                        IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;

                        ShoppingCart shoppingCart = new ShoppingCart(premiumAccount,webUser,new Date()); //4

                        //add shoppingCart to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),shoppingCart);
                        IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;


                        webUser.setShoppingCart(shoppingCart);
                        webUser.setCustomer(customer);
                        premiumAccount.setShoppingCart(shoppingCart);
                        customer.setAccount(premiumAccount);
                    }
                    else
                    {
                        Account account1 = new Account(accountId,customer);//3

                        //add account1 to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),account1);
                        IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;


                        ShoppingCart shoppingCart = new ShoppingCart(account1,webUser,new Date()); //4

                        //add shoppingCart to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),shoppingCart);
                        IdListUsers.get(webUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;

                        webUser.setShoppingCart(shoppingCart);
                        webUser.setCustomer(customer);
                        account1.setShoppingCart(shoppingCart);
                        customer.setAccount(account1);
                        //*** ADD THE OBJECTS!!***//

                    }



                case 2://Remove WebUser
                    System.out.println("Please enter a login id for remove");
                     String loginIDToRemove = scanner.next();
                    WebUser forRemove = getWebUser(loginIDToRemove,AllObjects,IdListUsers);
                    ArrayList<String> templist = IdListUsers.get(loginIDToRemove);
                    for (String s : templist) {
                        if (AllObjects.containsKey(s))
                            AllObjects.remove(s);
                    }
                    IdListUsers.remove(loginIDToRemove);
                    forRemove.Delete();

                case 3://Log In
                    boolean out = true;
                    System.out.println("Please enter a login id");
                    login = scanner.next();
                    if (IdListUsers.containsKey(login)) {
                        System.out.println("Please enter a Password");
                        password = scanner.next();
                        webUser = getWebUser(login,AllObjects,IdListUsers);
                        if (webUser.getPassword() == password) {
                            account = webUser.getCustomer().getAccount();//This is
                            while (out == true) {
                                webUser.setState(Active);
                                System.out.println("1: Make order");
                                System.out.println("2: Display order");
                                System.out.println("3: Add a Link Product");
                                System.out.println("4: Logout");
                                int userchoos = scanner.nextInt();
                                switch (userchoos) {
                                    case 1://Make order
                                        System.out.println("Please enter id of the seller");
                                        loginIDToRemove = scanner.next();
                                        WebUser seller = getWebUser(loginIDToRemove,AllObjects,IdListUsers);
                                        if (seller.getCustomer().getAccount().isPremiumAccount()) {
                                            boolean buy = true;
                                            while (buy == true) {
                                                seller.getCustomer().getAccount().printorders();
                                                System.out.println("Please enter id of the product you want");
                                                String prod = scanner.next();
                                                System.out.println("Please enter quantity");
                                                String quan = scanner.next();
                                                /*
                                                need to remove from seller?
                                                need to put in buyer?
                                                 */

                                                last_order = seller.getCustomer().getAccount().getorder(prod);
                                                System.out.println("Do you want to continue buying?(yes/no");
                                                String stay = scanner.next();
                                                if (stay == "no")
                                                    buy = false;
                                            }
                                        } else {
                                            System.out.println("This is not a premium account");
                                        }


                                        break;


                                    case 2://Display order
                                        last_order.printinfo();
                                        break;

                                    case 3://Link Product

                                    case 4://LogOut
                                        System.out.println("Please enter a login id");
                                        String id_log_out = scanner.next();
                                         getWebUser(id_log_out,AllObjects,IdListUsers).setState(UseState.Blocked);
                                        out = false;
                                        break;
                                }
                            }

                        }

                    }


                case 4:// Add Product
                    System.out.println("Enter the Product Id");
                    String product_id = scanner.next();

                    System.out.println("Enter the Name of Product");
                    String product_name = scanner.next();

                    System.out.println("Enter the price of Product ");
                    String product_price = scanner.next();

                    System.out.println("Enter the Supplier Id");
                    String supplier_id = scanner.next();

                    System.out.println("Enter the Name of Supplier ");
                    String supplier_name = scanner.next();

                    Supplier new_supplier = new Supplier(supplier_id, supplier_name);
                    Product new_product = new Product(product_id, product_name, Integer.parseInt(product_price), new_supplier);

                    //add supplier and product to our data structure
                    AllObjects.put(Integer.toString(counter), new_product);
                    counter++;
                    AllObjects.put(Integer.toString(counter), new_supplier);
                    counter++;
                    IdListProducts.put(product_id,new ArrayList<String>());
                    IdListProducts.get(product_id).add(Integer.toString(counter));
                    counter++;
                    break;


                case 5://Delete Product
                    System.out.println("Please enter a product id tp delete");
                    String productIDToRemove = scanner.next();
                    Product product = getProduct(productIDToRemove,AllObjects,IdListProducts);
                    ArrayList<String> templistProduct = IdListProducts.get(productIDToRemove);
                    for (String p : templistProduct) {
                        if (AllObjects.containsKey(p))
                            AllObjects.remove(p);
                    }
                    IdListProducts.remove(productIDToRemove);
                    product.Delete();

                    break;


                case 6://ShowAllObjects
                    for (String idO : AllObjects.keySet()) {
                        Object Ob = AllObjects.get(idO);
                        System.out.println("Object's id:" + idO + ", object's name: " + Ob.toString());
                    }
                    break;
             /*       for (String Id : IdListUsers.keySet()) {
                       WebUser webUser1=(WebUser)AllObjects.get(IdListProducts.get(Id));
                        System.out.println("Object's id:" + Id + ", object's name: " + webUser.toString());
                    }
                    for (String idP : AllProducts.keySet()) {
                        Product proud = AllProducts.get(idP);
                        System.out.println("Object's id:" + idP + ", object's name: " + proud.toString());
                    }*/


                case 7://ShowObjectById
                    System.out.println("Enter the Object Id");
                    String object_id = scanner.next();
                    Object ob = AllObjects.get(object_id);
                    if (ob instanceof PremiumAccount) {
                        PremiumAccount temp = (PremiumAccount) ob;
                        temp.printinfo();
                    } else if (ob instanceof Account) {
                        Account temp = (Account) ob;
                        temp.printinfo();
                    } else if (ob instanceof Customer) {
                        Customer temp = (Customer) ob;
                        temp.printinfo();
                    } else if (ob instanceof Payment) {
                        Payment temp = (Payment) ob;
                        temp.printinfo();
                    } else if (ob instanceof LineItem) {
                        LineItem temp = (LineItem) ob;
                        temp.print();
                    } else if (ob instanceof Order) {
                        Order temp = (Order) ob;
                        temp.printinfo();
                    } else if (ob instanceof Product) {
                        Product temp = (Product) ob;
                        temp.printInfo();
                    } else if (ob instanceof ShoppingCart) {
                        ShoppingCart temp = (ShoppingCart) ob;
                        temp.printinfo();
                    } else if (ob instanceof Supplier) {
                        Supplier temp = (Supplier) ob;
                        temp.printInfo();
                    } else if (ob instanceof WebUser) {
                        WebUser temp = (WebUser) ob;
                        temp.printinfo();
                    }

            }

        }



    }
    public static WebUser getWebUser(String webUserLoginId,HashMap<String,Object> AllObjects,HashMap<String, ArrayList<String>> IdListUsers){

        return (WebUser)AllObjects.get(IdListUsers.get(webUserLoginId).get(0));
    }
    public static Product getProduct(String ProductId,HashMap<String,Object> AllObjects,HashMap<String, ArrayList<String>> IdListProducts){

        return (Product) AllObjects.get(IdListProducts.get(ProductId).get(0));
    }
}
