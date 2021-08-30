import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private final String customerNumber;
    private final String city;
    private final double lat;
    private final  double longt;
    private final String prov;
    private final String zone;
    private final ArrayList<Order> orderList;

    public Customer(String customerNumber, String city, double lat, double longt, String prov, String zone) {
        this.customerNumber = customerNumber;
        this.city = city;
        this.lat = lat;
        this.longt = longt;
        this.prov = prov;
        this.zone = zone;
        this.orderList = new ArrayList<>();
    }

    public String toString() {
        return customerNumber + ": " + city + ", " + prov + ", " + zone;

    }

    public void displayOrders() {
        for (Order order: orderList) {
            System.out.println(order);
        }
    }


    public ArrayList<Order> getOrderList() {
        return orderList;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getCity() {
        return city;
    }

    public String getZone() {
        return zone;
    }

    public double returnLat() {
        return lat;
    }

    public double returnLong() {
        return longt;
    }

    public double getLat() {
        return lat;
    }

    public double getLongt() {
        return longt;
    }



}


