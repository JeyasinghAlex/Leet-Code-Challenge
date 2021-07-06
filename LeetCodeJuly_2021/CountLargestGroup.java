import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {

    public int countLargestGroup(int n) {

        int[] cnt = new int[37];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; ++i) {
            int sum = digitSum(i);
            cnt[sum]++;
            max = Math.max(max, cnt[sum]);
        }

        int count = 0;
        for (int i : cnt) {
            count += i == max ? 1 : 0;
        }
        return count;
    }

    public int countLargestGroup_1(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; ++i) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (int i : map.values()) {
            max = Math.max(max, i);
        }

        int count = 0;
        for(int i : map.values()) {
            if (i == max) {
                ++count;
            }
        }
        return count;
    }

    private int digitSum(int n) {

        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
