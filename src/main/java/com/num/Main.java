package com.num;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input file path: ");
        String filePath = scanner.nextLine();

       List<Integer> numbers = NumberReader.processFile(filePath);

        long start = System.currentTimeMillis();
        System.out.println("Max value = " + NumberUtil.findMax(numbers));
        System.out.println("Min value = " + NumberUtil.findMin(numbers));
        System.out.println("Avg value = " + NumberUtil.findAvg(numbers));
        System.out.println("Median = " + NumberUtil.findMedian(numbers));
        System.out.println("Longest decrease sequence = " + NumberUtil.findLongestDecreasingSequence(numbers));
        System.out.println("Longest increase sequence = " + NumberUtil.findLongestIncreasingSequence(numbers));
        long end = System.currentTimeMillis();
        System.out.println("Wasted time = " + (end - start) + " ms");
    }
}
