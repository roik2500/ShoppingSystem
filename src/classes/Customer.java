package classes;

import classes.Address;

public class Customer {

    private String id;
   private Address address;
   private String phone;
   private String email;
   private WebUser webUser;
   private Account account;

    public Customer(WebUser webUser) {
        this.webUser = webUser;
    }

    public Customer(String id, Address address, String phone, String email, WebUser webUser) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.account=null;
        this.webUser=webUser;

    }

    public void Delete(){
        account=null;
    }

 public void deletewebuser(){
        if(webUser!=null)
            this.webUser=null;
  }


    public void setId(String id) { this.id = id; }
    public void setAddress(Address address) { this.address = address; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }
    public void setWebUser(WebUser webUser) {
        if(webUser==null)
            this.webUser = webUser;
    }
    public void setAccount(Account account) {
        if(account==null)
        this.account = account;
    }

    public void printinfo(){
        System.out.println("ID:"+id);
        System.out.println("Address:"+address);
        System.out.println("Phone:"+phone);
        System.out.println("Email:"+email);
        if(webUser!=null){ System.out.println("WebUser:"+webUser);}
        if(account!=null){ System.out.println("Account:"+account);
        }
    }



    public String getId() { return id; }
    public Address getAddress() { return address; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public WebUser getWebUser() { return webUser; }
    public Account getAccount() { return account; }

    @Override
    public String toString() {
        return "Customer";
    }
}
