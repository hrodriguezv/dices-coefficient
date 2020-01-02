package com.shibsted.challenge.dicescoefficient.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * The Class DiceCoefficientHelper offers an implementation of Dice's
 * Coefficient algorithm. This algorithm measures how similar a set and another
 * set are. It can be used to measure how similar two strings are in terms of
 * the number of common bigrams (a bigram is a pair of adjacent letters in the
 * string)
 */
public class DiceCoefficientHelper {

	/**
	 * Builds the bigrams set.
	 *
	 * @param str
	 *            the str
	 * @return the sets the
	 */
	private static Set<String> buildBigramsSet(String str) {

		Set<String> set = new HashSet<>();

		IntStream.range(0, str.length() - 1).forEach(index -> {
			char first = str.charAt(index);
			char second = str.charAt(index + 1);
			set.add("" + first + second);
		});

		return set;

	}

	/**
	 * Calculate.
	 *
	 * @param firstStr
	 *            the s 1
	 * @param secondStr
	 *            the s 2
	 * @return the double
	 */
	public static Double calculate(String firstStr, String secondStr) {

		Set<String> firstBigramsSet = buildBigramsSet(firstStr);
		Set<String> secondBigramsSet = buildBigramsSet(secondStr);

		Set<String> intersection = new HashSet<String>(firstBigramsSet);
		intersection.retainAll(secondBigramsSet);

		double numberOfbigrams = intersection.size();

		return (2 * numberOfbigrams) / (firstBigramsSet.size() + secondBigramsSet.size());

	}
	
	public static Double calculateByWord(String firstStr, String secondStr) {

		Set<String> firstBigramsSet = buildWordSet(firstStr);
		Set<String> secondBigramsSet = buildWordSet(secondStr);

		Set<String> intersection = new HashSet<String>(firstBigramsSet);
		intersection.retainAll(secondBigramsSet);

		double numberOfbigrams = intersection.size();

		return (2 * numberOfbigrams) / (firstBigramsSet.size() + secondBigramsSet.size());

	}

	private static Set<String> buildWordSet(String secondStr) {
		
		String[] array = secondStr.split("\\s+");
		Set<String> set = new HashSet<>();

		Arrays.asList(array).stream().forEach(token -> set.add(token));
		
		return set;
	}
	
		

}
