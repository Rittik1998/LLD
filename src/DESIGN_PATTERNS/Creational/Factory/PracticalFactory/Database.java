package DESIGN_PATTERNS.Creational.Factory.PracticalFactory;

public interface Database {
    void connect();
    void setUrl();
    DatabaseFactory getDatabaseFactory();
}
