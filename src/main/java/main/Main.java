package main;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        // Input tests
        String input = "1,1,1,6,7,8,12,13,14,15,21,22,23,24,31";
        NumberRangeSummarizer Numbers = new numbers();
        Collection<Integer> collection = Numbers.collect(input);
        System.out.println("Collected: " + collection);

        String summary = Numbers.summarizeCollection(collection);
        System.out.println("Summarized: " + summary);
    }
}
