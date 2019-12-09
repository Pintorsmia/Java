package smash;



import java.io.File;
import java.util.Collection;
import java.util.Scanner;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ChatManagerListener;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.Roster;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.RosterListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.filetransfer.FileTransferListener;
import org.jivesoftware.smackx.filetransfer.FileTransferManager;
import org.jivesoftware.smackx.filetransfer.FileTransferRequest;
import org.jivesoftware.smackx.filetransfer.IncomingFileTransfer;
import org.jivesoftware.smackx.filetransfer.OutgoingFileTransfer;

public class Connexion {
	public static void main(String[] args) throws XMPPException {
		Connexion connexion = new Connexion();
		// Create the configuration for this new connection
		ConnectionConfiguration config = new ConnectionConfiguration("is2403a.local.univ-savoie.fr", 5222);
		config.setCompressionEnabled(true);
		config.setSASLAuthenticationEnabled(true);

		Connection connection = new XMPPConnection(config);
		// Connect to the server
		connection.connect();
		// Log into the server
		connection.login("littlemac", "smash", "SomeRessource");
		// Assume we've created a Connection name "connection".
		Chat chat = connexion.CreationChat(connection,args[0]);
		//"falcon@is2403a.local.univ-savoie.fr"
				
		Roster roster = connexion.Roster(connection);
		roster.addRosterListener(new RosterListener() {
		    // Ignored events public void entriesAdded(Collection<String> addresses) {}
		    public void entriesDeleted(Collection<String> addresses) {}
		    public void entriesUpdated(Collection<String> addresses) {}
		    public void presenceChanged(Presence presence) {
		        System.out.println("Presence changed: " + presence.getFrom() + " " + presence);
		    }
			@Override
			public void entriesAdded(Collection<String> arg0) {
				// TODO Auto-generated method stub
				
			}
		});

		connexion.receiveFile(connection);
	while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez saisir un messages :");
		String str = sc.next();
		if(str.compareTo("/quit") == 0) {
			connection.disconnect();
			System.out.println("Fin du tchat");
			break;
		}else if(str.compareTo("/add") == 0) {
			roster.createEntry(sc.next(), null, null);
			roster.createEntry("pikachu@is2403a.local.univ-savoie.fr", null, null);
			roster = connexion.Roster(connection);
		}else if(str.compareTo("/send") == 0){
			connexion.sendFile(connection, "falcon@is2403a.local.univ-savoie.fr/SomeRessource", sc.next());
		}else {
		
			try {
				chat.sendMessage(str);
			}
			catch (XMPPException e) {
				System.out.println("Error Delivering block");

			}
		}
	}
		//pikachu@is2403a.local.univ-savoie.fr
		// Disconnect from the server
		//
		
	}
	
	
	public Chat CreationChat(Connection connection,String user) {
		ChatManager chatmanager = connection.getChatManager();
		Chat newChat = chatmanager.createChat(user, new MessageListener() {
		    public void processMessage(Chat chat, Message message) {
		        System.out.println("Received message: " + message.getBody());
		    }
		});
		
		return newChat;
	}
	
	public Roster Roster(Connection connection) throws XMPPException {
		Roster roster = connection.getRoster();
		//Liste des contacts existant
		Collection<RosterEntry> entries = roster.getEntries();
		for (RosterEntry entry : entries) {
		    System.out.println("contact : " + entry);
		}
		
	
		return roster;
	}
	
	public void sendFile(Connection connection, String user, String chemin) throws XMPPException {
		 // Create the file transfer manager
	      FileTransferManager manager = new FileTransferManager(connection);
			
	      // Create the outgoing file transfer
	      OutgoingFileTransfer transfer = manager.createOutgoingFileTransfer(user);
			
	      // Send the file
	      transfer.sendFile(new File(chemin), "Nouveau Fichier !! ");

	}
	
	public void receiveFile(Connection connection) {
		// Create the file transfer manager
		final FileTransferManager manager = new FileTransferManager(connection);

		// Create the listener
		manager.addFileTransferListener(new FileTransferListener() {
			public void fileTransferRequest(FileTransferRequest request) {

				IncomingFileTransfer transfer = request.accept();
				try {
					transfer.recieveFile(new File("C:\\Users\\user\\eclipse-workspace\\JaninXMPP\\testreceive.txt"));
				} catch (XMPPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
		
	
}
