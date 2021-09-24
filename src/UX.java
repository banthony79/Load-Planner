import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class UX {

    private LinkedList<Customer> customerDB;
    private LinkedList<Order> masterOrderList;
    private OrderOrganizer organizer;
    private final OrderMaker orderMaker;
    private final InventoryControl inventoryControl;

    public UX() {
        this.customerDB = new LinkedList<>();
        this.masterOrderList = new LinkedList<>();
        this.organizer = new OrderOrganizer(masterOrderList);
        this.inventoryControl = new InventoryControl(5, 0, masterOrderList);
        this.orderMaker = new OrderMaker(masterOrderList, organizer, inventoryControl, customerDB);
    }

    public void addCustomer(String memberNumber, String city, double lat, double longt, String prov, String zone) {
        customerDB.add(new Customer(memberNumber, city, lat, longt, prov, zone));
    }

    public void addProduct(String name, int grossWeight, String itemNumber, int qtyInStock) {
        inventoryControl.getInventoryList().add(new Product(name, grossWeight, itemNumber, qtyInStock));
    }

    public void importOrders(String fileName) {

        Order order = null;
        Product product = null;
        Customer newCustomer = null;
        try {
            Scanner fileScanner = new Scanner(Paths.get(fileName));

            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] orderArray = line.split(",");
                String salesOrder = orderArray[0];
                int qty = Integer.parseInt(orderArray[1]);
                String custNumber = orderArray[2];
                String salesRep = orderArray[3];
                String proName = orderArray[4];
                String city = orderArray[5];
                int proWeight = Integer.parseInt(orderArray[6]);
                int inventoryNum = Integer.parseInt(orderArray[7]);
                String itemNumber = orderArray[8];
                String zone = orderArray[9];
                String province = orderArray[10];
                double lat = Double.parseDouble(orderArray[11]);
                if (lat > 0) {
                    lat = lat * -1;
                }
                double longt = Double.parseDouble(orderArray[12]);
                if (longt > 0) {
                    longt = longt * -1;
                }
                int itemWeight = proWeight/qty;

                product = new Product(proName, itemWeight, itemNumber, inventoryNum);

                newCustomer = new Customer(custNumber, city, lat, longt, province, zone);

                order = new Order(newCustomer, qty, product, salesOrder, salesRep);

                masterOrderList.add(order);


            }


        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }




    public void run(String fileName) {
        importOrders(fileName);
        addCustomers();
        inventoryControl.addProducts();
        addProductsToAllCustomers();
        //showProducts();
       // organizer.organizeList();
        //organizer.organizeByOrderNumber("57659");
        //organizer.organizeByGroup("004");
        //organizer.organizeByProduct("700127");
        //organizer.organizeByOrderNumber("57661");
        System.out.println(findCustomer("0"));
        System.out.println("The distance is " + returnKms("03769", "08392"));
        inventoryControl.showProducts();

    }

    public Customer findCustomer(String customerNumber) {
        for (Customer foundCustomer: customerDB) {
            if (foundCustomer.getCustomerNumber().equals(customerNumber)) {
                return foundCustomer;
            }
        }
   return null; }

    public List<Product> productList() {
        return inventoryControl.getInventoryList();
    }


    public double returnKms(String A, String B) {
        return orderMaker.calculateDistance(findCustomer(A).returnLat(), findCustomer(A).returnLong(),
                findCustomer(B).returnLat(), findCustomer(B).returnLong());
    }





    private void addCustomers() {
        Customer customer = null;
        for (int i = 0; i < masterOrderList.size(); i++) {
            customer = masterOrderList.get(i).returnCustomer();
            if (!checkCustomer(customer.getCustomerNumber())) {
                customerDB.add(customer);


      }
        }
    }

    private void addProductsToCustomer(String memberNumber) {
        Order order = null;
        for (int i = 0; i < masterOrderList.size(); i++) {
            order = masterOrderList.get(i);
            if (order.returnCustomer().getCustomerNumber().equals(memberNumber)) {
                findCustomer(memberNumber).getOrderList().add(order);

            }

            }
        }

    public void addProductsToAllCustomers() {
        for (Customer customer : customerDB) {
            addProductsToCustomer(customer.getCustomerNumber());
        }
    }



    public void displayAllCustomers() {
        System.out.println("====CUSTOMER LIST====");
        for (Customer customer: customerDB) {
            System.out.println(customer);
        }

    }



    public void displayOrders(String customerNumber) {
        if (findCustomer(customerNumber) != null) {
            findCustomer(customerNumber).displayOrders();
        } else {
            System.out.println("Not found");
        }
    }

    public void displayAllProducts() {
        System.out.println("=====PRODUCT LIST======");
        for (Product product: productList()) {
            System.out.println(product);
        }

    }





    private boolean checkCustomer(String customerNumber) {
    if (!masterOrderList.isEmpty()) {
        for (Customer customer: customerDB) {
            if (customer.getCustomerNumber().equals(customerNumber)) {
                return true;
            }
    }
  return false;
    }
    return false;
}
    public void buildLoads(int zone, boolean trailer) {

    }


}





