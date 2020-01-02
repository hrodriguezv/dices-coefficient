package com.shibsted.challenge.dicescoefficient.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author hrodriguez
 *
 */
public class TestDiceCoefficientHelper {

	@Test
	public void test100PercentMeasure() {
		String str1 = "SetOfCharacters";
		String str2 = "SetOfCharacters";

		double calculate = DiceCoefficientHelper.calculate(str1, str2);

		assertTrue(1d == calculate);
	}

	@Test
	public void test33PercentMeasure() {
		String str1 = "World - Wide - Web";
		String str2 = "Web";

		double calculate = DiceCoefficientHelper.calculateByWord(str1, str2);

		assertTrue(0.33d == calculate);
	}

}
