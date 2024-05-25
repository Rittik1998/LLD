package DESIGN_PATTERNS.Factory.AbstractFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public class Client {
    public static void main(String[] args) {
        //create a MySQL db
        Database db = new MySQLDatabase();
        DatabaseFactory dbf = db.getDatabaseFactory();
        Query q = dbf.createQuery();
        System.out.println(q.getClass());

        //create a Mongo db
        Database db2 = new MongoDatabase();
        DatabaseFactory dbf2 = db2.getDatabaseFactory();
        Query q2 = dbf2.createQuery();
        System.out.println(q2.getClass());
    }
}
