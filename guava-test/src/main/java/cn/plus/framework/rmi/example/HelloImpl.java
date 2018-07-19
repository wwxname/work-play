package cn.plus.framework.rmi.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author plus me
 * @date 2018/6/19
 */
public class HelloImpl  extends UnicastRemoteObject implements Hello{
    protected HelloImpl() throws RemoteException {
    }

    @Override
    public String printMsg() throws RemoteException {
        System.err.println("wwx");
        return "wwx";
    }
}
