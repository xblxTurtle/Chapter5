import java.util.concurrent.ConcurrentLinkedQueue;

public class ParrallelExample {

	public static void main(String[] args)
	{
		System.out.println("Final thread started.");
		ConcurrentLinkedQueue<Runnable> tasks = new ConcurrentLinkedQueue<Runnable>();
		for(int i=10;i>=0;i--)
		{
			tasks.add(new Runner(i*1000,(i+1)*1000));
		}
		int processorsNum = Runtime.getRuntime().availableProcessors();
		MyThread[] threads = new MyThread[processorsNum]; 
		for (int i=0;i<processorsNum;i++)
		{
			threads[i] = new MyThread(tasks);
			threads[i].start();
		}
		for (int i=0;i<processorsNum;i++)
		{
			try
			{
				threads[i].join();
			}
			catch (Exception ex)
			{
			}
		}
		System.out.println("Final thread is terminating");
	}
}
