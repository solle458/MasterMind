import java.util.Random;

public class Seikai {

	public static char[] deck = NewDeck();

	public static char[] NewDeck(){
		Random rand = new Random();
		// int size = rand.nextInt(100) + 1;
		int size= 50;
		char[] deck = new char[size];
		for(int i=0; i<size; i++){
			deck[i] = (char) ('A' + rand.nextInt(26));
		}
		return deck;
	}

}
