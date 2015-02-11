package com.openbravo.data.user;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.SentenceList;
import com.openbravo.data.loader.TableDefinition;
import java.util.*;

public class ListProviderCreator implements ListProvider {

    private SentenceList sent;
    private EditorCreator prov;
    private Object params;

    /**
     * Creates a new instance of ListProviderEditor
     */
    public ListProviderCreator(SentenceList sent, EditorCreator prov) {
        this.sent = sent;
        this.prov = prov;
        params = null;
    }

    public ListProviderCreator(SentenceList sent) {
        this(sent, null);
    }

    public ListProviderCreator(TableDefinition table) {
        this(table.getListSentence(), null);
    }
//    public ListProviderECreator(Connection c, ISQLBuilderStatic sqlbuilder, SerializerRead sr, SerializerWrite sw, EditorCreator prov) {
//        this(new StaticSentence(c, sqlbuilder), prov);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//    }
//    public ListProviderECreator(Connection c, TableDefinition table, SerializerRead sr, SerializerWrite sw) {
//        this(new PreparedSentence(c, table.getListSentence()), null);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//    }
//    public ListProviderECreator(Connection c, ISQLBuilder sqlbuilder, SerializerRead sr, SerializerWrite sw, EditorCreator prov) {
//        this(new PreparedSentence(c, sqlbuilder), prov);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//    }
//    public ListProviderECreator(Connection c, TableDefinition table, String[] asFindFields, SerializerRead sr, SerializerWrite sw, EditorCreator prov) {
//        this(new PreparedSentence(c, new ListBuilder(table, asFindFields)), prov);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//   }
//    public ListProviderECreator(Connection c, String sqlsentence, SerializerRead sr, SerializerWrite sw, EditorCreator prov) {
//        this(new PreparedSentence(c, sqlsentence), prov);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//    }
//    public ListProviderECreator(Connection c, String sqlsentence, SerializerRead sr, SerializerWrite sw) {
//        this(new PreparedSentence(c, sqlsentence), null);
//        sent.setSerializerRead(sr);
//        sent.setSerializerWrite(sw);
//    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public List loadData() throws BasicException {
        params = (prov == null) ? null : prov.createValue();
        return refreshData();
    }

    /**
     *
     * @throws BasicException
     */
    @Override
    public List refreshData() throws BasicException {
        return sent.list(params);
    }
}
