package com.codechallenge.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codechallenge.bean.ZipCode;

/**
 * @author Liz
 *
 */
public class ZipCodeComparatorTest {

	/*
	 * This method test equals ZipCodes, expected return is ZERO
	 */
	@Test
	@DisplayName("Testing equals case")
	public void compare_equalsTest() {
		ZipCodeComparator comparator = new ZipCodeComparator();
		ZipCode zipCode1 = new ZipCode(94600, 94699);
		ZipCode zipCode2 = new ZipCode(94600, 94692);
		Assertions.assertEquals(0, comparator.compare(zipCode1, zipCode2), "Expected 0 since both objects are equal");
	}
	
	@Test
	public void compare_lessThanTest() {
		ZipCodeComparator comparator = new ZipCodeComparator();
		ZipCode zipCode1 = new ZipCode(94600, 94699);
		ZipCode zipCode2 = new ZipCode(94601, 94692);
		Assertions.assertEquals(-1, comparator.compare(zipCode1, zipCode2));
	}
	
	@Test
	public void compare_greaterThanTest() {
		ZipCodeComparator comparator = new ZipCodeComparator();
		ZipCode zipCode1 = new ZipCode(94602, 94699);
		ZipCode zipCode2 = new ZipCode(94601, 94692);
		Assertions.assertEquals(1, comparator.compare(zipCode1, zipCode2));
	}
}
