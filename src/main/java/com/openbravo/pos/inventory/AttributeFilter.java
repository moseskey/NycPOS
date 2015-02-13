package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.gui.ComboBoxValModel;
import com.openbravo.data.loader.*;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.reports.ReportEditorCreator;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.List;

public class AttributeFilter extends javax.swing.JPanel implements ReportEditorCreator {

    private SentenceList attsent;
    private ComboBoxValModel attmodel;

    public AttributeFilter() {
        initComponents();
    }

    @Override
    public void init(AppView app) {

        attsent = new StaticSentence(app.getSession(),
             "SELECT ID, NAME FROM ATTRIBUTE ORDER BY NAME",
             null,
             new SerializerRead() {@Override
 public Object readValues(DataRead dr) throws BasicException {
                return new AttributeInfo(dr.getString(1), dr.getString(2));
            }});
        attmodel = new ComboBoxValModel();
    }

    @Override
    public void activate() throws BasicException {
        List a = attsent.list();
        attmodel = new ComboBoxValModel(a);
        attmodel.setSelectedFirst();
        jAttr.setModel(attmodel);
    }

    @Override
    public SerializerWrite getSerializerWrite() {
        return SerializerWriteString.INSTANCE;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    public void addActionListener(ActionListener l) {
        jAttr.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        jAttr.removeActionListener(l);
    }

    @Override
    public Object createValue() throws BasicException {
        AttributeInfo att = (AttributeInfo) attmodel.getSelectedItem();

        return att == null ? null : att.getId();
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

        jLabel8 = new javax.swing.JLabel();
        jAttr = new javax.swing.JComboBox();

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText(AppLocal.getIntString("label.attribute")); // NOI18N

        jAttr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jAttr, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jAttr, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jAttr;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

}
