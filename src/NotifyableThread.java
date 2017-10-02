
public class NotifyableThread extends Thread {

	public void run()
	{
		
			while (NotifyExample.st != NotifyExample.status.exit)
			{
				try {
					sleep(2000);
				} catch (InterruptedException e1) 
				{
				}
				System.out.print(".");
				synchronized(NotifyExample.lock)
				{
					if (NotifyExample.st == NotifyExample.status.pause)
					{
						try
						{
							NotifyExample.lock.wait();
						}
						catch(InterruptedException e)
						{
							
						}
					}
				}
			}
		
	}
}
