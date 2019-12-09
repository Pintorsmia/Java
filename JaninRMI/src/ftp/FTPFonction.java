package ftp;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.RemoteException;


public class FTPFonction implements FTPInter {
	private String dir = "D:\\";
	
	@Override
	public byte[] get(String filename) throws IOException {
		 byte[] content = Files.readAllBytes(Paths.get(this.dir + filename));
		return content;
	}

	@Override
	public void put(String filename, byte[] file) throws IOException {
		Files.write(Paths.get(filename), file);
	}

	@Override
	public void cd(String dir) throws RemoteException {
		this.dir = dir;
		System.out.println("Nouveau répertoire : " + this.dir);
	}

	@Override
	public String[] ls() throws RemoteException {
		File repertoire = new File(this.dir);
		return repertoire.list();
	}

	@Override
	public String pwd() throws RemoteException {
		return this.dir;
	}
	
	
	
}
