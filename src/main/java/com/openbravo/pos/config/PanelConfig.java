package com.openbravo.pos.config;

import com.openbravo.pos.forms.AppConfig;
import java.awt.Component;

public interface PanelConfig {

    public void loadProperties(AppConfig config);

    public void saveProperties(AppConfig config);

    public boolean hasChanged();

    public Component getConfigComponent();
}
