package com.openbravo.data.loader;

import java.util.MissingResourceException;
import com.openbravo.beans.LocaleResources;

public class LocalRes {

    // private static ResourceBundle m_Intl;
    private static final LocaleResources m_resources;

    static {
        m_resources = new LocaleResources();
        m_resources.addBundleName("data_messages");
    }

    /**
     * Creates a new instance of LocalRes */
    private LocalRes() {
    }

    public static String getIntString(String sKey) {
        return m_resources.getString(sKey);
    }
}
