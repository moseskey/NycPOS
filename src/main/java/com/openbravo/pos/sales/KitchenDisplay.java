package com.openbravo.pos.sales;

import com.openbravo.data.loader.Session;
import com.openbravo.pos.forms.AppView;
import com.openbravo.pos.forms.DataLogicSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KitchenDisplay {
    private static final Logger logger = LoggerFactory.getLogger(KitchenDisplay.class);

    private Session s;
    private Connection con;
    private Statement stmt;
    private PreparedStatement pstmt;
    private String SQL;
    private ResultSet rs;
    private AppView m_App;

    protected DataLogicSystem dlSystem;

    public KitchenDisplay(AppView oApp) {
        m_App = oApp;

//get database connection details
        try {
            s = m_App.getSession();
            con = s.getConnection();
        } catch (Exception e) {
          logger.error("Encountered Exception: {}: No session or connection", e);
        }
    }

    public void addRecord(String ID, String table, String pickupID, String product, String multiply,
                          String attributes) {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        logger.info(dateFormat.format(date));


        try {
            SQL = "INSERT INTO KITCHENDISPLAY (ID, ORDERTIME, PLACE, PICKUPID, PRODUCT, MULTIPLY, ATTRIBUTES) VALUES (?, ?, ?, ?, ?, ?, ?) ";
            pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, ID);
            pstmt.setString(2, dateFormat.format(date));
            pstmt.setString(3, table);
            pstmt.setString(4, pickupID);
            pstmt.setString(5, product);
            pstmt.setString(6, multiply);
            pstmt.setString(7, attributes);
            pstmt.executeUpdate();
        } catch (Exception e) {
        }

    }


//              stmt = (Statement) con.createStatement();
//            rs = stmt.executeQuery(SQL);


}
