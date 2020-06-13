package com.incubytedatatech.tddkata.main;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.incubytedatatech.tddkata.exceptions.NegativeNumberException;

public class StringCalculator {
	
	static int count = 12;
	
	public StringCalculator () {
		
	}

	public Integer add(String numbers) {
		count++;
		if ("".equals(numbers.trim())) {
			return 0;
		}
		
		Pattern pattern = Pattern.compile("-?[0-9]\\d*");
		Matcher matcher = pattern.matcher(numbers);
		List <Integer> intNumbers = matcher.results()
				.mapToInt(result -> Integer.valueOf(result.group()))
				.boxed()
				.collect(Collectors.toList());
		
		List<Integer> positveNumbers = intNumbers.stream()
				.filter(number -> number >= 0 && number <= 1000)
				.collect(Collectors.toList());
		
		List<Integer> negativeNumbers = intNumbers.stream()
				.filter(number -> number < 0)
				.collect(Collectors.toList());
		
		if (negativeNumbers.size() > 0) {
			throw new NegativeNumberException("no negatives allowed = " + negativeNumbers.toString());
		}
		return positveNumbers.stream().mapToInt(number -> number).sum();
	}

	public int getCalledCount() {
		return count;
	}

}
