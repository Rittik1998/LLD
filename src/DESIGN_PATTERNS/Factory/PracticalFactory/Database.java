package DESIGN_PATTERNS.Factory.PracticalFactory;

public interface Database {
    void connect();
    void setUrl();
    DatabaseFactory getDatabaseFactory();
}
