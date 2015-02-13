package com.openbravo.data.loader;

public abstract class QBFCompareEnum {

    public final static QBFCompareEnum COMP_NONE = new QBFCompareEnum(0, "qbf.none") {
        public String getExpression(String sField, String sSQLValue) { return null; }
    };

    public final static QBFCompareEnum COMP_ISNULL = new QBFCompareEnum(1, "qbf.null") {
        public String getExpression(String sField, String sSQLValue) { return sField + " IS NULL"; }
    };

    public final static QBFCompareEnum COMP_ISNOTNULL = new QBFCompareEnum(2, "qbf.notnull") {
        public String getExpression(String sField, String sSQLValue) { return sField + " IS NOT NULL"; }
    };

    public final static QBFCompareEnum COMP_RE = new QBFCompareEnum(3, "qbf.re") {
        public String getExpression(String sField, String sSQLValue) { return sField + " LIKE " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_EQUALS = new QBFCompareEnum(3, "qbf.equals") {
        public String getExpression(String sField, String sSQLValue) { return sField + " = " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_DISTINCT = new QBFCompareEnum(4, "qbf.distinct") {
        public String getExpression(String sField, String sSQLValue) { return sField + " <> " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_GREATER = new QBFCompareEnum(5, "qbf.greater") {
        public String getExpression(String sField, String sSQLValue) { return sField + " > " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_LESS = new QBFCompareEnum(6, "qbf.less") {
        public String getExpression(String sField, String sSQLValue) { return sField + " < " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_GREATEROREQUALS = new QBFCompareEnum(7,
    "qbf.greaterequals") {
        public String getExpression(String sField, String sSQLValue) { return sField + " >= " + sSQLValue; }
    };

    public final static QBFCompareEnum COMP_LESSOREQUALS = new QBFCompareEnum(8, "qbf.lessequals") {
        public String getExpression(String sField, String sSQLValue) { return sField + " <= " + sSQLValue; }
    };
//    public final static QBFCompareEnum COMP_STARTSWITH = new QBFCompareEnum(9, "qbf.startswith") {
//        public String getExpression(String sField, String sSQLValue) { return sField + " LIKE " ... + sSQLValue; }
//    };
//    public final static int COMP_ENDSWITH = 12;
//    public final static int COMP_CONTAINS = 13;

    private int m_iValue;
    private String m_sKey;

    private QBFCompareEnum(int iValue, String sKey) {
        m_iValue = iValue;
        m_sKey = sKey;
    }

    public int getCompareInt() {
        return m_iValue;
    }
    public String toString() {
        return LocalRes.getIntString(m_sKey);
    }

    public abstract String getExpression(String sField, String sSQLValue);
}
