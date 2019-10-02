package de.codeforces;
import java.util.ArrayList;
import java.util.Scanner;

public class Game2048 {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

	int q = s.nextInt();
	for (int i = 0; i < q; i++) {
	    int n = s.nextInt();
	    ArrayList<Integer> nums2 = new ArrayList<Integer>();
	    for (int j = 0; j < n; j++) {
		nums2.add(new Integer(s.nextInt()));
	    }
	    ArrayList<Integer> nums = new ArrayList<Integer>();
	    for (Integer j : nums2) {
		if (j <= 2048) {
		    nums.add(j);
		}
	    }
	    int sum = 0;
	    for (int j : nums) {
		sum += j;
	    }
	    if (sum >= 2048) {
		System.out.println("YES");
	    } else {
		System.out.println("NO");
	    }
	}

	s.close();

    }

}
