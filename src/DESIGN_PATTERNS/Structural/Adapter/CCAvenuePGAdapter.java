package DESIGN_PATTERNS.Structural.Adapter;


import DESIGN_PATTERNS.Structural.Adapter.thirdParty.CCAvenuePG;

import java.util.UUID;

public class CCAvenuePGAdapter implements PGAdapter{
    private CCAvenuePG ccAvenuePG = new CCAvenuePG();

    @Override
    public void initiate(String orderNumber) {
        ccAvenuePG.startPayment(UUID.fromString(orderNumber));
    }
}
