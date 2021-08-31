public class Product {

    private String name;
    private int itemWeight;
    private String itemNumber;
    private int qtyInStock;


    public Product(String name, int itemWeight, String itemNumber, int qtyInStock) {
        this.name = name;
        this.itemWeight = itemWeight;
        this.qtyInStock = qtyInStock;
        this.itemNumber = itemNumber;

    }

    public String getName() {

        return name;
    }

    public String toString() {
        return qtyInStock + " x " + name + ", " + itemNumber + ", " + itemWeight + " lbs";
    }

    public String getItemNumber() {
        return itemNumber;
    }

    public int getItemWeight() {
        return itemWeight;
    }

    public void addToLoad(int qty) {
        if (qtyInStock < qty) {
            System.out.println("Not in stock");
        } else {
            this.qtyInStock--;
        }

    }

    public void addToStock(int qty) {
        this.qtyInStock++;
    }
}


