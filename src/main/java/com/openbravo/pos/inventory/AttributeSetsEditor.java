package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.DirtyManager;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.AppLocal;
import java.awt.Component;
import java.util.UUID;

public final class AttributeSetsEditor extends javax.swing.JPanel implements EditorRecord {

    private Object id;

    public AttributeSetsEditor(DirtyManager dirty) {
        initComponents();

        m_jName.getDocument().addDocumentListener(dirty);

        writeValueEOF();
    }

    @Override
    public void writeValueEOF() {
        id = null;
        m_jName.setText(null);
        m_jName.setEnabled(false);
    }

    @Override
    public void writeValueInsert() {
        id = UUID.randomUUID().toString();
        m_jName.setText(null);
        m_jName.setEnabled(true);
    }

    @Override
    public void writeValueDelete(Object value) {

        Object[] attrset = (Object[]) value;
        id = attrset[0];
        m_jName.setText(Formats.STRING.formatValue(attrset[1]));
        m_jName.setEnabled(false);
    }

    @Override
    public void writeValueEdit(Object value) {

        Object[] attrset = (Object[]) value;
        id = attrset[0];
        m_jName.setText(Formats.STRING.formatValue(attrset[1]));
        m_jName.setEnabled(true);
    }

    @Override
    public Object createValue() throws BasicException {

        Object[] attrset = new Object[2];

        attrset[0] = id;
        attrset[1] = m_jName.getText();

        return attrset;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    @Override
    public void refresh() {
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

        jLabel2 = new javax.swing.JLabel();
        m_jName = new javax.swing.JTextField();

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText(AppLocal.getIntString("Label.Name")); // NOI18N

        m_jName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(m_jName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField m_jName;
    // End of variables declaration//GEN-END:variables

}
