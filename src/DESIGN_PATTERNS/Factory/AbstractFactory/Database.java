package DESIGN_PATTERNS.Factory.AbstractFactory;

public interface Database {
    void connect();
    void setUrl();
    DatabaseFactory getDatabaseFactory();
}
