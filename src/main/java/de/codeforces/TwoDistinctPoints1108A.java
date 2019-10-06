package de.codeforces;

import java.util.Scanner;

public class TwoDistinctPoints1108A {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int queriesNum = s.nextInt();
        for (int i = 0; i < queriesNum; i++) {
            int l1 = s.nextInt();
            s.nextInt(); // unused r2
            int l2 = s.nextInt();
            int r2 = s.nextInt();

            if (l1 != l2) {
                System.out.println(l1 + " " + l2);
            } else {
                System.out.println(l1 + " " + r2);
            }
        }

        s.close();
    }
}
