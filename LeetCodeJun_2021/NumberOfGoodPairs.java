import java.util.Arrays;

public class NumberOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {

        int[] freq = new int[101];
        int count = 0;
        for(int a : nums) {
            count += freq[a]++;
        }

        return count;
    }
}
