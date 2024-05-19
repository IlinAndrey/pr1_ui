package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;


public class TextNumberReplacerTest extends TestCase {

    public TextNumberReplacerTest(String testName) {
        super(testName);
    }

    public static TestSuite suite() {
        return new TestSuite(TextNumberReplacerTest.class);
    }

    public void testReplaceNumberWords_singleWord() {
        String input = "один";
        String expectedOutput = "1";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    public void testReplaceNumberWords_multipleWords() {
        String input = "сто одиннадцать тысяч фиолетовых оленей";
        String expectedOutput = "111000 фиолетовых оленей";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    public void testReplaceNumberWords_mixedContent() {
        String input = "У меня пятьсот двадцать пять яблок и тысяча триста бананов.";
        String expectedOutput = "У меня 525 яблок и 1300 бананов.";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    public void testReplaceNumberWords_largeNumbers() {
        String input = "четыреста пятьдесят тысяч шестьсот семьдесят восемь";
        String expectedOutput = "450678";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    public void testReplaceNumberWords_noNumbers() {
        String input = "Это текст без чисел.";
        String expectedOutput = "Это текст без чисел.";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }

    public void testReplaceNumberWords_complexSentence() {
        String input = "Я купил триста двадцать один апельсин, а друг купил двести сорок девять лимонов.";
        String expectedOutput = "Я купил 321 апельсин, а друг купил 249 лимонов.";
        String actualOutput = TextNumberReplacer.replaceNumberWords(input);
        assertEquals(expectedOutput, actualOutput);
    }
}
