package InterviewBit;

import java.util.HashMap;
import java.util.Map;

public class LargestPermutation {

    public int[] solve(int[] A, int B) {

        int n = A.length;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            map.put(A[i], i);
        }

        for (int i = n, j = 0; i > 0 && B > 0; --i, ++j) {

            int index = map.get(i);
            int temp  = A[j];

            if (temp >= i)
                continue;

            A[j] = i;
            A[index] = temp;

            map.put(i, j);
            map.put(temp, index);
            --B;
        }

        return A;
    }
}
