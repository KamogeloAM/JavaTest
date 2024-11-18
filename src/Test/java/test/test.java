package test;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import main.NumberRangeSummarizer;
import main.numbers;

class NumbersTest {

    // @Override
    NumberRangeSummarizer summarizer = new numbers();

    @Test
    void testCollect_ValidInput() {
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        Collection<Integer> result = summarizer.collect(input);
        assertEquals(expected, result, "The collected numbers should match the expected list.");
    }

    @Test
    void testCollect_EmptyInput() {
        String input = "";
        Collection<Integer> result = summarizer.collect(input);
        assertTrue(result.isEmpty(), "The result should be an empty collection for empty input.");
    }

    @Test
    void testCollect_InvalidNumbersIgnored() {
        String input = "1,3,a,7,8,15,b,24";
        // Adjust test to handle invalid number formats if validation logic is added.
        Collection<Integer> expected = Arrays.asList(1, 3, 7, 8, 15, 24);
        Collection<Integer> result = summarizer.collect(input);
        assertEquals(expected, result, "The collected numbers should include valid integers only.");
    }

    @Test
    void testSummarizeCollection_ValidInput() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1, 3, 6-8, 12-15, 21-24, 31";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "The summarized output should match the expected string.");
    }

    @Test
    void testSummarizeCollection_EmptyCollection() {
        Collection<Integer> input = Arrays.asList();
        String expected = "collection is empty";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "The output should indicate that the collection is empty.");
    }

    @Test
    void testSummarizeCollection_SingleElement() {
        Collection<Integer> input = Arrays.asList(5);
        String expected = "5";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "A single element collection should return the element itself.");
    }

    @Test
    void testSummarizeCollection_AllConsecutive() {
        Collection<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        String expected = "1-5";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "All consecutive numbers should be summarized as a single range.");
    }

    @Test
    void testSummarizeCollection_AllNonConsecutive() {
        Collection<Integer> input = Arrays.asList(1, 3, 5, 7, 9);
        String expected = "1, 3, 5, 7, 9";
        String result = summarizer.summarizeCollection(input);
        assertEquals(expected, result, "All non-consecutive numbers should be listed individually.");
    }

    public NumberRangeSummarizer getSummarizer() {
        return summarizer;
    }

    public void setSummarizer(NumberRangeSummarizer summarizer) {
        this.summarizer = summarizer;
    }

}
