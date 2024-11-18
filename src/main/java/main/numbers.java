package main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class numbers implements NumberRangeSummarizer {
    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> result = new ArrayList<>();
        if (!input.isEmpty()) {
            String[] parts = input.split(",");
            for (String part : parts) {
                result.add(Integer.valueOf(part.trim()));
            }
        }
        return result;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        if (input == null || input.isEmpty()) {
            return "collection is empty";
        }

        // Sorting
        List<Integer> sortedList = new ArrayList<>(input);
        Collections.sort(sortedList);

        // Build the summarized string
        StringBuilder summary = new StringBuilder();
        Integer start = null;
        Integer end = null;

        for (Integer number : sortedList) {
            if (start == null) {
                // Start a new range
                start = number;
                end = number;
            } else if (number == end + 1) {
                // Extend the current range
                end = number;
            } else {
                // Close the current range
                Range(summary, start, end);
                start = number;
                end = number;
            }
        }
        // Append the last range
        Range(summary, start, end);

        return summary.toString();
    }

    private void Range(StringBuilder summary, Integer start, Integer end) {
        if (summary.length() > 0) {
            summary.append(", ");
        }
        if (start.equals(end)) {
            summary.append(start);
        } else {
            summary.append(start).append("-").append(end);
        }
    }
}
