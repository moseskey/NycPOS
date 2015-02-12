package com.openbravo.pos.instance;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AppMessage extends Remote {

    public void restoreWindow() throws RemoteException;
}
