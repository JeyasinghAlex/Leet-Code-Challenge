import java.util.Arrays;

public class TripletsWithSmallerSum {

    public int countTriplets(long arr[], int n,int sum) {

        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < n; ++i) {
            int lo = i + 1;
            int hi = n - 1;
            while (lo < hi) {
                long temp = arr[i] + arr[lo] + arr[hi];
                if (temp >= sum) {
                    --hi;
                } else {
                    count += (hi - lo);
                    ++lo;
                }
            }
        }
        return  count;
    }
}
