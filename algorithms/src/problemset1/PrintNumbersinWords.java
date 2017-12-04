package problemset1;

public class PrintNumbersinWords {

	public static void main(String[] args) {
		String single_digits[] = { "zero", "one", "two", "three", "four",
				"five", "six", "seven", "eight", "nine" };
		String two_digits[] = { "", "ten", "eleven", "twelve", "thirteen",
				"fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
				"nineteen" };
		String tens_multiple[] = { "", "", "twenty", "thirty", "forty",
				"fifty", "sixty", "seventy", "eighty", "ninety" };
		String tens_power[] = { "hundred", "thousand" };

		for (int i = 0; i < 100; i++) {
			if (i < 10) {
				System.out.println(single_digits[i]);
			}

			else if (i >= 10 && i < 20) {
				System.out.println(two_digits[(int) (i % 10)+1]);
			}

			else if (i >= 20 && i < 100) {
				System.out.println(tens_multiple[(int) (i / 10)] + " "
						+ (single_digits[(int) (i % 10)].equalsIgnoreCase("zero")?"":single_digits[(int) (i % 10)]));
			}
		}

	}

}
