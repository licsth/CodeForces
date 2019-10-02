import java.util.Scanner;

public class Cards {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	s.nextLine();
	char[] str = s.nextLine().toCharArray();
	int z = 0;
	int n = 0;
	for (char st : str) {
	    if (st == 'z') {
		z++;
	    }
	    if (st == 'n') {
		n++;
	    }
	}
	for (int i = 0; i < n; i++) {
	    System.out.print(1 + " ");
	}
	for (int i = 0; i < z; i++) {
	    System.out.print(0 + " ");
	}
	s.close();
    }

}
