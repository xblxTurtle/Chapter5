import java.util.*;
public class NotifyExample {
	static public Object lock = new Object(); 
	enum status {run, pause, exit};
	public static status st;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		st = status.run;
		NotifyableThread thread = new NotifyableThread();
		thread.start();
		Scanner sc = new Scanner(System.in);
		String c = "r";
		while (!c.equals("q"))
		{
				c = sc.next();
				System.out.printf("Entered symbol: %s\n",c);
			
			if (c.equals("r"))
			{
				synchronized(lock)
				{
					st = status.run;
					lock.notify();
				}
			} else
				if (c.equals("p"))
				{
					st = status.pause;
				} else
					if (c.equals("e"))
					{
						st = status.exit;
					}
				
		}
	}

}
