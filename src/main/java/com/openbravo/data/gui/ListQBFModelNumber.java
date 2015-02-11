package com.openbravo.data.gui;

import com.openbravo.data.loader.QBFCompareEnum;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
public class ListQBFModelNumber extends AbstractListModel implements ComboBoxModel {

private Object[] m_items;
private Object m_sel;

/**
 * Creates a new instance of ListQBFModelNumber
     * @param items */
//    public ListQBFModelNumber() {
//    private ListQBFModelNumber(Object... items) {
    public ListQBFModelNumber(Object... items) {
        m_items = items;
        m_sel = m_items[0];
    }

//    m_items = new Object[] {

        public static ListQBFModelNumber getMandatoryString() {
        return new ListQBFModelNumber(
              QBFCompareEnum.COMP_NONE,
              QBFCompareEnum.COMP_EQUALS,
              QBFCompareEnum.COMP_RE,
              QBFCompareEnum.COMP_DISTINCT,
//            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_GREATER,
              QBFCompareEnum.COMP_LESS,
//            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS
        );
    }

    public static ListQBFModelNumber getMandatoryNumber() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS
        );
    }

    public static ListQBFModelNumber getNonMandatoryString() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_RE,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
              QBFCompareEnum.COMP_LESSOREQUALS,
              QBFCompareEnum.COMP_ISNULL,
//            QBFCompareEnum.COMP_ISNOTNULL,
//        };
//        m_sel = m_items[0];
            QBFCompareEnum.COMP_ISNOTNULL
        );
    }

    public static ListQBFModelNumber getNonMandatoryNumber() {
        return new ListQBFModelNumber(
            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS,
            QBFCompareEnum.COMP_ISNULL,
            QBFCompareEnum.COMP_ISNOTNULL
        );
      }

    public static ListQBFModelNumber getOverrideMandatoryNumber() {
        return new ListQBFModelNumber(
//            QBFCompareEnum.COMP_NONE,
            QBFCompareEnum.COMP_EQUALS,
            QBFCompareEnum.COMP_DISTINCT,
            QBFCompareEnum.COMP_GREATER,
            QBFCompareEnum.COMP_LESS,
            QBFCompareEnum.COMP_GREATEROREQUALS,
            QBFCompareEnum.COMP_LESSOREQUALS
        );
    }



    @Override
      public Object getElementAt(int index) {

        return m_items[index];
    }

    @Override
    public int getSize() {
        return m_items.length;
    }

    @Override
    public Object getSelectedItem() {
        return m_sel;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        m_sel = anItem;
    }
}
