import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solver {

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
			contains.put(c, -1);
		}
		return contains;
	}

	public static void answer() {
		int size = MasterMind.getzigen();
		int limit = MasterMind.getlimit();
		int counter = 0;
		int[][] hint = new int[2][2];
		char[] deck = initDeck(size);
		HashMap<Character, Integer> contains = initContains();

		hint[0] = Arrays.copyOf(MasterMind.evaluate(deck), 2);
		hint[1] = Arrays.copyOf(hint[0], 2);
		contains.put(deck[0], hint[0][1]);
		counter++;

		for(int i=0; i<size; i++){
			int now = deck[i] - 'A', prev = deck[i] - 'A';
			while(hint[0][0] == hint[1][0] && hint[1][0] != size){
				prev = now;
				now++;
				if(contains.get(alphabet[now % 26]) == 0) continue;
				contains.put(alphabet[prev % 26], hint[1][1] - contains.get('A'));
				deck[i] = alphabet[now % 26];
				hint[1] = Arrays.copyOf(MasterMind.evaluate(deck), 2);
				counter++;
				if(counter == limit-1) break;
			}
			if(counter == limit-1) break;
			if(hint[0][0] > hint[1][0]) deck[i] = alphabet[prev % 26];
			hint[0] = Arrays.copyOf(MasterMind.evaluate(deck), 2);
			hint[1] = Arrays.copyOf(hint[0], 2);
			counter++;
		}
		MasterMind.submit(deck);
	}
}
