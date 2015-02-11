package com.openbravo.data.loader;

public class SessionDBDerby implements SessionDB {

    @Override
    public String TRUE() {
        return "1";
    }

    @Override
    public String FALSE() {
        return "0";
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
        return "Derby";
    }

    @Override
    public SentenceFind getSequenceSentence(Session s, String sequence) {
        return new SequenceForDerby(s, sequence);
    }

    @Override
    public SentenceFind resetSequenceSentence(Session s, String sequence) {
        return new SequenceForDerby(s, sequence);
}
}
