package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public class BasicSentenceEnum implements SentenceEnum {

    BaseSentence sent;
    DataResultSet SRS;

    public BasicSentenceEnum(BaseSentence sent) {
        this.sent = sent;
        this.SRS = null;
    }

    public void load() throws BasicException {
        load(null);
    }

    public void load(Object params) throws BasicException {
        SRS = sent.openExec(params);
    }

    public Object getCurrent() throws BasicException {
        if (SRS == null) {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        return SRS.getCurrent();
    }

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
