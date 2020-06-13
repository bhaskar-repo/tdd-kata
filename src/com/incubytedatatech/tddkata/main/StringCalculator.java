package com.incubytedatatech.tddkata.main;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {

	public Integer add(String numbers) {
		
		if ("".equals(numbers.trim())) {
			return 0;
		}
		else {
			Pattern pattern = Pattern.compile("\\d+");
			Matcher matcher = pattern.matcher(numbers);
			List <Integer> intNumbers = matcher.results()
					.mapToInt(result -> Integer.valueOf(result.group()))
					.boxed()
					.collect(Collectors.toList());
			if (intNumbers.size() == 1) {
				return intNumbers.get(0);
			}
			else {
				
				return intNumbers.stream().mapToInt(number -> number)
							  .sum();
			}
			
		}
		
		
	}

}
