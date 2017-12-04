package problemset1;

import java.util.Scanner;

public class HackerRank {

	public static void main(String[] args) {
		int i = 4;
		double d = 4.0;
		String s = "HackerRank ";

		Scanner scan = new Scanner(System.in);
		int j = 0;
		double p = 0.0;
		String text = "";

		j = scan.nextInt();
		p = scan.nextDouble();
		text = scan.next();
		int scale = (int) Math.pow(10, 1);
		p = (double) Math.round(p * scale) / scale;
		text = s + text;
		System.out.println(j + i);
		System.out.println(p + d);
		System.out.println(text);

		scan.close();
	}

}
