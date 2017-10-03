import java.io.Serializable;

public class DistributedTask implements Serializable{
	private long startnum;
	private long endnum;
	
	public DistributedTask(long startnum, long endnum)
	{
		this.startnum = startnum;
		this.endnum = endnum;
	}
	public long getstartnum()
	{
		return startnum;
	}
	public long getendnum()
	{
		return endnum;
	}
}
