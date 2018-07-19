package cn.plus.framework.rmi.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author plus me
 * @date 2018/6/19
 */
public interface Hello extends Remote {
    /**
     * printMsg
     * @return
     * @throws RemoteException
     */
    String printMsg() throws RemoteException;
}
