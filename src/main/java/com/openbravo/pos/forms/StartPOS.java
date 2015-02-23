package com.openbravo.pos.forms;

import com.openbravo.format.Formats;
import com.openbravo.pos.instance.InstanceQuery;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import org.pushingpixels.substance.api.SubstanceSkin;
import com.openbravo.pos.ticket.TicketInfo;

public class StartPOS {
    private static final Logger logger = LoggerFactory.getLogger(StartPOS.class);

    private StartPOS() {
    }

    public static boolean registerApp() {
        // check if there is another instance running
        InstanceQuery i = null;
        try {
            i = new InstanceQuery();
            i.getAppMessage().restoreWindow();
            return false;
// JG 6 May 2013 to Multicatch
        } catch (RemoteException | NotBoundException e) {
            return true;
        }
    }

    public static void main(final String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (!registerApp()) {
                    System.exit(1);
                }

                AppConfig config = new AppConfig(args);
                config.load();

                // set Locale.
                String slang = config.getProperty("user.language");
                String scountry = config.getProperty("user.country");
                String svariant = config.getProperty("user.variant");
                if (slang != null && !slang.equals("") && scountry != null && svariant != null) {
                    Locale.setDefault(new Locale(slang, scountry, svariant));
                }

                // Set the format patterns
                Formats.setIntegerPattern(config.getProperty("format.integer"));
                Formats.setDoublePattern(config.getProperty("format.double"));
                Formats.setCurrencyPattern(config.getProperty("format.currency"));
                Formats.setPercentPattern(config.getProperty("format.percent"));
                Formats.setDatePattern(config.getProperty("format.date"));
                Formats.setTimePattern(config.getProperty("format.time"));
                Formats.setDateTimePattern(config.getProperty("format.datetime"));

                // Set the look and feel.
                try {
                    Object laf = Class.forName(config.getProperty("swing.defaultlaf")).newInstance();
                    if (laf instanceof LookAndFeel) {
                        UIManager.setLookAndFeel((LookAndFeel) laf);
                    } else if (laf instanceof SubstanceSkin) {
                        SubstanceLookAndFeel.setSkin((SubstanceSkin) laf);
                    }
// JG 6 May 2013 to multicatch
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                             UnsupportedLookAndFeelException e) {
                    logger.debug("Cannot set Look and Feel", e);
                }
// JG July 2014 Hostname for Tickets
                String hostname = config.getProperty("machine.hostname");
                TicketInfo.setHostname(hostname);

                String screenmode = config.getProperty("machine.screenmode");
                if ("fullscreen".equals(screenmode)) {
                    JRootKiosk rootkiosk = new JRootKiosk();
                    rootkiosk.initFrame(config);
                } else {
                    JRootFrame rootframe = new JRootFrame();
                    rootframe.initFrame(config);
                }
            }
        });
    }
}
