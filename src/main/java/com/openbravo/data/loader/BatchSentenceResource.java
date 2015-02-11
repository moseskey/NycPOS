package com.openbravo.data.loader;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import com.openbravo.basic.BasicException;
import java.io.UnsupportedEncodingException;

public class BatchSentenceResource extends BatchSentence {

    private String m_sResScript;

    /**
     * Creates a new instance of BatchSentenceResource
     * @param resscript */
    public BatchSentenceResource(Session s, String resscript) {
        super(s);
        m_sResScript = resscript;
    }

    /**
     *
     * @throws BasicException
     */
    protected Reader getReader() throws BasicException {

        InputStream in = BatchSentenceResource.class.getResourceAsStream(m_sResScript);

        if (in == null) {
            throw new BasicException(LocalRes.getIntString("exception.nosentencesfile"));
        } else {
            try {
                return new InputStreamReader(in, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                throw new BasicException(LocalRes.getIntString("exception.nosentencesfile"), ex);
            }
        }
    }
}
