package com.codechallenge.util;

import java.util.ArrayList;
import java.util.Collections;


import com.codechallenge.bean.ZipCode;


/**
 * @author Liz
 * 
 * ZipCodeSortAndMerge is  a class which sorts the ZipCodes and Combine ZipCodes
 * based on the business logic
 * 
 *
 */

public class ZipCodeSortAndMerge {
	
	/**
	 * @param sortZipList
	 * @return
	 * 
	 * This Method combines zip codes based on the zipcode range
	 */
	public ArrayList<ZipCode> combineZipCode(ArrayList<ZipCode> sortZipList){
		
		ArrayList<ZipCode> combineZipList = new ArrayList<ZipCode>();
		
		ZipCode zipCode = new ZipCode();
		ZipCode zipCode1 = new ZipCode();
		
		if(sortZipList.size() > 0)
			zipCode = sortZipList.get(0);
		
		for(int i=0;i<sortZipList.size();i++) {
			zipCode1 = sortZipList.get(i);
								
			/*
			 * Check to see whether upperBound Zipcode with 1 added is equal to lowerBound Zipcode
			 * of the next item in the list or if that is less than the upperBound Zipcode. This is to group
			 * the zipcodes if that falls in the same range [94200,94299][94300,94399] 
			 * 
			 * Then Check whether UpperBound Zipcode is greater than the next item Lowerbound Zipcode
			 * This is to group the zipcode of this range [94200,94399] [94233,94266](Overlapping Ranges)
			 */
					
			if(zipCode.getUpperBound() +1 == (zipCode1.getLowerBound())
					|| (zipCode.getUpperBound()) >= (zipCode1.getLowerBound()))	
			{
				if(zipCode1.getLowerBound() > zipCode.getUpperBound() ||
						(zipCode.getUpperBound() < zipCode1.getUpperBound())) {
							zipCode.setUpperBound(zipCode1.getUpperBound());
				}			
			}
			else {
				combineZipList.add(zipCode);
				zipCode = sortZipList.get(i);
			}
			
		}
		combineZipList.add(zipCode);
		return combineZipList;
	}
	
	
	/**
	 * @param zipcodeList 
	 * @return 
	 * 
	 * This Method sort the Zipcodes based on the LowerBound values using ZipcodeComparator class
	 */
	public ArrayList<ZipCode> sortLowerBound(ArrayList<ZipCode> zipcodeList){
		    Collections.sort(zipcodeList, new ZipCodeComparator());
		    return zipcodeList;
	}
	
	
	/**
	 * @param zipFinalList 
	 *  
	 * This Method prints the output after grouping based on the requirement
	 */
	public void printOutput(ArrayList<ZipCode> zipFinalList) {
		String output ="";
		if(zipFinalList.size() > 0 || (zipFinalList !=null)) {
			for(ZipCode finalZip: zipFinalList) {
				output += "["+finalZip.getLowerBound()+","+finalZip.getUpperBound()+"] ";
							
			}
			System.out.println("Output:"+output);
		}
	}
	
}
