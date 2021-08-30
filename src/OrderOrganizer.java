import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class OrderOrganizer {

    private LinkedList<Order> orderList;


    public OrderOrganizer(LinkedList<Order> orderList) {
        this.orderList = orderList;
    }

    public void organizeByOrderNumber(String orderNumber) {
        System.out.println("ORDER " + orderNumber + " LIST");
        String[] array = null;
        int count = 0;
        for (Order order : orderList) {
            array = order.getOrderNumber().split("-");
            //System.out.println(orderNumber + " - " + array[1]);
            if (array[1].equals(orderNumber)) {
                System.out.println(order.completeOrder());
                count++;
            }


        }

        if (count == 0) {
            System.out.println("Not found");
        }
    }


    private void organizeBySalesPerson(String firstName, String lastName) {
        Predicate<Order> bySalesPerson = order -> order.returnSalesFullName().equals(firstName + " " + lastName);
        var result = orderList.stream().filter(bySalesPerson).collect(Collectors.toList());
        if (!result.isEmpty()) {
            printOut(result);
        } else {
            System.out.println("Nothing found");
        }
    }

    private void organizeBySalesPersonFirstName(String firstName) {
        Predicate<Order> bySalesPerson = order -> order.returnSalesFirstName().equals(firstName);
        var result = orderList.stream().filter(bySalesPerson).collect(Collectors.toList());
        if (!result.isEmpty()) {
            printOut(result);
        } else {
            System.out.println("Nothing found");
        }
    }

    private void printOrders(List<Order> list) {
        for (Order order: list) {
            System.out.println(order.completeOrder());
        }
    }

    public void printOut(List<Order> list) {
        printOrders(list);
        System.out.println(calculateWeight(list));
        System.out.println("Count " + list.size());
    }

    public void organizeByProduct(String itemNumber) {
        Predicate<Order> byItemNumber = order -> order.returnProductID().equals(itemNumber);
        var result = orderList.stream().filter(byItemNumber).collect(Collectors.toList());
        if (!result.isEmpty()) {
            printOut(result);
        } else {
            System.out.println("Nothing found");
        }
    }

    public void organizeByGroup(String groupID) {
        Predicate<Order> byZone = order -> order.returnCustomerZone().equals(groupID);
        var result = orderList.stream().filter(byZone).collect(Collectors.toList());
        if (!result.isEmpty()) {
            printOut(result);
        } else {
            System.out.println("Nothing found");
        }
    }

    public List<Order> returnZoneList(String groupID) {
        Predicate<Order> byZone = order -> order.returnCustomerZone().equals(groupID);
        var result = orderList.stream().filter(byZone).collect(Collectors.toList());
        return result;
    }

    public void organizeList() {
        Comparator<Order> compareByZone = Comparator.
                                            comparing(Order::returnCustomerZone).
                                            thenComparing(Order::returnCustomerCity).
                                            thenComparing(Order::returnCustomerNumber);

        List<Order> sortedOrders = orderList.stream()
                                    .sorted(compareByZone)
                                    .collect(Collectors.toList());

        printOut(sortedOrders);
    }

        private String calculateWeight(List<Order> list) {
        int weight = 0;
        for (Order order: list) {
            weight+=order.returnOrderWeight();
        }
        return "Total Weight: " + weight + " lbs";
    }
}
