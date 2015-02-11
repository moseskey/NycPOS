//    uniCenta oPOS  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2014 uniCenta & previous Openbravo POS works
//    http://www.unicenta.com
//
//    This file is part of uniCenta oPOS
//
//    uniCenta oPOS is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//   uniCenta oPOS is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with uniCenta oPOS.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.reports;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.SerializerWrite;
import com.openbravo.data.loader.SerializerWriteComposed;
import com.openbravo.pos.forms.AppView;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

public class JParamsComposed extends javax.swing.JPanel implements ReportEditorCreator {

// JG 16 May 12 use diamond inference
    private List<ReportEditorCreator> editors = new ArrayList<>();

    /** Creates new form JParamsComposed */
    public JParamsComposed() {
        initComponents();
    }

    @Override
    public void init(AppView app) {
        for (ReportEditorCreator qbff : editors) {
            qbff.init(app);
        }
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public void activate() throws BasicException {
        for (ReportEditorCreator qbff : editors) {
            qbff.activate();
        }
    }

    @Override
    public SerializerWrite getSerializerWrite() {

        SerializerWriteComposed sw = new SerializerWriteComposed();

        for (ReportEditorCreator qbff : editors) {
            sw.add(qbff.getSerializerWrite());
        }

        return sw;
    }

    @Override
    public Component getComponent() {
        return this;
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public Object createValue() throws BasicException {

        Object[] value = new Object[editors.size()];

        for(int i = 0; i < editors.size(); i++) {
            value[i] = editors.get(i).createValue();
        }

        return value;
    }

    public void addEditor(ReportEditorCreator c) {
        editors.add(c);
        add(c.getComponent());
    }

    public boolean isEmpty() {

        return editors.isEmpty();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
