package DESIGN_PATTERNS.Factory.PracticalFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.MongoQuery;
import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public class MongoFactory implements DatabaseFactory {
    @Override
    public Query createQuery() {
        return new MongoQuery();
    }
}
