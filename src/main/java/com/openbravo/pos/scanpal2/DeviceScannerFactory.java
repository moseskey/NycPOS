package com.openbravo.pos.scanpal2;

import com.openbravo.pos.forms.AppProperties;
import com.openbravo.pos.util.StringParser;

public class DeviceScannerFactory {

    /**
     * Creates a new instance of DeviceScannerFactory */
    private DeviceScannerFactory() {
    }

    public static DeviceScanner createInstance(AppProperties props) {

        StringParser sd = new StringParser(props.getProperty("machine.scanner"));
        String sScannerType = sd.nextToken(':');
        String sScannerParam1 = sd.nextToken(',');
        // String sScannerParam2 = sd.nextToken(',');

        if ("scanpal2".equals(sScannerType)) {
            return new DeviceScannerComm(sScannerParam1);
        } else {
            return null;
        }
    }
}
