package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;

public interface DataRead {

    public Integer getInt(int columnIndex) throws BasicException;

    public String getString(int columnIndex) throws BasicException;

    public Double getDouble(int columnIndex) throws BasicException;

    public Boolean getBoolean(int columnIndex) throws BasicException;

    public java.util.Date getTimestamp(int columnIndex) throws BasicException;

    //public java.io.InputStream getBinaryStream(int columnIndex) throws DataException;

        public byte[] getBytes(int columnIndex) throws BasicException;

    public Object getObject(int columnIndex) throws BasicException ;

//    public int getColumnCount() throws DataException;

        public DataField[] getDataField() throws BasicException;
}
