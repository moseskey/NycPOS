package com.openbravo.pos.forms;

import com.openbravo.data.loader.Session;
import com.openbravo.pos.printer.DeviceTicket;
import com.openbravo.pos.scale.DeviceScale;
import com.openbravo.pos.scanpal2.DeviceScanner;
import java.util.Date;

public interface AppView {

    public DeviceScale getDeviceScale();

    public DeviceTicket getDeviceTicket();

    public DeviceScanner getDeviceScanner();

    public Session getSession();

    public AppProperties getProperties();

    /**
     *
     * @throws BeanFactoryException
     */
    public Object getBean(String beanfactory) throws BeanFactoryException;

    public void setActiveCash(String value, int iSeq, Date dStart, Date dEnd);

    public String getActiveCashIndex();

    public int getActiveCashSequence();

    public Date getActiveCashDateStart();

    public Date getActiveCashDateEnd();

    public String getInventoryLocation();

    public void waitCursorBegin();

    public void waitCursorEnd();

    public AppUserView getAppUserView();
}

