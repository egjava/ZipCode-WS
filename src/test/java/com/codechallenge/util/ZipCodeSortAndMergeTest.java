package com.codechallenge.util;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codechallenge.bean.ZipCode;

public class ZipCodeSortAndMergeTest {
	
	@Test
	@DisplayName("Testing Sorting ZipCodes")
	public void sortLowerBoundTest() {
		
		ZipCode zipCode1 = new ZipCode(94600, 94699);
		ZipCode zipCode2 = new ZipCode(94602, 94692);
	    ArrayList<ZipCode> zipcodeList = new ArrayList<ZipCode>();
	    zipcodeList.add(zipCode1);
	    zipcodeList.add(zipCode2);
	 
	    ZipCodeSortAndMerge zcSortMerge = new ZipCodeSortAndMerge();
	    ArrayList<ZipCode> sortedZipCodeList = zcSortMerge.sortLowerBound(zipcodeList);
	    Assertions.assertTrue((sortedZipCodeList.get(0) == zipCode1), "Expected zipCode1 since zipCode1 has less value for lowerbound zipcode");
	}

	@Test
	@DisplayName("Testing Combining ZipCodes")
	public void combineZipCodeTest() {
		ZipCode zipCodeTest = new ZipCode(94600,94699);
		ArrayList<ZipCode> zipCodeListTest = new ArrayList<ZipCode>();
		zipCodeListTest.add(zipCodeTest);
		ZipCode zipCode1 = new ZipCode(94600,94699);
		ZipCode zipCode2 = new ZipCode(94602,94692);
	    ArrayList<ZipCode> zipcodeList = new ArrayList<ZipCode>();
	    zipcodeList.add(zipCode1);
	    zipcodeList.add(zipCode2);
	 
	    ZipCodeSortAndMerge zcSortMerge = new ZipCodeSortAndMerge();
	    ArrayList<ZipCode> sortedZipCodeList = zcSortMerge.sortLowerBound(zipcodeList);
	    ArrayList<ZipCode> combineZipCodeList = zcSortMerge.combineZipCode(sortedZipCodeList);
	    Assertions.assertIterableEquals(combineZipCodeList , zipCodeListTest);
	}
	
	@Test
	@DisplayName("Testing output")
	public void printOutputTest() {
		ZipCode zipCodeTest = new ZipCode(94600,94699);
		ArrayList<ZipCode> zipCodeListTest = new ArrayList<ZipCode>();
		zipCodeListTest.add(zipCodeTest);
		ZipCode zipCode1 = new ZipCode(94600, 94699);
		ZipCode zipCode2 = new ZipCode(94602, 94692);
		ArrayList<ZipCode> zipcodeList = new ArrayList<ZipCode>();
		zipcodeList.add(zipCode1);
		zipcodeList.add(zipCode2);
		ZipCodeSortAndMerge zcSortMerge = new ZipCodeSortAndMerge();
		ArrayList<ZipCode> sortedZipCodeList = zcSortMerge.sortLowerBound(zipcodeList);
		ArrayList<ZipCode> combineZipList = zcSortMerge.combineZipCode(sortedZipCodeList);
		Assertions.assertIterableEquals(combineZipList , zipCodeListTest);
	}
}
