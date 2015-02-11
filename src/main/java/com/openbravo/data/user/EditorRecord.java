package com.openbravo.data.user;

import java.awt.Component;

public interface EditorRecord extends EditorCreator {

    public void writeValueEOF();

    public void writeValueInsert();

    public void writeValueEdit(Object value); // not null por definicion.

    public void writeValueDelete(Object value); // not null por definicion.

    public void refresh();

    public Component getComponent();
}
