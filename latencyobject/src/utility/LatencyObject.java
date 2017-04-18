package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author wfristdr
 * The singleton LatencyObject will hold all measured latency properties
 * and forms the center part of this project. During the unfolding of the
 * project data will be saved into this singleton class. The LatencyService
 * class will deliver that data at the result servlet.
 *
 */
public class LatencyObject {
	private static LatencyObject instance = null;
	private long durationTextCreate;
	private long durationTextFileCreate;
	private long durationTextFileCopiesCreate;
	private long durationTextZipCreate;
	private List<Long> durationWordCreateList;
	private List<Long> durationLineCreateList;
	private List<Integer> numberWordsPerLineList;

	protected LatencyObject() {
		durationWordCreateList = new ArrayList<Long>();
		durationLineCreateList = new ArrayList<Long>();
		numberWordsPerLineList = new ArrayList<Integer>();
	}

	public static LatencyObject getInstance() {
		if (instance == null) {
			instance = new LatencyObject();
		}
		return instance;
	}
	

	public static void setInstance(LatencyObject instance) {
		LatencyObject.instance = instance;
	}

	/**
	 * 
	 * @return the duration of created text of 1000 line and random words
	 */
	public long getDurationTextCreate() {
		return durationTextCreate;
	}

	/**
	 * 
	 * @param durationTextCreate the duration of created text of 1000 line and random words
	 */
	public void setDurationTextCreate(long durationTextCreate) {
		this.durationTextCreate = durationTextCreate;
	}

	/**
	 * 
	 * @return the duration of created text-file of 1000 line and random words
	 */
	public long getDurationTextFileCreate() {
		return durationTextFileCreate;
	}
	
	/**
	 * 
	 * @param durationTextFileCreate the duration of created text-file of 1000 line and random words
	 */
	public void setDurationTextFileCreate(long durationTextFileCreate) {
		this.durationTextFileCreate = durationTextFileCreate;
	}

	/**
	 * 
	 * @return the duration of created 5 text-file copies of 1000 line and random words
	 */
	public long getDurationTextFileCopiesCreate() {
		return durationTextFileCopiesCreate;
	}

	/**
	 * 
	 * @param durationTextFileCopiesCreate 
	 * the duration of created 5 text-file copies of 1000 line and random words
	 */
	public void setDurationTextFileCopiesCreate(long durationTextFileCopiesCreate) {
		this.durationTextFileCopiesCreate = durationTextFileCopiesCreate;
	}

	/**
	 * 
	 * @return the duration of created zip-file 
	 * of 5 text-file copies of 1000 line and random words
	 */
	public long getDurationTextZipCreate() {
		return durationTextZipCreate;
	}

	/**
	 * 
	 * @param durationTextZipCreate the duration of created zip-file 
	 * of 5 text-file copies of 1000 line and random words
	 */
	public void setDurationTextZipCreate(long durationTextZipCreate) {
		this.durationTextZipCreate = durationTextZipCreate;
	}

	/**
	 * 
	 * @return the duration of the creation of a single random word
	 */
	public List<Long> getDurationWordCreateList() {
		return durationWordCreateList;
	}

	/**
	 * 
	 * @param durationWordCreateList the duration of the creation of a single random word
	 */
	public void setDurationWordCreateList(List<Long> durationWordCreateList) {
		this.durationWordCreateList = durationWordCreateList;
	}

	/**
	 * 
	 * @return the duration of the creation of a single line of random words
	 */
	public List<Long> getDurationLineCreateList() {
		return durationLineCreateList;
	}

	/**
	 * 
	 * @param durationLineCreateList the duration of the 
	 * creation of a single line of random words
	 */
	public void setDurationLineCreateList(List<Long> durationLineCreateList) {
		this.durationLineCreateList = durationLineCreateList;
	}

	/**
	 * 
	 * @return a list of number of words of all 1000 lines
	 */
	public List<Integer> getNumberWordsPerLineList() {
		return numberWordsPerLineList;
	}

	/**
	 * 
	 * @param numberWordsPerLineList a list of number of words of all 1000 lines
	 */
	public void setNumberWordsPerLineList(List<Integer> numberWordsPerLineList) {
		this.numberWordsPerLineList = numberWordsPerLineList;
	}


	@Override
	public String toString() {
		return "LatencyObject [durationTextCreate=" + durationTextCreate + ", durationTextFileCreate="
				+ durationTextFileCreate + ", durationTextFileCopiesCreate=" + durationTextFileCopiesCreate
				+ ", durationTextZipCreate=" + durationTextZipCreate + ", durationWordCreateList="
				+ durationWordCreateList + ", durationLineCreateList=" + durationLineCreateList
				+ ", numberWordsPerLineList=" + numberWordsPerLineList + "]";
	}
}
