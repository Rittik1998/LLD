package DESIGN_PATTERNS.Creational.Factory.AbstractFactory;

import DESIGN_PATTERNS.Creational.Factory.FactroryMethod.Query;

public interface DatabaseFactory {
    Query createQuery();
}
