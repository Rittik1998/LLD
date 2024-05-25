package DESIGN_PATTERNS.Creational.Singleton;

public class Database {

    private static Database obj = new Database();
    private Database(){}

    public static Database getObj() {
        return obj;
    }
}

//problems:
