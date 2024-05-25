package DESIGN_PATTERNS.Factory.PracticalFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public interface DatabaseFactory {
    Query createQuery();
}
