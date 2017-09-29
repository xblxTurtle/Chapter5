import java.io.Serializable;
public class StorageObject implements Serializable {

	public String str;
	public int number;
	public StorageObject(int number, String str)
	{
		this.number = number;
		this.str = str;
	}
	
	public String toString()
	{
		return String.format("This object has number = %d and string = %s", number, str);
	}
}
