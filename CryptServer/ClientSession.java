import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientSession {
	private Socket client;
	private ServerSocket servSock;
	private QueueGate queueGate;
	
	public ClientSession(Socket client, QueueGate queueGate){
		this.client = client;
		this.queueGate = queueGate;
		threadMain();
	}
	
	public void threadMain(){
		if (!queueGate.amILoggedIn(client))
			getUserName();
	}
	
	public void getUserName() {
		try{
		ServerSocket negotiator = new ServerSocket(client.getPort());
		}
		catch (IOException e){
			System.err.println("error negotiation with client...");
		}
	}
	
}


