package com.codechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.codechallenge.bean.ZipCode;
import com.codechallenge.util.ZipCodeSortAndMerge;
import com.codechallenge.util.ZipCodeValidation;



/**
 * @author Liz
 * 
 * ZipCodeApplication is a main class which gets Input, Validate ZipCode,
 *  Sort and Merge the Zipcodes and print Output
 */


public class ZipCodeApplication {
	
		public static void main(String args[]) {
			
			
			 // Get User Input for ZipCodes
			 		
			String strZipcodes = getInput();
			
			//Pair Zip Code and validate
			ZipCodeValidation zipvalid = new ZipCodeValidation();
			String nInputArr[] = zipvalid.getPairZipcode(strZipcodes);
			
			//Validate ZipCode
			ArrayList<ZipCode> zipWorkList = zipvalid.validateZipcode(nInputArr);
		
			//Sort the lower bound zipcode
			ZipCodeSortAndMerge zipSortMerge = new ZipCodeSortAndMerge();
			ArrayList<ZipCode> zipSortList = zipSortMerge.sortLowerBound(zipWorkList);
						
			//Combine the ZipCodes based on the range
			ArrayList<ZipCode> zipCombineList = zipSortMerge.combineZipCode(zipSortList);
			
			//Print the output
			zipSortMerge.printOutput(zipCombineList);
		}
		
		
		/**
		 * @return
		 * Gets the User Input and if that is not String it prints "Invalid Data"
		 *
		 */
		
		public static String getInput() {
			try(Scanner input= new Scanner(System.in)){
				String strZipcodes = "";
				try {
					System.out.println("Enter a String input format:([94200,94299] [95200,95299]):");
					strZipcodes = input.nextLine();
				}
				catch(InputMismatchException e) {
					System.out.println("You have entered Invalid Data");
				}
				return strZipcodes;
			}			
			
		}
}
