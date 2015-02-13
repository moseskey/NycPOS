package com.openbravo.data.loader;

public class SessionDBHSQLDB implements SessionDB {

    @Override
    public String TRUE() {
        return "TRUE";
    }

    @Override
    public String FALSE() {
        return "FALSE";
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
        return "HSQLDB";
    }

    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null,
                                  SerializerReadInteger.INSTANCE);
    }

    @Override
    public SentenceFind resetSequenceSentence(Session s, String sequence) {
        return new StaticSentence(s, "CALL NEXT VALUE FOR " + sequence, null,
                                  SerializerReadInteger.INSTANCE);
    }
}
