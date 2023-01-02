package WeeklyContest_326_01_01_23;

public class PartitionStringIntoSubStringsWithValuesAtMost_K {

    public int minimumPartition(String s, int k) {

        int ans = 0;
        long num = 0;

        for (char ch : s.toCharArray()) {

            num = num * 10 + (ch - '0');
            if (num > k) {
                ++ans;
                num = ch - '0';
                if (num > k) {
                    return -1;
                }
            }
        }
        if (num > 0) {
            ++ans;
        }
        return ans;
    }
}
