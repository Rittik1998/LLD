package DESIGN_PATTERNS.Behavioural.Observer;

public class Order {
    String customerName;
    String customerEmail;
    long orderId;
    long productId;

    public Order(String customerName, String customerEmail, long orderId, long productId) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderId = orderId;
        this.productId = productId;
    }
}
