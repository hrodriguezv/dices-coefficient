package com.shibsted.challenge.dicescoefficient.io.impl;

import java.util.Map.Entry;
import java.util.Set;

import com.shibsted.challenge.dicescoefficient.io.spec.PrinterResults;

/**
 * The Class PrintConsoleRankingResults.
 *
 * @author hrodriguez
 */
public class PrintByConsoleRankingResults implements PrinterResults {

	/** The ranking. */
	private Set<Entry<String, Double>> ranking;

	/**
	 * Instantiates a new prints the console ranking results.
	 *
	 * @param set
	 *            the set
	 */
	public PrintByConsoleRankingResults(Set<Entry<String, Double>> set) {

		this.ranking = set;

	}

	@Override
	public void print() {

		if (ranking.isEmpty()) {

			System.out.println("no matches found");

		}

		ranking.stream().forEach(entry -> System.out.printf("%s : %.0f%s %n", entry.getKey(), entry.getValue(), "%"));

	}

}
