package DESIGN_PATTERNS.Factory.AbstractFactory;

public class MongoDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("Connecting to MongoDB");
    }

    @Override
    public void setUrl() {
        System.out.println("Setting url of MongoDB");
    }

    @Override
    public DatabaseFactory getDatabaseFactory() {
        return new MongoFactory();
    }
}
