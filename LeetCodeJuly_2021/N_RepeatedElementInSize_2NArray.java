import java.util.HashMap;
import java.util.Map;

public class N_RepeatedElementInSize_2NArray {


    public int repeatedNTimes(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int n : map.keySet()) {

            if (map.get(n) > 1) {
                return n;
            }
        }
        return 0;
    }


    public int repeatedNTimes_1(int[] nums) {

        int[] arr = new int[10000001];
        for (int n : nums) {
            if (++arr[n] > 1) {
                return n;
            }
        }
        return 0;
    }
}