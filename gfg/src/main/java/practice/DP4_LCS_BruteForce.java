package practice;

import java.util.ArrayList;
import java.util.List;

public class DP4_LCS_BruteForce {

	public static String lcs(String s1, String s2) {

		List<String> xSeqs = generateSequences(s1);
		List<String> ySeqs = generateSequences(s2);

		String maxFound = "";
		for (int i = 0; i < xSeqs.size(); i++) {
			String xSeq = xSeqs.get(i);
			for (int j = 0; j < ySeqs.size(); j++) {
				String ySeq = ySeqs.get(j);
				if (ySeq.equalsIgnoreCase(xSeq)) {
					System.out.println("Found Matching " + xSeq);
					if (xSeq.length() > maxFound.length())
						maxFound = xSeq;
				}
			}
		}

		return maxFound;
	}

	private static List<String> generateSequences(String original) {
		List<String> substrings = new ArrayList<>();

		generate(original, -1, "", substrings);

		return substrings;
	}

	private static void generate(String original, int index, String current, List<String> substrings) {

		if (index == original.length())
			return;

		substrings.add(current);

		for (int i = index + 1; i < original.length(); i++) {
			current = current + original.charAt(i);
			generate(original, i, current, substrings);
			current = current.substring(0, current.length() - 1);
		}
	}

	public static void main(String args[]) {

		String s1 = "ABCDGH";
		String s2 = "AEDFHR";

		System.out.println(lcs(s1, s2));
	}

}