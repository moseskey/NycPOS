package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class SequenceForMySQL extends BaseSentence {

    private BaseSentence sent1;
    private BaseSentence sent2;

    public SequenceForMySQL(Session s, String sSeqTable) {

        sent1 = new StaticSentence(s, "UPDATE " + sSeqTable + " SET ID = LAST_INSERT_ID(ID + 1)");
        sent2 = new StaticSentence(s, "SELECT LAST_INSERT_ID()", null, SerializerReadInteger.INSTANCE);
    }

    // Funciones de bajo nivel

        public DataResultSet openExec(Object params) throws BasicException {
        sent1.exec();
        return sent2.openExec(null);
    }

    public DataResultSet moreResults() throws BasicException {
        return sent2.moreResults();
    }

    public void closeExec() throws BasicException {
        sent2.closeExec();
    }
}
