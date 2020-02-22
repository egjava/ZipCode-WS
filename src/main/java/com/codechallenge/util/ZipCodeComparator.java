package com.codechallenge.util;

import java.util.Comparator;

import com.codechallenge.bean.ZipCode;

/**
 * @author Liz
 *
 * ZipCodeComparator is an utility to compare two objects type of ZipCode
 */
public class ZipCodeComparator implements Comparator<ZipCode> { 
	  
    /**
     * @param lowerBoundZip1 first zip code
     * @param lowerBoundZip1 second zip code
     * @return int 
     * 
     *  the value 0 if this Integer isequal to the argument Integer; 
     *  a value less than 0 if this Integer is numerically lessthan 
     *  the argument Integer; and a value greaterthan 0 if this 
     *  Integer is numericallygreater than the argument Integer (signedcomparison).
     * 
     */
    public int compare(ZipCode lowerBoundZip1, ZipCode lowerBoundZip2) { 
        int lowerboundCompare = lowerBoundZip1.getLowerBound().compareTo(lowerBoundZip2.getLowerBound()); 
        return lowerboundCompare;       
    } 
} 