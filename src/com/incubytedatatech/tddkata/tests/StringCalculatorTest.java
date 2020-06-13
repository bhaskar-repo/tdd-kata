package com.incubytedatatech.tddkata.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.incubytedatatech.tddkata.exceptions.NegativeNumberException;
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
	
	@Test
	public void add_shouldThrowNegativeNumberExceptionForNegativeNumber () {
		assertThrows(NegativeNumberException.class, () -> stringCalculator.add("-3"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfNumbersWithDelimitersOfAnyLength () {
		assertEquals(6, stringCalculator.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfNumbersWithMultipleDelimiters () {
		assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void add_shouldReturnAdditionOfNumbersWithMultipleDelimitersOfAnyLength () {
		assertEquals(6, stringCalculator.add("“//[**][%%]\\n1**2%%3"));
	}
	
	@Test
	public void add_shouldIgnoreNumbersGreaterThan1000AndReturnAddition () {
		assertEquals(4, stringCalculator.add("20000,\n4"));
	}
	
	@Test
	public void getCalledCount_shouldReturnCountNumberOfTimesAddInvoked () {
		assertEquals(12, stringCalculator.getCalledCount ());
	}
}
