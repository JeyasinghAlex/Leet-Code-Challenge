package InterviewBit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OccurenceOfEachNumber {

    public int[] findOccurences(int[] A) {

        int n = A.length;
        Arrays.sort(A);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        int[] ans = new int[map.size()];
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if(map.get(A[i]) != 0) {
                ans[idx++] = map.get(A[i]);
                map.put(A[i], 0);
            }

        }
        return ans;
    }
}
