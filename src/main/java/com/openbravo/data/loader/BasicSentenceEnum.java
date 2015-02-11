package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class BasicSentenceEnum implements SentenceEnum {

    BaseSentence sent;
    DataResultSet SRS;

    /**
     * Creates a new instance of AbstractSentenceEnum
     * @param sent */
    public BasicSentenceEnum(BaseSentence sent) {
        this.sent = sent;
        this.SRS = null;
    }

    /**
     *
     * @throws BasicException
     */
    public void load() throws BasicException {
        load(null);
    }

    /**
     *
     * @throws BasicException
     */
    public void load(Object params) throws BasicException {
        SRS = sent.openExec(params);
    }

    /**
     *
     * @throws BasicException
     */
    public Object getCurrent() throws BasicException {
        if (SRS == null) {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        return SRS.getCurrent();
    }

    /**
     *
     * @throws BasicException
     */
    public boolean next() throws BasicException {
        if (SRS == null) {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        if (SRS.next()) {
            return true;
        } else {
            SRS.close();
            SRS = null;
            sent.closeExec();
            return false;
        }
    }
}
