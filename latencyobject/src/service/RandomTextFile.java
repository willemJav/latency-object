package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import utility.DirectoryNotCreatedException;
import utility.LatencyObject;
import utility.LatencyService;
import utility.PropertyUtil;

/**
 * 
 * @author wfristdr
 * 
 * The class extends the RandomLine class and invokes the method createLine,
 * The method createTextFile creates a single text-file of 1000 line consisting of random words.
 * The text-file will be copied 5 times and will be saved on the hard-disk locally.
 * The file path is C:/textfolder/ and a directory will be created when there is no
 * folder of that name present.
 * The name of the 5 textfiles are randomtext1-5.txt
 *
 */

public class RandomTextFile extends RandomLineImpl{
	String DIRECTORY_STRING;
	String TEXT_FILE_STRING;
	
	public RandomTextFile() {
		DIRECTORY_STRING = PropertyUtil.getProperty("DIRECTORY_STRING");
		TEXT_FILE_STRING = PropertyUtil.getProperty("TEXT_FILE_STRING");
	}

	/**
	 * 
	 * @return the duration in ms as long
	 * creates the single text file of 1000 lines consisting of random words
	 * Several elements of this class will be saved into the LatencyObject class:
	 * 1) the duration of the text creations;
	 * 2) the duration of the first text file;
	 * 3) the duration of the creations of all 5 text files.
	 * @throws DirectoryNotCreatedException 
	 */
	public void createTextFile() throws DirectoryNotCreatedException {
		long startTime = System.currentTimeMillis();
		StringBuilder textFile = new StringBuilder("");
		for (int i = 0; i < 1001; i++) textFile.append(createLine());
		LatencyObject.getInstance().setDurationTextCreate(System.currentTimeMillis() - startTime);
		createDirectory(); // if not existing
		
		for (int i = 0; i < 5; i++) {
			try (Writer writer = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(TEXT_FILE_STRING + (i+1) + ".txt"), "utf-8"))) {
				writer.write(textFile.toString());
			} catch (IOException e) {
				System.err.println("Error creating text file: " + e);
				e.printStackTrace();
			}
			if (i == 0 )LatencyObject.getInstance().setDurationTextFileCreate(System.currentTimeMillis() - startTime);
		}
		LatencyObject.getInstance().setDurationTextFileCopiesCreate(System.currentTimeMillis() - startTime);
	}
	
	/**
	 * Creates the directory testfolder in case the folder does not exists
	 * @throws DirectoryNotCreatedException 
	 */
	private void createDirectory() throws DirectoryNotCreatedException {
		File newDir = new File(DIRECTORY_STRING);
		if (!newDir.exists()) {
			boolean bl = new File(DIRECTORY_STRING).mkdir();
			if (!bl) {
				throw new DirectoryNotCreatedException("Directory no created");
			}
		}
	}

	/**
	 * 
	 * @param args not used
	 * main for test reasons only
	 */
	public static void main(String[] args) {
		RandomTextFile tf = new RandomTextFile();
		RandomTextZipp rz = new RandomTextZipp();
		try {
			tf.createTextFile();
		} catch (DirectoryNotCreatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rz.createRandomTextZipp();
		System.out.println("getTotalWordsOfFile          " + LatencyService.getTotalWordsOfFile());
		System.out.println("getAverageWordsPerLine       " + LatencyService.getAverageWordsPerLine());
		System.out.println("getTextCreateDuration        " + LatencyService.getTextCreateDuration());
		System.out.println("getTextFileCreateDuration    " + LatencyService.getTextFileCreateDuration());
		System.out.println("getTextCreateCopiesDuration  " + LatencyService.getTextCreateCopiesDuration());
		System.out.println("getTextCreateZipDuration     " + LatencyService.getTextCreateZipDuration());
		System.out.println("getMinimumWordCreateDuration " + LatencyService.getMinimumWordCreateDuration());
		System.out.println("getMaximumWordCreateDuration " + LatencyService.getMaximumWordCreateDuration());
		System.out.println("getAverageWordCreateDuration " + LatencyService.getAverageWordCreateDuration());
		System.out.println("getAverageLineCreateDuration " + LatencyService.getAverageLineCreateDuration());
	}
}
