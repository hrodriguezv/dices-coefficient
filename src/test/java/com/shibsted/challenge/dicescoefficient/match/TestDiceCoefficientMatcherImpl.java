package com.shibsted.challenge.dicescoefficient.match;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Map;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

import com.shibsted.challenge.dicescoefficient.match.impl.DiceCoefficientMatcherImpl;
import com.shibsted.challenge.dicescoefficient.match.spec.FindMatches;
import com.shibsted.challenge.dicescoefficient.match.spec.FindSortedMatches;
import com.shibsted.challenge.dicescoefficient.util.FileUtils;

/**
 * @author hrodriguez
 *
 */
public class TestDiceCoefficientMatcherImpl {

	private String term;
	private File rootDir;
	private File[] listOfFiles;

	@Before
	public void setup() {

		rootDir = new File(".");
		listOfFiles = FileUtils.listFiles(rootDir + "/files", Optional.empty());

	}

	@Test
	public void testFirstPlaceInRanking() {

		term = "Hola Mundo";

		FindSortedMatches finder = new DiceCoefficientMatcherImpl(listOfFiles, term);

		Map<String, Double> ranking = finder.findSorted();

		assertTrue(FileUtils.removeExtension(ranking.keySet().stream().findFirst().get()).equals(term));

	}

	@Test
	public void testNoMatches() {

		term = "3333333333";

		FindMatches finder = new DiceCoefficientMatcherImpl(listOfFiles, term);

		Map<String, Double> ranking = finder.find();

		assertTrue(ranking.keySet().isEmpty());

	}

	@Test
	public void testRankingLimitedTo10() {

		String term = "Hola";

		FindSortedMatches finder = new DiceCoefficientMatcherImpl(listOfFiles, term);

		Map<String, Double> ranking = finder.findSorted();

		assertTrue(ranking.keySet().size() == 10);

	}
}
