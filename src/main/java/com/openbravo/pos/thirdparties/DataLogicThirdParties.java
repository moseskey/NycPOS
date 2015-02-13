package com.openbravo.pos.thirdparties;

import com.openbravo.data.loader.Datas;
import com.openbravo.data.loader.Session;
import com.openbravo.data.loader.TableDefinition;
import com.openbravo.format.Formats;
import com.openbravo.pos.forms.BeanFactoryDataSingle;

public class DataLogicThirdParties extends BeanFactoryDataSingle {

    private TableDefinition m_tthirdparties;

    public DataLogicThirdParties() {
    }

    public void init(Session s){

        m_tthirdparties = new TableDefinition(s,
            "THIRDPARTIES",
             new String[] {"ID", "CIF", "NAME", "ADDRESS", "CONTACTCOMM", "CONTACTFACT", "PAYRULE", "FAXNUMBER", "PHONENUMBER", "MOBILENUMBER", "EMAIL", "WEBPAGE", "NOTES"},
             new Datas[] {Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING, Datas.STRING},
             new Formats[] {Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING, Formats.STRING},
             new int[] {0}
        );

    }

    public final TableDefinition getTableThirdParties() {
        return m_tthirdparties;
    }
}
