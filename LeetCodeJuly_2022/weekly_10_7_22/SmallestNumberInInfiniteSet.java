package weekly_10_7_22;

import java.util.Arrays;

public class SmallestNumberInInfiniteSet {

    private final boolean[] set;
    private final int LIMIT = 1001;
    public SmallestNumberInInfiniteSet() {
        set = new boolean[LIMIT];
        Arrays.fill(set, true);
    }

    public int popSmallest() {
        for (int i = 1; i < LIMIT; ++i) {
            if (set[i]) {
                set[i] = false;
                return i;
            }
        }
        return -1;
    }

    public void addBack(int num) {
        set[num] = true;
    }
}
