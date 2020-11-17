package Main;
import classes.*;
import enums.OrderStatus;
import enums.UseState;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static enums.UseState.Active;

public class Main {

    public static void main(String[] args) throws ParseException, InterruptedException {
        HashMap<String,Object> AllObjects= new HashMap<String, Object>();
        HashMap<String, ArrayList<String>> IdListUsers= new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<String>> IdListProducts= new HashMap<String, ArrayList<String>>();
        Account connected;

        //////////Already exist in the System ////////////
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
        AllObjects.put("4",webUser);;

        IdListUsers.put(webUser.getLogin_id(),new ArrayList<String>());
        IdListUsers.get(webUser.getLogin_id()).add("4");
        Customer customer1 =new Customer(webUser);
        webUser.setCustomer(customer1);
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
        webUser.getCustomer().setAddress(new Address("13213"));

        WebUser webUser2=new WebUser("Dana", "Dana123");
        AllObjects.put("8",webUser2);;

        IdListUsers.put(webUser2.getLogin_id(),new ArrayList<String>());
        IdListUsers.get(webUser2.getLogin_id()).add("8");
        Customer customer2 =new Customer(webUser2);
        webUser2.setCustomer(customer2);
        AllObjects.put("9",customer2);
        IdListUsers.get(webUser2.getLogin_id()).add("9");
        PremiumAccount premiumAccount2=new PremiumAccount("4564",customer2);
        AllObjects.put("10",premiumAccount2);
        IdListUsers.get(webUser2.getLogin_id()).add("10");
        customer2.setAccount(premiumAccount2);
        ShoppingCart shoppingCart2 =new ShoppingCart(premiumAccount2,webUser2,new Date());
        premiumAccount2.setShoppingCart(shoppingCart2);
        AllObjects.put("11",shoppingCart2);
        IdListUsers.get(webUser2.getLogin_id()).add("11");
        webUser2.getCustomer().setAddress(new Address("13213"));
        premiumAccount2.UpdateHashProduct(bamba);
        bamba.setPremiumAccount(premiumAccount2);
        bamba.setQuantity(50);
        int counter = 12; // counter global
        boolean exit=false;

        while (exit!=true){
            System.out.println("1: Add WebUser");
            System.out.println("2: Remove WebUser ");
            System.out.println("3: Log In");
            System.out.println("4: Add Product ");
            System.out.println("5: Delete Product");
            System.out.println("6: ShowAllObjects");
            System.out.println("7: ShowObjectId ");
            System.out.println("8: Exit ");


            Scanner scanner=new Scanner(System.in);
            int num=scanner.nextInt();
            String login;
            String password;
            Order last_order=null;

            switch (num) {
                case 1://Add WebUser
                    //webUser
                    System.out.println("Details about web user:");
                    System.out.println("Enter web user id:");
                    String webUesrId = scanner.next();
                    System.out.println("password:");
                    password = scanner.next();

                    //customer
                    System.out.println("Details about customer:");
                    System.out.println("Enter customer id:");
                    String customerId = scanner.next();
                    System.out.println("Enter customer address:");
                    String customerAddress = scanner.next();
                    Address address = new Address(customerAddress);
                    System.out.println("Enter customer phone:");
                    String customerPhone = scanner.next();
                    System.out.println("Enter customer email:");
                    String customerEmail =scanner.next();

                    //Account
                    System.out.println("Details about account:");
                    System.out.println("Enter account id:");
                    String accountId = scanner.next();
                    System.out.println("Enter billing address account:");
                    String accountBillingAddress = scanner.next();
                    System.out.println("Enter account balance:");
                    int accountBalance = Integer.parseInt(scanner.next());
                    System.out.println("Is a premium account? y/n");
                    String isPremium = scanner.next();

                    //Building the objects:
                    WebUser WebUser = new WebUser(webUesrId, password);//1

                    //add WebUser to to Allobject and crate an arraylist and add the ID to the arraylist in IdListUsers
                    AllObjects.put(Integer.toString(counter),WebUser);
                    IdListUsers.put(WebUser.getLogin_id(),new ArrayList<String>());
                    IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                    counter++;


                    Customer customer = new Customer(customerId, address, customerPhone, customerEmail,webUser);//2

                    //add customer to to Allobject and add the ID to the arraylist in IdListUsers
                    AllObjects.put(Integer.toString(counter),customer);
                    IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                    counter++;


                    if(isPremium.equals("y")) {
                        PremiumAccount premiumAccount = new PremiumAccount(accountId,accountBillingAddress,new Date(),accountBalance );//3
                        premiumAccount.setCustomer(customer);

                        //add premiumAccount to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),premiumAccount);
                        IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;

                        ShoppingCart shoppingCart = new ShoppingCart(premiumAccount,webUser,new Date()); //4

                        //add shoppingCart to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),shoppingCart);
                        IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;


                        WebUser.setShoppingCart(shoppingCart);
                        WebUser.setCustomer(customer);
                        premiumAccount.setShoppingCart(shoppingCart);
                        customer.setAccount(premiumAccount);
                    }
                    else
                    {
                        Account account1 = new Account(accountId,accountBillingAddress,new Date(),accountBalance );//3
                        account1.setCustomer(customer);
                        //add account1 to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),account1);
                        IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;


                        ShoppingCart shoppingCart = new ShoppingCart(account1,webUser,new Date()); //4

                        //add shoppingCart to to Allobject and add the ID to the arraylist in IdListUsers
                        AllObjects.put(Integer.toString(counter),shoppingCart);
                        IdListUsers.get(WebUser.getLogin_id()).add(Integer.toString(counter));
                        counter++;

                        WebUser.setShoppingCart(shoppingCart);
                        WebUser.setCustomer(customer);
                        account1.setShoppingCart(shoppingCart);
                        customer.setAccount(account1);
                        //*** ADD THE OBJECTS!!***//

                    }
                    break;



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
                    break;

                case 3://Log In
                    boolean out = true;
                    System.out.println("Please enter a login id");
                    login = scanner.next();
                    if (IdListUsers.containsKey(login)) {
                        System.out.println("Please enter a Password");
                        password = scanner.next();
                        WebUser connect = getWebUser(login,AllObjects,IdListUsers);
                        if (password.equals(connect.getPassword()) ) {
                            while (out == true) {
                                connect.setState(Active);
                                System.out.println("1: Make order");
                                System.out.println("2: Display order");
                                System.out.println("3: Add a Link Product");
                                System.out.println("4: Logout");
                                int userchoos = scanner.nextInt();
                                switch (userchoos) {
                                    case 1://Make order
                                        float total=0;
                                        System.out.println("Please enter id of the seller");
                                        loginIDToRemove = scanner.next();
                                        WebUser seller = getWebUser(loginIDToRemove,AllObjects,IdListUsers);
                                        if (seller.getCustomer().getAccount().isPremiumAccount()) {
                                            PremiumAccount premiumAccount= (PremiumAccount) seller.getCustomer().getAccount();
                                            boolean buy = true;
                                            int prodamunt=0;
                                            Order newOrder=null;
                                            while (buy == true) {
                                                premiumAccount.printProduct();//show all products
                                                System.out.println("Please enter id of the product you want");
                                                String prod = scanner.next();//choose product
                                                System.out.println("Please enter quantity");
                                                String quan = scanner.next();//ask for quantity
                                                prodamunt++;
                                                int quantity=Integer.parseInt(quan);
                                                int price = premiumAccount.getHash_Product().get(prod).getPrice();
                                                if(prodamunt==1) {
                                                    System.out.println("Please enter order number");
                                                    String number = scanner.next();
                                                    System.out.println("Please enter date to deliver(yyyy-MM-dd)");
                                                    String date = scanner.next();
                                                    int amount = premiumAccount.getHash_Product().get(prod).getQuantity();
                                                    premiumAccount.getHash_Product().get(prod).setQuantity(amount - quantity);//lowers the amount
                                                    Date today = new Date();
                                                    Date deliver = new SimpleDateFormat("yyyy-MM-dd").parse(date);
                                                    //make new order
                                                     newOrder = new Order(number, today, deliver, connect.getCustomer().getAddress(), OrderStatus.New, quantity * price);
                                                }
                                                //make line item
                                                LineItem lineItem=new LineItem(quantity,price,newOrder,connect.getShoppingCart(),premiumAccount.getHash_Product().get(prod));
                                                newOrder.UpdateListLineItems(lineItem);

                                                premiumAccount.setBalanced((int) (premiumAccount.getBalanced()+newOrder.getTotal()));
                                                total=total+quantity*price;
                                                //add order and line item to our data structure
                                                AllObjects.put(Integer.toString(counter), newOrder);
                                                IdListUsers.get(connect.getLogin_id()).add(Integer.toString(counter));
                                                counter++;
                                                AllObjects.put(Integer.toString(counter), lineItem);
                                                IdListProducts.get(prod).add(Integer.toString(counter));
                                                counter++;


                                                System.out.println("Do you want to continue buying?(yes/no)");
                                                String stay = scanner.next();
                                                if (stay.equals("no")) {
                                                    newOrder.setTotal(total);
                                                    connect.getCustomer().getAccount().UpdateHashOrders(newOrder);//connect the order to the account order hash
                                                    newOrder.setAccount(connect.getCustomer().getAccount());//set order account

                                                    System.out.println("How do you want to pay?(D/I)");
                                                    String pay = scanner.next();
                                                    System.out.println("Please enter payment id");
                                                    String payid = scanner.next();
                                                    System.out.println("Please enter date to pay(yyyy-MM-dd)");
                                                    String paydate = scanner.next();
                                                    Date deliverpay = new SimpleDateFormat("yyyy-MM-dd").parse(paydate);
                                                    System.out.println("Please enter more details");
                                                    String details = scanner.next();
                                                    if(pay.equals("D"))
                                                    {
                                                        DelayedPayment delayedPayment=new DelayedPayment(connect.getCustomer().getAccount(),newOrder,deliverpay,payid,deliverpay,total,details);
                                                        connect.getCustomer().getAccount().UpdateHashPayments(delayedPayment);
                                                        AllObjects.put(Integer.toString(counter), delayedPayment);
                                                        IdListUsers.get(connect.getLogin_id()).add(Integer.toString(counter));
                                                        newOrder.UpdateHashPayments(delayedPayment);
                                                        counter++;
                                                    }
                                                    else {
                                                        System.out.println("Please enter phone phone confirmation(y/n)");
                                                        String confirm = scanner.next();
                                                        boolean confirmation;
                                                        if(confirm.equals("y"))
                                                            confirmation=true;
                                                        else
                                                            confirmation=false;
                                                        ImmediatePayment immediatePayment=new ImmediatePayment(connect.getCustomer().getAccount(),newOrder,confirmation,payid,deliverpay,total,details);
                                                        connect.getCustomer().getAccount().UpdateHashPayments(immediatePayment);
                                                        AllObjects.put(Integer.toString(counter), immediatePayment);
                                                        IdListUsers.get(connect.getLogin_id()).add(Integer.toString(counter));
                                                        newOrder.UpdateHashPayments(immediatePayment);
                                                        counter++;
                                                    }
                                                    connect.getCustomer().getAccount().setBalanced((int) (connect.getCustomer().getAccount().getBalanced()-total));

                                                    buy = false;
                                                }

                                            }
                                        } else {
                                            System.out.println("This is not a premium account");
                                        }
                                        break;


                                    case 2://Display order
                                        if(connect.getCustomer().getAccount().getLastOrder()!=null)
                                            connect.getCustomer().getAccount().getLastOrder().printinfo();
                                        else {
                                            System.out.println("The order is doesnt exist, please make order before");
                                            TimeUnit.SECONDS.sleep(2);
                                        }
                                        break;

                                    case 3://Link Product
                                        if (connect.getCustomer().getAccount().isPremiumAccount()) { //checking if preimumAccount
                                            PremiumAccount premiumAccount = (PremiumAccount) connect.getCustomer().getAccount();
                                            System.out.println("Enter a product name");
                                            String product_name = scanner.next();
                                            Product product = getProduct(product_name,AllObjects,IdListProducts);
                                            if (product.getPremiumAccount() == null) {
                                                product.setPremiumAccount(premiumAccount);
                                                premiumAccount.UpdateHashProduct(product);
                                                System.out.println("Enter a product price");
                                                int temp =Integer.parseInt( scanner.next());
                                                product.setPrice(temp);
                                                System.out.println("Enter a product quantity");
                                                temp = Integer.parseInt( scanner.next());
                                                product.setQuantity(temp);
                                            }
                                        }
                                        break;


                                    case 4://LogOut
                                        connect.setState(UseState.Blocked);
                                        out = false;
                                        break;
                                }
                            }

                        }
                        break;

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
                    new_supplier.setHashProducts(new_product.getId(),new_product);


                    //add supplier and product to our data structure
                    AllObjects.put(Integer.toString(counter), new_product);
                    IdListProducts.put(product_id,new ArrayList<String>());
                    IdListProducts.get(product_id).add(Integer.toString(counter));
                    counter++;
                    AllObjects.put(Integer.toString(counter), new_supplier);
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


                case 7://ShowObjectById
                    System.out.println("Enter the Object Id");
                    String object_id = scanner.next();
                    Object ob = AllObjects.get(object_id);
                    if (ob instanceof PremiumAccount) {
                        PremiumAccount temp = (PremiumAccount) ob;
                        temp.printPremiumInfo();
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
                        temp.printinfo();
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
                    break;


                case 8:
                    exit=true;
                    break;
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
