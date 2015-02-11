package com.openbravo.beans;

import java.awt.Component;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

public class JNumberDialog extends javax.swing.JDialog {

    private static LocaleResources m_resources;

    private Double m_value;

    /**
     * Creates new form JNumberDialog
     */
    public JNumberDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        init();
    }

    /**
     * Creates new form JNumberDialog
     */
    public JNumberDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        init();
    }

    private void init() {

        if (m_resources == null) {
            m_resources = new LocaleResources();
            m_resources.addBundleName("beans_messages");
        }

        initComponents();
        getRootPane().setDefaultButton(jcmdOK);

        m_jnumber.addEditorKeys(m_jKeys);
        m_jnumber.reset();
        m_jnumber.setDoubleValue(0.0);
        m_jnumber.activate();

        m_jPanelTitle.setBorder(RoundedBorder.createGradientBorder());

        m_value = null;
    }

    private void setTitle(String title, String message, Icon icon) {
        setTitle(title);
        m_lblMessage.setText(message);
        m_lblMessage.setIcon(icon);
    }

    public static Double showEditNumber(Component parent, String title) {
        return showEditNumber(parent, title, null, null);
    }

    public static Double showEditNumber(Component parent, String title, String message) {
        return showEditNumber(parent, title, message, null);
    }

    public static Double showEditNumber(Component parent, String title, String message, Icon icon) {

        Window window = SwingUtilities.windowForComponent(parent);

        JNumberDialog myMsg;
        if (window instanceof Frame) {
            myMsg = new JNumberDialog((Frame) window, true);
        } else {
            myMsg = new JNumberDialog((Dialog) window, true);
        }

        myMsg.setTitle(title, message, icon);
        myMsg.setVisible(true);
        return myMsg.m_value;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcmdOK = new javax.swing.JButton();
        jcmdCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanelGrid = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        m_jKeys = new com.openbravo.editor.JEditorKeys();
        jPanel4 = new javax.swing.JPanel();
        m_jnumber = new com.openbravo.editor.JEditorDoublePositive();
        m_jPanelTitle = new javax.swing.JPanel();
        m_lblMessage = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jcmdOK.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdOK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ok.png"))); // NOI18N
        jcmdOK.setText(m_resources.getString("button.ok")); // NOI18N
        jcmdOK.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdOKActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdOK);

        jcmdCancel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jcmdCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        jcmdCancel.setText(m_resources.getString("button.cancel")); // NOI18N
        jcmdCancel.setMargin(new java.awt.Insets(8, 16, 8, 16));
        jcmdCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcmdCancelActionPerformed(evt);
            }
        });
        jPanel1.add(jcmdCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        m_jKeys.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jKeysActionPerformed(evt);
            }
        });
        jPanel3.add(m_jKeys);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setLayout(new java.awt.BorderLayout());

        m_jnumber.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel4.add(m_jnumber, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel4);

        jPanelGrid.add(jPanel3);

        jPanel2.add(jPanelGrid, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        m_jPanelTitle.setLayout(new java.awt.BorderLayout());

        m_lblMessage.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, java.awt.Color.darkGray), javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        m_jPanelTitle.add(m_lblMessage, java.awt.BorderLayout.CENTER);

        getContentPane().add(m_jPanelTitle, java.awt.BorderLayout.NORTH);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-253)/2, (screenSize.height-433)/2, 253, 433);
    }// </editor-fold>//GEN-END:initComponents

    private void jcmdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdOKActionPerformed


        m_value = m_jnumber.getDoubleValue();
        setVisible(false);
        dispose();


    }//GEN-LAST:event_jcmdOKActionPerformed

    private void jcmdCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcmdCancelActionPerformed

        setVisible(false);
        dispose();

    }//GEN-LAST:event_jcmdCancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        setVisible(false);
        dispose();

    }//GEN-LAST:event_formWindowClosing

    private void m_jKeysActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jKeysActionPerformed

    }//GEN-LAST:event_m_jKeysActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JButton jcmdCancel;
    private javax.swing.JButton jcmdOK;
    private com.openbravo.editor.JEditorKeys m_jKeys;
    private javax.swing.JPanel m_jPanelTitle;
    private com.openbravo.editor.JEditorDoublePositive m_jnumber;
    private javax.swing.JLabel m_lblMessage;
    // End of variables declaration//GEN-END:variables

}
