package ftp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;



public class FTPClient {
	

	public byte[] get(String filename) throws IOException {
		byte[] content = null;
		content = Files.readAllBytes(Paths.get(filename));
		return content;
	}


	public void put(String filename, byte[] file) throws IOException {
		// TODO Auto-generated method stub
		Files.write(Paths.get(filename), file);
	}

	
	
	public static void main(String[] args) {
		FTPClient Client = new FTPClient();
		String host = (args.length < 1) ? null : args[0];
		int port = Integer.parseInt(args[1]);
		String name = args[2];
		Boolean test = true;
		try {
			Scanner sc = new Scanner(System.in);
			while (test) {
				    System.out.println("Commande à effectuer : ");
				    String command = sc.next();
				    sc.nextLine();
     
				    System.out.println(command);
				   
				  }				
				
						
			
			 sc.close();
			
			
			Registry registry = LocateRegistry.getRegistry(host,port);
			FTPInter stub = (FTPInter) registry.lookup("FTP");
			stub.cd("C:\\");
			byte[] file = stub.get(name);
			Client.put("C:\\Test\\Mikail.txt", file);
			System.out.println(Arrays.toString(stub.ls()));
			System.out.println("Repertoire actuel : " + stub.pwd());
		} catch (Exception e) {
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace();
		}
	}
}
