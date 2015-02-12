package com.openbravo.pos.sales.restaurant;

import com.openbravo.basic.BasicException;
import com.openbravo.data.loader.DataRead;
import com.openbravo.data.loader.ImageUtils;
import com.openbravo.data.loader.SerializableRead;
import com.openbravo.pos.util.ThumbNailBuilder;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Floor implements SerializableRead {

    private static final long serialVersionUID = 8694154682897L;
    private String m_sID;
    private String m_sName;
    private Container m_container;
    private Icon m_icon;

    private static Image defimg = null;

    public Floor() {
        try {
//            defimg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/images/atlantikdesigner.png"));
            defimg = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/images/floors.png"));
        } catch (Exception fnfe) {
        }
    }

    @Override
    public void readValues(DataRead dr) throws BasicException {
        m_sID = dr.getString(1);
        m_sName = dr.getString(2);
        BufferedImage img = ImageUtils.readImage(dr.getBytes(3));
        ThumbNailBuilder tnbcat = new ThumbNailBuilder(32, 32, defimg);
        m_container = new JPanelDrawing(img);
        m_icon = new ImageIcon(tnbcat.getThumbNail(img));
    }

    public String getID() {
        return m_sID;
    }

    public String getName() {
        return m_sName;
    }

    public Icon getIcon() {
        return m_icon;
    }

    public Container getContainer() {
        return m_container;
    }

    private static class JPanelDrawing extends JPanel {
        private Image img;

        public JPanelDrawing(Image img) {
            this.img = img;
            setLayout(null);
        }

        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            if (img != null) {
                g.drawImage(img, 0, 0, this);
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return (img == null)
                ? new Dimension(640, 480)
                : new Dimension(img.getWidth(this), img.getHeight(this));
        }
        @Override
        public Dimension getMinimumSize() {
            return getPreferredSize();
        }
        @Override
        public Dimension getMaximumSize() {
            return getPreferredSize();
        }
    }
}
