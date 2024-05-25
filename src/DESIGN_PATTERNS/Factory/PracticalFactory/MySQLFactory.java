package DESIGN_PATTERNS.Factory.PracticalFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.MySQLQuery;
import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public class MySQLFactory implements DatabaseFactory {
    @Override
    public Query createQuery() {
        return new MySQLQuery();
    }
}
