package Main;
import classes.*;
import enums.UseState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static enums.UseState.Active;

public class Main {

    public static void main(String[] args) {
        //when the user log in we add him to hashmap "connected" by the login_id
        HashMap<String, WebUser> users= new HashMap<String, WebUser>();//all the users in the system
        HashMap<String,Product> AllProducts= new HashMap<String, Product>();
        HashMap<String,Object> AllObjects= new HashMap<String, Object>();
        HashMap<String, ArrayList<String>> IdList= new HashMap<String, ArrayList<String>>();
        Account connected;

        //////////Already exist in the System (נתון לנו)/////////////
        Supplier moshe=new Supplier("123","Moshe");
        Product bamba=new Product("Bamba","Bamba",moshe);
        Product raman=new Product("Raman","Raman",moshe);
        Account account=new Account("Dani","Dani123");//add s setter for id


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
            String num2=scanner.next();
            String login;
            String password;

            switch (num){
                case 1://Add WebUser




                case 2://Remove WebUser
                    System.out.println("Please enter a login id for remove");
                    num2=scanner.next();
                    WebUser forRemove=users.get(num2);
                    ArrayList<String> templist = IdList.get(num2);
                    for (String s:templist) {
                        if(AllObjects.containsKey(s))
                            AllObjects.remove(s);
                    }
                    IdList.remove(num2);
                    AllObjects.remove(num2);
                    forRemove.Delete();
                    users.remove(num2);

                case 3://Log In
                    System.out.println("Please enter a login id");
                    login=scanner.next();
                    if(users.containsKey(login)) {
                        System.out.println("Please enter a Password");
                        password=scanner.next();
                        if(users.get(login).getPassword()==password){
                            account=users.get(login).getCustomer().getAccount();//This is
                            while (true){
                                users.get(login).setState(Active);
                                System.out.println("1: Make order");
                                System.out.println("2: Display order");
                                System.out.println("3: Add a Link Product");
                                int userchoos=scanner.nextInt();
                                switch (userchoos){
                                    case 1://Make order

                                    case 2://Display order

                                    case 3://Link Product

                                    case 4://Log Out
                                        System.out.println("Please enter a login id");
                                        String id_log_out=scanner.next();
                                        WebUser log_out=users.get(id_log_out);
                                        log_out.setState(UseState.Blocked);
                                        break;
                                }
                            }

                        }

                    }



                case 4:// Add Product
                    System.out.println("Enter the Product Id");
                    String product_id=scanner.next();

                    System.out.println("Enter the Name of Product");
                    String product_name=scanner.next();

                    System.out.println("Enter the Supplier Id");
                    String supplier_id=scanner.next();

                    System.out.println("Enter the Name of Supplier ");
                    String supplier_name=scanner.next();

                    Supplier new_supplier=new Supplier(supplier_id,supplier_name);
                    Product new_product=new Product(product_id,product_name,new_supplier);

                    AllProducts.put(product_id,new_product);
                    AllObjects.put(product_id,new_product);
                    AllObjects.put(supplier_id,new_supplier);
                    ArrayList<String> s=new ArrayList<String>();
                    s.add(supplier_id);
                    IdList.put(product_id,s);
                    break;


                case 7://ShowObjectById
                    System.out.println("Enter the Object Id");
                    String object_id=scanner.next();
                    Object ob =AllObjects.get(object_id);
                    if(ob instanceof PremiumAccount){
                        PremiumAccount temp=(PremiumAccount)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof Account){
                       Account temp=(Account)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof Customer){
                        Customer temp=(Customer)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof Payment){
                        Payment temp=(Payment)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof LineItem){
                        LineItem temp=(LineItem)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof Order){
                        Order temp=(Order)ob;
                        temp.printinfo();
                    }

                    else if(ob instanceof Product){
                        Product temp=(Product)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof ShoppingCart){
                        ShoppingCart temp=(ShoppingCart)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof Supplier){
                        Supplier temp=(Supplier)ob;
                        temp.printinfo();
                    }
                    else if(ob instanceof WebUser){
                        WebUser temp=(WebUser)ob;
                        temp.printinfo();
                    }

            }

        }



    }
}
