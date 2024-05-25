package DESIGN_PATTERNS.Creational.Factory.PracticalFactory;

import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.Query;

public interface DatabaseFactory {
    Query createQuery();
}
