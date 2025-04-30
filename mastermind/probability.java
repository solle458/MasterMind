import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class probability {
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

	public static HashMap<Character, Integer> initContains() {
		HashMap<Character, Integer> contains = new HashMap<>();
		for (char c : alphabet) {
			contains.put(c, 0);
		}
		return contains;
	}

	public static void answer() {
		int size = MasterMind.getzigen();
		int limit = MasterMind.getlimit();
		int[][] hints = new int[2][2];
		char[] guess = initDeck(size);
		HashMap<Character, Integer> contains = initContains();

		System.err.println("max = " + size*13 + " size = " + size + " limit = " + limit);

		for(char c : alphabet){
			for(int i = 0; i < size; i++) guess[i] = c;
			hints[0] = Arrays.copyOf(MasterMind.evaluate(guess), 2);
			contains.put(c, hints[0][0]);
		}

		List<Entry<Character, Integer>> sortedMap = new ArrayList<>(contains.entrySet());
		sortedMap.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

		for(int i = 0; i < size; i++){
			int prev = 25;
			int[] save = hints[0];
			for(Entry<Character, Integer> entry : sortedMap){
				char c = entry.getKey();
				guess[i] = c;
				hints[1] = Arrays.copyOf(MasterMind.evaluate(guess), 2);
				if(save[0] != hints[1][0])break;
				prev = c-'A';
			}
			hints[0] = Arrays.copyOf(hints[1], 2);
			if(hints[1][0] < save[0]){
				guess[i] = alphabet[prev];
				hints[0][0]++;
			}
			contains.put(guess[i], contains.get(guess[i]) - 1);
			sortedMap = new ArrayList<>(contains.entrySet());
			sortedMap.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
		}
		MasterMind.submit(guess);
	}
}
