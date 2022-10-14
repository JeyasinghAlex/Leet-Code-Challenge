package WeeklyContest_310_11_09_22;

import java.util.Arrays;

public class OptimalPartitionOfString {

    public int partitionString(String s) {

        boolean[] arr = new boolean[26];
        int ans = 1;

        for (char ch : s.toCharArray()) {

            int idx = ch - 'a';

            if (!arr[idx]) {
                arr[idx] = true;
            } else {
                Arrays.fill(arr, false);
                arr[idx] = true;
                ++ans;
            }
        }
        return ans;
    }
}
