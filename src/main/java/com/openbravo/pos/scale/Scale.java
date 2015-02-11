package com.openbravo.pos.scale;

public interface Scale {

    /**
     *
     * @throws ScaleException
     */
    public Double readWeight() throws ScaleException;
}
