public class Solver {

	public static void answer(){
		int N = MasterMind.getzigen();
		int THRESHOLD = 10;

		if (N <= THRESHOLD) {
			contains.answer();
		} else {
			probability.answer();
		}
	}
}
