package cn.plus.framework.rmi.example;

/**
 * @author plus me
 * @date 2018/6/19
 */

import cn.plus.framework.util.IPUtils;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class Server extends HelloImpl {
    protected Server() throws RemoteException {
    }

    public static void main(String args[]) {
        int port = 10100;
        Hello hello = null;
        try{
            //创建一个注册表而已
            LocateRegistry.createRegistry(port);
            String url = "rmi://localhost:10100/Hello";
            hello = new HelloImpl();
            Naming.rebind(url,hello);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}