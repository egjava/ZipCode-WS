package com.codechallenge.util;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codechallenge.bean.ZipCode;

public class ZipCodeValidationTest {
		
	@Test
	@DisplayName("Testing Zipcode is valid number and it has 5 digits")
	public void validDigitsTest() {
		String strZipCode = "94200";
		ZipCodeValidation zipCodeValidDigit = new ZipCodeValidation();
		boolean isValid = zipCodeValidDigit.validDigits(strZipCode);
		Assertions.assertTrue(isValid == true);
	}
	
	
	@Test
	@DisplayName("Testing Pair zipCode")
	public void getPairZipcodeTest() {
		String strZipCode = "[ 94200 , 94299 ] [94400 , 94499 ]";
		String[] pariZipCode = {"94200,94299","94400,94499"};
		ZipCodeValidation zipCodeValidDigit = new ZipCodeValidation();
		String[] strPairZipCode = zipCodeValidDigit.getPairZipcode(strZipCode);
		Assertions.assertArrayEquals(strPairZipCode,pariZipCode);
	}
	
	@Test
	@DisplayName("Testing Validate Zipcode and split into lowerbound and upperbound ")
	public void validateZipcodeTest() {
		ZipCode zipCode1 = new ZipCode(94200,94299);
		ZipCode zipCode2 = new ZipCode(94400,94499);
		ArrayList<ZipCode> zipcodeListTest = new ArrayList<ZipCode>();
		zipcodeListTest.add(zipCode1);
		zipcodeListTest.add(zipCode2);
		String[] pariZipCode = {"94200,94299","94400,94499"};
		ZipCodeValidation zipCodeValidDigit = new ZipCodeValidation();
		ArrayList<ZipCode> zipCodeList = zipCodeValidDigit.validateZipcode(pariZipCode);
		zipCodeList.sort(new ZipCodeComparator());
		zipcodeListTest.sort(new ZipCodeComparator());
		assertIterableEquals(zipCodeList, zipcodeListTest);
	}
}
