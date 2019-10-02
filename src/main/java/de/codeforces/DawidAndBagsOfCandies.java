package de.codeforces;
import java.util.Scanner;

public class DawidAndBagsOfCandies {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	String[] str = s.nextLine().split(" ");
	s.close();
	int x = str.length;
	int[] n = new int[x];
	int sum = 0;
	for (int i = 0; i < x; i++) {
	    n[i] = Integer.parseInt(str[i]);
	    sum += n[i];
	}
	if (sum % 2 == 1) {
	    System.out.println("NO");
	    System.exit(0);
	}
	sum /= 2;
	int max = 0;
	for (int i = 0; i < x; i++) {
	    if (n[i] > max) {
		max = n[i];
	    }
	}
	if (max > sum) {
	    System.out.println("NO");
	    System.exit(0);
	}
	if (max == sum) {
	    System.out.println("YES");
	    System.exit(0);
	}
	sum -= max;
	for (int i = 0; i < x; i++) {
	    if (n[i] == sum) {
		System.out.println("YES");
		System.exit(0);
	    }
	}
	System.out.println("NO");
    }

}
