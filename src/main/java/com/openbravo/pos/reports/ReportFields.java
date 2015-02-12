package com.openbravo.pos.reports;

public interface ReportFields {

    public Object getField(Object record, String field) throws ReportException;
}
