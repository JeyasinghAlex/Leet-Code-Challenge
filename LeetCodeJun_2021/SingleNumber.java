import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

//    Approach 4: Bit Manipulation
    public int singleNumber(int[] nums) {

        int res = 0;
        for (int n : nums) {
            res = res ^ n;
        }
        return res;
    }

//    Approach 3: Math
    /**
     *
     Concept
        2 * (a + b + c) - (a + a + b + b + c) = c2∗(a+b+c)−(a+a+b+b+c)=c
     */
    public int singleNumber_1(int[] nums) {

        Set<Integer> set = new HashSet<>();
        int a = 0;
        int b = 0;
        for (int n : nums) {

            if (!set.contains(n)) {
                set.add(n);
                a += n;
            }
            b += n;
        }
        return (2 * a) - b;
    }

//    Approach 2: Hash Table
    public int singleNumber_2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (int n : nums) {
            if (map.get(n) == 1) {
                return n;
            }
        }
        return -1;
    }
}
