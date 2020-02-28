import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class Driver {
	static String[] words;
	static int[] scores; 
	public static void main(String... args) {
		try(BufferedReader reader = new BufferedReader(new FileReader(new File("input\\input00.txt")))) {
			reader.readLine();
			words = reader.readLine().split(" ");
			scores = Stream.of(reader.readLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
			int numberOfTests = Integer.parseInt(reader.readLine());
			long minScore = Long.MAX_VALUE;
			long maxScore = Long.MIN_VALUE;
			for(int i = 0; i < numberOfTests; i++) {
				String problemString = reader.readLine();
				int[] bounds = Stream.of(problemString.split(" ")).limit(2).mapToInt(s -> Integer.parseInt(s)).toArray();
				String toTest = problemString.split(" ")[2];
				long score = drive(bounds, toTest);
				if(score > maxScore)
					maxScore = score;
				if(score < minScore)
					minScore = score;
			}
			System.out.println("Min score: " + minScore + " Max score: " + maxScore);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static long drive(int[] bounds, String toTest) {
		ACFinder finder = new ACFinder();
		for(int i = bounds[0]; i <= bounds[1]; i++) {
			finder.addWord(words[i]);
		}
		HashMap<String, Integer> result = finder.getTest(toTest);
		int score = 0;
		for(int j = bounds[0]; j <= bounds[1]; j++) {
			
		}
		System.out.println(result);
		System.out.println(toTest);
		System.out.println(score);
		return score;
	} 
}
