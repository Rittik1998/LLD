package DESIGN_PATTERNS.Behavioural.Observer;

public class NotificationGeneratorSubscriber implements OrderPlacedSubscriber{
    @Override
    public void onOrderPlaced(Order order) {
        notifyUser(order);
    }

    private void notifyUser(Order order) {
        System.out.println("Hi " + order.customerEmail + ", the order has been placed with id " +
                order.orderId);
    }
}
