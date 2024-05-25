package DESIGN_PATTERNS.Creational.Factory.AbstractFactory;

import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.MongoQuery;
import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.Query;

public class MongoFactory implements DatabaseFactory{
    @Override
    public Query createQuery() {
        return new MongoQuery();
    }
}
