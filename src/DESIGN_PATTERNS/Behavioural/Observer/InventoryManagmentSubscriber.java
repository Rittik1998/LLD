package DESIGN_PATTERNS.Behavioural.Observer;

public class InventoryManagmentSubscriber implements OrderPlacedSubscriber{
    @Override
    public void onOrderPlaced(Order order) {
        System.out.println("Count of product with id " + order.productId + " got reduced by 1");
    }
}
