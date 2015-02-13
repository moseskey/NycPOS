package com.openbravo.data.loader;


import com.openbravo.basic.BasicException;
import com.openbravo.pos.forms.AppViewConnection;
import com.openbravo.pos.forms.DataLogicSales;
import com.openbravo.data.loader.Session;
import com.openbravo.pos.forms.AppConfig;
import com.openbravo.pos.forms.AppLocal;
import java.io.*;

public class CompanyDetails {
    private String db_url;
    private String db_user;
    private String db_password;
    private File m_config;
    private Session session;

    public CompanyDetails() {

        AppConfig config = new AppConfig(m_config);
        // AppViewConnection Session = new AppViewConnection();


    }

    public void loadProperties(AppConfig config) {

        db_url = (config.getProperty("db.url"));
        db_user = (config.getProperty("db_user"));
        db_password = (config.getProperty("db.password"));
        //catch (BasicException){
        // Session s = new Session(db_url,db_user,"epos");

    }

    public String getUser() {
        return db_user;
    }
}





