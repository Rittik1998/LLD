package DESIGN_PATTERNS.Behavioural.Observer;

public class InvoiceGeneratorSubscriber implements OrderPlacedSubscriber{
    @Override
    public void onOrderPlaced(Order order) {
        System.out.println(order.customerName + " has ordered product with id " + order.productId + ". The order id is: " +
                order.orderId);
    }
}
