package com.openbravo.pos.reports;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.BaseSentence;
import com.openbravo.data.loader.DataResultSet;
import com.openbravo.pos.forms.AppLocal;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class JRDataSourceBasic implements JRDataSource {

    private BaseSentence sent;
    private DataResultSet SRS = null;
    private Object current = null;

    private ReportFields m_fields = null;

    public JRDataSourceBasic(BaseSentence sent, ReportFields fields, Object params) throws BasicException  {

        this.sent = sent;
        SRS = sent.openExec(params);
        m_fields = fields;
    }

    @Override
    public Object getFieldValue(JRField jrField) throws JRException {

        try {
            return m_fields.getField(current,  jrField.getName());
        } catch (ReportException er) {
            throw new JRException(er);
        }
    }

    @Override
    public boolean next() throws JRException {

        if (SRS == null) {
            throw new JRException(AppLocal.getIntString("exception.unavailabledataset"));
        }

        try {
            if (SRS.next()) {
                current = SRS.getCurrent();
                return true;
            } else {
                current = null;
                SRS = null;
                sent.closeExec();
                sent = null;
                return false;
            }
        } catch (BasicException e) {
            throw new JRException(e);
        }
    }
}
