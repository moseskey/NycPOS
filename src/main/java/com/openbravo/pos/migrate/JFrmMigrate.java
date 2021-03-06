package com.openbravo.pos.migrate;

import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppProperties;
import com.openbravo.pos.forms.JRootFrame;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JFrmMigrate extends javax.swing.JFrame {

    private JPaneldbMigrate config;

    public JFrmMigrate(AppProperties props) {
        initComponents();

        try {
            this.setIconImage(ImageIO.read(JRootFrame.class.getResourceAsStream("/images/favicon.png")));
        } catch (IOException e) {
        }
        setTitle(AppLocal.APP_NAME + " - " + AppLocal.APP_VERSION + " - " +
                 AppLocal.getIntString("Menu.Configuration"));

        addWindowListener(new MyFrameListener());

        config = new JPaneldbMigrate(props);

        getContentPane().add(config, BorderLayout.CENTER);

        try {
            config.activate();
        } catch (BasicException e) { // never thrown ;-)
        }
    }

    private class MyFrameListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent evt) {
            if (config.deactivate()) {
                dispose();
            }
        }
        @Override
        public void windowClosed(WindowEvent evt) {
            System.exit(0);
        }
    }
    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width - 702) / 2, (screenSize.height - 325) / 2, 702, 325);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(final String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                AppConfig config = new AppConfig(args);
                config.load();

// Set the look and feel.
// JG 6 May 2013 to Multicatch
                //   try {
                //     UIManager.setLookAndFeel(config.getProperty("swing.defaultlaf"));
                // } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                // }

                new JFrmMigrate(config).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
