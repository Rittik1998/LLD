package DESIGN_PATTERNS.Structural.Adapter;

import DESIGN_PATTERNS.Structural.Adapter.thirdParty.RazorpayPG;

public class RazorpayPGAdapter implements PGAdapter{
    private RazorpayPG razorpayPG = new RazorpayPG();

    @Override
    public void initiate(String orderNumber) {
        razorpayPG.beginPayment(orderNumber);
    }
}
