import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.IOException;
import java.net.*;
public class DistributedServer {

	public static final long calculationsize = 300000; 
	public static final long portNumber = 1050; 
	public static LinkedBlockingQueue<DistributedTask> taskQueue;
	public static ArrayList<Long> results = new ArrayList<Long>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Starting server");
		taskQueue = FormTaskQueue();
		System.out.println("Waiting for clients");
		while (!FormTaskQueue().isEmpty())
		{
			try
			{
				ServerSocket listener = new ServerSocket(1050);
				Socket socket = listener.accept();
				System.out.println("Client connected");
				DistributedWorker worker = new DistributedWorker(socket);
				worker.start();
			}
			catch (IOException ex)
			{
				
			}
		}
		System.out.println("Task queue is empty");
		System.out.println("Results:");
		System.out.println(results.toString());
	}
	public static LinkedBlockingQueue<DistributedTask> FormTaskQueue()
	{
		LinkedBlockingQueue<DistributedTask> taskQueue = new LinkedBlockingQueue<DistributedTask>();
		for (int i=10;i>0;i--)
		{
			taskQueue.add(new DistributedTask((long)((double)i/10)*calculationsize, (long) (((double)(i-1)/10)*calculationsize)));
		}
		return taskQueue;
	}

}
