package com.openbravo.data.loader;

import java.util.Comparator;

public class ComparatorCreatorBasic implements ComparatorCreator {

    private String[] m_sHeaders;
    private Datas[] m_aDatas;
    private int[] m_iAvailableIndexes;

    public ComparatorCreatorBasic(String[] sHeaders, Datas[] aDatas, int[] iAvailableIndexes) {

        m_sHeaders = sHeaders;
        m_aDatas = aDatas;
        m_iAvailableIndexes = iAvailableIndexes;
    }

    public ComparatorCreatorBasic(String[] sHeaders, Datas[] aDatas) {
        m_sHeaders = sHeaders;
        m_aDatas = aDatas;
        m_iAvailableIndexes = new int[aDatas.length];
        for (int i = 0; i < aDatas.length; i++) {
            m_iAvailableIndexes[i] = i;
        }
    }

    public String[] getHeaders() {

        String[] sTempHeaders = new String[m_iAvailableIndexes.length];

        for (int i = 0; i < m_iAvailableIndexes.length; i++) {
            sTempHeaders[i] = m_sHeaders[m_iAvailableIndexes[i]];
        }
        return sTempHeaders;
    }

    public Comparator createComparator(int[] aiOrderBy) {
        return new ComparatorBasic(aiOrderBy);
    }

    public class ComparatorBasic implements Comparator {

        private int[] m_aiOrderBy;

        public ComparatorBasic(int[] aiOrderBy) {
            m_aiOrderBy = aiOrderBy;
        }
        public int compare(Object o1, Object o2) {
            if (o1 == null) {
                if (o2 == null) {
                    return 0;
                } else {
                    return -1;
                }
            } else if (o2 == null) {
                return +1;
            } else {
                // ninguno de los dos es nulo...
                Object[] ao1 = (Object[]) o1;
                Object[] ao2 = (Object[]) o2;
                for (int i = 0; i < m_aiOrderBy.length; i++) {
                    int result = m_aDatas[m_iAvailableIndexes[m_aiOrderBy[i]]].compare(ao1[m_iAvailableIndexes[m_aiOrderBy[i]]], ao2[m_iAvailableIndexes[m_aiOrderBy[i]]]);
                    if (result != 0) {
                        return result;
                    }
                }
                return 0;
            }
        }
    }
}
