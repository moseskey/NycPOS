package com.openbravo.pos.panels;

import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

public class SQLTable implements TreeNode {

    private SQLDatabase m_db;
    private String m_sName;

    private ArrayList m_aColumns;

    public SQLTable(SQLDatabase db, String name) {
        m_db = db;
        m_sName = name;
        m_aColumns = new ArrayList();
    }

    public String getName() {
        return m_sName;
    }

    public void addColumn(String name) {
        SQLColumn c = new SQLColumn(this, name);
        m_aColumns.add(c);
    }

    @Override
    public String toString() {
        return m_sName;
    }

    @Override
    public Enumeration children() {
        return new EnumerationIter(m_aColumns.iterator());
    }
    @Override
    public boolean getAllowsChildren() {
        return true;
    }
    @Override
    public TreeNode getChildAt(int childIndex) {
        return (TreeNode) m_aColumns.get(childIndex);
    }
    @Override
    public int getChildCount() {
        return m_aColumns.size();
    }
    @Override
    public int getIndex(TreeNode node) {
        return m_aColumns.indexOf(node);
    }
    @Override
    public TreeNode getParent() {
        return m_db;
    }
    @Override
    public boolean isLeaf() {
// JG 16 May 2013 use isEmpty instead of size.
        return m_aColumns.isEmpty();
    }
//    public Enumeration children(){
//    }
//    public boolean getAllowsChildren() {
//    }
//    public TreeNode getChildAt(int childIndex) {
//    }
//    public int getChildCount() {
//    }
//    public int getIndex(TreeNode node){
//    }
//    public TreeNode getParent() {
//    }
//    public boolean isLeaf() {
//    }
}
