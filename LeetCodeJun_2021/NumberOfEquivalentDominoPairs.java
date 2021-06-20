import java.util.HashMap;
import java.util.Map;

public class NumberOfEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {

        int[] freq = new int[100];
        int count = 0;
        for (int[] arr : dominoes) {
            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);
            int temp = (min * 10) + max;
            count += freq[temp]++;
        }
        return count;
    }

    public int numEquivDominoPairs_1(int[][] dominoes) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int[] arr : dominoes) {
            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);
            int temp = (min * 10) + max;
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int count = 0;
        for (int n : map.values()) {
            count += (n * (n - 1)) / 2;
        }
        return count;
    }

    public int numEquivDominoPairs_2(int[][] dominoes) {

        int[] freq = new int[100];
        for (int[] arr : dominoes) {
            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);
            int temp = (min * 10) + max;
            freq[temp]++;
        }

        int count = 0;
        for (int i = 0; i < 100; ++i) {
            int n = freq[i];
            if (n >= 2) {
                count += (n * (n - 1)) / 2;
            }
        }
        return count;
    }
}
