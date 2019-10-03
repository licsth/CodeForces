package de.codeforce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;

import de.codeforces.Cards;

public class CardsTest {
	
	private Cards cards = new Cards();

	@Test
	public void oneTimeZero() {
		String [] anyLines = {"4", "zero"};
		assertThat(cards.getCalculatedString(anyLines).trim(), is("0"));
	}
	
	@Test
	public void twoTimesOne() {
		String [] anyLines = {"6", "oneone"};
		assertThat(cards.getCalculatedString(anyLines).trim(), is("1 1"));
	}
	
	@Test
	public void twoTimesOneOneTimeZero() {
		String [] anyLines = {"10", "onezeroone"};
		assertThat(cards.getCalculatedString(anyLines).trim(), is("1 1 0"));
	}
	
	@Test
	public void twoTimesOneOneTimeZeroInOtherOrder() {
		String [] anyLines = {"10", "nzn00eeoer"};
		assertThat(cards.getCalculatedString(anyLines).trim(), is("1 1 0"));
	}
}
