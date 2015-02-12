package com.openbravo.data.loader;

import java.io.Reader;
import com.openbravo.basic.BasicException;

public class BatchSentenceScript extends BatchSentence {

    private String m_sScript;

    public BatchSentenceScript(Session s, String script) {
        super(s);
        m_sScript = script;
    }

    protected Reader getReader() throws BasicException {

        return new java.io.StringReader(m_sScript);
    }
}
