import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class contains {
	public static char[] alphabet = createAlphabet();

	public static char[] createAlphabet() {
		char[] alphabet = new char[26];
		for (int i = 0; i < 26; i++) {
			alphabet[i] = (char) ('A' + i);
		}
		return alphabet;
	}

	public static char[] initDeck(int size) {
		char[] deck = new char[size];
		for(int i=0; i<size; i++){
			deck[i] = 'A';
		}
		return deck;
	}

	public static HashMap<Character, Boolean> initContains() {
		HashMap<Character, Boolean> contains = new HashMap<>();
		for (char c : alphabet) {
			contains.put(c, true);
		}
		return contains;
	}

	public static void answer() {
		int size = MasterMind.getzigen();
		int limit = MasterMind.getlimit();
		int[][] hints = new int[2][2];
		char[] guess = initDeck(size);
		HashMap<Character, Boolean> contains = initContains();
		// System.err.println("max = " + size*13 + " size = " + size + " limit = " + limit);

		hints[0] = Arrays.copyOf(MasterMind.evaluate(guess), 2);
		hints[1] = Arrays.copyOf(hints[0], 2);

		for(int i = 0; i < size; i++){
			int prev = 0;
			int[] save = hints[0];
			for(int j = 1; j <= 26; j++){
				int idx = j % 26;
				if(!contains.get(alphabet[idx]))continue;
				guess[i] = alphabet[idx];
				hints[1] = Arrays.copyOf(MasterMind.evaluate(guess), 2);
				if(hints[1][1] == 0)contains.put(alphabet[idx], false);
				if(save[0] != hints[1][0])break;
				prev = idx;
			}
			hints[0] = Arrays.copyOf(hints[1], 2);
			if(hints[1][0] < save[0]){
				guess[i] = alphabet[prev];
				hints[0][0]++;
			}
			contains.put(guess[i], true);
		}

		MasterMind.submit(guess);
	}
}
