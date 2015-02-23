package com.openbravo.pos.forms;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Creation and Editing of stored settings
 * unicentaopos.properties
 */
public class AppConfig implements AppProperties {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private static AppConfig m_instance = null;
    private Properties m_propsConfig;
    private File m_propFile;

    public AppConfig(File propFile) {
        this.m_propFile = propFile;

        m_propsConfig = new Properties();
        logger.info("Using configuration file: {}", m_propFile.getAbsolutePath());
    }

    public AppConfig(String propertyFile) {
        this(new File(propertyFile));
    }

    public AppConfig(String[] args) {
        this(new File(args.length == 1 ? args[0] : "nycpos.properties"));
    }

    /**
     *
     * @return keypair from .properties filename
     */
    @Override
    public String getProperty(String sKey) {
        return m_propsConfig.getProperty(sKey);
    }

    /**
     * @return Machine name
     */
    @Override
    public String getHost() {
        return getProperty("machine.hostname");
    }

    /**
     * @return .properties filename
     */
    @Override
    public File getConfigFile() {
        return m_propFile;
    }

    /**
     * Update .properties resource keypair values
     */
    public void setProperty(String sKey, String sValue) {
        if (sValue == null) {
            m_propsConfig.remove(sKey);
        } else {
            m_propsConfig.setProperty(sKey, sValue);
        }
    }

    /**
     * Local machine identity
     * @return Machine name from OS
     */
    private String getLocalHostName() {
        try {
            return java.net.InetAddress.getLocalHost().getHostName();
        } catch (java.net.UnknownHostException eUH) {
            return "localhost";
        }
    }

    /**
     *
     * @return Delete .properties filename
     */
    public boolean delete() {
        loadDefault();
        return m_propFile.delete();
    }

    /**
     * Get instance settings
     * @Read .properties resource files
     */
    public void load() {
        loadDefault();

        try {
            InputStream in = new FileInputStream(m_propFile);
            if (in != null) {
                m_propsConfig.load(in);
                in.close();
            }
        } catch (IOException e) {
            logger.info("Could not load property file '{}}', using defaults instead", m_propFile.getAbsolutePath());
            loadDefault();
        }
    }

    /**
     * @return 0 or 00 number keypad boolean true/false
     */
    public Boolean isPriceWith00() {
        String prop = getProperty("pricewith00");
        if (prop == null) {
            return false;
        } else {
            return prop.equals("true");
        }
    }

    /**
     * Save values to .properties file
     */
    public void save() throws IOException {
        OutputStream out = new FileOutputStream(m_propFile);
        if (out != null) {
            m_propsConfig.store(out, AppLocal.APP_NAME + ". Configuration file.");
            out.close();
        }
    }

    /**
     * Settings over-rides
     */
    private void loadDefault() {
        m_propsConfig = new Properties();

        String dirname = System.getProperty("dirname.path");
        dirname = dirname == null ? "./" : dirname;

//        m_propsConfig.setProperty("db.driverlib", new File(new File(dirname), "lib/derby.jar").getAbsolutePath());
//        m_propsConfig.setProperty("db.driver", "org.apache.derby.jdbc.EmbeddedDriver");
//        m_propsConfig.setProperty("db.URL", "jdbc:derby:" + new File(new File(System.getProperty("user.home")), AppLocal.APP_ID + "-database").getAbsolutePath() + ";create=true");
//        m_propsConfig.setProperty("db.user", "");
//        m_propsConfig.setProperty("db.password", "");

//        m_propsConfig.setProperty("db.driverlib", new File(new File(dirname), "lib/hsqldb.jar").getAbsolutePath());
//        m_propsConfig.setProperty("db.driver", "org.hsqldb.jdbcDriver");
//        m_propsConfig.setProperty("db.URL", "jdbc:hsqldb:file:" + new File(new File(System.getProperty("user.home")), AppLocal.APP_ID + "-db").getAbsolutePath() + ";shutdown=true");
//        m_propsConfig.setProperty("db.user", "SA");
//        m_propsConfig.setProperty("db.password", "");

//        m_propsConfig.setProperty("db.driver", "com.mysql.jdbc.Driver");
//        m_propsConfig.setProperty("db.URL", "jdbc:mysql://localhost:3306/database");
//        m_propsConfig.setProperty("db.user", "user");
//        m_propsConfig.setProperty("db.password", "password");

        m_propsConfig.setProperty("db.driver", "org.postgresql.Driver");
        m_propsConfig.setProperty("db.URL", "jdbc:postgresql://localhost:5432/database");
        m_propsConfig.setProperty("db.user", "user");
        m_propsConfig.setProperty("db.password", "password");

        /**
         *
         * Default component settings
         */
        m_propsConfig.setProperty("machine.hostname", getLocalHostName());

        Locale l = Locale.getDefault();
        m_propsConfig.setProperty("user.language", l.getLanguage());
        m_propsConfig.setProperty("user.country", l.getCountry());
        m_propsConfig.setProperty("user.variant", l.getVariant());

        m_propsConfig.setProperty("swing.defaultlaf", System.getProperty("swing.defaultlaf", "javax.swing.plaf.metal.MetalLookAndFeel"));
//        m_propsConfig.setProperty("swing.defaultlaf", System.getProperty("swing.defaultlaf", "javax.swing.plaf.synth.SynthLookAndFeel"));

        m_propsConfig.setProperty("machine.printer", "screen");
        m_propsConfig.setProperty("machine.printer.2", "Not defined");
        m_propsConfig.setProperty("machine.printer.3", "Not defined");
        m_propsConfig.setProperty("machine.printer.4", "Not defined");
        m_propsConfig.setProperty("machine.printer.5", "Not defined");
        m_propsConfig.setProperty("machine.printer.6", "Not defined");

        m_propsConfig.setProperty("machine.display", "screen");
        m_propsConfig.setProperty("machine.scale", "Not defined");
        m_propsConfig.setProperty("machine.screenmode", "window"); // fullscreen / window
        m_propsConfig.setProperty("machine.ticketsbag", "standard");
        m_propsConfig.setProperty("machine.scanner", "Not defined");

        m_propsConfig.setProperty("payment.gateway", "external");
        m_propsConfig.setProperty("payment.magcardreader", "Not defined");
        m_propsConfig.setProperty("payment.testmode", "false");
        m_propsConfig.setProperty("payment.commerceid", "");
        m_propsConfig.setProperty("payment.commercepassword", "password");

        m_propsConfig.setProperty("machine.printername", "(Default)");

        // Receipt printer paper set to 72mmx200mm

// JG 7 May 14 Epson ESC/POS settings
        m_propsConfig.setProperty("paper.receipt.x", "10");
        m_propsConfig.setProperty("paper.receipt.y", "10");
// JG 7 May 14 Star Micronics settings
//        m_propsConfig.setProperty("paper.receipt.x", "10");
//        m_propsConfig.setProperty("paper.receipt.y", "287");
        m_propsConfig.setProperty("paper.receipt.width", "190");
        m_propsConfig.setProperty("paper.receipt.height", "546");
        m_propsConfig.setProperty("paper.receipt.mediasizename", "A4");

        // Normal printer paper for A4
        m_propsConfig.setProperty("paper.standard.x", "72");
        m_propsConfig.setProperty("paper.standard.y", "72");
        m_propsConfig.setProperty("paper.standard.width", "451");
        m_propsConfig.setProperty("paper.standard.height", "698");
        m_propsConfig.setProperty("paper.standard.mediasizename", "A4");

        m_propsConfig.setProperty("machine.uniqueinstance", "false");

//JG July 2014 - Thank you Ron Isaacson On-screen receipt defauls to 42 columns
        m_propsConfig.setProperty("screen.receipt.columns", "42");
    }
}
