package com.openbravo.pos.epm;

import com.openbravo.pos.util.StringUtils;
import java.io.Serializable;

public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 9083257536541L;

    protected String id;

    protected String name;

    /**
     * Creates a new instance of EmployeeInfo
     * @param id
     */
    public EmployeeInfo(String id) {
        this.id = id;
        this.name = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String printName() {
        return StringUtils.encodeXML(name);
    }

    @Override
    public String toString() {
        return getName();
    }
}

