package cards;

public class Card {
	public enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS};
	private final Suit suit;
	private final int value;
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public Card(Suit suit, int value)
	{
		if ((value >=1) && (value <=13))
		{
			this.suit = suit;
			this.value = value;
		}
		else throw new IllegalArgumentException();
	}
	
	public String getValueAsString()
	{
		switch (value)
		{
			case 1: return "Ace";
			case 2: return "2";
			case 3: return "3";
			case 4: return "4";
			case 5: return "5";
			case 6: return "6";
			case 7: return "7";
			case 8: return "8";
			case 9: return "9";
			case 10: return "10";
			case 11: return "Jack";
			case 12: return "Queen";
			default: return "King";
		}
	}
	public String toString()
	{
		return suit.toString() + " " + getValueAsString();
	}

}
