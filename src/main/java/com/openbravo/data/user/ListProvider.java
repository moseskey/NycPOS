package com.openbravo.data.user;

import com.openbravo.basic.BasicException;
import java.util.List;

public interface ListProvider {

    /**
     *
     * @throws BasicException
     */
    public List loadData() throws BasicException;

    /**
     *
     * @throws BasicException
     */
    public List refreshData() throws BasicException;
}
