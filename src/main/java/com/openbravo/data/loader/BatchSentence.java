package com.openbravo.data.loader;

import com.openbravo.basic.BasicException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BatchSentence extends BaseSentence {
    private static final Logger logger = LoggerFactory.getLogger(BatchSentence.class);

    protected Session m_s;

    protected HashMap<String, String> m_parameters;

    public BatchSentence(Session s) {
        m_s = s;
        m_parameters = new HashMap<>();
    }

    public void putParameter(String name, String replacement) {
        m_parameters.put(name, replacement);
    }

    protected abstract Reader getReader() throws BasicException;

    public class ExceptionsResultSet implements DataResultSet {

        List l;
        int m_iIndex;

        public ExceptionsResultSet(List l) {
            this.l = l;
            m_iIndex = -1;
        }

        @Override
        public Integer getInt(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public String getString(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public Double getDouble(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public Boolean getBoolean(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public java.util.Date getTimestamp(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        //public java.io.InputStream getBinaryStream(int columnIndex) throws DataException;

        @Override
        public byte[] getBytes(int columnIndex) throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public Object getObject(int columnIndex) throws BasicException  {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        //    public int getColumnCount() throws DataException;

        @Override
        public DataField[] getDataField() throws BasicException {
            throw new BasicException(LocalRes.getIntString("exception.nodataset"));
        }

        @Override
        public Object getCurrent() throws BasicException {
            if (m_iIndex < 0 || m_iIndex >= l.size()) {
                throw new BasicException(LocalRes.getIntString("exception.outofbounds"));
            } else {
                return l.get(m_iIndex);
            }
        }

        @Override
        public boolean next() throws BasicException {
            return ++m_iIndex < l.size();
        }

        @Override
        public void close() throws BasicException {
        }

        @Override
        public int updateCount() {
            return 0;
        }
    }

    @Override
    public final void closeExec() throws BasicException {
    }

    @Override
    public final DataResultSet moreResults() throws BasicException {
        return null;
    }

    @Override
    public DataResultSet openExec(Object params) throws BasicException {

        BufferedReader br = new BufferedReader(getReader());

        String sLine;
        StringBuffer sSentence = new StringBuffer();
        List aExceptions = new ArrayList();

        try {
            while ((sLine = br.readLine()) != null) {
                sLine = sLine.trim();
                if (!sLine.equals("") && !sLine.startsWith("--")) {
                    // No es un comentario ni linea vacia
                    if (sLine.endsWith(";")) {
                        // ha terminado la sentencia
                        sSentence.append(sLine.substring(0, sLine.length() - 1));

                        // File parameters
                        Pattern pattern = Pattern.compile("\\$(\\w+)\\{([^}]*)\\}");
                        Matcher matcher = pattern.matcher(sSentence.toString());
                        List paramlist = new ArrayList();

                        // Replace all occurrences of pattern in input
                        StringBuffer buf = new StringBuffer();
                        while (matcher.find()) {
                            logger.info("BatchSentence::openExec:matcher: " + matcher.group(1) + " // " + matcher.group(2));
                            if ("FILE".equals(matcher.group(1))) {
                                paramlist.add(ImageUtils.getBytesFromResource(matcher.group(2)));
                                matcher.appendReplacement(buf, "?");
                            } else {
                                String replacement = m_parameters.get(matcher.group(1));
                                if (replacement == null) {
                                    matcher.appendReplacement(buf, Matcher.quoteReplacement(matcher.group(0)));
                                } else {
                                    paramlist.add(replacement);
                                    matcher.appendReplacement(buf, "?");
                                }
                            }
                        }
                        matcher.appendTail(buf);

                        // La disparo
                        try {
                            BaseSentence sent;
                            if (paramlist.isEmpty()) {
                                sent = new StaticSentence(m_s, buf.toString());
                                sent.exec();
                            } else {
                                sent = new PreparedSentence(m_s, buf.toString(), SerializerWriteBuilder.INSTANCE);
                                sent.exec(new VarParams(paramlist));
                            }
                        } catch (BasicException eD) {
                            aExceptions.add(eD);
                        }
                        sSentence = new StringBuffer();

                    } else {
                        // la sentencia continua en la linea siguiente
                        sSentence.append(sLine);
                    }
                }
            }

            br.close();

        } catch (IOException eIO) {
            throw new BasicException(LocalRes.getIntString("exception.noreadfile"), eIO);
        }

        if (sSentence.length() > 0) {
            // ha quedado una sentencia inacabada
            aExceptions.add(new BasicException(LocalRes.getIntString("exception.nofinishedfile")));
        }

        return new ExceptionsResultSet(aExceptions);
    }

    private static class VarParams implements SerializableWrite {

        private List l;

        public VarParams(List l) {
            this.l = l;
        }

        @Override
        public void writeValues(DataWrite dp) throws BasicException {
            for (int i = 0; i < l.size(); i++) {
                Object v = l.get(i);
                if (v instanceof String) {
                    dp.setString(i + 1, (String) v);
                } else if (v instanceof byte[]) {
                    dp.setBytes(i + 1, (byte[]) l.get(i));
                } else {
                    dp.setObject(i + 1, v);
                }
            }
        }
    }
}
