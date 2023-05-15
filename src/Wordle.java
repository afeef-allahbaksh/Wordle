import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wordle {
	private final String word;
	private final int[] validIndex = new int[5];
	public int numGus;

	public Wordle() {
		ArrayList<String> dict = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("src/dictionary.txt"))) {
			while (scanner.hasNext()) {
				String sc = scanner.next();
				if (sc.length() == 5) {
					dict.add(sc);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int i = (int) (Math.random() * dict.size());
		word = dict.get(i);
	}

	public int[] getValidIndex() {
		return validIndex;
	}

	public String getWord() {
		return word;
	}

	public boolean validate(int[] valid) {
		for (int i : valid) {
			if (i != 1) {
				return false;
			}
		}
		return true;
	}

	public void guess(String guess) {
		char[] guessedWrd = guess.toCharArray();
		char[] hiddenWrd = word.toCharArray();

		for (int i = 0; i < guessedWrd.length; i++) {
			if (guessedWrd[i] == hiddenWrd[i]) {
				validIndex[i] = 1;
			} else if (word.indexOf(guessedWrd[i]) != -1) {
				validIndex[i] = 0;
			} else {
				validIndex[i] = -1;
			}
		}

		numGus++;
	}
}
