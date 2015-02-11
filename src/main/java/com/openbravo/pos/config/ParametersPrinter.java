package com.openbravo.pos.config;

import com.openbravo.data.user.DirtyManager;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.util.StringParser;
import java.awt.Component;

public class ParametersPrinter extends javax.swing.JPanel implements ParametersConfig {

    private String othersizename = "standard";

    /**
     * Creates new form ParametersPrinter
     */
    public ParametersPrinter(String [] printernames) {
        initComponents();

        jPrinters.addItem("(Default)");
        jPrinters.addItem("(Show dialog)");
        for (String name : printernames) {
            jPrinters.addItem(name);
        }
    }

    public Component getComponent() {
        return this;
    }

    public void addDirtyManager(DirtyManager dirty) {
        jPrinters.addActionListener(dirty);
        jReceiptPrinter.addActionListener(dirty);
    }

    public void setParameters(StringParser p) {
        jPrinters.setSelectedItem(p.nextToken(','));
        String sizename = p.nextToken(',');
        jReceiptPrinter.setSelected("receipt".equals(sizename));
        othersizename = "receipt".equals(sizename) ? "standard" : sizename;
    }

    public String getParameters() {
        return comboValue(jPrinters.getSelectedItem()) + "," + boolValue(jReceiptPrinter.isSelected());
    }

    private static String comboValue(Object value) {
        return value == null ? "" : value.toString();
    }

    private String boolValue(boolean value) {
        return value ? "receipt" : othersizename;
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPrinters = new javax.swing.JComboBox();
        jReceiptPrinter = new javax.swing.JCheckBox();

        jPrinters.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPrinters.setPreferredSize(new java.awt.Dimension(200, 23));
        jPrinters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPrintersActionPerformed(evt);
            }
        });

        jReceiptPrinter.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jReceiptPrinter.setSelected(true);
        jReceiptPrinter.setText(AppLocal.getIntString("label.receiptprinter")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jReceiptPrinter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jReceiptPrinter, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jPrintersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPrintersActionPerformed

    }//GEN-LAST:event_jPrintersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jPrinters;
    private javax.swing.JCheckBox jReceiptPrinter;
    // End of variables declaration//GEN-END:variables

}
