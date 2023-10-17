package GreedyAlgorithm;
import java.util.*;

/**
 * 1. Every train will depart on the same day and the departure time will always be greater than the arrival time. For example, A train with arrival time 2240 and departure time 1930 is not possible.
 *
 * 2. Time will be given in 24H format and colons will be omitted for convenience. For example, 9:05AM will be given as "905", or 9:10PM will be given as "2110".
 *
 * 3. Also, there will be no leading zeroes in the given times. For example, 12:10AM will be given as “10” and not as “0010”.
 */
public class MinimumNumberOfPlatforms {

    public  int calculateMinPlatforms(int[] arr, int[] dep, int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;

        int max = 1;
        int platform = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                ++platform;
                ++i;
            } else {
                --platform;
                ++j;
            }
            max = Math.max(max, platform);
        }
        return max;
    }
}
