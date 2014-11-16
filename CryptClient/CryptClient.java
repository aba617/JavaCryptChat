import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class CryptClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			    Socket echoSocket = new Socket("localhost", 40453);
			    PrintWriter out =
			        new PrintWriter(echoSocket.getOutputStream(), true);
			    BufferedReader in =
			        new BufferedReader(
			            new InputStreamReader(echoSocket.getInputStream()));
			    BufferedReader stdIn =
			        new BufferedReader(
			            new InputStreamReader(System.in));
		}
		catch (Exception e){
			System.out.println(e);
		}
	}

}
