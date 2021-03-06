package com.openbravo.pos.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtils {
    private Properties m_propsconfig;
    private File configFile;
    private final String APP_ID = "upos-app";

    public PropertyUtils() {
        this.configFile = new File("unicentaopos.properties");

        // Load Properties
        try {
            InputStream in = new FileInputStream(configFile);
            if (in != null) {
                m_propsconfig = new Properties();
                m_propsconfig.load(in);
                in.close();
            }
        } catch (IOException e) {
        }
    }

    public String getProperty(String sKey) {
        return m_propsconfig.getProperty(sKey);
    }

    public String getDriverName() {
        return m_propsconfig.getProperty("db.driver");
    }

    public String getUrl() {
        return m_propsconfig.getProperty("db.url");
    }

    public String getDBUser() {
        return m_propsconfig.getProperty("db.user");
    }

    public String getDBPassword() {
        String m_password = "[color=#FF0000]YourDBPassword[/color]";
        return m_password;
    }
}
