package com.openbravo.pos.util;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class ReportUtils {

    private ReportUtils() {
    }

    public static PrintService getPrintService(String printername) {

        // Initalize print service

        if (printername == null) {
            return PrintServiceLookup.lookupDefaultPrintService();
        } else {

            if ("(Show dialog)".equals(printername)) {
                return null; // null means "you have to show the print dialog"
            } else if ("(Default)".equals(printername)) {
                return PrintServiceLookup.lookupDefaultPrintService();
            } else {
                PrintService[] pservices =
                        PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE , null);
                for (PrintService s : pservices) {
                    if (printername.equals(s.getName())) {
                        return s;
                    }
                }
                return PrintServiceLookup.lookupDefaultPrintService();
            }
        }
    }

    public static String[] getPrintNames() {
        PrintService[] pservices =
                PrintServiceLookup.lookupPrintServices(DocFlavor.SERVICE_FORMATTED.PRINTABLE , null);

        String printers[] = new String[pservices.length];
        for (int i = 0; i < pservices.length; i++) {
            printers[i] = pservices[i].getName();
        }

        return printers;
    }

}
