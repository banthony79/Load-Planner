import java.util.LinkedList;

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

    
}
