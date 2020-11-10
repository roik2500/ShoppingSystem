package classes;

public class Address {

    private String address;

    public Address(String address) {
        this.address = address;
    }

    public String getAddress() { return address; }
    public void setAddress(String address) {
        if(address == null)
            this.address = address;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                '}';
    }
}