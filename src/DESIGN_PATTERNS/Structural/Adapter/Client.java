package DESIGN_PATTERNS.Structural.Adapter;

public class Client {
    public static void main(String[] args) {
        PGAdapter pg = new RazorpayPGAdapter();
        pg.initiate("12345566");
    }
}
