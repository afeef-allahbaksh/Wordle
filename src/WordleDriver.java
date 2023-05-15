import java.util.Scanner;

public class WordleDriver {

	public static void main(String[] args) {
		Wordle game = new Wordle();

		try (Scanner sc = new Scanner(System.in)) {
			while (game.numGus < 7) {
				System.out.println("Enter your guess: ");
				String userGuess = sc.nextLine();
				game.guess(userGuess);
				int[] valid = game.getValidIndex();

				if (game.validate(valid)) {
					System.out.println(
							"You won! It took you " + game.numGus + " tries. Come back tomorrow for another game.");
					break;
				}

				int pos = 1;
				for (int value : valid) {
					if (value == 1) {
						System.out.println("The letter in place " + pos + " is in the correct spot.");
					} else if (value == 0) {
						System.out.println(
								"The letter in place " + pos + " is in the hidden word but not in the correct spot.");
					} else {
						System.out.println("The letter in place " + pos + " is not in the hidden word.");
					}
					pos++;
				}

				if (game.numGus > 6) {
					System.out.println("You lose! Better luck next time! The word was: " + game.getWord());
				}
			}
		}
	}
}
