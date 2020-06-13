package com.incubytedatatech.tddkata.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.incubytedatatech.tddkata.main.StringCalculator;

@TestInstance(Lifecycle.PER_CLASS)
public class StringCalculatorTest {
	
	private StringCalculator stringCalculator;
	
	@BeforeAll
	private void itShouldCreateStringCalculatorBeforeAllTestCaseRuns() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void add_shouldReturn0WhenNumbersIsEmpty () {
		assertEquals(0, stringCalculator.add(""));
	}
	
	@Test
	public void add_shouldReturnSameForSingleNumber () {
		String numbers = "1";
		assertEquals(Integer.valueOf(numbers), stringCalculator.add(numbers));
	}
	
	@Test
	public void add_shouldReturnAdditionOfTwoNumbers () {
		assertEquals(3, stringCalculator.add("1,2"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfUnknownAmountOfNumbers () {
		
		assertEquals(26, stringCalculator.add("1,2,5,9,3,2,4"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfNumbersWithAllowedNewLines () {
		assertEquals(6, stringCalculator.add("1\n2,3"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfNumbersWithSupportedDelimiters () {
		assertEquals(3, stringCalculator.add("//;\n1;2"));
	}
}
