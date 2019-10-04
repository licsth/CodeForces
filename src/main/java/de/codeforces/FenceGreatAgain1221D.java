package de.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class FenceGreatAgain1221D {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> inputList = new ArrayList<>();
		
		String line = scanner.nextLine();
		inputList.add(line);
		int countFences = Integer.parseInt(line);
		
		for (int fenceIndex = 0 ; fenceIndex < countFences ; fenceIndex++) {
			line = scanner.nextLine();
			inputList.add(line);
			int countBoards = Integer.parseInt(line);
			for (int boardInFenceIndex = 0 ; boardInFenceIndex < countBoards ; boardInFenceIndex++) {
				inputList.add(scanner.nextLine());
			}
		}
		scanner.close();
		Stream.of(new FenceGreatAgain1221D().getCalculatedString(inputList.stream().toArray(String[]::new))).forEach(System.out::println);
	}

	public String[] getCalculatedString(String [] input) {
		List<Fence> fences = new ArrayList<>();
		Iterator<String> inputIterator = Arrays.stream(input).iterator();
		
		int countFences= getIntOf(inputIterator.next());
		
		for (int iQuery = 0 ; iQuery < countFences; iQuery++) {
			int countBoards = getIntOf(inputIterator.next());
			Fence fence = new Fence(countBoards);
			for (int iBoard = 0 ; iBoard <  countBoards ; iBoard++) {
				fence.addBoard(Board.fromString(inputIterator.next()));
			}
			
			fences.add(fence);
		}
		
		fences.parallelStream().forEach(Fence::makeGreat);
		return fences.stream().map((f) -> "" + f.getTotalPrice()).toArray(String[]::new);
		
	}
	private int getIntOf(String text) {
		return Integer.parseInt(text);
	}
	
	public static class Fence{
		private List<Board> boards = new ArrayList<>();
		private long totalPrice = 0L;

		public Fence(int countBoards) {
			boards = new ArrayList<>(countBoards);
		}
		
		public void addBoard(Board board) {
			boards.add(board);
		}
		
		public void makeGreat() {
			if (!isGreat()) {
				boards.parallelStream().forEach(Board::resetToInitial);
				
				totalPrice = calculatePrice(0L, 0);
			}
		}
		
		public long calculatePrice(long add, int position) {
			long result = Long.MAX_VALUE;
			if (position==boards.size()) {
				return 0L;
			}
			for (long x = 0 ; x <= 2 ; ++x) {
				if (position == 0 || boards.get(position).getLength() + x != boards.get(position-1).getLength() + add) {
					result = Math.min(result, calculatePrice(x, position+1) + x * boards.get(position).getIncreasePrice());
				}
			}
			
			return result;
		}
		
		
		public boolean isGreat() {
			boolean great = true;
			for (int i = 1 ; i < boards.size() ; i++) {
				if (boards.get(i).hasEqualLength(boards.get(i-1))) {
					great = false;
					break;
				}
			}
			return great;
		}
		
		public long getTotalPrice() {
			return totalPrice;
		}
	}
	
	public static class Board{
		private long initialLength;
		private long increasePrice;
		private long length;
		private long totalPrice;
		
		
		public Board(long length, long increasePrice) {
			this.initialLength = length;
			this.length = length;
			this.increasePrice = increasePrice;
			this.totalPrice = 0L;
		}
		
		public static Board fromString(String lengthAndPrice) {
			String [] splittet = lengthAndPrice.split(" ");
			return new Board(Long.parseLong(splittet[0]), Long.parseLong(splittet[1]));
		}
		
		public void resetToInitial() {
			this.length = initialLength;
			this.totalPrice = 0L;
		}

		public long getLength() {
			return length;
		}

		public long getIncreasePrice() {
			return increasePrice;
		}
		
		public long getTotalPrice() {
			return totalPrice;
		}
		
		public void increase() {
			length++;
			totalPrice += increasePrice;
		}
		
		public boolean hasEqualLength(Board board) {
			return length == board.getLength();
		}
		
	}
}
