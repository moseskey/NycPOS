package com.openbravo.pos.instance;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class InstanceQuery {

    private final AppMessage m_appstub;

    /**
     * Creates a new instance of InstanceQuery
     * @throws java.rmi.RemoteException
     * @throws java.rmi.NotBoundException */
    public InstanceQuery() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry();
        m_appstub = (AppMessage) registry.lookup("AppMessage");
    }

    public AppMessage getAppMessage() {
        return m_appstub;
    }
}
