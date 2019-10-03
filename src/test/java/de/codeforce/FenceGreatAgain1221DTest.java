package de.codeforce;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.hamcrest.Matchers;


import de.codeforces.FenceGreatAgain1221D;
import de.codeforces.FenceGreatAgain1221D.Board;
import de.codeforces.FenceGreatAgain1221D.Fence;


public class FenceGreatAgain1221DTest {

	@Test
	public void createBoardFromLine() {
		String anyLine = "3 5";
		
		Board board = Board.fromString(anyLine);
		assertThat(board.getLength(), Matchers.is(3L));
		assertThat(board.getIncreasePrice(), Matchers.is(5L));
	}
	
	@Test
	public void initialGreatFench() {
		Fence fence = new Fence(4);
		fence.addBoard(Board.fromString("1 7"));
		fence.addBoard(Board.fromString("3 3"));
		fence.addBoard(Board.fromString("2 6"));
		fence.addBoard(Board.fromString("1000000000 2"));
		
		assertThat(fence.isGreat(), Matchers.is(true));
	}
	
	@Test
	public void greatFenceAfterIncrease() {
		Fence fence = new Fence(3);
		Board firstBoard = Board.fromString("2 4");
		Board secondBoard = Board.fromString("2 1");
		Board thirdBoard = Board.fromString("3 5");
		fence.addBoard(firstBoard);
		fence.addBoard(secondBoard);
		fence.addBoard(thirdBoard);
		
		assertThat("initially great", fence.isGreat(), Matchers.is(false));
		secondBoard.increase();
		secondBoard.increase();
		
		assertThat("great after increase", fence.isGreat(), Matchers.is(true));
	}
	
	@Test
	public void priceIncreasedFence() {
		Fence fence = new Fence(3);
		Board firstBoard = Board.fromString("2 4");
		Board secondBoard = Board.fromString("2 1");
		Board thirdBoard = Board.fromString("3 5");
		fence.addBoard(firstBoard);
		fence.addBoard(secondBoard);
		fence.addBoard(thirdBoard);
		
		fence.makeGreat();
		
		assertThat("great after increase", fence.getTotalPrice(), Matchers.is(2L));
	}
	
	@Test
	public void exampleInProblemDescription() {
		String [] lines = {"3" ,"3", "2 4", "2 1", "3 5", "3", "2 3", "2 10", "2 6", "4", "1 7", "3 3", "2 6","1000000000 2"};
		String [] expectedOutput = {"2", "9", "0"};
		System.out.println(Stream.of(new FenceGreatAgain1221D().getCalculatedString(lines)).collect(Collectors.toList()));
		assertThat(new FenceGreatAgain1221D().getCalculatedString(lines), Matchers.arrayContaining(expectedOutput));
	}
}
