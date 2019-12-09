package ftp;

import java.io.IOException;
import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

import ftp.FTPInter;
public class FTPServer implements Remote {
	
	public FTPServer() {}
	
	public static void main(String args[]) throws IOException {
		
		//FTPFonction Fonction = new FTPFonction();
		//byte[] file = Fonction.get("C:\\test.txt");
		//Fonction.put("C:\\Test\\aled.txt", file);
		
		try {
			FTPFonction obj = new FTPFonction();
	
			// Declare le stub surlequel sera expose l’objet distribue
			FTPInter stub = (FTPInter)UnicastRemoteObject.exportObject(obj, 0);
			// Permet de lier au Registre l’objet distribue
			Registry registry = LocateRegistry.createRegistry(1099);
			registry.bind("FTP", stub);
			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("Server exception: " + e.toString());
	
			e.printStackTrace();
		}
		
		}
	
	
}
