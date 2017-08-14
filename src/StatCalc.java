
import java.awt.IllegalComponentStateException;
import java.util.Stack;

public class StatCalc {
	
private Stack<Integer> numbers = new Stack<Integer>();
private int max=0;
private int min=0;
private int sum=0;

public StatCalc()
{	
}

public void enter(int item)
{
	if ((item>max)||(getCount()==0))
	{
		max = item;
	}
	if ((item<min)||(getCount()==0))
	{
		min = item;
	}

	numbers.add(item);
	sum+=item;
}
public int getCount()
{
	return numbers.size();
}
public int getSum()
{
	if (numbers.size() ==0)
		throw new IllegalComponentStateException("No elements added");
	return sum;
}
public int getMax()
{
	if (numbers.size() ==0)
		throw new IllegalComponentStateException("No elements added");
	return max;
}
public int getMin()
{
	if (numbers.size() ==0)
		throw new IllegalComponentStateException("No elements added");
	return min;
}
public double getMean()
{
	if (numbers.size() ==0)
		throw new IllegalComponentStateException("No elements added");
	return (double)getSum()/getCount();
}
public double getStandardDeviation()
{
	if (numbers.size() ==0)
		throw new IllegalComponentStateException("No elements added");
	
	double deviationSum=0;
	double mean = getMean();
	for (int i=0;i<numbers.size();i++)
	{
		deviationSum += Math.abs(mean - numbers.get(i));
	}
	
	return ((double)deviationSum/getCount());
}
}
