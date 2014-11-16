import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class QueueGate {

	Queue<Socket> IncomingClients = new LinkedList<Socket>();
	HashMap<Socket, String> loggedClients = new HashMap<Socket, String>();
	
	public int threadCounter = 0;
	
	
	public synchronized void enqueueClient(Socket client){
		this.IncomingClients.add(client);
		threadCounter++;
	}
	
	public synchronized Socket dequeueClient(){
		threadCounter--;
		return 	this.IncomingClients.remove();

		}
	
	public synchronized int getThreadCount(){
		return threadCounter;
	}
	
	public synchronized String GetUserName(Socket sock){
		return loggedClients.get(sock);
	}
	
	public synchronized boolean amILoggedIn(Socket sock){
		if (loggedClients.get(sock) == null)
			return false;
		else
			return true;
			
	}
	
	public synchronized void logIn(Socket sock, String name){
		loggedClients.put(sock, name);
	}
	
}
