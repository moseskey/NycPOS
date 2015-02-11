package com.openbravo.editor;

import java.awt.Component;

public interface EditorComponent {

    public void addEditorKeys(EditorKeys ed);

    public Component getComponent();

    public void deactivate();

    public void typeChar(char c);

    public void transChar(char c);
}
