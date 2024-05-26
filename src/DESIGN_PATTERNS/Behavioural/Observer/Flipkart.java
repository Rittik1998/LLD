package DESIGN_PATTERNS.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class Flipkart {
    List<OrderPlacedSubscriber> subscriberList;

    Flipkart(){
        this.subscriberList = new ArrayList<>();
    }
    public void register(OrderPlacedSubscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void deregister(OrderPlacedSubscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void orderPlaced(Order order){
        for(OrderPlacedSubscriber subscriber: subscriberList){
            subscriber.onOrderPlaced(order);
        }
    }
}
