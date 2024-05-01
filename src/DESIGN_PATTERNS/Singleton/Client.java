package DESIGN_PATTERNS.Singleton;

public class Client {
    public static void main(String[] args) {
        //v1
        Database db = Database.getObj();

        //v2
        Databasev2 db1 = Databasev2.getObj("1234","Rittik");
    }
}
