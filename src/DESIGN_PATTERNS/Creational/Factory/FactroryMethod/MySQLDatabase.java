package DESIGN_PATTERNS.Creational.Factory.FactroryMethod;

public class MySQLDatabase implements Database{
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB");
    }

    @Override
    public void setUrl() {
        System.out.println("Setting url of MongoDB");
    }

    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }
}
