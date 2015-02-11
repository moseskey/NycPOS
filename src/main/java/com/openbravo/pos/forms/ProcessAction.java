package com.openbravo.pos.forms;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.MessageInf;

public interface ProcessAction {

    /**
     *
     * @throws BasicException
     */
    public MessageInf execute() throws BasicException;
}
