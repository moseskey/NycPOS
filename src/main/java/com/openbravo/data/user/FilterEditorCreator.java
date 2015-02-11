package com.openbravo.data.user;

import com.openbravo.data.loader.SerializerWrite;

public interface FilterEditorCreator extends EditorCreator {

    public SerializerWrite getSerializerWrite();
}
