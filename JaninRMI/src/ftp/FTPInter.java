package ftp;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FTPInter extends Remote{
	byte[] get(String filename) throws RemoteException, IOException;
	void put(String filename, byte[] file) throws RemoteException, IOException;
	void cd(String dir) throws RemoteException;
	String[] ls() throws RemoteException ;
	String pwd() throws RemoteException;

}
