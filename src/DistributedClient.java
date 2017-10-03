import java.io.IOException;
import java.io.*;
import java.net.*;
import java.util.*;

public class DistributedClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		DistributedTask task;
		ArrayList<Long> result; 
		ObjectInputStream in;
		ObjectOutputStream out;
		try {
			socket = new Socket("127.0.0.1",1050);
			System.out.println("Connected to server.");
			in = new ObjectInputStream(socket.getInputStream()); 
			out = new ObjectOutputStream (socket.getOutputStream());
			while (true)
			{				
				try {
					task = (DistributedTask)in.readObject();
					result = TaskExecute(task);
					out.writeObject(result);
				} 
				catch (ClassNotFoundException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ArrayList<Long> TaskExecute(DistributedTask task)
	{
		ArrayList<Long> result = new ArrayList<Long>(); 
		for (long i=task.getstartnum();i<task.getendnum();i++)
		{
			boolean prime = true;
			for (int k=2;k<i;k++)
			{
				if ((i%k)==0)
				{
					prime = false;
					break;
				}
			}
			if (prime) result.add(i);	
		}
		return result;
	}

}
