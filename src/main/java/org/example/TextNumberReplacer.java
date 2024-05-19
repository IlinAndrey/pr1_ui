package org.example;
import java.io.*;
import java.util.*;

public class TextNumberReplacer {

    private static final Map<String, Integer> numberMap = new HashMap<>();
    private static final Set<String> largeUnits = new HashSet<>(Arrays.asList("тысяча", "тысяч", "миллион", "миллионов", "миллиард"));

    static {
        numberMap.put("ноль", 0);
        numberMap.put("один", 1);
        numberMap.put("два", 2);
        numberMap.put("три", 3);
        numberMap.put("четыре", 4);
        numberMap.put("пять", 5);
        numberMap.put("шесть", 6);
        numberMap.put("семь", 7);
        numberMap.put("восемь", 8);
        numberMap.put("девять", 9);
        numberMap.put("десять", 10);
        numberMap.put("одиннадцать", 11);
        numberMap.put("двенадцать", 12);
        numberMap.put("тринадцать", 13);
        numberMap.put("четырнадцать", 14);
        numberMap.put("пятнадцать", 15);
        numberMap.put("шестнадцать", 16);
        numberMap.put("семнадцать", 17);
        numberMap.put("восемнадцать", 18);
        numberMap.put("девятнадцать", 19);
        numberMap.put("двадцать", 20);
        numberMap.put("тридцать", 30);
        numberMap.put("сорок", 40);
        numberMap.put("пятьдесят", 50);
        numberMap.put("шестьдесят", 60);
        numberMap.put("семьдесят", 70);
        numberMap.put("восемьдесят", 80);
        numberMap.put("девяносто", 90);
        numberMap.put("сто", 100);
        numberMap.put("двести", 200);
        numberMap.put("триста", 300);
        numberMap.put("четыреста", 400);
        numberMap.put("пятьсот", 500);
        numberMap.put("шестьсот", 600);
        numberMap.put("семьсот", 700);
        numberMap.put("восемьсот", 800);
        numberMap.put("девятьсот", 900);
        numberMap.put("тысяча", 1000);
        numberMap.put("тысяч", 1000);
        numberMap.put("миллион", 1000000);
        numberMap.put("миллионов", 1000000);
        numberMap.put("миллиард", 1000000000);
    }

    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        StringBuilder inputText = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                inputText.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String outputText = replaceNumberWords(inputText.toString());

        System.out.println(outputText);
    }

    private static String replaceNumberWords(String text) {
        String[] words = text.split("\\s+");
        StringBuilder result = new StringBuilder();
        List<String> numberWords = new ArrayList<>();

        for (String word : words) {
            if (numberMap.containsKey(word.toLowerCase())) {
                numberWords.add(word.toLowerCase());
            } else {
                if (!numberWords.isEmpty()) {
                    result.append(convertWordsToNumber(numberWords)).append(" ");
                    numberWords.clear();
                }
                result.append(word).append(" ");
            }
        }
        if (!numberWords.isEmpty()) {
            result.append(convertWordsToNumber(numberWords)).append(" ");
        }

        return result.toString().trim();
    }

    private static String convertWordsToNumber(List<String> numberWords) {
        long number = 0;
        long tempNumber = 0;

        for (String word : numberWords) {
            int value = numberMap.get(word);
            if (largeUnits.contains(word)) {
                if (tempNumber == 0) {
                    tempNumber = 1;
                }
                number += tempNumber * value;
                tempNumber = 0;
            } else if (value >= 100) {
                tempNumber += value;
            } else {
                tempNumber += value;
            }
        }
        number += tempNumber;

        return String.valueOf(number);
    }
}