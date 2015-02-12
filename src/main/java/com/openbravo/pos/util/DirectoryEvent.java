package com.openbravo.pos.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.JTextComponent;
import com.openbravo.pos.forms.AppLocal;

public class DirectoryEvent implements ActionListener {
    private JTextComponent m_jTxtField;
    private JFileChooser m_fc;

    public DirectoryEvent(JTextComponent TxtField) {
        m_jTxtField = TxtField;
        m_fc = new JFileChooser();

        m_fc.resetChoosableFileFilters();
        m_fc.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".jar") || filename.endsWith(".zip");
                }
            }
            @Override
            public String getDescription() {
                return AppLocal.getIntString("filter.dbdriverlib");
            }
        });

        m_fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        m_fc.setCurrentDirectory(new File(m_jTxtField.getText()));

        if (m_fc.showOpenDialog(m_jTxtField) == JFileChooser.APPROVE_OPTION) {
            m_jTxtField.setText(m_fc.getSelectedFile().getAbsolutePath());
        }
    }
}
