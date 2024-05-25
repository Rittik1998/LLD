package DESIGN_PATTERNS.Creational.Factory.AbstractFactory;

import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.MySQLQuery;
import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.Query;

public class MySQLFactory implements DatabaseFactory{
    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }
}
