package com.shibsted.challenge.dicescoefficient.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Optional;

/**
 * The Class FileUtils.
 *
 * @author hrodriguez
 */
public class FileUtils {

	/** The Constant TXT_EXTENSION. */
	public static final String TXT_EXTENSION = ".txt";

	/**
	 * Removes the extension.
	 *
	 * @param fileName the file name
	 * @return the string
	 */
	public static String removeExtension(String fileName) {
		return fileName.replaceFirst("[.][^.]+$", "");
	}

	/**
	 * List files.
	 *
	 * @param dirName the dir name
	 * @param extensionToFilter the extension to filter
	 * @return the file[]
	 */
	public static File[] listFiles(String dirName, Optional<String> extensionToFilter) {

		File dir = new File(dirName);

		return dir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String filename) {

				if (extensionToFilter.isPresent()) {
					return filename.endsWith(extensionToFilter.get());
				}
				return true;
			}

		});

	}

	/**
	 * List files.
	 *
	 * @param dirName the dir name
	 * @return the file[]
	 */
	public static File[] listFiles(String dirName) {
		return listFiles(dirName, Optional.empty());
	}
}
