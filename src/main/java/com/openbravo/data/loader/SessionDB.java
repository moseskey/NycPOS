package com.openbravo.data.loader;

public interface SessionDB {

    public String TRUE();

    public String FALSE();

    public String INTEGER_NULL();

    public String CHAR_NULL();

    public String getName();

    public SentenceFind getSequenceSentence(Session s, String sequence);

    public SentenceFind resetSequenceSentence(Session s, String sequence);

}


