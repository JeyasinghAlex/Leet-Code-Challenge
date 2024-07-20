package InterviewBit;

import java.util.HashMap;
import java.util.Map;

public class MakeEqualElementsArray {

    public int solve(int[] A, int B) {

        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {

            int val = A[i];
            int prev = A[i] - B;
            int next = A[i] + B;

            map.put(val,  map.getOrDefault(val, 0) + 1);
            map.put(prev, map.getOrDefault(prev, 0) + 1);
            map.put(next, map.getOrDefault(next, 0) + 1);
        }

        for (int val : map.values()) {
            if (val == n)
                return 1;
        }
        return 0;
    }
}
