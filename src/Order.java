public class Order {

    private final Customer customer;
    private final int qtyOrdered;
    private final Product product;
    private final String orderNumber;
    private final String salesRep;

    public Order(Customer customer, int qtyOrdered, Product product, String orderNumber, String salesRep) {
        this.customer = customer;
        this.qtyOrdered = qtyOrdered;
        this.product = product;
        this.orderNumber = orderNumber;
        this.salesRep = salesRep;
    }


    public String toString() {

        return qtyOrdered + " x " + product.getName() + " - " + orderNumber + " - " + salesRep;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Product getProduct() {

        return product;
    }

    public Customer returnCustomer() {

        return customer;
    }

    public String returnCustomerNumber() {
        return customer.getCustomerNumber();
    }

    public String returnSalesFirstName() {
        String [] nameArray = salesRep.split("");
        return nameArray[0];
    }

    public String returnSalesFullName() {
        return salesRep;
    }

    public String returnCustomerCity() {
        return customer.getCity();
    }

    public String returnCustomerZone() {
        return customer.getZone();
    }

    public String returnCustomerID() {
        return customer.getCustomerNumber();
    }

    public String returnProductID() {
        return product.getItemNumber();

    }

    public String completeOrder() {
        return orderNumber + " - " +
                customer.getCustomerNumber() + " - " +
                customer.getCity() + " - " + customer.getZone() + " - " +
                qtyOrdered + " x " + product.getName() + "(" + product.getItemNumber() + ")"
                + " - " + returnOrderWeight() + " lbs";
    }

    public int returnOrderWeight() {
        return (qtyOrdered * product.getItemWeight());
    }





}

