package week_10.CarDealership;

public class Dealership {
    private int id;
    private String name;
    private String address;
    private String phone;

    public Dealership(){}

    public Dealership(int id, String name, String address, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;

    }

    @Override
    public String toString() {
        return String.format("""
                             Dealership:
                             Id - %d
                             Name - %s
                             Address - %s
                             Phone -  %s""", id,name,address,phone);
    }
}
