package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.util.Date;

public abstract class DataParams implements DataWrite {

    protected DataWrite dw;

    public abstract void writeValues() throws BasicException;

    public void setInt(int paramIndex, Integer iValue) throws BasicException {
        dw.setInt(paramIndex, iValue);
    }

    public void setString(int paramIndex, String sValue) throws BasicException {
        dw.setString(paramIndex, sValue);
    }

    public void setDouble(int paramIndex, Double dValue) throws BasicException {
        dw.setDouble(paramIndex, dValue);
    }

    public void setBoolean(int paramIndex, Boolean bValue) throws BasicException {
        dw.setBoolean(paramIndex, bValue);
    }

    public void setTimestamp(int paramIndex, Date dValue) throws BasicException {
        dw.setTimestamp(paramIndex, dValue);
    }

    public void setBytes(int paramIndex, byte[] value) throws BasicException {
        dw.setBytes(paramIndex, value);
    }

    public void setObject(int paramIndex, Object value) throws BasicException {
        dw.setObject(paramIndex, value);
    }

    public DataWrite getDataWrite() {
        return dw;
    }

    public void setDataWrite(DataWrite dw) {
        this.dw = dw;
    }
}
