package cards;

public class BlackJackHand extends Hand{
	/*
	 *  The value of a numeric card such as a three or a ten is its numerical value. 
	 *  The value of a Jack, Queen, or King is 10. 
	 *  The value of an Ace can be either 1 or 11. 
	 *  An Ace should be counted as 11 unless doing so would put the total value of the hand over 21. 
	 *  Note that this means that the second, third, or fourth Ace in the hand will always be counted as 1.
	 */
	public int getBlackjackValue()
	{
		boolean ace = false;
		int sum = 0;
		for(Card card:cards)
		{
			int value = card.getValue(); 
			if ((value == 11)||(value == 12)||(value == 13))
			{
				value = 10;
			} else
			if (value == 1)
			{
				ace = true;
			}
			sum += value;
		}
		if (ace && ((sum + 10)<=21))
		{
			sum+=10;
		}
		return sum;
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for(Card card:cards)
		{
			sb.append(card.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	public String toStringDealer()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i< cards.size();i++)
		{
			if (i==0)
			{
				sb.append("Card is hidden \n");
			}
			else
			{
				sb.append(cards.get(i).toString());
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}
