
package main;

import java.util.Collection;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 */
public interface NumberRangeSummarizer {
    // Collect the input
    Collection<Integer> collect(String input);

    // Get the summarized string
    String summarizeCollection(Collection<Integer> input);
}






