import java.net.*;
import  java.io.*;
import java.util.*;

public class DistributedWorker extends Thread{
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	public DistributedWorker(Socket socket)
	{
		super();
		this.socket = socket;
	}
	public void run()
	{
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
			
		while (!DistributedServer.taskQueue.isEmpty())
		{ 
			
			try {
				DistributedTask task = DistributedServer.taskQueue.take();
				out.writeObject(task);
				ArrayList<Long> result = (ArrayList<Long>)in.readObject();
				System.out.println("Task completed");
				synchronized(DistributedServer.results)
				{
					DistributedServer.results.addAll(result);
				}
			} 
			catch (InterruptedException | IOException | ClassNotFoundException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
}
