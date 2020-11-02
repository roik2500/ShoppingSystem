package classes;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Customer {

    String id;
    Address address;
    String phone;
    String email;
    WebUser webUser;
    Account account;



    public Customer(String id) {
        this.id = id;
        this.address = null;
        this.phone = null;
        this.email = null;
        this.account=new Account();
        // add a commend that update the custome in Account to be this - roi peled
        this.webUser=null;
    }


    public void Delete(){
        if(webUser!=null){
            webUser.Delete();
            webUser=null;
        }
        //account.delete;
        //account=null;
    }
  public void deletewebuser(){
        if(webUser!=null)
            this.webUser=null;
  }

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
