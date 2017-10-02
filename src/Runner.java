
public class Runner implements Runnable {
	private int start;
	private int finish;
	public Runner(int start, int finish)
	{
		this.start = start;
		this.finish = finish;
	}
	public void run() {
		
		for (int i = start; i< finish; i++)
		{
			boolean simple = true;
			for (int k=2;k<i;k++)
			{
				if (i % k == 0)
				{
					simple = false;
					break;
				}
			}
			if (simple)
				System.out.printf("Simple number : %d\n",i);
		}
		
	}
	
}
