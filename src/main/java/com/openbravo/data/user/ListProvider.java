package com.openbravo.data.user;

import com.openbravo.basic.BasicException;
import java.util.List;

public interface ListProvider {

    public List loadData() throws BasicException;

    public List refreshData() throws BasicException;
}
