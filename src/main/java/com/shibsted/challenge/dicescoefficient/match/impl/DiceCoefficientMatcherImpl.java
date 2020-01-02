package com.shibsted.challenge.dicescoefficient.match.impl;

import static java.util.stream.Collectors.toMap;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.shibsted.challenge.dicescoefficient.match.spec.FindMatches;
import com.shibsted.challenge.dicescoefficient.match.spec.FindSortedMatches;
import com.shibsted.challenge.dicescoefficient.util.DiceCoefficientHelper;
import com.shibsted.challenge.dicescoefficient.util.FileUtils;

/**
 * The Class DiceCoefficientMatcherImpl.
 *
 * @author hrodriguez
 */
public class DiceCoefficientMatcherImpl implements FindMatches, FindSortedMatches {

	/** The files. */
	private File[] files;

	/** The term. */
	private String term;

	/**
	 * Instantiates a new dice coefficient matcher impl.
	 *
	 * @param filtered
	 *            the filtered
	 * @param term
	 *            the term
	 */
	public DiceCoefficientMatcherImpl(File[] filtered, String term) {

		this.files = filtered;
		this.term = term;

	}

	@Override
	public Map<String, Double> find() {

		Map<String, Double> map = new HashMap<>();

		for (File file : files) {

			double percentage = DiceCoefficientHelper.calculate(FileUtils.removeExtension(file.getName()), term);
			if (percentage > 0) {
				map.put(file.getName(), 100 * percentage);
			}

		}

		return map;

	}

	@Override
	public Map<String, Double> findSorted() {

		Map<String, Double> sorted = find().entrySet().stream().limit(10)
				.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(toMap(entry -> entry.getKey(),
						entry -> entry.getValue(), (entry1, entry2) -> entry2, LinkedHashMap::new));

		return sorted;

	}

}
