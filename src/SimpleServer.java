import java.net.*;
import java.io.*;

public class SimpleServer {
	public static final int connectionPort = 2000;
	public static int connectionsCount = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.printf("Starting server on port : %d\n", connectionPort);
		try (ServerSocket server = new ServerSocket(connectionPort))
		{
			while (true)
			{
				Socket socket = server.accept();
				connectionsCount++;
				System.out.printf("Client number: %d connected. Processing.\n", connectionsCount);
				processConnection(socket);
				socket.close();
			}
		}
		catch(Exception ex)
		{
			System.out.printf("An error appeared during listening for connections. Terminating. \n %s \n:", ex.toString());
		}
	}
	public static void processConnection(Socket socket)
	{
		try
		{
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			writer.printf("Hello from server. You are %d 's connection for this server run.\n", connectionsCount);
			writer.flush();
			writer.close();
		}
		catch(Exception ex)
		{
			System.out.printf("An error appeared during an attempt to send info to the client. \n %s \n:", ex.toString());
		}
	}

}
