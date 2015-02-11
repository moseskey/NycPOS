package com.openbravo.pos.panels;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIter implements Enumeration {

    private Iterator i;

    public EnumerationIter(Iterator i) {
        this.i = i;
    }
    @Override
    public boolean hasMoreElements() {
        return i.hasNext();
    }
    @Override
    public Object nextElement() {
        return i.next();
    }
}
