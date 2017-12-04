package problemset2;

public class CheckAnagrams {

	public static void main(String[] args) {
		
		/****Check how many characters need to be changed to make two string anagram of each-other
		 * In below example
		 * aabbcc- 2a, 2b,2c
		 * ddbbcc- 2d, 2b, 2c
		 * 
		 * 
		 *  aabbca- 3a, 2b,1c
		 * ---------------
		 * 2|2|2|0|0|0----
		 * ---------------
		 * 
		 * ddbbcc- 2d, 2b, 2c
		 * -----------
		 * 0|2|2|2|0|0----
		 * -----------
		 * 
		 * difference is:
		 * (2-0)+(2-2)+(2-2)+(2-0)+0+0+----
		 * =4
		 * So 4 letters need to be changed from two Strings
		 * so the answer is 4/2=2 characters need to be changed in one string to make it anagram of another.
		 * 
		 * ***/
		
		String first ="aabbcc";
		String second="ddbbcc";
		
		System.out.println(checkAnagrams(first,second));
		
		//Logic is to first check 
		
		
	}

	static int[] getMinimumDifference(String[] a, String[] b) {

		int[] arr = new int[a.length];
		if (a.length != b.length) {

			arr[0] = -1;
			return arr;
		} else {

			for (int i = 0; i < a.length; i++) { // n times
				int count = 0;

				count = checkAnagrams(a[i], b[i]);
				arr[i] = count;

			}

		}
		return arr;
	}

	static int checkAnagrams(String firstString, String secondString) {
		int diff = 0;
		if (firstString.length() != secondString.length()) { // constant time

			return -1;

		} else {

			int[] letterCountsFirst = getLetterCounts(firstString); // takes
																	// O(n)
			int[] letterCountsSecond = getLetterCounts(secondString);// takes
																		// O(n)

			diff = getDifference(letterCountsFirst, letterCountsSecond);

		}
		return diff;

	}

	private static int getDifference(int[] letterCountsFirst, int[] letterCountsSecond) {

		int diff = 0;
		for (int i = 0; i < letterCountsFirst.length; i++) { // n times

			diff = diff + Math.abs(letterCountsFirst[i] - letterCountsSecond[i]);

		}

		return (diff / 2);
	}

	private static int[] getLetterCounts(String anagrams) {

		int[] totalLetters = new int[26];// total no of english characters..

		for (int i = 0; i < anagrams.length(); i++) { // n times

			int index = anagrams.charAt(i) - (int) 'a';
			totalLetters[index]++;

		}
		return totalLetters;

	}
}
