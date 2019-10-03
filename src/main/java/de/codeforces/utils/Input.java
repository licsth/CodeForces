package de.codeforces.utils;

import java.io.InputStream;
import java.util.Scanner;

public class Input {
	
	public static final Input getConsoleInput() {
		return new Input(System.in);
	}

	public Input(InputStream inputStream) {
		if (inputStream == null) {
			throw new NullPointerException("inputStream is null");
		}
		this.inputStream = inputStream;
	}
	
	private InputStream inputStream;
	
	private Scanner createScanner() {
		return new Scanner(inputStream);
	}
	
	public String getLine() {
		Scanner scanner = createScanner();
		String line = getLine(scanner);
		scanner.close();
		return line;
	}
	
	public String getLine(String description) {
		System.out.println(description);
		return getLine();
	}
	
	public String[] getLines(int count) {
		Scanner scanner = createScanner();
		String[] lines = new String[count];
		for (int i = 0 ; i < count ; i++) {
			lines[i] = getLine(scanner);
		}
		scanner.close();
		return lines;
	}
	
	public String[] getLines(String ...descriptions) {
		Scanner scanner = createScanner();
		String[] lines = new String[descriptions.length];
		for (int i = 0 ; i < lines.length ; i++) {
			System.out.println(descriptions[i]);
			lines[i] = getLine(scanner);
		}
		scanner.close();
		return lines;
	}
	
	private String getLine(Scanner scanner) {
		return scanner.nextLine();
	}
	
}
