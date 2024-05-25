package DESIGN_PATTERNS.Factory.AbstractFactory;

import DESIGN_PATTERNS.Factory.FactroryMethod.Query;

public interface DatabaseFactory {
    Query createQuery();
}
