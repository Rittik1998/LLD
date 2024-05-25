package DESIGN_PATTERNS.Factory.FactroryMethod;

public interface Database {
    void connect();
    void setUrl();
    Query createQuery();
}
