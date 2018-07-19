package cn.plus.framework.rmi.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author plus me
 * @date 2018/6/19
 */
public class Client {

    public static void  main(String args[]) throws RemoteException, NotBoundException, MalformedURLException {
        String url = "rmi://localhost:10100/Hello";
        Hello helloService = (Hello) Naming.lookup(url);
        String result = helloService.printMsg();
        System.out.println(result);
    }
}
