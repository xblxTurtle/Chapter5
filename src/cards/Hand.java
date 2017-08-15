package cards;
import java.util.ArrayList; 

public class Hand {
	protected ArrayList<Card> cards = new ArrayList<Card>();
	
	public void AddCard(Card card)
	{
		cards.add(card);
	}
	
	public void RemoveCard(Card card)
	{
		cards.remove(card);
	}
	
	public void Clear()
	{
		cards = null;
	}
	
	public int getCardCount()
	{
		return cards.size();
	}

}
