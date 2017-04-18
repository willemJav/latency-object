package service;

import java.util.Random;
import interfaces.RandomLine;
import utility.LatencyObject;

/**
 * 
 * @author wfristdr
 * 
 * The class implements the RandomLine interface with its only method createLine.
 * The class extends the class RandomWordImpl and invokes its method creatWord.
 * The createLine method will generate a single line of random words created by
 * the createWord method of the superclass RandomWordImpl.
 * The constant WORDS_PER_LINE sets max number of characters per line
 * Each line will start with a Capital letter and terminate with a dot.
 * Each single line could have a line-break.
 */

public class RandomLineImpl extends RandomWordImpl implements RandomLine { 
	private int CHAR_PER_LINE = 75;
	private int wordCountPerLine;
	private int lineCount = 0;
	
	@Override
	/**
	 *  @return a single line of random words with a maximum of 75 characters
	 *  The duration of the create line method will be saved into list of LatencyObject in ms.
	 */
	public String createLine() {
		long startTime = System.currentTimeMillis();
		String firstWord = createWord();
		String capitalWord = firstWord.substring(0, 1).toUpperCase() + firstWord.substring(1);
		StringBuilder line = new StringBuilder(capitalWord);
		
		Random rn = new Random();
		int lineLength = rn.nextInt((CHAR_PER_LINE - 12) + 1) + 12;
		wordCountPerLine = 0;
		lineCount++;
		//System.out.print(lineCount + " <<<<< " + line.length() + " < " + lineLength);
		while (line.length() < lineLength) {
			line.append(createWord());
			wordCountPerLine++;
		}
		//System.out.println(" /wordCountPerLine: " + wordCountPerLine);
		line.deleteCharAt(line.length() - 1);
		line.append(". ");
		//line.append("\n");
		LatencyObject.getInstance().getDurationLineCreateList().add(System.currentTimeMillis() - startTime);
		LatencyObject.getInstance().getNumberWordsPerLineList().add(wordCountPerLine);
		return line.toString();
	}
}
