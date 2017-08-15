import cards.*;

public class ChapterExcercises {

	public static void main(String[] args) {
		//DiceGame();
		//Statistics();
		BlackJackGame();
	}
	public static void BlackJackGame()
	{
		boolean continueGame = true;
		System.out.println("Welcome to the game of BlackJack with computer:");
		
		while (continueGame)
		{
			Deck deck = new Deck();
			BlackJackHand hand = new BlackJackHand(); 
			int randomCardsCount = (int)(Math.random()*5)+2;
			for (int i=0;i<randomCardsCount;i++)
			{
				Card card = deck.DealCard();
				System.out.println("Dealt card is : " + card.toString());
				hand.AddCard(card);
			}
			System.out.printf("Hand value is :%d\n", hand.getBlackjackValue());
			System.out.println("Do you want to play another game? (any key to continue, \"0\" to exit)");
			if (TextIO.getAnyChar() == '0')
				continueGame=false;
		}
	}
	public static void DiceGame()
	{
		PairOfDice dices = new PairOfDice(6,6);
		int rollCount;
		char input;
		do 
		{
			rollCount=0;
			do
			{
				dices.RollDices();
				rollCount++;
			}
			while (dices.getDice1() != dices.getDice2());
			
			System.out.printf("Number of rolls before dices are equal is: %d \n",rollCount);
			System.out.println("Do you want ot play again? (press any key to continue, \"0\" to exit)");
			input = TextIO.getAnyChar();
		}
		while(input != '0');
	}
	public static void Statistics()
	{
		int input;
		StatCalc calc= new StatCalc();
		System.out.println("Please enter elements of the set (only integer). Input \"0\" when input is finished.");
		
		input = TextIO.getlnInt();
		while (input != 0)
		{
			calc.enter(input);
			input = TextIO.getlnInt();
		}
		
		if (calc.getCount() != 0)
		{
			System.out.printf("Number of items in set is :%d\n", calc.getCount());
			System.out.printf("Minimum of all items in set is :%d\n", calc.getMin());
			System.out.printf("Maximum of all items in set is :%d\n", calc.getMax());
			System.out.printf("Sum of all items in set is :%d\n", calc.getSum());
			System.out.printf("Average of all items in set is :%.2f\n", calc.getMean());
			System.out.printf("Deviation of all items in set is :%.2f\n", calc.getStandardDeviation());
		}
		else
			System.out.println("Your input was empty.");
	}

}
