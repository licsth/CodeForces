import java.util.Scanner;

public class AniaAndMinimizing {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt(), k = sc.nextInt();
	String s = sc.next();
	sc.close();
	String[] num = s.split("");
	if (n == 1) {
	    if (k > 0) {
		System.out.println(0);
		System.exit(0);
	    }
	}
	for (int i = 0; i < n && k > 0; i++) {
	    if (i > 0) {
		if (!num[i].equals("0")) {
		    num[i] = "0";
		    k--;
		}
	    } else {
		if (!num[i].equals("1")) {
		    num[i] = "1";
		    k--;
		}
	    }
	}
	for (int i = 0; i < n; i++) {
	    System.out.print(num[i]);
	}
    }

}
