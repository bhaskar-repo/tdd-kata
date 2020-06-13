package com.incubytedatatech.tddkata.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.incubytedatatech.tddkata.main.StringCalculator;

@TestInstance(Lifecycle.PER_CLASS)
public class StringCalculatorTest {

	@Test
	public void add_shouldReturn0WhenNumbersIsEmpty () {
		StringCalculator stringCalculator = new StringCalculator();
		assertEquals(0, stringCalculator.add(""));
	}
}
