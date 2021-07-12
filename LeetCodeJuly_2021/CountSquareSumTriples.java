import java.util.HashSet;
import java.util.Set;

public class CountSquareSumTriples {

    public int countTriples(int n) {

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; ++i) {
            set.add(i * i);
        }

        int count = 0;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                int sum = (i * i) + (j * j);
                if (set.contains(sum)) {
                    ++count;
                }
            }
        }
        return count;
    }
}