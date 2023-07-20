package com.example.numberrangesummarizer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class NumberRangeSummarizerTest {

	@Test
	public void positiveTestGroupSequentialNumbers() {
		NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
		Collection<Integer> input1 = Arrays.asList(1, 2, 3, 4, 5);
		String expected1 = "1-5";
		assertThat(expected1.equals(numberRangeSummarizer.summarizeCollection(input1)));

		// Test case with non-consecutive numbers: 1, 3, 5, 6, 7
		Collection<Integer> input2 = Arrays.asList(1, 3, 5, 6, 7);
		String expected2 = "1,3,5-7";
		assertThat(expected2.equals(numberRangeSummarizer.summarizeCollection(input2)));
		// Test case with empty input
		Collection<Integer> input3 = Arrays.asList();
		String expected3 = "";
		assertThat(expected3.equals(numberRangeSummarizer.summarizeCollection(input3)));

		// Test case with single number: 10
		Collection<Integer> input4 = Arrays.asList(10);
		String expected4 = "10";
		assertThat(expected4.equals(numberRangeSummarizer.summarizeCollection(input4)));

		// Test case with negative numbers: -5, -4, -3, -2, -1, 0
		Collection<Integer> input5 = Arrays.asList(-5, -4, -3, -2, -1, 0);
		String expected5 = "-5--1,0";
		assertThat(expected5.equals(numberRangeSummarizer.summarizeCollection(input5)));
	}

	@Test
	public void negativeTestGroupSequentialNumbers() {
		NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
		Collection<Integer> input1 = Arrays.asList(1, 2, 3, 5);
		String expected1 = "1-5";
		assertThat(expected1 != numberRangeSummarizer.summarizeCollection(input1));

		Collection<Integer> input2 = Arrays.asList(1, 3, 5, 6, 7);
		String expected2 = "1,3,6-7";
		assertThat(expected2 != numberRangeSummarizer.summarizeCollection(input2));
		Collection<Integer> input3 = Arrays.asList();
		String expected3 = "1";
		assertThat(expected3 != numberRangeSummarizer.summarizeCollection(input3));

		Collection<Integer> input4 = Arrays.asList(10);
		String expected4 = "1";
		assertThat(expected4 != numberRangeSummarizer.summarizeCollection(input4));

		Collection<Integer> input5 = Arrays.asList(-5, -4, -3, -2, -1, 0);
		String expected5 = "-5-1,0";
		assertThat(expected5 != numberRangeSummarizer.summarizeCollection(input5));
	}

	@Test
	public void positiveTestcollect() {
		NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
		String input1 = "1,4,3,6,3,78,9,3,8,4,6,";
		Collection<Integer> expected1 = Arrays.asList(1, 3, 4, 6, 8, 9, 78);
		assertThat(expected1.equals(numberRangeSummarizer.collect(input1)));

		String input2 = "-1,4,3,6,3,-78,9,3,8,4,6,";
		Collection<Integer> expected2 = Arrays.asList(-78, -1, 3, 4, 6, 8, 9);
		assertThat(expected2.equals(numberRangeSummarizer.collect(input2)));
	}

	@Test
	public void negativeTestcollect() {
		NumberRangeSummarizer numberRangeSummarizer = new NumberRangeSummarizerImpl();
		String input1 = "1,4,3,6,3,78,9,3,8,4,6,";
		Collection<Integer> expected1 = Arrays.asList(1, 4, 6, 8, 9, 78);
		assertThat(expected1 != numberRangeSummarizer.collect(input1));

		String input2 = "-1,4,3,6,3,-78,9,3,8,4,6,";
		Collection<Integer> expected2 = Arrays.asList(-1, 3, 4, 6, 8, 9, -78);
		assertThat(expected2 != numberRangeSummarizer.collect(input2));
	}

}
