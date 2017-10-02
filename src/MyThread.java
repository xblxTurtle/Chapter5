import java.util.concurrent.ConcurrentLinkedQueue;

public class MyThread extends Thread{
	
	private ConcurrentLinkedQueue<Runnable> tasks;
	public MyThread(ConcurrentLinkedQueue<Runnable> tasks)
	{
		super();
		this.tasks = tasks;
	}
	public void run()
	{
		while (!tasks.isEmpty())
		{
			Runnable task = tasks.poll();
			task.run();
		}
	}
}
