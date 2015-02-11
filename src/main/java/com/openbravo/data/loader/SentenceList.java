package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.List;

public interface SentenceList {

    /**
     *
     * @throws BasicException
     */
    public List list() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public List list(Object... params) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public List list(Object params) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public List listPage(int offset, int length) throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public List listPage(Object params, int offset, int length) throws BasicException;
}
