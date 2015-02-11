package com.openbravo.pos.inventory;

import com.openbravo.data.loader.IKeyed;

public class AttributeSetInfo implements IKeyed {

    private String id;
    private String name;

    public AttributeSetInfo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Object getKey() {
        return id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
