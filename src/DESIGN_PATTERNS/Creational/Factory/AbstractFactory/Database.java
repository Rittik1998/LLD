package DESIGN_PATTERNS.Creational.Factory.AbstractFactory;

public interface Database {
    void connect();
    void setUrl();
    DatabaseFactory getDatabaseFactory();
}
