package com.openbravo.data.loader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * Created on February 6, 2007, 4:06 PM
 *
 */
public final class Session {

    private final String m_surl;
    private final String m_sappuser;
    private final String m_spassword;

    private Connection m_c;
    private boolean m_bInTransaction;

    public final SessionDB DB;

    public Session(String url, String user, String password) throws SQLException {
        m_surl = url;
        m_sappuser = user;
        m_spassword = password;

        m_c = null;
        m_bInTransaction = false;

        connect(); // no lazy connection

        DB = getDiff();
    }

    public void connect() throws SQLException {

        // primero cerramos si no estabamos cerrados
        close();

        // creamos una nueva conexion.
        m_c = (m_sappuser == null && m_spassword == null)
              ? DriverManager.getConnection(m_surl)
              : DriverManager.getConnection(m_surl, m_sappuser, m_spassword);
        m_c.setAutoCommit(true);
        m_bInTransaction = false;
    }

    public void close() {

        if (m_c != null) {
            try {
                if (m_bInTransaction) {
                    m_bInTransaction = false; // lo primero salimos del estado
                    m_c.rollback();
                    m_c.setAutoCommit(true);
                }
                m_c.close();
            } catch (SQLException e) {
                // me la como
            } finally {
                m_c = null;
            }
        }
    }

    public Connection getConnection() throws SQLException {

        if (!m_bInTransaction) {
            ensureConnection();
        }
        return m_c;
    }

    public void begin() throws SQLException {

        if (m_bInTransaction) {
            throw new SQLException("Already in transaction");
        } else {
            ensureConnection();
            m_c.setAutoCommit(false);
            m_bInTransaction = true;
        }
    }

    public void commit() throws SQLException {
        if (m_bInTransaction) {
            m_bInTransaction = false; // lo primero salimos del estado
            m_c.commit();
            m_c.setAutoCommit(true);
        } else {
            throw new SQLException("Transaction not started");
        }
    }

    public void rollback() throws SQLException {
        if (m_bInTransaction) {
            m_bInTransaction = false; // lo primero salimos del estado
            m_c.rollback();
            m_c.setAutoCommit(true);
        } else {
            throw new SQLException("Transaction not started");
        }
    }

    public boolean isTransaction() {
        return m_bInTransaction;
    }

    private void ensureConnection() throws SQLException {
        // solo se invoca si isTransaction == false

        boolean bclosed;
        try {
            bclosed = m_c == null || m_c.isClosed();
        } catch (SQLException e) {
            bclosed = true;
        }

        // reconnect if closed
        if (bclosed) {
            connect();
        }
    }

    public String getURL() throws SQLException {
        return getConnection().getMetaData().getURL();
    }

    private SessionDB getDiff() throws SQLException {

        String sdbmanager = getConnection().getMetaData().getDatabaseProductName();
        switch (sdbmanager) {
            case "HSQL Database Engine":
                return new SessionDBHSQLDB();
            case "MySQL":
                return new SessionDBMySQL();
            case "PostgreSQL":
                return new SessionDBPostgreSQL();
            case "Oracle":
                return new SessionDBOracle();
            case "Apache Derby":
                return new SessionDBDerby();
            default:
                return new SessionDBGeneric(sdbmanager);
        }
    }
}
