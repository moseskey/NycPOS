package com.openbravo.pos.reports;

public interface ReportFields {

    /**
     *
     * @throws ReportException
     */
    public Object getField(Object record, String field) throws ReportException;
}
