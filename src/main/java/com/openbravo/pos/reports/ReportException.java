package com.openbravo.pos.reports;

public class ReportException extends Exception {

    public ReportException() {
    }

    public ReportException(String msg) {
        super(msg);
    }

    public ReportException(Exception e) {
        super(e);
    }
}
