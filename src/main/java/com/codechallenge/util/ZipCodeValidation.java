package com.codechallenge.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.codechallenge.bean.ZipCode;


/**
 * @author Liz
 * 
 * ZipCodeValidation is a class which helps to pair the Zipcodes,  validates ZipCode, 
 * Checks whether Zipcode has five digits and its number between {0-9}
 * 
 *
 */
public class ZipCodeValidation {
		
	/**
	 * @param zipArray
	 * @return
	 * 
	 * This Method Validates Zipcode -checks whether it is a valid 5 digit code,
	 *  Checks whether the lowerbound zip is having less value than upperbound zipcode
	 *  or else interchange the value.
	 *  splits the zipcode into lowerbound and upperbound zipcode and set it to an object and returns it.
	 */
	public ArrayList<ZipCode> validateZipcode(String[] zipArray){
		
		ArrayList<ZipCode> zipCodeList = new ArrayList<ZipCode>();
		
		for(int i=0;i<zipArray.length;i++) {
			
			String zipCodeArray[] = zipArray[i].split(",");
			assert zipCodeArray.length==2:"Expects two numbers (only)";
			ZipCode zCode = new ZipCode();

				
				if(validDigits(zipCodeArray[0])
						&& validDigits(zipCodeArray[1])){
						
				if(Integer.parseInt(zipCodeArray[0]) <= (Integer.parseInt(zipCodeArray[1])))
					zCode = new ZipCode(Integer.parseInt(zipCodeArray[0]),Integer.parseInt(zipCodeArray[1]));
				else	
					zCode = new ZipCode(Integer.parseInt(zipCodeArray[1]),Integer.parseInt(zipCodeArray[0]));
					
				zipCodeList.add(zCode);
				}
						
		}
		return zipCodeList;
	}
	
		
	/**
	 * @param zipDigit
	 * @return
	 * 
	 * This Method checks whether ZipCode is a valid number and it has 5 digits
	 * 
	 */
	public boolean validDigits(String zipDigit)
	{
		try {
			if(zipDigit.matches("[0-9]{5}"))
				return true;
			else {
				System.out.println("Invalid ZipCode Format...ZipCode: "+zipDigit);
				return false;
			}
		}
		catch(NumberFormatException ex) {
			return false;
		}
	}
	
		
	/**
	 * @param strZipCode
	 * @return
	 * 
	 * This Method helps to form a String array from the user input, removes brackets([]) and whitespace from the input
	 */
	public String[] getPairZipcode(String strZipCode) {
		strZipCode = strZipCode.replaceAll("\\s+","");
		String strZipArr[] =  strZipCode.split("]");	
		for(int i=0;i<strZipArr.length;i++) {
			strZipArr[i] =strZipArr[i].replaceAll("\\[", "");
		}
		return strZipArr;
	}
	 

	

}
