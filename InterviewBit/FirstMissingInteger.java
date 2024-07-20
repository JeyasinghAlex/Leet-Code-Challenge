package InterviewBit;

import java.util.HashSet;
import java.util.Set;

public class FirstMissingInteger {

    public int firstMissingPositive(int[] A) {

        Set<Integer> set = new HashSet<>();
        for (int n : A)
            set.add(n);

        for (int i = 1; i <= Integer.MAX_VALUE; ++i) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }
}
