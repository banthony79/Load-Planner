import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderMaker {

    private InventoryControl inventory;
    private LinkedList<Order> orderList;
    private OrderOrganizer organizer;

    public OrderMaker(InventoryControl inventory, LinkedList<Order> orders, OrderOrganizer organizer) {
    this.inventory = inventory;
    this.orderList = orders;
    this.organizer = organizer;
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

    public List<Order> addZonesToList(String zone1, String zone2, String zone3) {
        List<Order> list1  = organizer.returnZoneList(zone1);
        List<Order> list2 = organizer.returnZoneList(zone2);
        List<Order> list3 = organizer.returnZoneList(zone3);

        List<Order> newList = Stream.concat(list1.stream(), list2.stream()).collect(Collectors.toList());

        newList.addAll(organizer.returnZoneList(zone3));

    return newList;
    }


}

