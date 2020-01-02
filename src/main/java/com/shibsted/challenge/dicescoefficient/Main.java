package com.shibsted.challenge.dicescoefficient;

import java.io.File;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import com.shibsted.challenge.dicescoefficient.io.impl.PrintByConsoleRankingResults;
import com.shibsted.challenge.dicescoefficient.io.spec.PrinterResults;
import com.shibsted.challenge.dicescoefficient.match.impl.DiceCoefficientMatcherImpl;
import com.shibsted.challenge.dicescoefficient.match.spec.FindSortedMatches;
import com.shibsted.challenge.dicescoefficient.util.FileUtils;

/**
 * @author hrodriguez
 *
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		if (args.length == 0) {

			throw new IllegalArgumentException("No directory given to index.");

		}

		try (Scanner keyboard = new Scanner(System.in)) {

			final File indexableDirectory = new File(args[0]);
			File[] listOfFiles = FileUtils.listFiles(indexableDirectory.getAbsolutePath(), Optional.empty());

			System.out.println(listOfFiles.length + " files read in directory " + indexableDirectory.getAbsolutePath());
			String termToSearch = "";

			while (!termToSearch.equals(":quit")) {

				System.out.print("search> ");

				termToSearch = keyboard.nextLine();

				FindSortedMatches finder = new DiceCoefficientMatcherImpl(listOfFiles, termToSearch);

				Map<String, Double> ranking = finder.findSorted();

				PrinterResults printer = new PrintByConsoleRankingResults(ranking.entrySet());

				printer.print();

			}

		} catch (Exception e) {

			System.err
					.println("There was an error trying to find term into selected directory [" + e.getMessage() + "]");

		}

	}

}
