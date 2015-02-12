package com.openbravo.pos.reports;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.FilterEditorCreator;
import com.openbravo.pos.forms.AppView;
import java.awt.Component;

public interface ReportEditorCreator extends FilterEditorCreator {

    public void init(AppView app);

    public void activate() throws BasicException;

    public Component getComponent();
}
