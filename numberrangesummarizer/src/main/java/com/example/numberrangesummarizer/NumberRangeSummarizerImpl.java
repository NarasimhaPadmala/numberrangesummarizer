package com.example.numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {

	@Override
	public Collection<Integer> collect(String input) {

		List<Integer> sortedNumbers = Arrays.stream(input.split(",")).map(Integer::parseInt).sorted()
				.collect(Collectors.toCollection(ArrayList::new));

		return sortedNumbers;
	}

	@Override
	public String summarizeCollection(Collection<Integer> input) {

		List<String> ranges = new ArrayList<>();
		if (input.isEmpty()) {
			return "";
		}
		List<Integer> sortedInput = input.stream().collect(Collectors.toList());

		int start = sortedInput.get(0);
		int end = sortedInput.get(0);

		for (int i = 1; i < sortedInput.size(); i++) {
			if (sortedInput.get(i) == end + 1) {
				end = sortedInput.get(i);
			} else {
				if (start != end) {
					ranges.add(start + "-" + end);
				} else {
					ranges.add(Integer.toString(start));
				}
				start = sortedInput.get(i);
				end = sortedInput.get(i);
			}
		}

		if (start != end) {
			ranges.add(start + "-" + end);
		} else {
			ranges.add(Integer.toString(start));
		}

		return String.join(",", ranges);
	}
	
	public static void main(String[] args) {
		NumberRangeSummarizerImpl NumberRangeSummarizerImpl = new NumberRangeSummarizerImpl();
		
		Collection<Integer> out = NumberRangeSummarizerImpl.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
		System.out.println(out);
		
		String SumClooection = NumberRangeSummarizerImpl.summarizeCollection(out);
		
		System.out.println(SumClooection);

	}

}