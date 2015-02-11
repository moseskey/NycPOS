package com.openbravo.data.loader;

import java.util.Comparator;

public interface ComparatorCreator {

    public String[] getHeaders();

    public Comparator createComparator(int[] index);
}
