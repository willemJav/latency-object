package utility;

/**
 * 
 * @author wfristdr
 * This class is the worker-class of the LatencyObject class
 * The static methods of this class will be consulted at the final
 * result servlet´s web interface.
 */
public class LatencyService {
	
	/**
	 * 
	 * @return the duration of created text of 1000 line and random words
	 */
	public static long getTextCreateDuration() {
		return LatencyObject.getInstance().getDurationTextCreate();
	}
	
	/**
	 * 
	 * @return the duration of created text-file of 1000 line and random words
	 */
	public static long getTextFileCreateDuration() {
		return LatencyObject.getInstance().getDurationTextFileCopiesCreate();
	}
	
	/**
	 * 
	 * @return the duration of created 5 text-file copies of 1000 line and random words
	 */
	public static long getTextCreateCopiesDuration() {
		return LatencyObject.getInstance().getDurationTextFileCopiesCreate();
	}
	
	/**
	 * 
	 * @return the duration of created zip-file of the 5 created text-files
	 */
	public static long getTextCreateZipDuration() {
		return LatencyObject.getInstance().getDurationTextZipCreate();
	}
	
	/**
	 * 
	 * @return the total of created random words
	 */
	public static int getTotalWordsOfFile() {
		return LatencyObject.getInstance().getDurationWordCreateList().size();
	}
	
	/**
	 * 
	 * @return minimum creation time of a single word
	 */
	public static long getMinimumWordCreateDuration() {
		long min = 999999999;
		for (long lng: LatencyObject.getInstance().getDurationWordCreateList()) {
			if (lng < min) min = lng;
		}
		return min;
	}
	
	/**
	 * 
	 * @return maximum creation time of a single word
	 */
	public static long getMaximumWordCreateDuration() {
		long max = 0;
		for (long lng: LatencyObject.getInstance().getDurationWordCreateList()) {
			if (lng > max) max = lng;
		}
		return max;
	}
	
	/**
	 * 
	 * @return the average creation time of a single word
	 */
	public static long getAverageWordCreateDuration() {
		long average = 0;
		for (long lng: LatencyObject.getInstance().getDurationWordCreateList()) {
			average = average + lng;
		}
		return average / LatencyObject.getInstance().getDurationWordCreateList().size();
	}
	
	/**
	 * 
	 * @return the average creation time of a single line
	 */
	public static long getAverageLineCreateDuration() {
		long average = 0;
		for (long lng: LatencyObject.getInstance().getDurationLineCreateList()) {
			average = average + lng;
		}
		return average / LatencyObject.getInstance().getDurationLineCreateList().size();
	}
	
	/**
	 * 
	 * @return the average number of words per line
	 */
	public static float getAverageWordsPerLine() {
		float average = 0;
		for (int i: LatencyObject.getInstance().getNumberWordsPerLineList()) {
			average = average + i;
		}
		return average / LatencyObject.getInstance().getNumberWordsPerLineList().size();
	}
	
	/**
	 * resets the lists of the Latency Object
	 */
	public static void clearService() {
		LatencyObject.getInstance().getDurationWordCreateList().clear();
		LatencyObject.getInstance().getDurationLineCreateList().clear();
		LatencyObject.getInstance().getNumberWordsPerLineList().clear();
	}

}