package com.openbravo.pos.sales;

import com.openbravo.pos.ticket.TaxInfo;
import java.util.ArrayList;
import java.util.List;

public class TaxesLogicElement {

    private TaxInfo tax;
    private List<TaxesLogicElement> taxsons;

    public TaxesLogicElement(TaxInfo tax) {
        this.tax = tax;
        // JG June 2013 use diamond inference
        this.taxsons = new ArrayList<>();
    }

    public TaxInfo getTax() {
        return tax;
    }

    public List<TaxesLogicElement> getSons() {
        return taxsons;
    }
}
