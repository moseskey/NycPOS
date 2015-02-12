package com.openbravo.pos.epm;

public class EmployeeInfoExt extends EmployeeInfo {

    protected boolean visible;

    public EmployeeInfoExt(String id) {
        super(id);
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
