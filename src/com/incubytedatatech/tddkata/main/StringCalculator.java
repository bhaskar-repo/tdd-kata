package com.incubytedatatech.tddkata.main;

public class StringCalculator {

	public Integer add(String numbers) {
		
		if ("".equals(numbers.trim())) {
			return 0;
		}
		String numberValues[] = numbers.split(",");
		if (numberValues.length == 1) {
			return Integer.valueOf(numberValues[0]);
		}
		
		return null;
	}

}
