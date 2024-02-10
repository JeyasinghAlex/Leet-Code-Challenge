package InterviewQuestions;

import java.util.*;
public class FindMidPointMinimumFuelConsumption {

    // 16,1,2,0,4,2,7,1,2,14

    /**
     * Microsoft
     */

    private int minFule(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        int start = arr[0];
        int end = arr[n - 1];
        int meetPoint = 0;

        int min = Integer.MAX_VALUE;
        int minFule = 0;
        int distance = 0;

        for (int i = start; i <= end; ++i) {
            minFule = 0;
            for (int j = 0; j < n; ++j) {
                distance = Math.abs(arr[j] - i);
                minFule += (distance * (distance + 1) / 2);
            }
            if (minFule < min) {
                min = minFule;
                meetPoint = i;
            }
        }
        return meetPoint;
    }
}
