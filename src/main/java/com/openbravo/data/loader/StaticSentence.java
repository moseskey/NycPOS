package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StaticSentence extends JDBCSentence {

    private static final Logger logger = Logger.getLogger("com.openbravo.data.loader.StaticSentence");

    private ISQLBuilderStatic m_sentence;

    protected SerializerWrite m_SerWrite = null;

    protected SerializerRead m_SerRead = null;

    // Estado
    private Statement m_Stmt;

    public StaticSentence(Session s, ISQLBuilderStatic sentence, SerializerWrite serwrite,
                          SerializerRead serread) {
        super(s);
        m_sentence = sentence;
        m_SerWrite = serwrite;
        m_SerRead = serread;
        m_Stmt = null;
    }
    public StaticSentence(Session s, ISQLBuilderStatic sentence) {
        this(s, sentence, null, null);
    }
    public StaticSentence(Session s, ISQLBuilderStatic sentence, SerializerWrite serwrite) {
        this(s, sentence, serwrite, null);
    }
    public StaticSentence(Session s, String sentence, SerializerWrite serwrite,
                          SerializerRead serread) {
        this(s, new NormalBuilder(sentence), serwrite, serread);
    }
    public StaticSentence(Session s, String sentence, SerializerWrite serwrite) {
        this(s, new NormalBuilder(sentence), serwrite, null);
    }
    public StaticSentence(Session s, String sentence) {
        this(s, new NormalBuilder(sentence), null, null);
    }

    @Override
    public DataResultSet openExec(Object params) throws BasicException {
        // true -> un resultset
        // false -> un updatecount (si -1 entonces se acabo)

        closeExec();

        try {
            m_Stmt = m_s.getConnection().createStatement();

            String sentence = m_sentence.getSQL(m_SerWrite, params);

            logger.log(Level.INFO, "Executing static SQL: {0}", sentence);

            if (m_Stmt.execute(sentence)) {
                return new JDBCDataResultSet(m_Stmt.getResultSet(), m_SerRead);
            } else {
                int iUC = m_Stmt.getUpdateCount();
                if (iUC < 0) {
                    return null;
                } else {
                    return new SentenceUpdateResultSet(iUC);
                }
            }
        } catch (SQLException eSQL) {
            throw new BasicException(eSQL);
        }
    }

    @Override
    public void closeExec() throws BasicException {

        if (m_Stmt != null) {
            try {
                m_Stmt.close();
            } catch (SQLException eSQL) {
                throw new BasicException(eSQL);
            } finally {
                m_Stmt = null;
            }
        }
    }

    @Override
    public DataResultSet moreResults() throws BasicException {

        try {
            if (m_Stmt.getMoreResults()) {
                // tenemos resultset
                return new JDBCDataResultSet(m_Stmt.getResultSet(), m_SerRead);
            } else {
                // tenemos updatecount o si devuelve -1 ya no hay mas
                int iUC = m_Stmt.getUpdateCount();
                if (iUC < 0) {
                    return null;
                } else {
                    return new SentenceUpdateResultSet(iUC);
                }
            }
        } catch (SQLException eSQL) {
            throw new BasicException(eSQL);
        }
    }

}
