package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import utility.LatencyObject;
import utility.PropertyUtil;

/**
 * 
 * @author wfristdr
 *
 * The createRandomTextZipp method finds the previous created text-files and will
 * zip them inside a newly created zip-file at the same directory of the textfiles.
 * The name of the zip-file is randomtextZip.zip.
 */

public class RandomTextZipp {
	
	/**
	 * 
	 * @return the duration in ms as long
	 * 
	 * Creates the single zip-file of 5 copies of the
	 * previous created text-file of 1000 lines of random words.
	 * The duration of the creations of the zip-file will be saved into LatencyObject in ms.
	 */
	public void createRandomTextZipp() {
		long startTime = System.currentTimeMillis();
		String ZIP_FILE_STRING = PropertyUtil.getProperty("ZIP_FILE_STRING");
		String TEXT_FILE_BASE_STRING = PropertyUtil.getProperty("TEXT_FILE_BASE_STRING");
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		FileInputStream fis = null;
		
		try {
			byte[] buffer = new byte[1024];
			fos = new FileOutputStream(ZIP_FILE_STRING);
			zos = new ZipOutputStream(fos);
			
			for (int i=0; i < 5; i++) {
				String tfs = TEXT_FILE_BASE_STRING + (i+1) + ".txt";
				File txtFile = new File(tfs);
				fis = new FileInputStream(txtFile);
				zos.putNextEntry(new ZipEntry(txtFile.getName()));
				int length;

				while ((length = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, length);
				}
			}
		}
		catch (IOException ioe) {
			System.err.println("Error creating zip file: " + ioe);
		} finally {
			try {
				if (zos != null) zos.closeEntry();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		LatencyObject.getInstance().setDurationTextZipCreate(System.currentTimeMillis() - startTime);
	}
}