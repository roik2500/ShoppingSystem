package classes;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Customer {

    private String id;
   private Address address;
   private String phone;
   private String email;
   private WebUser webUser;
   private Account account;

    public Customer(String id) {
        this.id = id;
        this.address = null;
        this.phone = null;
        this.email = null;
      this.account=null;
      this.webUser=null;
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
