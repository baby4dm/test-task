package com.num;

import java.io.*;
import java.util.*;

public class NumberReader {
    public static List<Integer> processFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numbers.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}


