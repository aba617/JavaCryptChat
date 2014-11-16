import java.net.*;
import java.io.*;



public class CryptServer implements Runnable {
	private QueueGate queueGate;
	
	public CryptServer (QueueGate queueGate){
		this.queueGate=queueGate;
	}
	
	public void run() {
		handler();
	}
	
	public void handler(){
		ClientSession clientSession = new ClientSession(queueGate.dequeueClient(), queueGate);
		
		
	//	if (queueGate.threadCounter > 0)
	//		clientSession = new ClientSession(queueGate.dequeueClient(), queueGate);
	//	else{
			//try {
		//		System.out.println("waiting...");
			//} catch (InterruptedException e) {
			//	System.err.println("Error in Thread Handler");
			//	e.printStackTrace();
			//}
		}
	}
	

	public static void main(String[] args) throws IOException{
		QueueGate queueGate = new QueueGate();
		System.out.println(queueGate);

		int portNo = Integer.parseInt(args[0]);
		
		CryptServer threadManager = new CryptServer(queueGate);
		threadManager.run();

		ServerSocket serverSock = new ServerSocket (portNo);

		
		while (true){
		
			Socket clientSock = serverSock.accept();
			//System.out.println("client received");
			queueGate.enqueueClient(clientSock);
		}
		
	}



}



