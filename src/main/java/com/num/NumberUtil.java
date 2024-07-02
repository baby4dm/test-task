package com.num;

import java.util.*;

public class NumberUtil {
    private NumberUtil(){}
    public static int findMax(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max().orElseThrow(RuntimeException::new);
    }

    public static int findMin(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).min().orElseThrow(RuntimeException::new);
    }

    public static double findAvg(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElseThrow(RuntimeException::new);
    }

    public static double findMedian(List<Integer> numbers){
        int size = numbers.size();
        if (size == 0) {
            return 0;
        }

        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .toList();

        if (size % 2 == 1) {
            return sortedNumbers.get(size / 2);
        } else {
            return (sortedNumbers.get((size / 2) - 1) + sortedNumbers.get(size / 2)) / 2.0;
        }
    }

    public static List<Integer> findLongestDecreasingSequence(List<Integer> numbers) {
        checkIsInputDataCorrect(numbers);

        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> longestSequence = new ArrayList<>();

        for (Integer number : numbers) {
            if (currentSequence.isEmpty() || number < currentSequence.getLast()) {
                currentSequence.add(number);
            } else {
                longestSequence = checkLongestSequence(currentSequence, longestSequence);
                currentSequence.clear();
                currentSequence.add(number);
            }
        }

        longestSequence = checkLongestSequence(currentSequence, longestSequence);

        return longestSequence;
    }

    public static List<Integer> findLongestIncreasingSequence(List<Integer> numbers) {
        checkIsInputDataCorrect(numbers);
        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> longestSequence = new ArrayList<>();

        for (Integer number : numbers) {
            if (currentSequence.isEmpty() || number > currentSequence.getLast()) {
                currentSequence.add(number);
            } else {
                longestSequence = checkLongestSequence(currentSequence, longestSequence);
                currentSequence.clear();
                currentSequence.add(number);
            }
        }

        longestSequence = checkLongestSequence(currentSequence, longestSequence);

        return longestSequence;
    }

    private static void checkIsInputDataCorrect(List<Integer> numbers){
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List must has elements");
        }
    }

    private static List<Integer> checkLongestSequence(List<Integer> currentSequence, List<Integer> longestSequence){
        if (currentSequence.size() > longestSequence.size()) {
            longestSequence = new ArrayList<>(currentSequence);
        }
        return longestSequence;
    }
}
