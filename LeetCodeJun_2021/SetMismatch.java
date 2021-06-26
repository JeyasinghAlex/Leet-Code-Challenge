import java.util.HashSet;
import java.util.Set;

public class SetMismatch {


    public int[] findErrorNums(int[] nums) {

        int dup = 0;
        int mis = 0;
        int[] cnt = new int[nums.length + 1];
        for (int n : nums) {
            cnt[n]++;
        }

        for (int i = 1; i <= nums.length; ++i) {
            if (cnt[i] > 1) {
                dup = i;
            }
            if (cnt[i] == 0) {
                mis = i;
            }
        }
        return new int[]{dup, mis};
    }

    public int[] findErrorNums_1(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int duplicate = 0;
        int next = 0;
        for (int n : nums) {
            if (set.contains(n)) {
                duplicate = n;
            }
            set.add(n);
        }
        for (int i = 1; i <= nums.length; ++i) {
            if (!set.contains(i)) {
                next = i;
                break;
            }
        }
        return new int[]{duplicate, next};
    }
}
