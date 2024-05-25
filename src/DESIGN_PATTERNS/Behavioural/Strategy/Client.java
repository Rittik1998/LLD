package DESIGN_PATTERNS.Behavioural.Strategy;

public class Client {
    public static void main(String[] args) {
        GoogleMap gmap = new GoogleMap();
        //find path for car
        gmap.findPath("Airport","Bellandur",Mode.CAR);

        //find path for bike
        gmap.findPath("Airport","Bellandur",Mode.BIKE);
    }
}
