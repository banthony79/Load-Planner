import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderMaker {

    //private InventoryControl inventory;
    private final LinkedList<Order> orderList;
    private final OrderOrganizer organizer;
    private final InventoryControl inventoryControl;


    public OrderMaker(LinkedList<Order> orders, OrderOrganizer organizer, InventoryControl inv) {
   // this.inventory = inventory;
    this.orderList = orders;
    this.organizer = organizer;
    this.inventoryControl = inv;
    }

    public LinkedList<Order> getOrderList() {
        return orderList;
    }

    public OrderOrganizer getOrganizer() {
        return organizer;
    }

   public List<Order> addZonesToList(String zone1) {
       return organizer.returnZoneList(zone1);
    }

    public List<Order> addZonesToList(String zone1, String zone2) {
        List<Order> list1  = organizer.returnZoneList(zone1);
        List<Order> list2 = organizer.returnZoneList(zone2);

        List<Order> newList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

    return newList;
  }

    //Distance, d = 3963.0 * arccos[(sin(lat1) * sin(lat2)) + cos(lat1) * cos(lat2) * cos(long2 – long1)]

    public double calculateDistance(double lat1, double long1, double lat2, double long2) {

        long1 = Math.toRadians(long1);
        long2 = Math.toRadians(long2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);


        double dlon = long2 - long1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }




}


