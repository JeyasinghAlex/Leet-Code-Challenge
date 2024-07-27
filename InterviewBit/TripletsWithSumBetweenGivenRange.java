package InterviewBit;

import java.util.Arrays;

public class TripletsWithSumBetweenGivenRange {

    public int solve(String[] A) {

        int n = A.length;
        double[] arr = new double[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Double.parseDouble(A[i]);
        }
        Arrays.sort(arr);
        int st = 1;
        int ed = n - 1;

        while (st < ed) {
            double a = arr[st - 1];
            double b = arr[st];
            double c = arr[ed];
            double sum = a + b + c;
            if (1.0 < sum && sum < 2.0)
                return 1;
            else if (sum < 1)
                ++st;
            else
                --ed;
        }
        return 0;
    }
}
