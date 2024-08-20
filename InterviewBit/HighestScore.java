package InterviewBit;

import java.util.HashMap;
import java.util.Map;

public class HighestScore {

    public int highestScore(String[][] A) {

        Map<String, Integer> totalMark = new HashMap<>();
        Map<String, Integer> numberOfMark = new HashMap<>();
        int maxAverage = Integer.MIN_VALUE;

        for (String[] s : A) {
            String name = s[0];
            int mark = Integer.parseInt(s[1]);

            totalMark.put(name, totalMark.getOrDefault(name, 0) + mark);
            numberOfMark.put(name, numberOfMark.getOrDefault(name, 0) + 1);
        }

        for (String name : totalMark.keySet()) {
            int sumOfMark = totalMark.get(name);
            int count = numberOfMark.get(name);

            int average = sumOfMark / count;
            if (average > maxAverage) {
                maxAverage = average;
            }
        }
        return maxAverage;
    }
}
