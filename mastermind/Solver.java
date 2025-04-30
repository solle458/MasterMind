import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

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
