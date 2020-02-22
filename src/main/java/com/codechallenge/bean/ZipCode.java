package com.codechallenge.bean;


/**
 * @author Liz
 * 
 * This is a bean class for Zipcodes which has two integer lowerbound and upperbound zipcodes
 *
 */
public class ZipCode {
	
	
	private Integer lowerBound;
	private Integer upperBound;
	
	
	public ZipCode() {
		
	}
	
	public ZipCode(Integer lowerBound, Integer upperBound) {
		
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}
	
	public Integer getUpperBound() {
		return upperBound;
	}
	public void setUpperBound(Integer upperBound) {
		this.upperBound = upperBound;
	}
	public Integer getLowerBound() {
		return lowerBound;
	}
	public void setLowerBound(Integer lowerBound) {
		this.lowerBound = lowerBound;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ZipCode) {
			ZipCode paramZipCode = (ZipCode) obj;
			return this.lowerBound.equals(paramZipCode.lowerBound) && this.upperBound.equals(paramZipCode.upperBound); 
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return (this.lowerBound+""+this.upperBound).hashCode();
	}
	@Override
	public String toString() {
		return "ZipcodeBean [upperBound=" + upperBound + ", lowerBound=" + lowerBound + "]";
	}

	
}
