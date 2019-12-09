package hello;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloClass implements Hello{

	@Override
	public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello Mikail le bg";
	}
	
	public static void main(String args[]) {
		try {
		HelloClass obj = new HelloClass();

		// Declare le stub surlequel sera expose l’objet distribue
		Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
		// Permet de lier au Registre l’objet distribue
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.bind("Pouet", stub);
		System.err.println("Server ready");
		} catch (Exception e) {
		System.err.println("Server exception: " + e.toString());

		e.printStackTrace();
		}
		}

}
