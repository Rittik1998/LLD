package DESIGN_PATTERNS.Creational.Factory.FactroryMethod;

public class Client {
    public static void main(String[] args) {
        //create a MySQL db
        Database db = new MySQLDatabase();
        Query q = db.createQuery();
        System.out.println(q.getClass());

        //create a Mongo db
        Database db2 = new MongoDatabase();
        Query q2 = db2.createQuery();
        System.out.println(q2.getClass());
    }
}
