package com.openbravo.pos.util;

import javax.swing.*;
import java.awt.event.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// this is a dialog that will dispose of itself after a given amount of time
public class Test extends JDialog {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    private int lifeTime = 0;

// if lifeTime is set to zero, this behaves like a normal dialog
    public void setLifeTime(int millis) {
        lifeTime = millis;
    }

    public void setVisible(boolean b) {
        logger.info("setVisible(" + b + ")");
        super.setVisible(b);
        if (b && lifeTime != 0) {
            Action disposeAction = new AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    logger.info("disposing");
                    dispose();
                }
            };
            Timer t = new Timer(lifeTime, disposeAction);
            t.setRepeats(false);
            t.start();
        }
    }
}

