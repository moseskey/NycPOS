package com.openbravo.pos.ticket;

import com.openbravo.data.loader.IKeyed;
import java.io.Serializable;

public class TaxInfo implements Serializable, IKeyed {

    private static final long serialVersionUID = -2705212098856473043L;
    private String id;
    private String name;
    private String taxcategoryid;
    private String taxcustcategoryid;
    private String parentid;

    private double rate;
    private boolean cascade;
    private Integer order;

    public TaxInfo(String id, String name, String taxcategoryid, String taxcustcategoryid, String parentid, double rate, boolean cascade, Integer order) {
        this.id = id;
        this.name = name;
        this.taxcategoryid = taxcategoryid;
        this.taxcustcategoryid = taxcustcategoryid;
        this.parentid = parentid;

        this.rate = rate;
        this.cascade = cascade;
        this.order = order;
    }

    public Object getKey() {
        return id;
    }

    public void setID(String value) {
        id = value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getTaxCategoryID() {
        return taxcategoryid;
    }

    public void setTaxCategoryID(String value) {
        taxcategoryid = value;
    }

    public String getTaxCustCategoryID() {
        return taxcustcategoryid;
    }

    public void setTaxCustCategoryID(String value) {
        taxcustcategoryid = value;
    }

    public String getParentID() {
        return parentid;
    }

    public void setParentID(String value) {
        parentid = value;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double value) {
        rate = value;
    }

    public boolean isCascade() {
        return cascade;
    }

    public void setCascade(boolean value) {
        cascade = value;
    }

    public Integer getOrder() {
        return order;
    }

    public Integer getApplicationOrder() {
        return order == null ? Integer.MAX_VALUE : order.intValue();
    }

    public void setOrder(Integer value) {
        order = value;
    }

    @Override
    public String toString(){
        return name;
    }
}
