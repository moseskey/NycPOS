package com.openbravo.pos.panels;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import javax.swing.tree.TreeNode;

public class SQLDatabase implements TreeNode {

    private ArrayList m_aTables;
    private HashMap m_mTables;
    private String m_sName;

    public SQLDatabase(String name) {
        m_sName = name;
        m_aTables = new ArrayList();
        m_mTables = new HashMap();
    }
    @Override
    public String toString() {
        return m_sName;
    }

    public void addTable(String sTable) {
        SQLTable t = new SQLTable(this, sTable);
        m_aTables.add(t);
        m_mTables.put(sTable, t);
    }

    public SQLTable getTable(String sTable) {
        return (SQLTable) m_mTables.get(sTable);
    }

    @Override
    public Enumeration children() {
        return new EnumerationIter(m_aTables.iterator());
    }
    @Override
    public boolean getAllowsChildren() {
        return true;
    }
    @Override
    public TreeNode getChildAt(int childIndex) {
        return (TreeNode) m_aTables.get(childIndex);
    }
    @Override
    public int getChildCount() {
        return m_aTables.size();
    }
    @Override
    public int getIndex(TreeNode node) {
        return m_aTables.indexOf(node);
    }
    @Override
    public TreeNode getParent() {
        return null;
    }
    @Override
    public boolean isLeaf() {
// JG 16 May 2013 use isEmpty
        return m_aTables.isEmpty();
    }
}
