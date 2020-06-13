package com.incubytedatatech.tddkata.main;

import java.util.Arrays;

public class StringCalculator {

	public Integer add(String numbers) {
		
		if ("".equals(numbers.trim())) {
			return 0;
		}
		else {
			String numberValues[] = numbers.split(",");
			if (numberValues.length == 1) {
				return Integer.valueOf(numberValues[0]);
			}
			else {
				return Arrays.stream(numberValues)
						.mapToInt(number -> Integer.valueOf(number))
						.sum();
			}
		}
		
		
	}

}
