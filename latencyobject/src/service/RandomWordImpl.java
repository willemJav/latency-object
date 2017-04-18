package service;

import java.util.Random;
import interfaces.RandomWord;
import utility.LatencyObject;


/**
 * 
 * @author wfristdr
 * 
 * The class implements the RandomWord interface with its only method createWord
 * The createWord method creates a single word
 * of 1 to 12 characters in a random manner.
 * There are three type of random words:
 * small up to 3 characters
 * medium from 4 to 7
 * large from 7 to 12
 * The medium sized words appear with most often.
 * After each word there is a single space.
 */
public class RandomWordImpl implements RandomWord {
	
	/**
	 * 
	 * @return length of a single word (character) as int
	 */
	private int  randomWordLength() {
		Random rn = new Random();
		int wordLength = 7;
		
		int number = rn.nextInt(10) + 1;
		if (number < 3) {
			wordLength = rn.nextInt(3) + 1;
		} else
		if (number > 8) {
			wordLength = rn.nextInt((12 - 8) + 1) + 8;
		} else {
			wordLength = rn.nextInt((7 - 3) + 1) + 3;
		}
		return wordLength;
	}

	/**
	 * 
	 * @param the number of characters as int
	 * @return the single word as string
	 */
	private String randomWord(int length) {
	    Random random = new Random();
	    StringBuilder word = new StringBuilder(length);
	    for (int i = 0; i < length; i++) {
	        word.append((char)('a' + random.nextInt(26)));
	    }
	    word.append(" ");
	    return word.toString();
	}
	
	@Override
	/**
	 * @return the single word as string
	 * The duration of the create word method will be saved into list of LatencyObject in ms.
	 */
	public String createWord() {
		long startTime = System.currentTimeMillis();
		String word = randomWord(randomWordLength());
		LatencyObject.getInstance().getDurationWordCreateList().add(System.currentTimeMillis() - startTime);
		return word;
	}
}
