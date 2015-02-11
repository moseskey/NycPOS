package com.openbravo.data.loader;

import java.io.Reader;
import com.openbravo.basic.BasicException;

public class BatchSentenceScript extends BatchSentence {

    private String m_sScript;

    /**
     * Creates a new instance of BatchSentenceScript
     */
    public BatchSentenceScript(Session s, String script) {
        super(s);
        m_sScript = script;
    }

    /**
     *
     * @throws BasicException
     */
    protected Reader getReader() throws BasicException {

        return new java.io.StringReader(m_sScript);
    }
}
