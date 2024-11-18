// // package main.mainPackage;
// package main;


// import java.util.ArrayList;
// import java.util.Collection;
// import java.util.Collections;
// import java.util.List;

// /**
//  * @author Werner
//  *
//  * Implement this Interface to produce a comma delimited list of numbers,
//  * grouping the numbers into a range when they are sequential.
//  *
//  *
//  * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
//  * Result: "1, 3, 6-8, 12-15, 21-24, 31"
//  *
//  * The code will be evaluated on
//  *   - functionality
//  *   - style
//  *   - robustness
//  *   - best practices
//  *   - unit tests
//  */
// public interface NumberRangeSummarizer {
//     //collect the input
//     Collection<Integer> collect(String input);
//     //get the summarized string
//     String summarizeCollection(Collection<Integer> input);
// }

// public class numbers implements NumberRangeSummarizer {
//     @Override
//     public Collection<Integer> collect(String input) {
//         Collection<Integer> result = new ArrayList<>();
//         if (!input.isEmpty()) {
//             String[] parts = input.split(",");
//             for (String part : parts) {
//                     result.add(Integer.valueOf(part.trim()));
                
//             }
//         }
//         return result;
//     }
//     @Override
//     public String summarizeCollection(Collection<Integer> input) {
//         if (input == null || input.isEmpty()) {
//             return "collection is empty";
//         }

//         //sorting
//         List<Integer> sortedList = new ArrayList<>(input);
//         Collections.sort(sortedList);

//         // Build the summarized string
//         StringBuilder summary = new StringBuilder();
//         Integer start = null;
//         Integer end = null;

//         for (Integer number : sortedList) {
//             if (start == null) {
//                 // Start a new range
//                 start = number;
//                 end = number;
//             } else if (number == end + 1) {
//                 // Extend the current range
//                 end = number;
//             } else {
//                 // Close the current range
//                 Range(summary, start, end);
//                 start = number;
//                 end = number;
//             }
//         }
//         // Append the last range
//         Range(summary, start, end);

//         return summary.toString();
//     }

//     private void Range(StringBuilder summary, Integer start, Integer end) {
//         if (summary.length() > 0) {
//             summary.append(", ");
//         }
//         if (start.equals(end)) {
//             summary.append(start);
//         } else {
//             summary.append(start).append("-").append(end);
//         }
//     }
// }

// class Main{
//     public static void main(String[] args) {        
//         // input tests
//         String input = "1,1,1,6,7,8,12,13,14,15,21,22,23,24,31";
//         NumberRangeSummarizer Numbers = new numbers();
//         Collection<Integer> collection =  Numbers.collect(input);
//         System.out.println("Collected: " + collection);

//         String summary = Numbers.summarizeCollection(collection);
//         System.out.println("Summarized: " + summary);
//     }
// }
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






