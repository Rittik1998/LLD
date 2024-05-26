package DESIGN_PATTERNS.Behavioural.Observer;

public class Client {
    public static void main(String[] args) {
        Order item = new Order("Rittik Banerjee","rittik@gmail.com",14567,987);
        Flipkart flipkart = new Flipkart();

        flipkart.register(new InventoryManagmentSubscriber());
        flipkart.register(new InvoiceGeneratorSubscriber());
        flipkart.register(new NotificationGeneratorSubscriber());

        flipkart.orderPlaced(item);
    }
}
