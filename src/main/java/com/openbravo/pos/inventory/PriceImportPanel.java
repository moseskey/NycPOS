package com.openbravo.pos.inventory;

import com.openbravo.basic.BasicException;
import com.openbravo.data.user.EditorListener;
import com.openbravo.data.user.EditorRecord;
import com.openbravo.data.user.ListProviderCreator;
import com.openbravo.data.user.SaveProvider;
import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.pos.panels.JPanelTable2;
import com.openbravo.pos.ticket.ProductFilter;
import java.awt.Component;
import javax.swing.JButton;

/**
 *
 * Created on 1 de marzo de 2007, 22:15
 *
 */
public class PriceImportPanel extends JPanelTable2 implements EditorListener {

    private ProductsEditor jeditor;
    private ProductFilter jproductfilter;

    private DataLogicSales m_dlSales = null;

    public PriceImportPanel() {
    }

    @Override
    protected void init() {
        m_dlSales = (DataLogicSales) app.getBean("com.openbravo.pos.forms.DataLogicSales");

        // el panel del filtro
        jproductfilter = new ProductFilter();
        jproductfilter.init(app);

        row = m_dlSales.getProductsRow();

        lpr =  new ListProviderCreator(m_dlSales.getProductCatQBF(), jproductfilter);

        spr = new SaveProvider(
            m_dlSales.getProductCatUpdate(),
            m_dlSales.getProductCatInsert(),
            m_dlSales.getProductCatDelete());

        // el panel del editor
        jeditor = new ProductsEditor(m_dlSales, dirty);
    }

    @Override
    public EditorRecord getEditor() {
        return jeditor;
    }

    @Override
    public Component getFilter() {
        return jproductfilter.getComponent();
    }

    @Override
    public Component getToolbarExtras() {

        JButton btnScanPal = new JButton();
        btnScanPal.setText("ScanPal");
        btnScanPal.setVisible(app.getDeviceScanner() != null);
        btnScanPal.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanPalActionPerformed(evt);
            }
        });

        return btnScanPal;
    }

    private void btnScanPalActionPerformed(java.awt.event.ActionEvent evt) {

        JDlgUploadProducts.showMessage(this, app.getDeviceScanner(), bd);
    }

    @Override
    public String getTitle() {
        return AppLocal.getIntString("Menu.StockImport");
    }

    @Override
    public void activate() throws BasicException {

        jeditor.activate();
        jproductfilter.activate();

        super.activate();
    }

    @Override
    public void updateValue(Object value) {
    }
}
