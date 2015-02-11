package com.openbravo.pos.payment;

public class PaymentInfoFree extends PaymentInfo {

    private double m_dTotal;
    private double m_dTendered;
    private String m_dCardName =null;

    /**
     * Creates a new instance of PaymentInfoFree
     */
    public PaymentInfoFree(double dTotal) {
        m_dTotal = dTotal;
    }

    @Override
    public PaymentInfo copyPayment(){
        return new PaymentInfoFree(m_dTotal);
    }

    @Override
    public String getTransactionID(){
        return "no ID";
    }

    @Override
    public String getName() {
        return "free";
    }

    @Override
    public double getTotal() {
        return m_dTotal;
    }

    @Override
    public double getPaid() {
        return (0.0);
    }

    @Override
    public double getChange(){
       return (0.00);
   }

    @Override
    public double getTendered() {
       return m_dTendered;
   }

    @Override
    public String getCardName() {
       return m_dCardName;
   }

}
