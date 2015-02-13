package com.openbravo.pos.customers;

import com.openbravo.data.user.BrowsableEditableData;

public class CustomerInfoGlobal {

    private static CustomerInfoGlobal INSTANCE;
    private CustomerInfoExt customerInfoExt;
    private BrowsableEditableData editableData;

    //Singleton class
    private CustomerInfoGlobal() {
    }

    //Singleton constructor

    public static CustomerInfoGlobal getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CustomerInfoGlobal();
        }

        return INSTANCE;
    }

    public CustomerInfoExt getCustomerInfoExt() {
        return customerInfoExt;
    }

    public void setCustomerInfoExt(CustomerInfoExt customerInfoExt) {
        this.customerInfoExt = customerInfoExt;
    }

    public BrowsableEditableData getEditableData() {
        return editableData;
    }

    public void setEditableData(BrowsableEditableData editableData) {
        this.editableData = editableData;
    }


}
