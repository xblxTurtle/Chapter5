import java.io.*;
import java.net.*;

public class SimpleClient {
	public static final int connectionPort = 2000; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting client. Trying to connect to server.");
		try
		{
			Socket socket = new Socket("127.0.0.1", connectionPort);
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String inputString = reader.readLine();
			System.out.printf("Connection with server is established. Information received: \n %s \n", inputString);
			reader.close();
			socket.close();
		}
		catch(Exception ex)
		{
			System.out.printf("Error appeared during connection attempt. Terminating. \n %s\n", ex.toString());
		}
	}

}
