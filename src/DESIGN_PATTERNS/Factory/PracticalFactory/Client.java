package DESIGN_PATTERNS.Factory.PracticalFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public class Client {
    public static void main(String[] args) {
        //create a MySQL db
        Database db = DatabasePracticalFactory.getDatabaseInstance("MySQL");
        DatabaseFactory dbf = db.getDatabaseFactory();
        Query q = dbf.createQuery();
        System.out.println(q.getClass());

        //create a Mongo db
        Database db2 = DatabasePracticalFactory.getDatabaseInstance("Mongo");
        DatabaseFactory dbf2 = db2.getDatabaseFactory();
        Query q2 = dbf2.createQuery();
        System.out.println(q2.getClass());
    }
}
