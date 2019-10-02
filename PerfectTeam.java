import java.util.Scanner;

public class PerfectTeam {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);

	int q = s.nextInt();
	for (int i = 0; i < q; i++) {
	    int c = s.nextInt();
	    int m = s.nextInt();
	    int x = s.nextInt();
	    System.out.println(Math.min((c + m + x) / 3, Math.min(c, m)));
	}

	s.close();
    }

}
