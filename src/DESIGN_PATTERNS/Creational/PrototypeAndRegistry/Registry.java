package DESIGN_PATTERNS.Creational.PrototypeAndRegistry;

public interface Registry<T> {
    void register(String key, T obj);
    T getObj(String key);
}
