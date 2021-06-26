import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {

        int maximum = candyType.length / 2;
        Set<Integer> set = new HashSet<>();
        for (int n : candyType) {
            set.add(n);
        }

        return Math.min(set.size(), maximum);
    }
}
