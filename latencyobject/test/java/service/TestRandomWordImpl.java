package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestRandomWordImpl {

	@Test
	public void randomWord() {
		RandomWordImpl rw = new RandomWordImpl();
		String testString = rw.createWord();
		int length = testString.length();
		assertTrue(testString instanceof String && length <= 13 && length != 0 
				&& (testString.charAt(length-1) == ' '));
	}
}
 