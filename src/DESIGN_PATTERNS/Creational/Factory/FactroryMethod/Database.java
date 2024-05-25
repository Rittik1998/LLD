package DESIGN_PATTERNS.Creational.Factory.FactroryMethod;

public interface Database {
    void connect();
    void setUrl();
    Query createQuery();
}
