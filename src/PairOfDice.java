
public class PairOfDice {

	private final int dice1Size;
	private final int dice2Size;
	private int dice1;
	private int dice2;
	
	public int getDice1()
	{
		return dice1;
	}
	public int getDice2()
	{
		return dice2;
	}
	public int getDice1Size()
	{
		return dice1Size;
	}
	public int getDice2Size()
	{
		return dice2Size;
	}
	public PairOfDice(int dice1Size, int dice2Size)
	{
		this.dice1Size = dice1Size;
		this.dice2Size = dice2Size;
	}
	public void RollDices()
	{
		dice1 = (int)(Math.random()* dice1Size)+1;
		dice2 = (int)(Math.random()* dice2Size)+1;
		
	}
}
