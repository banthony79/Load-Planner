import java.util.ArrayList;
import java.util.List;

public class InventoryControl {

    private final List<Product> inventoryList;
    private int glyphosate1000L;
    private int glyphosate500L;
    private List<Order> masterOrderList;


    public InventoryControl(int glyphosate1000L, int glyphosate500L, List<Order> masterOrderList) {
        this.inventoryList = new ArrayList<>();
        this.glyphosate1000L = glyphosate1000L;
        this.glyphosate500L = glyphosate500L;
        Product product = new Product("1000L Glyphosate", 3100, "000000", glyphosate1000L);
        Product product1 = new Product("500L Glyphosate", 1629, "000001", glyphosate500L);
        inventoryList.add(product);
        inventoryList.add(product1);
        this.masterOrderList = masterOrderList;
    }

    public List<Product> getInventoryList() {

        return inventoryList;
    }

    public void addProducts() {
        Product product = null;
        for (int i = 0; i < masterOrderList.size(); i++) {
            product = masterOrderList.get(i).getProduct();
            if (!checkProduct(product.getItemNumber()) && (!product.getName().contains("Disruptor"))) {
                inventoryList.add(product);

            }

        }
    }

    private boolean checkProduct(String itemNumber) {
        if (!masterOrderList.isEmpty()) {
            for (Product product : inventoryList) {
                if (product.getItemNumber().equals(itemNumber)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }





    public void showProducts() {
        System.out.println("=====PRODUCT LIST=====");
        for (Product product : inventoryList) {
            System.out.println(product);
        }
    }

}



