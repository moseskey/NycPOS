package com.openbravo.pos.ticket;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.IKeyed;
import com.openbravo.data.loader.ImageUtils;
import com.openbravo.data.loader.SerializerRead;
import java.awt.image.*;

/**
 *
 * @version
 */
public class CategoryInfo implements IKeyed {

    private static final long serialVersionUID = 8612449444103L;
    private String m_sID;
    private String m_sName;
    private String m_sTextTip;
    private BufferedImage m_Image;
    private Boolean m_bCatShowName;

    /**
     * Creates new CategoryInfo
     * @param catshowname */
    public CategoryInfo(String id, String name, BufferedImage image, String texttip, Boolean catshowname) {
        m_sID = id;
        m_sName = name;
        m_Image = image;
        m_sTextTip = texttip;
        m_bCatShowName = catshowname;
    }

    @Override
    public Object getKey() {
        return m_sID;
    }

    public void setID(String sID) {
        m_sID = sID;
    }

    public String getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }

    public void setName(String sName) {
        m_sName = sName;
    }
// ADDED JDL 13.04.13 *************

        public String getTextTip() {
        return m_sTextTip;
    }

    public void setTextTip(String sName) {
        m_sTextTip = sName;
    }

    public Boolean getCatShowName() {
        return m_bCatShowName;
    }

    public void setCatShowName(Boolean bcatshowname) {
        m_bCatShowName = bcatshowname;
    }





    // *******************************


    public BufferedImage getImage() {
        return m_Image;
    }

    public void setImage(BufferedImage img) {
        m_Image = img;
    }

    @Override
    public String toString() {
        return m_sName;
    }

    public static SerializerRead getSerializerRead() {
        return new SerializerRead() {@Override
 public Object readValues(DataRead dr) throws BasicException {
            return new CategoryInfo(dr.getString(1), dr.getString(2), ImageUtils.readImage(dr.getBytes(3)),dr.getString(4),dr.getBoolean(5));
        }};
    }
}
