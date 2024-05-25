package DESIGN_PATTERNS.Structural.Adapter;


import DESIGN_PATTERNS.Structural.Adapter.thirdParty.JuspayPG;

public class JuspayPGAdapter implements PGAdapter{
    private JuspayPG juspayPG = new JuspayPG();

    @Override
    public void initiate(String orderNumber) {
        juspayPG.initiatePayment(orderNumber);
    }
}
