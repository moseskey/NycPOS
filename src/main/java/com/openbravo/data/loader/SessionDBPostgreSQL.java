package com.openbravo.data.loader;

public class SessionDBPostgreSQL implements SessionDB {

    @Override
    public String TRUE() {
        return "True";
    }

    @Override
    public String FALSE() {
        return "False";
    }

    @Override
    public String INTEGER_NULL() {
        return "CAST(NULL AS INTEGER)";
    }

    @Override
    public String CHAR_NULL() {
        return "CAST(NULL AS CHAR)";
    }

    @Override
    public String getName() {
        return "PostgreSQL";
    }

    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "SELECT NEXTVAL('" + sequence + "')", null,
                                  SerializerReadInteger.INSTANCE);
    }

    @Override
    public SentenceFind resetSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "ALTER SEQUENCE " + sequence + " RESTART WITH '0'", null,
                                  SerializerReadInteger.INSTANCE);
    }
}
