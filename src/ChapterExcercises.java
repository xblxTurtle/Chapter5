
public class ChapterExcercises {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiceGame();

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

}
