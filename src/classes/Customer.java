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
      this.account=new Account();
    }

    public void Delete(){
        account=null;
    }

  public void deletewebuser(){
        if(webUser!=null)
            this.webUser=null;
  }


  //////getter and setter/////////
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public WebUser getWebUser(){return webUser;}


}
