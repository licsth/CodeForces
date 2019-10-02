import java.util.Scanner;

public class Knights {

    int[][] b;

    public static void main(String[] args) {
	new Knights();

    }

    public Knights() {
	Scanner s = new Scanner(System.in);
	int n = s.nextInt();
	s.close();
	b = new int[n][n];
	b[0][0] = 1;
	boolean unfinished = true;
	int lastunf = 0;
	int unf = 0;
	while (unfinished) {
	    unf = 0;
	    unfinished = false;
	    for (int i = 0; i < b.length; i++) {
		for (int j = 0; j < b[i].length; j++) {
		    if (b[i][j] > 0) {
			colorOpponents(i, j, b[i][j]);
		    } else {
			unfinished = true;
			unf++;
		    }
		}
	    }
	    if (lastunf == unf) {
		break;
	    }
	    lastunf = unf;

	}
	for (int i = 0; i < b.length; i++) {
	    for (int j = 0; j < b[i].length; j++) {
		if (b[i][j] == 0) {
		    b[i][j] = 1;
		}
	    }
	}
	printBoard();
    }

    private void printBoard() {
	for (int[] row : b) {
	    for (int i : row) {
		if (i == 1) {
		    System.out.print("B");
		} else {
		    System.out.print("W");
		}
	    }
	    System.out.println();
	}

    }

    private void colorOpponents(int x, int y, int c) {
	c = c % 2 + 1;
	for (int i = -1; i < 2; i += 2) {
	    for (int j = -1; j < 2; j += 2) {
		try {
		    if (b[x + 2 * i][y + 1 * j] == 0) {
			b[x + 2 * i][y + 1 * j] = c;
		    }
		} catch (ArrayIndexOutOfBoundsException e) {

		}
		try {
		    if (b[x + 1 * i][y + 2 * j] == 0) {
			b[x + 1 * i][y + 2 * j] = c;
		    }
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	    }
	}
    }

}
