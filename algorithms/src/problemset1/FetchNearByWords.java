package problemset1;

import java.util.HashSet;
import java.util.Set;

public class FetchNearByWords {

	public static void main(String[] args) {

		long nanorecursion = System.nanoTime();
		System.out.println(startPermutationByRecursion("hhi"));
		System.out.println(System.nanoTime() - nanorecursion) ;
		long nanosnestedFor = System.nanoTime() ;
		Set<String> wordPermutationSet = new HashSet<String>();
		wordPermutationSet.add("");
		Set<String> finalPermutationSet = new HashSet<String>();
		char[] wordArray = "hhi".toCharArray();
		for (int i = wordArray.length - 1; i >= 0; i--) {
			if (finalPermutationSet.size() != 0) {
				wordPermutationSet = finalPermutationSet;
				finalPermutationSet = new HashSet<String>() ;
			}
			Set<Character> nearByWords = getNearByWords(wordArray[i]);
			for (char elem : nearByWords) {
				for (String str : wordPermutationSet) {
					finalPermutationSet.add(elem + str);
				}

			}
             
		}

		System.out.println(finalPermutationSet);
		System.out.println(System.nanoTime() - nanosnestedFor) ;

	}

	public static Set<String> startPermutationByRecursion(String word) {

		char[] wordArray = word.toCharArray();
		return (doPermutation(wordArray, 0));

	}

	public static Set<String> doPermutation(char[] wordArray, int index) {

		if (index >= wordArray.length) {

			Set<String> permutationSet = new HashSet<String>();
			permutationSet.add("");
			return permutationSet;
		}

		Set<String> permutationSet = doPermutation(wordArray, index + 1);
		Set<Character> nearByWords = getNearByWords(wordArray[index]);
		Set<String> finalPermutationSet = permutate(permutationSet, nearByWords);

		return finalPermutationSet;

	}

	public static Set<String> permutate(Set<String> permutationSet,
			Set<Character> nearByWords) {
		Set<String> finalPermutationSet = new HashSet<String>();
		for (char elem : nearByWords) {
			for (String innerelem : permutationSet) {

				finalPermutationSet.add(elem + innerelem);

			}
		}

		return finalPermutationSet;

	}

	public static Set<Character> getNearByWords(Character character) {
		HashSet<Character> characters = new HashSet<>();
		if (character == 'h') {
			characters.add('g');
			characters.add('h');
			characters.add('f');
		} else {
			characters.add('i');
			characters.add('o');
			characters.add('k');
		}
		return characters;
	}

}
