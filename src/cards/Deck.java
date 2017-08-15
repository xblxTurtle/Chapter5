package cards;
import java.util.Stack;

import cards.Card.Suit;

public class Deck {
	
	private int cardNumber;
	private Stack<Card> cards = new Stack<Card>();
	public Deck()
	{
		cardNumber = 52;
		for (int i=1;i<=13;i++) {
			cards.push(new Card(Card.Suit.CLUBS,i));
			cards.push(new Card(Card.Suit.DIAMONDS,i));
			cards.push(new Card(Card.Suit.HEARTS,i));
			cards.push(new Card(Card.Suit.SPADES,i));
		}
		Shuffle();
	}
	
	public void Shuffle()
	{
		Stack<Card> newCards = new Stack<Card>();
		while (cards.size() > 0)
		{
			Card card = cards.remove((int)(cards.size()*Math.random()));
			newCards.push(card);
		}
		cards = newCards;
	}
	
	public Card DealCard()
	{
		return cards.pop();
	}

	public int getCardLeft() {
		return cards.size();
	}

	public int getCardNumber() {
		return cardNumber;
	}

}
