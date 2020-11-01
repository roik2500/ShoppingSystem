package classes;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

public class Customer {
    String id;
    Address address;
    String phone;
    String email;

    public Customer(String id, Address address, String phone, String email) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }


}
