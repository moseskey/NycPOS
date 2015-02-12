package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.BrowsableData;
import com.openbravo.format.Formats;
import javax.swing.table.AbstractTableModel;

public class StockModel extends AbstractTableModel {

    private BrowsableData m_bd;
    private Formats[] m_formats;
    private boolean[] m_bedit;

    public StockModel(BrowsableData bd, Formats[] f, boolean[] bedit) {
        m_bd = bd;
        m_formats = f;
        m_bedit = bedit;
    }
    @Override
    public int getRowCount() {
        return m_bd.getSize();
    }
    @Override
    public int getColumnCount() {
        return m_formats.length;
    }
    @Override
    public Object getValueAt(int row, int column) {
        return m_formats[column].formatValue(
                ((Object[]) m_bd.getElementAt(row))[column]);
    }
    @Override
    public boolean isCellEditable(int row, int column) {
        return m_bedit[column];
    }
    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Object[] record = (Object[]) m_bd.getElementAt(row);
        try {
            record[column] = m_formats[column].parseValue((String) aValue);
            m_bd.updateRecord(row, record);
        } catch (BasicException e) {
        }
    }
}
